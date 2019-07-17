(ns jdk.awt.SystemColor
  "A class to encapsulate symbolic colors representing the color of
  native GUI objects on a system.  For systems which support the dynamic
  update of the system colors (when the user changes the colors)
  the actual RGB values of these symbolic colors will also change
  dynamically.  In order to compare the `current` RGB value of a
  SystemColor object with a non-symbolic Color object,
  getRGB should be used rather than equals.

  Note that the way in which these system colors are applied to GUI objects
  may vary slightly from platform to platform since GUI objects may be
  rendered differently on each platform.

  System color values may also be available through the getDesktopProperty
  method on java.awt.Toolkit."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt SystemColor]))

(def *-desktop
  "Static Constant.

  The array index for the
   desktop system color.

  type: java.lang.annotation.    int"
  SystemColor/DESKTOP)

(def *-active-caption
  "Static Constant.

  The array index for the
   activeCaption system color.

  type: java.lang.annotation.    int"
  SystemColor/ACTIVE_CAPTION)

(def *-active-caption-text
  "Static Constant.

  The array index for the
   activeCaptionText system color.

  type: java.lang.annotation.    int"
  SystemColor/ACTIVE_CAPTION_TEXT)

(def *-active-caption-border
  "Static Constant.

  The array index for the
   activeCaptionBorder system color.

  type: java.lang.annotation.    int"
  SystemColor/ACTIVE_CAPTION_BORDER)

(def *-inactive-caption
  "Static Constant.

  The array index for the
   inactiveCaption system color.

  type: java.lang.annotation.    int"
  SystemColor/INACTIVE_CAPTION)

(def *-inactive-caption-text
  "Static Constant.

  The array index for the
   inactiveCaptionText system color.

  type: java.lang.annotation.    int"
  SystemColor/INACTIVE_CAPTION_TEXT)

(def *-inactive-caption-border
  "Static Constant.

  The array index for the
   inactiveCaptionBorder system color.

  type: java.lang.annotation.    int"
  SystemColor/INACTIVE_CAPTION_BORDER)

(def *-window
  "Static Constant.

  The array index for the
   window system color.

  type: java.lang.annotation.    int"
  SystemColor/WINDOW)

(def *-window-border
  "Static Constant.

  The array index for the
   windowBorder system color.

  type: java.lang.annotation.    int"
  SystemColor/WINDOW_BORDER)

(def *-window-text
  "Static Constant.

  The array index for the
   windowText system color.

  type: java.lang.annotation.    int"
  SystemColor/WINDOW_TEXT)

(def *-menu
  "Static Constant.

  The array index for the
   menu system color.

  type: java.lang.annotation.    int"
  SystemColor/MENU)

(def *-menu-text
  "Static Constant.

  The array index for the
   menuText system color.

  type: java.lang.annotation.    int"
  SystemColor/MENU_TEXT)

(def *-text
  "Static Constant.

  The array index for the
   text system color.

  type: java.lang.annotation.    int"
  SystemColor/TEXT)

(def *-text-text
  "Static Constant.

  The array index for the
   textText system color.

  type: java.lang.annotation.    int"
  SystemColor/TEXT_TEXT)

(def *-text-highlight
  "Static Constant.

  The array index for the
   textHighlight system color.

  type: java.lang.annotation.    int"
  SystemColor/TEXT_HIGHLIGHT)

(def *-text-highlight-text
  "Static Constant.

  The array index for the
   textHighlightText system color.

  type: java.lang.annotation.    int"
  SystemColor/TEXT_HIGHLIGHT_TEXT)

(def *-text-inactive-text
  "Static Constant.

  The array index for the
   textInactiveText system color.

  type: java.lang.annotation.    int"
  SystemColor/TEXT_INACTIVE_TEXT)

(def *-control
  "Static Constant.

  The array index for the
   control system color.

  type: java.lang.annotation.    int"
  SystemColor/CONTROL)

(def *-control-text
  "Static Constant.

  The array index for the
   controlText system color.

  type: java.lang.annotation.    int"
  SystemColor/CONTROL_TEXT)

(def *-control-highlight
  "Static Constant.

  The array index for the
   controlHighlight system color.

  type: java.lang.annotation.    int"
  SystemColor/CONTROL_HIGHLIGHT)

(def *-control-lt-highlight
  "Static Constant.

  The array index for the
   controlLtHighlight system color.

  type: java.lang.annotation.    int"
  SystemColor/CONTROL_LT_HIGHLIGHT)

(def *-control-shadow
  "Static Constant.

  The array index for the
   controlShadow system color.

  type: java.lang.annotation.    int"
  SystemColor/CONTROL_SHADOW)

(def *-control-dk-shadow
  "Static Constant.

  The array index for the
   controlDkShadow system color.

  type: java.lang.annotation.    int"
  SystemColor/CONTROL_DK_SHADOW)

(def *-scrollbar
  "Static Constant.

  The array index for the
   scrollbar system color.

  type: java.lang.annotation.    int"
  SystemColor/SCROLLBAR)

(def *-info
  "Static Constant.

  The array index for the
   info system color.

  type: java.lang.annotation.    int"
  SystemColor/INFO)

(def *-info-text
  "Static Constant.

  The array index for the
   infoText system color.

  type: java.lang.annotation.    int"
  SystemColor/INFO_TEXT)

(def *-num-colors
  "Static Constant.

  The number of system colors in the array.

  type: java.lang.annotation.    int"
  SystemColor/NUM_COLORS)

(def *-desktop
  "Static Constant.

  The color rendered for the background of the desktop.

  type: java.awt.SystemColor"
  SystemColor/desktop)

(def *-active-caption
  "Static Constant.

  The color rendered for the window-title background of the currently active window.

  type: java.awt.SystemColor"
  SystemColor/activeCaption)

(def *-active-caption-text
  "Static Constant.

  The color rendered for the window-title text of the currently active window.

  type: java.awt.SystemColor"
  SystemColor/activeCaptionText)

(def *-active-caption-border
  "Static Constant.

  The color rendered for the border around the currently active window.

  type: java.awt.SystemColor"
  SystemColor/activeCaptionBorder)

(def *-inactive-caption
  "Static Constant.

  The color rendered for the window-title background of inactive windows.

  type: java.awt.SystemColor"
  SystemColor/inactiveCaption)

(def *-inactive-caption-text
  "Static Constant.

  The color rendered for the window-title text of inactive windows.

  type: java.awt.SystemColor"
  SystemColor/inactiveCaptionText)

(def *-inactive-caption-border
  "Static Constant.

  The color rendered for the border around inactive windows.

  type: java.awt.SystemColor"
  SystemColor/inactiveCaptionBorder)

(def *-window
  "Static Constant.

  The color rendered for the background of interior regions inside windows.

  type: java.awt.SystemColor"
  SystemColor/window)

(def *-window-border
  "Static Constant.

  The color rendered for the border around interior regions inside windows.

  type: java.awt.SystemColor"
  SystemColor/windowBorder)

(def *-window-text
  "Static Constant.

  The color rendered for text of interior regions inside windows.

  type: java.awt.SystemColor"
  SystemColor/windowText)

(def *-menu
  "Static Constant.

  The color rendered for the background of menus.

  type: java.awt.SystemColor"
  SystemColor/menu)

(def *-menu-text
  "Static Constant.

  The color rendered for the text of menus.

  type: java.awt.SystemColor"
  SystemColor/menuText)

(def *-text
  "Static Constant.

  The color rendered for the background of text control objects, such as
   textfields and comboboxes.

  type: java.awt.SystemColor"
  SystemColor/text)

(def *-text-text
  "Static Constant.

  The color rendered for the text of text control objects, such as textfields
   and comboboxes.

  type: java.awt.SystemColor"
  SystemColor/textText)

(def *-text-highlight
  "Static Constant.

  The color rendered for the background of selected items, such as in menus,
   comboboxes, and text.

  type: java.awt.SystemColor"
  SystemColor/textHighlight)

(def *-text-highlight-text
  "Static Constant.

  The color rendered for the text of selected items, such as in menus, comboboxes,
   and text.

  type: java.awt.SystemColor"
  SystemColor/textHighlightText)

(def *-text-inactive-text
  "Static Constant.

  The color rendered for the text of inactive items, such as in menus.

  type: java.awt.SystemColor"
  SystemColor/textInactiveText)

(def *-control
  "Static Constant.

  The color rendered for the background of control panels and control objects,
   such as pushbuttons.

  type: java.awt.SystemColor"
  SystemColor/control)

(def *-control-text
  "Static Constant.

  The color rendered for the text of control panels and control objects,
   such as pushbuttons.

  type: java.awt.SystemColor"
  SystemColor/controlText)

(def *-control-highlight
  "Static Constant.

  The color rendered for light areas of 3D control objects, such as pushbuttons.
   This color is typically derived from the control background color
   to provide a 3D effect.

  type: java.awt.SystemColor"
  SystemColor/controlHighlight)

(def *-control-lt-highlight
  "Static Constant.

  The color rendered for highlight areas of 3D control objects, such as pushbuttons.
   This color is typically derived from the control background color
   to provide a 3D effect.

  type: java.awt.SystemColor"
  SystemColor/controlLtHighlight)

(def *-control-shadow
  "Static Constant.

  The color rendered for shadow areas of 3D control objects, such as pushbuttons.
   This color is typically derived from the control background color
   to provide a 3D effect.

  type: java.awt.SystemColor"
  SystemColor/controlShadow)

(def *-control-dk-shadow
  "Static Constant.

  The color rendered for dark shadow areas on 3D control objects, such as pushbuttons.
   This color is typically derived from the control background color
   to provide a 3D effect.

  type: java.awt.SystemColor"
  SystemColor/controlDkShadow)

(def *-scrollbar
  "Static Constant.

  The color rendered for the background of scrollbars.

  type: java.awt.SystemColor"
  SystemColor/scrollbar)

(def *-info
  "Static Constant.

  The color rendered for the background of tooltips or spot help.

  type: java.awt.SystemColor"
  SystemColor/info)

(def *-info-text
  "Static Constant.

  The color rendered for the text of tooltips or spot help.

  type: java.awt.SystemColor"
  SystemColor/infoText)

(defn to-string
  "Returns a string representation of this Color's values.
   This method is intended to be used only for debugging purposes,
   and the content and format of the returned string may vary between
   implementations.
   The returned string may be empty but may not be null.

  returns: a string representation of this Color - `java.lang.String`"
  ([^java.awt.SystemColor this]
    (-> this (.toString))))

