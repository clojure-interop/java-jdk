(ns jdk.awt.geom.CubicCurve2D$Double
  "A cubic parametric curve segment specified with
  double coordinates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom CubicCurve2D$Double]))

(defn ->double
  "Constructor.

  Constructs and initializes a CubicCurve2D from
   the specified double coordinates.

  x-1 - the X coordinate for the start point of the resulting CubicCurve2D - `double`
  y-1 - the Y coordinate for the start point of the resulting CubicCurve2D - `double`
  ctrlx-1 - the X coordinate for the first control point of the resulting CubicCurve2D - `double`
  ctrly-1 - the Y coordinate for the first control point of the resulting CubicCurve2D - `double`
  ctrlx-2 - the X coordinate for the second control point of the resulting CubicCurve2D - `double`
  ctrly-2 - the Y coordinate for the second control point of the resulting CubicCurve2D - `double`
  x-2 - the X coordinate for the end point of the resulting CubicCurve2D - `double`
  y-2 - the Y coordinate for the end point of the resulting CubicCurve2D - `double`"
  ([^Double x-1 ^Double y-1 ^Double ctrlx-1 ^Double ctrly-1 ^Double ctrlx-2 ^Double ctrly-2 ^Double x-2 ^Double y-2]
    (new CubicCurve2D$Double x-1 y-1 ctrlx-1 ctrly-1 ctrlx-2 ctrly-2 x-2 y-2))
  ([]
    (new CubicCurve2D$Double )))

(defn -x-1
  "Instance Field.

  The X coordinate of the start point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-x1))

(defn -y-1
  "Instance Field.

  The Y coordinate of the start point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-y1))

(defn -ctrlx-1
  "Instance Field.

  The X coordinate of the first control point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-ctrlx1))

(defn -ctrly-1
  "Instance Field.

  The Y coordinate of the first control point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-ctrly1))

(defn -ctrlx-2
  "Instance Field.

  The X coordinate of the second control point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-ctrlx2))

(defn -ctrly-2
  "Instance Field.

  The Y coordinate of the second control point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-ctrly2))

(defn -x-2
  "Instance Field.

  The X coordinate of the end point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-x2))

(defn -y-2
  "Instance Field.

  The Y coordinate of the end point
   of the cubic curve segment.

  type: double"
  [this]
  (-> this .-y2))

(defn get-x-1
  "Returns the X coordinate of the start point in double precision.

  returns: the X coordinate of the start point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getX1))))

(defn get-p-1
  "Returns the start point.

  returns: a Point2D that is the start point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getP1))))

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
  (^java.awt.geom.Rectangle2D [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getBounds2D))))

(defn get-y-2
  "Returns the Y coordinate of the end point in double precision.

  returns: the Y coordinate of the end point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getY2))))

(defn get-x-2
  "Returns the X coordinate of the end point in double precision.

  returns: the X coordinate of the end point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getX2))))

(defn get-ctrl-y-2
  "Returns the Y coordinate of the second control point
   in double precision.

  returns: the Y coordinate of the second control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getCtrlY2))))

(defn get-ctrl-y-1
  "Returns the Y coordinate of the first control point in double precision.

  returns: the Y coordinate of the first control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getCtrlY1))))

(defn get-y-1
  "Returns the Y coordinate of the start point in double precision.

  returns: the Y coordinate of the start point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getY1))))

(defn get-ctrl-x-1
  "Returns the X coordinate of the first control point in double precision.

  returns: the X coordinate of the first control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getCtrlX1))))

(defn get-p-2
  "Returns the end point.

  returns: a Point2D that is the end point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getP2))))

(defn get-ctrl-x-2
  "Returns the X coordinate of the second control point
   in double precision.

  returns: the X coordinate of the second control point of the
           CubicCurve2D. - `double`"
  (^Double [^java.awt.geom.CubicCurve2D$Double this]
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
  ([^java.awt.geom.CubicCurve2D$Double this ^Double x-1 ^Double y-1 ^Double ctrlx-1 ^Double ctrly-1 ^Double ctrlx-2 ^Double ctrly-2 ^Double x-2 ^Double y-2]
    (-> this (.setCurve x-1 y-1 ctrlx-1 ctrly-1 ctrlx-2 ctrly-2 x-2 y-2))))

(defn get-ctrl-p-2
  "Returns the second control point.

  returns: a Point2D that is the second control point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getCtrlP2))))

(defn get-ctrl-p-1
  "Returns the first control point.

  returns: a Point2D that is the first control point of
           the CubicCurve2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^java.awt.geom.CubicCurve2D$Double this]
    (-> this (.getCtrlP1))))

