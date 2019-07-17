(ns javax.swing.border.StrokeBorder
  "A class which implements a border of an arbitrary stroke.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI
  between applications running the same version of Swing.
  As of 1.4, support for long term storage of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.border StrokeBorder]))

(defn ->stroke-border
  "Constructor.

  Creates a border of the specified stroke and paint.
   If the specified paint is null,
   the component's foreground color will be used to render the border.

  stroke - the BasicStroke object used to stroke a shape - `java.awt.BasicStroke`
  paint - the Paint object used to generate a color - `java.awt.Paint`

  throws: java.lang.NullPointerException - if the specified stroke is null"
  ([stroke paint]
    (new StrokeBorder stroke paint))
  ([stroke]
    (new StrokeBorder stroke)))

(defn paint-border
  "Paints the border for the specified component
   with the specified position and size.
   If the border was not specified with a Paint object,
   the component's foreground color will be used to render the border.
   If the component's foreground color is not available,
   the default color of the Graphics object will be used.

  c - the component for which this border is being painted - `java.awt.Component`
  g - the paint graphics - `java.awt.Graphics`
  x - the x position of the painted border - `int`
  y - the y position of the painted border - `int`
  width - the width of the painted border - `int`
  height - the height of the painted border - `int`

  throws: java.lang.NullPointerException - if the specified g is null"
  ([this c g x y width height]
    (-> this (.paintBorder c g x y width height))))

(defn get-border-insets
  "Reinitializes the insets parameter
   with this border's current insets.
   Every inset is the smallest (closest to negative infinity) integer value
   that is greater than or equal to the line width of the stroke
   that is used to paint the border.

  c - the component for which this border insets value applies - `java.awt.Component`
  insets - the Insets object to be reinitialized - `java.awt.Insets`

  returns: the reinitialized insets parameter - `java.awt.Insets`

  throws: java.lang.NullPointerException - if the specified insets is null"
  ([this c insets]
    (-> this (.getBorderInsets c insets))))

(defn get-stroke
  "Returns the BasicStroke object used to stroke a shape
   during the border rendering.

  returns: the BasicStroke object - `java.awt.BasicStroke`"
  ([this]
    (-> this (.getStroke))))

(defn get-paint
  "Returns the Paint object used to generate a color
   during the border rendering.

  returns: the Paint object or null
           if the paint parameter is not set - `java.awt.Paint`"
  ([this]
    (-> this (.getPaint))))

