(ns jdk.util.concurrent.ConcurrentHashMap$KeySetView
  "A view of a ConcurrentHashMap as a Set of keys, in
  which additions may optionally be enabled by mapping to a
  common value.  This class cannot be directly instantiated.
  See keySet(),
  keySet(V),
  newKeySet(),
  newKeySet(int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ConcurrentHashMap$KeySetView]))

(defn add-all
  "Adds all of the elements in the specified collection to this set,
   as if by calling add(K) on each one.

  c - the elements to be inserted into this set - `ConcurrentHashMap.KeySetView.K>`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.NullPointerException - if the collection or any of its elements are null"
  ([this c]
    (-> this (.addAll c))))

(defn spliterator
  "Description copied from interface: Set

  returns: a Spliterator over the elements in this set - `java.util.Spliterator<ConcurrentHashMap.KeySetView.K>`"
  ([this]
    (-> this (.spliterator))))

(defn for-each
  "Description copied from interface: Iterable

  action - The action to be performed for each element - `ConcurrentHashMap.KeySetView.K>`"
  ([this action]
    (-> this (.forEach action))))

(defn get-map
  "Returns the map backing this view.

  returns: the map backing this view - `java.util.concurrent.ConcurrentHashMap<K,V>`"
  ([this]
    (-> this (.getMap))))

(defn contains
  "Returns true if this collection contains the specified element.
   More formally, returns true if and only if this collection
   contains at least one element e such that
   (o==null ? e==null : o.equals(e)).

  o - element whose presence in this collection is to be tested - `java.lang.Object`

  returns: true if this collection contains the specified
           element - `boolean`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([this o]
    (-> this (.contains o))))

(defn to-string
  "Returns a string representation of this collection.
   The string representation consists of the string representations
   of the collection's elements in the order they are returned by
   its iterator, enclosed in square brackets (`[]`).
   Adjacent elements are separated by the characters `, `
   (comma and space).  Elements are converted to strings as by
   String.valueOf(Object).

  returns: a string representation of this collection - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn iterator
  "Returns an iterator over the elements in this collection.

   The returned iterator is
   weakly consistent.

  returns: an iterator over the keys of the backing map - `java.util.Iterator<ConcurrentHashMap.KeySetView.K>`"
  ([this]
    (-> this (.iterator))))

(defn remove
  "Removes the key from this map view, by removing the key (and its
   corresponding value) from the backing map.  This method does
   nothing if the key is not in the map.

  o - the key to be removed from the backing map - `java.lang.Object`

  returns: true if the backing map contained the specified key - `boolean`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([this o]
    (-> this (.remove o))))

(defn get-mapped-value
  "Returns the default mapped value for additions,
   or null if additions are not supported.

  returns: the default mapped value for additions, or null
   if not supported - `ConcurrentHashMap.KeySetView.V`"
  ([this]
    (-> this (.getMappedValue))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn add
  "Adds the specified key to this set view by mapping the key to
   the default mapped value in the backing map, if defined.

  e - key to be added - `ConcurrentHashMap.KeySetView.K`

  returns: true if this set changed as a result of the call - `boolean`

  throws: java.lang.NullPointerException - if the specified key is null"
  ([this e]
    (-> this (.add e))))

(defn empty?
  "Description copied from interface: Collection

  returns: true if this collection contains no elements - `boolean`"
  ([this]
    (-> this (.isEmpty))))

(defn size
  "Description copied from interface: Collection

  returns: the number of elements in this collection - `int`"
  ([this]
    (-> this (.size))))

(defn retain-all
  "Description copied from interface: Collection

  c - collection containing elements to be retained in this collection - `java.util.Collection<?>`

  returns: true if this collection changed as a result of the call - `boolean`"
  ([this c]
    (-> this (.retainAll c))))

(defn clear
  "Removes all of the elements from this view, by removing all
   the mappings from the map backing this view."
  ([this]
    (-> this (.clear))))

(defn to-array
  "Description copied from interface: Collection

  a - the array into which the elements of this collection are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. - `T[]`

  returns: an array containing all of the elements in this collection - `<T> T[]`"
  ([this a]
    (-> this (.toArray a)))
  ([this]
    (-> this (.toArray))))

(defn remove-all
  "Description copied from interface: Collection

  c - collection containing elements to be removed from this collection - `java.util.Collection<?>`

  returns: true if this collection changed as a result of the
           call - `boolean`"
  ([this c]
    (-> this (.removeAll c))))

(defn equals
  "Description copied from class: Object

  o - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([this o]
    (-> this (.equals o))))

(defn contains-all
  "Description copied from interface: Collection

  c - collection to be checked for containment in this collection - `java.util.Collection<?>`

  returns: true if this collection contains all of the elements
           in the specified collection - `boolean`"
  ([this c]
    (-> this (.containsAll c))))

