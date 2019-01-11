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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class IronIconsTypes {

    private static final List<Class<? extends Enum<? extends IronIconEnum>>> types = new ArrayList<>();

    private IronIconsTypes() {
    }

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

    public static List<Class<? extends Enum<? extends IronIconEnum>>> getIconTypes() {
        return Collections.unmodifiableList(types);
    }
}
