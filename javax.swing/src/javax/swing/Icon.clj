(ns javax.swing.Icon
  "A small fixed size picture, typically used to decorate components."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing Icon]))

(defn paint-icon
  "Draw the icon at the specified location.  Icon implementations
   may use the Component argument to get properties useful for
   painting, e.g. the foreground or background color.

  c - `java.awt.Component`
  g - `java.awt.Graphics`
  x - `int`
  y - `int`"
  ([this c g x y]
    (-> this (.paintIcon c g x y))))

(defn get-icon-width
  "Returns the icon's width.

  returns: an int specifying the fixed width of the icon. - `int`"
  ([this]
    (-> this (.getIconWidth))))

(defn get-icon-height
  "Returns the icon's height.

  returns: an int specifying the fixed height of the icon. - `int`"
  ([this]
    (-> this (.getIconHeight))))

