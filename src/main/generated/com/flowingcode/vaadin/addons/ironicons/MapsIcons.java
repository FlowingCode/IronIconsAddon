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
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.ClickNotifier;

/**
 * Enumeration of all icons in the maps iconset (iron-icons/v2.1.1)
 * <p>
 * These instances can be used to create {@link IronIcon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum MapsIcons implements IronIconEnum {

    /**
     * The maps:add-location icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/add-location'>example</a>
     */
    ADD_LOCATION,
    /**
     * The maps:beenhere icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/beenhere'>example</a>
     */
    BEENHERE,
    /**
     * The maps:directions icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions'>example</a>
     */
    DIRECTIONS,
    /**
     * The maps:directions-bike icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-bike'>example</a>
     */
    DIRECTIONS_BIKE,
    /**
     * The maps:directions-boat icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-boat'>example</a>
     */
    DIRECTIONS_BOAT,
    /**
     * The maps:directions-bus icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-bus'>example</a>
     */
    DIRECTIONS_BUS,
    /**
     * The maps:directions-car icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-car'>example</a>
     */
    DIRECTIONS_CAR,
    /**
     * The maps:directions-railway icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-railway'>example</a>
     */
    DIRECTIONS_RAILWAY,
    /**
     * The maps:directions-run icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-run'>example</a>
     */
    DIRECTIONS_RUN,
    /**
     * The maps:directions-subway icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-subway'>example</a>
     */
    DIRECTIONS_SUBWAY,
    /**
     * The maps:directions-transit icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-transit'>example</a>
     */
    DIRECTIONS_TRANSIT,
    /**
     * The maps:directions-walk icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/directions-walk'>example</a>
     */
    DIRECTIONS_WALK,
    /**
     * The maps:edit-location icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/edit-location'>example</a>
     */
    EDIT_LOCATION,
    /**
     * The maps:ev-station icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/ev-station'>example</a>
     */
    EV_STATION,
    /**
     * The maps:flight icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/flight'>example</a>
     */
    FLIGHT,
    /**
     * The maps:hotel icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/hotel'>example</a>
     */
    HOTEL,
    /**
     * The maps:layers icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/layers'>example</a>
     */
    LAYERS,
    /**
     * The maps:layers-clear icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/layers-clear'>example</a>
     */
    LAYERS_CLEAR,
    /**
     * The maps:local-activity icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-activity'>example</a>
     */
    LOCAL_ACTIVITY,
    /**
     * The maps:local-airport icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-airport'>example</a>
     */
    LOCAL_AIRPORT,
    /**
     * The maps:local-atm icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-atm'>example</a>
     */
    LOCAL_ATM,
    /**
     * The maps:local-bar icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-bar'>example</a>
     */
    LOCAL_BAR,
    /**
     * The maps:local-cafe icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-cafe'>example</a>
     */
    LOCAL_CAFE,
    /**
     * The maps:local-car-wash icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-car-wash'>example</a>
     */
    LOCAL_CAR_WASH,
    /**
     * The maps:local-convenience-store icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-convenience-store'>example</a>
     */
    LOCAL_CONVENIENCE_STORE,
    /**
     * The maps:local-dining icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-dining'>example</a>
     */
    LOCAL_DINING,
    /**
     * The maps:local-drink icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-drink'>example</a>
     */
    LOCAL_DRINK,
    /**
     * The maps:local-florist icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-florist'>example</a>
     */
    LOCAL_FLORIST,
    /**
     * The maps:local-gas-station icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-gas-station'>example</a>
     */
    LOCAL_GAS_STATION,
    /**
     * The maps:local-grocery-store icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-grocery-store'>example</a>
     */
    LOCAL_GROCERY_STORE,
    /**
     * The maps:local-hospital icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-hospital'>example</a>
     */
    LOCAL_HOSPITAL,
    /**
     * The maps:local-hotel icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-hotel'>example</a>
     */
    LOCAL_HOTEL,
    /**
     * The maps:local-laundry-service icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-laundry-service'>example</a>
     */
    LOCAL_LAUNDRY_SERVICE,
    /**
     * The maps:local-library icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-library'>example</a>
     */
    LOCAL_LIBRARY,
    /**
     * The maps:local-mall icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-mall'>example</a>
     */
    LOCAL_MALL,
    /**
     * The maps:local-movies icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-movies'>example</a>
     */
    LOCAL_MOVIES,
    /**
     * The maps:local-offer icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-offer'>example</a>
     */
    LOCAL_OFFER,
    /**
     * The maps:local-parking icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-parking'>example</a>
     */
    LOCAL_PARKING,
    /**
     * The maps:local-pharmacy icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-pharmacy'>example</a>
     */
    LOCAL_PHARMACY,
    /**
     * The maps:local-phone icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-phone'>example</a>
     */
    LOCAL_PHONE,
    /**
     * The maps:local-pizza icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-pizza'>example</a>
     */
    LOCAL_PIZZA,
    /**
     * The maps:local-play icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-play'>example</a>
     */
    LOCAL_PLAY,
    /**
     * The maps:local-post-office icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-post-office'>example</a>
     */
    LOCAL_POST_OFFICE,
    /**
     * The maps:local-printshop icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-printshop'>example</a>
     */
    LOCAL_PRINTSHOP,
    /**
     * The maps:local-see icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-see'>example</a>
     */
    LOCAL_SEE,
    /**
     * The maps:local-shipping icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-shipping'>example</a>
     */
    LOCAL_SHIPPING,
    /**
     * The maps:local-taxi icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/local-taxi'>example</a>
     */
    LOCAL_TAXI,
    /**
     * The maps:map icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/map'>example</a>
     */
    MAP,
    /**
     * The maps:my-location icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/my-location'>example</a>
     */
    MY_LOCATION,
    /**
     * The maps:navigation icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/navigation'>example</a>
     */
    NAVIGATION,
    /**
     * The maps:near-me icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/near-me'>example</a>
     */
    NEAR_ME,
    /**
     * The maps:person-pin icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/person-pin'>example</a>
     */
    PERSON_PIN,
    /**
     * The maps:person-pin-circle icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/person-pin-circle'>example</a>
     */
    PERSON_PIN_CIRCLE,
    /**
     * The maps:pin-drop icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/pin-drop'>example</a>
     */
    PIN_DROP,
    /**
     * The maps:place icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/place'>example</a>
     */
    PLACE,
    /**
     * The maps:rate-review icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/rate-review'>example</a>
     */
    RATE_REVIEW,
    /**
     * The maps:restaurant icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/restaurant'>example</a>
     */
    RESTAURANT,
    /**
     * The maps:restaurant-menu icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/restaurant-menu'>example</a>
     */
    RESTAURANT_MENU,
    /**
     * The maps:satellite icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/satellite'>example</a>
     */
    SATELLITE,
    /**
     * The maps:store-mall-directory icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/store-mall-directory'>example</a>
     */
    STORE_MALL_DIRECTORY,
    /**
     * The maps:streetview icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/streetview'>example</a>
     */
    STREETVIEW,
    /**
     * The maps:subway icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/subway'>example</a>
     */
    SUBWAY,
    /**
     * The maps:terrain icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/terrain'>example</a>
     */
    TERRAIN,
    /**
     * The maps:traffic icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/traffic'>example</a>
     */
    TRAFFIC,
    /**
     * The maps:train icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/train'>example</a>
     */
    TRAIN,
    /**
     * The maps:tram icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/tram'>example</a>
     */
    TRAM,
    /**
     * The maps:transfer-within-a-station icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/transfer-within-a-station'>example</a>
     */
    TRANSFER_WITHIN_A_STATION,
    /**
     * The maps:zoom-out-map icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/maps/zoom-out-map'>example</a>
     */
    ZOOM_OUT_MAP;

    /**
     * The HTML resource that contains the maps iconset
     */
    public static final String URL = "frontend://bower_components/iron-icons/maps-icons.html";

    /**
     * The Iconset name, i.e. {@code "maps"}."
     */
    public static final String ICONSET = "maps";

    /**
     * Return the icon name.
     * @return the icon name, i.e. {@code "maps:name"}..
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
    public Icon create() {
        return new Icon(this.getIconPart());
    }

    /**
     * Create a new {@link IronIcon} instance with the icon determined by the name and a listener for click events.
     * @param listener the event listener for click events
     * @return a new instance of {@link IronIcon} component
     */
    public Icon create(ComponentEventListener<ClickEvent<IronIcon>> listener) {
        Icon icon = create();
        icon.addClickListener(listener);
        return icon;
    }

    /**
     * Server side component for {@code MapsIcons}
     */
    @HtmlImport(MapsIcons.URL)
    @SuppressWarnings("serial")
    public final static class Icon extends IronIcon implements ClickNotifier<IronIcon> {

         Icon(String icon) {
            super(ICONSET, icon);
        }
    }
}
