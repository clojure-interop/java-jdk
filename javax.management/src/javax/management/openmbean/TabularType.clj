(ns javax.management.openmbean.TabularType
  "The TabularType class is the  open type class
  whose instances describe the types of TabularData values."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean TabularType]))

(defn ->tabular-type
  "Constructor.

  Constructs a TabularType instance, checking for the validity of the given parameters.
   The validity constraints are described below for each parameter.

   The Java class name of tabular data values this tabular type represents
   (ie the class name returned by the getClassName method)
   is set to the string value returned by TabularData.class.getName().

  type-name - The name given to the tabular type this instance represents; cannot be a null or empty string. - `java.lang.String`
  description - The human readable description of the tabular type this instance represents; cannot be a null or empty string. - `java.lang.String`
  row-type - The type of the row elements of tabular data values described by this tabular type instance; cannot be null. - `javax.management.openmbean.CompositeType`
  index-names - The names of the items the values of which are used to uniquely index each row element in the tabular data values described by this tabular type instance; cannot be null or empty. Each element should be an item name defined in rowType (no null or empty string allowed). It is important to note that the order of the item names in indexNames is used by the methods get and remove of class TabularData to match their array of values parameter to items. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - if rowType is null, or indexNames is a null or empty array, or an element in indexNames is a null or empty string, or typeName or description is a null or empty string."
  ([^java.lang.String type-name ^java.lang.String description ^javax.management.openmbean.CompositeType row-type ^java.lang.String[] index-names]
    (new TabularType type-name description row-type index-names)))

(defn get-row-type
  "Returns the type of the row elements of tabular data values
   described by this TabularType instance.

  returns: the type of each row. - `javax.management.openmbean.CompositeType`"
  ([^javax.management.openmbean.TabularType this]
    (-> this (.getRowType))))

(defn get-index-names
  "Returns, in the same order as was given to this instance's
   constructor, an unmodifiable List of the names of the items the
   values of which are used to uniquely index each row element of
   tabular data values described by this TabularType
   instance.

  returns: a List of String representing the names of the index
   items. - `java.util.List<java.lang.String>`"
  ([^javax.management.openmbean.TabularType this]
    (-> this (.getIndexNames))))

(defn value?
  "Tests whether obj is a value which could be
   described by this TabularType instance.

   If obj is null or is not an instance of
   javax.management.openmbean.TabularData,
   isValue returns false.

   If obj is an instance of
   javax.management.openmbean.TabularData, say td, the result is true if this TabularType is
   assignable from td.getTabularType(), as defined in CompositeType.isValue.

  obj - the value whose open type is to be tested for compatibility with this TabularType instance. - `java.lang.Object`

  returns: true if obj is a value for this
   tabular type, false otherwise. - `boolean`"
  ([^javax.management.openmbean.TabularType this ^java.lang.Object obj]
    (-> this (.isValue obj))))

(defn equals
  "Compares the specified obj parameter with this TabularType instance for equality.

   Two TabularType instances are equal if and only if all of the following statements are true:

   their type names are equal
   their row types are equal
   they use the same index names, in the same order

  obj - the object to be compared for equality with this TabularType instance; if obj is null, equals returns false. - `java.lang.Object`

  returns: true if the specified object is equal to this TabularType instance. - `boolean`"
  ([^javax.management.openmbean.TabularType this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this TabularType instance.

   The hash code of a TabularType instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: name, row type, index names).
   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two TabularType instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

   As TabularType instances are immutable, the hash code for this instance is calculated once,
   on the first call to hashCode, and then the same value is returned for subsequent calls.

  returns: the hash code value for this TabularType instance - `int`"
  ([^javax.management.openmbean.TabularType this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this TabularType instance.

   The string representation consists of the name of this class (ie javax.management.openmbean.TabularType),
   the type name for this instance, the row type string representation of this instance,
   and the index names of this instance.

   As TabularType instances are immutable, the string representation for this instance is calculated once,
   on the first call to toString, and then the same value is returned for subsequent calls.

  returns: a string representation of this TabularType instance - `java.lang.String`"
  ([^javax.management.openmbean.TabularType this]
    (-> this (.toString))))

