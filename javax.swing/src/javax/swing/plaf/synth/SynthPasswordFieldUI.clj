(ns javax.swing.plaf.synth.SynthPasswordFieldUI
  "Provides the Synth L&F UI delegate for
  JPasswordField."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthPasswordFieldUI]))

(defn ->synth-password-field-ui
  "Constructor."
  ([]
    (new SynthPasswordFieldUI )))

(defn *create-ui
  "Creates a UI for a JPasswordField.

  c - the JPasswordField - `javax.swing.JComponent`

  returns: the UI - `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (SynthPasswordFieldUI/createUI c)))

(defn create
  "Creates a view (PasswordView) for an element.

  elem - the element - `javax.swing.text.Element`

  returns: the view - `javax.swing.text.View`"
  ([^javax.swing.plaf.synth.SynthPasswordFieldUI this ^javax.swing.text.Element elem]
    (-> this (.create elem))))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^javax.swing.plaf.synth.SynthPasswordFieldUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

