(ns jdk.awt.geom.RoundRectangle2D$Double
  "The Double class defines a rectangle with rounded
  corners all specified in double coordinates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom RoundRectangle2D$Double]))

(defn ->double
  "Constructor.

  Constructs and initializes a RoundRectangle2D
   from the specified double coordinates.

  x - the X coordinate of the newly constructed RoundRectangle2D - `double`
  y - the Y coordinate of the newly constructed RoundRectangle2D - `double`
  w - the width to which to set the newly constructed RoundRectangle2D - `double`
  h - the height to which to set the newly constructed RoundRectangle2D - `double`
  arcw - the width of the arc to use to round off the corners of the newly constructed RoundRectangle2D - `double`
  arch - the height of the arc to use to round off the corners of the newly constructed RoundRectangle2D - `double`"
  ([^Double x ^Double y ^Double w ^Double h ^Double arcw ^Double arch]
    (new RoundRectangle2D$Double x y w h arcw arch))
  ([]
    (new RoundRectangle2D$Double )))

(defn -x
  "Instance Field.

  The X coordinate of this RoundRectangle2D.

  type: double"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The Y coordinate of this RoundRectangle2D.

  type: double"
  [this]
  (-> this .-y))

(defn -width
  "Instance Field.

  The width of this RoundRectangle2D.

  type: double"
  [this]
  (-> this .-width))

(defn -height
  "Instance Field.

  The height of this RoundRectangle2D.

  type: double"
  [this]
  (-> this .-height))

(defn -arcwidth
  "Instance Field.

  The width of the arc that rounds off the corners.

  type: double"
  [this]
  (-> this .-arcwidth))

(defn -archeight
  "Instance Field.

  The height of the arc that rounds off the corners.

  type: double"
  [this]
  (-> this .-archeight))

(defn get-width
  "Returns the width of the framing rectangle in
   double precision.

  returns: the width of the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.getWidth))))

(defn set-round-rect
  "Sets the location, size, and corner radii of this
   RoundRectangle2D to the specified
   double values.

  x - the X coordinate to which to set the location of this RoundRectangle2D - `double`
  y - the Y coordinate to which to set the location of this RoundRectangle2D - `double`
  w - the width to which to set this RoundRectangle2D - `double`
  h - the height to which to set this RoundRectangle2D - `double`
  arcw - the width to which to set the arc of this RoundRectangle2D - `double`
  arch - the height to which to set the arc of this RoundRectangle2D - `double`"
  ([^java.awt.geom.RoundRectangle2D$Double this ^Double x ^Double y ^Double w ^Double h ^Double arcw ^Double arch]
    (-> this (.setRoundRect x y w h arcw arch)))
  ([^java.awt.geom.RoundRectangle2D$Double this ^java.awt.geom.RoundRectangle2D rr]
    (-> this (.setRoundRect rr))))

(defn get-arc-width
  "Gets the width of the arc that rounds off the corners.

  returns: the width of the arc that rounds off the corners
   of this RoundRectangle2D. - `double`"
  (^Double [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.getArcWidth))))

(defn get-y
  "Returns the Y coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the Y coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.getY))))

(defn get-x
  "Returns the X coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the X coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.getX))))

(defn get-height
  "Returns the height of the framing rectangle
   in double precision.

  returns: the height of the framing rectangle. - `double`"
  (^Double [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.getHeight))))

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
  (^java.awt.geom.Rectangle2D [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.getBounds2D))))

(defn get-arc-height
  "Gets the height of the arc that rounds off the corners.

  returns: the height of the arc that rounds off the corners
   of this RoundRectangle2D. - `double`"
  (^Double [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.getArcHeight))))

(defn empty?
  "Determines whether the RectangularShape is empty.
   When the RectangularShape is empty, it encloses no
   area.

  returns: true if the RectangularShape is empty;
            false otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.RoundRectangle2D$Double this]
    (-> this (.isEmpty))))

