(ns jdk.awt.Stroke
  "The Stroke interface allows a
  Graphics2D object to obtain a Shape that is the
  decorated outline, or stylistic representation of the outline,
  of the specified Shape.
  Stroking a Shape is like tracing its outline with a
  marking pen of the appropriate size and shape.
  The area where the pen would place ink is the area enclosed by the
  outline Shape.

  The methods of the Graphics2D interface that use the
  outline Shape returned by a Stroke object
  include draw and any other methods that are
  implemented in terms of that method, such as
  drawLine, drawRect,
  drawRoundRect, drawOval,
  drawArc, drawPolyline,
  and drawPolygon.

  The objects of the classes implementing Stroke
  must be read-only because Graphics2D does not
  clone these objects either when they are set as an attribute
  with the setStroke method or when the
  Graphics2D object is itself cloned.
  If a Stroke object is modified after it is set in
  the Graphics2D context then the behavior
  of subsequent rendering would be undefined."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Stroke]))

(defn create-stroked-shape
  "Returns an outline Shape which encloses the area that
   should be painted when the Shape is stroked according
   to the rules defined by the
   object implementing the Stroke interface.

  p - a Shape to be stroked - `java.awt.Shape`

  returns: the stroked outline Shape. - `java.awt.Shape`"
  (^java.awt.Shape [^java.awt.Stroke this ^java.awt.Shape p]
    (-> this (.createStrokedShape p))))

