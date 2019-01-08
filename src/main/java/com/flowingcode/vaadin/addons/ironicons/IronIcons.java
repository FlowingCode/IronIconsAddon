package com.flowingcode.vaadin.addons.ironicons;

import com.vaadin.flow.component.icon.Icon;

/**
 * Enumeration of all icons in the iron iconset (iron-icons/v2.1.1)
 * <p>
 * These instances can be used to create {@link Icon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum IronIcons {

    ACCESSIBILITY,
    ACCESSIBLE,
    ADD,
    ALARM,
    ANDROID,
    ANNOUNCEMENT,
    APPS,
    ARCHIVE,
    ASSESSMENT,
    ASSIGNMENT,
    ATTACHMENT,
    AUTORENEW,
    BACKSPACE,
    BACKUP,
    BLOCK,
    BOOK,
    BOOKMARK,
    BUILD,
    CACHED,
    CANCEL,
    CHECK,
    CLASS,
    CLEAR,
    CLOSE,
    CLOUD,
    CODE,
    COPYRIGHT,
    CREATE,
    DASHBOARD,
    DELETE,
    DESCRIPTION,
    DNS,
    DONE,
    DRAFTS,
    EJECT,
    ERROR,
    EVENT,
    EXPLORE,
    EXTENSION,
    FACE,
    FAVORITE,
    FEEDBACK,
    FINGERPRINT,
    FLAG,
    FOLDER,
    FORWARD,
    FULLSCREEN,
    GAVEL,
    GESTURE,
    GIF,
    GRADE,
    HELP,
    HISTORY,
    HOME,
    HTTP,
    HTTPS,
    INBOX,
    INFO,
    INPUT,
    LABEL,
    LANGUAGE,
    LAUNCH,
    LINK,
    LIST,
    LOCK,
    LOYALTY,
    MAIL,
    MARKUNREAD,
    MENU,
    MOTORCYCLE,
    OPACITY,
    PAGEVIEW,
    PAYMENT,
    PETS,
    POLYMER,
    PRINT,
    RECEIPT,
    REDEEM,
    REDO,
    REFRESH,
    REMOVE,
    REORDER,
    REPLY,
    REPORT,
    RESTORE,
    ROOM,
    ROWING,
    SAVE,
    SCHEDULE,
    SEARCH,
    SEND,
    SETTINGS,
    SHOP,
    SORT,
    SPELLCHECK,
    STAR,
    STARS,
    STORE,
    SUBJECT,
    TAB,
    THEATERS,
    TIMELINE,
    TOC,
    TODAY,
    TOLL,
    TRANSLATE,
    UNARCHIVE,
    UNDO,
    UPDATE,
    VISIBILITY,
    WARNING,
    WEEKEND,
    WORK;

    public static final String ICONSET = "iron";

    public static final String URL = "frontend://bower_components/iron-icons/iron.html";

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
