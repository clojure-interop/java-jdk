(ns jdk.util.Hashtable
  "This class implements a hash table, which maps keys to values. Any
  non-null object can be used as a key or as a value.

  To successfully store and retrieve objects from a hashtable, the
  objects used as keys must implement the hashCode
  method and the equals method.

  An instance of Hashtable has two parameters that affect its
  performance: initial capacity and load factor.  The
  capacity is the number of buckets in the hash table, and the
  initial capacity is simply the capacity at the time the hash table
  is created.  Note that the hash table is open: in the case of a `hash
  collision`, a single bucket stores multiple entries, which must be searched
  sequentially.  The load factor is a measure of how full the hash
  table is allowed to get before its capacity is automatically increased.
  The initial capacity and load factor parameters are merely hints to
  the implementation.  The exact details as to when and whether the rehash
  method is invoked are implementation-dependent.

  Generally, the default load factor (.75) offers a good tradeoff between
  time and space costs.  Higher values decrease the space overhead but
  increase the time cost to look up an entry (which is reflected in most
  Hashtable operations, including get and put).

  The initial capacity controls a tradeoff between wasted space and the
  need for rehash operations, which are time-consuming.
  No rehash operations will ever occur if the initial
  capacity is greater than the maximum number of entries the
  Hashtable will contain divided by its load factor.  However,
  setting the initial capacity too high can waste space.

  If many entries are to be made into a Hashtable,
  creating it with a sufficiently large capacity may allow the
  entries to be inserted more efficiently than letting it perform
  automatic rehashing as needed to grow the table.

  This example creates a hashtable of numbers. It uses the names of
  the numbers as keys:


    Hashtable<String, Integer> numbers
      = new Hashtable<String, Integer>();
    numbers.put(`one`, 1);
    numbers.put(`two`, 2);
    numbers.put(`three`, 3);

  To retrieve a number, use the following code:


    Integer n = numbers.get(`two`);
    if (n != null) {
      System.out.println(`two = `  n);
    }

  The iterators returned by the iterator method of the collections
  returned by all of this class's `collection view methods` are
  fail-fast: if the Hashtable is structurally modified at any time
  after the iterator is created, in any way except through the iterator's own
  remove method, the iterator will throw a ConcurrentModificationException.  Thus, in the face of concurrent
  modification, the iterator fails quickly and cleanly, rather than risking
  arbitrary, non-deterministic behavior at an undetermined time in the future.
  The Enumerations returned by Hashtable's keys and elements methods are
  not fail-fast.

  Note that the fail-fast behavior of an iterator cannot be guaranteed
  as it is, generally speaking, impossible to make any hard guarantees in the
  presence of unsynchronized concurrent modification.  Fail-fast iterators
  throw ConcurrentModificationException on a best-effort basis.
  Therefore, it would be wrong to write a program that depended on this
  exception for its correctness: the fail-fast behavior of iterators
  should be used only to detect bugs.

  As of the Java 2 platform v1.2, this class was retrofitted to
  implement the Map interface, making it a member of the


  Java Collections Framework.  Unlike the new collection
  implementations, Hashtable is synchronized.  If a
  thread-safe implementation is not needed, it is recommended to use
  HashMap in place of Hashtable.  If a thread-safe
  highly-concurrent implementation is desired, then it is recommended
  to use ConcurrentHashMap in place of
  Hashtable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Hashtable]))

(defn ->hashtable
  "Constructor.

  Constructs a new, empty hashtable with the specified initial
   capacity and the specified load factor.

  initial-capacity - the initial capacity of the hashtable. - `int`
  load-factor - the load factor of the hashtable. - `float`

  throws: java.lang.IllegalArgumentException - if the initial capacity is less than zero, or if the load factor is nonpositive."
  ([^Integer initial-capacity ^Float load-factor]
    (new Hashtable initial-capacity load-factor))
  ([^Integer initial-capacity]
    (new Hashtable initial-capacity))
  ([]
    (new Hashtable )))

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

  returns: a collection view of the values contained in this map - `java.util.Collection<Hashtable.V>`"
  (^java.util.Collection [^java.util.Hashtable this]
    (-> this (.values))))

(defn for-each
  "Description copied from interface: Map

  action - The action to be performed for each entry - `Hashtable.V>`"
  ([^java.util.Hashtable this ^Hashtable.V> action]
    (-> this (.forEach action))))

(defn keys
  "Returns an enumeration of the keys in this hashtable.

  returns: an enumeration of the keys in this hashtable. - `java.util.Enumeration<Hashtable.K>`"
  (^java.util.Enumeration [^java.util.Hashtable this]
    (-> this (.keys))))

(defn replace-all
  "Description copied from interface: Map

  function - the function to apply to each entry - `Hashtable.V>`"
  ([^java.util.Hashtable this ^Hashtable.V> function]
    (-> this (.replaceAll function))))

(defn put-all
  "Copies all of the mappings from the specified map to this hashtable.
   These mappings will replace any mappings that this hashtable had for any
   of the keys currently in the specified map.

  t - mappings to be stored in this map - `Hashtable.V>`

  throws: java.lang.NullPointerException - if the specified map is null"
  ([^java.util.Hashtable this ^Hashtable.V> t]
    (-> this (.putAll t))))

(defn put-if-absent
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `Hashtable.K`
  value - value to be associated with the specified key - `Hashtable.V`

  returns: the previous value associated with the specified key, or
           null if there was no mapping for the key.
           (A null return can also indicate that the map
           previously associated null with the key,
           if the implementation supports null values.) - `Hashtable.V`"
  (^Hashtable.V [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V value]
    (-> this (.putIfAbsent key value))))

(defn put
  "Maps the specified key to the specified
   value in this hashtable. Neither the key nor the
   value can be null.

   The value can be retrieved by calling the get method
   with a key that is equal to the original key.

  key - the hashtable key - `Hashtable.K`
  value - the value - `Hashtable.V`

  returns: the previous value of the specified key in this hashtable,
               or null if it did not have one - `Hashtable.V`

  throws: java.lang.NullPointerException - if the key or value is null"
  (^Hashtable.V [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V value]
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

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map.Entry<Hashtable.K,Hashtable.V>>`"
  (^java.util.Set> [^java.util.Hashtable this]
    (-> this (.entrySet))))

(defn contains
  "Tests if some key maps into the specified value in this hashtable.
   This operation is more expensive than the containsKey method.

   Note that this method is identical in functionality to
   containsValue, (which is part of the
   Map interface in the collections framework).

  value - a value to search for - `java.lang.Object`

  returns: true if and only if some key maps to the
               value argument in this hashtable as
               determined by the equals method;
               false otherwise. - `boolean`

  throws: java.lang.NullPointerException - if the value is null"
  (^Boolean [^java.util.Hashtable this ^java.lang.Object value]
    (-> this (.contains value))))

(defn to-string
  "Returns a string representation of this Hashtable object
   in the form of a set of entries, enclosed in braces and separated
   by the ASCII characters `, ` (comma and space). Each
   entry is rendered as the key, an equals sign =, and the
   associated element, where the toString method is used to
   convert the key and element to strings.

  returns: a string representation of this hashtable - `java.lang.String`"
  (^java.lang.String [^java.util.Hashtable this]
    (-> this (.toString))))

(defn contains-value
  "Returns true if this hashtable maps one or more keys to this value.

   Note that this method is identical in functionality to contains (which predates the Map interface).

  value - value whose presence in this hashtable is to be tested - `java.lang.Object`

  returns: true if this map maps one or more keys to the
           specified value - `boolean`

  throws: java.lang.NullPointerException - if the value is null"
  (^Boolean [^java.util.Hashtable this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn get-or-default
  "Description copied from interface: Map

  key - the key whose associated value is to be returned - `java.lang.Object`
  default-value - the default mapping of the key - `Hashtable.V`

  returns: the value to which the specified key is mapped, or
   defaultValue if this map contains no mapping for the key - `Hashtable.V`"
  (^Hashtable.V [^java.util.Hashtable this ^java.lang.Object key ^Hashtable.V default-value]
    (-> this (.getOrDefault key default-value))))

(defn replace
  "Description copied from interface: Map

  key - key with which the specified value is associated - `Hashtable.K`
  old-value - value expected to be associated with the specified key - `Hashtable.V`
  new-value - value to be associated with the specified key - `Hashtable.V`

  returns: true if the value was replaced - `boolean`"
  (^Boolean [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V old-value ^Hashtable.V new-value]
    (-> this (.replace key old-value new-value)))
  (^Hashtable.V [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V value]
    (-> this (.replace key value))))

(defn remove
  "Description copied from interface: Map

  key - key with which the specified value is associated - `java.lang.Object`
  value - value expected to be associated with the specified key - `java.lang.Object`

  returns: true if the value was removed - `boolean`"
  (^Boolean [^java.util.Hashtable this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.remove key value)))
  (^Hashtable.V [^java.util.Hashtable this ^java.lang.Object key]
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

  returns: a set view of the keys contained in this map - `java.util.Set<Hashtable.K>`"
  (^java.util.Set [^java.util.Hashtable this]
    (-> this (.keySet))))

(defn clone
  "Creates a shallow copy of this hashtable. All the structure of the
   hashtable itself is copied, but the keys and values are not cloned.
   This is a relatively expensive operation.

  returns: a clone of the hashtable - `java.lang.Object`"
  (^java.lang.Object [^java.util.Hashtable this]
    (-> this (.clone))))

(defn compute-if-present
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `Hashtable.K`
  remapping-function - the function to compute a value - `Hashtable.V>`

  returns: the new value associated with the specified key, or null if none - `Hashtable.V`"
  (^Hashtable.V [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V> remapping-function]
    (-> this (.computeIfPresent key remapping-function))))

(defn hash-code
  "Returns the hash code value for this Map as per the definition in the
   Map interface.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.util.Hashtable this]
    (-> this (.hashCode))))

(defn empty?
  "Tests if this hashtable maps no keys to values.

  returns: true if this hashtable maps no keys to values;
            false otherwise. - `boolean`"
  (^Boolean [^java.util.Hashtable this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of keys in this hashtable.

  returns: the number of keys in this hashtable. - `int`"
  (^Integer [^java.util.Hashtable this]
    (-> this (.size))))

(defn clear
  "Clears this hashtable so that it contains no keys."
  ([^java.util.Hashtable this]
    (-> this (.clear))))

(defn contains-key
  "Tests if the specified object is a key in this hashtable.

  key - possible key - `java.lang.Object`

  returns: true if and only if the specified object
            is a key in this hashtable, as determined by the
            equals method; false otherwise. - `boolean`

  throws: java.lang.NullPointerException - if the key is null"
  (^Boolean [^java.util.Hashtable this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which the specified key is mapped,
   or null if this map contains no mapping for the key.

   More formally, if this map contains a mapping from a key
   k to a value v such that (key.equals(k)),
   then this method returns v; otherwise it returns
   null.  (There can be at most one such mapping.)

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `Hashtable.V`

  throws: java.lang.NullPointerException - if the specified key is null"
  (^Hashtable.V [^java.util.Hashtable this ^java.lang.Object key]
    (-> this (.get key))))

(defn merge
  "Description copied from interface: Map

  key - key with which the resulting value is to be associated - `Hashtable.K`
  value - the non-null value to be merged with the existing value associated with the key or, if no existing value or a null value is associated with the key, to be associated with the key - `Hashtable.V`
  remapping-function - the function to recompute a value if present - `Hashtable.V>`

  returns: the new value associated with the specified key, or null if no
           value is associated with the key - `Hashtable.V`"
  (^Hashtable.V [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V value ^Hashtable.V> remapping-function]
    (-> this (.merge key value remapping-function))))

(defn equals
  "Compares the specified Object with this Map for equality,
   as per the definition in the Map interface.

  o - object to be compared for equality with this hashtable - `java.lang.Object`

  returns: true if the specified Object is equal to this Map - `boolean`"
  (^Boolean [^java.util.Hashtable this ^java.lang.Object o]
    (-> this (.equals o))))

(defn compute
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `Hashtable.K`
  remapping-function - the function to compute a value - `Hashtable.V>`

  returns: the new value associated with the specified key, or null if none - `Hashtable.V`"
  (^Hashtable.V [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V> remapping-function]
    (-> this (.compute key remapping-function))))

(defn elements
  "Returns an enumeration of the values in this hashtable.
   Use the Enumeration methods on the returned object to fetch the elements
   sequentially.

  returns: an enumeration of the values in this hashtable. - `java.util.Enumeration<Hashtable.V>`"
  (^java.util.Enumeration [^java.util.Hashtable this]
    (-> this (.elements))))

(defn compute-if-absent
  "Description copied from interface: Map

  key - key with which the specified value is to be associated - `Hashtable.K`
  mapping-function - the function to compute a value - `Hashtable.V>`

  returns: the current (existing or computed) value associated with
           the specified key, or null if the computed value is null - `Hashtable.V`"
  (^Hashtable.V [^java.util.Hashtable this ^Hashtable.K key ^Hashtable.V> mapping-function]
    (-> this (.computeIfAbsent key mapping-function))))

