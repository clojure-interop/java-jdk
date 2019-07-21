(ns javax.swing.plaf.metal.MetalLookAndFeel
  "The Java Look and Feel, otherwise known as Metal.

  Each of the ComponentUIs provided by MetalLookAndFeel derives its behavior from the defaults
  table. Unless otherwise noted each of the ComponentUI
  implementations in this package document the set of defaults they
  use. Unless otherwise noted the defaults are installed at the time
  installUI is invoked, and follow the recommendations
  outlined in LookAndFeel for installing defaults.

  MetalLookAndFeel derives it's color palette and fonts from
  MetalTheme. The default theme is OceanTheme. The theme
  can be changed using the setCurrentTheme method, refer to it
  for details on changing the theme. Prior to 1.5 the default
  theme was DefaultMetalTheme. The system property
  \"swing.metalTheme\" can be set to \"steel\" to indicate
  the default should be DefaultMetalTheme.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalLookAndFeel]))

(defn ->metal-look-and-feel
  "Constructor."
  (^MetalLookAndFeel []
    (new MetalLookAndFeel )))

(defn *get-text-highlight-color
  "Returns the text highlight color of the current theme. This is a
   cover method for getCurrentTheme().getTextHighlightColor().

  returns: the text highlight color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getTextHighlightColor )))

(defn *get-control-text-color
  "Returns the control text color of the current theme. This is a
   cover method for getCurrentTheme().getControlTextColor().

  returns: the control text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getControlTextColor )))

(defn *get-control-disabled
  "Returns the control disabled color of the current theme. This is a
   cover method for getCurrentTheme().getControlDisabled().

  returns: the control disabled color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getControlDisabled )))

(defn *get-window-title-background
  "Returns the window title background color of the current
   theme. This is a cover method for getCurrentTheme().getWindowTitleBackground().

  returns: the window title background color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getWindowTitleBackground )))

(defn *get-window-title-inactive-background
  "Returns the window title inactive background color of the current
   theme. This is a cover method for getCurrentTheme().getWindowTitleInactiveBackground().

  returns: the window title inactive background color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getWindowTitleInactiveBackground )))

(defn *get-user-text-color
  "Returns the user text color of the current theme. This is a
   cover method for getCurrentTheme().getUserTextColor().

  returns: the user text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getUserTextColor )))

(defn *get-primary-control-dark-shadow
  "Returns the primary control dark shadow color of the current
   theme. This is a cover method for getCurrentTheme().getPrimaryControlDarkShadow().

  returns: the primary control dark shadow color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getPrimaryControlDarkShadow )))

(defn *get-window-title-foreground
  "Returns the window title foreground color of the current
   theme. This is a cover method for getCurrentTheme().getWindowTitleForeground().

  returns: the window title foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getWindowTitleForeground )))

(defn *get-current-theme
  "Return the theme currently being used by MetalLookAndFeel.
   If the current theme is null, the default theme is created.

  returns: the current theme - `javax.swing.plaf.metal.MetalTheme`"
  (^javax.swing.plaf.metal.MetalTheme []
    (MetalLookAndFeel/getCurrentTheme )))

(defn *set-current-theme
  "Set the theme used by MetalLookAndFeel.

   After the theme is set, MetalLookAndFeel needs to be
   re-installed and the uis need to be recreated. The following
   shows how to do this:


     MetalLookAndFeel.setCurrentTheme(theme);

     // re-install the Metal Look and Feel
     UIManager.setLookAndFeel(new MetalLookAndFeel());

     // Update the ComponentUIs for all Components. This
     // needs to be invoked for all windows.
     SwingUtilities.updateComponentTreeUI(rootComponent);
   If this is not done the results are undefined.

  theme - the theme to use - `javax.swing.plaf.metal.MetalTheme`

  throws: java.lang.NullPointerException - if theme is null"
  ([^javax.swing.plaf.metal.MetalTheme theme]
    (MetalLookAndFeel/setCurrentTheme theme)))

(defn *get-control-dark-shadow
  "Returns the control dark shadow color of the current theme. This is a
   cover method for getCurrentTheme().getControlDarkShadow().

  returns: the control dark shadow color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getControlDarkShadow )))

(defn *get-menu-background
  "Returns the menu background color of the current theme. This is
   a cover method for getCurrentTheme().getMenuBackground().

  returns: the menu background color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getMenuBackground )))

(defn *get-inactive-system-text-color
  "Returns the inactive system text color of the current theme. This is a
   cover method for getCurrentTheme().getInactiveSystemTextColor().

  returns: the inactive system text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getInactiveSystemTextColor )))

(defn *get-control-shadow
  "Returns the control shadow color of the current theme. This is a
   cover method for getCurrentTheme().getControlShadow().

  returns: the control shadow color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getControlShadow )))

(defn *get-menu-text-font
  "Returns the menu text font of the current theme. This is a
   cover method for getCurrentTheme().getMenuTextFont().

  returns: the menu text font - `javax.swing.plaf.FontUIResource`"
  (^javax.swing.plaf.FontUIResource []
    (MetalLookAndFeel/getMenuTextFont )))

(defn *get-user-text-font
  "Returns the user text font of the current theme. This is a
   cover method for getCurrentTheme().getUserTextFont().

  returns: the user text font - `javax.swing.plaf.FontUIResource`"
  (^javax.swing.plaf.FontUIResource []
    (MetalLookAndFeel/getUserTextFont )))

(defn *get-primary-control-shadow
  "Returns the primary control shadow color of the current theme. This is a
   cover method for getCurrentTheme().getPrimaryControlShadow().

  returns: the primary control shadow color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getPrimaryControlShadow )))

(defn *get-control-text-font
  "Returns the control text font of the current theme. This is a
   cover method for getCurrentTheme().getControlTextColor().

  returns: the control text font - `javax.swing.plaf.FontUIResource`"
  (^javax.swing.plaf.FontUIResource []
    (MetalLookAndFeel/getControlTextFont )))

(defn *get-menu-selected-foreground
  "Returns the menu selected foreground color of the current theme. This is
   a cover method for
   getCurrentTheme().getMenuSelectedForeground().

  returns: the menu selected foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getMenuSelectedForeground )))

(defn *get-primary-control
  "Returns the primary control color of the current theme. This is a
   cover method for getCurrentTheme().getPrimaryControl().

  returns: the primary control color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getPrimaryControl )))

(defn *get-focus-color
  "Returns the focus color of the current theme. This is a
   cover method for getCurrentTheme().getFocusColor().

  returns: the focus color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getFocusColor )))

(defn *get-control
  "Returns the control color of the current theme. This is a
   cover method for getCurrentTheme().getControl().

  returns: the control color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getControl )))

(defn *get-control-highlight
  "Returns the control highlight color of the current theme. This is a
   cover method for getCurrentTheme().getControlHighlight().

  returns: the control highlight color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getControlHighlight )))

(defn *get-menu-foreground
  "Returns the menu foreground color of the current theme. This is
   a cover method for getCurrentTheme().getMenuForeground().

  returns: the menu foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getMenuForeground )))

(defn *get-desktop-color
  "Returns the desktop color of the current theme. This is a
   cover method for getCurrentTheme().getDesktopColor().

  returns: the desktop color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getDesktopColor )))

(defn *get-highlighted-text-color
  "Returns the highlighted text color of the current theme. This is a
   cover method for getCurrentTheme().getHighlightedTextColor().

  returns: the highlighted text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getHighlightedTextColor )))

(defn *get-window-title-font
  "Returns the window title font of the current theme. This is a
   cover method for getCurrentTheme().getWindowTitleFont().

  returns: the window title font - `javax.swing.plaf.FontUIResource`"
  (^javax.swing.plaf.FontUIResource []
    (MetalLookAndFeel/getWindowTitleFont )))

(defn *get-separator-foreground
  "Returns the separator foreground color of the current theme. This is
   a cover method for getCurrentTheme().getSeparatorForeground().

  returns: the separator foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getSeparatorForeground )))

(defn *get-sub-text-font
  "Returns the sub-text font of the current theme. This is a
   cover method for getCurrentTheme().getSubTextFont().

  returns: the sub-text font - `javax.swing.plaf.FontUIResource`"
  (^javax.swing.plaf.FontUIResource []
    (MetalLookAndFeel/getSubTextFont )))

(defn *get-accelerator-foreground
  "Returns the accelerator foreground color of the current theme. This is
   a cover method for getCurrentTheme().getAcceleratorForeground().

  returns: the separator accelerator foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getAcceleratorForeground )))

(defn *get-separator-background
  "Returns the separator background color of the current theme. This is
   a cover method for getCurrentTheme().getSeparatorBackground().

  returns: the separator background color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getSeparatorBackground )))

(defn *get-accelerator-selected-foreground
  "Returns the accelerator selected foreground color of the
   current theme. This is a cover method for getCurrentTheme().getAcceleratorSelectedForeground().

  returns: the accelerator selected foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getAcceleratorSelectedForeground )))

(defn *get-white
  "Returns the white color of the current theme. This is a
   cover method for getCurrentTheme().getWhite().

  returns: the white color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getWhite )))

(defn *get-system-text-color
  "Returns the system text color of the current theme. This is a
   cover method for getCurrentTheme().getSystemTextColor().

  returns: the system text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getSystemTextColor )))

(defn *get-black
  "Returns the black color of the current theme. This is a
   cover method for getCurrentTheme().getBlack().

  returns: the black color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getBlack )))

(defn *get-window-background
  "Returns the window background color of the current theme. This is a
   cover method for getCurrentTheme().getWindowBackground().

  returns: the window background color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getWindowBackground )))

(defn *get-menu-disabled-foreground
  "Returns the menu disabled foreground color of the current theme. This is
   a cover method for
   getCurrentTheme().getMenuDisabledForeground().

  returns: the menu disabled foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getMenuDisabledForeground )))

(defn *get-primary-control-info
  "Returns the primary control info color of the current theme. This is a
   cover method for getCurrentTheme().getPrimaryControlInfo().

  returns: the primary control info color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getPrimaryControlInfo )))

(defn *get-menu-selected-background
  "Returns the menu selected background color of the current theme. This is
   a cover method for
   getCurrentTheme().getMenuSelectedBackground().

  returns: the menu selected background color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getMenuSelectedBackground )))

(defn *get-inactive-control-text-color
  "Returns the inactive control text color of the current theme. This is a
   cover method for getCurrentTheme().getInactiveControlTextColor().

  returns: the inactive control text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getInactiveControlTextColor )))

(defn *get-control-info
  "Returns the control info color of the current theme. This is a
   cover method for getCurrentTheme().getControlInfo().

  returns: the control info color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getControlInfo )))

(defn *get-window-title-inactive-foreground
  "Returns the window title inactive foreground color of the current
   theme. This is a cover method for getCurrentTheme().getWindowTitleInactiveForeground().

  returns: the window title inactive foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getWindowTitleInactiveForeground )))

(defn *get-system-text-font
  "Returns the system text font of the current theme. This is a
   cover method for getCurrentTheme().getSystemTextFont().

  returns: the system text font - `javax.swing.plaf.FontUIResource`"
  (^javax.swing.plaf.FontUIResource []
    (MetalLookAndFeel/getSystemTextFont )))

(defn *get-primary-control-highlight
  "Returns the primary control highlight color of the current
   theme. This is a cover method for getCurrentTheme().getPrimaryControlHighlight().

  returns: the primary control highlight color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource []
    (MetalLookAndFeel/getPrimaryControlHighlight )))

(defn get-disabled-selected-icon
  "Returns an Icon for use by disabled
   components that are also selected. This method is used to generate an
   Icon for components that are in both the disabled and
   selected states but do not have a specific Icon for this
   state.  For example, if you create a JButton and only
   specify an Icon via setIcon this method
   will be called to generate the disabled and selected
   Icon. If null is passed as icon this method
   returns null.

   Some look and feels might not render the disabled and selected Icon,
   in which case they will ignore this.

  component - JComponent that will display the Icon, may be null - `javax.swing.JComponent`
  icon - Icon to generate disabled and selected icon from. - `javax.swing.Icon`

  returns: Disabled and Selected icon, or null if a suitable Icon can not
           be generated. - `javax.swing.Icon`"
  (^javax.swing.Icon [^MetalLookAndFeel this ^javax.swing.JComponent component ^javax.swing.Icon icon]
    (-> this (.getDisabledSelectedIcon component icon))))

(defn get-supports-window-decorations?
  "Returns true; metal can provide Window
   decorations.

  returns: true - `boolean`"
  (^Boolean [^MetalLookAndFeel this]
    (-> this (.getSupportsWindowDecorations))))

(defn get-defaults
  "Returns the look and feel defaults. This invokes, in order,
   createDefaultTheme(), super.getDefaults() and
   getCurrentTheme().addCustomEntriesToTable(table).

   While this method is public, it should only be invoked by the
   UIManager when the look and feel is set as the current
   look and feel and after initialize has been invoked.

  returns: the look and feel defaults - `javax.swing.UIDefaults`"
  (^javax.swing.UIDefaults [^MetalLookAndFeel this]
    (-> this (.getDefaults))))

(defn get-name
  "Returns the name of this look and feel. This returns
   \"Metal\".

  returns: the name of this look and feel - `java.lang.String`"
  (^java.lang.String [^MetalLookAndFeel this]
    (-> this (.getName))))

(defn get-layout-style
  "Returns a LayoutStyle implementing the Java look and feel
   design guidelines as specified at
   http://www.oracle.com/technetwork/java/hig-136467.html.

  returns: LayoutStyle implementing the Java look and feel design
           guidelines - `javax.swing.LayoutStyle`"
  (^javax.swing.LayoutStyle [^MetalLookAndFeel this]
    (-> this (.getLayoutStyle))))

(defn get-description
  "Returns a short description of this look and feel. This returns
   \"The Java(tm) Look and Feel\".

  returns: a short description for the look and feel - `java.lang.String`"
  (^java.lang.String [^MetalLookAndFeel this]
    (-> this (.getDescription))))

(defn supported-look-and-feel?
  "Returns true; MetalLookAndFeel can be run on
   any platform.

  returns: true - `boolean`"
  (^Boolean [^MetalLookAndFeel this]
    (-> this (.isSupportedLookAndFeel))))

(defn provide-error-feedback
  "Invoked when the user attempts an invalid operation,
   such as pasting into an uneditable JTextField
   that has focus. The default implementation beeps. Subclasses
   that wish different behavior should override this and provide
   the additional feedback.

  component - the Component the error occurred in, may be null indicating the error condition is not directly associated with a Component - `java.awt.Component`"
  ([^MetalLookAndFeel this ^java.awt.Component component]
    (-> this (.provideErrorFeedback component))))

(defn native-look-and-feel?
  "Returns false; MetalLookAndFeel is not a native
   look and feel.

  returns: false - `boolean`"
  (^Boolean [^MetalLookAndFeel this]
    (-> this (.isNativeLookAndFeel))))

(defn get-id
  "Returns an identifier for this look and feel. This returns
   \"Metal\".

  returns: the identifier of this look and feel - `java.lang.String`"
  (^java.lang.String [^MetalLookAndFeel this]
    (-> this (.getID))))

(defn get-disabled-icon
  "Returns an Icon with a disabled appearance.
   This method is used to generate a disabled Icon when
   one has not been specified.  For example, if you create a
   JButton and only specify an Icon via
   setIcon this method will be called to generate the
   disabled Icon. If null is passed as icon
   this method returns null.

   Some look and feels might not render the disabled Icon, in which
   case they will ignore this.

  component - JComponent that will display the Icon, may be null - `javax.swing.JComponent`
  icon - Icon to generate disable icon from. - `javax.swing.Icon`

  returns: Disabled icon, or null if a suitable Icon can not be
           generated. - `javax.swing.Icon`"
  (^javax.swing.Icon [^MetalLookAndFeel this ^javax.swing.JComponent component ^javax.swing.Icon icon]
    (-> this (.getDisabledIcon component icon))))

