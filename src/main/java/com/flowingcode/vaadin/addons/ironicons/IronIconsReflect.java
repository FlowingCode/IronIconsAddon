package com.flowingcode.vaadin.addons.ironicons;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

public abstract class IronIconsReflect {
	
	private IronIconsReflect() {}
		
	public static List<Class<? extends Enum<? extends IronIconEnum>>> getIconTypes() {
		//IronIconsTypes is generated
		return IronIconsTypes.getIconTypes();
	}
		
	public static String getUrl(Class<? extends Enum<? extends IronIconEnum>> type) {
		return getStaticField("URL", type); 
	}
	
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
