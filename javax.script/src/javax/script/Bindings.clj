(ns javax.script.Bindings
  "A mapping of key/value pairs, all of whose keys are
  Strings."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script Bindings]))

(defn put
  "Set a named value.

  name - The name associated with the value. - `java.lang.String`
  value - The value associated with the name. - `java.lang.Object`

  returns: The value previously associated with the given name.
   Returns null if no value was previously associated with the name. - `java.lang.Object`

  throws: java.lang.NullPointerException - if the name is null."
  ([this name value]
    (-> this (.put name value))))

(defn put-all
  "Adds all the mappings in a given Map to this Bindings.

  to-merge - The Map to merge with this one. - `java.lang.Object>`

  throws: java.lang.NullPointerException - if toMerge map is null or if some key in the map is null."
  ([this to-merge]
    (-> this (.putAll to-merge))))

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

