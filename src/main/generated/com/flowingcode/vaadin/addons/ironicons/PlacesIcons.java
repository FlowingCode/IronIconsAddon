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
 * Enumeration of all icons in the places iconset (iron-icons/v2.1.1)
 * <p>
 * These instances can be used to create {@link IronIcon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum PlacesIcons implements IronIconEnum {

    /**
     * The places:ac-unit icon. See <a href='URL/places/ac-unit'>example</a>.
     */
    AC_UNIT,
    /**
     * The places:airport-shuttle icon. See <a href='URL/places/airport-shuttle'>example</a>.
     */
    AIRPORT_SHUTTLE,
    /**
     * The places:all-inclusive icon. See <a href='URL/places/all-inclusive'>example</a>.
     */
    ALL_INCLUSIVE,
    /**
     * The places:beach-access icon. See <a href='URL/places/beach-access'>example</a>.
     */
    BEACH_ACCESS,
    /**
     * The places:business-center icon. See <a href='URL/places/business-center'>example</a>.
     */
    BUSINESS_CENTER,
    /**
     * The places:casino icon. See <a href='URL/places/casino'>example</a>.
     */
    CASINO,
    /**
     * The places:child-care icon. See <a href='URL/places/child-care'>example</a>.
     */
    CHILD_CARE,
    /**
     * The places:child-friendly icon. See <a href='URL/places/child-friendly'>example</a>.
     */
    CHILD_FRIENDLY,
    /**
     * The places:fitness-center icon. See <a href='URL/places/fitness-center'>example</a>.
     */
    FITNESS_CENTER,
    /**
     * The places:free-breakfast icon. See <a href='URL/places/free-breakfast'>example</a>.
     */
    FREE_BREAKFAST,
    /**
     * The places:golf-course icon. See <a href='URL/places/golf-course'>example</a>.
     */
    GOLF_COURSE,
    /**
     * The places:hot-tub icon. See <a href='URL/places/hot-tub'>example</a>.
     */
    HOT_TUB,
    /**
     * The places:kitchen icon. See <a href='URL/places/kitchen'>example</a>.
     */
    KITCHEN,
    /**
     * The places:pool icon. See <a href='URL/places/pool'>example</a>.
     */
    POOL,
    /**
     * The places:room-service icon. See <a href='URL/places/room-service'>example</a>.
     */
    ROOM_SERVICE,
    /**
     * The places:rv-hookup icon. See <a href='URL/places/rv-hookup'>example</a>.
     */
    RV_HOOKUP,
    /**
     * The places:smoke-free icon. See <a href='URL/places/smoke-free'>example</a>.
     */
    SMOKE_FREE,
    /**
     * The places:smoking-rooms icon. See <a href='URL/places/smoking-rooms'>example</a>.
     */
    SMOKING_ROOMS,
    /**
     * The places:spa icon. See <a href='URL/places/spa'>example</a>.
     */
    SPA;

    /**
     * The HTML resource that contains the places iconset
     */
    public static final String URL = "frontend://bower_components/iron-icons/places-icons.html";

    /**
     * The Iconset name, i.e. {@code "places"}."
     */
    public static final String ICONSET = "places";

    /**
     * Return the icon name.
     * @return the icon name, i.e. {@code "places:name"}..
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
