(ns javax.print.attribute.AttributeSet
  "Interface AttributeSet specifies the interface for a set of printing
  attributes. A printing attribute is an object whose class implements
  interface Attribute.

  An attribute set contains a group of attribute values,
  where duplicate values are not allowed in the set.
  Furthermore, each value in an attribute set is
  a member of some category, and at most one value in any particular
  category is allowed in the set. For an attribute set, the values are Attribute objects, and the categories are Class objects. An attribute's category is the class (or interface) at the
  root of the class hierarchy for that kind of attribute. Note that an
  attribute object's category may be a superclass of the attribute object's
  class rather than the attribute object's class itself. An attribute
  object's
  category is determined by calling the getCategory() method defined in interface Attribute.

  The interfaces of an AttributeSet resemble those of the Java Collections
  API's java.util.Map interface, but is more restrictive in the types
  it will accept, and combines keys and values into an Attribute.

  Attribute sets are used in several places in the Print Service API. In
  each context, only certain kinds of attributes are allowed to appear in the
  attribute set, as determined by the tagging interfaces which the attribute
  class implements -- DocAttribute, PrintRequestAttribute, PrintJobAttribute, and PrintServiceAttribute.
  There are four specializations of an attribute set that are restricted to
  contain just one of the four kinds of attribute -- DocAttributeSet, PrintRequestAttributeSet,
  PrintJobAttributeSet, and PrintServiceAttributeSet, respectively. Note that
  many attribute classes implement more than one tagging interface and so may
  appear in more than one context.


  A DocAttributeSet, containing DocAttributes, specifies the characteristics of an individual doc and the
  print job settings to be applied to an individual doc.


  A PrintRequestAttributeSet, containing
  PrintRequestAttributes, specifies the
  settings
  to be applied to a whole print job and to all the docs in the print job.


  A PrintJobAttributeSet, containing PrintJobAttributes, reports the status of a print job.


  A PrintServiceAttributeSet, containing
  PrintServiceAttributes, reports the status of
   a Print Service instance.


  In some contexts, the client is only allowed to examine an attribute set's
  contents but not change them (the set is read-only). In other places, the
  client is allowed both to examine and to change an attribute set's contents
  (the set is read-write). For a read-only attribute set, calling a mutating
  operation throws an UnmodifiableSetException.

  The Print Service API provides one implementation of interface
  AttributeSet, class HashAttributeSet.
  A client can use class HashAttributeSet or provide its own implementation of
  interface AttributeSet. The Print Service API also provides
  implementations of interface AttributeSet's subinterfaces -- classes HashDocAttributeSet,
  HashPrintRequestAttributeSet, HashPrintJobAttributeSet, and HashPrintServiceAttributeSet."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute AttributeSet]))

(defn add-all
  "Adds all of the elements in the specified set to this attribute.
   The outcome is the same as if the =
   add(Attribute)
   operation had been applied to this attribute set successively with each
   element from the specified set.
   The behavior of the addAll(AttributeSet)
   operation is unspecified if the specified set is modified while
   the operation is in progress.

   If the addAll(AttributeSet) operation throws an exception,
   the effect on this attribute set's state is implementation dependent;
   elements from the specified set before the point of the exception may
   or may not have been added to this attribute set.

  attributes - whose elements are to be added to this attribute set. - `javax.print.attribute.AttributeSet`

  returns: true if this attribute set changed as a result of the
            call. - `boolean`

  throws: javax.print.attribute.UnmodifiableSetException - (Unchecked exception) Thrown if this attribute set does not support the addAll(AttributeSet) method."
  (^Boolean [^javax.print.attribute.AttributeSet this ^javax.print.attribute.AttributeSet attributes]
    (-> this (.addAll attributes))))

(defn contains-value
  "Returns true if this attribute set contains the given
   attribute value.

  attribute - Attribute value whose presence in this attribute set is to be tested. - `javax.print.attribute.Attribute`

  returns: true if this attribute set contains the given
        attribute  value. - `boolean`"
  (^Boolean [^javax.print.attribute.AttributeSet this ^javax.print.attribute.Attribute attribute]
    (-> this (.containsValue attribute))))

(defn remove
  "Removes any attribute for this category from this attribute set if
   present. If category is null, then
   remove() does nothing and returns false.

  category - Attribute category to be removed from this attribute set. - `java.lang.Class<?>`

  returns: true if this attribute set changed as a result of the
           call, i.e., the given attribute value had been a member of this
            attribute set. - `boolean`

  throws: javax.print.attribute.UnmodifiableSetException - (unchecked exception) Thrown if this attribute set does not support the remove() operation."
  (^Boolean [^javax.print.attribute.AttributeSet this ^java.lang.Class category]
    (-> this (.remove category))))

(defn hash-code
  "Returns the hash code value for this attribute set. The hash code of an
   attribute set is defined to be the sum of the hash codes of each entry
   in the AttributeSet.
   This ensures that t1.equals(t2) implies that
   t1.hashCode()==t2.hashCode() for any two attribute sets
   t1 and t2, as required by the general contract of
   Object.hashCode().

  returns: The hash code value for this attribute set. - `int`"
  (^Integer [^javax.print.attribute.AttributeSet this]
    (-> this (.hashCode))))

(defn add
  "Adds the specified attribute to this attribute set if it is not
   already present, first removing any existing value in the same
   attribute category as the specified attribute value.

  attribute - Attribute value to be added to this attribute set. - `javax.print.attribute.Attribute`

  returns: true if this attribute set changed as a result of the
            call, i.e., the given attribute value was not already a member
            of this attribute set. - `boolean`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if the attribute is null."
  (^Boolean [^javax.print.attribute.AttributeSet this ^javax.print.attribute.Attribute attribute]
    (-> this (.add attribute))))

(defn empty?
  "Returns true if this attribute set contains no attributes.

  returns: true if this attribute set contains no attributes. - `boolean`"
  (^Boolean [^javax.print.attribute.AttributeSet this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of attributes in this attribute set. If this
   attribute set contains more than Integer.MAX_VALUE elements,
   returns  Integer.MAX_VALUE.

  returns: The number of attributes in this attribute set. - `int`"
  (^Integer [^javax.print.attribute.AttributeSet this]
    (-> this (.size))))

(defn clear
  "Removes all attributes from this attribute set.

  throws: javax.print.attribute.UnmodifiableSetException - (unchecked exception) Thrown if this attribute set does not support the clear() operation."
  ([^javax.print.attribute.AttributeSet this]
    (-> this (.clear))))

(defn to-array
  "Returns an array of the attributes contained in this set.

  returns: the Attributes contained in this set as an array, zero length
   if the AttributeSet is empty. - `javax.print.attribute.Attribute[]`"
  ([^javax.print.attribute.AttributeSet this]
    (-> this (.toArray))))

(defn contains-key
  "Returns true if this attribute set contains an
   attribute for the specified category.

  category - whose presence in this attribute set is to be tested. - `java.lang.Class<?>`

  returns: true if this attribute set contains an attribute
           value for the specified category. - `boolean`"
  (^Boolean [^javax.print.attribute.AttributeSet this ^java.lang.Class category]
    (-> this (.containsKey category))))

(defn get
  "Returns the attribute value which this attribute set contains in the
   given attribute category. Returns null if this attribute set
   does not contain any attribute value in the given attribute category.

  category - Attribute category whose associated attribute value is to be returned. It must be a Class that implements interface Attribute. - `java.lang.Class<?>`

  returns: The attribute value in the given attribute category contained
            in this attribute set, or null if this attribute set
            does not contain any attribute value in the given attribute
            category. - `javax.print.attribute.Attribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if the category is null."
  (^javax.print.attribute.Attribute [^javax.print.attribute.AttributeSet this ^java.lang.Class category]
    (-> this (.get category))))

(defn equals
  "Compares the specified object with this attribute set for equality.
   Returns true if the given object is also an attribute set and
   the two attribute sets contain the same attribute category-attribute
   value mappings. This ensures that the
   equals() method works properly across different
   implementations of the AttributeSet interface.

  object - to be compared for equality with this attribute set. - `java.lang.Object`

  returns: true if the specified object is equal to this
         attribute   set. - `boolean`"
  (^Boolean [^javax.print.attribute.AttributeSet this ^java.lang.Object object]
    (-> this (.equals object))))

