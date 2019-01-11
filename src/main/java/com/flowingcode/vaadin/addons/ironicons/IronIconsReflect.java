package com.flowingcode.vaadin.addons.ironicons;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

/**
 * Reflection utilities for {@link IronIconEnum}.
 * @author Javier Godoy / Flowing Code
 */
public abstract class IronIconsReflect {
	
	private IronIconsReflect() {}
		
	/**Return a list of all the {@code IronIconEnum} types defined in the addon.*/
	public static List<Class<? extends Enum<? extends IronIconEnum>>> getIconTypes() {
		//IronIconsTypes is generated
		return IronIconsTypes.getIconTypes();
	}
		
	/**Return the URL of the The HTML resource that contains the iconset for an {@code IronIconEnum} type.*/
	public static String getUrl(Class<? extends Enum<? extends IronIconEnum>> type) {
		return getStaticField("URL", type); 
	}
	
	/**Return the iconset name of the given {@code IronIconEnum} type.*/
	public static String getIconset(Class<? extends Enum<? extends IronIconEnum>> type) {
		return getStaticField("ICONSET", type); 
	}
	
	private static String getStaticField(String fieldName, Class<? extends Enum<? extends IronIconEnum>> type) {
		try {
			return (String) type.getField(fieldName).get(null);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new UndeclaredThrowableException(e);
		}
	}
	
}
