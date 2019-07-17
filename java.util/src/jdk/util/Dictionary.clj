(ns jdk.util.Dictionary
  "The Dictionary class is the abstract parent of any
  class, such as Hashtable, which maps keys to values.
  Every key and every value is an object. In any one Dictionary
  object, every key is associated with at most one value. Given a
  Dictionary and a key, the associated element can be looked up.
  Any non-null object can be used as a key and as a value.

  As a rule, the equals method should be used by
  implementations of this class to decide if two keys are the same.

  NOTE: This class is obsolete.  New implementations should
  implement the Map interface, rather than extending this class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Dictionary]))

(defn ->dictionary
  "Constructor.

  Sole constructor.  (For invocation by subclass constructors, typically
   implicit.)"
  ([]
    (new Dictionary )))

(defn size
  "Returns the number of entries (distinct keys) in this dictionary.

  returns: the number of keys in this dictionary. - `int`"
  ([^java.util.Dictionary this]
    (-> this (.size))))

(defn empty?
  "Tests if this dictionary maps no keys to value. The general contract
   for the isEmpty method is that the result is true if and only
   if this dictionary contains no entries.

  returns: true if this dictionary maps no keys to values;
            false otherwise. - `boolean`"
  ([^java.util.Dictionary this]
    (-> this (.isEmpty))))

(defn keys
  "Returns an enumeration of the keys in this dictionary. The general
   contract for the keys method is that an Enumeration object
   is returned that will generate all the keys for which this dictionary
   contains entries.

  returns: an enumeration of the keys in this dictionary. - `java.util.Enumeration<Dictionary.K>`"
  ([^java.util.Dictionary this]
    (-> this (.keys))))

(defn elements
  "Returns an enumeration of the values in this dictionary. The general
   contract for the elements method is that an
   Enumeration is returned that will generate all the elements
   contained in entries in this dictionary.

  returns: an enumeration of the values in this dictionary. - `java.util.Enumeration<Dictionary.V>`"
  ([^java.util.Dictionary this]
    (-> this (.elements))))

(defn get
  "Returns the value to which the key is mapped in this dictionary.
   The general contract for the isEmpty method is that if this
   dictionary contains an entry for the specified key, the associated
   value is returned; otherwise, null is returned.

  key - a key in this dictionary. null if the key is not mapped to any value in this dictionary. - `java.lang.Object`

  returns: the value to which the key is mapped in this dictionary; - `Dictionary.V`

  throws: java.lang.NullPointerException - if the key is null."
  ([^java.util.Dictionary this ^java.lang.Object key]
    (-> this (.get key))))

(defn put
  "Maps the specified key to the specified
   value in this dictionary. Neither the key nor the
   value can be null.

   If this dictionary already contains an entry for the specified
   key, the value already in this dictionary for that
   key is returned, after modifying the entry to contain the
    new element. If this dictionary does not already have an entry
    for the specified key, an entry is created for the
    specified key and value, and null is
    returned.

   The value can be retrieved by calling the
   get method with a key that is equal to
   the original key.

  key - the hashtable key. - `Dictionary.K`
  value - the value. - `Dictionary.V`

  returns: the previous value to which the key was mapped
               in this dictionary, or null if the key did not
               have a previous mapping. - `Dictionary.V`

  throws: java.lang.NullPointerException - if the key or value is null."
  ([^java.util.Dictionary this ^Dictionary.K key ^Dictionary.V value]
    (-> this (.put key value))))

(defn remove
  "Removes the key (and its corresponding
   value) from this dictionary. This method does nothing
   if the key is not in this dictionary.

  key - the key that needs to be removed. - `java.lang.Object`

  returns: the value to which the key had been mapped in this
            dictionary, or null if the key did not have a
            mapping. - `Dictionary.V`

  throws: java.lang.NullPointerException - if key is null."
  ([^java.util.Dictionary this ^java.lang.Object key]
    (-> this (.remove key))))

