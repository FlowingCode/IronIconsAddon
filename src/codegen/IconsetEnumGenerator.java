import static com.github.javaparser.ast.Modifier.Keyword.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHException;
import org.kohsuke.github.GHFileNotFoundException;
import org.kohsuke.github.GHIOException;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;

public class IconsetEnumGenerator {

	private static final String PACKAGE_NAME = "com.flowingcode.vaadin.addons.ironicons";

	private static String tagName;
	
	private static String repositoryName;
	
	private static File directory = new File("../main/java/");
	
	public static void main(String[] args) throws IOException {		
		repositoryName = args[0];
		tagName = args[1];
		System.out.println("Using "+repositoryName+" version "+tagName);
		
		System.out.println("Output directory is "+Paths.get(directory.getAbsolutePath()).normalize());
		if (!directory.exists()) {
			System.err.println("Output directory does not exist");
			System.exit(1);
		}
		
		try {
			execute();
		} catch (GHException|GHIOException|GHFileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
	private static void execute()  throws IOException {	
		GitHub github = GitHub.connect();
		GHRepository repo = github.getRepository(repositoryName);
		
		repo.getDirectoryContent("/", tagName).stream()
			.filter(e->/*e.getPath().endsWith("-icons.js")||*/e.getPath().endsWith("-icons.html"))
			.forEach(file -> {
				System.out.println("Generating constants for "+file.getName());
				String name = file.getName().replaceAll("-icons\\.\\w+$", "");
				try (InputStream in = file.read()) {
					String content = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));
					createCompilationUnit(name, content);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		});
		
		createInterface();
	}
	
	private static void createCompilationUnit(String cuName, String content) throws FileNotFoundException {
		Matcher iconsetMatcher = Pattern.compile("<iron-iconset-svg.+?name=\"(.+?)\"").matcher(content);
		if (!iconsetMatcher.find()) {
			throw new IllegalArgumentException("iron-iconset-svg not found");
		}
		String iconset = iconsetMatcher.group(1);
		
		List<String> icons = new ArrayList<>();
		Matcher matcher = Pattern.compile("<g id=\"([\\w-]+)\">").matcher(content);
		while (matcher.find()) {
			icons.add(matcher.group(1));
		}
		
		CompilationUnit cu = new CompilationUnit();
		cu.setPackageDeclaration(PACKAGE_NAME);
		cu.addImport("com.vaadin.flow.component.icon.IronIcon");
		
		EnumDeclaration decl = cu.addEnum(StringUtils.capitalize(cuName)+"Icons");
		decl.addImplementedType("IronIconEnum");
		
		decl.setJavadocComment(new JavadocComment(
			Stream.of(
				String.format("Enumeration of all icons in the %s iconset (iron-icons/%s)", iconset, tagName),
				"<p>",
				"These instances can be used to create {@link IronIcon} components either by using",
				"their {@link #create()} method or by passing them to Icon's constructor.",
				"",
				"@author Javier Godoy / Flowing Code"
			).collect(Collectors.joining("\n"))
		));
						
		for (String icon : icons) {
			String name = icon.toUpperCase().replace("-", "_");
			if (!Character.isJavaIdentifierStart(name.charAt(0)) || name.equals("ICONSET") || name.equals("URL")) {
				name = "ICON_"+name;
			}
			decl.addEnumConstant(name)
			    .setJavadocComment(new JavadocComment(String.format("The %1$s:%2$s icon. See <a href='URL/%1$s/%2$s'>example</a>.", iconset, icon)));
		}

		String componentName = repositoryName.split("/",2)[1];
		String url = "frontend://bower_components/"+componentName+"/"+cuName+"-icons.html"; 
		decl.addFieldWithInitializer("String", "URL", new StringLiteralExpr(url), PUBLIC, STATIC, FINAL)
			.setJavadocComment(new JavadocComment(String.format("The HTML resource that contains the %s iconset", iconset)));

		decl.addFieldWithInitializer("String", "ICONSET", new StringLiteralExpr(iconset), PUBLIC, STATIC, FINAL)
			.setJavadocComment(new JavadocComment(String.format("The Iconset name, i.e. {@code \"%s\"}.\"",iconset)));

		MethodDeclaration getIconName = decl.addMethod("getIconName", PUBLIC);
		getIconName.setJavadocComment(new JavadocComment(String.format("Return the icon name.\n@return the icon name, i.e. {@code \"%s:name\"}..",iconset)));
		getIconName.setType("String");
		getIconName.getBody().get().addStatement(new ReturnStmt("ICONSET+':'+getIconPart()"));

		MethodDeclaration getIconPart = decl.addMethod("getIconPart", PRIVATE);
		getIconPart.setType("String");
		getIconPart.getBody().get().addStatement(new ReturnStmt("this.name().toLowerCase().replace('_', '-')"));
				
		MethodDeclaration create = decl.addMethod("create", PUBLIC);
		create.setJavadocComment(new JavadocComment("Create a new {@link IronIcon} instance with the icon determined by the name.\n@return a new instance of {@link IronIcon} component"));
		create.setType("IronIcon");
		create.getBody().get().addStatement(new ReturnStmt("new IronIcon(ICONSET, this.getIconPart())"));

		save(cu);
	}
	
	private static void createInterface() throws FileNotFoundException {
		CompilationUnit cu = new CompilationUnit();
		cu.setPackageDeclaration(PACKAGE_NAME);
		cu.addImport("com.vaadin.flow.component.icon.IronIcon");
		
		ClassOrInterfaceDeclaration decl = cu.addInterface("IronIconEnum");
		MethodDeclaration getIconName = decl.addMethod("getIconName");
		getIconName.setJavadocComment(new JavadocComment("Return the icon name.\n@return the icon name, i.e. {@code \"iconset:name\"}"));
		getIconName.setType("String");
		getIconName.setBody(null);
		
		MethodDeclaration create = decl.addMethod("create");
		create.setJavadocComment(new JavadocComment("Creates a new {@link IronIcon} instance with the icon determined by the name.\n@return a new instance of {@link IronIcon} component"));
		create.setType("IronIcon");
		create.setBody(null);
		
		save(cu);
	}
	
	private static void save(CompilationUnit cu) throws FileNotFoundException {
		File pkgDirectory = new File(directory, PACKAGE_NAME.replace('.', '/'));
		pkgDirectory.mkdirs();
		
		PrintStream ps = new PrintStream(new FileOutputStream(new File(pkgDirectory,cu.getType(0).getName()+".java")));
		ps.print(cu);
		ps.close();
	}
}
