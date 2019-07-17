(ns javax.management.openmbean.TabularDataSupport
  "The TabularDataSupport class is the open data class which implements the TabularData
  and the Map interfaces, and which is internally based on a hash map data structure."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean TabularDataSupport]))

(defn ->tabular-data-support
  "Constructor.

  Creates an empty TabularDataSupport instance whose open-type is tabularType,
   and whose underlying HashMap has the specified initial capacity and load factor.

  tabular-type - the tabular type describing this TabularData instance; cannot be null. - `javax.management.openmbean.TabularType`
  initial-capacity - the initial capacity of the HashMap. - `int`
  load-factor - the load factor of the HashMap - `float`

  throws: java.lang.IllegalArgumentException - if the initial capacity is less than zero, or the load factor is nonpositive, or the tabular type is null."
  ([^javax.management.openmbean.TabularType tabular-type ^Integer initial-capacity ^Float load-factor]
    (new TabularDataSupport tabular-type initial-capacity load-factor))
  ([^javax.management.openmbean.TabularType tabular-type]
    (new TabularDataSupport tabular-type)))

(defn values
  "Returns a collection view of the rows contained in this
   TabularDataSupport instance. The returned Collection
   is a Collection<CompositeData> but is declared as a
   Collection<Object> for compatibility reasons.
   The returned collection can be used to iterate over the values.
   The collection is backed by the underlying map, so changes to the
   TabularDataSupport instance are reflected in the collection,
   and vice-versa.

   The collection supports element removal, which removes the corresponding
   index to row mapping from this TabularDataSupport instance, via
   the Iterator.remove(), Collection.remove(java.lang.Object),
   Collection.removeAll(java.util.Collection<?>), Collection.retainAll(java.util.Collection<?>),
   and Collection.clear() operations. It does not support
   the Collection.add(E) or Collection.addAll(java.util.Collection<? extends E>) operations.

  returns: a collection view (Collection<CompositeData>) of
   the values contained in this TabularDataSupport instance. - `java.util.Collection<java.lang.Object>`"
  (^java.util.Collection [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.values))))

(defn put-all
  "Add all the values contained in the specified map t
   to this TabularData instance.  This method converts
   the collection of values contained in this map into an array of
   CompositeData values, if possible, and then call the
   method putAll(CompositeData[]). Note that the keys
   used in the specified map t are ignored. This method
   allows, for example to add the content of another
   TabularData instance with the same row type (but
   possibly different index names) into this instance.

  t - the map whose values are to be added as new rows to this TabularData instance; if t is null or empty, this method returns without doing anything. - `java.util.Map<?,?>`

  throws: java.lang.NullPointerException - if a value in t is null."
  ([^javax.management.openmbean.TabularDataSupport this ^java.util.Map t]
    (-> this (.putAll t))))

(defn get-tabular-type
  "Returns the tabular type describing this TabularData instance.

  returns: the tabular type. - `javax.management.openmbean.TabularType`"
  (^javax.management.openmbean.TabularType [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.getTabularType))))

(defn put
  "This method simply calls put((CompositeData) value) and
   therefore ignores its key parameter which can be null.

  key - an ignored parameter. - `java.lang.Object`
  value - the CompositeData to put. - `java.lang.Object`

  returns: the value which is put - `java.lang.Object`

  throws: java.lang.NullPointerException - if the value is null"
  (^java.lang.Object [^javax.management.openmbean.TabularDataSupport this ^java.lang.Object key ^java.lang.Object value]
    (-> this (.put key value)))
  ([^javax.management.openmbean.TabularDataSupport this ^javax.management.openmbean.CompositeData value]
    (-> this (.put value))))

(defn entry-set
  "Returns a collection view of the index to row mappings
   contained in this TabularDataSupport instance.
   Each element in the returned collection is
   a Map.Entry<List<?>,CompositeData> but
   is declared as a Map.Entry<Object,Object>
   for compatibility reasons. Each of the map entry
   keys is an unmodifiable List<?>.
   The collection is backed by the underlying map of this
   TabularDataSupport instance, so changes to the
   TabularDataSupport instance are reflected in
   the collection, and vice-versa.
   The collection supports element removal, which removes
   the corresponding mapping from the map, via the
   Iterator.remove(), Collection.remove(java.lang.Object),
   Collection.removeAll(java.util.Collection<?>), Collection.retainAll(java.util.Collection<?>),
   and Collection.clear() operations. It does not support
   the Collection.add(E) or Collection.addAll(java.util.Collection<? extends E>)
   operations.

   IMPORTANT NOTICE: Do not use the setValue method of the
   Map.Entry elements contained in the returned collection view.
   Doing so would corrupt the index to row mappings contained in this
   TabularDataSupport instance.

  returns: a collection view (Set<Map.Entry<List<?>,CompositeData>>)
   of the mappings contained in this map. - `java.util.Set<java.util.Map.Entry<java.lang.Object,java.lang.Object>>`"
  (^java.util.Set> [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.entrySet))))

(defn to-string
  "Returns a string representation of this TabularDataSupport instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.TabularDataSupport),
   the string representation of the tabular type of this instance, and the string representation of the contents
   (ie list the key=value mappings as returned by a call to
   dataMap.toString()).

  returns: a string representation of this TabularDataSupport instance - `java.lang.String`"
  (^java.lang.String [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.toString))))

(defn contains-value
  "Returns true if and only if this TabularData instance contains the specified
   CompositeData value. If value is null or does not conform to
   this TabularData instance's row type definition, this method simply returns false.

  value - the row value whose presence in this TabularData instance is to be tested. - `javax.management.openmbean.CompositeData`

  returns: true if this TabularData instance contains the specified row value. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularDataSupport this ^javax.management.openmbean.CompositeData value]
    (-> this (.containsValue value))))

(defn remove
  "This method simply calls remove((Object[]) key).

  key - an Object[] representing the key to remove. - `java.lang.Object`

  returns: previous value associated with specified key, or null
           if there was no mapping for key. - `java.lang.Object`

  throws: java.lang.NullPointerException - if the key is null"
  (^java.lang.Object [^javax.management.openmbean.TabularDataSupport this ^java.lang.Object key]
    (-> this (.remove key))))

(defn key-set
  "Returns a set view of the keys contained in the underlying map of this
   TabularDataSupport instance used to index the rows.
   Each key contained in this Set is an unmodifiable List<?>
   so the returned set view is a Set<List<?>> but is declared as a
   Set<Object> for compatibility reasons.
   The set is backed by the underlying map of this
   TabularDataSupport instance, so changes to the
   TabularDataSupport instance are reflected in the
   set, and vice-versa.

   The set supports element removal, which removes the corresponding
   row from this TabularDataSupport instance, via the
   Iterator.remove(), Set.remove(java.lang.Object), Set.removeAll(java.util.Collection<?>),
   Set.retainAll(java.util.Collection<?>), and Set.clear() operations. It does
    not support the Set.add(E) or Set.addAll(java.util.Collection<? extends E>) operations.

  returns: a set view (Set<List<?>>) of the keys used to index
   the rows of this TabularDataSupport instance. - `java.util.Set<java.lang.Object>`"
  (^java.util.Set [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.keySet))))

(defn clone
  "Returns a clone of this TabularDataSupport instance:
   the clone is obtained by calling super.clone(), and then cloning the underlying map.
   Only a shallow clone of the underlying map is made, i.e. no cloning of the indexes and row values is made as they are immutable.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this TabularDataSupport instance.

   The hash code of a TabularDataSupport instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: its tabular type and its content, where the content is defined as all the CompositeData values).

   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two TabularDataSupport instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

   However, note that another instance of a class implementing the TabularData interface
   may be equal to this TabularDataSupport instance as defined by equals(java.lang.Object),
   but may have a different hash code if it is calculated differently.

  returns: the hash code value for this TabularDataSupport instance - `int`"
  (^Integer [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.hashCode))))

(defn empty?
  "Returns true if this TabularDataSupport instance contains no rows.

  returns: true if this TabularDataSupport instance contains no rows. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of rows in this TabularDataSupport instance.

  returns: the number of rows in this TabularDataSupport instance. - `int`"
  (^Integer [^javax.management.openmbean.TabularDataSupport this]
    (-> this (.size))))

(defn clear
  "Removes all rows from this TabularDataSupport instance."
  ([^javax.management.openmbean.TabularDataSupport this]
    (-> this (.clear))))

(defn calculate-index
  "Calculates the index that would be used in this TabularData instance to refer to the specified
   composite data value parameter if it were added to this instance.
   This method checks for the type validity of the specified value,
   but does not check if the calculated index is already used to refer to a value in this TabularData instance.

  value - the composite data value whose index in this TabularData instance is to be calculated; must be of the same composite type as this instance's row type; must not be null. - `javax.management.openmbean.CompositeData`

  returns: the index that the specified value would have in this TabularData instance. - `java.lang.Object[]`

  throws: java.lang.NullPointerException - if value is null."
  ([^javax.management.openmbean.TabularDataSupport this ^javax.management.openmbean.CompositeData value]
    (-> this (.calculateIndex value))))

(defn contains-key
  "Returns true if and only if this TabularData instance contains a CompositeData value
   (ie a row) whose index is the specified key. If key cannot be cast to a one dimension array
   of Object instances, this method simply returns false; otherwise it returns the the result of the call to
   this.containsKey((Object[]) key).

  key - the index value whose presence in this TabularData instance is to be tested. - `java.lang.Object`

  returns: true if this TabularData indexes a row value with the specified key. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularDataSupport this ^java.lang.Object key]
    (-> this (.containsKey key))))

(defn get
  "This method simply calls get((Object[]) key).

  key - the key whose associated value is to be returned - `java.lang.Object`

  returns: the value to which the specified key is mapped, or
           null if this map contains no mapping for the key - `java.lang.Object`

  throws: java.lang.NullPointerException - if the key is null"
  (^java.lang.Object [^javax.management.openmbean.TabularDataSupport this ^java.lang.Object key]
    (-> this (.get key))))

(defn equals
  "Compares the specified obj parameter with this TabularDataSupport instance for equality.

   Returns true if and only if all of the following statements are true:

   obj is non null,
   obj also implements the TabularData interface,
   their tabular types are equal
   their contents (ie all CompositeData values) are equal.

   This ensures that this equals method works properly for obj parameters which are
   different implementations of the TabularData interface.

  obj - the object to be compared for equality with this TabularDataSupport instance; - `java.lang.Object`

  returns: true if the specified object is equal to this TabularDataSupport instance. - `boolean`"
  (^Boolean [^javax.management.openmbean.TabularDataSupport this ^java.lang.Object obj]
    (-> this (.equals obj))))

