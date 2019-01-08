package com.flowingcode.vaadin.addons.ironicons;

import com.vaadin.flow.component.icon.Icon;

/**
 * Enumeration of all icons in the image iconset (iron-icons/v2.1.1)
 * <p>
 * These instances can be used to create {@link Icon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum ImageIcons {

    ADJUST,
    ASSISTANT,
    AUDIOTRACK,
    BRUSH,
    CAMERA,
    COLLECTIONS,
    COLORIZE,
    COMPARE,
    CROP,
    DEHAZE,
    DETAILS,
    EDIT,
    EXPOSURE,
    FILTER,
    FLARE,
    FLIP,
    GRADIENT,
    GRAIN,
    HEALING,
    IMAGE,
    ISO,
    LANDSCAPE,
    LENS,
    LOOKS,
    LOUPE,
    NATURE,
    PALETTE,
    PANORAMA,
    PHOTO,
    PORTRAIT,
    SLIDESHOW,
    STRAIGHTEN,
    STYLE,
    TEXTURE,
    TIMELAPSE,
    TIMER,
    TONALITY,
    TRANSFORM,
    TUNE,
    VIGNETTE;

    public static final String ICONSET = "image";

    public static final String URL = "frontend://bower_components/iron-icons/image.html";

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
