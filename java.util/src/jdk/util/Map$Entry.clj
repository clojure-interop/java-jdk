(ns jdk.util.Map$Entry
  "A map entry (key-value pair).  The Map.entrySet method returns
  a collection-view of the map, whose elements are of this class.  The
  only way to obtain a reference to a map entry is from the
  iterator of this collection-view.  These Map.Entry objects are
  valid only for the duration of the iteration; more formally,
  the behavior of a map entry is undefined if the backing map has been
  modified after the entry was returned by the iterator, except through
  the setValue operation on the map entry."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Map$Entry]))

(defn get-key
  "Returns the key corresponding to this entry.

  returns: the key corresponding to this entry - `K`

  throws: java.lang.IllegalStateException - implementations may, but are not required to, throw this exception if the entry has been removed from the backing map."
  ([^Map$Entry this]
    (-> this (.getKey))))

(defn get-value
  "Returns the value corresponding to this entry.  If the mapping
   has been removed from the backing map (by the iterator's
   remove operation), the results of this call are undefined.

  returns: the value corresponding to this entry - `V`

  throws: java.lang.IllegalStateException - implementations may, but are not required to, throw this exception if the entry has been removed from the backing map."
  ([^Map$Entry this]
    (-> this (.getValue))))

(defn set-value
  "Replaces the value corresponding to this entry with the specified
   value (optional operation).  (Writes through to the map.)  The
   behavior of this call is undefined if the mapping has already been
   removed from the map (by the iterator's remove operation).

  value - new value to be stored in this entry - `V`

  returns: old value corresponding to the entry - `V`

  throws: java.lang.UnsupportedOperationException - if the put operation is not supported by the backing map"
  ([^Map$Entry this value]
    (-> this (.setValue value))))

(defn equals
  "Compares the specified object with this entry for equality.
   Returns true if the given object is also a map entry and
   the two entries represent the same mapping.  More formally, two
   entries e1 and e2 represent the same mapping
   if

       (e1.getKey()==null ?
        e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &&
       (e1.getValue()==null ?
        e2.getValue()==null : e1.getValue().equals(e2.getValue()))
   This ensures that the equals method works properly across
   different implementations of the Map.Entry interface.

  o - object to be compared for equality with this map entry - `java.lang.Object`

  returns: true if the specified object is equal to this map
           entry - `boolean`"
  (^Boolean [^Map$Entry this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Returns the hash code value for this map entry.  The hash code
   of a map entry e is defined to be:

       (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
       (e.getValue()==null ? 0 : e.getValue().hashCode())
   This ensures that e1.equals(e2) implies that
   e1.hashCode()==e2.hashCode() for any two Entries
   e1 and e2, as required by the general
   contract of Object.hashCode.

  returns: the hash code value for this map entry - `int`"
  (^Integer [^Map$Entry this]
    (-> this (.hashCode))))

(defn *comparing-by-key
  "Returns a comparator that compares Map.Entry by key using the given
   Comparator.

   The returned comparator is serializable if the specified comparator
   is also serializable.

  cmp - the key Comparator - `java.util.Comparator`

  returns: a comparator that compares Map.Entry by the key. - `<K,V> java.util.Comparator<java.util.Map$Entry<K,V>>`"
  ([^java.util.Comparator cmp]
    (Map$Entry/comparingByKey cmp))
  ([]
    (Map$Entry/comparingByKey )))

(defn *comparing-by-value
  "Returns a comparator that compares Map.Entry by value using the given
   Comparator.

   The returned comparator is serializable if the specified comparator
   is also serializable.

  cmp - the value Comparator - `java.util.Comparator`

  returns: a comparator that compares Map.Entry by the value. - `<K,V> java.util.Comparator<java.util.Map$Entry<K,V>>`"
  ([^java.util.Comparator cmp]
    (Map$Entry/comparingByValue cmp))
  ([]
    (Map$Entry/comparingByValue )))

