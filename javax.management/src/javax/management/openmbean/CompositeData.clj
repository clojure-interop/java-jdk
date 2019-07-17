(ns javax.management.openmbean.CompositeData
  "The CompositeData interface specifies the behavior of a specific type of complex open data objects
  which represent composite data structures."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean CompositeData]))

(defn values
  "Returns an unmodifiable Collection view of the item values contained in this CompositeData instance.
   The returned collection's iterator will return the values in the ascending lexicographic order of the corresponding
   item names.

  returns: the values. - `java.util.Collection<?>`"
  ([this]
    (-> this (.values))))

(defn get-all
  "Returns an array of the values of the items whose names are specified by keys, in the same order as keys.

  keys - the names of the items. - `java.lang.String[]`

  returns: the values corresponding to the keys. - `java.lang.Object[]`

  throws: java.lang.IllegalArgumentException - if an element in keys is a null or empty String."
  ([this keys]
    (-> this (.getAll keys))))

(defn to-string
  "Returns a string representation of this CompositeData instance.

   The string representation consists of the name of the implementing class,
   the string representation of the composite type of this instance, and the string representation of the contents
   (ie list the itemName=itemValue mappings).

  returns: a string representation of this CompositeData instance - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn contains-value
  "Returns true if and only if this CompositeData instance contains an item
   whose value is value.

  value - the value to be tested. - `java.lang.Object`

  returns: true if this CompositeData contains the value. - `boolean`"
  ([this value]
    (-> this (.containsValue value))))

(defn hash-code
  "Returns the hash code value for this CompositeData instance.

   The hash code of a CompositeData instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its composite type and all the item values).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two CompositeData instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

   Each item value's hash code is added to the returned hash code.
   If an item value is an array,
   its hash code is obtained as if by calling the
   deepHashCode method
   for arrays of object reference types or the appropriate overloading
   of Arrays.hashCode(e) for arrays of primitive types.

  returns: the hash code value for this CompositeData instance - `int`"
  ([this]
    (-> this (.hashCode))))

(defn contains-key
  "Returns true if and only if this CompositeData instance contains
   an item whose name is key.
   If key is a null or empty String, this method simply returns false.

  key - the key to be tested. - `java.lang.String`

  returns: true if this CompositeData contains the key. - `boolean`"
  ([this key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value of the item whose name is key.

  key - the name of the item. - `java.lang.String`

  returns: the value associated with this key. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if key is a null or empty String."
  ([this key]
    (-> this (.get key))))

(defn get-composite-type
  "Returns the composite type  of this composite data instance.

  returns: the type of this CompositeData. - `javax.management.openmbean.CompositeType`"
  ([this]
    (-> this (.getCompositeType))))

(defn equals
  "Compares the specified obj parameter with this
   CompositeData instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the CompositeData interface,
   their composite types are equal
   their contents, i.e. (name, value) pairs are equal. If a value contained in
   the content is an array, the value comparison is done as if by calling
   the deepEquals method
   for arrays of object reference types or the appropriate overloading of
   Arrays.equals(e1,e2) for arrays of primitive types


   This ensures that this equals method works properly for
   obj parameters which are different implementations of the
   CompositeData interface, with the restrictions mentioned in the
   equals
   method of the java.util.Collection interface.

  obj - the object to be compared for equality with this CompositeData instance. - `java.lang.Object`

  returns: true if the specified object is equal to this
   CompositeData instance. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

