(ns jdk.awt.geom.Line2D$Float
  "A line segment specified with float coordinates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Line2D$Float]))

(defn ->float
  "Constructor.

  Constructs and initializes a Line from the specified coordinates.

  x-1 - the X coordinate of the start point - `float`
  y-1 - the Y coordinate of the start point - `float`
  x-2 - the X coordinate of the end point - `float`
  y-2 - the Y coordinate of the end point - `float`"
  (^Line2D$Float [^Float x-1 ^Float y-1 ^Float x-2 ^Float y-2]
    (new Line2D$Float x-1 y-1 x-2 y-2))
  (^Line2D$Float [^java.awt.geom.Point2D p-1 ^java.awt.geom.Point2D p-2]
    (new Line2D$Float p-1 p-2))
  (^Line2D$Float []
    (new Line2D$Float )))

(defn x-1
  "Instance Field.

  The X coordinate of the start point of the line segment.

  type: float"
  (^Float [^Line2D$Float this]
    (-> this .-x1)))

(defn y-1
  "Instance Field.

  The Y coordinate of the start point of the line segment.

  type: float"
  (^Float [^Line2D$Float this]
    (-> this .-y1)))

(defn x-2
  "Instance Field.

  The X coordinate of the end point of the line segment.

  type: float"
  (^Float [^Line2D$Float this]
    (-> this .-x2)))

(defn y-2
  "Instance Field.

  The Y coordinate of the end point of the line segment.

  type: float"
  (^Float [^Line2D$Float this]
    (-> this .-y2)))

(defn get-x-1
  "Returns the X coordinate of the start point in double precision.

  returns: the X coordinate of the start point of this
           Line2D object. - `double`"
  (^Double [^Line2D$Float this]
    (-> this (.getX1))))

(defn get-y-1
  "Returns the Y coordinate of the start point in double precision.

  returns: the Y coordinate of the start point of this
           Line2D object. - `double`"
  (^Double [^Line2D$Float this]
    (-> this (.getY1))))

(defn get-p-1
  "Returns the start Point2D of this Line2D.

  returns: the start Point2D of this Line2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^Line2D$Float this]
    (-> this (.getP1))))

(defn get-x-2
  "Returns the X coordinate of the end point in double precision.

  returns: the X coordinate of the end point of this
           Line2D object. - `double`"
  (^Double [^Line2D$Float this]
    (-> this (.getX2))))

(defn get-y-2
  "Returns the Y coordinate of the end point in double precision.

  returns: the Y coordinate of the end point of this
           Line2D object. - `double`"
  (^Double [^Line2D$Float this]
    (-> this (.getY2))))

(defn get-p-2
  "Returns the end Point2D of this Line2D.

  returns: the end Point2D of this Line2D. - `java.awt.geom.Point2D`"
  (^java.awt.geom.Point2D [^Line2D$Float this]
    (-> this (.getP2))))

(defn set-line
  "Sets the location of the end points of this Line2D to
   the specified double coordinates.

  x-1 - the X coordinate of the start point - `double`
  y-1 - the Y coordinate of the start point - `double`
  x-2 - the X coordinate of the end point - `double`
  y-2 - the Y coordinate of the end point - `double`"
  ([^Line2D$Float this ^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (-> this (.setLine x-1 y-1 x-2 y-2))))

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
  (^java.awt.geom.Rectangle2D [^Line2D$Float this]
    (-> this (.getBounds2D))))

