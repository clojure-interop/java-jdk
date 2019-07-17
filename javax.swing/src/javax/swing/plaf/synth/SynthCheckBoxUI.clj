(ns javax.swing.plaf.synth.SynthCheckBoxUI
  "Provides the Synth L&F UI delegate for
  JCheckBox."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthCheckBoxUI]))

(defn ->synth-check-box-ui
  "Constructor."
  ([]
    (new SynthCheckBoxUI )))

(defn *create-ui
  "Creates a new UI object for the given component.

  b - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (SynthCheckBoxUI/createUI b)))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^javax.swing.plaf.synth.SynthCheckBoxUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

