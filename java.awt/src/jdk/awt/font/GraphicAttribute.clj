(ns jdk.awt.font.GraphicAttribute
  "This class is used with the CHAR_REPLACEMENT attribute.

  The GraphicAttribute class represents a graphic embedded
  in text. Clients subclass this class to implement their own char
  replacement graphics.  Clients wishing to embed shapes and images in
  text need not subclass this class.  Instead, clients can use the
  ShapeGraphicAttribute and ImageGraphicAttribute
  classes.

  Subclasses must ensure that their objects are immutable once they
  are constructed.  Mutating a GraphicAttribute that
  is used in a TextLayout results in undefined behavior from the
  TextLayout."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.font GraphicAttribute]))

(def *-top-alignment
  "Static Constant.

  Aligns top of graphic to top of line.

  type: int"
  GraphicAttribute/TOP_ALIGNMENT)

(def *-bottom-alignment
  "Static Constant.

  Aligns bottom of graphic to bottom of line.

  type: int"
  GraphicAttribute/BOTTOM_ALIGNMENT)

(def *-roman-baseline
  "Static Constant.

  Aligns origin of graphic to roman baseline of line.

  type: int"
  GraphicAttribute/ROMAN_BASELINE)

(def *-center-baseline
  "Static Constant.

  Aligns origin of graphic to center baseline of line.

  type: int"
  GraphicAttribute/CENTER_BASELINE)

(def *-hanging-baseline
  "Static Constant.

  Aligns origin of graphic to hanging baseline of line.

  type: int"
  GraphicAttribute/HANGING_BASELINE)

(defn get-ascent
  "Returns the ascent of this GraphicAttribute.  A
   graphic can be rendered above its ascent.

  returns: the ascent of this GraphicAttribute. - `float`"
  (^Float [^GraphicAttribute this]
    (-> this (.getAscent))))

(defn get-descent
  "Returns the descent of this GraphicAttribute.  A
   graphic can be rendered below its descent.

  returns: the descent of this GraphicAttribute. - `float`"
  (^Float [^GraphicAttribute this]
    (-> this (.getDescent))))

(defn get-advance
  "Returns the advance of this GraphicAttribute.  The
   GraphicAttribute object's advance is the distance
   from the point at which the graphic is rendered and the point where
   the next character or graphic is rendered.  A graphic can be
   rendered beyond its advance

  returns: the advance of this GraphicAttribute. - `float`"
  (^Float [^GraphicAttribute this]
    (-> this (.getAdvance))))

(defn get-bounds
  "Returns a Rectangle2D that encloses all of the
   bits drawn by this GraphicAttribute relative to the
   rendering position.
   A graphic may be rendered beyond its origin, ascent, descent,
   or advance;  but if it is, this method's implementation must
   indicate where the graphic is rendered.
   Default bounds is the rectangle (0, -ascent, advance, ascent+descent).

  returns: a Rectangle2D that encloses all of the bits
   rendered by this GraphicAttribute. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^GraphicAttribute this]
    (-> this (.getBounds))))

(defn get-outline
  "Return a Shape that represents the region that
   this GraphicAttribute renders.  This is used when a
   TextLayout is requested to return the outline of the text.
   The (untransformed) shape must not extend outside the rectangular
   bounds returned by getBounds.
   The default implementation returns the rectangle returned by
   getBounds(), transformed by the provided AffineTransform
   if present.

  tx - an optional AffineTransform to apply to the outline of this GraphicAttribute. This can be null. - `java.awt.geom.AffineTransform`

  returns: a Shape representing this graphic attribute,
     suitable for stroking or filling. - `java.awt.Shape`"
  (^java.awt.Shape [^GraphicAttribute this ^java.awt.geom.AffineTransform tx]
    (-> this (.getOutline tx))))

(defn draw
  "Renders this GraphicAttribute at the specified
   location.

  graphics - the Graphics2D into which to render the graphic - `java.awt.Graphics2D`
  x - the user-space X coordinate where the graphic is rendered - `float`
  y - the user-space Y coordinate where the graphic is rendered - `float`"
  ([^GraphicAttribute this ^java.awt.Graphics2D graphics ^Float x ^Float y]
    (-> this (.draw graphics x y))))

(defn get-alignment
  "Returns the alignment of this GraphicAttribute.
   Alignment can be to a particular baseline, or to the absolute top
   or bottom of a line.

  returns: the alignment of this GraphicAttribute. - `int`"
  (^Integer [^GraphicAttribute this]
    (-> this (.getAlignment))))

(defn get-justification-info
  "Returns the justification information for this
   GraphicAttribute.  Subclasses
   can override this method to provide different justification
   information.

  returns: a GlyphJustificationInfo object that contains the
   justification information for this GraphicAttribute. - `java.awt.font.GlyphJustificationInfo`"
  (^java.awt.font.GlyphJustificationInfo [^GraphicAttribute this]
    (-> this (.getJustificationInfo))))

