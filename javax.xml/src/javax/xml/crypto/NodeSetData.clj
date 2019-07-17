(ns javax.xml.crypto.NodeSetData
  "An abstract representation of a Data type containing a
  node-set. The type (class) and ordering of the nodes contained in the set
  are not defined by this class; instead that behavior should be
  defined by NodeSetData subclasses."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto NodeSetData]))

(defn iterator
  "Returns a read-only iterator over the nodes contained in this
   NodeSetData in

   document order. Attempts to modify the returned iterator
   via the remove method throw
   UnsupportedOperationException.

  returns: an Iterator over the nodes in this
      NodeSetData in document order - `java.util.Iterator`"
  (^java.util.Iterator [^javax.xml.crypto.NodeSetData this]
    (-> this (.iterator))))

