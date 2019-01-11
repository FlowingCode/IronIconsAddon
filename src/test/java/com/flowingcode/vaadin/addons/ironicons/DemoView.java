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


import static com.flowingcode.vaadin.addons.ironicons.IronIconsReflect.getIconTypes;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.router.Route;

/**
 * @author Javier Godoy / Flowing Code
 */
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
