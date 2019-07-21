(ns jdk.awt.geom.Ellipse2D$Float
  "The Float class defines an ellipse specified
  in float precision."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Ellipse2D$Float]))

(defn ->float
  "Constructor.

  Constructs and initializes an Ellipse2D from the
   specified coordinates.

  x - the X coordinate of the upper-left corner of the framing rectangle - `float`
  y - the Y coordinate of the upper-left corner of the framing rectangle - `float`
  w - the width of the framing rectangle - `float`
  h - the height of the framing rectangle - `float`"
  (^Ellipse2D$Float [^Float x ^Float y ^Float w ^Float h]
    (new Ellipse2D$Float x y w h))
  (^Ellipse2D$Float []
    (new Ellipse2D$Float )))

(defn x
  "Instance Field.

  The X coordinate of the upper-left corner of the
   framing rectangle of this Ellipse2D.

  type: float"
  (^Float [^Ellipse2D$Float this]
    (-> this .-x)))

(defn y
  "Instance Field.

  The Y coordinate of the upper-left corner of the
   framing rectangle of this Ellipse2D.

  type: float"
  (^Float [^Ellipse2D$Float this]
    (-> this .-y)))

(defn width
  "Instance Field.

  The overall width of this Ellipse2D.

  type: float"
  (^Float [^Ellipse2D$Float this]
    (-> this .-width)))

(defn height
  "Instance Field.

  The overall height of this Ellipse2D.

  type: float"
  (^Float [^Ellipse2D$Float this]
    (-> this .-height)))

(defn get-x
  "Returns the X coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the X coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^Ellipse2D$Float this]
    (-> this (.getX))))

(defn get-y
  "Returns the Y coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the Y coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^Ellipse2D$Float this]
    (-> this (.getY))))

(defn get-width
  "Returns the width of the framing rectangle in
   double precision.

  returns: the width of the framing rectangle. - `double`"
  (^Double [^Ellipse2D$Float this]
    (-> this (.getWidth))))

(defn get-height
  "Returns the height of the framing rectangle
   in double precision.

  returns: the height of the framing rectangle. - `double`"
  (^Double [^Ellipse2D$Float this]
    (-> this (.getHeight))))

(defn empty?
  "Determines whether the RectangularShape is empty.
   When the RectangularShape is empty, it encloses no
   area.

  returns: true if the RectangularShape is empty;
            false otherwise. - `boolean`"
  (^Boolean [^Ellipse2D$Float this]
    (-> this (.isEmpty))))

(defn set-frame
  "Sets the location and size of the framing rectangle of this
   Shape to the specified rectangular values.

  x - the X coordinate of the upper-left corner of the specified rectangular shape - `float`
  y - the Y coordinate of the upper-left corner of the specified rectangular shape - `float`
  w - the width of the specified rectangular shape - `float`
  h - the height of the specified rectangular shape - `float`"
  ([^Ellipse2D$Float this ^Float x ^Float y ^Float w ^Float h]
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
  (^java.awt.geom.Rectangle2D [^Ellipse2D$Float this]
    (-> this (.getBounds2D))))

