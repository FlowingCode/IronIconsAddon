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
package com.flowingcode.vaadin.addons.ironicons;

import java.util.stream.Stream;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.WildcardParameter;

/**
 * @author Javier Godoy / Flowing Code
 */
@Route("view")
@SuppressWarnings("serial")
@HtmlImport("frontend://styles/shared-styles.html")
public class DemoViewSingle extends Div implements HasUrlParameter<String>  {
		
	IronIconEnum icon;
	
	@Override
	public void setParameter(BeforeEvent event, @WildcardParameter String parameter) {
		addClassName("single-icon-view");
		
		String ss[] = parameter.split("/",2);
		if (ss.length==2) {
			String iconset = ss[0];
			String iconname = iconset+":"+ss[1];
			
			this.icon = IronIconsReflect.getIconTypes().stream()
			.filter(e->IronIconsReflect.getIconset(e).equals(iconset))
			.flatMap(e->Stream.of(e.getEnumConstants()))
			.map(IronIconEnum.class::cast)
			.filter(_icon->_icon.getIconName().equals(iconname))
			.findFirst().orElse(null);
		} else {
			this.icon = null;
		}
	}
	
	@Override
	protected void onAttach(AttachEvent attachEvent) {
		if (icon!=null) {
			getUI().map(UI::getPage).ifPresent(page->page.addHtmlImport(IronIconsReflect.getUrl(icon.getClass())));
			
			H4 iconTitle = new H4("Icon");
			iconTitle.getStyle().set("margin", "1em");
			add(iconTitle);
			
			HorizontalLayout iconsLayout = new HorizontalLayout();
			iconsLayout.getStyle().set("margin", "2em");
			iconsLayout.setDefaultVerticalComponentAlignment(Alignment.END);
			iconsLayout.add(icon.create());	
			iconsLayout.add(icon.create());
			iconsLayout.add(icon.create());
			
			add(iconsLayout);
			
			VerticalLayout html = new VerticalLayout();
			VerticalLayout java = new VerticalLayout();
			
			html.setWidth("400px");
			html.add(new H4("Icon name"));
			html.add(new Span(icon.getIconName()));
			
			String url = IronIconsReflect.getUrl(icon.getClass()).replace("frontend://bower_components","..");
			html.add(new H4("HTML Example"));
			html.add(new Span(String.format("<link rel=\"import\" href=\"%s\">", url)));
			html.add(new Span(String.format("<iron-icon icon=\"%s\"></iron-icon>", icon.getIconName())));
			
			String type = icon.getClass().getSimpleName();
			String name = ((Enum<?>)icon).name();
			
			java.setWidth("400px");
			java.add(new H4("Enum constant"));
			java.add(new Span(type+"."+name));
			
			java.add(new H4("Java Example"));
			java.add(new Span(String.format("@HtmlImport(%s.URL)", type)));
			java.add(new Span(String.format("add(%s.%s.create());",type,name)));
			
			Div layout = new Div(html,java);
			layout.addClassName("main-layout");
			add(layout);
		} else {
			add(new Span("Not found"));
		}
	}
	
}
