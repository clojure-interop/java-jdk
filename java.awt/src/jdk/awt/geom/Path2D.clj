(ns jdk.awt.geom.Path2D
  "The Path2D class provides a simple, yet flexible
  shape which represents an arbitrary geometric path.
  It can fully represent any path which can be iterated by the
  PathIterator interface including all of its segment
  types and winding rules and it implements all of the
  basic hit testing methods of the Shape interface.

  Use Path2D.Float when dealing with data that can be represented
  and used with floating point precision.  Use Path2D.Double
  for data that requires the accuracy or range of double precision.

  Path2D provides exactly those facilities required for
  basic construction and management of a geometric path and
  implementation of the above interfaces with little added
  interpretation.
  If it is useful to manipulate the interiors of closed
  geometric shapes beyond simple hit testing then the
  Area class provides additional capabilities
  specifically targeted at closed figures.
  While both classes nominally implement the Shape
  interface, they differ in purpose and together they provide
  two useful views of a geometric shape where Path2D
  deals primarily with a trajectory formed by path segments
  and Area deals more with interpretation and manipulation
  of enclosed regions of 2D geometric space.

  The PathIterator interface has more detailed descriptions
  of the types of segments that make up a path and the winding rules
  that control how to determine which regions are inside or outside
  the path."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Path2D]))

(def *-wind-even-odd
  "Static Constant.

  An even-odd winding rule for determining the interior of
   a path.

  type: int"
  Path2D/WIND_EVEN_ODD)

(def *-wind-non-zero
  "Static Constant.

  A non-zero winding rule for determining the interior of a
   path.

  type: int"
  Path2D/WIND_NON_ZERO)

(defn *contains
  "Tests if the specified rectangular area is entirely inside the
   closed boundary of the specified PathIterator.

   This method provides a basic facility for implementors of
   the Shape interface to implement support for the
   Shape.contains(double, double, double, double) method.

   This method object may conservatively return false in
   cases where the specified rectangular area intersects a
   segment of the path, but that segment does not represent a
   boundary between the interior and exterior of the path.
   Such segments could lie entirely within the interior of the
   path if they are part of a path with a WIND_NON_ZERO
   winding rule or if the segments are retraced in the reverse
   direction such that the two sets of segments cancel each
   other out without any exterior area falling between them.
   To determine whether segments represent true boundaries of
   the interior of the path would require extensive calculations
   involving all of the segments of the path and the winding
   rule and are thus beyond the scope of this implementation.

  pi - the specified PathIterator - `java.awt.geom.PathIterator`
  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`
  w - the width of the specified rectangular area - `double`
  h - the height of the specified rectangular area - `double`

  returns: true if the specified PathIterator contains
           the specified rectangular area; false otherwise. - `boolean`"
  ([^java.awt.geom.PathIterator pi ^Double x ^Double y ^Double w ^Double h]
    (Path2D/contains pi x y w h))
  ([^java.awt.geom.PathIterator pi ^Double x ^Double y]
    (Path2D/contains pi x y))
  ([^java.awt.geom.PathIterator pi ^java.awt.geom.Point2D p]
    (Path2D/contains pi p)))

(defn *intersects
  "Tests if the interior of the specified PathIterator
   intersects the interior of a specified set of rectangular
   coordinates.

   This method provides a basic facility for implementors of
   the Shape interface to implement support for the
   Shape.intersects(double, double, double, double) method.

   This method object may conservatively return true in
   cases where the specified rectangular area intersects a
   segment of the path, but that segment does not represent a
   boundary between the interior and exterior of the path.
   Such a case may occur if some set of segments of the
   path are retraced in the reverse direction such that the
   two sets of segments cancel each other out without any
   interior area between them.
   To determine whether segments represent true boundaries of
   the interior of the path would require extensive calculations
   involving all of the segments of the path and the winding
   rule and are thus beyond the scope of this implementation.

  pi - the specified PathIterator - `java.awt.geom.PathIterator`
  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`
  w - the width of the specified rectangular coordinates - `double`
  h - the height of the specified rectangular coordinates - `double`

  returns: true if the specified PathIterator and
           the interior of the specified set of rectangular
           coordinates intersect each other; false otherwise. - `boolean`"
  ([^java.awt.geom.PathIterator pi ^Double x ^Double y ^Double w ^Double h]
    (Path2D/intersects pi x y w h))
  ([^java.awt.geom.PathIterator pi ^java.awt.geom.Rectangle2D r]
    (Path2D/intersects pi r)))

(defn get-current-point
  "Returns the coordinates most recently added to the end of the path
   as a Point2D object.

  returns: a Point2D object containing the ending coordinates of
           the path or null if there are no points in the path. - `java.awt.geom.Point2D`"
  ([^java.awt.geom.Path2D this]
    (-> this (.getCurrentPoint))))

(defn get-winding-rule
  "Returns the fill style winding rule.

  returns: an integer representing the current winding rule. - `int`"
  ([^java.awt.geom.Path2D this]
    (-> this (.getWindingRule))))

(defn get-path-iterator
  "Returns an iterator object that iterates along the Shape
   boundary and provides access to a flattened view of the
   Shape outline geometry.

   Only SEG_MOVETO, SEG_LINETO, and SEG_CLOSE point types are
   returned by the iterator.

   If an optional AffineTransform is specified,
   the coordinates returned in the iteration are transformed
   accordingly.

   The amount of subdivision of the curved segments is controlled
   by the flatness parameter, which specifies the
   maximum distance that any point on the unflattened transformed
   curve can deviate from the returned flattened path segments.
   Note that a limit on the accuracy of the flattened path might be
   silently imposed, causing very small flattening parameters to be
   treated as larger values.  This limit, if there is one, is
   defined by the particular implementation that is used.

   Each call to this method returns a fresh PathIterator
   object that traverses the Shape object geometry
   independently from any other PathIterator objects in use at
   the same time.

   It is recommended, but not guaranteed, that objects
   implementing the Shape interface isolate iterations
   that are in process from any changes that might occur to the original
   object's geometry during such iterations.

   The iterator for this class is not multi-threaded safe,
   which means that this Path2D class does not
   guarantee that modifications to the geometry of this
   Path2D object do not affect any iterations of
   that geometry that are already in process.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`
  flatness - the maximum distance that the line segments used to approximate the curved segments are allowed to deviate from any point on the original curve - `double`

  returns: a new PathIterator that independently traverses
           a flattened view of the geometry of the  Shape. - `java.awt.geom.PathIterator`"
  ([^java.awt.geom.Path2D this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness))))

(defn line-to
  "Adds a point to the path by drawing a straight line from the
   current coordinates to the new specified coordinates
   specified in double precision.

  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`"
  ([^java.awt.geom.Path2D this ^Double x ^Double y]
    (-> this (.lineTo x y))))

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

   This method object may conservatively return false in
   cases where the specified rectangular area intersects a
   segment of the path, but that segment does not represent a
   boundary between the interior and exterior of the path.
   Such segments could lie entirely within the interior of the
   path if they are part of a path with a WIND_NON_ZERO
   winding rule or if the segments are retraced in the reverse
   direction such that the two sets of segments cancel each
   other out without any exterior area falling between them.
   To determine whether segments represent true boundaries of
   the interior of the path would require extensive calculations
   involving all of the segments of the path and the winding
   rule and are thus beyond the scope of this implementation.

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
  ([^java.awt.geom.Path2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  ([^java.awt.geom.Path2D this ^Double x ^Double y]
    (-> this (.contains x y)))
  ([^java.awt.geom.Path2D this ^java.awt.geom.Point2D p]
    (-> this (.contains p))))

(defn transform
  "Transforms the geometry of this path using the specified
   AffineTransform.
   The geometry is transformed in place, which permanently changes the
   boundary defined by this object.

  at - the AffineTransform used to transform the area - `java.awt.geom.AffineTransform`"
  ([^java.awt.geom.Path2D this ^java.awt.geom.AffineTransform at]
    (-> this (.transform at))))

(defn curve-to
  "Adds a curved segment, defined by three new points, to the path by
   drawing a Bézier curve that intersects both the current
   coordinates and the specified coordinates (x3,y3),
   using the specified points (x1,y1) and (x2,y2) as
   Bézier control points.
   All coordinates are specified in double precision.

  x-1 - the X coordinate of the first Bézier control point - `double`
  y-1 - the Y coordinate of the first Bézier control point - `double`
  x-2 - the X coordinate of the second Bézier control point - `double`
  y-2 - the Y coordinate of the second Bézier control point - `double`
  x-3 - the X coordinate of the final end point - `double`
  y-3 - the Y coordinate of the final end point - `double`"
  ([^java.awt.geom.Path2D this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double x-3 ^Double y-3]
    (-> this (.curveTo x-1 y-1 x-2 y-2 x-3 y-3))))

(defn reset
  "Resets the path to empty.  The append position is set back to the
   beginning of the path and all coordinates and point types are
   forgotten."
  ([^java.awt.geom.Path2D this]
    (-> this (.reset))))

(defn move-to
  "Adds a point to the path by moving to the specified
   coordinates specified in double precision.

  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`"
  ([^java.awt.geom.Path2D this ^Double x ^Double y]
    (-> this (.moveTo x y))))

(defn create-transformed-shape
  "Returns a new Shape representing a transformed version
   of this Path2D.
   Note that the exact type and coordinate precision of the return
   value is not specified for this method.
   The method will return a Shape that contains no less precision
   for the transformed geometry than this Path2D currently
   maintains, but it may contain no more precision either.
   If the tradeoff of precision vs. storage size in the result is
   important then the convenience constructors in the
   Path2D.Float
   and
   Path2D.Double
   subclasses should be used to make the choice explicit.

  at - the AffineTransform used to transform a new Shape. - `java.awt.geom.AffineTransform`

  returns: a new Shape, transformed with the specified
           AffineTransform. - `java.awt.Shape`"
  ([^java.awt.geom.Path2D this ^java.awt.geom.AffineTransform at]
    (-> this (.createTransformedShape at))))

(defn append
  "Appends the geometry of the specified Shape object to the
   path, possibly connecting the new geometry to the existing path
   segments with a line segment.
   If the connect parameter is true and the
   path is not empty then any initial moveTo in the
   geometry of the appended Shape
   is turned into a lineTo segment.
   If the destination coordinates of such a connecting lineTo
   segment match the ending coordinates of a currently open
   subpath then the segment is omitted as superfluous.
   The winding rule of the specified Shape is ignored
   and the appended geometry is governed by the winding
   rule specified for this path.

  s - the Shape whose geometry is appended to this path - `java.awt.Shape`
  connect - a boolean to control whether or not to turn an initial moveTo segment into a lineTo segment to connect the new geometry to the existing path - `boolean`"
  ([^java.awt.geom.Path2D this ^java.awt.Shape s ^Boolean connect]
    (-> this (.append s connect))))

(defn clone
  "Creates a new object of the same class as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  ([^java.awt.geom.Path2D this]
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
  ([^java.awt.geom.Path2D this]
    (-> this (.getBounds))))

(defn set-winding-rule
  "Sets the winding rule for this path to the specified value.

  rule - an integer representing the specified winding rule - `int`

  throws: java.lang.IllegalArgumentException - if rule is not either WIND_EVEN_ODD or WIND_NON_ZERO"
  ([^java.awt.geom.Path2D this ^Integer rule]
    (-> this (.setWindingRule rule))))

(defn close-path
  "Closes the current subpath by drawing a straight line back to
   the coordinates of the last moveTo.  If the path is already
   closed then this method has no effect."
  ([^java.awt.geom.Path2D this]
    (-> this (.closePath))))

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

   This method object may conservatively return true in
   cases where the specified rectangular area intersects a
   segment of the path, but that segment does not represent a
   boundary between the interior and exterior of the path.
   Such a case may occur if some set of segments of the
   path are retraced in the reverse direction such that the
   two sets of segments cancel each other out without any
   interior area between them.
   To determine whether segments represent true boundaries of
   the interior of the path would require extensive calculations
   involving all of the segments of the path and the winding
   rule and are thus beyond the scope of this implementation.

  x - the X coordinate of the upper-left corner of the specified rectangular area - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular area - `double`
  w - the width of the specified rectangular area - `double`
  h - the height of the specified rectangular area - `double`

  returns: true if the interior of the Shape and
            the interior of the rectangular area intersect, or are
            both highly likely to intersect and intersection calculations
            would be too expensive to perform; false otherwise. - `boolean`"
  ([^java.awt.geom.Path2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h)))
  ([^java.awt.geom.Path2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

(defn quad-to
  "Adds a curved segment, defined by two new points, to the path by
   drawing a Quadratic curve that intersects both the current
   coordinates and the specified coordinates (x2,y2),
   using the specified point (x1,y1) as a quadratic
   parametric control point.
   All coordinates are specified in double precision.

  x-1 - the X coordinate of the quadratic control point - `double`
  y-1 - the Y coordinate of the quadratic control point - `double`
  x-2 - the X coordinate of the final end point - `double`
  y-2 - the Y coordinate of the final end point - `double`"
  ([^java.awt.geom.Path2D this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.quadTo x-1 y-1 x-2 y-2))))

