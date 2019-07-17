(ns jdk.awt.geom.Path2D$Float
  "The Float class defines a geometric path with
  coordinates stored in single precision floating point."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Path2D$Float]))

(defn ->float
  "Constructor.

  Constructs a new empty single precision Path2D object
   with the specified winding rule and the specified initial
   capacity to store path segments.
   This number is an initial guess as to how many path segments
   will be added to the path, but the storage is expanded as
   needed to store whatever path segments are added.

  rule - the winding rule - `int`
  initial-capacity - the estimate for the number of path segments in the path - `int`"
  ([^Integer rule ^Integer initial-capacity]
    (new Path2D$Float rule initial-capacity))
  ([^Integer rule]
    (new Path2D$Float rule))
  ([]
    (new Path2D$Float )))

(defn get-path-iterator
  "Returns an iterator object that iterates along the
   Shape boundary and provides access to the geometry of the
   Shape outline.  If an optional AffineTransform
   is specified, the coordinates returned in the iteration are
   transformed accordingly.

   Each call to this method returns a fresh PathIterator
   object that traverses the geometry of the Shape object
   independently from any other PathIterator objects in use
   at the same time.

   It is recommended, but not guaranteed, that objects
   implementing the Shape interface isolate iterations
   that are in process from any changes that might occur to the original
   object's geometry during such iterations.

   The iterator for this class is not multi-threaded safe,
   which means that the Path2D class does not
   guarantee that modifications to the geometry of this
   Path2D object do not affect any iterations of
   that geometry that are already in process.

  at - an optional AffineTransform to be applied to the coordinates as they are returned in the iteration, or null if untransformed coordinates are desired - `java.awt.geom.AffineTransform`

  returns: a new PathIterator object, which independently
            traverses the geometry of the Shape. - `java.awt.geom.PathIterator`"
  (^java.awt.geom.PathIterator [^java.awt.geom.Path2D$Float this ^java.awt.geom.AffineTransform at]
    (-> this (.getPathIterator at))))

(defn line-to
  "Adds a point to the path by drawing a straight line from the
   current coordinates to the new specified coordinates
   specified in double precision.

  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`"
  ([^java.awt.geom.Path2D$Float this ^Double x ^Double y]
    (-> this (.lineTo x y))))

(defn transform
  "Transforms the geometry of this path using the specified
   AffineTransform.
   The geometry is transformed in place, which permanently changes the
   boundary defined by this object.

  at - the AffineTransform used to transform the area - `java.awt.geom.AffineTransform`"
  ([^java.awt.geom.Path2D$Float this ^java.awt.geom.AffineTransform at]
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
  ([^java.awt.geom.Path2D$Float this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2 ^Double x-3 ^Double y-3]
    (-> this (.curveTo x-1 y-1 x-2 y-2 x-3 y-3))))

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
  (^java.awt.geom.Rectangle2D [^java.awt.geom.Path2D$Float this]
    (-> this (.getBounds2D))))

(defn move-to
  "Adds a point to the path by moving to the specified
   coordinates specified in double precision.

  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`"
  ([^java.awt.geom.Path2D$Float this ^Double x ^Double y]
    (-> this (.moveTo x y))))

(defn append
  "Appends the geometry of the specified
   PathIterator object
   to the path, possibly connecting the new geometry to the existing
   path segments with a line segment.
   If the connect parameter is true and the
   path is not empty then any initial moveTo in the
   geometry of the appended Shape is turned into a
   lineTo segment.
   If the destination coordinates of such a connecting lineTo
   segment match the ending coordinates of a currently open
   subpath then the segment is omitted as superfluous.
   The winding rule of the specified Shape is ignored
   and the appended geometry is governed by the winding
   rule specified for this path.

  pi - the PathIterator whose geometry is appended to this path - `java.awt.geom.PathIterator`
  connect - a boolean to control whether or not to turn an initial moveTo segment into a lineTo segment to connect the new geometry to the existing path - `boolean`"
  ([^java.awt.geom.Path2D$Float this ^java.awt.geom.PathIterator pi ^Boolean connect]
    (-> this (.append pi connect))))

(defn clone
  "Creates a new object of the same class as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  (^java.lang.Object [^java.awt.geom.Path2D$Float this]
    (-> this (.clone))))

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
  ([^java.awt.geom.Path2D$Float this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.quadTo x-1 y-1 x-2 y-2))))

