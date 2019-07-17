(ns jdk.awt.geom.GeneralPath
  "The GeneralPath class represents a geometric path
  constructed from straight lines, and quadratic and cubic
  (Bézier) curves.  It can contain multiple subpaths.

  GeneralPath is a legacy final class which exactly
  implements the behavior of its superclass Path2D.Float.
  Together with Path2D.Double, the Path2D classes
  provide full implementations of a general geometric path that
  support all of the functionality of the Shape and
  PathIterator interfaces with the ability to explicitly
  select different levels of internal coordinate precision.

  Use Path2D.Float (or this legacy GeneralPath
  subclass) when dealing with data that can be represented
  and used with floating point precision.  Use Path2D.Double
  for data that requires the accuracy or range of double precision."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom GeneralPath]))

(defn ->general-path
  "Constructor.

  Constructs a new GeneralPath object with the specified
   winding rule and the specified initial capacity to store path
   coordinates.
   This number is an initial guess as to how many path segments
   will be added to the path, but the storage is expanded as
   needed to store whatever path segments are added.

  rule - the winding rule - `int`
  initial-capacity - the estimate for the number of path segments in the path - `int`"
  ([^Integer rule ^Integer initial-capacity]
    (new GeneralPath rule initial-capacity))
  ([^Integer rule]
    (new GeneralPath rule))
  ([]
    (new GeneralPath )))

