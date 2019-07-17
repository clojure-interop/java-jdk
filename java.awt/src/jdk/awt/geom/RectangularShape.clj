(ns jdk.awt.geom.RectangularShape
  "RectangularShape is the base class for a number of
  Shape objects whose geometry is defined by a rectangular frame.
  This class does not directly specify any specific geometry by
  itself, but merely provides manipulation methods inherited by
  a whole category of Shape objects.
  The manipulation methods provided by this class can be used to
  query and modify the rectangular frame, which provides a reference
  for the subclasses to define their geometry."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom RectangularShape]))

(defn get-max-y
  "Returns the largest Y coordinate of the framing
   rectangle of the Shape in double
   precision.

  returns: the largest Y coordinate of the framing
            rectangle of the Shape. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getMaxY))))

(defn get-center-x
  "Returns the X coordinate of the center of the framing
   rectangle of the Shape in double
   precision.

  returns: the X coordinate of the center of the framing rectangle
            of the Shape. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getCenterX))))

(defn set-frame-from-diagonal
  "Sets the diagonal of the framing rectangle of this Shape
   based on the two specified coordinates.  The framing rectangle is
   used by the subclasses of RectangularShape to define
   their geometry.

  x-1 - the X coordinate of the start point of the specified diagonal - `double`
  y-1 - the Y coordinate of the start point of the specified diagonal - `double`
  x-2 - the X coordinate of the end point of the specified diagonal - `double`
  y-2 - the Y coordinate of the end point of the specified diagonal - `double`"
  ([^java.awt.geom.RectangularShape this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.setFrameFromDiagonal x-1 y-1 x-2 y-2)))
  ([^java.awt.geom.RectangularShape this ^java.awt.geom.Point2D p-1 ^java.awt.geom.Point2D p-2]
    (-> this (.setFrameFromDiagonal p-1 p-2))))

(defn get-width
  "Returns the width of the framing rectangle in
   double precision.

  returns: the width of the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getWidth))))

(defn get-path-iterator
  "Returns an iterator object that iterates along the
   Shape object's boundary and provides access to a
   flattened view of the outline of the Shape
   object's geometry.

   Only SEG_MOVETO, SEG_LINETO, and SEG_CLOSE point types will
   be returned by the iterator.

   The amount of subdivision of the curved segments is controlled
   by the flatness parameter, which specifies the
   maximum distance that any point on the unflattened transformed
   curve can deviate from the returned flattened path segments.
   An optional AffineTransform can
   be specified so that the coordinates returned in the iteration are
   transformed accordingly.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired. - `java.awt.geom.AffineTransform`
  flatness - the maximum distance that the line segments used to approximate the curved segments are allowed to deviate from any point on the original curve - `double`

  returns: a PathIterator object that provides access to
            the Shape object's flattened geometry. - `java.awt.geom.PathIterator`"
  (^java.awt.geom.PathIterator [^java.awt.geom.RectangularShape this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness))))

(defn get-frame
  "Returns the framing Rectangle2D
   that defines the overall shape of this object.

  returns: a Rectangle2D, specified in
   double coordinates. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.geom.RectangularShape this]
    (-> this (.getFrame))))

(defn get-max-x
  "Returns the largest X coordinate of the framing
   rectangle of the Shape in double
   precision.

  returns: the largest X coordinate of the framing
            rectangle of the Shape. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getMaxX))))

(defn contains
  "Tests if a specified Point2D is inside the boundary
   of the Shape, as described by the

   definition of insideness.

  p - the specified Point2D to be tested - `java.awt.geom.Point2D`

  returns: true if the specified Point2D is
            inside the boundary of the Shape;
            false otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.RectangularShape this ^java.awt.geom.Point2D p]
    (-> this (.contains p))))

(defn get-min-y
  "Returns the smallest Y coordinate of the framing
   rectangle of the Shape in double
   precision.

  returns: the smallest Y coordinate of the framing
            rectangle of the Shape. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getMinY))))

(defn get-center-y
  "Returns the Y coordinate of the center of the framing
   rectangle of the Shape in double
   precision.

  returns: the Y coordinate of the center of the framing rectangle
            of the Shape. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getCenterY))))

(defn get-y
  "Returns the Y coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the Y coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getY))))

(defn get-x
  "Returns the X coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the X coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getX))))

(defn get-height
  "Returns the height of the framing rectangle
   in double precision.

  returns: the height of the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getHeight))))

(defn set-frame-from-center
  "Sets the framing rectangle of this Shape
   based on the specified center point coordinates and corner point
   coordinates.  The framing rectangle is used by the subclasses of
   RectangularShape to define their geometry.

  center-x - the X coordinate of the specified center point - `double`
  center-y - the Y coordinate of the specified center point - `double`
  corner-x - the X coordinate of the specified corner point - `double`
  corner-y - the Y coordinate of the specified corner point - `double`"
  ([^java.awt.geom.RectangularShape this ^Double center-x ^Double center-y ^Double corner-x ^Double corner-y]
    (-> this (.setFrameFromCenter center-x center-y corner-x corner-y)))
  ([^java.awt.geom.RectangularShape this ^java.awt.geom.Point2D center ^java.awt.geom.Point2D corner]
    (-> this (.setFrameFromCenter center corner))))

(defn clone
  "Creates a new object of the same class and with the same
   contents as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  (^java.lang.Object [^java.awt.geom.RectangularShape this]
    (-> this (.clone))))

(defn get-bounds
  "Returns an integer Rectangle that completely encloses the
   Shape.  Note that there is no guarantee that the
   returned Rectangle is the smallest bounding box that
   encloses the Shape, only that the Shape
   lies entirely within the indicated  Rectangle.  The
   returned Rectangle might also fail to completely
   enclose the Shape if the Shape overflows
   the limited range of the integer data type.  The
   getBounds2D method generally returns a
   tighter bounding box due to its greater flexibility in
   representation.


   Note that the
   definition of insideness can lead to situations where points
   on the defining outline of the shape may not be considered
   contained in the returned bounds object, but only in cases
   where those points are also not considered contained in the original
   shape.


   If a point is inside the shape according to the
   contains(point) method, then
   it must be inside the returned Rectangle bounds object
   according to the contains(point)
   method of the bounds. Specifically:


    shape.contains(x,y) requires bounds.contains(x,y)


   If a point is not inside the shape, then it might
   still be contained in the bounds object:


    bounds.contains(x,y) does not imply shape.contains(x,y)

  returns: an integer Rectangle that completely encloses
                   the Shape. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^java.awt.geom.RectangularShape this]
    (-> this (.getBounds))))

(defn get-min-x
  "Returns the smallest X coordinate of the framing
   rectangle of the Shape in double
   precision.

  returns: the smallest X coordinate of the framing
            rectangle of the Shape. - `double`"
  (^Double [^java.awt.geom.RectangularShape this]
    (-> this (.getMinX))))

(defn empty?
  "Determines whether the RectangularShape is empty.
   When the RectangularShape is empty, it encloses no
   area.

  returns: true if the RectangularShape is empty;
            false otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.RectangularShape this]
    (-> this (.isEmpty))))

(defn set-frame
  "Sets the location and size of the framing rectangle of this
   Shape to the specified rectangular values.

  x - the X coordinate of the upper-left corner of the specified rectangular shape - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular shape - `double`
  w - the width of the specified rectangular shape - `double`
  h - the height of the specified rectangular shape - `double`"
  ([^java.awt.geom.RectangularShape this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.setFrame x y w h)))
  ([^java.awt.geom.RectangularShape this ^java.awt.geom.Point2D loc ^java.awt.geom.Dimension2D size]
    (-> this (.setFrame loc size)))
  ([^java.awt.geom.RectangularShape this ^java.awt.geom.Rectangle2D r]
    (-> this (.setFrame r))))

(defn intersects
  "Tests if the interior of the Shape intersects the
   interior of a specified Rectangle2D.
   The Shape.intersects() method allows a Shape
   implementation to conservatively return true when:


   there is a high probability that the Rectangle2D and the
   Shape intersect, but

   the calculations to accurately determine this intersection
   are prohibitively expensive.

   This means that for some Shapes this method might
   return true even though the Rectangle2D does not
   intersect the Shape.
   The Area class performs
   more accurate computations of geometric intersection than most
   Shape objects and therefore can be used if a more precise
   answer is required.

  r - the specified Rectangle2D - `java.awt.geom.Rectangle2D`

  returns: true if the interior of the Shape and
            the interior of the specified Rectangle2D
            intersect, or are both highly likely to intersect and intersection
            calculations would be too expensive to perform; false
            otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.RectangularShape this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

