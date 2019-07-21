(ns jdk.util.HashMap
  "Hash table based implementation of the Map interface.  This
  implementation provides all of the optional map operations, and permits
  null values and the null key.  (The HashMap
  class is roughly equivalent to Hashtable, except that it is
  unsynchronized and permits nulls.)  This class makes no guarantees as to
  the order of the map; in particular, it does not guarantee that the order
  will remain constant over time.

  This implementation provides constant-time performance for the basic
  operations (get and put), assuming the hash function
  disperses the elements properly among the buckets.  Iteration over
  collection views requires time proportional to the \"capacity\" of the
  HashMap instance (the number of buckets) plus its size (the number
  of key-value mappings).  Thus, it's very important not to set the initial
  capacity too high (or the load factor too low) if iteration performance is
  important.

  An instance of HashMap has two parameters that affect its
  performance: initial capacity and load factor.  The
  capacity is the number of buckets in the hash table, and the initial
  capacity is simply the capacity at the time the hash table is created.  The
  load factor is a measure of how full the hash table is allowed to
  get before its capacity is automatically increased.  When the number of
  entries in the hash table exceeds the product of the load factor and the
  current capacity, the hash table is rehashed (that is, internal data
  structures are rebuilt) so that the hash table has approximately twice the
  number of buckets.

  As a general rule, the default load factor (.75) offers a good
  tradeoff between time and space costs.  Higher values decrease the
  space overhead but increase the lookup cost (reflected in most of
  the operations of the HashMap class, including
  get and put).  The expected number of entries in
  the map and its load factor should be taken into account when
  setting its initial capacity, so as to minimize the number of
  rehash operations.  If the initial capacity is greater than the
  maximum number of entries divided by the load factor, no rehash
  operations will ever occur.

  If many mappings are to be stored in a HashMap
  instance, creating it with a sufficiently large capacity will allow
  the mappings to be stored more efficiently than letting it perform
  automatic rehashing as needed to grow the table.  Note that using
  many keys with the same hashCode() is a sure way to slow
  down performance of any hash table. To ameliorate impact, when keys
  are Comparable, this class may use comparison order among
  keys to help break ties.

  Note that this implementation is not synchronized.
  If multiple threads access a hash map concurrently, and at least one of
  the threads modifies the map structurally, it must be
  synchronized externally.  (A structural modification is any operation
  that adds or deletes one or more mappings; merely changing the value
  associated with a key that an instance already contains is not a
  structural modification.)  This is typically accomplished by
  synchronizing on some object that naturally encapsulates the map.

  If no such object exists, the map should be \"wrapped\" using the
  Collections.synchronizedMap
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access to the map:

    Map m = Collections.synchronizedMap(new HashMap(...));

  The iterators returned by all of this class's \"collection view methods\"
  are fail-fast: if the map is structurally modified at any time after
  the iterator is created, in any way except through the iterator's own
  remove method, the iterator will throw a
  ConcurrentModificationException.  Thus, in the face of concurrent
  modification, the iterator fails quickly and cleanly, rather than risking
  arbitrary, non-deterministic behavior at an undetermined time in the
  future.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness: the fail-fast behavior of iterators
  should be used only to detect bugs.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util HashMap]))

(defn ->hash-map
  "Constructor.

  Constructs an empty HashMap with the specified initial
   capacity and load factor.

  initial-capacity - the initial capacity - `int`
  load-factor - the load factor - `float`

  throws: java.lang.IllegalArgumentException - if the initial capacity is negative or the load factor is nonpositive"
  (^HashMap [^Integer initial-capacity ^Float load-factor]
    (new HashMap initial-capacity load-factor))
  (^HashMap [^Integer initial-capacity]
    (new HashMap initial-capacity))
  (^HashMap []
    (new HashMap )))

(defn values
  "Returns a Collection view of the values contained in this map.
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

  returns: a view of the values contained in this map - `java.util.Collection<V>`"
  (^java.util.Collection [^HashMap this]
    (-> this (.values))))

(defn for-each
  "Description copied from interface: Map

  action - The action to be performed for each entry - `java.util.function.BiConsumer`"
  ([^HashMap this ^java.util.function.BiConsumer action]
    (-> this (.forEach action))))

(defn replace-all
  "Description copied from interface: Map

  function - the function to apply to each entry - `java.util.function.BiFunction`"
  ([^HashMap this ^java.util.function.BiFunction function]
    (-> this (.replaceAll function))))

(defn put-all
  "Copies all of the mappings from the specified map to this map.
   These mappings will replace any mappings that this map had for
   any of the keys currently in the specified map.

  m - mappings to be stored in this map - `java.util.Map`

  throws: java.lang.NullPointerException - if the specified map is null"
  ([^HashMap this ^java.util.Map m]
    (-> this (.putAll m))))

(defn put-if-absent
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `K`
  value - value to be associated with the specified key - `V`

  returns: the previous value associated with the specified key, or
           null if there was no mapping for the key.
           (A null return can also indicate that the map
           previously associated null with the key,
           if the implementation supports null values.) - `V`"
  ([^HashMap this key value]
    (-> this (.putIfAbsent key value))))

(defn put
  "Associates the specified value with the specified key in this map.
   If the map previously contained a mapping for the key, the old
   value is replaced.

  key - key with which the specified value is to be associated - `K`
  value - value to be associated with the specified key - `V`

  returns: the previous value associated with key, or
           null if there was no mapping for key.
           (A null return can also indicate that the map
           previously associated null with key.) - `V`"
  ([^HashMap this key value]
    (-> this (.put key value))))

(defn entry-set
  "Returns a Set view of the mappings contained in this map.
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

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map$Entry<K,V>>`"
  (^java.util.Set [^HashMap this]
    (-> this (.entrySet))))

(defn contains-value
  "Returns true if this map maps one or more keys to the
   specified value.

  value - value whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map maps one or more keys to the
           specified value - `boolean`"
  (^Boolean [^HashMap this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn get-or-default
  "Description copied from interface: Map

  key - the key whose associated value is to be returned - `java.lang.Object`
  default-value - the default mapping of the key - `V`

  returns: the value to which the specified key is mapped, or
   defaultValue if this map contains no mapping for the key - `V`"
  ([^HashMap this ^java.lang.Object key default-value]
    (-> this (.getOrDefault key default-value))))

(defn replace
  "Description copied from interface: Map

  key - key with which the specified value is associated - `K`
  old-value - value expected to be associated with the specified key - `V`
  new-value - value to be associated with the specified key - `V`

  returns: true if the value was replaced - `boolean`"
  (^Boolean [^HashMap this key old-value new-value]
    (-> this (.replace key old-value new-value)))
  ([^HashMap this key value]
    (-> this (.replace key value))))

(defn remove
  "Description copied from interface: Map

  key - key with which the specified value is associated - `java.lang.Object`
  value - value expected to be associated with the specified key - `java.lang.Object`

  returns: true if the value was removed - `boolean`"
  (^Boolean [^HashMap this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.remove key value)))
  ([^HashMap this ^java.lang.Object key]
    (-> this (.remove key))))

(defn key-set
  "Returns a Set view of the keys contained in this map.
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

  returns: a set view of the keys contained in this map - `java.util.Set<K>`"
  (^java.util.Set [^HashMap this]
    (-> this (.keySet))))

(defn clone
  "Returns a shallow copy of this HashMap instance: the keys and
   values themselves are not cloned.

  returns: a shallow copy of this map - `java.lang.Object`"
  (^java.lang.Object [^HashMap this]
    (-> this (.clone))))

(defn compute-if-present
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `K`
  remapping-function - the function to compute a value - `java.util.function.BiFunction`

  returns: the new value associated with the specified key, or null if none - `V`"
  ([^HashMap this key ^java.util.function.BiFunction remapping-function]
    (-> this (.computeIfPresent key remapping-function))))

(defn empty?
  "Returns true if this map contains no key-value mappings.

  returns: true if this map contains no key-value mappings - `boolean`"
  (^Boolean [^HashMap this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of key-value mappings in this map.

  returns: the number of key-value mappings in this map - `int`"
  (^Integer [^HashMap this]
    (-> this (.size))))

(defn clear
  "Removes all of the mappings from this map.
   The map will be empty after this call returns."
  ([^HashMap this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this map contains a mapping for the
   specified key.

  key - The key whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map contains a mapping for the specified
   key. - `boolean`"
  (^Boolean [^HashMap this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that (key==null ? k==null :
   key.equals(k)), then this method returns v; otherwise
   it returns null.  (There can be at most one such mapping.)

   A return value of null does not necessarily
   indicate that the map contains no mapping for the key; it's also
   possible that the map explicitly maps the key to null.
   The containsKey operation may be used to
   distinguish these two cases.

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `V`"
  ([^HashMap this ^java.lang.Object key]
    (-> this (.get key))))

(defn merge
  "Description copied from interface: Map

  key - key with which the resulting value is to be associated - `K`
  value - the non-null value to be merged with the existing value associated with the key or, if no existing value or a null value is associated with the key, to be associated with the key - `V`
  remapping-function - the function to recompute a value if present - `java.util.function.BiFunction`

  returns: the new value associated with the specified key, or null if no
           value is associated with the key - `V`"
  ([^HashMap this key value ^java.util.function.BiFunction remapping-function]
    (-> this (.merge key value remapping-function))))

(defn compute
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `K`
  remapping-function - the function to compute a value - `java.util.function.BiFunction`

  returns: the new value associated with the specified key, or null if none - `V`"
  ([^HashMap this key ^java.util.function.BiFunction remapping-function]
    (-> this (.compute key remapping-function))))

(defn compute-if-absent
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `K`
  mapping-function - the function to compute a value - `java.util.function.Function`

  returns: the current (existing or computed) value associated with
           the specified key, or null if the computed value is null - `V`"
  ([^HashMap this key ^java.util.function.Function mapping-function]
    (-> this (.computeIfAbsent key mapping-function))))

