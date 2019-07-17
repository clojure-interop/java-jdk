(ns javax.swing.border.LineBorder
  "A class which implements a line border of arbitrary thickness
  and of a single color.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border LineBorder]))

(defn ->line-border
  "Constructor.

  Creates a line border with the specified color, thickness,
   and corner shape.

  color - the color of the border - `java.awt.Color`
  thickness - the thickness of the border - `int`
  rounded-corners - whether or not border corners should be round - `boolean`"
  ([^java.awt.Color color ^Integer thickness ^Boolean rounded-corners]
    (new LineBorder color thickness rounded-corners))
  ([^java.awt.Color color ^Integer thickness]
    (new LineBorder color thickness))
  ([^java.awt.Color color]
    (new LineBorder color)))

(defn *create-black-line-border
  "Convenience method for getting the Color.black LineBorder of thickness 1.

  returns: `javax.swing.border.Border`"
  ([]
    (LineBorder/createBlackLineBorder )))

(defn *create-gray-line-border
  "Convenience method for getting the Color.gray LineBorder of thickness 1.

  returns: `javax.swing.border.Border`"
  ([]
    (LineBorder/createGrayLineBorder )))

(defn paint-border
  "Paints the border for the specified component with the
   specified position and size.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.border.LineBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitialize the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  ([^javax.swing.border.LineBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets))))

(defn get-line-color
  "Returns the color of the border.

  returns: `java.awt.Color`"
  ([^javax.swing.border.LineBorder this]
    (-> this (.getLineColor))))

(defn get-thickness
  "Returns the thickness of the border.

  returns: `int`"
  ([^javax.swing.border.LineBorder this]
    (-> this (.getThickness))))

(defn get-rounded-corners?
  "Returns whether this border will be drawn with rounded corners.

  returns: `boolean`"
  ([^javax.swing.border.LineBorder this]
    (-> this (.getRoundedCorners))))

(defn border-opaque?
  "Returns whether or not the border is opaque.

  returns: false - `boolean`"
  ([^javax.swing.border.LineBorder this]
    (-> this (.isBorderOpaque))))

