(ns jdk.awt.geom.QuadCurve2D
  "The QuadCurve2D class defines a quadratic parametric curve
  segment in (x,y) coordinate space.

  This class is only the abstract superclass for all objects that
  store a 2D quadratic curve segment.
  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom QuadCurve2D]))

(defn *get-flatness-sq
  "Returns the square of the flatness, or maximum distance of a
   control point from the line connecting the end points, of the
   quadratic curve specified by the indicated control points.

  x-1 - the X coordinate of the start point - `double`
  y-1 - the Y coordinate of the start point - `double`
  ctrlx - the X coordinate of the control point - `double`
  ctrly - the Y coordinate of the control point - `double`
  x-2 - the X coordinate of the end point - `double`
  y-2 - the Y coordinate of the end point - `double`

  returns: the square of the flatness of the quadratic curve
            defined by the specified coordinates. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double ctrlx ^Double ctrly ^Double x-2 ^Double y-2]
    (QuadCurve2D/getFlatnessSq x-1 y-1 ctrlx ctrly x-2 y-2))
  (^Double [coords ^Integer offset]
    (QuadCurve2D/getFlatnessSq coords offset)))

(defn *get-flatness
  "Returns the flatness, or maximum distance of a
   control point from the line connecting the end points, of the
   quadratic curve specified by the indicated control points.

  x-1 - the X coordinate of the start point - `double`
  y-1 - the Y coordinate of the start point - `double`
  ctrlx - the X coordinate of the control point - `double`
  ctrly - the Y coordinate of the control point - `double`
  x-2 - the X coordinate of the end point - `double`
  y-2 - the Y coordinate of the end point - `double`

  returns: the flatness of the quadratic curve defined by the
            specified coordinates. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double ctrlx ^Double ctrly ^Double x-2 ^Double y-2]
    (QuadCurve2D/getFlatness x-1 y-1 ctrlx ctrly x-2 y-2))
  (^Double [coords ^Integer offset]
    (QuadCurve2D/getFlatness coords offset)))

(defn *subdivide
  "Subdivides the quadratic curve specified by the coordinates
   stored in the src array at indices
   srcoff through srcoff  5
   and stores the resulting two subdivided curves into the two
   result arrays at the corresponding indices.
   Either or both of the left and right
   arrays can be null or a reference to the same array
   and offset as the src array.
   Note that the last point in the first subdivided curve is the
   same as the first point in the second subdivided curve.  Thus,
   it is possible to pass the same array for left and
   right and to use offsets such that
   rightoff equals leftoff  4 in order
   to avoid allocating extra storage for this common point.

  src - the array holding the coordinates for the source curve - `double[]`
  srcoff - the offset into the array of the beginning of the the 6 source coordinates - `int`
  left - the array for storing the coordinates for the first half of the subdivided curve - `double[]`
  leftoff - the offset into the array of the beginning of the the 6 left coordinates - `int`
  right - the array for storing the coordinates for the second half of the subdivided curve - `double[]`
  rightoff - the offset into the array of the beginning of the the 6 right coordinates - `int`"
  ([src ^Integer srcoff left ^Integer leftoff right ^Integer rightoff]
    (QuadCurve2D/subdivide src srcoff left leftoff right rightoff))
  ([^java.awt.geom.QuadCurve2D src ^java.awt.geom.QuadCurve2D left ^java.awt.geom.QuadCurve2D right]
    (QuadCurve2D/subdivide src left right)))

(defn *solve-quadratic
  "Solves the quadratic whose coefficients are in the eqn
   array and places the non-complex roots into the res
   array, returning the number of roots.
   The quadratic solved is represented by the equation:


       eqn = {C, B, A};
       ax^2  bx  c = 0
   A return value of -1 is used to distinguish a constant
   equation, which might be always 0 or never 0, from an equation that
   has no zeroes.

  eqn - the specified array of coefficients to use to solve the quadratic equation - `double[]`
  res - the array that contains the non-complex roots resulting from the solution of the quadratic equation - `double[]`

  returns: the number of roots, or -1 if the equation is
    a constant. - `int`"
  (^Integer [eqn res]
    (QuadCurve2D/solveQuadratic eqn res))
  (^Integer [eqn]
    (QuadCurve2D/solveQuadratic eqn)))

(defn subdivide
  "Subdivides this QuadCurve2D and stores the resulting
   two subdivided curves into the left and
   right curve parameters.
   Either or both of the left and right
   objects can be the same as this QuadCurve2D or
   null.

  left - the QuadCurve2D object for storing the left or first half of the subdivided curve - `java.awt.geom.QuadCurve2D`
  right - the QuadCurve2D object for storing the right or second half of the subdivided curve - `java.awt.geom.QuadCurve2D`"
  ([^QuadCurve2D this ^java.awt.geom.QuadCurve2D left ^java.awt.geom.QuadCurve2D right]
    (-> this (.subdivide left right))))

(defn get-x-1
  "Returns the X coordinate of the start point in
   double in precision.

  returns: the X coordinate of the start point. - `double`"
  (^Double [^QuadCurve2D this]
    (-> this (.getX1))))

(defn get-path-iterator
  "Returns an iteration object that defines the boundary of the
   flattened shape of this QuadCurve2D.
   The iterator for this class is not multi-threaded safe,
   which means that this QuadCurve2D class does not
   guarantee that modifications to the geometry of this
   QuadCurve2D object do not affect any iterations of
   that geometry that are already in process.

  at - an optional AffineTransform to apply to the boundary of the shape - `java.awt.geom.AffineTransform`
  flatness - the maximum distance that the control points for a subdivided curve can be with respect to a line connecting the end points of this curve before this curve is replaced by a straight line connecting the end points. - `double`

  returns: a PathIterator object that defines the
            flattened boundary of the shape. - `java.awt.geom.PathIterator`"
  (^java.awt.geom.PathIterator [^QuadCurve2D this ^java.awt.geom.AffineTransform at ^Double flatness]
    (-> this (.getPathIterator at flatness)))
  (^java.awt.geom.PathIterator [^QuadCurve2D this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn get-p-1
  "Returns the start point.

  returns: a Point2D that is the start point of this
            QuadCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^QuadCurve2D this]
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
  (^Boolean [^QuadCurve2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.contains x y w h)))
  (^Boolean [^QuadCurve2D this ^Double x ^Double y]
    (-> this (.contains x y)))
  (^Boolean [^QuadCurve2D this ^java.awt.geom.Point2D p]
    (-> this (.contains p))))

(defn get-ctrl-pt
  "Returns the control point.

  returns: a Point2D that is the control point of this
            Point2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^QuadCurve2D this]
    (-> this (.getCtrlPt))))

(defn get-flatness
  "Returns the flatness, or maximum distance of a
   control point from the line connecting the end points, of this
   QuadCurve2D.

  returns: the flatness of this QuadCurve2D. - `double`"
  (^Double [^QuadCurve2D this]
    (-> this (.getFlatness))))

(defn get-flatness-sq
  "Returns the square of the flatness, or maximum distance of a
   control point from the line connecting the end points, of this
   QuadCurve2D.

  returns: the square of the flatness of this
            QuadCurve2D. - `double`"
  (^Double [^QuadCurve2D this]
    (-> this (.getFlatnessSq))))

(defn get-ctrl-y
  "Returns the Y coordinate of the control point in
   double precision.

  returns: the Y coordinate of the control point. - `double`"
  (^Double [^QuadCurve2D this]
    (-> this (.getCtrlY))))

(defn get-ctrl-x
  "Returns the X coordinate of the control point in
   double precision.

  returns: X coordinate the control point - `double`"
  (^Double [^QuadCurve2D this]
    (-> this (.getCtrlX))))

(defn get-y-2
  "Returns the Y coordinate of the end point in
   double precision.

  returns: the Y coordinate of the end point. - `double`"
  (^Double [^QuadCurve2D this]
    (-> this (.getY2))))

(defn get-x-2
  "Returns the X coordinate of the end point in
   double precision.

  returns: the x coordinate of the end point. - `double`"
  (^Double [^QuadCurve2D this]
    (-> this (.getX2))))

(defn clone
  "Creates a new object of the same class and with the same contents
   as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  (^java.lang.Object [^QuadCurve2D this]
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
  (^java.awt.Rectangle [^QuadCurve2D this]
    (-> this (.getBounds))))

(defn get-y-1
  "Returns the Y coordinate of the start point in
   double precision.

  returns: the Y coordinate of the start point. - `double`"
  (^Double [^QuadCurve2D this]
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
  (^Boolean [^QuadCurve2D this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.intersects x y w h)))
  (^Boolean [^QuadCurve2D this ^java.awt.geom.Rectangle2D r]
    (-> this (.intersects r))))

(defn get-p-2
  "Returns the end point.

  returns: a Point object that is the end point
            of this Point2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^QuadCurve2D this]
    (-> this (.getP2))))

(defn set-curve
  "Sets the location of the end points and control point of this curve
   to the specified double coordinates.

  x-1 - the X coordinate of the start point - `double`
  y-1 - the Y coordinate of the start point - `double`
  ctrlx - the X coordinate of the control point - `double`
  ctrly - the Y coordinate of the control point - `double`
  x-2 - the X coordinate of the end point - `double`
  y-2 - the Y coordinate of the end point - `double`"
  ([^QuadCurve2D this ^Double x-1 ^Double y-1 ^Double ctrlx ^Double ctrly ^Double x-2 ^Double y-2]
    (-> this (.setCurve x-1 y-1 ctrlx ctrly x-2 y-2)))
  ([^QuadCurve2D this ^java.awt.geom.Point2D p-1 ^java.awt.geom.Point2D cp ^java.awt.geom.Point2D p-2]
    (-> this (.setCurve p-1 cp p-2)))
  ([^QuadCurve2D this coords ^Integer offset]
    (-> this (.setCurve coords offset)))
  ([^QuadCurve2D this ^java.awt.geom.QuadCurve2D c]
    (-> this (.setCurve c))))

