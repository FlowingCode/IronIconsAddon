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


import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reflection utilities for {@link IronIconEnum}.
 * @author Javier Godoy / Flowing Code
 */
public abstract class IronIconsReflect {
	
	private static final List<Class<? extends IronIconEnum>> types = new ArrayList<>();
	
	private IronIconsReflect() {}
		
	static {
        types.add(com.flowingcode.vaadin.addons.ironicons.AvIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.CommunicationIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.DeviceIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.EditorIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.HardwareIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.ImageIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.IronIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.MapsIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.NotificationIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.PlacesIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.SocialIcons.class);
        types.add(com.flowingcode.vaadin.addons.ironicons.FileIcons.class);
	}

	/**Return a list of all the {@code IronIconEnum} types defined in the addon.*/
	public static List<Class<? extends IronIconEnum>> getIconTypes() {
		return Collections.unmodifiableList(types);
	}
		
	/**Return the URL of the The HTML resource that contains the iconset for an {@code IronIconEnum} type.*/
	public static String getUrl(Class<? extends IronIconEnum> type) {
		return getStaticField("URL", type); 
	}
	
	/**Return the iconset name of the given {@code IronIconEnum} type.*/
	public static String getIconset(Class<? extends IronIconEnum> type) {
		return getStaticField("ICONSET", type); 
	}
	
	private static String getStaticField(String fieldName, Class<? extends IronIconEnum> type) {
		try {
			return (String) type.getField(fieldName).get(null);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new UndeclaredThrowableException(e);
		}
	}
	
}
