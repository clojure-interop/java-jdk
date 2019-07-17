(ns javax.swing.plaf.metal.MetalComboBoxIcon
  "This utility class draws the horizontal bars which indicate a MetalComboBox"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalComboBoxIcon]))

(defn ->metal-combo-box-icon
  "Constructor."
  ([]
    (new MetalComboBoxIcon )))

(defn paint-icon
  "Paints the horizontal bars for the

  c - `java.awt.Component`
  g - `java.awt.Graphics`
  x - `int`
  y - `int`"
  ([this c g x y]
    (-> this (.paintIcon c g x y))))

(defn get-icon-width
  "Created a stub to satisfy the interface.

  returns: an int specifying the fixed width of the icon. - `int`"
  ([this]
    (-> this (.getIconWidth))))

(defn get-icon-height
  "Created a stub to satisfy the interface.

  returns: an int specifying the fixed height of the icon. - `int`"
  ([this]
    (-> this (.getIconHeight))))

