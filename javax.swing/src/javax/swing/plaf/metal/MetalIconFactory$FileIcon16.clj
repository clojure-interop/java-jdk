(ns javax.swing.plaf.metal.MetalIconFactory$FileIcon16
  " Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalIconFactory$FileIcon16]))

(defn ->file-icon-16
  "Constructor."
  (^MetalIconFactory$FileIcon16 []
    (new MetalIconFactory$FileIcon16 )))

(defn paint-icon
  "Description copied from interface: Icon

  c - `java.awt.Component`
  g - `java.awt.Graphics`
  x - `int`
  y - `int`"
  ([^MetalIconFactory$FileIcon16 this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y]
    (-> this (.paintIcon c g x y))))

(defn get-shift
  "returns: `int`"
  (^Integer [^MetalIconFactory$FileIcon16 this]
    (-> this (.getShift))))

(defn get-additional-height
  "returns: `int`"
  (^Integer [^MetalIconFactory$FileIcon16 this]
    (-> this (.getAdditionalHeight))))

(defn get-icon-width
  "Description copied from interface: Icon

  returns: an int specifying the fixed width of the icon. - `int`"
  (^Integer [^MetalIconFactory$FileIcon16 this]
    (-> this (.getIconWidth))))

(defn get-icon-height
  "Description copied from interface: Icon

  returns: an int specifying the fixed height of the icon. - `int`"
  (^Integer [^MetalIconFactory$FileIcon16 this]
    (-> this (.getIconHeight))))

