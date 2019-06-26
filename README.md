[![Build Status](https://jenkins.flowingcode.com/job/IronIcons-addon/badge/icon)](https://jenkins.flowingcode.com/job/IronIcons-addon)

# Iron Icons Addon

Vaadin 10+ constants for https://github.com/PolymerElements/iron-icons

## Online demo

[Online demo here](http://addonsv10.flowingcode.com/iron-icons)

## Building and running demo

- git clone repository
- mvn clean install jetty:run

To see the demo, navigate to http://localhost:8080/

## Release notes

- **Version 1.0.0** Initial Version

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:

- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

IronIcons Addon is written by Flowing Code S.A.


# Developer Guide

## Using the icons

- Use the `create` method from the enum type, for instantiating a new `IronIcon` component based on that icon.
```
add(new Button("SAVE", IronIcons.SAVE.create()));
```

- You can also use the `getIconName` method for obtaining the qualified icon name, that can be set in the `icon` attribute of the `iron-icon` element. This can be helpful if you are writing a template renderer, such as:
```
	grid.addColumn(TemplateRenderer.<Flight>of(
	   "<iron-icon icon='IronIcons.FLIGHT_TAKEOFF.getIconName()'></iron-icon>[[item.takeoff_time]]"
	).withProperty("takeoff_time", Flight::getTakeOffTime));
```

In this latter case, you'll need to import the corresponding iconset:
```
@HtmlImport(IronIcons.URL)
```

## Code generation

For recreating the sources, you need to activate the `generate` maven profile (i.e. `mvn -Pgenerate compile`). This will download the web component sources from github, and run the code generator (`IconsetEnumGenerator`). The resulting Java enums will be written into `src/main/generated`.

In order to add support for a new iconset, perform the following steps in the base POM:

- Define a property for the iconset version:
`<iron.icons.version>2.1.1</iron.icons.version>`

- Add a dependency to the webjar:
```
    <dependency>
        <groupId>org.webjars.bowergithub.polymerelements</groupId>
        <artifactId>iron-icons</artifactId>
        <version>${iron.icons.version}</version>
    </dependency>
```

- Add a code generator execution under the `generate` profile, and configure the `codegen.repository` and `codegen.tag` arguments as appropriate.
```
    <plugin>    
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        ...
        <executions>
            <execution>
                <id>iron-icons</id>
                <phase>generate-sources</phase>
                <goals>
                    <goal>exec</goal>
                </goals>
                <configuration>
                    <arguments>
                        <argument>-Pgenerate</argument>
                        <argument>-Dcodegen.repository=PolymerElements/iron-icons</argument>
                        <argument>-Dcodegen.tag=v${iron.icons.version}</argument>
                        <argument>-Dcodegen.sources=${project.build.generatedSources}</argument>
                    </arguments>
                </configuration>
            </execution>
        </execution>
    </plugin>
```	
