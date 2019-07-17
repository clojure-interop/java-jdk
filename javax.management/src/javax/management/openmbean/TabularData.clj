(ns javax.management.openmbean.TabularData
  "The TabularData interface specifies the behavior of a specific type of complex open data objects
  which represent tabular data structures."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean TabularData]))

(defn values
  "Returns a collection view of the CompositeData values
   (ie the rows) contained in this TabularData instance.
   The returned Collection is a Collection<CompositeData>
   but is declared as a Collection<?> for compatibility reasons.
   The returned collection can be used to iterate over the values.

  returns: a collection view (Collection<CompositeData>)
   of the rows contained in this TabularData instance. - `java.util.Collection<?>`"
  (^java.util.Collection [^javax.management.openmbean.TabularData this]
    (-> this (.values))))

(defn put-all
  "Add all the elements in values to this TabularData instance.
   If any  element in values does not satisfy the constraints defined in put,
   or if any two elements in values have the same index calculated according to this TabularData
   instance's TabularType definition, then an exception describing the failure is thrown
   and no element of values is added,  thus leaving this TabularData instance unchanged.

  values - the array of composite data values to be added as new rows to this TabularData instance; if values is null or empty, this method returns without doing anything. - `javax.management.openmbean.CompositeData[]`

  throws: java.lang.NullPointerException - if an element of values is null"
  ([^javax.management.openmbean.TabularData this values]
    (-> this (.putAll values))))

(defn get-tabular-type
  "Returns the tabular type describing this
   TabularData instance.

  returns: the tabular type. - `javax.management.openmbean.TabularType`"
  (^javax.management.openmbean.TabularType [^javax.management.openmbean.TabularData this]
    (-> this (.getTabularType))))

(defn put
  "Adds value to this TabularData instance.
   The composite type of value must be the same as this
   instance's row type (ie the composite type returned by
   this.getTabularType().getRowType()), and there must not already be an existing
   value in this TabularData instance whose index is the
   same as the one calculated for the value to be
   added. The index for value is calculated according
   to this TabularData instance's TabularType
   definition (see TabularType.getIndexNames()).

  value - the composite data value to be added as a new row to this TabularData instance; must be of the same composite type as this instance's row type; must not be null. - `javax.management.openmbean.CompositeData`

  throws: java.lang.NullPointerException - if value is null"
  ([^javax.management.openmbean.TabularData this ^javax.management.openmbean.CompositeData value]
    (-> this (.put value))))

(defn to-string
  "Returns a string representation of this TabularData instance.

   The string representation consists of the name of the implementing class,
   and the tabular type of this instance.

  returns: a string representation of this TabularData instance - `java.lang.String`"
  (^java.lang.String [^javax.management.openmbean.TabularData this]
    (-> this (.toString))))

(defn contains-value
  "Returns true if and only if this TabularData instance contains the specified
   CompositeData value. If value is null or does not conform to
   this TabularData instance's row type definition, this method simply returns false.

  value - the row value whose presence in this TabularData instance is to be tested. - `javax.management.openmbean.CompositeData`

  returns: true if this TabularData instance contains the specified row value. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularData this ^javax.management.openmbean.CompositeData value]
    (-> this (.containsValue value))))

(defn remove
  "Removes the CompositeData value whose index is key from this TabularData instance,
   and returns the removed value, or returns null if there is no value whose index is key.

  key - the index of the value to get in this TabularData instance; must be valid with this TabularData instance's row type definition; must not be null. - `java.lang.Object[]`

  returns: previous value associated with specified key, or null
           if there was no mapping for key. - `javax.management.openmbean.CompositeData`

  throws: java.lang.NullPointerException - if the key is null"
  (^javax.management.openmbean.CompositeData [^javax.management.openmbean.TabularData this key]
    (-> this (.remove key))))

(defn key-set
  "Returns a set view of the keys (ie the index values) of the
   CompositeData values (ie the rows) contained in this
   TabularData instance. The returned Set is a
   Set<List<?>> but is declared as a Set<?> for
   compatibility reasons. The returned set can be used to iterate
   over the keys.

  returns: a set view (Set<List<?>>) of the index values
   used in this TabularData instance. - `java.util.Set<?>`"
  (^java.util.Set [^javax.management.openmbean.TabularData this]
    (-> this (.keySet))))

(defn hash-code
  "Returns the hash code value for this TabularData instance.

   The hash code of a TabularData instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its tabular type and its content, where the content is defined as all the index to value mappings).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two TabularDataSupport instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

  returns: the hash code value for this TabularDataSupport instance - `int`"
  (^Integer [^javax.management.openmbean.TabularData this]
    (-> this (.hashCode))))

(defn empty?
  "Returns true if the number of CompositeData
   values (ie the number of rows) contained in this
   TabularData instance is zero.

  returns: true if this TabularData is empty. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularData this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of CompositeData values (ie the
   number of rows) contained in this TabularData
   instance.

  returns: the number of values contained. - `int`"
  (^Integer [^javax.management.openmbean.TabularData this]
    (-> this (.size))))

(defn clear
  "Removes all CompositeData values (ie rows) from this TabularData instance."
  ([^javax.management.openmbean.TabularData this]
    (-> this (.clear))))

(defn calculate-index
  "Calculates the index that would be used in this TabularData instance to refer to the specified
   composite data value parameter if it were added to this instance.
   This method checks for the type validity of the specified value,
   but does not check if the calculated index is already used to refer to a value in this TabularData instance.

  value - the composite data value whose index in this TabularData instance is to be calculated; must be of the same composite type as this instance's row type; must not be null. - `javax.management.openmbean.CompositeData`

  returns: the index that the specified value would have in this TabularData instance. - `java.lang.Object[]`

  throws: java.lang.NullPointerException - if value is null"
  ([^javax.management.openmbean.TabularData this ^javax.management.openmbean.CompositeData value]
    (-> this (.calculateIndex value))))

(defn contains-key
  "Returns true if and only if this TabularData instance contains a CompositeData value
   (ie a row) whose index is the specified key. If key is null or does not conform to
   this TabularData instance's TabularType definition, this method simply returns false.

  key - the index value whose presence in this TabularData instance is to be tested. - `java.lang.Object[]`

  returns: true if this TabularData indexes a row value with the specified key. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularData this key]
    (-> this (.containsKey key))))

(defn get
  "Returns the CompositeData value whose index is
   key, or null if there is no value mapping
   to key, in this TabularData instance.

  key - the key of the row to return. - `java.lang.Object[]`

  returns: the value corresponding to key. - `javax.management.openmbean.CompositeData`

  throws: java.lang.NullPointerException - if the key is null"
  (^javax.management.openmbean.CompositeData [^javax.management.openmbean.TabularData this key]
    (-> this (.get key))))

(defn equals
  "Compares the specified obj parameter with this TabularData instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the TabularData interface,
   their row types are equal
   their contents (ie index to value mappings) are equal

   This ensures that this equals method works properly for obj parameters which are
   different implementations of the TabularData interface.

  obj - the object to be compared for equality with this TabularData instance; - `java.lang.Object`

  returns: true if the specified object is equal to this TabularData instance. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularData this ^java.lang.Object obj]
    (-> this (.equals obj))))

