(ns javax.swing.plaf.basic.BasicBorders$RolloverButtonBorder
  "Special thin border for rollover toolbar buttons."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicBorders$RolloverButtonBorder]))

(defn ->rollover-button-border
  "Constructor.

  shadow - `java.awt.Color`
  dark-shadow - `java.awt.Color`
  highlight - `java.awt.Color`
  light-highlight - `java.awt.Color`"
  ([shadow dark-shadow highlight light-highlight]
    (new BasicBorders$RolloverButtonBorder shadow dark-shadow highlight light-highlight)))

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

