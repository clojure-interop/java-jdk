(ns javax.swing.plaf.basic.BasicBorders$SplitPaneBorder
  "Draws the border around the splitpane. To work correctly you should
  also install a border on the divider (property SplitPaneDivider.border)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicBorders$SplitPaneBorder]))

(defn ->split-pane-border
  "Constructor.

  highlight - `java.awt.Color`
  shadow - `java.awt.Color`"
  ([^java.awt.Color highlight ^java.awt.Color shadow]
    (new BasicBorders$SplitPaneBorder highlight shadow)))

(defn paint-border
  "Description copied from interface: Border

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.plaf.basic.BasicBorders$SplitPaneBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Description copied from interface: Border

  c - the component for which this border insets value applies - `java.awt.Component`

  returns: `java.awt.Insets`"
  (^java.awt.Insets [^javax.swing.plaf.basic.BasicBorders$SplitPaneBorder this ^java.awt.Component c]
    (-> this (.getBorderInsets c))))

(defn border-opaque?
  "Description copied from interface: Border

  returns: `boolean`"
  (^Boolean [^javax.swing.plaf.basic.BasicBorders$SplitPaneBorder this]
    (-> this (.isBorderOpaque))))

