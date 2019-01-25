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

import com.vaadin.flow.component.icon.IronIcon;

/**
 * Enumeration of all icons in the file iconset (iron-icons/2.0.2)
 * <p>
 * These instances can be used to create {@link IronIcon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum FileIcons implements IronIconEnum {

    /**
     * The file:audio icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/audio'>example</a>
     */
    AUDIO,
    /**
     * The file:chart icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/chart'>example</a>
     */
    CHART,
    /**
     * The file:document icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/document'>example</a>
     */
    DOCUMENT,
    /**
     * The file:excel icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/excel'>example</a>
     */
    EXCEL,
    /**
     * The file:html icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/html'>example</a>
     */
    HTML,
    /**
     * The file:image icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/image'>example</a>
     */
    IMAGE,
    /**
     * The file:pdf icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/pdf'>example</a>
     */
    PDF,
    /**
     * The file:powerpoint icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/powerpoint'>example</a>
     */
    POWERPOINT,
    /**
     * The file:generic icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/generic'>example</a>
     */
    GENERIC,
    /**
     * The file:video icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/video'>example</a>
     */
    VIDEO,
    /**
     * The file:word icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/word'>example</a>
     */
    WORD,
    /**
     * The file:xml icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/xml'>example</a>
     */
    XML,
    /**
     * The file:zip icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/file/zip'>example</a>
     */
    ZIP;

    /**
     * The HTML resource that contains the file iconset
     */
    public static final String URL = "frontend://bower_components/iron-file-icons/file-icons.html";

    /**
     * The Iconset name, i.e. {@code "file"}."
     */
    public static final String ICONSET = "file";

    /**
     * Return the icon name.
     * @return the icon name, i.e. {@code "file:name"}..
     */
    public String getIconName() {
        return ICONSET+':'+getIconPart();
    }

    private String getIconPart() {
        return this.name().toLowerCase().replace('_', '-');
    }

    /**
     * Create a new {@link IronIcon} instance with the icon determined by the name.
     * @return a new instance of {@link IronIcon} component
     */
    public IronIcon create() {
        return new IronIcon(ICONSET, this.getIconPart());
    }
}
