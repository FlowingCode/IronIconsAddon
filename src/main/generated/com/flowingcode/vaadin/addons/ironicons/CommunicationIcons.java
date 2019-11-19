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
import java.util.Locale;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * Enumeration of all icons in the communication iconset (iron-icons/v3.0.1)
 * <p>
 * These instances can be used to create {@link IronIcon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum CommunicationIcons implements IronIconEnum {

    /**
     * The communication:business icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/business'>example</a>
     */
    BUSINESS,
    /**
     * The communication:call icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call'>example</a>
     */
    CALL,
    /**
     * The communication:call-end icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call-end'>example</a>
     */
    CALL_END,
    /**
     * The communication:call-made icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call-made'>example</a>
     */
    CALL_MADE,
    /**
     * The communication:call-merge icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call-merge'>example</a>
     */
    CALL_MERGE,
    /**
     * The communication:call-missed icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call-missed'>example</a>
     */
    CALL_MISSED,
    /**
     * The communication:call-missed-outgoing icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call-missed-outgoing'>example</a>
     */
    CALL_MISSED_OUTGOING,
    /**
     * The communication:call-received icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call-received'>example</a>
     */
    CALL_RECEIVED,
    /**
     * The communication:call-split icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/call-split'>example</a>
     */
    CALL_SPLIT,
    /**
     * The communication:chat icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/chat'>example</a>
     */
    CHAT,
    /**
     * The communication:chat-bubble icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/chat-bubble'>example</a>
     */
    CHAT_BUBBLE,
    /**
     * The communication:chat-bubble-outline icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/chat-bubble-outline'>example</a>
     */
    CHAT_BUBBLE_OUTLINE,
    /**
     * The communication:clear-all icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/clear-all'>example</a>
     */
    CLEAR_ALL,
    /**
     * The communication:comment icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/comment'>example</a>
     */
    COMMENT,
    /**
     * The communication:contact-mail icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/contact-mail'>example</a>
     */
    CONTACT_MAIL,
    /**
     * The communication:contact-phone icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/contact-phone'>example</a>
     */
    CONTACT_PHONE,
    /**
     * The communication:contacts icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/contacts'>example</a>
     */
    CONTACTS,
    /**
     * The communication:dialer-sip icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/dialer-sip'>example</a>
     */
    DIALER_SIP,
    /**
     * The communication:dialpad icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/dialpad'>example</a>
     */
    DIALPAD,
    /**
     * The communication:email icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/email'>example</a>
     */
    EMAIL,
    /**
     * The communication:forum icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/forum'>example</a>
     */
    FORUM,
    /**
     * The communication:import-contacts icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/import-contacts'>example</a>
     */
    IMPORT_CONTACTS,
    /**
     * The communication:import-export icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/import-export'>example</a>
     */
    IMPORT_EXPORT,
    /**
     * The communication:invert-colors-off icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/invert-colors-off'>example</a>
     */
    INVERT_COLORS_OFF,
    /**
     * The communication:live-help icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/live-help'>example</a>
     */
    LIVE_HELP,
    /**
     * The communication:location-off icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/location-off'>example</a>
     */
    LOCATION_OFF,
    /**
     * The communication:location-on icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/location-on'>example</a>
     */
    LOCATION_ON,
    /**
     * The communication:mail-outline icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/mail-outline'>example</a>
     */
    MAIL_OUTLINE,
    /**
     * The communication:message icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/message'>example</a>
     */
    MESSAGE,
    /**
     * The communication:no-sim icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/no-sim'>example</a>
     */
    NO_SIM,
    /**
     * The communication:phone icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/phone'>example</a>
     */
    PHONE,
    /**
     * The communication:phonelink-erase icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/phonelink-erase'>example</a>
     */
    PHONELINK_ERASE,
    /**
     * The communication:phonelink-lock icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/phonelink-lock'>example</a>
     */
    PHONELINK_LOCK,
    /**
     * The communication:phonelink-ring icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/phonelink-ring'>example</a>
     */
    PHONELINK_RING,
    /**
     * The communication:phonelink-setup icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/phonelink-setup'>example</a>
     */
    PHONELINK_SETUP,
    /**
     * The communication:portable-wifi-off icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/portable-wifi-off'>example</a>
     */
    PORTABLE_WIFI_OFF,
    /**
     * The communication:present-to-all icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/present-to-all'>example</a>
     */
    PRESENT_TO_ALL,
    /**
     * The communication:ring-volume icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/ring-volume'>example</a>
     */
    RING_VOLUME,
    /**
     * The communication:rss-feed icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/rss-feed'>example</a>
     */
    RSS_FEED,
    /**
     * The communication:screen-share icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/screen-share'>example</a>
     */
    SCREEN_SHARE,
    /**
     * The communication:speaker-phone icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/speaker-phone'>example</a>
     */
    SPEAKER_PHONE,
    /**
     * The communication:stay-current-landscape icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/stay-current-landscape'>example</a>
     */
    STAY_CURRENT_LANDSCAPE,
    /**
     * The communication:stay-current-portrait icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/stay-current-portrait'>example</a>
     */
    STAY_CURRENT_PORTRAIT,
    /**
     * The communication:stay-primary-landscape icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/stay-primary-landscape'>example</a>
     */
    STAY_PRIMARY_LANDSCAPE,
    /**
     * The communication:stay-primary-portrait icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/stay-primary-portrait'>example</a>
     */
    STAY_PRIMARY_PORTRAIT,
    /**
     * The communication:stop-screen-share icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/stop-screen-share'>example</a>
     */
    STOP_SCREEN_SHARE,
    /**
     * The communication:swap-calls icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/swap-calls'>example</a>
     */
    SWAP_CALLS,
    /**
     * The communication:textsms icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/textsms'>example</a>
     */
    TEXTSMS,
    /**
     * The communication:voicemail icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/voicemail'>example</a>
     */
    VOICEMAIL,
    /**
     * The communication:vpn-key icon.See <a href='https://addonsv14.flowingcode.com/iron-icons/view/communication/vpn-key'>example</a>
     */
    VPN_KEY;

    /**
     * The Iconset name, i.e. {@code "communication"}."
     */
    public static final String ICONSET = "communication";

    /**
     * Return the icon name.
     * @return the icon name, i.e. {@code "communication:name"}..
     */
    public String getIconName() {
        return ICONSET+':'+getIconPart();
    }

    private String getIconPart() {
        return this.name().toLowerCase(Locale.ENGLISH).replace('_', '-');
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
     * Server side component for {@code CommunicationIcons}
     */
    @NpmPackage(value = "@polymer/iron-icons", version = "v3.0.1")
    @JsModule("@polymer/iron-icons/communication-icons.js")
    @SuppressWarnings("serial")
    public static final class Icon extends IronIcon implements ClickNotifier<IronIcon> {

         Icon(String icon) {
            super(ICONSET, icon);
        }
    }
}
