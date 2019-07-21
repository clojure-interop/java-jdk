(ns jdk.awt.geom.Rectangle2D$Float
  "The Float class defines a rectangle specified in float
  coordinates."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Rectangle2D$Float]))

(defn ->float
  "Constructor.

  Constructs and initializes a Rectangle2D
   from the specified float coordinates.

  x - the X coordinate of the upper-left corner of the newly constructed Rectangle2D - `float`
  y - the Y coordinate of the upper-left corner of the newly constructed Rectangle2D - `float`
  w - the width of the newly constructed Rectangle2D - `float`
  h - the height of the newly constructed Rectangle2D - `float`"
  (^Rectangle2D$Float [^Float x ^Float y ^Float w ^Float h]
    (new Rectangle2D$Float x y w h))
  (^Rectangle2D$Float []
    (new Rectangle2D$Float )))

(defn x
  "Instance Field.

  The X coordinate of this Rectangle2D.

  type: float"
  (^Float [^Rectangle2D$Float this]
    (-> this .-x)))

(defn y
  "Instance Field.

  The Y coordinate of this Rectangle2D.

  type: float"
  (^Float [^Rectangle2D$Float this]
    (-> this .-y)))

(defn width
  "Instance Field.

  The width of this Rectangle2D.

  type: float"
  (^Float [^Rectangle2D$Float this]
    (-> this .-width)))

(defn height
  "Instance Field.

  The height of this Rectangle2D.

  type: float"
  (^Float [^Rectangle2D$Float this]
    (-> this .-height)))

(defn set-rect
  "Sets the location and size of this Rectangle2D
   to the specified float values.

  x - the X coordinate of the upper-left corner of this Rectangle2D - `float`
  y - the Y coordinate of the upper-left corner of this Rectangle2D - `float`
  w - the width of this Rectangle2D - `float`
  h - the height of this Rectangle2D - `float`"
  ([^Rectangle2D$Float this ^Float x ^Float y ^Float w ^Float h]
    (-> this (.setRect x y w h)))
  ([^Rectangle2D$Float this ^java.awt.geom.Rectangle2D r]
    (-> this (.setRect r))))

(defn get-width
  "Returns the width of the framing rectangle in
   double precision.

  returns: the width of the framing rectangle. - `double`"
  (^Double [^Rectangle2D$Float this]
    (-> this (.getWidth))))

(defn to-string
  "Returns the String representation of this
   Rectangle2D.

  returns: a String representing this
   Rectangle2D. - `java.lang.String`"
  (^java.lang.String [^Rectangle2D$Float this]
    (-> this (.toString))))

(defn create-intersection
  "Returns a new Rectangle2D object representing the
   intersection of this Rectangle2D with the specified
   Rectangle2D.

  r - the Rectangle2D to be intersected with this Rectangle2D - `java.awt.geom.Rectangle2D`

  returns: the largest Rectangle2D contained in both
            the specified Rectangle2D and in this
            Rectangle2D. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^Rectangle2D$Float this ^java.awt.geom.Rectangle2D r]
    (-> this (.createIntersection r))))

(defn get-y
  "Returns the Y coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the Y coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^Rectangle2D$Float this]
    (-> this (.getY))))

(defn create-union
  "Returns a new Rectangle2D object representing the
   union of this Rectangle2D with the specified
   Rectangle2D.

  r - the Rectangle2D to be combined with this Rectangle2D - `java.awt.geom.Rectangle2D`

  returns: the smallest Rectangle2D containing both
   the specified Rectangle2D and this
   Rectangle2D. - `java.awt.geom.Rectangle2D`"
  (^java.awt.geom.Rectangle2D [^Rectangle2D$Float this ^java.awt.geom.Rectangle2D r]
    (-> this (.createUnion r))))

(defn get-x
  "Returns the X coordinate of the upper-left corner of
   the framing rectangle in double precision.

  returns: the X coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  (^Double [^Rectangle2D$Float this]
    (-> this (.getX))))

(defn get-height
  "Returns the height of the framing rectangle
   in double precision.

  returns: the height of the framing rectangle. - `double`"
  (^Double [^Rectangle2D$Float this]
    (-> this (.getHeight))))

(defn outcode
  "Determines where the specified coordinates lie with respect
   to this Rectangle2D.
   This method computes a binary OR of the appropriate mask values
   indicating, for each side of this Rectangle2D,
   whether or not the specified coordinates are on the same side
   of the edge as the rest of this Rectangle2D.

  x - the specified X coordinate - `double`
  y - the specified Y coordinate - `double`

  returns: the logical OR of all appropriate out codes. - `int`"
  (^Integer [^Rectangle2D$Float this ^Double x ^Double y]
    (-> this (.outcode x y))))

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
  (^java.awt.geom.Rectangle2D [^Rectangle2D$Float this]
    (-> this (.getBounds2D))))

(defn empty?
  "Determines whether the RectangularShape is empty.
   When the RectangularShape is empty, it encloses no
   area.

  returns: true if the RectangularShape is empty;
            false otherwise. - `boolean`"
  (^Boolean [^Rectangle2D$Float this]
    (-> this (.isEmpty))))

