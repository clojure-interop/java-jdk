(ns jdk.awt.geom.CubicCurve2D
  "The CubicCurve2D class defines a cubic parametric curve
  segment in (x,y) coordinate space.

  This class is only the abstract superclass for all objects which
  store a 2D cubic curve segment.
  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom CubicCurve2D]))

(defn *get-flatness-sq
  "Returns the square of the flatness of the cubic curve specified
   by the indicated control points. The flatness is the maximum distance
   of a control point from the line connecting the end points.

  x-1 - the X coordinate that specifies the start point of a CubicCurve2D - `double`
  y-1 - the Y coordinate that specifies the start point of a CubicCurve2D - `double`
  ctrlx-1 - the X coordinate that specifies the first control point of a CubicCurve2D - `double`
  ctrly-1 - the Y coordinate that specifies the first control point of a CubicCurve2D - `double`
  ctrlx-2 - the X coordinate that specifies the second control point of a CubicCurve2D - `double`
  ctrly-2 - the Y coordinate that specifies the second control point of a CubicCurve2D - `double`
  x-2 - the X coordinate that specifies the end point of a CubicCurve2D - `double`
  y-2 - the Y coordinate that specifies the end point of a CubicCurve2D - `double`

  returns: the square of the flatness of the CubicCurve2D
            represented by the specified coordinates. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double ctrlx-1 ^Double ctrly-1 ^Double ctrlx-2 ^Double ctrly-2 ^Double x-2 ^Double y-2]
    (CubicCurve2D/getFlatnessSq x-1 y-1 ctrlx-1 ctrly-1 ctrlx-2 ctrly-2 x-2 y-2))
  (^Double [coords ^Integer offset]
    (CubicCurve2D/getFlatnessSq coords offset)))

(defn *get-flatness
  "Returns the flatness of the cubic curve specified
   by the indicated control points. The flatness is the maximum distance
   of a control point from the line connecting the end points.

  x-1 - the X coordinate that specifies the start point of a CubicCurve2D - `double`
  y-1 - the Y coordinate that specifies the start point of a CubicCurve2D - `double`
  ctrlx-1 - the X coordinate that specifies the first control point of a CubicCurve2D - `double`
  ctrly-1 - the Y coordinate that specifies the first control point of a CubicCurve2D - `double`
  ctrlx-2 - the X coordinate that specifies the second control point of a CubicCurve2D - `double`
  ctrly-2 - the Y coordinate that specifies the second control point of a CubicCurve2D - `double`
  x-2 - the X coordinate that specifies the end point of a CubicCurve2D - `double`
  y-2 - the Y coordinate that specifies the end point of a CubicCurve2D - `double`

  returns: the flatness of the CubicCurve2D
            represented by the specified coordinates. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double ctrlx-1 ^Double ctrly-1 ^Double ctrlx-2 ^Double ctrly-2 ^Double x-2 ^Double y-2]
    (CubicCurve2D/getFlatness x-1 y-1 ctrlx-1 ctrly-1 ctrlx-2 ctrly-2 x-2 y-2))
  (^Double [coords ^Integer offset]
    (CubicCurve2D/getFlatness coords offset)))

(defn *subdivide
  "Subdivides the cubic curve specified by the coordinates
   stored in the src array at indices srcoff
   through (srcoff  7) and stores the
   resulting two subdivided curves into the two result arrays at the
   corresponding indices.
   Either or both of the left and right
   arrays may be null or a reference to the same array
   as the src array.
   Note that the last point in the first subdivided curve is the
   same as the first point in the second subdivided curve. Thus,
   it is possible to pass the same array for left
   and right and to use offsets, such as rightoff
   equals (leftoff  6), in order
   to avoid allocating extra storage for this common point.

  src - the array holding the coordinates for the source curve - `double[]`
  srcoff - the offset into the array of the beginning of the the 6 source coordinates - `int`
  left - the array for storing the coordinates for the first half of the subdivided curve - `double[]`
  leftoff - the offset into the array of the beginning of the the 6 left coordinates - `int`
  right - the array for storing the coordinates for the second half of the subdivided curve - `double[]`
  rightoff - the offset into the array of the beginning of the the 6 right coordinates - `int`"
  ([src ^Integer srcoff left ^Integer leftoff right ^Integer rightoff]
    (CubicCurve2D/subdivide src srcoff left leftoff right rightoff))
  ([^java.awt.geom.CubicCurve2D src ^java.awt.geom.CubicCurve2D left ^java.awt.geom.CubicCurve2D right]
    (CubicCurve2D/subdivide src left right)))

(defn *solve-cubic
  "Solve the cubic whose coefficients are in the eqn
   array and place the non-complex roots into the res
   array, returning the number of roots.
   The cubic solved is represented by the equation:
       eqn = {c, b, a, d}
       dx^3  ax^2  bx  c = 0
   A return value of -1 is used to distinguish a constant equation,
   which may be always 0 or never 0, from an equation which has no
   zeroes.

  eqn - the specified array of coefficients to use to solve the cubic equation - `double[]`
  res - the array that contains the non-complex roots resulting from the solution of the cubic equation - `double[]`

  returns: the number of roots, or -1 if the equation is a constant - `int`"
  (^Integer [eqn res]
    (CubicCurve2D/solveCubic eqn res))
  (^Integer [eqn]
    (CubicCurve2D/solveCubic eqn)))

(defn subdivide
  "Subdivides this cubic curve and stores the resulting two
   subdivided curves into the left and right curve parameters.
   Either or both of the left and right objects may be the same
   as this object or null.

  left - the cubic curve object for storing for the left or first half of the subdivided curve - `java.awt.geom.CubicCurve2D`
  right - the cubic curve object for storing for the right or second half of the subdivided curve - `java.awt.geom.CubicCurve2D`"
  ([^java.awt.geom.CubicCurve2D this ^java.awt.geom.CubicCurve2D left ^java.awt.geom.CubicCurve2D right]
    (-> this (.subdivide left right))))

(defn get-x-1
  "Returns the X coordinate of the start point in double precision.

  returns: the X coordinate of the start point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getX1))))

(defn get-path-iterator
  "Return an iteration object that defines the boundary of the
   flattened shape.
   The iterator for this class is not multi-threaded safe,
   which means that this CubicCurve2D class does not
   guarantee that modifications to the geometry of this
   CubicCurve2D object do not affect any iterations of
   that geometry that are already in process.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`
  flatness - the maximum amount that the control points for a given curve can vary from colinear before a subdivided curve is replaced by a straight line connecting the end points - `double`

  returns: the PathIterator object that returns the
   geometry of the outline of this CubicCurve2D,
   one segment at a time. - `java.awt.geom.PathIterator`"
  (^java.awt.geom.PathIterator [^java.awt.geom.CubicCurve2D this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness)))
  (^java.awt.geom.PathIterator [^java.awt.geom.CubicCurve2D this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn get-p-1
  "Returns the start point.

  returns: a Point2D that is the start point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D this]
    (-> this (.getP1))))

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
  (^Boolean [^java.awt.geom.CubicCurve2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  (^Boolean [^java.awt.geom.CubicCurve2D this ^Double x ^Double y]
    (-> this (.contains x y)))
  (^Boolean [^java.awt.geom.CubicCurve2D this ^java.awt.geom.Point2D p]
    (-> this (.contains p))))

(defn get-flatness
  "Returns the flatness of this curve.  The flatness is the
   maximum distance of a control point from the line connecting the
   end points.

  returns: the flatness of this curve. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getFlatness))))

(defn get-flatness-sq
  "Returns the square of the flatness of this curve.  The flatness is the
   maximum distance of a control point from the line connecting the
   end points.

  returns: the square of the flatness of this curve. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getFlatnessSq))))

(defn get-y-2
  "Returns the Y coordinate of the end point in double precision.

  returns: the Y coordinate of the end point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getY2))))

(defn get-x-2
  "Returns the X coordinate of the end point in double precision.

  returns: the X coordinate of the end point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getX2))))

(defn clone
  "Creates a new object of the same class as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  (^java.lang.Object [^java.awt.geom.CubicCurve2D this]
    (-> this (.clone))))

(defn get-ctrl-y-2
  "Returns the Y coordinate of the second control point
   in double precision.

  returns: the Y coordinate of the second control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getCtrlY2))))

(defn get-ctrl-y-1
  "Returns the Y coordinate of the first control point in double precision.

  returns: the Y coordinate of the first control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getCtrlY1))))

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
  (^java.awt.Rectangle [^java.awt.geom.CubicCurve2D this]
    (-> this (.getBounds))))

(defn get-y-1
  "Returns the Y coordinate of the start point in double precision.

  returns: the Y coordinate of the start point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getY1))))

(defn get-ctrl-x-1
  "Returns the X coordinate of the first control point in double precision.

  returns: the X coordinate of the first control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getCtrlX1))))

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
  (^Boolean [^java.awt.geom.CubicCurve2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h)))
  (^Boolean [^java.awt.geom.CubicCurve2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

(defn get-p-2
  "Returns the end point.

  returns: a Point2D that is the end point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D this]
    (-> this (.getP2))))

(defn get-ctrl-x-2
  "Returns the X coordinate of the second control point
   in double precision.

  returns: the X coordinate of the second control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D this]
    (-> this (.getCtrlX2))))

(defn set-curve
  "Sets the location of the end points and control points of this curve
   to the specified double coordinates.

  x-1 - the X coordinate used to set the start point of this CubicCurve2D - `double`
  y-1 - the Y coordinate used to set the start point of this CubicCurve2D - `double`
  ctrlx-1 - the X coordinate used to set the first control point of this CubicCurve2D - `double`
  ctrly-1 - the Y coordinate used to set the first control point of this CubicCurve2D - `double`
  ctrlx-2 - the X coordinate used to set the second control point of this CubicCurve2D - `double`
  ctrly-2 - the Y coordinate used to set the second control point of this CubicCurve2D - `double`
  x-2 - the X coordinate used to set the end point of this CubicCurve2D - `double`
  y-2 - the Y coordinate used to set the end point of this CubicCurve2D - `double`"
  ([^java.awt.geom.CubicCurve2D this ^Double x-1 ^Double y-1 ^Double ctrlx-1 ^Double ctrly-1 ^Double ctrlx-2 ^Double ctrly-2 ^Double x-2 ^Double y-2]
    (-> this (.setCurve x-1 y-1 ctrlx-1 ctrly-1 ctrlx-2 ctrly-2 x-2 y-2)))
  ([^java.awt.geom.CubicCurve2D this ^java.awt.geom.Point2D p-1 ^java.awt.geom.Point2D cp-1 ^java.awt.geom.Point2D cp-2 ^java.awt.geom.Point2D p-2]
    (-> this (.setCurve p-1 cp-1 cp-2 p-2)))
  ([^java.awt.geom.CubicCurve2D this coords ^Integer offset]
    (-> this (.setCurve coords offset)))
  ([^java.awt.geom.CubicCurve2D this ^java.awt.geom.CubicCurve2D c]
    (-> this (.setCurve c))))

(defn get-ctrl-p-2
  "Returns the second control point.

  returns: a Point2D that is the second control point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D this]
    (-> this (.getCtrlP2))))

(defn get-ctrl-p-1
  "Returns the first control point.

  returns: a Point2D that is the first control point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D this]
    (-> this (.getCtrlP1))))

