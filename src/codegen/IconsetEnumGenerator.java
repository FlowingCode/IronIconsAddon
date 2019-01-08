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
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;

public class IconsetEnumGenerator {

	private static final String PACKAGE_NAME = "com.flowingcode.vaadin.addons.ironicons";

	private static String tagName;
	
	private static File directory = new File("../main/java/");
	
	public static void main(String[] args) throws IOException {		
		tagName = args[0];
		System.out.println("Using tag "+tagName);
		
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
		GHRepository repo = github.getRepository("PolymerElements/iron-icons");
		
		repo.getDirectoryContent("/", tagName).stream()
			.filter(e->/*e.getPath().endsWith("-icons.js")||*/e.getPath().endsWith("-icons.html"))
			.forEach(file -> {
				System.out.println("Generating constants for "+file.getName());
				String iconset = file.getName().replaceAll("-icons\\.\\w+$", "");
				try (InputStream in = file.read()) {
					String content = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));
					createCompilationUnit(iconset, content);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		});
	}
	
	private static void createCompilationUnit(String iconset, String content) throws FileNotFoundException {
		CompilationUnit cu = new CompilationUnit();
		cu.setPackageDeclaration(PACKAGE_NAME);
		
		cu.addImport("com.vaadin.flow.component.icon.Icon");
		
		EnumDeclaration decl = cu.addEnum(StringUtils.capitalize(iconset)+"Icons");
				
		decl.setJavadocComment(new JavadocComment(
			Stream.of(
				String.format("Enumeration of all icons in the %s iconset (iron-icons/%s)", iconset, tagName),
				"<p>",
				"These instances can be used to create {@link Icon} components either by using",
				"their {@link #create()} method or by passing them to Icon's constructor.",
				"",
				"@author Javier Godoy / Flowing Code"
			).collect(Collectors.joining("\n"))
		));
						
		Matcher matcher = Pattern.compile("<g id=\"(\\w+)\">").matcher(content);
		while (matcher.find()) {
			String icon = matcher.group(1);
			String name = matcher.group(1).toUpperCase().replace("-", "_");
			decl.addEnumConstant(name)
			    .setJavadocComment(new JavadocComment(String.format("The %1$s:%2$s icon. See <a href='URL/%1$s/%2$s'>example</a>.", iconset, icon)));
		}

		String url = "frontend://bower_components/iron-icons/"+iconset+".html"; 
		decl.addFieldWithInitializer("String", "URL", new StringLiteralExpr(url), PUBLIC, STATIC, FINAL)
			.setJavadocComment(new JavadocComment(String.format("The HTML resource that contains the %s iconset", iconset)));

		decl.addFieldWithInitializer("String", "ICONSET", new StringLiteralExpr(iconset), PRIVATE, STATIC, FINAL);

		MethodDeclaration getIconName = decl.addMethod("getIconName", PUBLIC);
		getIconName.setJavadocComment(new JavadocComment(String.format("Return the icon name.\n@return the icon name, i.e. \"%s:name\".",iconset)));
		getIconName.setType("String");
		getIconName.getBody().get().addStatement(new ReturnStmt("ICONSET+':'+getIconPart()"));

		MethodDeclaration getIconPart = decl.addMethod("getIconPart", PRIVATE);
		getIconPart.setType("String");
		getIconPart.getBody().get().addStatement(new ReturnStmt("this.name().toLowerCase().replace('_', '-')"));
				
		MethodDeclaration create = decl.addMethod("create", PUBLIC);
		create.setJavadocComment(new JavadocComment("Creates a new {@link Icon} instance with the icon determined by the name.\n@return a new instance of {@link Icon} component"));
		create.setType("Icon");
		create.getBody().get().addStatement(new ReturnStmt("new Icon(ICONSET, this.getIconPart())"));

		File pkgDirectory = new File(directory, PACKAGE_NAME.replace('.', '/'));
		pkgDirectory.mkdirs();
		
		PrintStream ps = new PrintStream(new FileOutputStream(new File(pkgDirectory,decl.getNameAsString()+".java")));
		ps.print(cu);
		ps.close();
	}
}
