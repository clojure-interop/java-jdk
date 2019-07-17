(ns jdk.util.NavigableMap
  "A SortedMap extended with navigation methods returning the
  closest matches for given search targets. Methods
  lowerEntry, floorEntry, ceilingEntry,
  and higherEntry return Map.Entry objects
  associated with keys respectively less than, less than or equal,
  greater than or equal, and greater than a given key, returning
  null if there is no such key.  Similarly, methods
  lowerKey, floorKey, ceilingKey, and
  higherKey return only the associated keys. All of these
  methods are designed for locating, not traversing entries.

  A NavigableMap may be accessed and traversed in either
  ascending or descending key order.  The descendingMap
  method returns a view of the map with the senses of all relational
  and directional methods inverted. The performance of ascending
  operations and views is likely to be faster than that of descending
  ones.  Methods subMap, headMap,
  and tailMap differ from the like-named SortedMap methods in accepting additional arguments describing
  whether lower and upper bounds are inclusive versus exclusive.
  Submaps of any NavigableMap must implement the NavigableMap interface.

  This interface additionally defines methods firstEntry,
  pollFirstEntry, lastEntry, and
  pollLastEntry that return and/or remove the least and
  greatest mappings, if any exist, else returning null.

  Implementations of entry-returning methods are expected to
  return Map.Entry pairs representing snapshots of mappings
  at the time they were produced, and thus generally do not
  support the optional Entry.setValue method. Note however
  that it is possible to change mappings in the associated map using
  method put.

  Methods
  subMap(K, K),
  headMap(K), and
  tailMap(K)
  are specified to return SortedMap to allow existing
  implementations of SortedMap to be compatibly retrofitted to
  implement NavigableMap, but extensions and implementations
  of this interface are encouraged to override these methods to return
  NavigableMap.  Similarly,
  SortedMap.keySet() can be overriden to return NavigableSet.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util NavigableMap]))

(defn head-map
  "Returns a view of the portion of this map whose keys are less than (or
   equal to, if inclusive is true) toKey.  The returned
   map is backed by this map, so changes in the returned map are reflected
   in this map, and vice-versa.  The returned map supports all optional
   map operations that this map supports.

   The returned map will throw an IllegalArgumentException
   on an attempt to insert a key outside its range.

  to-key - high endpoint of the keys in the returned map - `NavigableMap.K`
  inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are less than
           (or equal to, if inclusive is true) toKey - `java.util.NavigableMap<NavigableMap.K,NavigableMap.V>`

  throws: java.lang.ClassCastException - if toKey is not compatible with this map's comparator (or, if the map has no comparator, if toKey does not implement Comparable). Implementations may, but are not required to, throw this exception if toKey cannot be compared to keys currently in the map."
  (^java.util.NavigableMap [^java.util.NavigableMap this ^NavigableMap.K to-key ^Boolean inclusive]
    (-> this (.headMap to-key inclusive)))
  (^java.util.SortedMap [^java.util.NavigableMap this ^NavigableMap.K to-key]
    (-> this (.headMap to-key))))

(defn floor-key
  "Returns the greatest key less than or equal to the given key,
   or null if there is no such key.

  key - the key - `NavigableMap.K`

  returns: the greatest key less than or equal to key,
           or null if there is no such key - `NavigableMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^NavigableMap.K [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.floorKey key))))

(defn lower-entry
  "Returns a key-value mapping associated with the greatest key
   strictly less than the given key, or null if there is
   no such key.

  key - the key - `NavigableMap.K`

  returns: an entry with the greatest key less than key,
           or null if there is no such key - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.lowerEntry key))))

(defn floor-entry
  "Returns a key-value mapping associated with the greatest key
   less than or equal to the given key, or null if there
   is no such key.

  key - the key - `NavigableMap.K`

  returns: an entry with the greatest key less than or equal to
           key, or null if there is no such key - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.floorEntry key))))

(defn ceiling-entry
  "Returns a key-value mapping associated with the least key
   greater than or equal to the given key, or null if
   there is no such key.

  key - the key - `NavigableMap.K`

  returns: an entry with the least key greater than or equal to
           key, or null if there is no such key - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.ceilingEntry key))))

(defn descending-key-set
  "Returns a reverse order NavigableSet view of the keys contained in this map.
   The set's iterator returns the keys in descending order.
   The set is backed by the map, so changes to the map are reflected in
   the set, and vice-versa.  If the map is modified while an iteration
   over the set is in progress (except through the iterator's own remove operation), the results of the iteration are undefined.  The
   set supports element removal, which removes the corresponding mapping
   from the map, via the Iterator.remove, Set.remove,
   removeAll, retainAll, and clear operations.
   It does not support the add or addAll operations.

  returns: a reverse order navigable set view of the keys in this map - `java.util.NavigableSet<NavigableMap.K>`"
  (^java.util.NavigableSet [^java.util.NavigableMap this]
    (-> this (.descendingKeySet))))

(defn navigable-key-set
  "Returns a NavigableSet view of the keys contained in this map.
   The set's iterator returns the keys in ascending order.
   The set is backed by the map, so changes to the map are reflected in
   the set, and vice-versa.  If the map is modified while an iteration
   over the set is in progress (except through the iterator's own remove operation), the results of the iteration are undefined.  The
   set supports element removal, which removes the corresponding mapping
   from the map, via the Iterator.remove, Set.remove,
   removeAll, retainAll, and clear operations.
   It does not support the add or addAll operations.

  returns: a navigable set view of the keys in this map - `java.util.NavigableSet<NavigableMap.K>`"
  (^java.util.NavigableSet [^java.util.NavigableMap this]
    (-> this (.navigableKeySet))))

(defn higher-key
  "Returns the least key strictly greater than the given key, or
   null if there is no such key.

  key - the key - `NavigableMap.K`

  returns: the least key greater than key,
           or null if there is no such key - `NavigableMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^NavigableMap.K [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.higherKey key))))

(defn poll-last-entry
  "Removes and returns a key-value mapping associated with
   the greatest key in this map, or null if the map is empty.

  returns: the removed last entry of this map,
           or null if this map is empty - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`"
  (^java.util.Map.Entry [^java.util.NavigableMap this]
    (-> this (.pollLastEntry))))

(defn first-entry
  "Returns a key-value mapping associated with the least
   key in this map, or null if the map is empty.

  returns: an entry with the least key,
           or null if this map is empty - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`"
  (^java.util.Map.Entry [^java.util.NavigableMap this]
    (-> this (.firstEntry))))

(defn poll-first-entry
  "Removes and returns a key-value mapping associated with
   the least key in this map, or null if the map is empty.

  returns: the removed first entry of this map,
           or null if this map is empty - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`"
  (^java.util.Map.Entry [^java.util.NavigableMap this]
    (-> this (.pollFirstEntry))))

(defn lower-key
  "Returns the greatest key strictly less than the given key, or
   null if there is no such key.

  key - the key - `NavigableMap.K`

  returns: the greatest key less than key,
           or null if there is no such key - `NavigableMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^NavigableMap.K [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.lowerKey key))))

(defn sub-map
  "Returns a view of the portion of this map whose keys range from
   fromKey to toKey.  If fromKey and
   toKey are equal, the returned map is empty unless
   fromInclusive and toInclusive are both true.  The
   returned map is backed by this map, so changes in the returned map are
   reflected in this map, and vice-versa.  The returned map supports all
   optional map operations that this map supports.

   The returned map will throw an IllegalArgumentException
   on an attempt to insert a key outside of its range, or to construct a
   submap either of whose endpoints lie outside its range.

  from-key - low endpoint of the keys in the returned map - `NavigableMap.K`
  from-inclusive - true if the low endpoint is to be included in the returned view - `boolean`
  to-key - high endpoint of the keys in the returned map - `NavigableMap.K`
  to-inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys range from
           fromKey to toKey - `java.util.NavigableMap<NavigableMap.K,NavigableMap.V>`

  throws: java.lang.ClassCastException - if fromKey and toKey cannot be compared to one another using this map's comparator (or, if the map has no comparator, using natural ordering). Implementations may, but are not required to, throw this exception if fromKey or toKey cannot be compared to keys currently in the map."
  (^java.util.NavigableMap [^java.util.NavigableMap this ^NavigableMap.K from-key ^Boolean from-inclusive ^NavigableMap.K to-key ^Boolean to-inclusive]
    (-> this (.subMap from-key from-inclusive to-key to-inclusive)))
  (^java.util.SortedMap [^java.util.NavigableMap this ^NavigableMap.K from-key ^NavigableMap.K to-key]
    (-> this (.subMap from-key to-key))))

(defn tail-map
  "Returns a view of the portion of this map whose keys are greater than (or
   equal to, if inclusive is true) fromKey.  The returned
   map is backed by this map, so changes in the returned map are reflected
   in this map, and vice-versa.  The returned map supports all optional
   map operations that this map supports.

   The returned map will throw an IllegalArgumentException
   on an attempt to insert a key outside its range.

  from-key - low endpoint of the keys in the returned map - `NavigableMap.K`
  inclusive - true if the low endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are greater than
           (or equal to, if inclusive is true) fromKey - `java.util.NavigableMap<NavigableMap.K,NavigableMap.V>`

  throws: java.lang.ClassCastException - if fromKey is not compatible with this map's comparator (or, if the map has no comparator, if fromKey does not implement Comparable). Implementations may, but are not required to, throw this exception if fromKey cannot be compared to keys currently in the map."
  (^java.util.NavigableMap [^java.util.NavigableMap this ^NavigableMap.K from-key ^Boolean inclusive]
    (-> this (.tailMap from-key inclusive)))
  (^java.util.SortedMap [^java.util.NavigableMap this ^NavigableMap.K from-key]
    (-> this (.tailMap from-key))))

(defn descending-map
  "Returns a reverse order view of the mappings contained in this map.
   The descending map is backed by this map, so changes to the map are
   reflected in the descending map, and vice-versa.  If either map is
   modified while an iteration over a collection view of either map
   is in progress (except through the iterator's own remove
   operation), the results of the iteration are undefined.

   The returned map has an ordering equivalent to
   Collections.reverseOrder(comparator()).
   The expression m.descendingMap().descendingMap() returns a
   view of m essentially equivalent to m.

  returns: a reverse order view of this map - `java.util.NavigableMap<NavigableMap.K,NavigableMap.V>`"
  (^java.util.NavigableMap [^java.util.NavigableMap this]
    (-> this (.descendingMap))))

(defn higher-entry
  "Returns a key-value mapping associated with the least key
   strictly greater than the given key, or null if there
   is no such key.

  key - the key - `NavigableMap.K`

  returns: an entry with the least key greater than key,
           or null if there is no such key - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.higherEntry key))))

(defn ceiling-key
  "Returns the least key greater than or equal to the given key,
   or null if there is no such key.

  key - the key - `NavigableMap.K`

  returns: the least key greater than or equal to key,
           or null if there is no such key - `NavigableMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^NavigableMap.K [^java.util.NavigableMap this ^NavigableMap.K key]
    (-> this (.ceilingKey key))))

(defn last-entry
  "Returns a key-value mapping associated with the greatest
   key in this map, or null if the map is empty.

  returns: an entry with the greatest key,
           or null if this map is empty - `java.util.Map.Entry<NavigableMap.K,NavigableMap.V>`"
  (^java.util.Map.Entry [^java.util.NavigableMap this]
    (-> this (.lastEntry))))

