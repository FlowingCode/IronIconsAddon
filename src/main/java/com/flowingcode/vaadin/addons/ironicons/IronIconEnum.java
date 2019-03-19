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
 * Common interface for all iron-icon enum types.
 * 
 * @author Javier Godoy / Flowing Code
 */
public interface IronIconEnum {

    /**
     * Return the icon name.
     * @return the icon name, i.e. {@code "iconset:name"}
     */
    String getIconName();

    /**
     * Creates a new {@link IronIcon} instance with the icon determined by the name.
     * @return a new instance of {@link IronIcon} component
     */
    IronIcon create();
}
