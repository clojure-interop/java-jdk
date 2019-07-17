(ns javax.swing.border.SoftBevelBorder
  "A class which implements a raised or lowered bevel with
  softened corners.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border SoftBevelBorder]))

(defn ->soft-bevel-border
  "Constructor.

  Creates a bevel border with the specified type, highlight
   shadow colors.

  bevel-type - the type of bevel for the border - `int`
  highlight-outer-color - the color to use for the bevel outer highlight - `java.awt.Color`
  highlight-inner-color - the color to use for the bevel inner highlight - `java.awt.Color`
  shadow-outer-color - the color to use for the bevel outer shadow - `java.awt.Color`
  shadow-inner-color - the color to use for the bevel inner shadow - `java.awt.Color`"
  ([bevel-type highlight-outer-color highlight-inner-color shadow-outer-color shadow-inner-color]
    (new SoftBevelBorder bevel-type highlight-outer-color highlight-inner-color shadow-outer-color shadow-inner-color))
  ([bevel-type highlight shadow]
    (new SoftBevelBorder bevel-type highlight shadow))
  ([bevel-type]
    (new SoftBevelBorder bevel-type)))

(defn paint-border
  "Paints the border for the specified component with the specified
   position and size.

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
    (-> this (.getBorderInsets c insets))))

(defn border-opaque?
  "Returns whether or not the border is opaque.

  returns: false - `boolean`"
  ([this]
    (-> this (.isBorderOpaque))))

