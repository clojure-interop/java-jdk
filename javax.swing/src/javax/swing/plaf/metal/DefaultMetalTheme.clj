(ns javax.swing.plaf.metal.DefaultMetalTheme
  "A concrete implementation of MetalTheme providing
  the original look of the Java Look and Feel, code-named `Steel`. Refer
  to MetalLookAndFeel.setCurrentTheme(javax.swing.plaf.metal.MetalTheme) for details on changing
  the default theme.

  All colors returned by DefaultMetalTheme are completely
  opaque.

  Font Style

  DefaultMetalTheme uses bold fonts for many controls.  To make all
  controls (with the exception of the internal frame title bars and
  client decorated frame title bars) use plain fonts you can do either of
  the following:

  Set the system property swing.boldMetal to
      false.  For example,
      java -Dswing.boldMetal=false MyApp.
  Set the defaults property swing.boldMetal to
      Boolean.FALSE.  For example:
      UIManager.put(`swing.boldMetal`, Boolean.FALSE);

  The defaults property swing.boldMetal, if set,
  takes precedence over the system property of the same name. After
  setting this defaults property you need to re-install
  MetalLookAndFeel, as well as update the UI
  of any previously created widgets. Otherwise the results are undefined.
  The following illustrates how to do this:


    // turn off bold fonts
    UIManager.put(`swing.boldMetal`, Boolean.FALSE);

    // re-install the Metal Look and Feel
    UIManager.setLookAndFeel(new MetalLookAndFeel());

    // Update the ComponentUIs for all Components. This
    // needs to be invoked for all windows.
    SwingUtilities.updateComponentTreeUI(rootComponent);

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal DefaultMetalTheme]))

(defn ->default-metal-theme
  "Constructor.

  Creates and returns an instance of DefaultMetalTheme."
  ([]
    (new DefaultMetalTheme )))

(defn get-name
  "Returns the name of this theme. This returns `Steel`.

  returns: the name of this theme. - `java.lang.String`"
  ([^javax.swing.plaf.metal.DefaultMetalTheme this]
    (-> this (.getName))))

(defn get-control-text-font
  "Returns the control text font. This returns Dialog, 12pt. If
   plain fonts have been enabled as described in
   font style, the font style is plain. Otherwise the font style is
   bold.

  returns: the control text font - `javax.swing.plaf.FontUIResource`"
  ([^javax.swing.plaf.metal.DefaultMetalTheme this]
    (-> this (.getControlTextFont))))

(defn get-system-text-font
  "Returns the system text font. This returns Dialog, 12pt, plain.

  returns: the system text font - `javax.swing.plaf.FontUIResource`"
  ([^javax.swing.plaf.metal.DefaultMetalTheme this]
    (-> this (.getSystemTextFont))))

(defn get-user-text-font
  "Returns the user text font. This returns Dialog, 12pt, plain.

  returns: the user text font - `javax.swing.plaf.FontUIResource`"
  ([^javax.swing.plaf.metal.DefaultMetalTheme this]
    (-> this (.getUserTextFont))))

(defn get-menu-text-font
  "Returns the menu text font. This returns Dialog, 12pt. If
   plain fonts have been enabled as described in
   font style, the font style is plain. Otherwise the font style is
   bold.

  returns: the menu text font - `javax.swing.plaf.FontUIResource`"
  ([^javax.swing.plaf.metal.DefaultMetalTheme this]
    (-> this (.getMenuTextFont))))

(defn get-window-title-font
  "Returns the window title font. This returns Dialog, 12pt, bold.

  returns: the window title font - `javax.swing.plaf.FontUIResource`"
  ([^javax.swing.plaf.metal.DefaultMetalTheme this]
    (-> this (.getWindowTitleFont))))

(defn get-sub-text-font
  "Returns the sub-text font. This returns Dialog, 10pt, plain.

  returns: the sub-text font - `javax.swing.plaf.FontUIResource`"
  ([^javax.swing.plaf.metal.DefaultMetalTheme this]
    (-> this (.getSubTextFont))))

