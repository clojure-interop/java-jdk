(ns javax.swing.plaf.synth.SynthCheckBoxMenuItemUI
  "Provides the Synth L&F UI delegate for
  JCheckBoxMenuItem."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthCheckBoxMenuItemUI]))

(defn ->synth-check-box-menu-item-ui
  "Constructor."
  ([]
    (new SynthCheckBoxMenuItemUI )))

(defn *create-ui
  "Creates a new UI object for the given component.

  c - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  ([c]
    (SynthCheckBoxMenuItemUI/createUI c)))

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

