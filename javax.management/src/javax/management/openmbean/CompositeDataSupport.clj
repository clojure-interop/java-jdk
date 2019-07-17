(ns javax.management.openmbean.CompositeDataSupport
  "The CompositeDataSupport class is the open data class which
  implements the CompositeData interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean CompositeDataSupport]))

(defn ->composite-data-support
  "Constructor.

  Constructs a CompositeDataSupport instance with the specified
   compositeType, whose item values
   are specified by itemValues[], in the same order as in
   itemNames[].
   As a CompositeType does not specify any order on its items,
   the itemNames[] parameter is used
   to specify the order in which the values are given in itemValues[].
   The items contained in this CompositeDataSupport instance are
   internally stored in a TreeMap,
   thus sorted in ascending lexicographic order of their names, for faster
   retrieval of individual item values.

   The constructor checks that all the constraints listed below for each
   parameter are satisfied,
   and throws the appropriate exception if they are not.

  composite-type - the composite type of this composite data instance; must not be null. - `javax.management.openmbean.CompositeType`
  item-names - itemNames must list, in any order, all the item names defined in compositeType; the order in which the names are listed, is used to match values in itemValues[]; must not be null or empty. - `java.lang.String[]`
  item-values - the values of the items, listed in the same order as their respective names in itemNames; each item value can be null, but if it is non-null it must be a valid value for the open type defined in compositeType for the corresponding item; must be of the same size as itemNames; must not be null or empty. - `java.lang.Object[]`

  throws: java.lang.IllegalArgumentException - compositeType is null, or itemNames[] or itemValues[] is null or empty, or one of the elements in itemNames[] is a null or empty string, or itemNames[] and itemValues[] are not of the same size."
  ([^javax.management.openmbean.CompositeType composite-type ^java.lang.String[] item-names ^java.lang.Object[] item-values]
    (new CompositeDataSupport composite-type item-names item-values))
  ([^javax.management.openmbean.CompositeType composite-type ^java.util.Map items]
    (new CompositeDataSupport composite-type items)))

(defn values
  "Returns an unmodifiable Collection view of the item values contained in this
   CompositeData instance.
   The returned collection's iterator will return the values in the ascending
   lexicographic order of the corresponding
   item names.

  returns: the values. - `java.util.Collection<?>`"
  ([^javax.management.openmbean.CompositeDataSupport this]
    (-> this (.values))))

(defn get-all
  "Returns an array of the values of the items whose names are specified by
   keys, in the same order as keys.

  keys - the names of the items. - `java.lang.String[]`

  returns: the values corresponding to the keys. - `java.lang.Object[]`

  throws: java.lang.IllegalArgumentException - if an element in keys is a null or empty String."
  ([^javax.management.openmbean.CompositeDataSupport this ^java.lang.String[] keys]
    (-> this (.getAll keys))))

(defn to-string
  "Returns a string representation of this CompositeDataSupport instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.CompositeDataSupport),
   the string representation of the composite type of this instance, and the string representation of the contents
   (ie list the itemName=itemValue mappings).

  returns: a string representation of this CompositeDataSupport instance - `java.lang.String`"
  ([^javax.management.openmbean.CompositeDataSupport this]
    (-> this (.toString))))

(defn contains-value
  "Returns true if and only if this CompositeData instance
   contains an item
   whose value is value.

  value - the value to be tested. - `java.lang.Object`

  returns: true if this CompositeData contains the value. - `boolean`"
  ([^javax.management.openmbean.CompositeDataSupport this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn hash-code
  "Returns the hash code value for this CompositeDataSupport instance.

   The hash code of a CompositeDataSupport instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its composite type and all the item values).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two CompositeDataSupport instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

   Each item value's hash code is added to the returned hash code.
   If an item value is an array,
   its hash code is obtained as if by calling the
   deepHashCode method
   for arrays of object reference types or the appropriate overloading
   of Arrays.hashCode(e) for arrays of primitive types.

  returns: the hash code value for this CompositeDataSupport instance - `int`"
  ([^javax.management.openmbean.CompositeDataSupport this]
    (-> this (.hashCode))))

(defn contains-key
  "Returns true if and only if this CompositeData instance contains
   an item whose name is key.
   If key is a null or empty String, this method simply returns false.

  key - the key to be tested. - `java.lang.String`

  returns: true if this CompositeData contains the key. - `boolean`"
  ([^javax.management.openmbean.CompositeDataSupport this ^java.lang.String key]
    (-> this (.containsKey key))))

(defn get
  "Returns the value of the item whose name is key.

  key - the name of the item. - `java.lang.String`

  returns: the value associated with this key. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if key is a null or empty String."
  ([^javax.management.openmbean.CompositeDataSupport this ^java.lang.String key]
    (-> this (.get key))))

(defn get-composite-type
  "Returns the composite type  of this composite data instance.

  returns: the type of this CompositeData. - `javax.management.openmbean.CompositeType`"
  ([^javax.management.openmbean.CompositeDataSupport this]
    (-> this (.getCompositeType))))

(defn equals
  "Compares the specified obj parameter with this
   CompositeDataSupport instance for equality.

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

  obj - the object to be compared for equality with this CompositeDataSupport instance. - `java.lang.Object`

  returns: true if the specified object is equal to this
   CompositeDataSupport instance. - `boolean`"
  ([^javax.management.openmbean.CompositeDataSupport this ^java.lang.Object obj]
    (-> this (.equals obj))))

