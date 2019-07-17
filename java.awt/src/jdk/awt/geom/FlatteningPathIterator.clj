(ns jdk.awt.geom.FlatteningPathIterator
  "The FlatteningPathIterator class returns a flattened view of
  another PathIterator object.  Other Shape
  classes can use this class to provide flattening behavior for their paths
  without having to perform the interpolation calculations themselves."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom FlatteningPathIterator]))

(defn ->flattening-path-iterator
  "Constructor.

  Constructs a new FlatteningPathIterator object
   that flattens a path as it iterates over it.
   The limit parameter allows you to control the
   maximum number of recursive subdivisions that the iterator
   can make before it assumes that the curve is flat enough
   without measuring against the flatness parameter.
   The flattened iteration therefore never generates more than
   a maximum of (2^limit) line segments per curve.

  src - the original unflattened path being iterated over - `java.awt.geom.PathIterator`
  flatness - the maximum allowable distance between the control points and the flattened curve - `double`
  limit - the maximum number of recursive subdivisions allowed for any curved segment - `int`

  throws: java.lang.IllegalArgumentException - if flatness or limit is less than zero"
  ([^java.awt.geom.PathIterator src ^Double flatness ^Integer limit]
    (new FlatteningPathIterator src flatness limit))
  ([^java.awt.geom.PathIterator src ^Double flatness]
    (new FlatteningPathIterator src flatness)))

(defn get-flatness
  "Returns the flatness of this iterator.

  returns: the flatness of this FlatteningPathIterator. - `double`"
  (^Double [^java.awt.geom.FlatteningPathIterator this]
    (-> this (.getFlatness))))

(defn get-recursion-limit
  "Returns the recursion limit of this iterator.

  returns: the recursion limit of this
   FlatteningPathIterator. - `int`"
  (^Integer [^java.awt.geom.FlatteningPathIterator this]
    (-> this (.getRecursionLimit))))

(defn get-winding-rule
  "Returns the winding rule for determining the interior of the
   path.

  returns: the winding rule of the original unflattened path being
   iterated over. - `int`"
  (^Integer [^java.awt.geom.FlatteningPathIterator this]
    (-> this (.getWindingRule))))

(defn done?
  "Tests if the iteration is complete.

  returns: true if all the segments have
   been read; false otherwise. - `boolean`"
  (^Boolean [^java.awt.geom.FlatteningPathIterator this]
    (-> this (.isDone))))

(defn next
  "Moves the iterator to the next segment of the path forwards
   along the primary direction of traversal as long as there are
   more points in that direction."
  ([^java.awt.geom.FlatteningPathIterator this]
    (-> this (.next))))

(defn current-segment
  "Returns the coordinates and type of the current path segment in
   the iteration.
   The return value is the path segment type:
   SEG_MOVETO, SEG_LINETO, or SEG_CLOSE.
   A float array of length 6 must be passed in and can be used to
   store the coordinates of the point(s).
   Each point is stored as a pair of float x,y coordinates.
   SEG_MOVETO and SEG_LINETO types return one point,
   and SEG_CLOSE does not return any points.

  coords - an array that holds the data returned from this method - `float[]`

  returns: the path segment type of the current path segment. - `int`

  throws: java.util.NoSuchElementException - if there are no more elements in the flattening path to be returned."
  (^Integer [^java.awt.geom.FlatteningPathIterator this coords]
    (-> this (.currentSegment coords))))

