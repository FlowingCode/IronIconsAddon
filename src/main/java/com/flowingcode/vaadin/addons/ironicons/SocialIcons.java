package com.flowingcode.vaadin.addons.ironicons;

import com.vaadin.flow.component.icon.IronIcon;

/**
 * Enumeration of all icons in the social iconset (iron-icons/v2.1.1)
 * <p>
 * These instances can be used to create {@link IronIcon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum SocialIcons implements IronIconEnum {

    /**
     * The social:cake icon. See <a href='URL/social/cake'>example</a>.
     */
    CAKE,
    /**
     * The social:domain icon. See <a href='URL/social/domain'>example</a>.
     */
    DOMAIN,
    /**
     * The social:group icon. See <a href='URL/social/group'>example</a>.
     */
    GROUP,
    /**
     * The social:group-add icon. See <a href='URL/social/group-add'>example</a>.
     */
    GROUP_ADD,
    /**
     * The social:location-city icon. See <a href='URL/social/location-city'>example</a>.
     */
    LOCATION_CITY,
    /**
     * The social:mood icon. See <a href='URL/social/mood'>example</a>.
     */
    MOOD,
    /**
     * The social:mood-bad icon. See <a href='URL/social/mood-bad'>example</a>.
     */
    MOOD_BAD,
    /**
     * The social:notifications icon. See <a href='URL/social/notifications'>example</a>.
     */
    NOTIFICATIONS,
    /**
     * The social:notifications-active icon. See <a href='URL/social/notifications-active'>example</a>.
     */
    NOTIFICATIONS_ACTIVE,
    /**
     * The social:notifications-none icon. See <a href='URL/social/notifications-none'>example</a>.
     */
    NOTIFICATIONS_NONE,
    /**
     * The social:notifications-off icon. See <a href='URL/social/notifications-off'>example</a>.
     */
    NOTIFICATIONS_OFF,
    /**
     * The social:notifications-paused icon. See <a href='URL/social/notifications-paused'>example</a>.
     */
    NOTIFICATIONS_PAUSED,
    /**
     * The social:pages icon. See <a href='URL/social/pages'>example</a>.
     */
    PAGES,
    /**
     * The social:party-mode icon. See <a href='URL/social/party-mode'>example</a>.
     */
    PARTY_MODE,
    /**
     * The social:people icon. See <a href='URL/social/people'>example</a>.
     */
    PEOPLE,
    /**
     * The social:people-outline icon. See <a href='URL/social/people-outline'>example</a>.
     */
    PEOPLE_OUTLINE,
    /**
     * The social:person icon. See <a href='URL/social/person'>example</a>.
     */
    PERSON,
    /**
     * The social:person-add icon. See <a href='URL/social/person-add'>example</a>.
     */
    PERSON_ADD,
    /**
     * The social:person-outline icon. See <a href='URL/social/person-outline'>example</a>.
     */
    PERSON_OUTLINE,
    /**
     * The social:plus-one icon. See <a href='URL/social/plus-one'>example</a>.
     */
    PLUS_ONE,
    /**
     * The social:poll icon. See <a href='URL/social/poll'>example</a>.
     */
    POLL,
    /**
     * The social:public icon. See <a href='URL/social/public'>example</a>.
     */
    PUBLIC,
    /**
     * The social:school icon. See <a href='URL/social/school'>example</a>.
     */
    SCHOOL,
    /**
     * The social:sentiment-dissatisfied icon. See <a href='URL/social/sentiment-dissatisfied'>example</a>.
     */
    SENTIMENT_DISSATISFIED,
    /**
     * The social:sentiment-neutral icon. See <a href='URL/social/sentiment-neutral'>example</a>.
     */
    SENTIMENT_NEUTRAL,
    /**
     * The social:sentiment-satisfied icon. See <a href='URL/social/sentiment-satisfied'>example</a>.
     */
    SENTIMENT_SATISFIED,
    /**
     * The social:sentiment-very-dissatisfied icon. See <a href='URL/social/sentiment-very-dissatisfied'>example</a>.
     */
    SENTIMENT_VERY_DISSATISFIED,
    /**
     * The social:sentiment-very-satisfied icon. See <a href='URL/social/sentiment-very-satisfied'>example</a>.
     */
    SENTIMENT_VERY_SATISFIED,
    /**
     * The social:share icon. See <a href='URL/social/share'>example</a>.
     */
    SHARE,
    /**
     * The social:whatshot icon. See <a href='URL/social/whatshot'>example</a>.
     */
    WHATSHOT;

    /**
     * The HTML resource that contains the social iconset
     */
    public static final String URL = "frontend://bower_components/iron-icons/social-icons.html";

    /**
     * The Iconset name, i.e. {@code "social"}."
     */
    public static final String ICONSET = "social";

    /**
     * Return the icon name.
     * @return the icon name, i.e. {@code "social:name"}..
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
