(ns javax.swing.plaf.synth.SynthUI
  "SynthUI is used to fetch the SynthContext for a particular Component."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthUI]))

(defn get-context
  "Returns the Context for the specified component.

  c - Component requesting SynthContext. - `javax.swing.JComponent`

  returns: SynthContext describing component. - `javax.swing.plaf.synth.SynthContext`"
  ([this c]
    (-> this (.getContext c))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([this context g x y w h]
    (-> this (.paintBorder context g x y w h))))

