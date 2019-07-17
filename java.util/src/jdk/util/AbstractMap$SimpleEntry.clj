(ns jdk.util.AbstractMap$SimpleEntry
  "An Entry maintaining a key and a value.  The value may be
  changed using the setValue method.  This class
  facilitates the process of building custom map
  implementations. For example, it may be convenient to return
  arrays of SimpleEntry instances in method
  Map.entrySet().toArray."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util AbstractMap$SimpleEntry]))

(defn ->simple-entry
  "Constructor.

  Creates an entry representing a mapping from the specified
   key to the specified value.

  key - the key represented by this entry - `AbstractMap.SimpleEntry.K`
  value - the value represented by this entry - `AbstractMap.SimpleEntry.V`"
  ([^AbstractMap.SimpleEntry.K key ^AbstractMap.SimpleEntry.V value]
    (new AbstractMap$SimpleEntry key value))
  ([^AbstractMap.SimpleEntry.V> entry]
    (new AbstractMap$SimpleEntry entry)))

(defn get-key
  "Returns the key corresponding to this entry.

  returns: the key corresponding to this entry - `AbstractMap.SimpleEntry.K`"
  (^AbstractMap.SimpleEntry.K [^java.util.AbstractMap$SimpleEntry this]
    (-> this (.getKey))))

(defn get-value
  "Returns the value corresponding to this entry.

  returns: the value corresponding to this entry - `AbstractMap.SimpleEntry.V`"
  (^AbstractMap.SimpleEntry.V [^java.util.AbstractMap$SimpleEntry this]
    (-> this (.getValue))))

(defn set-value
  "Replaces the value corresponding to this entry with the specified
   value.

  value - new value to be stored in this entry - `AbstractMap.SimpleEntry.V`

  returns: the old value corresponding to the entry - `AbstractMap.SimpleEntry.V`"
  (^AbstractMap.SimpleEntry.V [^java.util.AbstractMap$SimpleEntry this ^AbstractMap.SimpleEntry.V value]
    (-> this (.setValue value))))

(defn equals
  "Compares the specified object with this entry for equality.
   Returns true if the given object is also a map entry and
   the two entries represent the same mapping.  More formally, two
   entries e1 and e2 represent the same mapping
   if

     (e1.getKey()==null ?
      e2.getKey()==null :
      e1.getKey().equals(e2.getKey()))
     &&
     (e1.getValue()==null ?
      e2.getValue()==null :
      e1.getValue().equals(e2.getValue()))
   This ensures that the equals method works properly across
   different implementations of the Map.Entry interface.

  o - object to be compared for equality with this map entry - `java.lang.Object`

  returns: true if the specified object is equal to this map
           entry - `boolean`"
  (^Boolean [^java.util.AbstractMap$SimpleEntry this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Returns the hash code value for this map entry.  The hash code
   of a map entry e is defined to be:

     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
     (e.getValue()==null ? 0 : e.getValue().hashCode())
   This ensures that e1.equals(e2) implies that
   e1.hashCode()==e2.hashCode() for any two Entries
   e1 and e2, as required by the general
   contract of Object.hashCode().

  returns: the hash code value for this map entry - `int`"
  (^Integer [^java.util.AbstractMap$SimpleEntry this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a String representation of this map entry.  This
   implementation returns the string representation of this
   entry's key followed by the equals character (`=`)
   followed by the string representation of this entry's value.

  returns: a String representation of this map entry - `java.lang.String`"
  (^java.lang.String [^java.util.AbstractMap$SimpleEntry this]
    (-> this (.toString))))

