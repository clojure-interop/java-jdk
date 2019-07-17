(ns jdk.util.TreeMap
  "A Red-Black tree based NavigableMap implementation.
  The map is sorted according to the java.lang.natural
  ordering of its keys, or by a Comparator provided at map
  creation time, depending on which constructor is used.

  This implementation provides guaranteed log(n) time cost for the
  containsKey, get, put and remove
  operations.  Algorithms are adaptations of those in Cormen, Leiserson, and
  Rivest's Introduction to Algorithms.

  Note that the ordering maintained by a tree map, like any sorted map, and
  whether or not an explicit comparator is provided, must be consistent
  with equals if this sorted map is to correctly implement the
  Map interface.  (See Comparable or Comparator for a
  precise definition of consistent with equals.)  This is so because
  the Map interface is defined in terms of the equals
  operation, but a sorted map performs all key comparisons using its compareTo (or compare) method, so two keys that are deemed equal by
  this method are, from the standpoint of the sorted map, equal.  The behavior
  of a sorted map is well-defined even if its ordering is
  inconsistent with equals; it just fails to obey the general contract
  of the Map interface.

  Note that this implementation is not synchronized.
  If multiple threads access a map concurrently, and at least one of the
  threads modifies the map structurally, it must be synchronized
  externally.  (A structural modification is any operation that adds or
  deletes one or more mappings; merely changing the value associated
  with an existing key is not a structural modification.)  This is
  typically accomplished by synchronizing on some object that naturally
  encapsulates the map.
  If no such object exists, the map should be `wrapped` using the
  Collections.synchronizedSortedMap
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the map:

    SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...));

  The iterators returned by the iterator method of the collections
  returned by all of this class's `collection view methods` are
  fail-fast: if the map is structurally modified at any time after
  the iterator is created, in any way except through the iterator's own
  remove method, the iterator will throw a ConcurrentModificationException.  Thus, in the face of concurrent
  modification, the iterator fails quickly and cleanly, rather than risking
  arbitrary, non-deterministic behavior at an undetermined time in the future.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness:   the fail-fast behavior of iterators
  should be used only to detect bugs.

  All Map.Entry pairs returned by methods in this class
  and its views represent snapshots of mappings at the time they were
  produced. They do not support the Entry.setValue
  method. (Note however that it is possible to change mappings in the
  associated map using put.)

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util TreeMap]))

(defn ->tree-map
  "Constructor.

  Constructs a new, empty tree map, ordered according to the given
   comparator.  All keys inserted into the map must be mutually
   comparable by the given comparator: comparator.compare(k1,
   k2) must not throw a ClassCastException for any keys
   k1 and k2 in the map.  If the user attempts to put
   a key into the map that violates this constraint, the put(Object
   key, Object value) call will throw a
   ClassCastException.

  comparator - the comparator that will be used to order this map. If null, the java.lang.natural ordering of the keys will be used. - `TreeMap.K>`"
  ([^TreeMap.K> comparator]
    (new TreeMap comparator))
  ([]
    (new TreeMap )))

(defn values
  "Returns a Collection view of the values contained in this map.

   The collection's iterator returns the values in ascending order
   of the corresponding keys. The collection's spliterator is
   late-binding,
   fail-fast, and additionally reports Spliterator.ORDERED
   with an encounter order that is ascending order of the corresponding
   keys.

   The collection is backed by the map, so changes to the map are
   reflected in the collection, and vice-versa.  If the map is
   modified while an iteration over the collection is in progress
   (except through the iterator's own remove operation),
   the results of the iteration are undefined.  The collection
   supports element removal, which removes the corresponding
   mapping from the map, via the Iterator.remove,
   Collection.remove, removeAll,
   retainAll and clear operations.  It does not
   support the add or addAll operations.

  returns: a collection view of the values contained in this map - `java.util.Collection<TreeMap.V>`"
  (^java.util.Collection [^java.util.TreeMap this]
    (-> this (.values))))

(defn for-each
  "Description copied from interface: Map

  action - The action to be performed for each entry - `TreeMap.V>`"
  ([^java.util.TreeMap this ^TreeMap.V> action]
    (-> this (.forEach action))))

(defn replace-all
  "Description copied from interface: Map

  function - the function to apply to each entry - `TreeMap.V>`"
  ([^java.util.TreeMap this ^TreeMap.V> function]
    (-> this (.replaceAll function))))

(defn put-all
  "Copies all of the mappings from the specified map to this map.
   These mappings replace any mappings that this map had for any
   of the keys currently in the specified map.

  map - mappings to be stored in this map - `TreeMap.V>`

  throws: java.lang.ClassCastException - if the class of a key or value in the specified map prevents it from being stored in this map"
  ([^java.util.TreeMap this ^TreeMap.V> map]
    (-> this (.putAll map))))

(defn head-map
  "Description copied from interface: NavigableMap

  to-key - high endpoint of the keys in the returned map - `TreeMap.K`
  inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are less than
           (or equal to, if inclusive is true) toKey - `java.util.NavigableMap<TreeMap.K,TreeMap.V>`

  throws: java.lang.ClassCastException - if toKey is not compatible with this map's comparator (or, if the map has no comparator, if toKey does not implement Comparable). Implementations may, but are not required to, throw this exception if toKey cannot be compared to keys currently in the map."
  (^java.util.NavigableMap [^java.util.TreeMap this ^TreeMap.K to-key ^Boolean inclusive]
    (-> this (.headMap to-key inclusive)))
  (^java.util.SortedMap [^java.util.TreeMap this ^TreeMap.K to-key]
    (-> this (.headMap to-key))))

(defn floor-key
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: the greatest key less than or equal to key,
           or null if there is no such key - `TreeMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^TreeMap.K [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.floorKey key))))

(defn lower-entry
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: an entry with the greatest key less than key,
           or null if there is no such key - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.lowerEntry key))))

(defn put
  "Associates the specified value with the specified key in this map.
   If the map previously contained a mapping for the key, the old
   value is replaced.

  key - key with which the specified value is to be associated - `TreeMap.K`
  value - value to be associated with the specified key - `TreeMap.V`

  returns: the previous value associated with key, or
           null if there was no mapping for key.
           (A null return can also indicate that the map
           previously associated null with key.) - `TreeMap.V`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^TreeMap.V [^java.util.TreeMap this ^TreeMap.K key ^TreeMap.V value]
    (-> this (.put key value))))

(defn entry-set
  "Returns a Set view of the mappings contained in this map.

   The set's iterator returns the entries in ascending key order. The
   sets's spliterator is
   late-binding,
   fail-fast, and additionally reports Spliterator.SORTED and
   Spliterator.ORDERED with an encounter order that is ascending key
   order.

   The set is backed by the map, so changes to the map are
   reflected in the set, and vice-versa.  If the map is modified
   while an iteration over the set is in progress (except through
   the iterator's own remove operation, or through the
   setValue operation on a map entry returned by the
   iterator) the results of the iteration are undefined.  The set
   supports element removal, which removes the corresponding
   mapping from the map, via the Iterator.remove,
   Set.remove, removeAll, retainAll and
   clear operations.  It does not support the
   add or addAll operations.

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map.Entry<TreeMap.K,TreeMap.V>>`"
  (^java.util.Set> [^java.util.TreeMap this]
    (-> this (.entrySet))))

(defn floor-entry
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: an entry with the greatest key less than or equal to
           key, or null if there is no such key - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.floorEntry key))))

(defn ceiling-entry
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: an entry with the least key greater than or equal to
           key, or null if there is no such key - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.ceilingEntry key))))

(defn descending-key-set
  "Description copied from interface: NavigableMap

  returns: a reverse order navigable set view of the keys in this map - `java.util.NavigableSet<TreeMap.K>`"
  (^java.util.NavigableSet [^java.util.TreeMap this]
    (-> this (.descendingKeySet))))

(defn navigable-key-set
  "Description copied from interface: NavigableMap

  returns: a navigable set view of the keys in this map - `java.util.NavigableSet<TreeMap.K>`"
  (^java.util.NavigableSet [^java.util.TreeMap this]
    (-> this (.navigableKeySet))))

(defn first-key
  "Description copied from interface: SortedMap

  returns: the first (lowest) key currently in this map - `TreeMap.K`

  throws: java.util.NoSuchElementException - if this map is empty"
  (^TreeMap.K [^java.util.TreeMap this]
    (-> this (.firstKey))))

(defn contains-value
  "Returns true if this map maps one or more keys to the
   specified value.  More formally, returns true if and only if
   this map contains at least one mapping to a value v such
   that (value==null ? v==null : value.equals(v)).  This
   operation will probably require time linear in the map size for
   most implementations.

  value - value whose presence in this map is to be tested - `java.lang.Object`

  returns: true if a mapping to value exists;
           false otherwise - `boolean`"
  (^Boolean [^java.util.TreeMap this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn higher-key
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: the least key greater than key,
           or null if there is no such key - `TreeMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^TreeMap.K [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.higherKey key))))

(defn replace
  "Description copied from interface: Map

  key - key with which the specified value is associated - `TreeMap.K`
  old-value - value expected to be associated with the specified key - `TreeMap.V`
  new-value - value to be associated with the specified key - `TreeMap.V`

  returns: true if the value was replaced - `boolean`"
  (^Boolean [^java.util.TreeMap this ^TreeMap.K key ^TreeMap.V old-value ^TreeMap.V new-value]
    (-> this (.replace key old-value new-value)))
  (^TreeMap.V [^java.util.TreeMap this ^TreeMap.K key ^TreeMap.V value]
    (-> this (.replace key value))))

(defn poll-last-entry
  "Description copied from interface: NavigableMap

  returns: the removed last entry of this map,
           or null if this map is empty - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`"
  (^java.util.Map.Entry [^java.util.TreeMap this]
    (-> this (.pollLastEntry))))

(defn first-entry
  "Description copied from interface: NavigableMap

  returns: an entry with the least key,
           or null if this map is empty - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`"
  (^java.util.Map.Entry [^java.util.TreeMap this]
    (-> this (.firstEntry))))

(defn last-key
  "Description copied from interface: SortedMap

  returns: the last (highest) key currently in this map - `TreeMap.K`

  throws: java.util.NoSuchElementException - if this map is empty"
  (^TreeMap.K [^java.util.TreeMap this]
    (-> this (.lastKey))))

(defn poll-first-entry
  "Description copied from interface: NavigableMap

  returns: the removed first entry of this map,
           or null if this map is empty - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`"
  (^java.util.Map.Entry [^java.util.TreeMap this]
    (-> this (.pollFirstEntry))))

(defn remove
  "Removes the mapping for this key from this TreeMap if present.

  key - key for which mapping should be removed - `java.lang.Object`

  returns: the previous value associated with key, or
           null if there was no mapping for key.
           (A null return can also indicate that the map
           previously associated null with key.) - `TreeMap.V`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^TreeMap.V [^java.util.TreeMap this ^java.lang.Object key]
    (-> this (.remove key))))

(defn lower-key
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: the greatest key less than key,
           or null if there is no such key - `TreeMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^TreeMap.K [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.lowerKey key))))

(defn key-set
  "Returns a Set view of the keys contained in this map.

   The set's iterator returns the keys in ascending order.
   The set's spliterator is
   late-binding,
   fail-fast, and additionally reports Spliterator.SORTED
   and Spliterator.ORDERED with an encounter order that is ascending
   key order.  The spliterator's comparator (see
   Spliterator.getComparator()) is null if
   the tree map's comparator (see comparator()) is null.
   Otherwise, the spliterator's comparator is the same as or imposes the
   same total ordering as the tree map's comparator.

   The set is backed by the map, so changes to the map are
   reflected in the set, and vice-versa.  If the map is modified
   while an iteration over the set is in progress (except through
   the iterator's own remove operation), the results of
   the iteration are undefined.  The set supports element removal,
   which removes the corresponding mapping from the map, via the
   Iterator.remove, Set.remove,
   removeAll, retainAll, and clear
   operations.  It does not support the add or addAll
   operations.

  returns: a set view of the keys contained in this map - `java.util.Set<TreeMap.K>`"
  (^java.util.Set [^java.util.TreeMap this]
    (-> this (.keySet))))

(defn comparator
  "Description copied from interface: SortedMap

  returns: the comparator used to order the keys in this map,
           or null if this map uses the natural ordering
           of its keys - `java.util.Comparator<? super TreeMap.K>`"
  ([^java.util.TreeMap this]
    (-> this (.comparator))))

(defn sub-map
  "Description copied from interface: NavigableMap

  from-key - low endpoint of the keys in the returned map - `TreeMap.K`
  from-inclusive - true if the low endpoint is to be included in the returned view - `boolean`
  to-key - high endpoint of the keys in the returned map - `TreeMap.K`
  to-inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys range from
           fromKey to toKey - `java.util.NavigableMap<TreeMap.K,TreeMap.V>`

  throws: java.lang.ClassCastException - if fromKey and toKey cannot be compared to one another using this map's comparator (or, if the map has no comparator, using natural ordering). Implementations may, but are not required to, throw this exception if fromKey or toKey cannot be compared to keys currently in the map."
  (^java.util.NavigableMap [^java.util.TreeMap this ^TreeMap.K from-key ^Boolean from-inclusive ^TreeMap.K to-key ^Boolean to-inclusive]
    (-> this (.subMap from-key from-inclusive to-key to-inclusive)))
  (^java.util.SortedMap [^java.util.TreeMap this ^TreeMap.K from-key ^TreeMap.K to-key]
    (-> this (.subMap from-key to-key))))

(defn tail-map
  "Description copied from interface: NavigableMap

  from-key - low endpoint of the keys in the returned map - `TreeMap.K`
  inclusive - true if the low endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are greater than
           (or equal to, if inclusive is true) fromKey - `java.util.NavigableMap<TreeMap.K,TreeMap.V>`

  throws: java.lang.ClassCastException - if fromKey is not compatible with this map's comparator (or, if the map has no comparator, if fromKey does not implement Comparable). Implementations may, but are not required to, throw this exception if fromKey cannot be compared to keys currently in the map."
  (^java.util.NavigableMap [^java.util.TreeMap this ^TreeMap.K from-key ^Boolean inclusive]
    (-> this (.tailMap from-key inclusive)))
  (^java.util.SortedMap [^java.util.TreeMap this ^TreeMap.K from-key]
    (-> this (.tailMap from-key))))

(defn descending-map
  "Description copied from interface: NavigableMap

  returns: a reverse order view of this map - `java.util.NavigableMap<TreeMap.K,TreeMap.V>`"
  (^java.util.NavigableMap [^java.util.TreeMap this]
    (-> this (.descendingMap))))

(defn clone
  "Returns a shallow copy of this TreeMap instance. (The keys and
   values themselves are not cloned.)

  returns: a shallow copy of this map - `java.lang.Object`"
  (^java.lang.Object [^java.util.TreeMap this]
    (-> this (.clone))))

(defn higher-entry
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: an entry with the least key greater than key,
           or null if there is no such key - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^java.util.Map.Entry [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.higherEntry key))))

(defn ceiling-key
  "Description copied from interface: NavigableMap

  key - the key - `TreeMap.K`

  returns: the least key greater than or equal to key,
           or null if there is no such key - `TreeMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^TreeMap.K [^java.util.TreeMap this ^TreeMap.K key]
    (-> this (.ceilingKey key))))

(defn size
  "Returns the number of key-value mappings in this map.

  returns: the number of key-value mappings in this map - `int`"
  (^Integer [^java.util.TreeMap this]
    (-> this (.size))))

(defn clear
  "Removes all of the mappings from this map.
   The map will be empty after this call returns."
  ([^java.util.TreeMap this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this map contains a mapping for the specified
   key.

  key - key whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map contains a mapping for the
           specified key - `boolean`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^Boolean [^java.util.TreeMap this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that key compares
   equal to k according to the map's ordering, then this
   method returns v; otherwise it returns null.
   (There can be at most one such mapping.)

   A return value of null does not necessarily
   indicate that the map contains no mapping for the key; it's also
   possible that the map explicitly maps the key to null.
   The containsKey operation may be used to
   distinguish these two cases.

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `TreeMap.V`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  (^TreeMap.V [^java.util.TreeMap this ^java.lang.Object key]
    (-> this (.get key))))

(defn last-entry
  "Description copied from interface: NavigableMap

  returns: an entry with the greatest key,
           or null if this map is empty - `java.util.Map.Entry<TreeMap.K,TreeMap.V>`"
  (^java.util.Map.Entry [^java.util.TreeMap this]
    (-> this (.lastEntry))))

