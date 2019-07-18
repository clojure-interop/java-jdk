(ns javax.management.openmbean.CompositeType
  "The CompositeType class is the open type class
  whose instances describe the types of CompositeData values."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean CompositeType]))

(defn ->composite-type
  "Constructor.

  Constructs a CompositeType instance, checking for the validity of the given parameters.
   The validity constraints are described below for each parameter.

   Note that the contents of the three array parameters
   itemNames, itemDescriptions and itemTypes
   are internally copied so that any subsequent modification of these arrays by the caller of this constructor
   has no impact on the constructed CompositeType instance.

   The Java class name of composite data values this composite type represents
   (ie the class name returned by the getClassName method)
   is set to the string value returned by CompositeData.class.getName().

  type-name - The name given to the composite type this instance represents; cannot be a null or empty string. - `java.lang.String`
  description - The human readable description of the composite type this instance represents; cannot be a null or empty string. - `java.lang.String`
  item-names - The names of the items contained in the composite data values described by this CompositeType instance; cannot be null and should contain at least one element; no element can be a null or empty string. Note that the order in which the item names are given is not important to differentiate a CompositeType instance from another; the item names are internally stored sorted in ascending alphanumeric order. - `java.lang.String[]`
  item-descriptions - The descriptions, in the same order as itemNames, of the items contained in the composite data values described by this CompositeType instance; should be of the same size as itemNames; no element can be null or an empty string. - `java.lang.String[]`
  item-types - The open type instances, in the same order as itemNames, describing the items contained in the composite data values described by this CompositeType instance; should be of the same size as itemNames; no element can be null. - `javax.management.openmbean.OpenType[]`

  throws: java.lang.IllegalArgumentException - If typeName or description is a null or empty string, or itemNames or itemDescriptions or itemTypes is null, or any element of itemNames or itemDescriptions is a null or empty string, or any element of itemTypes is null, or itemNames or itemDescriptions or itemTypes are not of the same size."
  (^CompositeType [^java.lang.String type-name ^java.lang.String description item-names item-descriptions item-types]
    (new CompositeType type-name description item-names item-descriptions item-types)))

(defn contains-key
  "Returns true if this CompositeType instance defines an item
   whose name is itemName.

  item-name - the name of the item. - `java.lang.String`

  returns: true if an item of this name is present. - `boolean`"
  (^Boolean [^CompositeType this ^java.lang.String item-name]
    (-> this (.containsKey item-name))))

(defn get-description
  "Returns the description of the item whose name is itemName,
   or null if this CompositeType instance does not define any item
   whose name is itemName.

  item-name - the name of the item. - `java.lang.String`

  returns: the description. - `java.lang.String`"
  (^java.lang.String [^CompositeType this ^java.lang.String item-name]
    (-> this (.getDescription item-name))))

(defn get-type
  "Returns the open type of the item whose name is itemName,
   or null if this CompositeType instance does not define any item
   whose name is itemName.

  item-name - the name of the time. - `java.lang.String`

  returns: the type. - `javax.management.openmbean.OpenType<?>`"
  (^javax.management.openmbean.OpenType [^CompositeType this ^java.lang.String item-name]
    (-> this (.getType item-name))))

(defn key-set
  "Returns an unmodifiable Set view of all the item names defined by this CompositeType instance.
   The set's iterator will return the item names in ascending order.

  returns: a Set of String. - `java.util.Set<java.lang.String>`"
  (^java.util.Set [^CompositeType this]
    (-> this (.keySet))))

(defn value?
  "Tests whether obj is a value which could be
   described by this CompositeType instance.

   If obj is null or is not an instance of
   javax.management.openmbean.CompositeData,
   isValue returns false.

   If obj is an instance of
   javax.management.openmbean.CompositeData, then let
   ct be its CompositeType as returned by CompositeData.getCompositeType().  The result is true if
   this is assignable from ct.  This
   means that:


   this.getTypeName() equals
   ct.getTypeName(), and
   there are no item names present in this that are
   not also present in ct, and
   for every item in this, its type is assignable from
   the type of the corresponding item in ct.


   A TabularType is assignable from another TabularType if they have the same typeName and index name list, and the
   row type of the first is
   assignable from the row type of the second.

   An ArrayType is assignable from another ArrayType if they have the same dimension; and both are primitive arrays or neither is;
   and the element
   type of the first is assignable from the element type of the
   second.

   In every other case, an OpenType is assignable from
   another OpenType only if they are equal.

   These rules mean that extra items can be added to a CompositeData without making it invalid for a CompositeType
   that does not have those items.

  obj - the value whose open type is to be tested for compatibility with this CompositeType instance. - `java.lang.Object`

  returns: true if obj is a value for this
   composite type, false otherwise. - `boolean`"
  (^Boolean [^CompositeType this ^java.lang.Object obj]
    (-> this (.isValue obj))))

(defn equals
  "Compares the specified obj parameter with this CompositeType instance for equality.

   Two CompositeType instances are equal if and only if all of the following statements are true:

   their type names are equal
   their items' names and types are equal

  obj - the object to be compared for equality with this CompositeType instance; if obj is null, equals returns false. - `java.lang.Object`

  returns: true if the specified object is equal to this CompositeType instance. - `boolean`"
  (^Boolean [^CompositeType this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this CompositeType instance.

   The hash code of a CompositeType instance is the sum of the hash codes
   of all elements of information used in equals comparisons
   (ie: name, items names, items types).
   This ensures that  t1.equals(t2)  implies that  t1.hashCode()==t2.hashCode()
   for any two CompositeType instances t1 and t2,
   as required by the general contract of the method
   Object.hashCode().

   As CompositeType instances are immutable, the hash code for this instance is calculated once,
   on the first call to hashCode, and then the same value is returned for subsequent calls.

  returns: the hash code value for this CompositeType instance - `int`"
  (^Integer [^CompositeType this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a string representation of this CompositeType instance.

   The string representation consists of
   the name of this class (ie javax.management.openmbean.CompositeType), the type name for this instance,
   and the list of the items names and types string representation of this instance.

   As CompositeType instances are immutable, the string representation for this instance is calculated once,
   on the first call to toString, and then the same value is returned for subsequent calls.

  returns: a string representation of this CompositeType instance - `java.lang.String`"
  (^java.lang.String [^CompositeType this]
    (-> this (.toString))))

