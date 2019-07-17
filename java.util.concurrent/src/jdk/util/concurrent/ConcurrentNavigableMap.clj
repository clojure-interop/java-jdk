(ns jdk.util.concurrent.ConcurrentNavigableMap
  "A ConcurrentMap supporting NavigableMap operations,
  and recursively so for its navigable sub-maps.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentNavigableMap]))

(defn sub-map
  "Description copied from interface: NavigableMap

  from-key - low endpoint of the keys in the returned map - `ConcurrentNavigableMap.K`
  from-inclusive - true if the low endpoint is to be included in the returned view - `boolean`
  to-key - high endpoint of the keys in the returned map - `ConcurrentNavigableMap.K`
  to-inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys range from
           fromKey to toKey - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentNavigableMap.K,ConcurrentNavigableMap.V>`

  throws: java.lang.ClassCastException - if fromKey and toKey cannot be compared to one another using this map's comparator (or, if the map has no comparator, using natural ordering). Implementations may, but are not required to, throw this exception if fromKey or toKey cannot be compared to keys currently in the map."
  ([this from-key from-inclusive to-key to-inclusive]
    (-> this (.subMap from-key from-inclusive to-key to-inclusive)))
  ([this from-key to-key]
    (-> this (.subMap from-key to-key))))

(defn head-map
  "Description copied from interface: NavigableMap

  to-key - high endpoint of the keys in the returned map - `ConcurrentNavigableMap.K`
  inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are less than
           (or equal to, if inclusive is true) toKey - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentNavigableMap.K,ConcurrentNavigableMap.V>`

  throws: java.lang.ClassCastException - if toKey is not compatible with this map's comparator (or, if the map has no comparator, if toKey does not implement Comparable). Implementations may, but are not required to, throw this exception if toKey cannot be compared to keys currently in the map."
  ([this to-key inclusive]
    (-> this (.headMap to-key inclusive)))
  ([this to-key]
    (-> this (.headMap to-key))))

(defn tail-map
  "Description copied from interface: NavigableMap

  from-key - low endpoint of the keys in the returned map - `ConcurrentNavigableMap.K`
  inclusive - true if the low endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are greater than
           (or equal to, if inclusive is true) fromKey - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentNavigableMap.K,ConcurrentNavigableMap.V>`

  throws: java.lang.ClassCastException - if fromKey is not compatible with this map's comparator (or, if the map has no comparator, if fromKey does not implement Comparable). Implementations may, but are not required to, throw this exception if fromKey cannot be compared to keys currently in the map."
  ([this from-key inclusive]
    (-> this (.tailMap from-key inclusive)))
  ([this from-key]
    (-> this (.tailMap from-key))))

(defn descending-map
  "Returns a reverse order view of the mappings contained in this map.
   The descending map is backed by this map, so changes to the map are
   reflected in the descending map, and vice-versa.

   The returned map has an ordering equivalent to
   Collections.reverseOrder(comparator()).
   The expression m.descendingMap().descendingMap() returns a
   view of m essentially equivalent to m.

  returns: a reverse order view of this map - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentNavigableMap.K,ConcurrentNavigableMap.V>`"
  ([this]
    (-> this (.descendingMap))))

(defn navigable-key-set
  "Returns a NavigableSet view of the keys contained in this map.
   The set's iterator returns the keys in ascending order.
   The set is backed by the map, so changes to the map are
   reflected in the set, and vice-versa.  The set supports element
   removal, which removes the corresponding mapping from the map,
   via the Iterator.remove, Set.remove,
   removeAll, retainAll, and clear
   operations.  It does not support the add or addAll
   operations.

   The view's iterators and spliterators are
   weakly consistent.

  returns: a navigable set view of the keys in this map - `java.util.NavigableSet<ConcurrentNavigableMap.K>`"
  ([this]
    (-> this (.navigableKeySet))))

(defn key-set
  "Returns a NavigableSet view of the keys contained in this map.
   The set's iterator returns the keys in ascending order.
   The set is backed by the map, so changes to the map are
   reflected in the set, and vice-versa.  The set supports element
   removal, which removes the corresponding mapping from the map,
   via the Iterator.remove, Set.remove,
   removeAll, retainAll, and clear
   operations.  It does not support the add or addAll
   operations.

   The view's iterators and spliterators are
   weakly consistent.

   This method is equivalent to method navigableKeySet.

  returns: a navigable set view of the keys in this map - `java.util.NavigableSet<ConcurrentNavigableMap.K>`"
  ([this]
    (-> this (.keySet))))

(defn descending-key-set
  "Returns a reverse order NavigableSet view of the keys contained in this map.
   The set's iterator returns the keys in descending order.
   The set is backed by the map, so changes to the map are
   reflected in the set, and vice-versa.  The set supports element
   removal, which removes the corresponding mapping from the map,
   via the Iterator.remove, Set.remove,
   removeAll, retainAll, and clear
   operations.  It does not support the add or addAll
   operations.

   The view's iterators and spliterators are
   weakly consistent.

  returns: a reverse order navigable set view of the keys in this map - `java.util.NavigableSet<ConcurrentNavigableMap.K>`"
  ([this]
    (-> this (.descendingKeySet))))

