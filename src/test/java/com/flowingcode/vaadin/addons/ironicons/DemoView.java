package com.flowingcode.vaadin.addons.ironicons;

import static com.flowingcode.vaadin.addons.ironicons.IronIconsReflect.getIconTypes;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.router.Route;

@Route("")
@SuppressWarnings("serial")
public class DemoView extends Div {
		
	{
		for (Class<? extends Enum<? extends IronIconEnum>> type : getIconTypes()) {
			add(new H4(IronIconsReflect.getIconset(type)));
			for (Enum<? extends IronIconEnum> e : type.getEnumConstants()) {
				IronIconEnum icon = (IronIconEnum)e;
				add(icon.create());
			}
		}
	}	
		
	@Override
	protected void onAttach(AttachEvent attachEvent) {		
		getUI().map(UI::getPage).ifPresent(page->getIconTypes().stream().map(IronIconsReflect::getUrl).forEach(page::addHtmlImport));
	}
	
}
