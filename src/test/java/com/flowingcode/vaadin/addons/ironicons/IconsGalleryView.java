/*-
 * #%L
 * Iron Icons
 * %%
 * Copyright (C) 2019 - 2020 Flowing Code
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

import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

@Uses(com.flowingcode.vaadin.addons.ironicons.AvIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.CommunicationIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.DeviceIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.EditorIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.HardwareIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.ImageIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.IronIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.MapsIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.NotificationIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.PlacesIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.SocialIcons.Icon.class)
@Uses(com.flowingcode.vaadin.addons.ironicons.FileIcons.Icon.class)
@StyleSheet("context://frontend/styles/iron-icons/demo-styles.css")
@SuppressWarnings("serial")
@PageTitle("Icons Gallery")
@DemoSource
@Route(value = "iron-icons/icons-gallery", layout = IroniconsDemoView.class)
@CssImport(value = "./styles/vaadin-button.css", themeFor = "vaadin-button")
public class IconsGalleryView extends Div {
	// this demo uses reflection, for a simple example that does not use reflection
	// see SimpleDemoView
	private static final Map<UI, String> searchString = new WeakHashMap<>();

	private final Map<String, Component> icons = new HashMap<>();
	private final List<Pair<H4, FlexLayout>> layouts = new ArrayList<>();
	private final Div noResults = new Div(new Span("Your search did not match any icons."));

	{
		TextField filter = new TextField();
		filter.setValueChangeMode(ValueChangeMode.EAGER);
		filter.setWidth("100%");
		filter.addValueChangeListener(ev -> this.applyFilter(filter.getValue()));
		filter.setPlaceholder("Search icons");
		add(filter);

		setSizeUndefined();
		addClassName("main-icon-view");

		getIconTypes().forEach(type -> {
			FlexLayout layout = new FlexLayout();
			layout.addClassName("flex");
			H4 h4 = new H4(IronIconsReflect.getIconset(type));
			add(h4, layout);
			layouts.add(Pair.of(h4, layout));

			for (IronIconEnum e : type.getEnumConstants()) {
				String name = ((Enum<?>) e).name().toLowerCase().replace('_', '-').replaceFirst("^-", "");
				Button btn = new Button(name, e.create());
				btn.setClassName("text-align-left");
				btn.addClickListener(ev -> showDetails(e));
				layout.add(btn);
				layout.setFlexGrow(0, btn);
				icons.put(e.getIconName(), btn);
			}
		});

		add(noResults);
		noResults.addClassName("no-results");
		noResults.setVisible(false);

		addAttachListener(ev -> getUI().map(searchString::get).ifPresent(filter::setValue));
	}

	private void showDetails(IronIconEnum e) {
		DemoViewSingle view = new DemoViewSingle();
		Button closeButton = new Button(IronIcons.CLOSE.create());
		closeButton.addClassName("close-button");
		HorizontalLayout top = new HorizontalLayout(closeButton);

		view.setParameter(null, e.getIconName().replace(':', '/'));
		Div div = new Div(top, view);
		div.addClassName("details-dialog");
		Dialog dlg = new Dialog(div);
		dlg.open();
		dlg.setWidth("600px");
		closeButton.addClickListener(ev -> dlg.close());
	}

	private static Stream<Class<? extends IronIconEnum>> getIconTypes() {
		return Stream.concat(Stream.of(IronIcons.class),
				IronIconsReflect.getIconTypes().stream().filter(e -> e != IronIcons.class));
	}

	private void applyFilter(String value) {
		searchString.put(getUI().get(), value);
		icons.forEach((name, icon) -> icon
				.setVisible(StringUtils.isBlank(value) || name.toLowerCase().contains(value.toLowerCase())));
		layouts.forEach(p -> p.getLeft().setVisible(p.getRight().getChildren().anyMatch(Component::isVisible)));
		noResults.setVisible(layouts.stream().noneMatch(p -> p.getLeft().isVisible()));
	}

}
