(ns javax.swing.plaf.synth.SynthRadioButtonMenuItemUI
  "Provides the Synth L&F UI delegate for
  JRadioButtonMenuItem."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.synth SynthRadioButtonMenuItemUI]))

(defn ->synth-radio-button-menu-item-ui
  "Constructor."
  (^SynthRadioButtonMenuItemUI []
    (new SynthRadioButtonMenuItemUI )))

(defn *create-ui
  "Creates a new UI object for the given component.

  b - component to create UI object for - `javax.swing.JComponent`

  returns: the UI object - `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (SynthRadioButtonMenuItemUI/createUI b)))

(defn paint-border
  "Paints the border.

  context - a component context - `javax.swing.plaf.synth.SynthContext`
  g - Graphics to paint on - `java.awt.Graphics`
  x - the X coordinate - `int`
  y - the Y coordinate - `int`
  w - width of the border - `int`
  h - height of the border - `int`"
  ([^SynthRadioButtonMenuItemUI this ^javax.swing.plaf.synth.SynthContext context ^java.awt.Graphics g ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.paintBorder context g x y w h))))

