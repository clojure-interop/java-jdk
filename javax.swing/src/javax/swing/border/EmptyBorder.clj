(ns javax.swing.border.EmptyBorder
  "A class which provides an empty, transparent border which
  takes up space but does no drawing.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border EmptyBorder]))

(defn ->empty-border
  "Constructor.

  Creates an empty border with the specified insets.

  top - the top inset of the border - `int`
  left - the left inset of the border - `int`
  bottom - the bottom inset of the border - `int`
  right - the right inset of the border - `int`"
  ([^Integer top ^Integer left ^Integer bottom ^Integer right]
    (new EmptyBorder top left bottom right))
  ([^java.awt.Insets border-insets]
    (new EmptyBorder border-insets)))

(defn paint-border
  "Does no drawing by default.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`"
  ([^javax.swing.border.EmptyBorder this ^java.awt.Component c ^java.awt.Graphics g ^Integer x ^Integer y ^Integer width ^Integer height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitialize the insets parameter with this Border's current Insets.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the object to be reinitialized - `java.awt.Insets`

  returns: the insets object - `java.awt.Insets`"
  (^java.awt.Insets [^javax.swing.border.EmptyBorder this ^java.awt.Component c ^java.awt.Insets insets]
    (-> this (.getBorderInsets c insets)))
  (^java.awt.Insets [^javax.swing.border.EmptyBorder this]
    (-> this (.getBorderInsets))))

(defn border-opaque?
  "Returns whether or not the border is opaque.
   Returns false by default.

  returns: false - `boolean`"
  (^Boolean [^javax.swing.border.EmptyBorder this]
    (-> this (.isBorderOpaque))))

