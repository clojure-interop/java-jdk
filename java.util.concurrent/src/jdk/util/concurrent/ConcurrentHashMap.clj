(ns jdk.util.concurrent.ConcurrentHashMap
  "A hash table supporting full concurrency of retrievals and
  high expected concurrency for updates. This class obeys the
  same functional specification as Hashtable, and
  includes versions of methods corresponding to each method of
  Hashtable. However, even though all operations are
  thread-safe, retrieval operations do not entail locking,
  and there is not any support for locking the entire table
  in a way that prevents all access.  This class is fully
  interoperable with Hashtable in programs that rely on its
  thread safety but not on its synchronization details.

  Retrieval operations (including get) generally do not
  block, so may overlap with update operations (including put
  and remove). Retrievals reflect the results of the most
  recently completed update operations holding upon their
  onset. (More formally, an update operation for a given key bears a
  happens-before relation with any (non-null) retrieval for
  that key reporting the updated value.)  For aggregate operations
  such as putAll and clear, concurrent retrievals may
  reflect insertion or removal of only some entries.  Similarly,
  Iterators, Spliterators and Enumerations return elements reflecting the
  state of the hash table at some point at or since the creation of the
  iterator/enumeration.  They do not throw ConcurrentModificationException.
  However, iterators are designed to be used by only one thread at a time.
  Bear in mind that the results of aggregate status methods including
  size, isEmpty, and containsValue are typically
  useful only when a map is not undergoing concurrent updates in other threads.
  Otherwise the results of these methods reflect transient states
  that may be adequate for monitoring or estimation purposes, but not
  for program control.

  The table is dynamically expanded when there are too many
  collisions (i.e., keys that have distinct hash codes but fall into
  the same slot modulo the table size), with the expected average
  effect of maintaining roughly two bins per mapping (corresponding
  to a 0.75 load factor threshold for resizing). There may be much
  variance around this average as mappings are added and removed, but
  overall, this maintains a commonly accepted time/space tradeoff for
  hash tables.  However, resizing this or any other kind of hash
  table may be a relatively slow operation. When possible, it is a
  good idea to provide a size estimate as an optional initialCapacity constructor argument. An additional optional
  loadFactor constructor argument provides a further means of
  customizing initial table capacity by specifying the table density
  to be used in calculating the amount of space to allocate for the
  given number of elements.  Also, for compatibility with previous
  versions of this class, constructors may optionally specify an
  expected concurrencyLevel as an additional hint for
  internal sizing.  Note that using many keys with exactly the same
  hashCode() is a sure way to slow down performance of any
  hash table. To ameliorate impact, when keys are Comparable,
  this class may use comparison order among keys to help break ties.

  A Set projection of a ConcurrentHashMap may be created
  (using newKeySet() or newKeySet(int)), or viewed
  (using keySet(Object) when only keys are of interest, and the
  mapped values are (perhaps transiently) not used or all take the
  same mapping value.

  A ConcurrentHashMap can be used as scalable frequency map (a
  form of histogram or multiset) by using LongAdder values and initializing via
  computeIfAbsent. For example, to add a count
  to a ConcurrentHashMap<String,LongAdder> freqs, you can use
  freqs.computeIfAbsent(k -> new LongAdder()).increment();

  This class and its views and iterators implement all of the
  optional methods of the Map and Iterator
  interfaces.

  Like Hashtable but unlike HashMap, this class
  does not allow null to be used as a key or value.

  ConcurrentHashMaps support a set of sequential and parallel bulk
  operations that, unlike most Stream methods, are designed
  to be safely, and often sensibly, applied even with maps that are
  being concurrently updated by other threads; for example, when
  computing a snapshot summary of the values in a shared registry.
  There are three kinds of operation, each with four forms, accepting
  functions with Keys, Values, Entries, and (Key, Value) arguments
  and/or return values. Because the elements of a ConcurrentHashMap
  are not ordered in any particular way, and may be processed in
  different orders in different parallel executions, the correctness
  of supplied functions should not depend on any ordering, or on any
  other objects or values that may transiently change while
  computation is in progress; and except for forEach actions, should
  ideally be side-effect-free. Bulk operations on Map.Entry
  objects do not support method setValue.


   forEach: Perform a given action on each element.
  A variant form applies a given transformation on each element
  before performing the action.

   search: Return the first available non-null result of
  applying a given function on each element; skipping further
  search when a result is found.

   reduce: Accumulate each element.  The supplied reduction
  function cannot rely on ordering (more formally, it should be
  both associative and commutative).  There are five variants:



   Plain reductions. (There is not a form of this method for
  (key, value) function arguments since there is no corresponding
  return type.)

   Mapped reductions that accumulate the results of a given
  function applied to each element.

   Reductions to scalar doubles, longs, and ints, using a
  given basis value.





  These bulk operations accept a parallelismThreshold
  argument. Methods proceed sequentially if the current map size is
  estimated to be less than the given threshold. Using a value of
  Long.MAX_VALUE suppresses all parallelism.  Using a value
  of 1 results in maximal parallelism by partitioning into
  enough subtasks to fully utilize the ForkJoinPool.commonPool() that is used for all parallel
  computations. Normally, you would initially choose one of these
  extreme values, and then measure performance of using in-between
  values that trade off overhead versus throughput.

  The concurrency properties of bulk operations follow
  from those of ConcurrentHashMap: Any non-null result returned
  from get(key) and related access methods bears a
  happens-before relation with the associated insertion or
  update.  The result of any bulk operation reflects the
  composition of these per-element relations (but is not
  necessarily atomic with respect to the map as a whole unless it
  is somehow known to be quiescent).  Conversely, because keys
  and values in the map are never null, null serves as a reliable
  atomic indicator of the current lack of any result.  To
  maintain this property, null serves as an implicit basis for
  all non-scalar reduction operations. For the double, long, and
  int versions, the basis should be one that, when combined with
  any other value, returns that other value (more formally, it
  should be the identity element for the reduction). Most common
  reductions have these properties; for example, computing a sum
  with basis 0 or a minimum with basis MAX_VALUE.

  Search and transformation functions provided as arguments
  should similarly return null to indicate the lack of any result
  (in which case it is not used). In the case of mapped
  reductions, this also enables transformations to serve as
  filters, returning null (or, in the case of primitive
  specializations, the identity basis) if the element should not
  be combined. You can create compound transformations and
  filterings by composing them yourself under this `null means
  there is nothing there now` rule before using them in search or
  reduce operations.

  Methods accepting and/or returning Entry arguments maintain
  key-value associations. They may be useful for example when
  finding the key for the greatest value. Note that `plain` Entry
  arguments can be supplied using new
  AbstractMap.SimpleEntry(k,v).

  Bulk operations may complete abruptly, throwing an
  exception encountered in the application of a supplied
  function. Bear in mind when handling such exceptions that other
  concurrently executing functions could also have thrown
  exceptions, or would have done so if the first exception had
  not occurred.

  Speedups for parallel compared to sequential forms are common
  but not guaranteed.  Parallel operations involving brief functions
  on small maps may execute more slowly than sequential forms if the
  underlying work to parallelize the computation is more expensive
  than the computation itself.  Similarly, parallelization may not
  lead to much actual parallelism if all processors are busy
  performing unrelated tasks.

  All arguments to all task methods must be non-null.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentHashMap]))

(defn ->concurrent-hash-map
  "Constructor.

  Creates a new, empty map with an initial table size based on
   the given number of elements (initialCapacity), table
   density (loadFactor), and number of concurrently
   updating threads (concurrencyLevel).

  initial-capacity - the initial capacity. The implementation performs internal sizing to accommodate this many elements, given the specified load factor. - `int`
  load-factor - the load factor (table density) for establishing the initial table size - `float`
  concurrency-level - the estimated number of concurrently updating threads. The implementation may use this value as a sizing hint. - `int`

  throws: java.lang.IllegalArgumentException - if the initial capacity is negative or the load factor or concurrencyLevel are nonpositive"
  ([^Integer initial-capacity ^Float load-factor ^Integer concurrency-level]
    (new ConcurrentHashMap initial-capacity load-factor concurrency-level))
  ([^Integer initial-capacity ^Float load-factor]
    (new ConcurrentHashMap initial-capacity load-factor))
  ([^Integer initial-capacity]
    (new ConcurrentHashMap initial-capacity))
  ([]
    (new ConcurrentHashMap )))

(defn *new-key-set
  "Creates a new Set backed by a ConcurrentHashMap
   from the given type to Boolean.TRUE.

  initial-capacity - The implementation performs internal sizing to accommodate this many elements. - `int`

  returns: the new set - `<K> java.util.concurrent.ConcurrentHashMap.KeySetView<K,java.lang.Boolean>`

  throws: java.lang.IllegalArgumentException - if the initial capacity of elements is negative"
  ([^Integer initial-capacity]
    (ConcurrentHashMap/newKeySet initial-capacity))
  ([]
    (ConcurrentHashMap/newKeySet )))

(defn for-each-key
  "Performs the given action for each non-null transformation
   of each key.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case the action is not applied) - `U>`
  action - the action - `U>`

  returns: `<U> void`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer action]
    (-> this (.forEachKey parallelism-threshold transformer action)))
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.K> action]
    (-> this (.forEachKey parallelism-threshold action))))

(defn values
  "Returns a Collection view of the values contained in this map.
   The collection is backed by the map, so changes to the map are
   reflected in the collection, and vice-versa.  The collection
   supports element removal, which removes the corresponding
   mapping from this map, via the Iterator.remove,
   Collection.remove, removeAll,
   retainAll, and clear operations.  It does not
   support the add or addAll operations.

   The view's iterators and spliterators are
   weakly consistent.

   The view's spliterator reports Spliterator.CONCURRENT
   and Spliterator.NONNULL.

  returns: the collection view - `java.util.Collection<ConcurrentHashMap.V>`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.values))))

(defn for-each
  "Performs the given action for each non-null transformation
   of each (key, value).

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case the action is not applied) - `U>`
  action - the action - `U>`

  returns: `<U> void`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer action]
    (-> this (.forEach parallelism-threshold transformer action)))
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> action]
    (-> this (.forEach parallelism-threshold action)))
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.V> action]
    (-> this (.forEach action))))

(defn reduce-entries-to-int
  "Returns the result of accumulating the given transformation
   of all entries using the given reducer to combine values,
   and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `java.util.function.ToIntFunction<java.util.Map.Entry<ConcurrentHashMap.K,ConcurrentHashMap.V>>`
  basis - the identity (initial default value) for the reduction - `int`
  reducer - a commutative associative combining function - `java.util.function.IntBinaryOperator`

  returns: the result of accumulating the given transformation
   of all entries - `int`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^java.util.function.ToIntFunction> transformer ^Integer basis ^java.util.function.IntBinaryOperator reducer]
    (-> this (.reduceEntriesToInt parallelism-threshold transformer basis reducer))))

(defn keys
  "Returns an enumeration of the keys in this table.

  returns: an enumeration of the keys in this table - `java.util.Enumeration<ConcurrentHashMap.K>`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.keys))))

(defn replace-all
  "Description copied from interface: ConcurrentMap

  function - the function to apply to each entry - `ConcurrentHashMap.V>`"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.V> function]
    (-> this (.replaceAll function))))

(defn put-all
  "Copies all of the mappings from the specified map to this one.
   These mappings replace any mappings that this map had for any of the
   keys currently in the specified map.

  m - mappings to be stored in this map - `ConcurrentHashMap.V>`"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.V> m]
    (-> this (.putAll m))))

(defn put-if-absent
  "If the specified key is not already associated
   with a value, associate it with the given value.
   This is equivalent to


   if (!map.containsKey(key))
     return map.put(key, value);
   else
     return map.get(key);

   except that the action is performed atomically.

  key - key with which the specified value is to be associated - `ConcurrentHashMap.K`
  value - value to be associated with the specified key - `ConcurrentHashMap.V`

  returns: the previous value associated with the specified key,
           or null if there was no mapping for the key - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key or value is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V value]
    (-> this (.putIfAbsent key value))))

(defn reduce-keys
  "Returns the result of accumulating the given transformation
   of all keys using the given reducer to combine values, or
   null if none.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case it is not combined) - `U>`
  reducer - a commutative associative combining function - `U>`

  returns: the result of accumulating the given transformation
   of all keys - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer reducer]
    (-> this (.reduceKeys parallelism-threshold transformer reducer)))
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.K> reducer]
    (-> this (.reduceKeys parallelism-threshold reducer))))

(defn reduce-entries
  "Returns the result of accumulating the given transformation
   of all entries using the given reducer to combine values,
   or null if none.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case it is not combined) - `U>`
  reducer - a commutative associative combining function - `U>`

  returns: the result of accumulating the given transformation
   of all entries - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer reducer]
    (-> this (.reduceEntries parallelism-threshold transformer reducer)))
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^java.util.Map.Entry> reducer]
    (-> this (.reduceEntries parallelism-threshold reducer))))

(defn put
  "Maps the specified key to the specified value in this table.
   Neither the key nor the value can be null.

   The value can be retrieved by calling the get method
   with a key that is equal to the original key.

  key - key with which the specified value is to be associated - `ConcurrentHashMap.K`
  value - value to be associated with the specified key - `ConcurrentHashMap.V`

  returns: the previous value associated with key, or
           null if there was no mapping for key - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key or value is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V value]
    (-> this (.put key value))))

(defn reduce-keys-to-long
  "Returns the result of accumulating the given transformation
   of all keys using the given reducer to combine values, and
   the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.K>`
  basis - the identity (initial default value) for the reduction - `long`
  reducer - a commutative associative combining function - `java.util.function.LongBinaryOperator`

  returns: the result of accumulating the given transformation
   of all keys - `long`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.K> transformer ^Long basis ^java.util.function.LongBinaryOperator reducer]
    (-> this (.reduceKeysToLong parallelism-threshold transformer basis reducer))))

(defn entry-set
  "Returns a Set view of the mappings contained in this map.
   The set is backed by the map, so changes to the map are
   reflected in the set, and vice-versa.  The set supports element
   removal, which removes the corresponding mapping from the map,
   via the Iterator.remove, Set.remove,
   removeAll, retainAll, and clear
   operations.

   The view's iterators and spliterators are
   weakly consistent.

   The view's spliterator reports Spliterator.CONCURRENT,
   Spliterator.DISTINCT, and Spliterator.NONNULL.

  returns: the set view - `java.util.Set<java.util.Map.Entry<ConcurrentHashMap.K,ConcurrentHashMap.V>>`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.entrySet))))

(defn contains
  "Legacy method testing if some key maps into the specified value
   in this table.  This method is identical in functionality to
   containsValue(Object), and exists solely to ensure
   full compatibility with class Hashtable,
   which supported this method prior to introduction of the
   Java Collections framework.

  value - a value to search for - `java.lang.Object`

  returns: true if and only if some key maps to the
           value argument in this table as
           determined by the equals method;
           false otherwise - `boolean`

  throws: java.lang.NullPointerException - if the specified value is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object value]
    (-> this (.contains value))))

(defn reduce-values-to-long
  "Returns the result of accumulating the given transformation
   of all values using the given reducer to combine values,
   and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.V>`
  basis - the identity (initial default value) for the reduction - `long`
  reducer - a commutative associative combining function - `java.util.function.LongBinaryOperator`

  returns: the result of accumulating the given transformation
   of all values - `long`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> transformer ^Long basis ^java.util.function.LongBinaryOperator reducer]
    (-> this (.reduceValuesToLong parallelism-threshold transformer basis reducer))))

(defn to-string
  "Returns a string representation of this map.  The string
   representation consists of a list of key-value mappings (in no
   particular order) enclosed in braces (`{}`).  Adjacent
   mappings are separated by the characters `, ` (comma
   and space).  Each key-value mapping is rendered as the key
   followed by an equals sign (`=`) followed by the
   associated value.

  returns: a string representation of this map - `java.lang.String`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.toString))))

(defn contains-value
  "Returns true if this map maps one or more keys to the
   specified value. Note: This method may require a full traversal
   of the map, and is much slower than method containsKey.

  value - value whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map maps one or more keys to the
           specified value - `boolean`

  throws: java.lang.NullPointerException - if the specified value is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn search-keys
  "Returns a non-null result from applying the given search
   function on each key, or null if none. Upon success,
   further element processing is suppressed and the results of
   any other parallel invocations of the search function are
   ignored.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  search-function - a function returning a non-null result on success, else null - `U>`

  returns: a non-null result from applying the given search
   function on each key, or null if none - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold search-function]
    (-> this (.searchKeys parallelism-threshold search-function))))

(defn get-or-default
  "Returns the value to which the specified key is mapped, or the
   given default value if this map contains no mapping for the
   key.

  key - the key whose associated value is to be returned - `java.lang.Object`
  default-value - the value to return if this map contains no mapping for the given key - `ConcurrentHashMap.V`

  returns: the mapping for the key, if present; else the default value - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object key ^ConcurrentHashMap.V default-value]
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

  key - key with which the specified value is associated - `ConcurrentHashMap.K`
  old-value - value expected to be associated with the specified key - `ConcurrentHashMap.V`
  new-value - value to be associated with the specified key - `ConcurrentHashMap.V`

  returns: true if the value was replaced - `boolean`

  throws: java.lang.NullPointerException - if any of the arguments are null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V old-value ^ConcurrentHashMap.V new-value]
    (-> this (.replace key old-value new-value)))
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V value]
    (-> this (.replace key value))))

(defn reduce-keys-to-int
  "Returns the result of accumulating the given transformation
   of all keys using the given reducer to combine values, and
   the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.K>`
  basis - the identity (initial default value) for the reduction - `int`
  reducer - a commutative associative combining function - `java.util.function.IntBinaryOperator`

  returns: the result of accumulating the given transformation
   of all keys - `int`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.K> transformer ^Integer basis ^java.util.function.IntBinaryOperator reducer]
    (-> this (.reduceKeysToInt parallelism-threshold transformer basis reducer))))

(defn reduce-values-to-int
  "Returns the result of accumulating the given transformation
   of all values using the given reducer to combine values,
   and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.V>`
  basis - the identity (initial default value) for the reduction - `int`
  reducer - a commutative associative combining function - `java.util.function.IntBinaryOperator`

  returns: the result of accumulating the given transformation
   of all values - `int`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> transformer ^Integer basis ^java.util.function.IntBinaryOperator reducer]
    (-> this (.reduceValuesToInt parallelism-threshold transformer basis reducer))))

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

  throws: java.lang.NullPointerException - if the specified key is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.remove key value)))
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object key]
    (-> this (.remove key))))

(defn mapping-count
  "Returns the number of mappings. This method should be used
   instead of size() because a ConcurrentHashMap may
   contain more mappings than can be represented as an int. The
   value returned is an estimate; the actual count may differ if
   there are concurrent insertions or removals.

  returns: the number of mappings - `long`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.mappingCount))))

(defn key-set
  "Returns a Set view of the keys in this map, using the
   given common mapped value for any additions (i.e., Collection.add(E) and Collection.addAll(Collection)).
   This is of course only appropriate if it is acceptable to use
   the same value for all additions from this view.

  mapped-value - the mapped value to use for any additions - `ConcurrentHashMap.V`

  returns: the set view - `java.util.concurrent.ConcurrentHashMap.KeySetView<ConcurrentHashMap.K,ConcurrentHashMap.V>`

  throws: java.lang.NullPointerException - if the mappedValue is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.V mapped-value]
    (-> this (.keySet mapped-value)))
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.keySet))))

(defn for-each-entry
  "Performs the given action for each non-null transformation
   of each entry.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case the action is not applied) - `U>`
  action - the action - `U>`

  returns: `<U> void`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer action]
    (-> this (.forEachEntry parallelism-threshold transformer action)))
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^java.util.Map.Entry> action]
    (-> this (.forEachEntry parallelism-threshold action))))

(defn search-values
  "Returns a non-null result from applying the given search
   function on each value, or null if none.  Upon success,
   further element processing is suppressed and the results of
   any other parallel invocations of the search function are
   ignored.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  search-function - a function returning a non-null result on success, else null - `U>`

  returns: a non-null result from applying the given search
   function on each value, or null if none - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold search-function]
    (-> this (.searchValues parallelism-threshold search-function))))

(defn reduce-values
  "Returns the result of accumulating the given transformation
   of all values using the given reducer to combine values, or
   null if none.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case it is not combined) - `U>`
  reducer - a commutative associative combining function - `U>`

  returns: the result of accumulating the given transformation
   of all values - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer reducer]
    (-> this (.reduceValues parallelism-threshold transformer reducer)))
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> reducer]
    (-> this (.reduceValues parallelism-threshold reducer))))

(defn reduce-to-int
  "Returns the result of accumulating the given transformation
   of all (key, value) pairs using the given reducer to
   combine values, and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.V>`
  basis - the identity (initial default value) for the reduction - `int`
  reducer - a commutative associative combining function - `java.util.function.IntBinaryOperator`

  returns: the result of accumulating the given transformation
   of all (key, value) pairs - `int`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> transformer ^Integer basis ^java.util.function.IntBinaryOperator reducer]
    (-> this (.reduceToInt parallelism-threshold transformer basis reducer))))

(defn reduce-values-to-double
  "Returns the result of accumulating the given transformation
   of all values using the given reducer to combine values,
   and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.V>`
  basis - the identity (initial default value) for the reduction - `double`
  reducer - a commutative associative combining function - `java.util.function.DoubleBinaryOperator`

  returns: the result of accumulating the given transformation
   of all values - `double`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> transformer ^Double basis ^java.util.function.DoubleBinaryOperator reducer]
    (-> this (.reduceValuesToDouble parallelism-threshold transformer basis reducer))))

(defn compute-if-present
  "If the value for the specified key is present, attempts to
   compute a new mapping given the key and its current mapped
   value.  The entire method invocation is performed atomically.
   Some attempted update operations on this map by other threads
   may be blocked while computation is in progress, so the
   computation should be short and simple, and must not attempt to
   update any other mappings of this map.

  key - key with which a value may be associated - `ConcurrentHashMap.K`
  remapping-function - the function to compute a value - `ConcurrentHashMap.V>`

  returns: the new value associated with the specified key, or null if none - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key or remappingFunction is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V> remapping-function]
    (-> this (.computeIfPresent key remapping-function))))

(defn hash-code
  "Returns the hash code value for this Map, i.e.,
   the sum of, for each key-value pair in the map,
   key.hashCode() ^ value.hashCode().

  returns: the hash code value for this map - `int`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.hashCode))))

(defn reduce-to-double
  "Returns the result of accumulating the given transformation
   of all (key, value) pairs using the given reducer to
   combine values, and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.V>`
  basis - the identity (initial default value) for the reduction - `double`
  reducer - a commutative associative combining function - `java.util.function.DoubleBinaryOperator`

  returns: the result of accumulating the given transformation
   of all (key, value) pairs - `double`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> transformer ^Double basis ^java.util.function.DoubleBinaryOperator reducer]
    (-> this (.reduceToDouble parallelism-threshold transformer basis reducer))))

(defn empty?
  "Returns true if this map contains no key-value mappings.

  returns: true if this map contains no key-value mappings - `boolean`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of key-value mappings in this map.  If the
   map contains more than Integer.MAX_VALUE elements, returns
   Integer.MAX_VALUE.

  returns: the number of key-value mappings in this map - `int`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.size))))

(defn reduce
  "Returns the result of accumulating the given transformation
   of all (key, value) pairs using the given reducer to
   combine values, or null if none.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case it is not combined) - `U>`
  reducer - a commutative associative combining function - `U>`

  returns: the result of accumulating the given transformation
   of all (key, value) pairs - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer reducer]
    (-> this (.reduce parallelism-threshold transformer reducer))))

(defn clear
  "Removes all of the mappings from this map."
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.clear))))

(defn reduce-entries-to-double
  "Returns the result of accumulating the given transformation
   of all entries using the given reducer to combine values,
   and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `java.util.function.ToDoubleFunction<java.util.Map.Entry<ConcurrentHashMap.K,ConcurrentHashMap.V>>`
  basis - the identity (initial default value) for the reduction - `double`
  reducer - a commutative associative combining function - `java.util.function.DoubleBinaryOperator`

  returns: the result of accumulating the given transformation
   of all entries - `double`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^java.util.function.ToDoubleFunction> transformer ^Double basis ^java.util.function.DoubleBinaryOperator reducer]
    (-> this (.reduceEntriesToDouble parallelism-threshold transformer basis reducer))))

(defn for-each-value
  "Performs the given action for each non-null transformation
   of each value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element, or null if there is no transformation (in which case the action is not applied) - `U>`
  action - the action - `U>`

  returns: `<U> void`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold transformer action]
    (-> this (.forEachValue parallelism-threshold transformer action)))
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> action]
    (-> this (.forEachValue parallelism-threshold action))))

(defn reduce-entries-to-long
  "Returns the result of accumulating the given transformation
   of all entries using the given reducer to combine values,
   and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `java.util.function.ToLongFunction<java.util.Map.Entry<ConcurrentHashMap.K,ConcurrentHashMap.V>>`
  basis - the identity (initial default value) for the reduction - `long`
  reducer - a commutative associative combining function - `java.util.function.LongBinaryOperator`

  returns: the result of accumulating the given transformation
   of all entries - `long`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^java.util.function.ToLongFunction> transformer ^Long basis ^java.util.function.LongBinaryOperator reducer]
    (-> this (.reduceEntriesToLong parallelism-threshold transformer basis reducer))))

(defn contains-key
  "Tests if the specified object is a key in this table.

  key - possible key - `java.lang.Object`

  returns: true if and only if the specified object
           is a key in this table, as determined by the
           equals method; false otherwise - `boolean`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn search
  "Returns a non-null result from applying the given search
   function on each (key, value), or null if none.  Upon
   success, further element processing is suppressed and the
   results of any other parallel invocations of the search
   function are ignored.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  search-function - a function returning a non-null result on success, else null - `U>`

  returns: a non-null result from applying the given search
   function on each (key, value), or null if none - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold search-function]
    (-> this (.search parallelism-threshold search-function))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that key.equals(k),
   then this method returns v; otherwise it returns
   null.  (There can be at most one such mapping.)

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object key]
    (-> this (.get key))))

(defn reduce-keys-to-double
  "Returns the result of accumulating the given transformation
   of all keys using the given reducer to combine values, and
   the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.K>`
  basis - the identity (initial default value) for the reduction - `double`
  reducer - a commutative associative combining function - `java.util.function.DoubleBinaryOperator`

  returns: the result of accumulating the given transformation
   of all keys - `double`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.K> transformer ^Double basis ^java.util.function.DoubleBinaryOperator reducer]
    (-> this (.reduceKeysToDouble parallelism-threshold transformer basis reducer))))

(defn merge
  "If the specified key is not already associated with a
   (non-null) value, associates it with the given value.
   Otherwise, replaces the value with the results of the given
   remapping function, or removes if null. The entire
   method invocation is performed atomically.  Some attempted
   update operations on this map by other threads may be blocked
   while computation is in progress, so the computation should be
   short and simple, and must not attempt to update any other
   mappings of this Map.

  key - key with which the specified value is to be associated - `ConcurrentHashMap.K`
  value - the value to use if absent - `ConcurrentHashMap.V`
  remapping-function - the function to recompute a value if present - `ConcurrentHashMap.V>`

  returns: the new value associated with the specified key, or null if none - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key or the remappingFunction is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V value ^ConcurrentHashMap.V> remapping-function]
    (-> this (.merge key value remapping-function))))

(defn equals
  "Compares the specified object with this map for equality.
   Returns true if the given object is a map with the same
   mappings as this map.  This operation may return misleading
   results if either map is concurrently modified during execution
   of this method.

  o - object to be compared for equality with this map - `java.lang.Object`

  returns: true if the specified object is equal to this map - `boolean`"
  ([^java.util.concurrent.ConcurrentHashMap this ^java.lang.Object o]
    (-> this (.equals o))))

(defn compute
  "Attempts to compute a mapping for the specified key and its
   current mapped value (or null if there is no current
   mapping). The entire method invocation is performed atomically.
   Some attempted update operations on this map by other threads
   may be blocked while computation is in progress, so the
   computation should be short and simple, and must not attempt to
   update any other mappings of this Map.

  key - key with which the specified value is to be associated - `ConcurrentHashMap.K`
  remapping-function - the function to compute a value - `ConcurrentHashMap.V>`

  returns: the new value associated with the specified key, or null if none - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key or remappingFunction is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V> remapping-function]
    (-> this (.compute key remapping-function))))

(defn reduce-to-long
  "Returns the result of accumulating the given transformation
   of all (key, value) pairs using the given reducer to
   combine values, and the given basis as an identity value.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  transformer - a function returning the transformation for an element - `ConcurrentHashMap.V>`
  basis - the identity (initial default value) for the reduction - `long`
  reducer - a commutative associative combining function - `java.util.function.LongBinaryOperator`

  returns: the result of accumulating the given transformation
   of all (key, value) pairs - `long`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold ^ConcurrentHashMap.V> transformer ^Long basis ^java.util.function.LongBinaryOperator reducer]
    (-> this (.reduceToLong parallelism-threshold transformer basis reducer))))

(defn search-entries
  "Returns a non-null result from applying the given search
   function on each entry, or null if none.  Upon success,
   further element processing is suppressed and the results of
   any other parallel invocations of the search function are
   ignored.

  parallelism-threshold - the (estimated) number of elements needed for this operation to be executed in parallel - `long`
  search-function - a function returning a non-null result on success, else null - `U>`

  returns: a non-null result from applying the given search
   function on each entry, or null if none - `<U> U`"
  ([^java.util.concurrent.ConcurrentHashMap this ^Long parallelism-threshold search-function]
    (-> this (.searchEntries parallelism-threshold search-function))))

(defn elements
  "Returns an enumeration of the values in this table.

  returns: an enumeration of the values in this table - `java.util.Enumeration<ConcurrentHashMap.V>`"
  ([^java.util.concurrent.ConcurrentHashMap this]
    (-> this (.elements))))

(defn compute-if-absent
  "If the specified key is not already associated with a value,
   attempts to compute its value using the given mapping function
   and enters it into this map unless null.  The entire
   method invocation is performed atomically, so the function is
   applied at most once per key.  Some attempted update operations
   on this map by other threads may be blocked while computation
   is in progress, so the computation should be short and simple,
   and must not attempt to update any other mappings of this map.

  key - key with which the specified value is to be associated - `ConcurrentHashMap.K`
  mapping-function - the function to compute a value - `ConcurrentHashMap.V>`

  returns: the current (existing or computed) value associated with
           the specified key, or null if the computed value is null - `ConcurrentHashMap.V`

  throws: java.lang.NullPointerException - if the specified key or mappingFunction is null"
  ([^java.util.concurrent.ConcurrentHashMap this ^ConcurrentHashMap.K key ^ConcurrentHashMap.V> mapping-function]
    (-> this (.computeIfAbsent key mapping-function))))

