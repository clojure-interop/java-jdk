(ns javax.swing.plaf.metal.MetalBorders$ToolBarBorder
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalBorders$ToolBarBorder]))

(defn ->tool-bar-border
  "Constructor."
  (^MetalBorders$ToolBarBorder []
    (new MetalBorders$ToolBarBorder )))

(defn paint-border
  "Description copied from class: AbstractBorder

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  w - the width of the painted border - `int`
  h - the height of the painted border - `int`"
  ([^MetalBorders$ToolBarBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder c g x y w h))))

(defn get-border-insets
  "Description copied from class: AbstractBorder

  c - the component for which this border insets value applies - `java.awt.Component`
  new-insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  (^java.awt.Insets [^MetalBorders$ToolBarBorder this ^java.awt.Component c ^java.awt.Insets new-insets]
    (-> this (.getBorderInsets c new-insets))))

