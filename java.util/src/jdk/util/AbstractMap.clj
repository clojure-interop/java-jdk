(ns jdk.util.AbstractMap
  "This class provides a skeletal implementation of the Map
  interface, to minimize the effort required to implement this interface.

  To implement an unmodifiable map, the programmer needs only to extend this
  class and provide an implementation for the entrySet method, which
  returns a set-view of the map's mappings.  Typically, the returned set
  will, in turn, be implemented atop AbstractSet.  This set should
  not support the add or remove methods, and its iterator
  should not support the remove method.

  To implement a modifiable map, the programmer must additionally override
  this class's put method (which otherwise throws an
  UnsupportedOperationException), and the iterator returned by
  entrySet().iterator() must additionally implement its
  remove method.

  The programmer should generally provide a void (no argument) and map
  constructor, as per the recommendation in the Map interface
  specification.

  The documentation for each non-abstract method in this class describes its
  implementation in detail.  Each of these methods may be overridden if the
  map being implemented admits a more efficient implementation.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util AbstractMap]))

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

  returns: a collection view of the values contained in this map - `java.util.Collection<AbstractMap.V>`"
  ([this]
    (-> this (.values))))

(defn put-all
  "Copies all of the mappings from the specified map to this map
   (optional operation).  The effect of this call is equivalent to that
   of calling put(k, v) on this map once
   for each mapping from key k to value v in the
   specified map.  The behavior of this operation is undefined if the
   specified map is modified while the operation is in progress.

  m - mappings to be stored in this map - `AbstractMap.V>`

  throws: java.lang.UnsupportedOperationException - if the putAll operation is not supported by this map"
  ([this m]
    (-> this (.putAll m))))

(defn put
  "Associates the specified value with the specified key in this map
   (optional operation).  If the map previously contained a mapping for
   the key, the old value is replaced by the specified value.  (A map
   m is said to contain a mapping for a key k if and only
   if m.containsKey(k) would return
   true.)

  key - key with which the specified value is to be associated - `AbstractMap.K`
  value - value to be associated with the specified key - `AbstractMap.V`

  returns: the previous value associated with key, or
           null if there was no mapping for key.
           (A null return can also indicate that the map
           previously associated null with key,
           if the implementation supports null values.) - `AbstractMap.V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by this map"
  ([this key value]
    (-> this (.put key value))))

(defn entry-set
  "Description copied from interface: Map

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map.Entry<AbstractMap.K,AbstractMap.V>>`"
  ([this]
    (-> this (.entrySet))))

(defn to-string
  "Returns a string representation of this map.  The string representation
   consists of a list of key-value mappings in the order returned by the
   map's entrySet view's iterator, enclosed in braces
   (`{}`).  Adjacent mappings are separated by the characters
   `, ` (comma and space).  Each key-value mapping is rendered as
   the key followed by an equals sign (`=`) followed by the
   associated value.  Keys and values are converted to strings as by
   String.valueOf(Object).

  returns: a string representation of this map - `java.lang.String`"
  ([this]
    (-> this (.toString))))

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
  ([this value]
    (-> this (.containsValue value))))

(defn remove
  "Removes the mapping for a key from this map if it is present
   (optional operation).   More formally, if this map contains a mapping
   from key k to value v such that
   (key==null ?  k==null : key.equals(k)), that mapping
   is removed.  (The map can contain at most one such mapping.)

   Returns the value to which this map previously associated the key,
   or null if the map contained no mapping for the key.

   If this map permits null values, then a return value of
   null does not necessarily indicate that the map
   contained no mapping for the key; it's also possible that the map
   explicitly mapped the key to null.

   The map will not contain a mapping for the specified key once the
   call returns.

  key - key whose mapping is to be removed from the map - `java.lang.Object`

  returns: the previous value associated with key, or
           null if there was no mapping for key. - `AbstractMap.V`

  throws: java.lang.UnsupportedOperationException - if the remove operation is not supported by this map"
  ([this key]
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

  returns: a set view of the keys contained in this map - `java.util.Set<AbstractMap.K>`"
  ([this]
    (-> this (.keySet))))

(defn hash-code
  "Returns the hash code value for this map.  The hash code of a map is
   defined to be the sum of the hash codes of each entry in the map's
   entrySet() view.  This ensures that m1.equals(m2)
   implies that m1.hashCode()==m2.hashCode() for any two maps
   m1 and m2, as required by the general contract of
   Object.hashCode().

  returns: the hash code value for this map - `int`"
  ([this]
    (-> this (.hashCode))))

(defn empty?
  "Returns true if this map contains no key-value mappings.

  returns: true if this map contains no key-value mappings - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of key-value mappings in this map.  If the
   map contains more than Integer.MAX_VALUE elements, returns
   Integer.MAX_VALUE.

  returns: the number of key-value mappings in this map - `int`"
  ([this]
    (-> this (.size))))

(defn clear
  "Removes all of the mappings from this map (optional operation).
   The map will be empty after this call returns.

  throws: java.lang.UnsupportedOperationException - if the clear operation is not supported by this map"
  ([this]
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
  ([this key]
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
           null if this map contains no mapping for the key - `AbstractMap.V`

  throws: java.lang.ClassCastException - if the key is of an inappropriate type for this map (optional)"
  ([this key]
    (-> this (.get key))))

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
  ([this o]
    (-> this (.equals o))))

