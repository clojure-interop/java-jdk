(ns javax.swing.plaf.basic.BasicCheckBoxUI
  "CheckboxUI implementation for BasicCheckboxUI

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicCheckBoxUI]))

(defn ->basic-check-box-ui
  "Constructor."
  (^BasicCheckBoxUI []
    (new BasicCheckBoxUI )))

(defn *create-ui
  "b - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent b]
    (BasicCheckBoxUI/createUI b)))

(defn get-property-prefix
  "returns: `java.lang.String`"
  (^java.lang.String [^BasicCheckBoxUI this]
    (-> this (.getPropertyPrefix))))

