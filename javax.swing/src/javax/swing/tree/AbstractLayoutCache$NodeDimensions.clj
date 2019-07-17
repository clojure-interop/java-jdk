(ns javax.swing.tree.AbstractLayoutCache$NodeDimensions
  "Used by AbstractLayoutCache to determine the size
  and x origin of a particular node."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree AbstractLayoutCache$NodeDimensions]))

(defn ->node-dimensions
  "Constructor."
  ([]
    (new AbstractLayoutCache$NodeDimensions )))

(defn get-node-dimensions
  "Returns, by reference in bounds, the size and x origin to
   place value at. The calling method is responsible for determining
   the Y location. If bounds is null, a newly created
   Rectangle should be returned,
   otherwise the value should be placed in bounds and returned.

  value - the value to be represented - `java.lang.Object`
  row - row being queried - `int`
  depth - the depth of the row - `int`
  expanded - true if row is expanded, false otherwise - `boolean`
  bounds - a Rectangle containing the size needed to represent value - `java.awt.Rectangle`

  returns: a Rectangle containing the node dimensions,
                or null if node has no dimension - `java.awt.Rectangle`"
  ([^javax.swing.tree.AbstractLayoutCache$NodeDimensions this ^java.lang.Object value ^Integer row ^Integer depth ^Boolean expanded ^java.awt.Rectangle bounds]
    (-> this (.getNodeDimensions value row depth expanded bounds))))

