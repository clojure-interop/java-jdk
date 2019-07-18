(ns javax.swing.plaf.metal.MetalCheckBoxIcon
  "CheckboxIcon implementation for OrganicCheckBoxUI

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalCheckBoxIcon]))

(defn ->metal-check-box-icon
  "Constructor."
  (^MetalCheckBoxIcon []
    (new MetalCheckBoxIcon )))

(defn paint-icon
  "Description copied from interface: Icon

  c - `java.awt.Component`
  g - `java.awt.Graphics`
  x - `int`
  y - `int`"
  ([^MetalCheckBoxIcon this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y]
    (-> this (.paintIcon c g x y))))

(defn get-icon-width
  "Description copied from interface: Icon

  returns: an int specifying the fixed width of the icon. - `int`"
  (^Integer [^MetalCheckBoxIcon this]
    (-> this (.getIconWidth))))

(defn get-icon-height
  "Description copied from interface: Icon

  returns: an int specifying the fixed height of the icon. - `int`"
  (^Integer [^MetalCheckBoxIcon this]
    (-> this (.getIconHeight))))

