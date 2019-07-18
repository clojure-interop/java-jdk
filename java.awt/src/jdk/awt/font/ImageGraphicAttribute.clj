(ns jdk.awt.font.ImageGraphicAttribute
  "The ImageGraphicAttribute class is an implementation of
  GraphicAttribute which draws images in
  a TextLayout."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font ImageGraphicAttribute]))

(defn ->image-graphic-attribute
  "Constructor.

  Constructs an ImageGraphicAttribute from the specified
   Image. The point
   (originX, originY) in the
   Image appears at the origin of the
   ImageGraphicAttribute within the text.

  image - the Image rendered by this ImageGraphicAttribute. This object keeps a reference to image. - `java.awt.Image`
  alignment - one of the alignments from this ImageGraphicAttribute - `int`
  origin-x - the X coordinate of the point within the Image that appears at the origin of the ImageGraphicAttribute in the text line. - `float`
  origin-y - the Y coordinate of the point within the Image that appears at the origin of the ImageGraphicAttribute in the text line. - `float`"
  (^ImageGraphicAttribute [^java.awt.Image image ^Integer alignment ^Float origin-x ^Float origin-y]
    (new ImageGraphicAttribute image alignment origin-x origin-y))
  (^ImageGraphicAttribute [^java.awt.Image image ^Integer alignment]
    (new ImageGraphicAttribute image alignment)))

(defn get-ascent
  "Returns the ascent of this ImageGraphicAttribute.  The
   ascent of an ImageGraphicAttribute is the distance
   from the top of the image to the origin.

  returns: the ascent of this ImageGraphicAttribute. - `float`"
  (^Float [^ImageGraphicAttribute this]
    (-> this (.getAscent))))

(defn get-descent
  "Returns the descent of this ImageGraphicAttribute.
   The descent of an ImageGraphicAttribute is the
   distance from the origin to the bottom of the image.

  returns: the descent of this ImageGraphicAttribute. - `float`"
  (^Float [^ImageGraphicAttribute this]
    (-> this (.getDescent))))

(defn get-advance
  "Returns the advance of this ImageGraphicAttribute.
   The advance of an ImageGraphicAttribute is the
   distance from the origin to the right edge of the image.

  returns: the advance of this ImageGraphicAttribute. - `float`"
  (^Float [^ImageGraphicAttribute this]
    (-> this (.getAdvance))))

(defn get-bounds
  "Returns a Rectangle2D that encloses all of the
   bits rendered by this ImageGraphicAttribute, relative
   to the rendering position.  A graphic can be rendered beyond its
   origin, ascent, descent, or advance;  but if it is, this
   method's implementation must indicate where the graphic is rendered.

  returns: a Rectangle2D that encloses all of the bits
   rendered by this ImageGraphicAttribute. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^ImageGraphicAttribute this]
    (-> this (.getBounds))))

(defn draw
  "Renders this GraphicAttribute at the specified
   location.

  graphics - the Graphics2D into which to render the graphic - `java.awt.Graphics2D`
  x - the user-space X coordinate where the graphic is rendered - `float`
  y - the user-space Y coordinate where the graphic is rendered - `float`"
  ([^ImageGraphicAttribute this ^java.awt.Graphics2D graphics ^Float x ^Float y]
    (-> this (.draw graphics x y))))

(defn hash-code
  "Returns a hashcode for this ImageGraphicAttribute.

  returns: a hash code value for this object. - `int`"
  (^Integer [^ImageGraphicAttribute this]
    (-> this (.hashCode))))

(defn equals
  "Compares this ImageGraphicAttribute to the specified
   Object.

  rhs - the Object to compare for equality - `java.lang.Object`

  returns: true if this
   ImageGraphicAttribute equals rhs;
   false otherwise. - `boolean`"
  (^Boolean [^ImageGraphicAttribute this ^java.lang.Object rhs]
    (-> this (.equals rhs))))

