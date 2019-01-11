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
