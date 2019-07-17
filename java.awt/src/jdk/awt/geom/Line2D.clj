(ns jdk.awt.geom.Line2D
  "This Line2D represents a line segment in (x,y)
  coordinate space.  This class, like all of the Java 2D API, uses a
  default coordinate system called user space in which the y-axis
  values increase downward and x-axis values increase to the right.  For
  more information on the user space coordinate system, see the

  Coordinate Systems section of the Java 2D Programmer's Guide.

  This class is only the abstract superclass for all objects that
  store a 2D line segment.
  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Line2D]))

(defn *relative-ccw
  "Returns an indicator of where the specified point
   (px,py) lies with respect to the line segment from
   (x1,y1) to (x2,y2).
   The return value can be either 1, -1, or 0 and indicates
   in which direction the specified line must pivot around its
   first end point, (x1,y1), in order to point at the
   specified point (px,py).
   A return value of 1 indicates that the line segment must
   turn in the direction that takes the positive X axis towards
   the negative Y axis.  In the default coordinate system used by
   Java 2D, this direction is counterclockwise.
   A return value of -1 indicates that the line segment must
   turn in the direction that takes the positive X axis towards
   the positive Y axis.  In the default coordinate system, this
   direction is clockwise.
   A return value of 0 indicates that the point lies
   exactly on the line segment.  Note that an indicator value
   of 0 is rare and not useful for determining collinearity
   because of floating point rounding issues.
   If the point is colinear with the line segment, but
   not between the end points, then the value will be -1 if the point
   lies `beyond (x1,y1)` or 1 if the point lies
   `beyond (x2,y2)`.

  x-1 - the X coordinate of the start point of the specified line segment - `double`
  y-1 - the Y coordinate of the start point of the specified line segment - `double`
  x-2 - the X coordinate of the end point of the specified line segment - `double`
  y-2 - the Y coordinate of the end point of the specified line segment - `double`
  px - the X coordinate of the specified point to be compared with the specified line segment - `double`
  py - the Y coordinate of the specified point to be compared with the specified line segment - `double`

  returns: an integer that indicates the position of the third specified
                    coordinates with respect to the line segment formed
                    by the first two specified coordinates. - `int`"
  (^Integer [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double px ^Double py]
    (Line2D/relativeCCW x-1 y-1 x-2 y-2 px py)))

(defn *lines-intersect
  "Tests if the line segment from (x1,y1) to
   (x2,y2) intersects the line segment from (x3,y3)
   to (x4,y4).

  x-1 - the X coordinate of the start point of the first specified line segment - `double`
  y-1 - the Y coordinate of the start point of the first specified line segment - `double`
  x-2 - the X coordinate of the end point of the first specified line segment - `double`
  y-2 - the Y coordinate of the end point of the first specified line segment - `double`
  x-3 - the X coordinate of the start point of the second specified line segment - `double`
  y-3 - the Y coordinate of the start point of the second specified line segment - `double`
  x-4 - the X coordinate of the end point of the second specified line segment - `double`
  y-4 - the Y coordinate of the end point of the second specified line segment - `double`

  returns: true if the first specified line segment
                    and the second specified line segment intersect
                    each other; false otherwise. - `boolean`"
  (^Boolean [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double x-3 ^Double y-3 ^Double x-4 ^Double y-4]
    (Line2D/linesIntersect x-1 y-1 x-2 y-2 x-3 y-3 x-4 y-4)))

(defn *pt-seg-dist-sq
  "Returns the square of the distance from a point to a line segment.
   The distance measured is the distance between the specified
   point and the closest point between the specified end points.
   If the specified point intersects the line segment in between the
   end points, this method returns 0.0.

  x-1 - the X coordinate of the start point of the specified line segment - `double`
  y-1 - the Y coordinate of the start point of the specified line segment - `double`
  x-2 - the X coordinate of the end point of the specified line segment - `double`
  y-2 - the Y coordinate of the end point of the specified line segment - `double`
  px - the X coordinate of the specified point being measured against the specified line segment - `double`
  py - the Y coordinate of the specified point being measured against the specified line segment - `double`

  returns: a double value that is the square of the distance from the
                    specified point to the specified line segment. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double px ^Double py]
    (Line2D/ptSegDistSq x-1 y-1 x-2 y-2 px py)))

(defn *pt-seg-dist
  "Returns the distance from a point to a line segment.
   The distance measured is the distance between the specified
   point and the closest point between the specified end points.
   If the specified point intersects the line segment in between the
   end points, this method returns 0.0.

  x-1 - the X coordinate of the start point of the specified line segment - `double`
  y-1 - the Y coordinate of the start point of the specified line segment - `double`
  x-2 - the X coordinate of the end point of the specified line segment - `double`
  y-2 - the Y coordinate of the end point of the specified line segment - `double`
  px - the X coordinate of the specified point being measured against the specified line segment - `double`
  py - the Y coordinate of the specified point being measured against the specified line segment - `double`

  returns: a double value that is the distance from the specified point
                            to the specified line segment. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double px ^Double py]
    (Line2D/ptSegDist x-1 y-1 x-2 y-2 px py)))

(defn *pt-line-dist-sq
  "Returns the square of the distance from a point to a line.
   The distance measured is the distance between the specified
   point and the closest point on the infinitely-extended line
   defined by the specified coordinates.  If the specified point
   intersects the line, this method returns 0.0.

  x-1 - the X coordinate of the start point of the specified line - `double`
  y-1 - the Y coordinate of the start point of the specified line - `double`
  x-2 - the X coordinate of the end point of the specified line - `double`
  y-2 - the Y coordinate of the end point of the specified line - `double`
  px - the X coordinate of the specified point being measured against the specified line - `double`
  py - the Y coordinate of the specified point being measured against the specified line - `double`

  returns: a double value that is the square of the distance from the
                    specified point to the specified line. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double px ^Double py]
    (Line2D/ptLineDistSq x-1 y-1 x-2 y-2 px py)))

(defn *pt-line-dist
  "Returns the distance from a point to a line.
   The distance measured is the distance between the specified
   point and the closest point on the infinitely-extended line
   defined by the specified coordinates.  If the specified point
   intersects the line, this method returns 0.0.

  x-1 - the X coordinate of the start point of the specified line - `double`
  y-1 - the Y coordinate of the start point of the specified line - `double`
  x-2 - the X coordinate of the end point of the specified line - `double`
  y-2 - the Y coordinate of the end point of the specified line - `double`
  px - the X coordinate of the specified point being measured against the specified line - `double`
  py - the Y coordinate of the specified point being measured against the specified line - `double`

  returns: a double value that is the distance from the specified
                     point to the specified line. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double px ^Double py]
    (Line2D/ptLineDist x-1 y-1 x-2 y-2 px py)))

(defn get-x-1
  "Returns the X coordinate of the start point in double precision.

  returns: the X coordinate of the start point of this
           Line2D object. - `double`"
  (^Double [^java.awt.geom.Line2D this]
    (-> this (.getX1))))

(defn get-path-iterator
  "Returns an iteration object that defines the boundary of this
   flattened Line2D.
   The iterator for this class is not multi-threaded safe,
   which means that this Line2D class does not
   guarantee that modifications to the geometry of this
   Line2D object do not affect any iterations of that
   geometry that are already in process.

  at - the specified AffineTransform - `java.awt.geom.AffineTransform`
  flatness - the maximum amount that the control points for a given curve can vary from colinear before a subdivided curve is replaced by a straight line connecting the end points. Since a Line2D object is always flat, this parameter is ignored. - `double`

  returns: a PathIterator that defines the boundary of the
                    flattened Line2D - `java.awt.geom.PathIterator`"
  (^java.awt.geom.PathIterator [^java.awt.geom.Line2D this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness)))
  (^java.awt.geom.PathIterator [^java.awt.geom.Line2D this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn get-p-1
  "Returns the start Point2D of this Line2D.

  returns: the start Point2D of this Line2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.Line2D this]
    (-> this (.getP1))))

(defn intersects-line
  "Tests if the line segment from (x1,y1) to
   (x2,y2) intersects this line segment.

  x-1 - the X coordinate of the start point of the specified line segment - `double`
  y-1 - the Y coordinate of the start point of the specified line segment - `double`
  x-2 - the X coordinate of the end point of the specified line segment - `double`
  y-2 - the Y coordinate of the end point of the specified line segment - `double`

  returns: <true> if this line segment and the specified line segment
                    intersect each other; false otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.Line2D this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.intersectsLine x-1 y-1 x-2 y-2)))
  (^Boolean [^java.awt.geom.Line2D this ^java.awt.geom.Line2D l]
    (-> this (.intersectsLine l))))

(defn contains
  "Tests if the interior of this Line2D entirely contains
   the specified set of rectangular coordinates.
   This method is required to implement the Shape interface,
   but in the case of Line2D objects it always returns
   false since a line contains no area.

  x - the X coordinate of the upper-left corner of the specified rectangular area - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular area - `double`
  w - the width of the specified rectangular area - `double`
  h - the height of the specified rectangular area - `double`

  returns: false because a Line2D contains
   no area. - `boolean`"
  (^Boolean [^java.awt.geom.Line2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  (^Boolean [^java.awt.geom.Line2D this ^Double x ^Double y]
    (-> this (.contains x y)))
  (^Boolean [^java.awt.geom.Line2D this ^java.awt.geom.Point2D p]
    (-> this (.contains p))))

(defn pt-line-dist
  "Returns the distance from a point to this line.
   The distance measured is the distance between the specified
   point and the closest point on the infinitely-extended line
   defined by this Line2D.  If the specified point
   intersects the line, this method returns 0.0.

  px - the X coordinate of the specified point being measured against this line - `double`
  py - the Y coordinate of the specified point being measured against this line - `double`

  returns: a double value that is the distance from a specified point
                    to the current line. - `double`"
  (^Double [^java.awt.geom.Line2D this ^Double px ^Double py]
    (-> this (.ptLineDist px py)))
  (^Double [^java.awt.geom.Line2D this ^java.awt.geom.Point2D pt]
    (-> this (.ptLineDist pt))))

(defn pt-line-dist-sq
  "Returns the square of the distance from a point to this line.
   The distance measured is the distance between the specified
   point and the closest point on the infinitely-extended line
   defined by this Line2D.  If the specified point
   intersects the line, this method returns 0.0.

  px - the X coordinate of the specified point being measured against this line - `double`
  py - the Y coordinate of the specified point being measured against this line - `double`

  returns: a double value that is the square of the distance from a
                    specified point to the current line. - `double`"
  (^Double [^java.awt.geom.Line2D this ^Double px ^Double py]
    (-> this (.ptLineDistSq px py)))
  (^Double [^java.awt.geom.Line2D this ^java.awt.geom.Point2D pt]
    (-> this (.ptLineDistSq pt))))

(defn pt-seg-dist-sq
  "Returns the square of the distance from a point to this line segment.
   The distance measured is the distance between the specified
   point and the closest point between the current line's end points.
   If the specified point intersects the line segment in between the
   end points, this method returns 0.0.

  px - the X coordinate of the specified point being measured against this line segment - `double`
  py - the Y coordinate of the specified point being measured against this line segment - `double`

  returns: a double value that is the square of the distance from the
                    specified point to the current line segment. - `double`"
  (^Double [^java.awt.geom.Line2D this ^Double px ^Double py]
    (-> this (.ptSegDistSq px py)))
  (^Double [^java.awt.geom.Line2D this ^java.awt.geom.Point2D pt]
    (-> this (.ptSegDistSq pt))))

(defn pt-seg-dist
  "Returns the distance from a point to this line segment.
   The distance measured is the distance between the specified
   point and the closest point between the current line's end points.
   If the specified point intersects the line segment in between the
   end points, this method returns 0.0.

  px - the X coordinate of the specified point being measured against this line segment - `double`
  py - the Y coordinate of the specified point being measured against this line segment - `double`

  returns: a double value that is the distance from the specified
                    point to the current line segment. - `double`"
  (^Double [^java.awt.geom.Line2D this ^Double px ^Double py]
    (-> this (.ptSegDist px py)))
  (^Double [^java.awt.geom.Line2D this ^java.awt.geom.Point2D pt]
    (-> this (.ptSegDist pt))))

(defn set-line
  "Sets the location of the end points of this Line2D to
   the specified double coordinates.

  x-1 - the X coordinate of the start point - `double`
  y-1 - the Y coordinate of the start point - `double`
  x-2 - the X coordinate of the end point - `double`
  y-2 - the Y coordinate of the end point - `double`"
  ([^java.awt.geom.Line2D this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.setLine x-1 y-1 x-2 y-2)))
  ([^java.awt.geom.Line2D this ^java.awt.geom.Point2D p-1 ^java.awt.geom.Point2D p-2]
    (-> this (.setLine p-1 p-2)))
  ([^java.awt.geom.Line2D this ^java.awt.geom.Line2D l]
    (-> this (.setLine l))))

(defn relative-ccw
  "Returns an indicator of where the specified point
   (px,py) lies with respect to this line segment.
   See the method comments of
   relativeCCW(double, double, double, double, double, double)
   to interpret the return value.

  px - the X coordinate of the specified point to be compared with this Line2D - `double`
  py - the Y coordinate of the specified point to be compared with this Line2D - `double`

  returns: an integer that indicates the position of the specified
           coordinates with respect to this Line2D - `int`"
  (^Integer [^java.awt.geom.Line2D this ^Double px ^Double py]
    (-> this (.relativeCCW px py)))
  (^Integer [^java.awt.geom.Line2D this ^java.awt.geom.Point2D p]
    (-> this (.relativeCCW p))))

(defn get-y-2
  "Returns the Y coordinate of the end point in double precision.

  returns: the Y coordinate of the end point of this
           Line2D object. - `double`"
  (^Double [^java.awt.geom.Line2D this]
    (-> this (.getY2))))

(defn get-x-2
  "Returns the X coordinate of the end point in double precision.

  returns: the X coordinate of the end point of this
           Line2D object. - `double`"
  (^Double [^java.awt.geom.Line2D this]
    (-> this (.getX2))))

(defn clone
  "Creates a new object of the same class as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  (^java.lang.Object [^java.awt.geom.Line2D this]
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
  (^java.awt.Rectangle [^java.awt.geom.Line2D this]
    (-> this (.getBounds))))

(defn get-y-1
  "Returns the Y coordinate of the start point in double precision.

  returns: the Y coordinate of the start point of this
           Line2D object. - `double`"
  (^Double [^java.awt.geom.Line2D this]
    (-> this (.getY1))))

(defn intersects
  "Tests if the interior of the Shape intersects the
   interior of a specified rectangular area.
   The rectangular area is considered to intersect the Shape
   if any point is contained in both the interior of the
   Shape and the specified rectangular area.

   The Shape.intersects() method allows a Shape
   implementation to conservatively return true when:


   there is a high probability that the rectangular area and the
   Shape intersect, but

   the calculations to accurately determine this intersection
   are prohibitively expensive.

   This means that for some Shapes this method might
   return true even though the rectangular area does not
   intersect the Shape.
   The Area class performs
   more accurate computations of geometric intersection than most
   Shape objects and therefore can be used if a more precise
   answer is required.

  x - the X coordinate of the upper-left corner of the specified rectangular area - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular area - `double`
  w - the width of the specified rectangular area - `double`
  h - the height of the specified rectangular area - `double`

  returns: true if the interior of the Shape and
            the interior of the rectangular area intersect, or are
            both highly likely to intersect and intersection calculations
            would be too expensive to perform; false otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.Line2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h)))
  (^Boolean [^java.awt.geom.Line2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

(defn get-p-2
  "Returns the end Point2D of this Line2D.

  returns: the end Point2D of this Line2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.Line2D this]
    (-> this (.getP2))))

