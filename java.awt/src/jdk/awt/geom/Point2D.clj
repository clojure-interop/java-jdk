(ns jdk.awt.geom.Point2D
  "The Point2D class defines a point representing a location
  in (x,y) coordinate space.

  This class is only the abstract superclass for all objects that
  store a 2D coordinate.
  The actual storage representation of the coordinates is left to
  the subclass."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Point2D]))

(defn *distance-sq
  "Returns the square of the distance between two points.

  x-1 - the X coordinate of the first specified point - `double`
  y-1 - the Y coordinate of the first specified point - `double`
  x-2 - the X coordinate of the second specified point - `double`
  y-2 - the Y coordinate of the second specified point - `double`

  returns: the square of the distance between the two
   sets of specified coordinates. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (Point2D/distanceSq x-1 y-1 x-2 y-2)))

(defn *distance
  "Returns the distance between two points.

  x-1 - the X coordinate of the first specified point - `double`
  y-1 - the Y coordinate of the first specified point - `double`
  x-2 - the X coordinate of the second specified point - `double`
  y-2 - the Y coordinate of the second specified point - `double`

  returns: the distance between the two sets of specified
   coordinates. - `double`"
  (^Double [^Double x-1 ^Double y-1 ^Double x-2 ^Double y-2]
    (Point2D/distance x-1 y-1 x-2 y-2)))

(defn get-x
  "Returns the X coordinate of this Point2D in
   double precision.

  returns: the X coordinate of this Point2D. - `double`"
  (^Double [^Point2D this]
    (-> this (.getX))))

(defn get-y
  "Returns the Y coordinate of this Point2D in
   double precision.

  returns: the Y coordinate of this Point2D. - `double`"
  (^Double [^Point2D this]
    (-> this (.getY))))

(defn set-location
  "Sets the location of this Point2D to the
   specified double coordinates.

  x - the new X coordinate of this Point2D - `double`
  y - the new Y coordinate of this Point2D - `double`"
  ([^Point2D this ^Double x ^Double y]
    (-> this (.setLocation x y)))
  ([^Point2D this ^java.awt.geom.Point2D p]
    (-> this (.setLocation p))))

(defn distance-sq
  "Returns the square of the distance from this
   Point2D to a specified point.

  px - the X coordinate of the specified point to be measured against this Point2D - `double`
  py - the Y coordinate of the specified point to be measured against this Point2D - `double`

  returns: the square of the distance between this
   Point2D and the specified point. - `double`"
  (^Double [^Point2D this ^Double px ^Double py]
    (-> this (.distanceSq px py)))
  (^Double [^Point2D this ^java.awt.geom.Point2D pt]
    (-> this (.distanceSq pt))))

(defn distance
  "Returns the distance from this Point2D to
   a specified point.

  px - the X coordinate of the specified point to be measured against this Point2D - `double`
  py - the Y coordinate of the specified point to be measured against this Point2D - `double`

  returns: the distance between this Point2D
   and a specified point. - `double`"
  (^Double [^Point2D this ^Double px ^Double py]
    (-> this (.distance px py)))
  (^Double [^Point2D this ^java.awt.geom.Point2D pt]
    (-> this (.distance pt))))

(defn clone
  "Creates a new object of the same class and with the
   same contents as this object.

  returns: a clone of this instance. - `java.lang.Object`

  throws: java.lang.OutOfMemoryError - if there is not enough memory."
  (^java.lang.Object [^Point2D this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hashcode for this Point2D.

  returns: a hash code for this Point2D. - `int`"
  (^Integer [^Point2D this]
    (-> this (.hashCode))))

(defn equals
  "Determines whether or not two points are equal. Two instances of
   Point2D are equal if the values of their
   x and y member fields, representing
   their position in the coordinate space, are the same.

  obj - an object to be compared with this Point2D - `java.lang.Object`

  returns: true if the object to be compared is
           an instance of Point2D and has
           the same values; false otherwise. - `boolean`"
  (^Boolean [^Point2D this ^java.lang.Object obj]
    (-> this (.equals obj))))

