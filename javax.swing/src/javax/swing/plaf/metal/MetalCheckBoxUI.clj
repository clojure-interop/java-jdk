(ns javax.swing.plaf.metal.MetalCheckBoxUI
  "CheckboxUI implementation for MetalCheckboxUI

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalCheckBoxUI]))

(defn ->metal-check-box-ui
  "Constructor."
  ([]
    (new MetalCheckBoxUI )))

(defn *create-ui
  "b - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (MetalCheckBoxUI/createUI b)))

(defn get-property-prefix
  "returns: `java.lang.String`"
  (^java.lang.String [^javax.swing.plaf.metal.MetalCheckBoxUI this]
    (-> this (.getPropertyPrefix))))

(defn install-defaults
  "b - `javax.swing.AbstractButton`"
  ([^javax.swing.plaf.metal.MetalCheckBoxUI this ^javax.swing.AbstractButton b]
    (-> this (.installDefaults b))))

