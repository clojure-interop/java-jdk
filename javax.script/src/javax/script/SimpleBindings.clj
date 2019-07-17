(ns javax.script.SimpleBindings
  "A simple implementation of Bindings backed by
  a HashMap or some other specified Map."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script SimpleBindings]))

(defn ->simple-bindings
  "Constructor.

  Constructor uses an existing Map to store the values.

  m - The Map backing this SimpleBindings. - `java.util.Map<java.lang.String,java.lang.Object>`

  throws: java.lang.NullPointerException - if m is null"
  ([m]
    (new SimpleBindings m))
  ([]
    (new SimpleBindings )))

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

  returns: a collection view of the values contained in this map - `java.util.Collection<java.lang.Object>`"
  ([this]
    (-> this (.values))))

(defn put-all
  "putAll is implemented using Map.putAll.

  to-merge - The Map of values to add. - `java.lang.Object>`

  throws: java.lang.NullPointerException - if toMerge map is null or if some key in the map is null."
  ([this to-merge]
    (-> this (.putAll to-merge))))

(defn put
  "Sets the specified key/value in the underlying map field.

  name - Name of value - `java.lang.String`
  value - Value to set. - `java.lang.Object`

  returns: Previous value for the specified key.  Returns null if key was previously
   unset. - `java.lang.Object`

  throws: java.lang.NullPointerException - if the name is null."
  ([this name value]
    (-> this (.put name value))))

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

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map.Entry<java.lang.String,java.lang.Object>>`"
  ([this]
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
           specified value - `boolean`"
  ([this value]
    (-> this (.containsValue value))))

(defn remove
  "Removes the mapping for this key from this map if it is present
   (optional operation).   More formally, if this map contains a mapping
   from key k to value v such that
   (key==null ?  k==null : key.equals(k)), that mapping
   is removed.  (The map can contain at most one such mapping.)

   Returns the value to which the map previously associated the key, or
   null if the map contained no mapping for this key.  (A
   null return can also indicate that the map previously
   associated null with the specified key if the implementation
   supports null values.)  The map will not contain a mapping for
   the specified  key once the call returns.

  key - key whose mapping is to be removed from the map. - `java.lang.Object`

  returns: previous value associated with specified key, or null
           if there was no mapping for key. - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null"
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

  returns: a set view of the keys contained in this map - `java.util.Set<java.lang.String>`"
  ([this]
    (-> this (.keySet))))

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
   The map will be empty after this call returns."
  ([this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this map contains a mapping for the specified
   key.  More formally, returns true if and only if
   this map contains a mapping for a key k such that
   (key==null ? k==null : key.equals(k)).  (There can be
   at most one such mapping.)

  key - key whose presence in this map is to be tested. - `java.lang.Object`

  returns: true if this map contains a mapping for the specified
           key. - `boolean`

  throws: java.lang.NullPointerException - if key is null"
  ([this key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value to which this map maps the specified key.  Returns
   null if the map contains no mapping for this key.  A return
   value of null does not necessarily indicate that the
   map contains no mapping for the key; it's also possible that the map
   explicitly maps the key to null.  The containsKey
   operation may be used to distinguish these two cases.

   More formally, if this map contains a mapping from a key
   k to a value v such that (key==null ? k==null :
   key.equals(k)), then this method returns v; otherwise
   it returns null.  (There can be at most one such mapping.)

  key - key whose associated value is to be returned. - `java.lang.Object`

  returns: the value to which this map maps the specified key, or
           null if the map contains no mapping for this key. - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null"
  ([this key]
    (-> this (.get key))))

