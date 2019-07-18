(ns javax.swing.plaf.metal.MetalIconFactory$PaletteCloseIcon
  "Defines an icon for Palette close"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.metal MetalIconFactory$PaletteCloseIcon]))

(defn ->palette-close-icon
  "Constructor."
  (^MetalIconFactory$PaletteCloseIcon []
    (new MetalIconFactory$PaletteCloseIcon )))

(defn paint-icon
  "Description copied from interface: Icon

  c - `java.awt.Component`
  g - `java.awt.Graphics`
  x - `int`
  y - `int`"
  ([^MetalIconFactory$PaletteCloseIcon this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y]
    (-> this (.paintIcon c g x y))))

(defn get-icon-width
  "Description copied from interface: Icon

  returns: an int specifying the fixed width of the icon. - `int`"
  (^Integer [^MetalIconFactory$PaletteCloseIcon this]
    (-> this (.getIconWidth))))

(defn get-icon-height
  "Description copied from interface: Icon

  returns: an int specifying the fixed height of the icon. - `int`"
  (^Integer [^MetalIconFactory$PaletteCloseIcon this]
    (-> this (.getIconHeight))))

