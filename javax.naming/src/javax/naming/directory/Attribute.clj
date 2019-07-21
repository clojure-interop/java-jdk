(ns javax.naming.directory.Attribute
  "This interface represents an attribute associated with a named object.

  In a directory, named objects can have associated with them
  attributes.  The Attribute interface represents an attribute associated
  with a named object.  An attribute contains 0 or more, possibly null, values.
  The attribute values can be ordered or unordered (see isOrdered()).
  If the values are unordered, no duplicates are allowed.
  If the values are ordered, duplicates are allowed.

  The content and representation of an attribute and its values is defined by
  the attribute's schema. The schema contains information
  about the attribute's syntax and other properties about the attribute.
  See getAttributeDefinition() and
  getAttributeSyntaxDefinition()
  for details regarding how to get schema information about an attribute
  if the underlying directory service supports schemas.

  Equality of two attributes is determined by the implementation class.
  A simple implementation can use Object.equals() to determine equality
  of attribute values, while a more sophisticated implementation might
  make use of schema information to determine equality.
  Similarly, one implementation might provide a static storage
  structure which simply returns the values passed to its
  constructor, while another implementation might define get() and
  getAll().
  to get the values dynamically from the directory.

  Note that updates to Attribute (such as adding or removing a
  value) do not affect the corresponding representation of the attribute
  in the directory.  Updates to the directory can only be effected
  using operations in the DirContext interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory Attribute]))

(defn ordered?
  "Determines whether this attribute's values are ordered.
   If an attribute's values are ordered, duplicate values are allowed.
   If an attribute's values are unordered, they are presented
   in any order and there are no duplicate values.

  returns: true if this attribute's values are ordered; false otherwise. - `boolean`"
  (^Boolean [^Attribute this]
    (-> this (.isOrdered))))

(defn contains
  "Determines whether a value is in the attribute.
   Equality is determined by the implementation, which may use
   Object.equals() or schema information to determine equality.

  attr-val - The possibly null value to check. If null, check whether the attribute has an attribute value whose value is null. - `java.lang.Object`

  returns: true if attrVal is one of this attribute's values; false otherwise. - `boolean`"
  (^Boolean [^Attribute this ^java.lang.Object attr-val]
    (-> this (.contains attr-val))))

(defn get-all
  "Retrieves an enumeration of the attribute's values.
   The behaviour of this enumeration is unspecified
   if the attribute's values are added, changed,
   or removed while the enumeration is in progress.
   If the attribute values are ordered, the enumeration's items
   will be ordered.

  returns: A non-null enumeration of the attribute's values.
   Each element of the enumeration is a possibly null Object. The object's
   class is the class of the attribute value. The element is null
   if the attribute's value is null.
   If the attribute has zero values, an empty enumeration
   is returned. - `javax.naming.NamingEnumeration<?>`

  throws: javax.naming.NamingException - If a naming exception was encountered while retrieving the values."
  (^javax.naming.NamingEnumeration [^Attribute this]
    (-> this (.getAll))))

(defn get-attribute-definition
  "Retrieves the attribute's schema definition.
   An attribute's schema definition contains information
   such as whether the attribute is multivalued or single-valued,
   the matching rules to use when comparing the attribute's values.

   The information that you can retrieve from an attribute definition
   is directory-dependent.


   If an implementation does not support schemas, it should throw
   OperationNotSupportedException. If an implementation does support
   schemas, it should define this method to return the appropriate
   information.

  returns: This attribute's schema definition. Null if the implementation
       supports schemas but this particular attribute does not have
       any schema information. - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - If getting the schema is not supported."
  (^javax.naming.directory.DirContext [^Attribute this]
    (-> this (.getAttributeDefinition))))

(defn get-attribute-syntax-definition
  "Retrieves the syntax definition associated with the attribute.
   An attribute's syntax definition specifies the format
   of the attribute's value(s). Note that this is different from
   the attribute value's representation as a Java object. Syntax
   definition refers to the directory's notion of syntax.

   For example, even though a value might be
   a Java String object, its directory syntax might be \"Printable String\"
   or \"Telephone Number\". Or a value might be a byte array, and its
   directory syntax is \"JPEG\" or \"Certificate\".
   For example, if this attribute's syntax is \"JPEG\",
   this method would return the syntax definition for \"JPEG\".

   The information that you can retrieve from a syntax definition
   is directory-dependent.

   If an implementation does not support schemas, it should throw
   OperationNotSupportedException. If an implementation does support
   schemas, it should define this method to return the appropriate
   information.

  returns: The attribute's syntax definition. Null if the implementation
      supports schemas but this particular attribute does not have
      any schema information. - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - If getting the schema is not supported."
  (^javax.naming.directory.DirContext [^Attribute this]
    (-> this (.getAttributeSyntaxDefinition))))

(defn remove
  "Removes a specified value from the attribute.
   If attrval is not in the attribute, this method does nothing.
   If the attribute values are ordered, the first occurrence of
   attrVal is removed and attribute values at indices greater
   than the removed
   value are shifted up towards the head of the list (and their indices
   decremented by one).

   Equality is determined by the implementation, which may use
   Object.equals() or schema information to determine equality.

  attrval - The possibly null value to remove from this attribute. If null, remove the attribute value that is null. - `java.lang.Object`

  returns: true if the value was removed; false otherwise. - `boolean`"
  (^Boolean [^Attribute this ^java.lang.Object attrval]
    (-> this (.remove attrval))))

(defn clone
  "Makes a copy of the attribute.
   The copy contains the same attribute values as the original attribute:
   the attribute values are not themselves cloned.
   Changes to the copy will not affect the original and vice versa.

  returns: A non-null copy of the attribute. - `java.lang.Object`"
  (^java.lang.Object [^Attribute this]
    (-> this (.clone))))

(defn get-id
  "Retrieves the id of this attribute.

  returns: The id of this attribute. It cannot be null. - `java.lang.String`"
  (^java.lang.String [^Attribute this]
    (-> this (.getID))))

(defn add
  "Adds an attribute value to the ordered list of attribute values.
   This method adds attrVal to the list of attribute values at
   index ix.
   Values located at indices at or greater than ix are
   shifted down towards the end of the list (and their indices incremented
   by one).
   If the attribute values are unordered and already have attrVal,
   IllegalStateException is thrown.

  ix - The index in the ordered list of attribute values to add the new value. 0 <= ix <= size(). - `int`
  attr-val - The possibly null attribute value to add; if null, null is the value added. - `java.lang.Object`

  throws: java.lang.IndexOutOfBoundsException - If ix is outside the specified range."
  ([^Attribute this ^Integer ix ^java.lang.Object attr-val]
    (-> this (.add ix attr-val)))
  (^Boolean [^Attribute this ^java.lang.Object attr-val]
    (-> this (.add attr-val))))

(defn set
  "Sets an attribute value in the ordered list of attribute values.
   This method sets the value at the ix index of the list of
   attribute values to be attrVal. The old value is removed.
   If the attribute values are unordered,
   this method sets the value that happens to be at that index
   to attrVal, unless attrVal is already one of the values.
   In that case, IllegalStateException is thrown.

  ix - The index of the value in the ordered list of attribute values. 0 <= ix < size(). - `int`
  attr-val - The possibly null attribute value to use. If null, 'null' replaces the old value. - `java.lang.Object`

  returns: The possibly null attribute value at index ix that was replaced.
     Null if the attribute value was null. - `java.lang.Object`

  throws: java.lang.IndexOutOfBoundsException - If ix is outside the specified range."
  (^java.lang.Object [^Attribute this ^Integer ix ^java.lang.Object attr-val]
    (-> this (.set ix attr-val))))

(defn size
  "Retrieves the number of values in this attribute.

  returns: The nonnegative number of values in this attribute. - `int`"
  (^Integer [^Attribute this]
    (-> this (.size))))

(defn clear
  "Removes all values from this attribute."
  ([^Attribute this]
    (-> this (.clear))))

(defn get
  "Retrieves the attribute value from the ordered list of attribute values.
   This method returns the value at the ix index of the list of
   attribute values.
   If the attribute values are unordered,
   this method returns the value that happens to be at that index.

  ix - The index of the value in the ordered list of attribute values. 0 <= ix < size(). - `int`

  returns: The possibly null attribute value at index ix;
     null if the attribute value is null. - `java.lang.Object`

  throws: javax.naming.NamingException - If a naming exception was encountered while retrieving the value."
  (^java.lang.Object [^Attribute this ^Integer ix]
    (-> this (.get ix)))
  (^java.lang.Object [^Attribute this]
    (-> this (.get))))

