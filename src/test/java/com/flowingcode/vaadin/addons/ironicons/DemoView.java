package com.flowingcode.vaadin.addons.ironicons;

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

import java.util.stream.Stream;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

/**
 * @author Javier Godoy / Flowing Code
 */
@Route("")
@SuppressWarnings("serial")
@HtmlImport("frontend://styles/shared-styles.html")
public class DemoView extends Div implements IronIconsImports {
		
	{
		setSizeFull();
		getStyle().set("margin", "8px");

		getIconTypes().forEach(type -> {
			FlexLayout layout = new FlexLayout();
			layout.getStyle().set("flex-wrap", "wrap");
			add(new H4(IronIconsReflect.getIconset(type)));
			add(layout);
			
			for (IronIconEnum e : type.getEnumConstants()) {
				IronIcon icon = e.create();
				String name = ((Enum<?>)e).name().toLowerCase().replace('_', '-');
				icon.setSize("24px");
				Div div = new Div();
				div.add(icon, new Span(name));
				div.setWidth("250px");
				layout.add(div);
				layout.setFlexGrow(0, div);
			}
		});
	}	
		
	private static Stream<Class<? extends IronIconEnum>> getIconTypes() {
		return Stream.concat(
			Stream.of(IronIcons.class),
			IronIconsReflect.getIconTypes().stream().filter(e -> e!=IronIcons.class)); 
	}

}
