package com.flowingcode.vaadin.addons.ironicons;

import com.vaadin.flow.component.icon.Icon;

/**
 * Enumeration of all icons in the av iconset (iron-icons/v2.1.1)
 * <p>
 * These instances can be used to create {@link Icon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum AvIcons {

    AIRPLAY,
    ALBUM,
    EQUALIZER,
    EXPLICIT,
    GAMES,
    HD,
    HEARING,
    LOOP,
    MIC,
    MOVIE,
    NOTE,
    PAUSE,
    QUEUE,
    RADIO,
    REPEAT,
    REPLAY,
    SHUFFLE,
    SNOOZE,
    STOP,
    SUBSCRIPTIONS,
    SUBTITLES,
    VIDEOCAM,
    WEB;

    public static final String ICONSET = "av";

    public static final String URL = "frontend://bower_components/iron-icons/av.html";

    /**
     * Return the icon name.
     * @return the icon name.
     */
    public String toString() {
        return this.name().toLowerCase().replace('_', '-');
    }

    /**
     * Creates a new {@link Icon} instance with the icon determined by the name.
     * @return a new instance of {@link Icon} component
     */
    public Icon create() {
        return new Icon(ICONSET, this.toString());
    }
}
