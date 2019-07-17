(ns jdk.awt.geom.Point2D$Double
  "The Double class defines a point specified in
  double precision."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Point2D$Double]))

(defn ->double
  "Constructor.

  Constructs and initializes a Point2D with the
   specified coordinates.

  x - the X coordinate of the newly constructed Point2D - `double`
  y - the Y coordinate of the newly constructed Point2D - `double`"
  ([^Double x ^Double y]
    (new Point2D$Double x y))
  ([]
    (new Point2D$Double )))

(defn -x
  "Instance Field.

  The X coordinate of this Point2D.

  type: double"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The Y coordinate of this Point2D.

  type: double"
  [this]
  (-> this .-y))

(defn get-x
  "Returns the X coordinate of this Point2D in
   double precision.

  returns: the X coordinate of this Point2D. - `double`"
  (^Double [^java.awt.geom.Point2D$Double this]
    (-> this (.getX))))

(defn get-y
  "Returns the Y coordinate of this Point2D in
   double precision.

  returns: the Y coordinate of this Point2D. - `double`"
  (^Double [^java.awt.geom.Point2D$Double this]
    (-> this (.getY))))

(defn set-location
  "Sets the location of this Point2D to the
   specified double coordinates.

  x - the new X coordinate of this Point2D - `double`
  y - the new Y coordinate of this Point2D - `double`"
  ([^java.awt.geom.Point2D$Double this ^Double x ^Double y]
    (-> this (.setLocation x y))))

(defn to-string
  "Returns a String that represents the value
   of this Point2D.

  returns: a string representation of this Point2D. - `java.lang.String`"
  (^java.lang.String [^java.awt.geom.Point2D$Double this]
    (-> this (.toString))))

