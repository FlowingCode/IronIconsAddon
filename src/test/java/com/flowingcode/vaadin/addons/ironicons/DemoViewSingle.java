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
			
			html.add(new H4("HTML Example"));
			Span htmlExample = new Span(String.format("<iron-icon icon=\"%s\"></iron-icon>", icon.getIconName()));
			html.add(htmlExample);
			
			String type = icon.getClass().getSimpleName();
			String name = ((Enum<?>)icon).name();
			
			java.setWidth("400px");
			java.add(new H4("Enum constant"));
			java.add(new Span(type+"."+name));
			
			java.add(new H4("Java Example"));
			Span javaExample = new Span("add("+type+"."+name+".create());");
			java.add(javaExample);
			
			Div layout = new Div(html,java);
			layout.addClassName("main-layout");
			add(layout);
		} else {
			add(new Span("Not found"));
		}
	}
	
}
