(ns javax.swing.plaf.basic.BasicBorders$FieldBorder
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicBorders$FieldBorder]))

(defn ->field-border
  "Constructor.

  shadow - `java.awt.Color`
  dark-shadow - `java.awt.Color`
  highlight - `java.awt.Color`
  light-highlight - `java.awt.Color`"
  (^BasicBorders$FieldBorder [^java.awt.Color shadow ^java.awt.Color dark-shadow ^java.awt.Color highlight ^java.awt.Color light-highlight]
    (new BasicBorders$FieldBorder shadow dark-shadow highlight light-highlight)))

(defn paint-border
  "Description copied from class: AbstractBorder

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^BasicBorders$FieldBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Description copied from class: AbstractBorder

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  (^java.awt.Insets [^BasicBorders$FieldBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets))))

