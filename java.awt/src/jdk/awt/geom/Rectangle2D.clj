(ns jdk.awt.geom.Rectangle2D
  "The Rectangle2D class describes a rectangle
  defined by a location (x,y) and dimension
  (w x h).

  This class is only the abstract superclass for all objects that
  store a 2D rectangle.
  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Rectangle2D]))

(def *-out-left
  "Static Constant.

  The bitmask that indicates that a point lies to the left of
   this Rectangle2D.

  type: int"
  Rectangle2D/OUT_LEFT)

(def *-out-top
  "Static Constant.

  The bitmask that indicates that a point lies above
   this Rectangle2D.

  type: int"
  Rectangle2D/OUT_TOP)

(def *-out-right
  "Static Constant.

  The bitmask that indicates that a point lies to the right of
   this Rectangle2D.

  type: int"
  Rectangle2D/OUT_RIGHT)

(def *-out-bottom
  "Static Constant.

  The bitmask that indicates that a point lies below
   this Rectangle2D.

  type: int"
  Rectangle2D/OUT_BOTTOM)

(defn *intersect
  "Intersects the pair of specified source Rectangle2D
   objects and puts the result into the specified destination
   Rectangle2D object.  One of the source rectangles
   can also be the destination to avoid creating a third Rectangle2D
   object, but in this case the original points of this source
   rectangle will be overwritten by this method.

  src-1 - the first of a pair of Rectangle2D objects to be intersected with each other - `java.awt.geom.Rectangle2D`
  src-2 - the second of a pair of Rectangle2D objects to be intersected with each other - `java.awt.geom.Rectangle2D`
  dest - the Rectangle2D that holds the results of the intersection of src1 and src2 - `java.awt.geom.Rectangle2D`"
  ([^java.awt.geom.Rectangle2D src-1 ^java.awt.geom.Rectangle2D src-2 ^java.awt.geom.Rectangle2D dest]
    (Rectangle2D/intersect src-1 src-2 dest)))

(defn *union
  "Unions the pair of source Rectangle2D objects
   and puts the result into the specified destination
   Rectangle2D object.  One of the source rectangles
   can also be the destination to avoid creating a third Rectangle2D
   object, but in this case the original points of this source
   rectangle will be overwritten by this method.

  src-1 - the first of a pair of Rectangle2D objects to be combined with each other - `java.awt.geom.Rectangle2D`
  src-2 - the second of a pair of Rectangle2D objects to be combined with each other - `java.awt.geom.Rectangle2D`
  dest - the Rectangle2D that holds the results of the union of src1 and src2 - `java.awt.geom.Rectangle2D`"
  ([^java.awt.geom.Rectangle2D src-1 ^java.awt.geom.Rectangle2D src-2 ^java.awt.geom.Rectangle2D dest]
    (Rectangle2D/union src-1 src-2 dest)))

(defn set-rect
  "Sets the location and size of this Rectangle2D
   to the specified double values.

  x - the X coordinate of the upper-left corner of this Rectangle2D - `double`
  y - the Y coordinate of the upper-left corner of this Rectangle2D - `double`
  w - the width of this Rectangle2D - `double`
  h - the height of this Rectangle2D - `double`"
  ([^java.awt.geom.Rectangle2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.setRect x y w h)))
  ([^java.awt.geom.Rectangle2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.setRect r))))

(defn get-path-iterator
  "Returns an iteration object that defines the boundary of the
   flattened Rectangle2D.  Since rectangles are already
   flat, the flatness parameter is ignored.
   The iterator for this class is multi-threaded safe, which means
   that this Rectangle2D class guarantees that
   modifications to the geometry of this Rectangle2D
   object do not affect any iterations of that geometry that
   are already in process.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`
  flatness - the maximum distance that the line segments used to approximate the curved segments are allowed to deviate from any point on the original curve. Since rectangles are already flat, the flatness parameter is ignored. - `double`

  returns: the PathIterator object that returns the
            geometry of the outline of this
            Rectangle2D, one segment at a time. - `java.awt.geom.PathIterator`"
  (^java.awt.geom.PathIterator [^java.awt.geom.Rectangle2D this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness)))
  (^java.awt.geom.PathIterator [^java.awt.geom.Rectangle2D this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn intersects-line
  "Tests if the specified line segment intersects the interior of this
   Rectangle2D.

  x-1 - the X coordinate of the start point of the specified line segment - `double`
  y-1 - the Y coordinate of the start point of the specified line segment - `double`
  x-2 - the X coordinate of the end point of the specified line segment - `double`
  y-2 - the Y coordinate of the end point of the specified line segment - `double`

  returns: true if the specified line segment intersects
   the interior of this Rectangle2D; false
   otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.Rectangle2D this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.intersectsLine x-1 y-1 x-2 y-2)))
  (^Boolean [^java.awt.geom.Rectangle2D this ^java.awt.geom.Line2D l]
    (-> this (.intersectsLine l))))

(defn contains
  "Tests if the interior of the Shape entirely contains
   the specified rectangular area.  All coordinates that lie inside
   the rectangular area must lie within the Shape for the
   entire rectangular area to be considered contained within the
   Shape.

   The Shape.contains() method allows a Shape
   implementation to conservatively return false when:


   the intersect method returns true and

   the calculations to determine whether or not the
   Shape entirely contains the rectangular area are
   prohibitively expensive.

   This means that for some Shapes this method might
   return false even though the Shape contains
   the rectangular area.
   The Area class performs
   more accurate geometric computations than most
   Shape objects and therefore can be used if a more precise
   answer is required.

  x - the X coordinate of the upper-left corner of the specified rectangular area - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular area - `double`
  w - the width of the specified rectangular area - `double`
  h - the height of the specified rectangular area - `double`

  returns: true if the interior of the Shape
            entirely contains the specified rectangular area;
            false otherwise or, if the Shape
            contains the rectangular area and the
            intersects method returns true
            and the containment calculations would be too expensive to
            perform. - `boolean`"
  (^Boolean [^java.awt.geom.Rectangle2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  (^Boolean [^java.awt.geom.Rectangle2D this ^Double x ^Double y]
    (-> this (.contains x y))))

(defn create-intersection
  "Returns a new Rectangle2D object representing the
   intersection of this Rectangle2D with the specified
   Rectangle2D.

  r - the Rectangle2D to be intersected with this Rectangle2D - `java.awt.geom.Rectangle2D`

  returns: the largest Rectangle2D contained in both
            the specified Rectangle2D and in this
            Rectangle2D. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.geom.Rectangle2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.createIntersection r))))

(defn create-union
  "Returns a new Rectangle2D object representing the
   union of this Rectangle2D with the specified
   Rectangle2D.

  r - the Rectangle2D to be combined with this Rectangle2D - `java.awt.geom.Rectangle2D`

  returns: the smallest Rectangle2D containing both
   the specified Rectangle2D and this
   Rectangle2D. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.geom.Rectangle2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.createUnion r))))

(defn outcode
  "Determines where the specified coordinates lie with respect
   to this Rectangle2D.
   This method computes a binary OR of the appropriate mask values
   indicating, for each side of this Rectangle2D,
   whether or not the specified coordinates are on the same side
   of the edge as the rest of this Rectangle2D.

  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`

  returns: the logical OR of all appropriate out codes. - `int`"
  (^Integer [^java.awt.geom.Rectangle2D this ^Double x ^Double y]
    (-> this (.outcode x y)))
  (^Integer [^java.awt.geom.Rectangle2D this ^java.awt.geom.Point2D p]
    (-> this (.outcode p))))

(defn get-bounds-2-d
  "Returns a high precision and more accurate bounding box of
   the Shape than the getBounds method.
   Note that there is no guarantee that the returned
   Rectangle2D is the smallest bounding box that encloses
   the Shape, only that the Shape lies
   entirely within the indicated Rectangle2D.  The
   bounding box returned by this method is usually tighter than that
   returned by the getBounds method and never fails due
   to overflow problems since the return value can be an instance of
   the Rectangle2D that uses double precision values to
   store the dimensions.


   Note that the
   definition of insideness can lead to situations where points
   on the defining outline of the shape may not be considered
   contained in the returned bounds object, but only in cases
   where those points are also not considered contained in the original
   shape.


   If a point is inside the shape according to the
   contains(point) method, then it must
   be inside the returned Rectangle2D bounds object according
   to the contains(point) method of the
   bounds. Specifically:


    shape.contains(p) requires bounds.contains(p)


   If a point is not inside the shape, then it might
   still be contained in the bounds object:


    bounds.contains(p) does not imply shape.contains(p)

  returns: an instance of Rectangle2D that is a
                   high-precision bounding box of the Shape. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^java.awt.geom.Rectangle2D this]
    (-> this (.getBounds2D))))

(defn hash-code
  "Returns the hashcode for this Rectangle2D.

  returns: the hashcode for this Rectangle2D. - `int`"
  (^Integer [^java.awt.geom.Rectangle2D this]
    (-> this (.hashCode))))

(defn add
  "Adds a point, specified by the double precision arguments
   newx and newy, to this
   Rectangle2D.  The resulting Rectangle2D
   is the smallest Rectangle2D that
   contains both the original Rectangle2D and the
   specified point.

   After adding a point, a call to contains with the
   added point as an argument does not necessarily return
   true. The contains method does not
   return true for points on the right or bottom
   edges of a rectangle. Therefore, if the added point falls on
   the left or bottom edge of the enlarged rectangle,
   contains returns false for that point.

  newx - the X coordinate of the new point - `double`
  newy - the Y coordinate of the new point - `double`"
  ([^java.awt.geom.Rectangle2D this ^Double newx ^Double newy]
    (-> this (.add newx newy)))
  ([^java.awt.geom.Rectangle2D this ^java.awt.geom.Point2D pt]
    (-> this (.add pt))))

(defn set-frame
  "Sets the location and size of the outer bounds of this
   Rectangle2D to the specified rectangular values.

  x - the X coordinate of the upper-left corner of this Rectangle2D - `double`
  y - the Y coordinate of the upper-left corner of this Rectangle2D - `double`
  w - the width of this Rectangle2D - `double`
  h - the height of this Rectangle2D - `double`"
  ([^java.awt.geom.Rectangle2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.setFrame x y w h))))

(defn equals
  "Determines whether or not the specified Object is
   equal to this Rectangle2D.  The specified
   Object is equal to this Rectangle2D
   if it is an instance of Rectangle2D and if its
   location and size are the same as this Rectangle2D.

  obj - an Object to be compared with this Rectangle2D. - `java.lang.Object`

  returns: true if obj is an instance
                       of Rectangle2D and has
                       the same values; false otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.Rectangle2D this ^java.lang.Object obj]
    (-> this (.equals obj))))

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
  (^Boolean [^java.awt.geom.Rectangle2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h))))

