(ns jdk.util.Map
  "An object that maps keys to values.  A map cannot contain duplicate keys;
  each key can map to at most one value.

  This interface takes the place of the Dictionary class, which
  was a totally abstract class rather than an interface.

  The Map interface provides three collection views, which
  allow a map's contents to be viewed as a set of keys, collection of values,
  or set of key-value mappings.  The order of a map is defined as
  the order in which the iterators on the map's collection views return their
  elements.  Some map implementations, like the TreeMap class, make
  specific guarantees as to their order; others, like the HashMap
  class, do not.

  Note: great care must be exercised if mutable objects are used as map
  keys.  The behavior of a map is not specified if the value of an object is
  changed in a manner that affects equals comparisons while the
  object is a key in the map.  A special case of this prohibition is that it
  is not permissible for a map to contain itself as a key.  While it is
  permissible for a map to contain itself as a value, extreme caution is
  advised: the equals and hashCode methods are no longer
  well defined on such a map.

  All general-purpose map implementation classes should provide two
  `standard` constructors: a void (no arguments) constructor which creates an
  empty map, and a constructor with a single argument of type Map,
  which creates a new map with the same key-value mappings as its argument.
  In effect, the latter constructor allows the user to copy any map,
  producing an equivalent map of the desired class.  There is no way to
  enforce this recommendation (as interfaces cannot contain constructors) but
  all of the general-purpose map implementations in the JDK comply.

  The `destructive` methods contained in this interface, that is, the
  methods that modify the map on which they operate, are specified to throw
  UnsupportedOperationException if this map does not support the
  operation.  If this is the case, these methods may, but are not required
  to, throw an UnsupportedOperationException if the invocation would
  have no effect on the map.  For example, invoking the putAll(Map)
  method on an unmodifiable map may, but is not required to, throw the
  exception if the map whose mappings are to be `superimposed` is empty.

  Some map implementations have restrictions on the keys and values they
  may contain.  For example, some implementations prohibit null keys and
  values, and some have restrictions on the types of their keys.  Attempting
  to insert an ineligible key or value throws an unchecked exception,
  typically NullPointerException or ClassCastException.
  Attempting to query the presence of an ineligible key or value may throw an
  exception, or it may simply return false; some implementations will exhibit
  the former behavior and some will exhibit the latter.  More generally,
  attempting an operation on an ineligible key or value whose completion
  would not result in the insertion of an ineligible element into the map may
  throw an exception or it may succeed, at the option of the implementation.
  Such exceptions are marked as `optional` in the specification for this
  interface.

  Many methods in Collections Framework interfaces are defined
  in terms of the equals method.  For
  example, the specification for the containsKey(Object key) method says: `returns true if and
  only if this map contains a mapping for a key k such that
  (key==null ? k==null : key.equals(k)).` This specification should
  not be construed to imply that invoking Map.containsKey
  with a non-null argument key will cause key.equals(k) to
  be invoked for any key k.  Implementations are free to
  implement optimizations whereby the equals invocation is avoided,
  for example, by first comparing the hash codes of the two keys.  (The
  Object.hashCode() specification guarantees that two objects with
  unequal hash codes cannot be equal.)  More generally, implementations of
  the various Collections Framework interfaces are free to take advantage of
  the specified behavior of underlying Object methods wherever the
  implementor deems it appropriate.

  Some map operations which perform recursive traversal of the map may fail
  with an exception for self-referential instances where the map directly or
  indirectly contains itself. This includes the clone(),
  equals(), hashCode() and toString() methods.
  Implementations may optionally handle the self-referential scenario, however
  most current implementations do not do so.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Map]))

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

  returns: a collection view of the values contained in this map - `java.util.Collection<Map.V>`"
  ([^. this]
    (-> this (.values))))

(defn for-each
  "Performs the given action for each entry in this map until all entries
   have been processed or the action throws an exception.   Unless
   otherwise specified by the implementing class, actions are performed in
   the order of entry set iteration (if an iteration order is specified.)
   Exceptions thrown by the action are relayed to the caller.

  action - The action to be performed for each entry - `Map.V>`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^. this ^Map.V> action]
    (-> this (.forEach action))))

(defn replace-all
  "Replaces each entry's value with the result of invoking the given
   function on that entry until all entries have been processed or the
   function throws an exception.  Exceptions thrown by the function are
   relayed to the caller.

  function - the function to apply to each entry - `Map.V>`

  returns: `default void`

  throws: java.lang.UnsupportedOperationException - if the set operation is not supported by this map's entry set iterator."
  ([^. this ^Map.V> function]
    (-> this (.replaceAll function))))

(defn put-all
  "Copies all of the mappings from the specified map to this map
   (optional operation).  The effect of this call is equivalent to that
   of calling put(k, v) on this map once
   for each mapping from key k to value v in the
   specified map.  The behavior of this operation is undefined if the
   specified map is modified while the operation is in progress.

  m - mappings to be stored in this map - `Map.V>`

  throws: java.lang.UnsupportedOperationException - if the putAll operation is not supported by this map"
  ([^. this ^Map.V> m]
    (-> this (.putAll m))))

(defn put-if-absent
  "If the specified key is not already associated with a value (or is mapped
   to null) associates it with the given value and returns
   null, else returns the current value.

  key - key with which the specified value is to be associated - `Map.K`
  value - value to be associated with the specified key - `Map.V`

  returns: the previous value associated with the specified key, or
           null if there was no mapping for the key.
           (A null return can also indicate that the map
           previously associated null with the key,
           if the implementation supports null values.) - `default Map.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map (optional)"
  ([^. this ^Map.K key ^Map.V value]
    (-> this (.putIfAbsent key value))))

(defn put
  "Associates the specified value with the specified key in this map
   (optional operation).  If the map previously contained a mapping for
   the key, the old value is replaced by the specified value.  (A map
   m is said to contain a mapping for a key k if and only
   if m.containsKey(k) would return
   true.)

  key - key with which the specified value is to be associated - `Map.K`
  value - value to be associated with the specified key - `Map.V`

  returns: the previous value associated with key, or
           null if there was no mapping for key.
           (A null return can also indicate that the map
           previously associated null with key,
           if the implementation supports null values.) - `Map.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map"
  ([^. this ^Map.K key ^Map.V value]
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

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map.Entry<Map.K,Map.V>>`"
  ([^. this]
    (-> this (.entrySet))))

(defn contains-value
  "Returns true if this map maps one or more keys to the
   specified value.  More formally, returns true if and only if
   this map contains at least one mapping to a value v such that
   (value==null ? v==null : value.equals(v)).  This operation
   will probably require time linear in the map size for most
   implementations of the Map interface.

  value - value whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map maps one or more keys to the
           specified value - `boolean`

  throws: java.lang.ClassCastException - if the value is of an inappropriate type for this map (optional)"
  ([^. this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn get-or-default
  "Returns the value to which the specified key is mapped, or
   defaultValue if this map contains no mapping for the key.

  key - the key whose associated value is to be returned - `java.lang.Object`
  default-value - the default mapping of the key - `Map.V`

  returns: the value to which the specified key is mapped, or
   defaultValue if this map contains no mapping for the key - `default Map.V`

  throws: java.lang.ClassCastException - if the key is of an inappropriate type for this map (optional)"
  ([^. this ^java.lang.Object key ^Map.V default-value]
    (-> this (.getOrDefault key default-value))))

(defn replace
  "Replaces the entry for the specified key only if currently
   mapped to the specified value.

  key - key with which the specified value is associated - `Map.K`
  old-value - value expected to be associated with the specified key - `Map.V`
  new-value - value to be associated with the specified key - `Map.V`

  returns: true if the value was replaced - `default boolean`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map (optional)"
  ([^. this ^Map.K key ^Map.V old-value ^Map.V new-value]
    (-> this (.replace key old-value new-value)))
  ([^. this ^Map.K key ^Map.V value]
    (-> this (.replace key value))))

(defn remove
  "Removes the entry for the specified key only if it is currently
   mapped to the specified value.

  key - key with which the specified value is associated - `java.lang.Object`
  value - value expected to be associated with the specified key - `java.lang.Object`

  returns: true if the value was removed - `default boolean`

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this map (optional)"
  ([^. this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.remove key value)))
  ([^. this ^java.lang.Object key]
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

  returns: a set view of the keys contained in this map - `java.util.Set<Map.K>`"
  ([^. this]
    (-> this (.keySet))))

(defn compute-if-present
  "If the value for the specified key is present and non-null, attempts to
   compute a new mapping given the key and its current mapped value.

   If the function returns null, the mapping is removed.  If the
   function itself throws an (unchecked) exception, the exception is
   rethrown, and the current mapping is left unchanged.

  key - key with which the specified value is to be associated - `Map.K`
  remapping-function - the function to compute a value - `Map.V>`

  returns: the new value associated with the specified key, or null if none - `default Map.V`

  throws: java.lang.NullPointerException - if the specified key is null and this map does not support null keys, or the remappingFunction is null"
  ([^. this ^Map.K key ^Map.V> remapping-function]
    (-> this (.computeIfPresent key remapping-function))))

(defn hash-code
  "Returns the hash code value for this map.  The hash code of a map is
   defined to be the sum of the hash codes of each entry in the map's
   entrySet() view.  This ensures that m1.equals(m2)
   implies that m1.hashCode()==m2.hashCode() for any two maps
   m1 and m2, as required by the general contract of
   Object.hashCode().

  returns: the hash code value for this map - `int`"
  ([^. this]
    (-> this (.hashCode))))

(defn empty?
  "Returns true if this map contains no key-value mappings.

  returns: true if this map contains no key-value mappings - `boolean`"
  ([^. this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of key-value mappings in this map.  If the
   map contains more than Integer.MAX_VALUE elements, returns
   Integer.MAX_VALUE.

  returns: the number of key-value mappings in this map - `int`"
  ([^. this]
    (-> this (.size))))

(defn clear
  "Removes all of the mappings from this map (optional operation).
   The map will be empty after this call returns.

  throws: java.lang.UnsupportedOperationException - if the clear operation is not supported by this map"
  ([^. this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this map contains a mapping for the specified
   key.  More formally, returns true if and only if
   this map contains a mapping for a key k such that
   (key==null ? k==null : key.equals(k)).  (There can be
   at most one such mapping.)

  key - key whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map contains a mapping for the specified
           key - `boolean`

  throws: java.lang.ClassCastException - if the key is of an inappropriate type for this map (optional)"
  ([^. this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that (key==null ? k==null :
   key.equals(k)), then this method returns v; otherwise
   it returns null.  (There can be at most one such mapping.)

   If this map permits null values, then a return value of
   null does not necessarily indicate that the map
   contains no mapping for the key; it's also possible that the map
   explicitly maps the key to null.  The containsKey operation may be used to distinguish these two cases.

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `Map.V`

  throws: java.lang.ClassCastException - if the key is of an inappropriate type for this map (optional)"
  ([^. this ^java.lang.Object key]
    (-> this (.get key))))

(defn merge
  "If the specified key is not already associated with a value or is
   associated with null, associates it with the given non-null value.
   Otherwise, replaces the associated value with the results of the given
   remapping function, or removes if the result is null. This
   method may be of use when combining multiple mapped values for a key.
   For example, to either create or append a String msg to a
   value mapping:



   map.merge(key, msg, String::concat)

   If the function returns null the mapping is removed.  If the
   function itself throws an (unchecked) exception, the exception is
   rethrown, and the current mapping is left unchanged.

  key - key with which the resulting value is to be associated - `Map.K`
  value - the non-null value to be merged with the existing value associated with the key or, if no existing value or a null value is associated with the key, to be associated with the key - `Map.V`
  remapping-function - the function to recompute a value if present - `Map.V>`

  returns: the new value associated with the specified key, or null if no
           value is associated with the key - `default Map.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map (optional)"
  ([^. this ^Map.K key ^Map.V value ^Map.V> remapping-function]
    (-> this (.merge key value remapping-function))))

(defn equals
  "Compares the specified object with this map for equality.  Returns
   true if the given object is also a map and the two maps
   represent the same mappings.  More formally, two maps m1 and
   m2 represent the same mappings if
   m1.entrySet().equals(m2.entrySet()).  This ensures that the
   equals method works properly across different implementations
   of the Map interface.

  o - object to be compared for equality with this map - `java.lang.Object`

  returns: true if the specified object is equal to this map - `boolean`"
  ([^. this ^java.lang.Object o]
    (-> this (.equals o))))

(defn compute
  "Attempts to compute a mapping for the specified key and its current
   mapped value (or null if there is no current mapping). For
   example, to either create or append a String msg to a value
   mapping:



   map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))
   (Method merge() is often simpler to use for such purposes.)

   If the function returns null, the mapping is removed (or
   remains absent if initially absent).  If the function itself throws an
   (unchecked) exception, the exception is rethrown, and the current mapping
   is left unchanged.

  key - key with which the specified value is to be associated - `Map.K`
  remapping-function - the function to compute a value - `Map.V>`

  returns: the new value associated with the specified key, or null if none - `default Map.V`

  throws: java.lang.NullPointerException - if the specified key is null and this map does not support null keys, or the remappingFunction is null"
  ([^. this ^Map.K key ^Map.V> remapping-function]
    (-> this (.compute key remapping-function))))

(defn compute-if-absent
  "If the specified key is not already associated with a value (or is mapped
   to null), attempts to compute its value using the given mapping
   function and enters it into this map unless null.

   If the function returns null no mapping is recorded. If
   the function itself throws an (unchecked) exception, the
   exception is rethrown, and no mapping is recorded.  The most
   common usage is to construct a new object serving as an initial
   mapped value or memoized result, as in:



   map.computeIfAbsent(key, k -> new Value(f(k)));

   Or to implement a multi-value map, Map<K,Collection<V>>,
   supporting multiple values per key:



   map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);

  key - key with which the specified value is to be associated - `Map.K`
  mapping-function - the function to compute a value - `Map.V>`

  returns: the current (existing or computed) value associated with
           the specified key, or null if the computed value is null - `default Map.V`

  throws: java.lang.NullPointerException - if the specified key is null and this map does not support null keys, or the mappingFunction is null"
  ([^. this ^Map.K key ^Map.V> mapping-function]
    (-> this (.computeIfAbsent key mapping-function))))

