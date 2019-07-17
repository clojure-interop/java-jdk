(ns jdk.util.concurrent.ConcurrentMap
  "A Map providing thread safety and atomicity
  guarantees.

  Memory consistency effects: As with other concurrent
  collections, actions in a thread prior to placing an object into a
  ConcurrentMap as a key or value
  happen-before
  actions subsequent to the access or removal of that object from
  the ConcurrentMap in another thread.

  This interface is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentMap]))

(defn for-each
  "Performs the given action for each entry in this map until all entries
   have been processed or the action throws an exception.   Unless
   otherwise specified by the implementing class, actions are performed in
   the order of entry set iteration (if an iteration order is specified.)
   Exceptions thrown by the action are relayed to the caller.

  action - The action to be performed for each entry - `ConcurrentMap.V>`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.V> action]
    (-> this (.forEach action))))

(defn replace-all
  "Replaces each entry's value with the result of invoking the given
   function on that entry until all entries have been processed or the
   function throws an exception.  Exceptions thrown by the function are
   relayed to the caller.

  function - the function to apply to each entry - `ConcurrentMap.V>`

  returns: `default void`

  throws: java.lang.UnsupportedOperationException - if the set operation is not supported by this map's entry set iterator."
  ([^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.V> function]
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

  key - key with which the specified value is to be associated - `ConcurrentMap.K`
  value - value to be associated with the specified key - `ConcurrentMap.V`

  returns: the previous value associated with the specified key, or
           null if there was no mapping for the key.
           (A null return can also indicate that the map
           previously associated null with the key,
           if the implementation supports null values.) - `ConcurrentMap.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map"
  (^ConcurrentMap.V [^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.K key ^ConcurrentMap.V value]
    (-> this (.putIfAbsent key value))))

(defn get-or-default
  "Returns the value to which the specified key is mapped, or
   defaultValue if this map contains no mapping for the key.

  key - the key whose associated value is to be returned - `java.lang.Object`
  default-value - the default mapping of the key - `ConcurrentMap.V`

  returns: the value to which the specified key is mapped, or
   defaultValue if this map contains no mapping for the key - `default ConcurrentMap.V`

  throws: java.lang.ClassCastException - if the key is of an inappropriate type for this map (optional)"
  ([^java.util.concurrent.ConcurrentMap this ^java.lang.Object key ^ConcurrentMap.V default-value]
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

  key - key with which the specified value is associated - `ConcurrentMap.K`
  old-value - value expected to be associated with the specified key - `ConcurrentMap.V`
  new-value - value to be associated with the specified key - `ConcurrentMap.V`

  returns: true if the value was replaced - `boolean`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map"
  (^Boolean [^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.K key ^ConcurrentMap.V old-value ^ConcurrentMap.V new-value]
    (-> this (.replace key old-value new-value)))
  (^ConcurrentMap.V [^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.K key ^ConcurrentMap.V value]
    (-> this (.replace key value))))

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

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this map"
  (^Boolean [^java.util.concurrent.ConcurrentMap this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.remove key value))))

(defn compute-if-present
  "If the value for the specified key is present and non-null, attempts to
   compute a new mapping given the key and its current mapped value.

   If the function returns null, the mapping is removed.  If the
   function itself throws an (unchecked) exception, the exception is
   rethrown, and the current mapping is left unchanged.

  key - key with which the specified value is to be associated - `ConcurrentMap.K`
  remapping-function - the function to compute a value - `ConcurrentMap.V>`

  returns: the new value associated with the specified key, or null if none - `default ConcurrentMap.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map (optional)"
  ([^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.K key ^ConcurrentMap.V> remapping-function]
    (-> this (.computeIfPresent key remapping-function))))

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

  key - key with which the resulting value is to be associated - `ConcurrentMap.K`
  value - the non-null value to be merged with the existing value associated with the key or, if no existing value or a null value is associated with the key, to be associated with the key - `ConcurrentMap.V`
  remapping-function - the function to recompute a value if present - `ConcurrentMap.V>`

  returns: the new value associated with the specified key, or null if no
           value is associated with the key - `default ConcurrentMap.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map (optional)"
  ([^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.K key ^ConcurrentMap.V value ^ConcurrentMap.V> remapping-function]
    (-> this (.merge key value remapping-function))))

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

  key - key with which the specified value is to be associated - `ConcurrentMap.K`
  remapping-function - the function to compute a value - `ConcurrentMap.V>`

  returns: the new value associated with the specified key, or null if none - `default ConcurrentMap.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map (optional)"
  ([^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.K key ^ConcurrentMap.V> remapping-function]
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

  key - key with which the specified value is to be associated - `ConcurrentMap.K`
  mapping-function - the function to compute a value - `ConcurrentMap.V>`

  returns: the current (existing or computed) value associated with
           the specified key, or null if the computed value is null - `default ConcurrentMap.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map (optional)"
  ([^java.util.concurrent.ConcurrentMap this ^ConcurrentMap.K key ^ConcurrentMap.V> mapping-function]
    (-> this (.computeIfAbsent key mapping-function))))

