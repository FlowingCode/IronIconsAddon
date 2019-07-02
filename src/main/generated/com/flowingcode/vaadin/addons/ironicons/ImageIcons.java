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
 * Enumeration of all icons in the image iconset (iron-icons/v2.1.1)
 * <p>
 * These instances can be used to create {@link IronIcon} components either by using
 * their {@link #create()} method or by passing them to Icon's constructor.
 *
 * @author Javier Godoy / Flowing Code
 */
public enum ImageIcons implements IronIconEnum {

    /**
     * The image:add-a-photo icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/add-a-photo'>example</a>
     */
    ADD_A_PHOTO,
    /**
     * The image:add-to-photos icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/add-to-photos'>example</a>
     */
    ADD_TO_PHOTOS,
    /**
     * The image:adjust icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/adjust'>example</a>
     */
    ADJUST,
    /**
     * The image:assistant icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/assistant'>example</a>
     */
    ASSISTANT,
    /**
     * The image:assistant-photo icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/assistant-photo'>example</a>
     */
    ASSISTANT_PHOTO,
    /**
     * The image:audiotrack icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/audiotrack'>example</a>
     */
    AUDIOTRACK,
    /**
     * The image:blur-circular icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/blur-circular'>example</a>
     */
    BLUR_CIRCULAR,
    /**
     * The image:blur-linear icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/blur-linear'>example</a>
     */
    BLUR_LINEAR,
    /**
     * The image:blur-off icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/blur-off'>example</a>
     */
    BLUR_OFF,
    /**
     * The image:blur-on icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/blur-on'>example</a>
     */
    BLUR_ON,
    /**
     * The image:brightness-1 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brightness-1'>example</a>
     */
    BRIGHTNESS_1,
    /**
     * The image:brightness-2 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brightness-2'>example</a>
     */
    BRIGHTNESS_2,
    /**
     * The image:brightness-3 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brightness-3'>example</a>
     */
    BRIGHTNESS_3,
    /**
     * The image:brightness-4 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brightness-4'>example</a>
     */
    BRIGHTNESS_4,
    /**
     * The image:brightness-5 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brightness-5'>example</a>
     */
    BRIGHTNESS_5,
    /**
     * The image:brightness-6 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brightness-6'>example</a>
     */
    BRIGHTNESS_6,
    /**
     * The image:brightness-7 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brightness-7'>example</a>
     */
    BRIGHTNESS_7,
    /**
     * The image:broken-image icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/broken-image'>example</a>
     */
    BROKEN_IMAGE,
    /**
     * The image:brush icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/brush'>example</a>
     */
    BRUSH,
    /**
     * The image:burst-mode icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/burst-mode'>example</a>
     */
    BURST_MODE,
    /**
     * The image:camera icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/camera'>example</a>
     */
    CAMERA,
    /**
     * The image:camera-alt icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/camera-alt'>example</a>
     */
    CAMERA_ALT,
    /**
     * The image:camera-front icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/camera-front'>example</a>
     */
    CAMERA_FRONT,
    /**
     * The image:camera-rear icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/camera-rear'>example</a>
     */
    CAMERA_REAR,
    /**
     * The image:camera-roll icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/camera-roll'>example</a>
     */
    CAMERA_ROLL,
    /**
     * The image:center-focus-strong icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/center-focus-strong'>example</a>
     */
    CENTER_FOCUS_STRONG,
    /**
     * The image:center-focus-weak icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/center-focus-weak'>example</a>
     */
    CENTER_FOCUS_WEAK,
    /**
     * The image:collections icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/collections'>example</a>
     */
    COLLECTIONS,
    /**
     * The image:collections-bookmark icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/collections-bookmark'>example</a>
     */
    COLLECTIONS_BOOKMARK,
    /**
     * The image:color-lens icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/color-lens'>example</a>
     */
    COLOR_LENS,
    /**
     * The image:colorize icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/colorize'>example</a>
     */
    COLORIZE,
    /**
     * The image:compare icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/compare'>example</a>
     */
    COMPARE,
    /**
     * The image:control-point icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/control-point'>example</a>
     */
    CONTROL_POINT,
    /**
     * The image:control-point-duplicate icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/control-point-duplicate'>example</a>
     */
    CONTROL_POINT_DUPLICATE,
    /**
     * The image:crop icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop'>example</a>
     */
    CROP,
    /**
     * The image:crop-16-9 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-16-9'>example</a>
     */
    CROP_16_9,
    /**
     * The image:crop-3-2 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-3-2'>example</a>
     */
    CROP_3_2,
    /**
     * The image:crop-5-4 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-5-4'>example</a>
     */
    CROP_5_4,
    /**
     * The image:crop-7-5 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-7-5'>example</a>
     */
    CROP_7_5,
    /**
     * The image:crop-din icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-din'>example</a>
     */
    CROP_DIN,
    /**
     * The image:crop-free icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-free'>example</a>
     */
    CROP_FREE,
    /**
     * The image:crop-landscape icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-landscape'>example</a>
     */
    CROP_LANDSCAPE,
    /**
     * The image:crop-original icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-original'>example</a>
     */
    CROP_ORIGINAL,
    /**
     * The image:crop-portrait icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-portrait'>example</a>
     */
    CROP_PORTRAIT,
    /**
     * The image:crop-rotate icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-rotate'>example</a>
     */
    CROP_ROTATE,
    /**
     * The image:crop-square icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/crop-square'>example</a>
     */
    CROP_SQUARE,
    /**
     * The image:dehaze icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/dehaze'>example</a>
     */
    DEHAZE,
    /**
     * The image:details icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/details'>example</a>
     */
    DETAILS,
    /**
     * The image:edit icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/edit'>example</a>
     */
    EDIT,
    /**
     * The image:exposure icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/exposure'>example</a>
     */
    EXPOSURE,
    /**
     * The image:exposure-neg-1 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/exposure-neg-1'>example</a>
     */
    EXPOSURE_NEG_1,
    /**
     * The image:exposure-neg-2 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/exposure-neg-2'>example</a>
     */
    EXPOSURE_NEG_2,
    /**
     * The image:exposure-plus-1 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/exposure-plus-1'>example</a>
     */
    EXPOSURE_PLUS_1,
    /**
     * The image:exposure-plus-2 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/exposure-plus-2'>example</a>
     */
    EXPOSURE_PLUS_2,
    /**
     * The image:exposure-zero icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/exposure-zero'>example</a>
     */
    EXPOSURE_ZERO,
    /**
     * The image:filter icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter'>example</a>
     */
    FILTER,
    /**
     * The image:filter-1 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-1'>example</a>
     */
    FILTER_1,
    /**
     * The image:filter-2 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-2'>example</a>
     */
    FILTER_2,
    /**
     * The image:filter-3 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-3'>example</a>
     */
    FILTER_3,
    /**
     * The image:filter-4 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-4'>example</a>
     */
    FILTER_4,
    /**
     * The image:filter-5 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-5'>example</a>
     */
    FILTER_5,
    /**
     * The image:filter-6 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-6'>example</a>
     */
    FILTER_6,
    /**
     * The image:filter-7 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-7'>example</a>
     */
    FILTER_7,
    /**
     * The image:filter-8 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-8'>example</a>
     */
    FILTER_8,
    /**
     * The image:filter-9 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-9'>example</a>
     */
    FILTER_9,
    /**
     * The image:filter-9-plus icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-9-plus'>example</a>
     */
    FILTER_9_PLUS,
    /**
     * The image:filter-b-and-w icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-b-and-w'>example</a>
     */
    FILTER_B_AND_W,
    /**
     * The image:filter-center-focus icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-center-focus'>example</a>
     */
    FILTER_CENTER_FOCUS,
    /**
     * The image:filter-drama icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-drama'>example</a>
     */
    FILTER_DRAMA,
    /**
     * The image:filter-frames icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-frames'>example</a>
     */
    FILTER_FRAMES,
    /**
     * The image:filter-hdr icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-hdr'>example</a>
     */
    FILTER_HDR,
    /**
     * The image:filter-none icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-none'>example</a>
     */
    FILTER_NONE,
    /**
     * The image:filter-tilt-shift icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-tilt-shift'>example</a>
     */
    FILTER_TILT_SHIFT,
    /**
     * The image:filter-vintage icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/filter-vintage'>example</a>
     */
    FILTER_VINTAGE,
    /**
     * The image:flare icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/flare'>example</a>
     */
    FLARE,
    /**
     * The image:flash-auto icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/flash-auto'>example</a>
     */
    FLASH_AUTO,
    /**
     * The image:flash-off icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/flash-off'>example</a>
     */
    FLASH_OFF,
    /**
     * The image:flash-on icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/flash-on'>example</a>
     */
    FLASH_ON,
    /**
     * The image:flip icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/flip'>example</a>
     */
    FLIP,
    /**
     * The image:gradient icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/gradient'>example</a>
     */
    GRADIENT,
    /**
     * The image:grain icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/grain'>example</a>
     */
    GRAIN,
    /**
     * The image:grid-off icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/grid-off'>example</a>
     */
    GRID_OFF,
    /**
     * The image:grid-on icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/grid-on'>example</a>
     */
    GRID_ON,
    /**
     * The image:hdr-off icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/hdr-off'>example</a>
     */
    HDR_OFF,
    /**
     * The image:hdr-on icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/hdr-on'>example</a>
     */
    HDR_ON,
    /**
     * The image:hdr-strong icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/hdr-strong'>example</a>
     */
    HDR_STRONG,
    /**
     * The image:hdr-weak icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/hdr-weak'>example</a>
     */
    HDR_WEAK,
    /**
     * The image:healing icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/healing'>example</a>
     */
    HEALING,
    /**
     * The image:image icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/image'>example</a>
     */
    IMAGE,
    /**
     * The image:image-aspect-ratio icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/image-aspect-ratio'>example</a>
     */
    IMAGE_ASPECT_RATIO,
    /**
     * The image:iso icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/iso'>example</a>
     */
    ISO,
    /**
     * The image:landscape icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/landscape'>example</a>
     */
    LANDSCAPE,
    /**
     * The image:leak-add icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/leak-add'>example</a>
     */
    LEAK_ADD,
    /**
     * The image:leak-remove icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/leak-remove'>example</a>
     */
    LEAK_REMOVE,
    /**
     * The image:lens icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/lens'>example</a>
     */
    LENS,
    /**
     * The image:linked-camera icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/linked-camera'>example</a>
     */
    LINKED_CAMERA,
    /**
     * The image:looks icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/looks'>example</a>
     */
    LOOKS,
    /**
     * The image:looks-3 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/looks-3'>example</a>
     */
    LOOKS_3,
    /**
     * The image:looks-4 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/looks-4'>example</a>
     */
    LOOKS_4,
    /**
     * The image:looks-5 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/looks-5'>example</a>
     */
    LOOKS_5,
    /**
     * The image:looks-6 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/looks-6'>example</a>
     */
    LOOKS_6,
    /**
     * The image:looks-one icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/looks-one'>example</a>
     */
    LOOKS_ONE,
    /**
     * The image:looks-two icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/looks-two'>example</a>
     */
    LOOKS_TWO,
    /**
     * The image:loupe icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/loupe'>example</a>
     */
    LOUPE,
    /**
     * The image:monochrome-photos icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/monochrome-photos'>example</a>
     */
    MONOCHROME_PHOTOS,
    /**
     * The image:movie-creation icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/movie-creation'>example</a>
     */
    MOVIE_CREATION,
    /**
     * The image:movie-filter icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/movie-filter'>example</a>
     */
    MOVIE_FILTER,
    /**
     * The image:music-note icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/music-note'>example</a>
     */
    MUSIC_NOTE,
    /**
     * The image:nature icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/nature'>example</a>
     */
    NATURE,
    /**
     * The image:nature-people icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/nature-people'>example</a>
     */
    NATURE_PEOPLE,
    /**
     * The image:navigate-before icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/navigate-before'>example</a>
     */
    NAVIGATE_BEFORE,
    /**
     * The image:navigate-next icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/navigate-next'>example</a>
     */
    NAVIGATE_NEXT,
    /**
     * The image:palette icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/palette'>example</a>
     */
    PALETTE,
    /**
     * The image:panorama icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/panorama'>example</a>
     */
    PANORAMA,
    /**
     * The image:panorama-fish-eye icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/panorama-fish-eye'>example</a>
     */
    PANORAMA_FISH_EYE,
    /**
     * The image:panorama-horizontal icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/panorama-horizontal'>example</a>
     */
    PANORAMA_HORIZONTAL,
    /**
     * The image:panorama-vertical icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/panorama-vertical'>example</a>
     */
    PANORAMA_VERTICAL,
    /**
     * The image:panorama-wide-angle icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/panorama-wide-angle'>example</a>
     */
    PANORAMA_WIDE_ANGLE,
    /**
     * The image:photo icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo'>example</a>
     */
    PHOTO,
    /**
     * The image:photo-album icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo-album'>example</a>
     */
    PHOTO_ALBUM,
    /**
     * The image:photo-camera icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo-camera'>example</a>
     */
    PHOTO_CAMERA,
    /**
     * The image:photo-filter icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo-filter'>example</a>
     */
    PHOTO_FILTER,
    /**
     * The image:photo-library icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo-library'>example</a>
     */
    PHOTO_LIBRARY,
    /**
     * The image:photo-size-select-actual icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo-size-select-actual'>example</a>
     */
    PHOTO_SIZE_SELECT_ACTUAL,
    /**
     * The image:photo-size-select-large icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo-size-select-large'>example</a>
     */
    PHOTO_SIZE_SELECT_LARGE,
    /**
     * The image:photo-size-select-small icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/photo-size-select-small'>example</a>
     */
    PHOTO_SIZE_SELECT_SMALL,
    /**
     * The image:picture-as-pdf icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/picture-as-pdf'>example</a>
     */
    PICTURE_AS_PDF,
    /**
     * The image:portrait icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/portrait'>example</a>
     */
    PORTRAIT,
    /**
     * The image:remove-red-eye icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/remove-red-eye'>example</a>
     */
    REMOVE_RED_EYE,
    /**
     * The image:rotate-90-degrees-ccw icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/rotate-90-degrees-ccw'>example</a>
     */
    ROTATE_90_DEGREES_CCW,
    /**
     * The image:rotate-left icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/rotate-left'>example</a>
     */
    ROTATE_LEFT,
    /**
     * The image:rotate-right icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/rotate-right'>example</a>
     */
    ROTATE_RIGHT,
    /**
     * The image:slideshow icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/slideshow'>example</a>
     */
    SLIDESHOW,
    /**
     * The image:straighten icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/straighten'>example</a>
     */
    STRAIGHTEN,
    /**
     * The image:style icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/style'>example</a>
     */
    STYLE,
    /**
     * The image:switch-camera icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/switch-camera'>example</a>
     */
    SWITCH_CAMERA,
    /**
     * The image:switch-video icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/switch-video'>example</a>
     */
    SWITCH_VIDEO,
    /**
     * The image:tag-faces icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/tag-faces'>example</a>
     */
    TAG_FACES,
    /**
     * The image:texture icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/texture'>example</a>
     */
    TEXTURE,
    /**
     * The image:timelapse icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/timelapse'>example</a>
     */
    TIMELAPSE,
    /**
     * The image:timer icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/timer'>example</a>
     */
    TIMER,
    /**
     * The image:timer-10 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/timer-10'>example</a>
     */
    TIMER_10,
    /**
     * The image:timer-3 icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/timer-3'>example</a>
     */
    TIMER_3,
    /**
     * The image:timer-off icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/timer-off'>example</a>
     */
    TIMER_OFF,
    /**
     * The image:tonality icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/tonality'>example</a>
     */
    TONALITY,
    /**
     * The image:transform icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/transform'>example</a>
     */
    TRANSFORM,
    /**
     * The image:tune icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/tune'>example</a>
     */
    TUNE,
    /**
     * The image:view-comfy icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/view-comfy'>example</a>
     */
    VIEW_COMFY,
    /**
     * The image:view-compact icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/view-compact'>example</a>
     */
    VIEW_COMPACT,
    /**
     * The image:vignette icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/vignette'>example</a>
     */
    VIGNETTE,
    /**
     * The image:wb-auto icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/wb-auto'>example</a>
     */
    WB_AUTO,
    /**
     * The image:wb-cloudy icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/wb-cloudy'>example</a>
     */
    WB_CLOUDY,
    /**
     * The image:wb-incandescent icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/wb-incandescent'>example</a>
     */
    WB_INCANDESCENT,
    /**
     * The image:wb-iridescent icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/wb-iridescent'>example</a>
     */
    WB_IRIDESCENT,
    /**
     * The image:wb-sunny icon.See <a href='https://addonsv10.flowingcode.com/iron-icons/view/image/wb-sunny'>example</a>
     */
    WB_SUNNY;

    /**
     * The HTML resource that contains the image iconset
     */
    public static final String URL = "frontend://bower_components/iron-icons/image-icons.html";

    /**
     * The Iconset name, i.e. {@code "image"}."
     */
    public static final String ICONSET = "image";

    /**
     * Return the icon name.
     * @return the icon name, i.e. {@code "image:name"}..
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
     * Server side component for {@code ImageIcons}
     */
    @HtmlImport(ImageIcons.URL)
    @SuppressWarnings("serial")
    public final static class Icon extends IronIcon implements ClickNotifier<IronIcon> {

         Icon(String icon) {
            super(ICONSET, icon);
        }
    }
}
