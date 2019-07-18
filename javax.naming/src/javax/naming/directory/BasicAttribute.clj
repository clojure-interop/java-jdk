(ns javax.naming.directory.BasicAttribute
  "This class provides a basic implementation of the Attribute interface.

  This implementation does not support the schema methods
  getAttributeDefinition() and getAttributeSyntaxDefinition().
  They simply throw OperationNotSupportedException.
  Subclasses of BasicAttribute should override these methods if they
  support them.

  The BasicAttribute class by default uses Object.equals() to
  determine equality of attribute values when testing for equality or
  when searching for values, except when the value is an array.
  For an array, each element of the array is checked using Object.equals().
  Subclasses of BasicAttribute can make use of schema information
  when doing similar equality checks by overriding methods
  in which such use of schema is meaningful.
  Similarly, the BasicAttribute class by default returns the values passed to its
  constructor and/or manipulated using the add/remove methods.
  Subclasses of BasicAttribute can override get() and getAll()
  to get the values dynamically from the directory (or implement
  the Attribute interface directly instead of subclassing BasicAttribute).

  Note that updates to BasicAttribute (such as adding or removing a value)
  does not affect the corresponding representation of the attribute
  in the directory.  Updates to the directory can only be effected
  using operations in the DirContext interface.

  A BasicAttribute instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify a
  BasicAttribute should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory BasicAttribute]))

(defn ->basic-attribute
  "Constructor.

  Constructs a new instance of a possibly ordered attribute with a
   single value.

  id - The attribute's id. It cannot be null. - `java.lang.String`
  value - The attribute's value. If null, a null value is added to the attribute. - `java.lang.Object`
  ordered - true means the attribute's values will be ordered; false otherwise. - `boolean`"
  (^BasicAttribute [^java.lang.String id ^java.lang.Object value ^Boolean ordered]
    (new BasicAttribute id value ordered))
  (^BasicAttribute [^java.lang.String id ^java.lang.Object value]
    (new BasicAttribute id value))
  (^BasicAttribute [^java.lang.String id]
    (new BasicAttribute id)))

(defn ordered?
  "Description copied from interface: Attribute

  returns: true if this attribute's values are ordered; false otherwise. - `boolean`"
  (^Boolean [^BasicAttribute this]
    (-> this (.isOrdered))))

(defn contains
  "Determines whether a value is in this attribute.

   By default,
   Object.equals() is used when comparing attrVal
   with this attribute's values except when attrVal is an array.
   For an array, each element of the array is checked using
   Object.equals().
   A subclass may use schema information to determine equality.

  attr-val - The possibly null value to check. If null, check whether the attribute has an attribute value whose value is null. - `java.lang.Object`

  returns: true if attrVal is one of this attribute's values; false otherwise. - `boolean`"
  (^Boolean [^BasicAttribute this ^java.lang.Object attr-val]
    (-> this (.contains attr-val))))

(defn get-all
  "Retrieves an enumeration of this attribute's values.

   By default, the values returned are those passed to the
   constructor and/or manipulated using the add/replace/remove methods.
   A subclass may override this to retrieve the values dynamically
   from the directory.

  returns: A non-null enumeration of the attribute's values.
   Each element of the enumeration is a possibly null Object. The object's
   class is the class of the attribute value. The element is null
   if the attribute's value is null.
   If the attribute has zero values, an empty enumeration
   is returned. - `javax.naming.NamingEnumeration<?>`

  throws: javax.naming.NamingException - If a naming exception was encountered while retrieving the values."
  (^javax.naming.NamingEnumeration [^BasicAttribute this]
    (-> this (.getAll))))

(defn to-string
  "Generates the string representation of this attribute.
   The string consists of the attribute's id and its values.
   This string is meant for debugging and not meant to be
   interpreted programmatically.

  returns: The non-null string representation of this attribute. - `java.lang.String`"
  (^java.lang.String [^BasicAttribute this]
    (-> this (.toString))))

(defn get-attribute-definition
  "Retrieves this attribute's schema definition.

   This method by default throws OperationNotSupportedException. A subclass
   should override this method if it supports schema.

  returns: This attribute's schema definition. Null if the implementation
       supports schemas but this particular attribute does not have
       any schema information. - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - If getting the schema is not supported."
  (^javax.naming.directory.DirContext [^BasicAttribute this]
    (-> this (.getAttributeDefinition))))

(defn get-attribute-syntax-definition
  "Retrieves the syntax definition associated with this attribute.

   This method by default throws OperationNotSupportedException. A subclass
   should override this method if it supports schema.

  returns: The attribute's syntax definition. Null if the implementation
      supports schemas but this particular attribute does not have
      any schema information. - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - If getting the schema is not supported."
  (^javax.naming.directory.DirContext [^BasicAttribute this]
    (-> this (.getAttributeSyntaxDefinition))))

(defn remove
  "Removes a specified value from this attribute.

   By default, Object.equals() is used when comparing attrVal
   with this attribute's values except when attrVal is an array.
   For an array, each element of the array is checked using
   Object.equals().
   A subclass may use schema information to determine equality.

  attrval - The possibly null value to remove from this attribute. If null, remove the attribute value that is null. - `java.lang.Object`

  returns: true if the value was removed; false otherwise. - `boolean`"
  (^Boolean [^BasicAttribute this ^java.lang.Object attrval]
    (-> this (.remove attrval))))

(defn clone
  "Description copied from class: Object

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^BasicAttribute this]
    (-> this (.clone))))

(defn hash-code
  "Calculates the hash code of this attribute.

   The hash code is computed by adding the hash code of
   the attribute's id and that of all of its values except for
   values that are arrays.
   For an array, the hash code of each element of the array is summed.
   If a subclass overrides hashCode(), it should override
   equals()
   as well so that two attributes that are equal have the same hash code.

  returns: an int representing the hash code of this attribute. - `int`"
  (^Integer [^BasicAttribute this]
    (-> this (.hashCode))))

(defn get-id
  "Description copied from interface: Attribute

  returns: The id of this attribute. It cannot be null. - `java.lang.String`"
  (^java.lang.String [^BasicAttribute this]
    (-> this (.getID))))

(defn add
  "Description copied from interface: Attribute

  ix - The index in the ordered list of attribute values to add the new value. 0 <= ix <= size(). - `int`
  attr-val - The possibly null attribute value to add; if null, null is the value added. - `java.lang.Object`"
  ([^BasicAttribute this ^Integer ix ^java.lang.Object attr-val]
    (-> this (.add ix attr-val)))
  (^Boolean [^BasicAttribute this ^java.lang.Object attr-val]
    (-> this (.add attr-val))))

(defn set
  "Description copied from interface: Attribute

  ix - The index of the value in the ordered list of attribute values. 0 <= ix < size(). - `int`
  attr-val - The possibly null attribute value to use. If null, 'null' replaces the old value. - `java.lang.Object`

  returns: The possibly null attribute value at index ix that was replaced.
     Null if the attribute value was null. - `java.lang.Object`"
  (^java.lang.Object [^BasicAttribute this ^Integer ix ^java.lang.Object attr-val]
    (-> this (.set ix attr-val))))

(defn size
  "Description copied from interface: Attribute

  returns: The nonnegative number of values in this attribute. - `int`"
  (^Integer [^BasicAttribute this]
    (-> this (.size))))

(defn clear
  "Description copied from interface: Attribute"
  ([^BasicAttribute this]
    (-> this (.clear))))

(defn get
  "Description copied from interface: Attribute

  ix - The index of the value in the ordered list of attribute values. 0 <= ix < size(). - `int`

  returns: The possibly null attribute value at index ix;
     null if the attribute value is null. - `java.lang.Object`

  throws: javax.naming.NamingException - If a naming exception was encountered while retrieving the value."
  (^java.lang.Object [^BasicAttribute this ^Integer ix]
    (-> this (.get ix)))
  (^java.lang.Object [^BasicAttribute this]
    (-> this (.get))))

(defn equals
  "Determines whether obj is equal to this attribute.
   Two attributes are equal if their attribute-ids, syntaxes
   and values are equal.
   If the attribute values are unordered, the order that the values were added
   are irrelevant. If the attribute values are ordered, then the
   order the values must match.
   If obj is null or not an Attribute, false is returned.

   By default Object.equals() is used when comparing the attribute
   id and its values except when a value is an array. For an array,
   each element of the array is checked using Object.equals().
   A subclass may override this to make
   use of schema syntax information and matching rules,
   which define what it means for two attributes to be equal.
   How and whether a subclass makes
   use of the schema information is determined by the subclass.
   If a subclass overrides equals(), it should also override
   hashCode()
   such that two attributes that are equal have the same hash code.

  obj - The possibly null object to check. - `java.lang.Object`

  returns: true if obj is equal to this attribute; false otherwise. - `boolean`"
  (^Boolean [^BasicAttribute this ^java.lang.Object obj]
    (-> this (.equals obj))))

