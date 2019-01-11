package com.flowingcode.vaadin.addons.ironicons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class IronIconsTypes {
	
	private static List<Class<? extends Enum<? extends IronIconEnum> >> types = new ArrayList<>();
	
	private IronIconsTypes() {}
	static {
		types.add(AvIcons.class);
		types.add(CommunicationIcons.class);
		types.add(DeviceIcons.class);
		types.add(EditorIcons.class);
		types.add(FileIcons.class);
		types.add(HardwareIcons.class);
		types.add(ImageIcons.class);
		types.add(IronIcons.class);
		types.add(MapsIcons.class);
		types.add(NotificationIcons.class);
		types.add(PlacesIcons.class);
		types.add(SocialIcons.class);
	}
		
	public static List<Class<? extends Enum<? extends IronIconEnum>>> getIconTypes() {
		return Collections.unmodifiableList(types);
	}

}
