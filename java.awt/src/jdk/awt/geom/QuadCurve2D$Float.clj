(ns jdk.awt.geom.QuadCurve2D$Float
  "A quadratic parametric curve segment specified with
  float coordinates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom QuadCurve2D$Float]))

(defn ->float
  "Constructor.

  Constructs and initializes a QuadCurve2D from the
   specified float coordinates.

  x-1 - the X coordinate of the start point - `float`
  y-1 - the Y coordinate of the start point - `float`
  ctrlx - the X coordinate of the control point - `float`
  ctrly - the Y coordinate of the control point - `float`
  x-2 - the X coordinate of the end point - `float`
  y-2 - the Y coordinate of the end point - `float`"
  (^QuadCurve2D$Float [^Float x-1 ^Float y-1 ^Float ctrlx ^Float ctrly ^Float x-2 ^Float y-2]
    (new QuadCurve2D$Float x-1 y-1 ctrlx ctrly x-2 y-2))
  (^QuadCurve2D$Float []
    (new QuadCurve2D$Float )))

(defn -x-1
  "Instance Field.

  The X coordinate of the start point of the quadratic curve
   segment.

  type: float"
  [this]
  (-> this .-x1))

(defn -y-1
  "Instance Field.

  The Y coordinate of the start point of the quadratic curve
   segment.

  type: float"
  [this]
  (-> this .-y1))

(defn -ctrlx
  "Instance Field.

  The X coordinate of the control point of the quadratic curve
   segment.

  type: float"
  [this]
  (-> this .-ctrlx))

(defn -ctrly
  "Instance Field.

  The Y coordinate of the control point of the quadratic curve
   segment.

  type: float"
  [this]
  (-> this .-ctrly))

(defn -x-2
  "Instance Field.

  The X coordinate of the end point of the quadratic curve
   segment.

  type: float"
  [this]
  (-> this .-x2))

(defn -y-2
  "Instance Field.

  The Y coordinate of the end point of the quadratic curve
   segment.

  type: float"
  [this]
  (-> this .-y2))

(defn get-x-1
  "Returns the X coordinate of the start point in
   double in precision.

  returns: the X coordinate of the start point. - `double`"
  (^Double [^QuadCurve2D$Float this]
    (-> this (.getX1))))

(defn get-p-1
  "Returns the start point.

  returns: a Point2D that is the start point of this
            QuadCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^QuadCurve2D$Float this]
    (-> this (.getP1))))

(defn get-ctrl-pt
  "Returns the control point.

  returns: a Point2D that is the control point of this
            Point2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^QuadCurve2D$Float this]
    (-> this (.getCtrlPt))))

(defn get-ctrl-y
  "Returns the Y coordinate of the control point in
   double precision.

  returns: the Y coordinate of the control point. - `double`"
  (^Double [^QuadCurve2D$Float this]
    (-> this (.getCtrlY))))

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
  (^java.awt.geom.Rectangle2D [^QuadCurve2D$Float this]
    (-> this (.getBounds2D))))

(defn get-ctrl-x
  "Returns the X coordinate of the control point in
   double precision.

  returns: X coordinate the control point - `double`"
  (^Double [^QuadCurve2D$Float this]
    (-> this (.getCtrlX))))

(defn get-y-2
  "Returns the Y coordinate of the end point in
   double precision.

  returns: the Y coordinate of the end point. - `double`"
  (^Double [^QuadCurve2D$Float this]
    (-> this (.getY2))))

(defn get-x-2
  "Returns the X coordinate of the end point in
   double precision.

  returns: the x coordinate of the end point. - `double`"
  (^Double [^QuadCurve2D$Float this]
    (-> this (.getX2))))

(defn get-y-1
  "Returns the Y coordinate of the start point in
   double precision.

  returns: the Y coordinate of the start point. - `double`"
  (^Double [^QuadCurve2D$Float this]
    (-> this (.getY1))))

(defn get-p-2
  "Returns the end point.

  returns: a Point object that is the end point
            of this Point2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^QuadCurve2D$Float this]
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
  ([^QuadCurve2D$Float this ^Double x-1 ^Double y-1 ^Double ctrlx ^Double ctrly ^Double x-2 ^Double y-2]
    (-> this (.setCurve x-1 y-1 ctrlx ctrly x-2 y-2))))

