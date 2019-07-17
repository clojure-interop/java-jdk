(ns jdk.awt.Polygon
  "The Polygon class encapsulates a description of a
  closed, two-dimensional region within a coordinate space. This
  region is bounded by an arbitrary number of line segments, each of
  which is one side of the polygon. Internally, a polygon
  comprises of a list of (x,y)
  coordinate pairs, where each pair defines a vertex of the
  polygon, and two successive pairs are the endpoints of a
  line that is a side of the polygon. The first and final
  pairs of (x,y) points are joined by a line segment
  that closes the polygon.  This Polygon is defined with
  an even-odd winding rule.  See
  WIND_EVEN_ODD
  for a definition of the even-odd winding rule.
  This class's hit-testing methods, which include the
  contains, intersects and inside
  methods, use the insideness definition described in the
  Shape class comments."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Polygon]))

(defn ->polygon
  "Constructor.

  Constructs and initializes a Polygon from the specified
   parameters.

  xpoints - an array of X coordinates - `int[]`
  ypoints - an array of Y coordinates - `int[]`
  npoints - the total number of points in the Polygon - `int`

  throws: java.lang.NegativeArraySizeException - if the value of npoints is negative."
  ([xpoints ypoints ^Integer npoints]
    (new Polygon xpoints ypoints npoints))
  ([]
    (new Polygon )))

(defn -npoints
  "Instance Field.

  The total number of points.  The value of npoints
   represents the number of valid points in this Polygon
   and might be less than the number of elements in
   xpoints or ypoints.
   This value can be NULL.

  type: int"
  [this]
  (-> this .-npoints))

(defn -xpoints
  "Instance Field.

  The array of X coordinates.  The number of elements in
   this array might be more than the number of X coordinates
   in this Polygon.  The extra elements allow new points
   to be added to this Polygon without re-creating this
   array.  The value of npoints is equal to the
   number of valid points in this Polygon.

  type: int[]"
  [this]
  (-> this .-xpoints))

(defn -ypoints
  "Instance Field.

  The array of Y coordinates.  The number of elements in
   this array might be more than the number of Y coordinates
   in this Polygon.  The extra elements allow new points
   to be added to this Polygon without re-creating this
   array.  The value of npoints is equal to the
   number of valid points in this Polygon.

  type: int[]"
  [this]
  (-> this .-ypoints))

(defn get-path-iterator
  "Returns an iterator object that iterates along the boundary of
   the Shape and provides access to the geometry of the
   outline of the Shape.  Only SEG_MOVETO, SEG_LINETO, and
   SEG_CLOSE point types are returned by the iterator.
   Since polygons are already flat, the flatness parameter
   is ignored.  An optional AffineTransform can be specified
   in which case the coordinates returned in the iteration are transformed
   accordingly.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`
  flatness - the maximum amount that the control points for a given curve can vary from colinear before a subdivided curve is replaced by a straight line connecting the endpoints. Since polygons are already flat the flatness parameter is ignored. - `double`

  returns: a PathIterator object that provides access to the
            Shape object's geometry. - `java.awt.geom.PathIterator`"
  ([^java.awt.Polygon this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness)))
  ([^java.awt.Polygon this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn translate
  "Translates the vertices of the Polygon by
   deltaX along the x axis and by
   deltaY along the y axis.

  delta-x - the amount to translate along the X axis - `int`
  delta-y - the amount to translate along the Y axis - `int`"
  ([^java.awt.Polygon this ^Integer delta-x ^Integer delta-y]
    (-> this (.translate delta-x delta-y))))

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
  ([^java.awt.Polygon this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  ([^java.awt.Polygon this ^Integer x ^Integer y]
    (-> this (.contains x y)))
  ([^java.awt.Polygon this ^java.awt.Point p]
    (-> this (.contains p))))

(defn reset
  "Resets this Polygon object to an empty polygon.
   The coordinate arrays and the data in them are left untouched
   but the number of points is reset to zero to mark the old
   vertex data as invalid and to start accumulating new vertex
   data at the beginning.
   All internally-cached data relating to the old vertices
   are discarded.
   Note that since the coordinate arrays from before the reset
   are reused, creating a new empty Polygon might
   be more memory efficient than resetting the current one if
   the number of vertices in the new polygon data is significantly
   smaller than the number of vertices in the data from before the
   reset."
  ([^java.awt.Polygon this]
    (-> this (.reset))))

(defn add-point
  "Appends the specified coordinates to this Polygon.

   If an operation that calculates the bounding box of this
   Polygon has already been performed, such as
   getBounds or contains, then this
   method updates the bounding box.

  x - the specified X coordinate - `int`
  y - the specified Y coordinate - `int`"
  ([^java.awt.Polygon this ^Integer x ^Integer y]
    (-> this (.addPoint x y))))

(defn invalidate
  "Invalidates or flushes any internally-cached data that depends
   on the vertex coordinates of this Polygon.
   This method should be called after any direct manipulation
   of the coordinates in the xpoints or
   ypoints arrays to avoid inconsistent results
   from methods such as getBounds or contains
   that might cache data from earlier computations relating to
   the vertex coordinates."
  ([^java.awt.Polygon this]
    (-> this (.invalidate))))

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
  ([^java.awt.Polygon this]
    (-> this (.getBounds2D))))

(defn inside
  "Deprecated. As of JDK version 1.1,
   replaced by contains(int, int).

  x - the specified X coordinate to be tested - `int`
  y - the specified Y coordinate to be tested - `int`

  returns: true if this Polygon contains
           the specified coordinates (x,y);
           false otherwise. - `java.lang.  boolean`"
  ([^java.awt.Polygon this ^Integer x ^Integer y]
    (-> this (.inside x y))))

(defn get-bounds
  "Gets the bounding box of this Polygon.
   The bounding box is the smallest Rectangle whose
   sides are parallel to the x and y axes of the
   coordinate space, and can completely contain the Polygon.

  returns: a Rectangle that defines the bounds of this
   Polygon. - `java.awt.Rectangle`"
  ([^java.awt.Polygon this]
    (-> this (.getBounds))))

(defn get-bounding-box
  "Deprecated. As of JDK version 1.1,
   replaced by getBounds().

  returns: the bounds of this Polygon. - `java.lang.  java.awt.Rectangle`"
  ([^java.awt.Polygon this]
    (-> this (.getBoundingBox))))

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
  ([^java.awt.Polygon this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h)))
  ([^java.awt.Polygon this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

