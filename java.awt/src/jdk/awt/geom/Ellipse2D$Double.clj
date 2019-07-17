(ns jdk.awt.geom.Ellipse2D$Double
  "The Double class defines an ellipse specified
  in double precision."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Ellipse2D$Double]))

(defn ->double
  "Constructor.

  Constructs and initializes an Ellipse2D from the
   specified coordinates.

  x - the X coordinate of the upper-left corner of the framing rectangle - `double`
  y - the Y coordinate of the upper-left corner of the framing rectangle - `double`
  w - the width of the framing rectangle - `double`
  h - the height of the framing rectangle - `double`"
  ([^Double x ^Double y ^Double w ^Double h]
    (new Ellipse2D$Double x y w h))
  ([]
    (new Ellipse2D$Double )))

(defn -x
  "Instance Field.

  The X coordinate of the upper-left corner of the
   framing rectangle of this Ellipse2D.

  type: double"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The Y coordinate of the upper-left corner of the
   framing rectangle of this Ellipse2D.

  type: double"
  [this]
  (-> this .-y))

(defn -width
  "Instance Field.

  The overall width of this Ellipse2D.

  type: double"
  [this]
  (-> this .-width))

(defn -height
  "Instance Field.

  The overall height of the Ellipse2D.

  type: double"
  [this]
  (-> this .-height))

(defn get-x
  "Returns the X coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the X coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  ([^java.awt.geom.Ellipse2D$Double this]
    (-> this (.getX))))

(defn get-y
  "Returns the Y coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the Y coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  ([^java.awt.geom.Ellipse2D$Double this]
    (-> this (.getY))))

(defn get-width
  "Returns the width of the framing rectangle in
   double precision.

  returns: the width of the framing rectangle. - `double`"
  ([^java.awt.geom.Ellipse2D$Double this]
    (-> this (.getWidth))))

(defn get-height
  "Returns the height of the framing rectangle
   in double precision.

  returns: the height of the framing rectangle. - `double`"
  ([^java.awt.geom.Ellipse2D$Double this]
    (-> this (.getHeight))))

(defn empty?
  "Determines whether the RectangularShape is empty.
   When the RectangularShape is empty, it encloses no
   area.

  returns: true if the RectangularShape is empty;
            false otherwise. - `boolean`"
  ([^java.awt.geom.Ellipse2D$Double this]
    (-> this (.isEmpty))))

(defn set-frame
  "Sets the location and size of the framing rectangle of this
   Shape to the specified rectangular values.

  x - the X coordinate of the upper-left corner of the specified rectangular shape - `double`
  y - the Y coordinate of the upper-left corner of the specified rectangular shape - `double`
  w - the width of the specified rectangular shape - `double`
  h - the height of the specified rectangular shape - `double`"
  ([^java.awt.geom.Ellipse2D$Double this ^Double x ^Double y ^Double w ^Double h]
    (-> this (.setFrame x y w h))))

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
  ([^java.awt.geom.Ellipse2D$Double this]
    (-> this (.getBounds2D))))

