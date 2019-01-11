/*-
 * #%L
 * Iron Icons
 * %%
 * Copyright (C) 2019 Flowing Code
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static com.github.javaparser.ast.Modifier.Keyword.*;
import static com.github.javaparser.JavaParser.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHException;
import org.kohsuke.github.GHFileNotFoundException;
import org.kohsuke.github.GHIOException;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.TypeExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;

/**
 * @author Javier Godoy / Flowing Code
 */
public class IconsetEnumGenerator {

	private static final String PACKAGE_NAME = "com.flowingcode.vaadin.addons.ironicons";

	private static String tagName;
	
	private static String repositoryName;
	
	private static File directory;
	
	private static File target;
	
	private static BlockComment license;
	
	public static void main(String[] args) throws IOException {
		
		repositoryName = getRequiredProperty("codegen.repository"); //the name of repository to be parsed
		tagName = getRequiredProperty("codegen.tag"); //the tag in the repository to be parsed
		target = new File(getRequiredProperty("codegen.target")); //the target directory of this build
		directory = new File(getRequiredProperty("codegen.sources")); //the location of generated sources
		
		license = getLicenseInformation();
		
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
	
	private static String getRequiredProperty(String name) {
		return Optional.ofNullable(System.getProperty(name)).orElseThrow(()->new NoSuchElementException("Missing system property -D"+name));
	}
	
	private static void execute()  throws IOException {	
		GitHub github = GitHub.connect();
		GHRepository repo = github.getRepository(repositoryName);
		
		List<String> types = repo.getDirectoryContent("/", tagName).stream()
			.filter(e->/*e.getPath().endsWith("-icons.js")||*/e.getPath().endsWith("-icons.html"))
			.map(file -> {
				System.out.println("Generating constants for "+file.getName());
				String name = file.getName().replaceAll("-icons\\.\\w+$", "");
				try (InputStream in = file.read()) {
					String content = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));
					return createCompilationUnit(name, content);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}).collect(Collectors.toList());
		
		appendToTypesList(types);
		generateTypesList();
	}
	
	private static String createCompilationUnit(String cuName, String content) throws FileNotFoundException {
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
		return PACKAGE_NAME+"."+decl.getName();
	}
	
	private static void save(CompilationUnit cu) throws FileNotFoundException {
		File pkgDirectory = new File(directory, PACKAGE_NAME.replace('.', '/'));
		pkgDirectory.mkdirs();
		
		PrintStream ps = new PrintStream(new FileOutputStream(new File(pkgDirectory,cu.getType(0).getName()+".java")));
		ps.println(license);
		ps.print(cu);
		ps.close();
	}
	
	private static void appendToTypesList(List<String> types) throws FileNotFoundException {
		File file = new File(target,"typelist");
		try (PrintStream ps = new PrintStream(new FileOutputStream(file,true))) {
			types.forEach(ps::println);
		}
	}
	
	private static void generateTypesList()  throws IOException {
		CompilationUnit cu = new CompilationUnit();
		cu.setPackageDeclaration(PACKAGE_NAME);

		cu.addImport("java.util.ArrayList");
		cu.addImport("java.util.Collections");
		cu.addImport("java.util.List");

		ClassOrInterfaceDeclaration decl = cu.addClass("IronIconsTypes", ABSTRACT);

		String listType = "List<Class<? extends Enum<? extends IronIconEnum>>>";
		decl.addFieldWithInitializer(listType, "types", parseExpression("new ArrayList<>()"), PRIVATE, STATIC, FINAL);
		decl.addConstructor(PRIVATE);
		
		File file = new File(target,"typelist");
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			BlockStmt initializer = decl.addStaticInitializer();
			in.lines().forEach(type->initializer.addStatement(new MethodCallExpr("types.add", new ClassExpr(parseType(type)))));
		}

		MethodDeclaration getIconTypes = decl.addMethod("getIconTypes", PUBLIC, STATIC);
		getIconTypes.setType(listType);
		getIconTypes.getBody().get().addStatement(new ReturnStmt("Collections.unmodifiableList(types)"));
		
		save(cu);
	}

	private static BlockComment getLicenseInformation() throws IOException {
		CompilationUnit cu = JavaParser.parse(new File("TemplateLicense.java"));
		return (BlockComment)cu.getOrphanComments().get(0);
	}
}
