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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
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
		addClassName("main-icon-view");

		getIconTypes().forEach(type -> {
			FlexLayout layout = new FlexLayout();
			layout.getStyle().set("flex-wrap", "wrap");
			add(new H4(IronIconsReflect.getIconset(type)));
			add(layout);
			
			for (IronIconEnum e : type.getEnumConstants()) {
				String name = ((Enum<?>)e).name().toLowerCase().replace('_', '-');
				Button btn = new Button(name, e.create());
				btn.setWidth("240px");
				btn.addClickListener(ev->getUI().get().navigate(DemoViewSingle.class, e.getIconName().replace(':', '/')));
				layout.add(btn);
				layout.setFlexGrow(0, btn);
			}
		});
	}	
		
	private static Stream<Class<? extends IronIconEnum>> getIconTypes() {
		return Stream.concat(
			Stream.of(IronIcons.class),
			IronIconsReflect.getIconTypes().stream().filter(e -> e!=IronIcons.class)); 
	}

}
