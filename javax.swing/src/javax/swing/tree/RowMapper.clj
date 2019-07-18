(ns javax.swing.tree.RowMapper
  "Defines the requirements for an object that translates paths in
  the tree into display rows."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.tree RowMapper]))

(defn get-rows-for-paths
  "Returns the rows that the TreePath instances in path
   are being displayed at. The receiver should return an array of
   the same length as that passed in, and if one of the TreePaths
   in path is not valid its entry in the array should
   be set to -1.

  path - `javax.swing.tree.TreePath[]`

  returns: `int[]`"
  ([^RowMapper this path]
    (-> this (.getRowsForPaths path))))

