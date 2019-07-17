(ns javax.swing.plaf.synth.SynthFormattedTextFieldUI
  "Provides the Synth L&F UI delegate for
  JFormattedTextField."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthFormattedTextFieldUI]))

(defn ->synth-formatted-text-field-ui
  "Constructor."
  ([]
    (new SynthFormattedTextFieldUI )))

(defn *create-ui
  "Creates a UI for a JFormattedTextField.

  c - the formatted text field - `javax.swing.JComponent`

  returns: the UI - `javax.swing.plaf.ComponentUI`"
  ([c]
    (SynthFormattedTextFieldUI/createUI c)))

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

