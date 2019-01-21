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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

/**
 * @author Javier Godoy / Flowing Code
 */
@Route("")
@SuppressWarnings("serial")
@HtmlImport("frontend://styles/shared-styles.html")
public class DemoView extends Div implements IronIconsImports {
	
	private static final Map<UI, String> searchString = new WeakHashMap<>();
	
	private final Map<String, Component> icons = new HashMap<>();
	private final List<Pair<H4, FlexLayout>> layouts = new ArrayList<>();
	private final Div noResults = new Div(new Span("Your search did not match any icons."));
			
	{
		TextField filter = new TextField();
		filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.setWidth("100%");
        filter.addValueChangeListener(ev->this.applyFilter(filter.getValue()));
        filter.setPlaceholder("Search icons");
        add(filter);
        
        setSizeUndefined();
		addClassName("main-icon-view");
		
		getIconTypes().forEach(type -> {
			FlexLayout layout = new FlexLayout();
			layout.addClassName("flex");
			H4 h4 = new H4(IronIconsReflect.getIconset(type));
			add(h4, layout);
			layouts.add(Pair.of(h4,layout));
			
			for (IronIconEnum e : type.getEnumConstants()) {
				String name = ((Enum<?>)e).name().toLowerCase().replace('_', '-').replaceFirst("^-", "");				
				Button btn = new Button(name, e.create());
				btn.addClickListener(ev->showDetails(e));
				layout.add(btn);
				layout.setFlexGrow(0, btn);
				icons.put(e.getIconName(), btn);
			}
		});
		
		add(noResults);
		noResults.addClassName("no-results");
		noResults.setVisible(false);
		
		addAttachListener(ev->getUI().map(searchString::get).ifPresent(filter::setValue));
	}
	
	private void showDetails(IronIconEnum e) {
		DemoViewSingle view = new DemoViewSingle();
		Button close = new Button(IronIcons.CLOSE.create());
		close.addClassName("close-button");
		view.setParameter(null, e.getIconName().replace(':', '/'));
		Dialog dlg = new Dialog(close, view);
		dlg.open();
		close.addClickListener(ev->dlg.close());
	}
	
	private static Stream<Class<? extends IronIconEnum>> getIconTypes() {
		return Stream.concat(
			Stream.of(IronIcons.class),
			IronIconsReflect.getIconTypes().stream().filter(e -> e!=IronIcons.class)); 
	}

	private void applyFilter(String value) {
		searchString.put(getUI().get(), value);
		icons.forEach((name,icon)->icon.setVisible(StringUtils.isBlank(value) || name.contains(value)));
		layouts.forEach(p->p.getLeft().setVisible(p.getRight().getChildren().anyMatch(Component::isVisible)));
		noResults.setVisible(layouts.stream().noneMatch(p->p.getLeft().isVisible()));
	}

}
