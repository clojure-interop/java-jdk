(ns javax.swing.plaf.metal.MetalRadioButtonUI
  "RadioButtonUI implementation for MetalRadioButtonUI

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalRadioButtonUI]))

(defn ->metal-radio-button-ui
  "Constructor."
  ([]
    (new MetalRadioButtonUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  ([^javax.swing.JComponent c]
    (MetalRadioButtonUI/createUI c)))

(defn install-defaults
  "b - `javax.swing.AbstractButton`"
  ([^javax.swing.plaf.metal.MetalRadioButtonUI this ^javax.swing.AbstractButton b]
    (-> this (.installDefaults b))))

(defn paint
  "Description copied from class: BasicRadioButtonUI

  g - the Graphics context in which to paint - `java.awt.Graphics`
  c - the component being painted; this argument is often ignored, but might be used if the UI object is stateless and shared by multiple components - `javax.swing.JComponent`"
  ([^javax.swing.plaf.metal.MetalRadioButtonUI this ^java.awt.Graphics g ^javax.swing.JComponent c]
    (-> this (.paint g c))))

