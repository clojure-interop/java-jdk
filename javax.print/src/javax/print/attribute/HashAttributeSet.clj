(ns javax.print.attribute.HashAttributeSet
  "Class HashAttributeSet provides an AttributeSet
  implementation with characteristics of a hash map."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute HashAttributeSet]))

(defn ->hash-attribute-set
  "Constructor.

  Construct a new attribute set,
   initially populated with the given attribute.

  attribute - Attribute value to add to the set. - `javax.print.attribute.Attribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if attribute is null."
  ([^javax.print.attribute.Attribute attribute]
    (new HashAttributeSet attribute))
  ([]
    (new HashAttributeSet )))

(defn add-all
  "Adds all of the elements in the specified set to this attribute.
   The outcome is the same as if the
   add(Attribute)
   operation had been applied to this attribute set successively with
   each element from the specified set.
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
  (^Boolean [^javax.print.attribute.HashAttributeSet this ^javax.print.attribute.AttributeSet attributes]
    (-> this (.addAll attributes))))

(defn contains-value
  "Returns true if this attribute set contains the given
   attribute.

  attribute - value whose presence in this attribute set is to be tested. - `javax.print.attribute.Attribute`

  returns: true if this attribute set contains the given
        attribute    value. - `boolean`"
  (^Boolean [^javax.print.attribute.HashAttributeSet this ^javax.print.attribute.Attribute attribute]
    (-> this (.containsValue attribute))))

(defn remove
  "Removes any attribute for this category from this attribute set if
   present. If category is null, then
   remove() does nothing and returns false.

  category - Attribute category to be removed from this attribute set. - `java.lang.Class<?>`

  returns: true if this attribute set changed as a result of the
           call, i.e., the given attribute category had been a member of
           this attribute set. - `boolean`

  throws: javax.print.attribute.UnmodifiableSetException - (unchecked exception) Thrown if this attribute set does not support the remove() operation."
  (^Boolean [^javax.print.attribute.HashAttributeSet this ^java.lang.Class category]
    (-> this (.remove category))))

(defn hash-code
  "Returns the hash code value for this attribute set.
   The hash code of an attribute set is defined to be the sum
   of the hash codes of each entry in the AttributeSet.
   This ensures that t1.equals(t2) implies that
   t1.hashCode()==t2.hashCode() for any two attribute sets
   t1 and t2, as required by the general contract of
   Object.hashCode().

  returns: The hash code value for this attribute set. - `int`"
  (^Integer [^javax.print.attribute.HashAttributeSet this]
    (-> this (.hashCode))))

(defn add
  "Adds the specified attribute to this attribute set if it is not
   already present, first removing any existing in the same
   attribute category as the specified attribute value.

  attribute - Attribute value to be added to this attribute set. - `javax.print.attribute.Attribute`

  returns: true if this attribute set changed as a result of the
            call, i.e., the given attribute value was not already a
            member of this attribute set. - `boolean`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if the attribute is null."
  (^Boolean [^javax.print.attribute.HashAttributeSet this ^javax.print.attribute.Attribute attribute]
    (-> this (.add attribute))))

(defn empty?
  "Returns true if this attribute set contains no attributes.

  returns: true if this attribute set contains no attributes. - `boolean`"
  (^Boolean [^javax.print.attribute.HashAttributeSet this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of attributes in this attribute set. If this
   attribute set contains more than Integer.MAX_VALUE elements,
   returns  Integer.MAX_VALUE.

  returns: The number of attributes in this attribute set. - `int`"
  (^Integer [^javax.print.attribute.HashAttributeSet this]
    (-> this (.size))))

(defn clear
  "Removes all attributes from this attribute set.

  throws: javax.print.attribute.UnmodifiableSetException - (unchecked exception) Thrown if this attribute set does not support the clear() operation."
  ([^javax.print.attribute.HashAttributeSet this]
    (-> this (.clear))))

(defn to-array
  "Description copied from interface: AttributeSet

  returns: the Attributes contained in this set as an array, zero length
   if the AttributeSet is empty. - `javax.print.attribute.Attribute[]`"
  ([^javax.print.attribute.HashAttributeSet this]
    (-> this (.toArray))))

(defn contains-key
  "Returns true if this attribute set contains an
   attribute for the specified category.

  category - whose presence in this attribute set is to be tested. - `java.lang.Class<?>`

  returns: true if this attribute set contains an attribute
           value for the specified category. - `boolean`"
  (^Boolean [^javax.print.attribute.HashAttributeSet this ^java.lang.Class category]
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
  (^javax.print.attribute.Attribute [^javax.print.attribute.HashAttributeSet this ^java.lang.Class category]
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
  (^Boolean [^javax.print.attribute.HashAttributeSet this ^java.lang.Object object]
    (-> this (.equals object))))

