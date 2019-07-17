(ns javax.swing.plaf.metal.MetalTextFieldUI
  "Basis of a look and feel for a JTextField.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalTextFieldUI]))

(defn ->metal-text-field-ui
  "Constructor."
  ([]
    (new MetalTextFieldUI )))

(defn *create-ui
  "c - `javax.swing.JComponent`

  returns: `javax.swing.plaf.ComponentUI`"
  (^javax.swing.plaf.ComponentUI [^javax.swing.JComponent c]
    (MetalTextFieldUI/createUI c)))

(defn property-change
  "This method gets called when a bound property is changed
   on the associated JTextComponent.  This is a hook
   which UI implementations may change to reflect how the
   UI displays bound properties of JTextComponent subclasses.

  evt - the property change event - `java.beans.PropertyChangeEvent`"
  ([^javax.swing.plaf.metal.MetalTextFieldUI this ^java.beans.PropertyChangeEvent evt]
    (-> this (.propertyChange evt))))

