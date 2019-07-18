(ns javax.swing.plaf.metal.MetalBorders$RolloverButtonBorder
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalBorders$RolloverButtonBorder]))

(defn ->rollover-button-border
  "Constructor."
  (^MetalBorders$RolloverButtonBorder []
    (new MetalBorders$RolloverButtonBorder )))

(defn paint-border
  "Description copied from class: AbstractBorder

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  w - the width of the painted border - `int`
  h - the height of the painted border - `int`"
  ([^MetalBorders$RolloverButtonBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder c g x y w h))))

