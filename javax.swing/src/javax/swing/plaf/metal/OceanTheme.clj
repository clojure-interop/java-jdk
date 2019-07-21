(ns javax.swing.plaf.metal.OceanTheme
  "The default theme for the MetalLookAndFeel.

  The designers
  of the Metal Look and Feel strive to keep the default look up to
  date, possibly through the use of new themes in the future.
  Therefore, developers should only use this class directly when they
  wish to customize the \"Ocean\" look, or force it to be the current
  theme, regardless of future updates.


  All colors returned by OceanTheme are completely
  opaque."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal OceanTheme]))

(defn ->ocean-theme
  "Constructor.

  Creates an instance of OceanTheme"
  (^OceanTheme []
    (new OceanTheme )))

(defn add-custom-entries-to-table
  "Add this theme's custom entries to the defaults table.

  table - the defaults table, non-null - `javax.swing.UIDefaults`

  throws: java.lang.NullPointerException - if table is null"
  ([^OceanTheme this ^javax.swing.UIDefaults table]
    (-> this (.addCustomEntriesToTable table))))

(defn get-name
  "Return the name of this theme, \"Ocean\".

  returns: \"Ocean\" - `java.lang.String`"
  (^java.lang.String [^OceanTheme this]
    (-> this (.getName))))

(defn get-desktop-color
  "Returns the desktop color. This returns a color with an rgb hex
   value of 0xFFFFFF.

  returns: the desktop color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource [^OceanTheme this]
    (-> this (.getDesktopColor))))

(defn get-inactive-control-text-color
  "Returns the inactive control text color. This returns a color with an
   rgb hex value of 0x999999.

  returns: the inactive control text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource [^OceanTheme this]
    (-> this (.getInactiveControlTextColor))))

(defn get-control-text-color
  "Returns the control text color. This returns a color with an
   rgb hex value of 0x333333.

  returns: the control text color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource [^OceanTheme this]
    (-> this (.getControlTextColor))))

(defn get-menu-disabled-foreground
  "Returns the menu disabled foreground color. This returns a color with an
   rgb hex value of 0x999999.

  returns: the menu disabled foreground color - `javax.swing.plaf.ColorUIResource`"
  (^javax.swing.plaf.ColorUIResource [^OceanTheme this]
    (-> this (.getMenuDisabledForeground))))

