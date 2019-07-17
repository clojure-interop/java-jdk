(ns javax.swing.plaf.metal.MetalTheme
  "MetalTheme provides the color palette and fonts used by
  the Java Look and Feel.

  MetalTheme is abstract, see DefaultMetalTheme and
  OceanTheme for concrete implementations.

  MetalLookAndFeel maintains the current theme that the
  the ComponentUI implementations for metal use. Refer to
  MetalLookAndFeel.setCurrentTheme(MetalTheme) for details on changing
  the current theme.

  MetalTheme provides a number of public methods for getting
  colors. These methods are implemented in terms of a
  handful of protected abstract methods. A subclass need only override
  the protected abstract methods (getPrimary1,
  getPrimary2, getPrimary3, getSecondary1,
  getSecondary2, and getSecondary3); although a subclass
  may override the other public methods for more control over the set of
  colors that are used.

  Concrete implementations of MetalTheme must return non-null
  values from all methods. While the behavior of returning null is
  not specified, returning null will result in incorrect behavior.

  It is strongly recommended that subclasses return completely opaque colors.
  To do otherwise may result in rendering problems, such as visual garbage."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalTheme]))

(defn ->metal-theme
  "Constructor."
  ([]
    (new MetalTheme )))

(defn get-text-highlight-color
  "Returns the text highlight color. This returns the value of
   getPrimary3().

  returns: the text highlight color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getTextHighlightColor))))

(defn get-control-text-color
  "Returns the control text color. This returns the value of
   getControlInfo().

  returns: the control text color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getControlTextColor))))

(defn get-control-disabled
  "Returns the control disabled color. This returns
   the value of getSecondary2().

  returns: the control disabled color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getControlDisabled))))

(defn get-window-title-background
  "Returns the window title background color. This returns the value of
   getPrimary3().

  returns: the window title background color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getWindowTitleBackground))))

(defn get-window-title-inactive-background
  "Returns the window title inactive background color. This
   returns the value of getSecondary3().

  returns: the window title inactive background color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getWindowTitleInactiveBackground))))

(defn get-user-text-color
  "Returns the user text color. This returns the value of
   getBlack().

  returns: the user text color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getUserTextColor))))

(defn get-primary-control-dark-shadow
  "Returns the primary control dark shadow color. This
   returns the value of getPrimary1().

  returns: the primary control dark shadow color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getPrimaryControlDarkShadow))))

(defn get-window-title-foreground
  "Returns the window title foreground color. This returns the value of
   getBlack().

  returns: the window title foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getWindowTitleForeground))))

(defn get-control-dark-shadow
  "Returns the control dark shadow color. This returns
   the value of getSecondary1().

  returns: the control dark shadow color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getControlDarkShadow))))

(defn get-menu-background
  "Returns the menu background color. This
   returns the value of getSecondary3().

  returns: the menu background color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getMenuBackground))))

(defn get-inactive-system-text-color
  "Returns the inactive system text color. This returns the value of
   getSecondary2().

  returns: the inactive system text color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getInactiveSystemTextColor))))

(defn get-control-shadow
  "Returns the control shadow color. This returns
   the value of getSecondary2().

  returns: the control shadow color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getControlShadow))))

(defn get-menu-text-font
  "Returns the menu text font.

  returns: the menu text font - `javax.swing.plaf.FontUIResource`"
  ([this]
    (-> this (.getMenuTextFont))))

(defn get-user-text-font
  "Returns the user text font.

  returns: the user text font - `javax.swing.plaf.FontUIResource`"
  ([this]
    (-> this (.getUserTextFont))))

(defn get-name
  "Returns the name of this theme.

  returns: the name of this theme - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-primary-control-shadow
  "Returns the primary control shadow color. This returns
   the value of getPrimary2().

  returns: the primary control shadow color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getPrimaryControlShadow))))

(defn get-control-text-font
  "Returns the control text font.

  returns: the control text font - `javax.swing.plaf.FontUIResource`"
  ([this]
    (-> this (.getControlTextFont))))

(defn get-menu-selected-foreground
  "Returns the menu selected foreground color. This
   returns the value of getBlack().

  returns: the menu selected foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getMenuSelectedForeground))))

(defn get-primary-control
  "Returns the primary control color. This returns
   the value of getPrimary3().

  returns: the primary control color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getPrimaryControl))))

(defn get-focus-color
  "Returns the focus color. This returns the value of
   getPrimary2().

  returns: the focus color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getFocusColor))))

(defn get-control
  "Returns the control color. This returns the value of
   getSecondary3().

  returns: the control color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getControl))))

(defn get-control-highlight
  "Returns the control highlight color. This returns
   the value of getWhite().

  returns: the control highlight color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getControlHighlight))))

(defn get-menu-foreground
  "Returns the menu foreground color. This
   returns the value of getBlack().

  returns: the menu foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getMenuForeground))))

(defn get-desktop-color
  "Returns the desktop color. This returns the value of
   getPrimary2().

  returns: the desktop color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getDesktopColor))))

(defn get-highlighted-text-color
  "Returns the highlighted text color. This returns the value of
   getControlTextColor().

  returns: the highlighted text color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getHighlightedTextColor))))

(defn get-window-title-font
  "Returns the window title font.

  returns: the window title font - `javax.swing.plaf.FontUIResource`"
  ([this]
    (-> this (.getWindowTitleFont))))

(defn get-separator-foreground
  "Returns the separator foreground color. This
   returns the value of getPrimary1().

  returns: the separator foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getSeparatorForeground))))

(defn get-sub-text-font
  "Returns the sub-text font.

  returns: the sub-text font - `javax.swing.plaf.FontUIResource`"
  ([this]
    (-> this (.getSubTextFont))))

(defn get-accelerator-foreground
  "Returns the accelerator foreground color. This
   returns the value of getPrimary1().

  returns: the accelerator foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getAcceleratorForeground))))

(defn get-separator-background
  "Returns the separator background color. This
   returns the value of getWhite().

  returns: the separator background color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getSeparatorBackground))))

(defn get-accelerator-selected-foreground
  "Returns the accelerator selected foreground color. This
   returns the value of getBlack().

  returns: the accelerator selected foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getAcceleratorSelectedForeground))))

(defn get-system-text-color
  "Returns the system text color. This returns the value of
   getBlack().

  returns: the system text color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getSystemTextColor))))

(defn get-window-background
  "Returns the window background color. This returns the value of
   getWhite().

  returns: the window background color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getWindowBackground))))

(defn get-menu-disabled-foreground
  "Returns the menu disabled foreground color. This
   returns the value of getSecondary2().

  returns: the menu disabled foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getMenuDisabledForeground))))

(defn get-primary-control-info
  "Returns the primary control info color. This
   returns the value of getBlack().

  returns: the primary control info color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getPrimaryControlInfo))))

(defn get-menu-selected-background
  "Returns the menu selected background color. This
   returns the value of getPrimary2().

  returns: the menu selected background color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getMenuSelectedBackground))))

(defn get-inactive-control-text-color
  "Returns the inactive control text color. This returns the value of
   getControlDisabled().

  returns: the inactive control text color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getInactiveControlTextColor))))

(defn get-control-info
  "Returns the control info color. This returns
   the value of getBlack().

  returns: the control info color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getControlInfo))))

(defn get-window-title-inactive-foreground
  "Returns the window title inactive foreground color. This
   returns the value of getBlack().

  returns: the window title inactive foreground color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getWindowTitleInactiveForeground))))

(defn get-system-text-font
  "Returns the system text font.

  returns: the system text font - `javax.swing.plaf.FontUIResource`"
  ([this]
    (-> this (.getSystemTextFont))))

(defn get-primary-control-highlight
  "Returns the primary control highlight color. This
   returns the value of getWhite().

  returns: the primary control highlight color - `javax.swing.plaf.ColorUIResource`"
  ([this]
    (-> this (.getPrimaryControlHighlight))))

(defn add-custom-entries-to-table
  "Adds values specific to this theme to the defaults table. This method
   is invoked when the look and feel defaults are obtained from
   MetalLookAndFeel.

   This implementation does nothing; it is provided for subclasses
   that wish to customize the defaults table.

  table - the UIDefaults to add the values to - `javax.swing.UIDefaults`"
  ([this table]
    (-> this (.addCustomEntriesToTable table))))

