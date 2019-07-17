(ns jdk.awt.Point
  "A point representing a location in (x,y) coordinate space,
  specified in integer precision."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Point]))

(defn ->point
  "Constructor.

  Constructs and initializes a point at the specified
   (x,y) location in the coordinate space.

  x - the X coordinate of the newly constructed Point - `int`
  y - the Y coordinate of the newly constructed Point - `int`"
  ([^Integer x ^Integer y]
    (new Point x y))
  ([^java.awt.Point p]
    (new Point p))
  ([]
    (new Point )))

(defn -x
  "Instance Field.

  The X coordinate of this Point.
   If no X coordinate is set it will default to 0.

  type: int"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The Y coordinate of this Point.
   If no Y coordinate is set it will default to 0.

  type: int"
  [this]
  (-> this .-y))

(defn get-x
  "Returns the X coordinate of this Point2D in
   double precision.

  returns: the X coordinate of this Point2D. - `double`"
  (^Double [^java.awt.Point this]
    (-> this (.getX))))

(defn get-y
  "Returns the Y coordinate of this Point2D in
   double precision.

  returns: the Y coordinate of this Point2D. - `double`"
  (^Double [^java.awt.Point this]
    (-> this (.getY))))

(defn get-location
  "Returns the location of this point.
   This method is included for completeness, to parallel the
   getLocation method of Component.

  returns: a copy of this point, at the same location - `java.awt.Point`"
  (^java.awt.Point [^java.awt.Point this]
    (-> this (.getLocation))))

(defn set-location
  "Changes the point to have the specified location.

   This method is included for completeness, to parallel the
   setLocation method of Component.
   Its behavior is identical with move(int, int).

  x - the X coordinate of the new location - `int`
  y - the Y coordinate of the new location - `int`"
  ([^java.awt.Point this ^Integer x ^Integer y]
    (-> this (.setLocation x y)))
  ([^java.awt.Point this ^java.awt.Point p]
    (-> this (.setLocation p))))

(defn move
  "Moves this point to the specified location in the
   (x,y) coordinate plane. This method
   is identical with setLocation(int, int).

  x - the X coordinate of the new location - `int`
  y - the Y coordinate of the new location - `int`"
  ([^java.awt.Point this ^Integer x ^Integer y]
    (-> this (.move x y))))

(defn translate
  "Translates this point, at location (x,y),
   by dx along the x axis and dy
   along the y axis so that it now represents the point
   (x+dx,y+dy).

  dx - the distance to move this point along the X axis - `int`
  dy - the distance to move this point along the Y axis - `int`"
  ([^java.awt.Point this ^Integer dx ^Integer dy]
    (-> this (.translate dx dy))))

(defn equals
  "Determines whether or not two points are equal. Two instances of
   Point2D are equal if the values of their
   x and y member fields, representing
   their position in the coordinate space, are the same.

  obj - an object to be compared with this Point2D - `java.lang.Object`

  returns: true if the object to be compared is
           an instance of Point2D and has
           the same values; false otherwise. - `boolean`"
  (^Boolean [^java.awt.Point this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a string representation of this point and its location
   in the (x,y) coordinate space. This method is
   intended to be used only for debugging purposes, and the content
   and format of the returned string may vary between implementations.
   The returned string may be empty but may not be null.

  returns: a string representation of this point - `java.lang.String`"
  (^java.lang.String [^java.awt.Point this]
    (-> this (.toString))))

