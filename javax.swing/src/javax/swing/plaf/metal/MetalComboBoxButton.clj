(ns javax.swing.plaf.metal.MetalComboBoxButton
  "JButton subclass to help out MetalComboBoxUI

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalComboBoxButton]))

(defn ->metal-combo-box-button
  "Constructor.

  cb - `javax.swing.JComboBox`
  i - `javax.swing.Icon`
  only-icon - `boolean`
  pane - `javax.swing.CellRendererPane`
  list - `javax.swing.JList`"
  ([cb i only-icon pane list]
    (new MetalComboBoxButton cb i only-icon pane list))
  ([cb i pane list]
    (new MetalComboBoxButton cb i pane list)))

(defn get-minimum-size
  "Description copied from class: JComponent

  returns: the value of the minimumSize property - `java.awt.Dimension`"
  ([this]
    (-> this (.getMinimumSize))))

(defn icon-only?
  "returns: `boolean`"
  ([this]
    (-> this (.isIconOnly))))

(defn set-combo-box
  "cb - `javax.swing.JComboBox`"
  ([this cb]
    (-> this (.setComboBox cb))))

(defn paint-component
  "Description copied from class: JComponent

  g - the Graphics object to protect - `java.awt.Graphics`"
  ([this g]
    (-> this (.paintComponent g))))

(defn focus-traversable?
  "Description copied from class: Component

  returns: true if this Component is
   focusable; false otherwise - `boolean`"
  ([this]
    (-> this (.isFocusTraversable))))

(defn get-combo-box
  "returns: `javax.swing.JComboBox`"
  ([this]
    (-> this (.getComboBox))))

(defn set-icon-only
  "is-icon-only - `boolean`"
  ([this is-icon-only]
    (-> this (.setIconOnly is-icon-only))))

(defn set-enabled
  "Description copied from class: AbstractButton

  enabled - true to enable the button, otherwise false - `boolean`"
  ([this enabled]
    (-> this (.setEnabled enabled))))

(defn get-combo-icon
  "returns: `javax.swing.Icon`"
  ([this]
    (-> this (.getComboIcon))))

(defn set-combo-icon
  "i - `javax.swing.Icon`"
  ([this i]
    (-> this (.setComboIcon i))))

