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
     * The file:audio icon. See <a href='URL/file/audio'>example</a>.
     */
    AUDIO,
    /**
     * The file:chart icon. See <a href='URL/file/chart'>example</a>.
     */
    CHART,
    /**
     * The file:document icon. See <a href='URL/file/document'>example</a>.
     */
    DOCUMENT,
    /**
     * The file:excel icon. See <a href='URL/file/excel'>example</a>.
     */
    EXCEL,
    /**
     * The file:html icon. See <a href='URL/file/html'>example</a>.
     */
    HTML,
    /**
     * The file:image icon. See <a href='URL/file/image'>example</a>.
     */
    IMAGE,
    /**
     * The file:pdf icon. See <a href='URL/file/pdf'>example</a>.
     */
    PDF,
    /**
     * The file:powerpoint icon. See <a href='URL/file/powerpoint'>example</a>.
     */
    POWERPOINT,
    /**
     * The file:generic icon. See <a href='URL/file/generic'>example</a>.
     */
    GENERIC,
    /**
     * The file:video icon. See <a href='URL/file/video'>example</a>.
     */
    VIDEO,
    /**
     * The file:word icon. See <a href='URL/file/word'>example</a>.
     */
    WORD,
    /**
     * The file:xml icon. See <a href='URL/file/xml'>example</a>.
     */
    XML,
    /**
     * The file:zip icon. See <a href='URL/file/zip'>example</a>.
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
