(ns jdk.awt.font.ShapeGraphicAttribute
  "The ShapeGraphicAttribute class is an implementation of
  GraphicAttribute that draws shapes in a TextLayout."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font ShapeGraphicAttribute]))

(defn ->shape-graphic-attribute
  "Constructor.

  Constructs a ShapeGraphicAttribute for the specified
   Shape.

  shape - the Shape to render. The Shape is rendered with its origin at the origin of this ShapeGraphicAttribute in the host TextLayout. This object maintains a reference to shape. - `java.awt.Shape`
  alignment - one of the alignments from this ShapeGraphicAttribute. - `int`
  stroke - true if the Shape should be stroked; false if the Shape should be filled. - `boolean`"
  ([^java.awt.Shape shape ^Integer alignment ^Boolean stroke]
    (new ShapeGraphicAttribute shape alignment stroke)))

(def *-stroke
  "Static Constant.

  A key indicating the shape should be stroked with a 1-pixel wide stroke.

  type: boolean"
  ShapeGraphicAttribute/STROKE)

(def *-fill
  "Static Constant.

  A key indicating the shape should be filled.

  type: boolean"
  ShapeGraphicAttribute/FILL)

(defn get-ascent
  "Returns the ascent of this ShapeGraphicAttribute.  The
   ascent of a ShapeGraphicAttribute is the positive
   distance from the origin of its Shape to the top of
   bounds of its Shape.

  returns: the ascent of this ShapeGraphicAttribute. - `float`"
  (^Float [^java.awt.font.ShapeGraphicAttribute this]
    (-> this (.getAscent))))

(defn get-descent
  "Returns the descent of this ShapeGraphicAttribute.
   The descent of a ShapeGraphicAttribute is the distance
   from the origin of its Shape to the bottom of the
   bounds of its Shape.

  returns: the descent of this ShapeGraphicAttribute. - `float`"
  (^Float [^java.awt.font.ShapeGraphicAttribute this]
    (-> this (.getDescent))))

(defn get-advance
  "Returns the advance of this ShapeGraphicAttribute.
   The advance of a ShapeGraphicAttribute is the distance
   from the origin of its Shape to the right side of the
   bounds of its Shape.

  returns: the advance of this ShapeGraphicAttribute. - `float`"
  (^Float [^java.awt.font.ShapeGraphicAttribute this]
    (-> this (.getAdvance))))

(defn draw
  "Renders this GraphicAttribute at the specified
   location.

  graphics - the Graphics2D into which to render the graphic - `java.awt.Graphics2D`
  x - the user-space X coordinate where the graphic is rendered - `float`
  y - the user-space Y coordinate where the graphic is rendered - `float`"
  ([^java.awt.font.ShapeGraphicAttribute this ^java.awt.Graphics2D graphics ^Float x ^Float y]
    (-> this (.draw graphics x y))))

(defn get-bounds
  "Returns a Rectangle2D that encloses all of the
   bits drawn by this ShapeGraphicAttribute relative to
   the rendering position.  A graphic can be rendered beyond its
   origin, ascent, descent, or advance;  but if it does, this method's
   implementation should indicate where the graphic is rendered.

  returns: a Rectangle2D that encloses all of the bits
   rendered by this ShapeGraphicAttribute. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.font.ShapeGraphicAttribute this]
    (-> this (.getBounds))))

(defn get-outline
  "Return a Shape that represents the region that
   this ShapeGraphicAttribute renders.  This is used when a
   TextLayout is requested to return the outline of the text.
   The (untransformed) shape must not extend outside the rectangular
   bounds returned by getBounds.

  tx - an optional AffineTransform to apply to the this ShapeGraphicAttribute. This can be null. - `java.awt.geom.AffineTransform`

  returns: the Shape representing this graphic attribute,
     suitable for stroking or filling. - `java.awt.Shape`"
  (^java.awt.Shape [^java.awt.font.ShapeGraphicAttribute this ^java.awt.geom.AffineTransform tx]
    (-> this (.getOutline tx))))

(defn hash-code
  "Returns a hashcode for this ShapeGraphicAttribute.

  returns: a hash code value for this
   ShapeGraphicAttribute. - `int`"
  (^Integer [^java.awt.font.ShapeGraphicAttribute this]
    (-> this (.hashCode))))

(defn equals
  "Compares this ShapeGraphicAttribute to the specified
   Object.

  rhs - the Object to compare for equality - `java.lang.Object`

  returns: true if this
   ShapeGraphicAttribute equals rhs;
   false otherwise. - `boolean`"
  (^Boolean [^java.awt.font.ShapeGraphicAttribute this ^java.lang.Object rhs]
    (-> this (.equals rhs))))

