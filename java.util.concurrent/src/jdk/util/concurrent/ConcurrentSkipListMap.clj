(ns jdk.util.concurrent.ConcurrentSkipListMap
  "A scalable concurrent ConcurrentNavigableMap implementation.
  The map is sorted according to the java.lang.natural
  ordering of its keys, or by a Comparator provided at map
  creation time, depending on which constructor is used.

  This class implements a concurrent variant of SkipLists
  providing expected average log(n) time cost for the
  containsKey, get, put and
  remove operations and their variants.  Insertion, removal,
  update, and access operations safely execute concurrently by
  multiple threads.

  Iterators and spliterators are
  weakly consistent.

  Ascending key ordered views and their iterators are faster than
  descending ones.

  All Map.Entry pairs returned by methods in this class
  and its views represent snapshots of mappings at the time they were
  produced. They do not support the Entry.setValue
  method. (Note however that it is possible to change mappings in the
  associated map using put, putIfAbsent, or
  replace, depending on exactly which effect you need.)

  Beware that, unlike in most collections, the size
  method is not a constant-time operation. Because of the
  asynchronous nature of these maps, determining the current number
  of elements requires a traversal of the elements, and so may report
  inaccurate results if this collection is modified during traversal.
  Additionally, the bulk operations putAll, equals,
  toArray, containsValue, and clear are
  not guaranteed to be performed atomically. For example, an
  iterator operating concurrently with a putAll operation
  might view only some of the added elements.

  This class and its views and iterators implement all of the
  optional methods of the Map and Iterator
  interfaces. Like most other concurrent collections, this class does
  not permit the use of null keys or values because some
  null return values cannot be reliably distinguished from the absence of
  elements.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentSkipListMap]))

(defn ->concurrent-skip-list-map
  "Constructor.

  Constructs a new, empty map, sorted according to the specified
   comparator.

  comparator - the comparator that will be used to order this map. If null, the java.lang.natural ordering of the keys will be used. - `ConcurrentSkipListMap.K>`"
  ([comparator]
    (new ConcurrentSkipListMap comparator))
  ([]
    (new ConcurrentSkipListMap )))

(defn values
  "Returns a Collection view of the values contained in this map.
   The collection's iterator returns the values in ascending order
   of the corresponding keys. The collections's spliterator additionally
   reports Spliterator.CONCURRENT, Spliterator.NONNULL and
   Spliterator.ORDERED, with an encounter order that is ascending
   order of the corresponding keys.

   The collection is backed by the map, so changes to the map are
   reflected in the collection, and vice-versa.  The collection
   supports element removal, which removes the corresponding
   mapping from the map, via the Iterator.remove,
   Collection.remove, removeAll,
   retainAll and clear operations.  It does not
   support the add or addAll operations.

   The view's iterators and spliterators are
   weakly consistent.

  returns: a collection view of the values contained in this map - `java.util.Collection<ConcurrentSkipListMap.V>`"
  ([this]
    (-> this (.values))))

(defn for-each
  "Description copied from interface: ConcurrentMap

  action - The action to be performed for each entry - `ConcurrentSkipListMap.V>`"
  ([this action]
    (-> this (.forEach action))))

(defn replace-all
  "Description copied from interface: ConcurrentMap

  function - the function to apply to each entry - `ConcurrentSkipListMap.V>`"
  ([this function]
    (-> this (.replaceAll function))))

(defn put-if-absent
  "If the specified key is not already associated
   with a value, associate it with the given value.
   This is equivalent to


   if (!map.containsKey(key))
     return map.put(key, value);
   else
     return map.get(key);

   except that the action is performed atomically.

  key - key with which the specified value is to be associated - `ConcurrentSkipListMap.K`
  value - value to be associated with the specified key - `ConcurrentSkipListMap.V`

  returns: the previous value associated with the specified key,
           or null if there was no mapping for the key - `ConcurrentSkipListMap.V`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key value]
    (-> this (.putIfAbsent key value))))

(defn head-map
  "Description copied from interface: NavigableMap

  to-key - high endpoint of the keys in the returned map - `ConcurrentSkipListMap.K`
  inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are less than
           (or equal to, if inclusive is true) toKey - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`

  throws: java.lang.ClassCastException - if toKey is not compatible with this map's comparator (or, if the map has no comparator, if toKey does not implement Comparable). Implementations may, but are not required to, throw this exception if toKey cannot be compared to keys currently in the map."
  ([this to-key inclusive]
    (-> this (.headMap to-key inclusive)))
  ([this to-key]
    (-> this (.headMap to-key))))

(defn floor-key
  "Description copied from interface: NavigableMap

  key - the key - `ConcurrentSkipListMap.K`

  returns: the greatest key less than or equal to key,
           or null if there is no such key - `ConcurrentSkipListMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.floorKey key))))

(defn lower-entry
  "Returns a key-value mapping associated with the greatest key
   strictly less than the given key, or null if there is
   no such key. The returned entry does not support the
   Entry.setValue method.

  key - the key - `ConcurrentSkipListMap.K`

  returns: an entry with the greatest key less than key,
           or null if there is no such key - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.lowerEntry key))))

(defn put
  "Associates the specified value with the specified key in this map.
   If the map previously contained a mapping for the key, the old
   value is replaced.

  key - key with which the specified value is to be associated - `ConcurrentSkipListMap.K`
  value - value to be associated with the specified key - `ConcurrentSkipListMap.V`

  returns: the previous value associated with the specified key, or
           null if there was no mapping for the key - `ConcurrentSkipListMap.V`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key value]
    (-> this (.put key value))))

(defn entry-set
  "Returns a Set view of the mappings contained in this map.

   The set's iterator returns the entries in ascending key order.  The
   set's spliterator additionally reports Spliterator.CONCURRENT,
   Spliterator.NONNULL, Spliterator.SORTED and
   Spliterator.ORDERED, with an encounter order that is ascending
   key order.

   The set is backed by the map, so changes to the map are
   reflected in the set, and vice-versa.  The set supports element
   removal, which removes the corresponding mapping from the map,
   via the Iterator.remove, Set.remove,
   removeAll, retainAll and clear
   operations.  It does not support the add or
   addAll operations.

   The view's iterators and spliterators are
   weakly consistent.

   The Map.Entry elements traversed by the iterator
   or spliterator do not support the setValue
   operation.

  returns: a set view of the mappings contained in this map,
           sorted in ascending key order - `java.util.Set<java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>>`"
  ([this]
    (-> this (.entrySet))))

(defn floor-entry
  "Returns a key-value mapping associated with the greatest key
   less than or equal to the given key, or null if there
   is no such key. The returned entry does not support
   the Entry.setValue method.

  key - the key - `ConcurrentSkipListMap.K`

  returns: an entry with the greatest key less than or equal to
           key, or null if there is no such key - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.floorEntry key))))

(defn ceiling-entry
  "Returns a key-value mapping associated with the least key
   greater than or equal to the given key, or null if
   there is no such entry. The returned entry does not
   support the Entry.setValue method.

  key - the key - `ConcurrentSkipListMap.K`

  returns: an entry with the least key greater than or equal to
           key, or null if there is no such key - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.ceilingEntry key))))

(defn descending-key-set
  "Description copied from interface: ConcurrentNavigableMap

  returns: a reverse order navigable set view of the keys in this map - `java.util.NavigableSet<ConcurrentSkipListMap.K>`"
  ([this]
    (-> this (.descendingKeySet))))

(defn navigable-key-set
  "Description copied from interface: ConcurrentNavigableMap

  returns: a navigable set view of the keys in this map - `java.util.NavigableSet<ConcurrentSkipListMap.K>`"
  ([this]
    (-> this (.navigableKeySet))))

(defn first-key
  "Description copied from interface: SortedMap

  returns: the first (lowest) key currently in this map - `ConcurrentSkipListMap.K`

  throws: java.util.NoSuchElementException - if this map is empty"
  ([this]
    (-> this (.firstKey))))

(defn contains-value
  "Returns true if this map maps one or more keys to the
   specified value.  This operation requires time linear in the
   map size. Additionally, it is possible for the map to change
   during execution of this method, in which case the returned
   result may be inaccurate.

  value - value whose presence in this map is to be tested - `java.lang.Object`

  returns: true if a mapping to value exists;
           false otherwise - `boolean`

  throws: java.lang.NullPointerException - if the specified value is null"
  ([this value]
    (-> this (.containsValue value))))

(defn higher-key
  "Description copied from interface: NavigableMap

  key - the key - `ConcurrentSkipListMap.K`

  returns: the least key greater than key,
           or null if there is no such key - `ConcurrentSkipListMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.higherKey key))))

(defn get-or-default
  "Returns the value to which the specified key is mapped,
   or the given defaultValue if this map contains no mapping for the key.

  key - the key - `java.lang.Object`
  default-value - the value to return if this map contains no mapping for the given key - `ConcurrentSkipListMap.V`

  returns: the mapping for the key, if present; else the defaultValue - `ConcurrentSkipListMap.V`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([this key default-value]
    (-> this (.getOrDefault key default-value))))

(defn replace
  "Replaces the entry for a key only if currently mapped to a given value.
   This is equivalent to


   if (map.containsKey(key) && Objects.equals(map.get(key), oldValue)) {
     map.put(key, newValue);
     return true;
   } else
     return false;

   except that the action is performed atomically.

  key - key with which the specified value is associated - `ConcurrentSkipListMap.K`
  old-value - value expected to be associated with the specified key - `ConcurrentSkipListMap.V`
  new-value - value to be associated with the specified key - `ConcurrentSkipListMap.V`

  returns: true if the value was replaced - `boolean`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key old-value new-value]
    (-> this (.replace key old-value new-value)))
  ([this key value]
    (-> this (.replace key value))))

(defn poll-last-entry
  "Removes and returns a key-value mapping associated with
   the greatest key in this map, or null if the map is empty.
   The returned entry does not support
   the Entry.setValue method.

  returns: the removed last entry of this map,
           or null if this map is empty - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`"
  ([this]
    (-> this (.pollLastEntry))))

(defn first-entry
  "Returns a key-value mapping associated with the least
   key in this map, or null if the map is empty.
   The returned entry does not support
   the Entry.setValue method.

  returns: an entry with the least key,
           or null if this map is empty - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`"
  ([this]
    (-> this (.firstEntry))))

(defn last-key
  "Description copied from interface: SortedMap

  returns: the last (highest) key currently in this map - `ConcurrentSkipListMap.K`

  throws: java.util.NoSuchElementException - if this map is empty"
  ([this]
    (-> this (.lastKey))))

(defn poll-first-entry
  "Removes and returns a key-value mapping associated with
   the least key in this map, or null if the map is empty.
   The returned entry does not support
   the Entry.setValue method.

  returns: the removed first entry of this map,
           or null if this map is empty - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`"
  ([this]
    (-> this (.pollFirstEntry))))

(defn remove
  "Removes the entry for a key only if currently mapped to a given value.
   This is equivalent to


   if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
     map.remove(key);
     return true;
   } else
     return false;

   except that the action is performed atomically.

  key - key with which the specified value is associated - `java.lang.Object`
  value - value expected to be associated with the specified key - `java.lang.Object`

  returns: true if the value was removed - `boolean`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key value]
    (-> this (.remove key value)))
  ([this key]
    (-> this (.remove key))))

(defn lower-key
  "Description copied from interface: NavigableMap

  key - the key - `ConcurrentSkipListMap.K`

  returns: the greatest key less than key,
           or null if there is no such key - `ConcurrentSkipListMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.lowerKey key))))

(defn key-set
  "Returns a NavigableSet view of the keys contained in this map.

   The set's iterator returns the keys in ascending order.
   The set's spliterator additionally reports Spliterator.CONCURRENT,
   Spliterator.NONNULL, Spliterator.SORTED and
   Spliterator.ORDERED, with an encounter order that is ascending
   key order.  The spliterator's comparator (see
   Spliterator.getComparator()) is null if
   the map's comparator (see comparator()) is null.
   Otherwise, the spliterator's comparator is the same as or imposes the
   same total ordering as the map's comparator.

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

  returns: a navigable set view of the keys in this map - `java.util.NavigableSet<ConcurrentSkipListMap.K>`"
  ([this]
    (-> this (.keySet))))

(defn comparator
  "Description copied from interface: SortedMap

  returns: the comparator used to order the keys in this map,
           or null if this map uses the natural ordering
           of its keys - `java.util.Comparator<? super ConcurrentSkipListMap.K>`"
  ([this]
    (-> this (.comparator))))

(defn sub-map
  "Description copied from interface: NavigableMap

  from-key - low endpoint of the keys in the returned map - `ConcurrentSkipListMap.K`
  from-inclusive - true if the low endpoint is to be included in the returned view - `boolean`
  to-key - high endpoint of the keys in the returned map - `ConcurrentSkipListMap.K`
  to-inclusive - true if the high endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys range from
           fromKey to toKey - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`

  throws: java.lang.ClassCastException - if fromKey and toKey cannot be compared to one another using this map's comparator (or, if the map has no comparator, using natural ordering). Implementations may, but are not required to, throw this exception if fromKey or toKey cannot be compared to keys currently in the map."
  ([this from-key from-inclusive to-key to-inclusive]
    (-> this (.subMap from-key from-inclusive to-key to-inclusive)))
  ([this from-key to-key]
    (-> this (.subMap from-key to-key))))

(defn tail-map
  "Description copied from interface: NavigableMap

  from-key - low endpoint of the keys in the returned map - `ConcurrentSkipListMap.K`
  inclusive - true if the low endpoint is to be included in the returned view - `boolean`

  returns: a view of the portion of this map whose keys are greater than
           (or equal to, if inclusive is true) fromKey - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`

  throws: java.lang.ClassCastException - if fromKey is not compatible with this map's comparator (or, if the map has no comparator, if fromKey does not implement Comparable). Implementations may, but are not required to, throw this exception if fromKey cannot be compared to keys currently in the map."
  ([this from-key inclusive]
    (-> this (.tailMap from-key inclusive)))
  ([this from-key]
    (-> this (.tailMap from-key))))

(defn descending-map
  "Description copied from interface: ConcurrentNavigableMap

  returns: a reverse order view of this map - `java.util.concurrent.ConcurrentNavigableMap<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`"
  ([this]
    (-> this (.descendingMap))))

(defn clone
  "Returns a shallow copy of this ConcurrentSkipListMap
   instance. (The keys and values themselves are not cloned.)

  returns: a shallow copy of this map - `java.util.concurrent.ConcurrentSkipListMap<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`"
  ([this]
    (-> this (.clone))))

(defn compute-if-present
  "If the value for the specified key is present, attempts to
   compute a new mapping given the key and its current mapped
   value. The function is NOT guaranteed to be applied
   once atomically.

  key - key with which a value may be associated - `ConcurrentSkipListMap.K`
  remapping-function - the function to compute a value - `ConcurrentSkipListMap.V>`

  returns: the new value associated with the specified key, or null if none - `ConcurrentSkipListMap.V`

  throws: java.lang.NullPointerException - if the specified key is null or the remappingFunction is null"
  ([this key remapping-function]
    (-> this (.computeIfPresent key remapping-function))))

(defn higher-entry
  "Returns a key-value mapping associated with the least key
   strictly greater than the given key, or null if there
   is no such key. The returned entry does not support
   the Entry.setValue method.

  key - the key - `ConcurrentSkipListMap.K`

  returns: an entry with the least key greater than key,
           or null if there is no such key - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.higherEntry key))))

(defn ceiling-key
  "Description copied from interface: NavigableMap

  key - the key - `ConcurrentSkipListMap.K`

  returns: the least key greater than or equal to key,
           or null if there is no such key - `ConcurrentSkipListMap.K`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.ceilingKey key))))

(defn empty?
  "Returns true if this map contains no key-value mappings.

  returns: true if this map contains no key-value mappings - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of key-value mappings in this map.  If this map
   contains more than Integer.MAX_VALUE elements, it
   returns Integer.MAX_VALUE.

   Beware that, unlike in most collections, this method is
   NOT a constant-time operation. Because of the
   asynchronous nature of these maps, determining the current
   number of elements requires traversing them all to count them.
   Additionally, it is possible for the size to change during
   execution of this method, in which case the returned result
   will be inaccurate. Thus, this method is typically not very
   useful in concurrent applications.

  returns: the number of elements in this map - `int`"
  ([this]
    (-> this (.size))))

(defn clear
  "Removes all of the mappings from this map."
  ([this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this map contains a mapping for the specified
   key.

  key - key whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map contains a mapping for the specified key - `boolean`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that key compares
   equal to k according to the map's ordering, then this
   method returns v; otherwise it returns null.
   (There can be at most one such mapping.)

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `ConcurrentSkipListMap.V`

  throws: java.lang.ClassCastException - if the specified key cannot be compared with the keys currently in the map"
  ([this key]
    (-> this (.get key))))

(defn merge
  "If the specified key is not already associated with a value,
   associates it with the given value.  Otherwise, replaces the
   value with the results of the given remapping function, or
   removes if null. The function is NOT
   guaranteed to be applied once atomically.

  key - key with which the specified value is to be associated - `ConcurrentSkipListMap.K`
  value - the value to use if absent - `ConcurrentSkipListMap.V`
  remapping-function - the function to recompute a value if present - `ConcurrentSkipListMap.V>`

  returns: the new value associated with the specified key, or null if none - `ConcurrentSkipListMap.V`

  throws: java.lang.NullPointerException - if the specified key or value is null or the remappingFunction is null"
  ([this key value remapping-function]
    (-> this (.merge key value remapping-function))))

(defn equals
  "Compares the specified object with this map for equality.
   Returns true if the given object is also a map and the
   two maps represent the same mappings.  More formally, two maps
   m1 and m2 represent the same mappings if
   m1.entrySet().equals(m2.entrySet()).  This
   operation may return misleading results if either map is
   concurrently modified during execution of this method.

  o - object to be compared for equality with this map - `java.lang.Object`

  returns: true if the specified object is equal to this map - `boolean`"
  ([this o]
    (-> this (.equals o))))

(defn compute
  "Attempts to compute a mapping for the specified key and its
   current mapped value (or null if there is no current
   mapping). The function is NOT guaranteed to be applied
   once atomically.

  key - key with which the specified value is to be associated - `ConcurrentSkipListMap.K`
  remapping-function - the function to compute a value - `ConcurrentSkipListMap.V>`

  returns: the new value associated with the specified key, or null if none - `ConcurrentSkipListMap.V`

  throws: java.lang.NullPointerException - if the specified key is null or the remappingFunction is null"
  ([this key remapping-function]
    (-> this (.compute key remapping-function))))

(defn compute-if-absent
  "If the specified key is not already associated with a value,
   attempts to compute its value using the given mapping function
   and enters it into this map unless null.  The function
   is NOT guaranteed to be applied once atomically only
   if the value is not present.

  key - key with which the specified value is to be associated - `ConcurrentSkipListMap.K`
  mapping-function - the function to compute a value - `ConcurrentSkipListMap.V>`

  returns: the current (existing or computed) value associated with
           the specified key, or null if the computed value is null - `ConcurrentSkipListMap.V`

  throws: java.lang.NullPointerException - if the specified key is null or the mappingFunction is null"
  ([this key mapping-function]
    (-> this (.computeIfAbsent key mapping-function))))

(defn last-entry
  "Returns a key-value mapping associated with the greatest
   key in this map, or null if the map is empty.
   The returned entry does not support
   the Entry.setValue method.

  returns: an entry with the greatest key,
           or null if this map is empty - `java.util.Map.Entry<ConcurrentSkipListMap.K,ConcurrentSkipListMap.V>`"
  ([this]
    (-> this (.lastEntry))))

