(ns jdk.awt.geom.PathIterator
  "The PathIterator interface provides the mechanism
  for objects that implement the Shape
  interface to return the geometry of their boundary by allowing
  a caller to retrieve the path of that boundary a segment at a
  time.  This interface allows these objects to retrieve the path of
  their boundary a segment at a time by using 1st through 3rd order
  Bézier curves, which are lines and quadratic or cubic
  Bézier splines.

  Multiple subpaths can be expressed by using a `MOVETO` segment to
  create a discontinuity in the geometry to move from the end of
  one subpath to the beginning of the next.

  Each subpath can be closed manually by ending the last segment in
  the subpath on the same coordinate as the beginning `MOVETO` segment
  for that subpath or by using a `CLOSE` segment to append a line
  segment from the last point back to the first.
  Be aware that manually closing an outline as opposed to using a
  `CLOSE` segment to close the path might result in different line
  style decorations being used at the end points of the subpath.
  For example, the BasicStroke object
  uses a line `JOIN` decoration to connect the first and last points
  if a `CLOSE` segment is encountered, whereas simply ending the path
  on the same coordinate as the beginning coordinate results in line
  `CAP` decorations being used at the ends."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom PathIterator]))

(defn get-winding-rule
  "Returns the winding rule for determining the interior of the
   path.

  returns: the winding rule. - `int`"
  ([^. this]
    (-> this (.getWindingRule))))

(defn done?
  "Tests if the iteration is complete.

  returns: true if all the segments have
   been read; false otherwise. - `boolean`"
  ([^. this]
    (-> this (.isDone))))

(defn next
  "Moves the iterator to the next segment of the path forwards
   along the primary direction of traversal as long as there are
   more points in that direction."
  ([^. this]
    (-> this (.next))))

(defn current-segment
  "Returns the coordinates and type of the current path segment in
   the iteration.
   The return value is the path-segment type:
   SEG_MOVETO, SEG_LINETO, SEG_QUADTO, SEG_CUBICTO, or SEG_CLOSE.
   A float array of length 6 must be passed in and can be used to
   store the coordinates of the point(s).
   Each point is stored as a pair of float x,y coordinates.
   SEG_MOVETO and SEG_LINETO types returns one point,
   SEG_QUADTO returns two points,
   SEG_CUBICTO returns 3 points
   and SEG_CLOSE does not return any points.

  coords - an array that holds the data returned from this method - `float[]`

  returns: the path-segment type of the current path segment. - `int`"
  ([^. this coords]
    (-> this (.currentSegment coords))))

