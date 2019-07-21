(ns javax.print.attribute.AttributeSetUtilities
  "Class AttributeSetUtilities provides static methods for manipulating
  AttributeSets.

  Methods for creating unmodifiable and synchronized views of attribute
  sets.
  operations useful for building
  implementations of interface AttributeSet


  An unmodifiable view U of an AttributeSet S provides a
  client with \"read-only\" access to S. Query operations on U
  \"read through\" to S; thus, changes in S are reflected in
  U. However, any attempt to modify U,
   results in an UnmodifiableSetException.
  The unmodifiable view object U will be serializable if the
  attribute set object S is serializable.

  A synchronized view V of an attribute set S provides a
  client with synchronized (multiple thread safe) access to S. Each
  operation of V is synchronized using V itself as the lock
  object and then merely invokes the corresponding operation of S. In
  order to guarantee mutually exclusive access, it is critical that all
  access to S is accomplished through V. The synchronized view
  object V will be serializable if the attribute set object S
  is serializable.

  As mentioned in the package description of javax.print, a null reference
  parameter to methods is
  incorrect unless explicitly documented on the method as having a meaningful
  interpretation.  Usage to the contrary is incorrect coding and may result in
  a run time exception either immediately
  or at some later time. IllegalArgumentException and NullPointerException
  are examples of typical and acceptable run time exceptions for such cases."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute AttributeSetUtilities]))

(defn *unmodifiable-view
  "Creates an unmodifiable view of the given attribute set.

  attribute-set - Underlying attribute set. - `javax.print.attribute.AttributeSet`

  returns: Unmodifiable view of attributeSet. - `javax.print.attribute.AttributeSet`

  throws: java.lang.NullPointerException - Thrown if attributeSet is null. Null is never a"
  (^javax.print.attribute.AttributeSet [^javax.print.attribute.AttributeSet attribute-set]
    (AttributeSetUtilities/unmodifiableView attribute-set)))

(defn *synchronized-view
  "Creates a synchronized view of the given attribute set.

  attribute-set - Underlying attribute set. - `javax.print.attribute.AttributeSet`

  returns: Synchronized view of attributeSet. - `javax.print.attribute.AttributeSet`

  throws: java.lang.NullPointerException - Thrown if attributeSet is null."
  (^javax.print.attribute.AttributeSet [^javax.print.attribute.AttributeSet attribute-set]
    (AttributeSetUtilities/synchronizedView attribute-set)))

(defn *verify-attribute-category
  "Verify that the given object is a Class that
   implements the given interface, which is assumed to be interface Attribute or a subinterface thereof.

  object - Object to test. - `java.lang.Object`
  interface-name - Interface the object must implement. - `java.lang.Class`

  returns: If object is a Class
            that implements interfaceName,
            object is returned downcast to type Class; otherwise an exception is thrown. - `java.lang.Class<?>`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if object is null."
  (^java.lang.Class [^java.lang.Object object ^java.lang.Class interface-name]
    (AttributeSetUtilities/verifyAttributeCategory object interface-name)))

(defn *verify-attribute-value
  "Verify that the given object is an instance of the given interface, which
   is assumed to be interface Attribute or a subinterface
   thereof.

  object - Object to test. - `java.lang.Object`
  interface-name - Interface of which the object must be an instance. - `java.lang.Class`

  returns: If object is an instance of
            interfaceName, object is returned
            downcast to type Attribute; otherwise an
            exception is thrown. - `javax.print.attribute.Attribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if object is null."
  (^javax.print.attribute.Attribute [^java.lang.Object object ^java.lang.Class interface-name]
    (AttributeSetUtilities/verifyAttributeValue object interface-name)))

(defn *verify-category-for-value
  "Verify that the given attribute category object is equal to the
   category of the given attribute value object. If so, this method
   returns doing nothing. If not, this method throws an exception.

  category - Attribute category to test. - `java.lang.Class`
  attribute - Attribute value to test. - `javax.print.attribute.Attribute`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if the category is null or if the attribute is null."
  ([^java.lang.Class category ^javax.print.attribute.Attribute attribute]
    (AttributeSetUtilities/verifyCategoryForValue category attribute)))

