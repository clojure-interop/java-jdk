(ns javax.swing.plaf.metal.MetalBorders$RolloverButtonBorder
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalBorders$RolloverButtonBorder]))

(defn ->rollover-button-border
  "Constructor."
  ([]
    (new MetalBorders$RolloverButtonBorder )))

(defn paint-border
  "Description copied from class: AbstractBorder

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  w - the width of the painted border - `int`
  h - the height of the painted border - `int`"
  ([this c g x y w h]
    (-> this (.paintBorder c g x y w h))))

