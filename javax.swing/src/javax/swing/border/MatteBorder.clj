(ns javax.swing.border.MatteBorder
  "A class which provides a matte-like border of either a solid color
  or a tiled icon.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border MatteBorder]))

(defn ->matte-border
  "Constructor.

  Creates a matte border with the specified insets and color.

  top - the top inset of the border - `int`
  left - the left inset of the border - `int`
  bottom - the bottom inset of the border - `int`
  right - the right inset of the border - `int`
  matte-color - the color rendered for the border - `java.awt.Color`"
  ([top left bottom right matte-color]
    (new MatteBorder top left bottom right matte-color))
  ([border-insets matte-color]
    (new MatteBorder border-insets matte-color))
  ([tile-icon]
    (new MatteBorder tile-icon)))

(defn paint-border
  "Paints the matte border.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([this c g x y width height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitialize the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  ([this c insets]
    (-> this (.getBorderInsets c insets)))
  ([this]
    (-> this (.getBorderInsets))))

(defn get-matte-color
  "Returns the color used for tiling the border or null
   if a tile icon is being used.

  returns: `java.awt.Color`"
  ([this]
    (-> this (.getMatteColor))))

(defn get-tile-icon
  "Returns the icon used for tiling the border or null
   if a solid color is being used.

  returns: `javax.swing.Icon`"
  ([this]
    (-> this (.getTileIcon))))

(defn border-opaque?
  "Returns whether or not the border is opaque.

  returns: false - `boolean`"
  ([this]
    (-> this (.isBorderOpaque))))

