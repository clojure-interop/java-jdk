(ns jdk.awt.geom.Point2D$Float
  "The Float class defines a point specified in float
  precision."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Point2D$Float]))

(defn ->float
  "Constructor.

  Constructs and initializes a Point2D with
   the specified coordinates.

  x - the X coordinate of the newly constructed Point2D - `float`
  y - the Y coordinate of the newly constructed Point2D - `float`"
  (^Point2D$Float [^Float x ^Float y]
    (new Point2D$Float x y))
  (^Point2D$Float []
    (new Point2D$Float )))

(defn -x
  "Instance Field.

  The X coordinate of this Point2D.

  type: float"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The Y coordinate of this Point2D.

  type: float"
  [this]
  (-> this .-y))

(defn get-x
  "Returns the X coordinate of this Point2D in
   double precision.

  returns: the X coordinate of this Point2D. - `double`"
  (^Double [^Point2D$Float this]
    (-> this (.getX))))

(defn get-y
  "Returns the Y coordinate of this Point2D in
   double precision.

  returns: the Y coordinate of this Point2D. - `double`"
  (^Double [^Point2D$Float this]
    (-> this (.getY))))

(defn set-location
  "Sets the location of this Point2D to the
   specified double coordinates.

  x - the new X coordinate of this Point2D - `double`
  y - the new Y coordinate of this Point2D - `double`"
  ([^Point2D$Float this ^Double x ^Double y]
    (-> this (.setLocation x y))))

(defn to-string
  "Returns a String that represents the value
   of this Point2D.

  returns: a string representation of this Point2D. - `java.lang.String`"
  (^java.lang.String [^Point2D$Float this]
    (-> this (.toString))))

