(ns jdk.util.EnumMap,V>
  "A specialized Map implementation for use with enum type keys.  All
  of the keys in an enum map must come from a single enum type that is
  specified, explicitly or implicitly, when the map is created.  Enum maps
  are represented internally as arrays.  This representation is extremely
  compact and efficient.

  Enum maps are maintained in the natural order of their keys
  (the order in which the enum constants are declared).  This is reflected
  in the iterators returned by the collections views (keySet(),
  entrySet(), and values()).

  Iterators returned by the collection views are weakly consistent:
  they will never throw ConcurrentModificationException and they may
  or may not show the effects of any modifications to the map that occur while
  the iteration is in progress.

  Null keys are not permitted.  Attempts to insert a null key will
  throw NullPointerException.  Attempts to test for the
  presence of a null key or to remove one will, however, function properly.
  Null values are permitted.

  Like most collection implementations EnumMap is not
  synchronized. If multiple threads access an enum map concurrently, and at
  least one of the threads modifies the map, it should be synchronized
  externally.  This is typically accomplished by synchronizing on some
  object that naturally encapsulates the enum map.  If no such object exists,
  the map should be `wrapped` using the Collections.synchronizedMap(java.util.Map<K, V>)
  method.  This is best done at creation time, to prevent accidental
  unsynchronized access:



      Map<EnumKey, V> m
          = Collections.synchronizedMap(new EnumMap<EnumKey, V>(...));

  Implementation note: All basic operations execute in constant time.
  They are likely (though not guaranteed) to be faster than their
  HashMap counterparts.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util EnumMap,V>]))

(defn ->enum-map
  "Constructor.

  Creates an empty enum map with the specified key type.

  key-type - the class object of the key type for this enum map - `java.lang.Class<EnumMap.K>`

  throws: java.lang.NullPointerException - if keyType is null"
  ([^java.lang.Class key-type]
    (new EnumMap,V> key-type)))

(defn values
  "Returns a Collection view of the values contained in this map.
   The returned collection obeys the general contract outlined in
   Map.values().  The collection's iterator will return the
   values in the order their corresponding keys appear in map,
   which is their natural order (the order in which the enum constants
   are declared).

  returns: a collection view of the values contained in this map - `java.util.Collection<EnumMap.V>`"
  ([^java.util.EnumMap,V> this]
    (-> this (.values))))

(defn put-all
  "Copies all of the mappings from the specified map to this map.
   These mappings will replace any mappings that this map had for
   any of the keys currently in the specified map.

  m - the mappings to be stored in this map - `EnumMap.V>`

  throws: java.lang.NullPointerException - the specified map is null, or if one or more keys in the specified map are null"
  ([^java.util.EnumMap,V> this ^EnumMap.V> m]
    (-> this (.putAll m))))

(defn put
  "Associates the specified value with the specified key in this map.
   If the map previously contained a mapping for this key, the old
   value is replaced.

  key - the key with which the specified value is to be associated - `EnumMap.K`
  value - the value to be associated with the specified key - `EnumMap.V`

  returns: the previous value associated with specified key, or
       null if there was no mapping for key.  (A null
       return can also indicate that the map previously associated
       null with the specified key.) - `EnumMap.V`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([^java.util.EnumMap,V> this ^EnumMap.K key ^EnumMap.V value]
    (-> this (.put key value))))

(defn entry-set
  "Returns a Set view of the mappings contained in this map.
   The returned set obeys the general contract outlined in
   Map.keySet().  The set's iterator will return the
   mappings in the order their keys appear in map, which is their
   natural order (the order in which the enum constants are declared).

  returns: a set view of the mappings contained in this enum map - `java.util.Set<java.util.Map.Entry<EnumMap.K,EnumMap.V>>`"
  ([^java.util.EnumMap,V> this]
    (-> this (.entrySet))))

(defn contains-value
  "Returns true if this map maps one or more keys to the
   specified value.

  value - the value whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map maps one or more keys to this value - `boolean`"
  ([^java.util.EnumMap,V> this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn remove
  "Removes the mapping for this key from this map if present.

  key - the key whose mapping is to be removed from the map - `java.lang.Object`

  returns: the previous value associated with specified key, or
       null if there was no entry for key.  (A null
       return can also indicate that the map previously associated
       null with the specified key.) - `EnumMap.V`"
  ([^java.util.EnumMap,V> this ^java.lang.Object key]
    (-> this (.remove key))))

(defn key-set
  "Returns a Set view of the keys contained in this map.
   The returned set obeys the general contract outlined in
   Map.keySet().  The set's iterator will return the keys
   in their natural order (the order in which the enum constants
   are declared).

  returns: a set view of the keys contained in this enum map - `java.util.Set<EnumMap.K>`"
  ([^java.util.EnumMap,V> this]
    (-> this (.keySet))))

(defn clone
  "Returns a shallow copy of this enum map.  (The values themselves
   are not cloned.

  returns: a shallow copy of this enum map - `java.util.EnumMap<EnumMap.K,EnumMap.V>`"
  ([^java.util.EnumMap,V> this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this map.  The hash code of a map is
   defined to be the sum of the hash codes of each entry in the map.

  returns: the hash code value for this map - `int`"
  ([^java.util.EnumMap,V> this]
    (-> this (.hashCode))))

(defn size
  "Returns the number of key-value mappings in this map.

  returns: the number of key-value mappings in this map - `int`"
  ([^java.util.EnumMap,V> this]
    (-> this (.size))))

(defn clear
  "Removes all mappings from this map."
  ([^java.util.EnumMap,V> this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this map contains a mapping for the specified
   key.

  key - the key whose presence in this map is to be tested - `java.lang.Object`

  returns: true if this map contains a mapping for the specified
              key - `boolean`"
  ([^java.util.EnumMap,V> this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that (key == k),
   then this method returns v; otherwise it returns
   null.  (There can be at most one such mapping.)

   A return value of null does not necessarily
   indicate that the map contains no mapping for the key; it's also
   possible that the map explicitly maps the key to null.
   The containsKey operation may be used to
   distinguish these two cases.

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `EnumMap.V`"
  ([^java.util.EnumMap,V> this ^java.lang.Object key]
    (-> this (.get key))))

(defn equals
  "Compares the specified object with this map for equality.  Returns
   true if the given object is also a map and the two maps
   represent the same mappings, as specified in the Map.equals(Object) contract.

  o - the object to be compared for equality with this map - `java.lang.Object`

  returns: true if the specified object is equal to this map - `boolean`"
  ([^java.util.EnumMap,V> this ^java.lang.Object o]
    (-> this (.equals o))))

