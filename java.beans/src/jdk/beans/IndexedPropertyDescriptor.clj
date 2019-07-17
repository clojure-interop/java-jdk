(ns jdk.beans.IndexedPropertyDescriptor
  "An IndexedPropertyDescriptor describes a property that acts like an
  array and has an indexed read and/or indexed write method to access
  specific elements of the array.

  An indexed property may also provide simple non-indexed read and write
  methods.  If these are present, they read and write arrays of the type
  returned by the indexed read method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans IndexedPropertyDescriptor]))

(defn ->indexed-property-descriptor
  "Constructor.

  This constructor takes the name of a simple property, and method
   names for reading and writing the property, both indexed
   and non-indexed.

  property-name - The programmatic name of the property. - `java.lang.String`
  bean-class - The Class object for the target bean. - `java.lang.Class<?>`
  read-method-name - The name of the method used for reading the property values as an array. May be null if the property is write-only or must be indexed. - `java.lang.String`
  write-method-name - The name of the method used for writing the property values as an array. May be null if the property is read-only or must be indexed. - `java.lang.String`
  indexed-read-method-name - The name of the method used for reading an indexed property value. May be null if the property is write-only. - `java.lang.String`
  indexed-write-method-name - The name of the method used for writing an indexed property value. May be null if the property is read-only. - `java.lang.String`

  throws: java.beans.IntrospectionException - if an exception occurs during introspection."
  ([property-name bean-class read-method-name write-method-name indexed-read-method-name indexed-write-method-name]
    (new IndexedPropertyDescriptor property-name bean-class read-method-name write-method-name indexed-read-method-name indexed-write-method-name))
  ([property-name read-method write-method indexed-read-method indexed-write-method]
    (new IndexedPropertyDescriptor property-name read-method write-method indexed-read-method indexed-write-method))
  ([property-name bean-class]
    (new IndexedPropertyDescriptor property-name bean-class)))

(defn get-indexed-read-method
  "Gets the method that should be used to read an indexed
   property value.

  returns: The method that should be used to read an indexed
   property value.
   May return null if the property isn't indexed or is write-only. - `java.lang.reflect.Method`"
  ([this]
    (-> this (.getIndexedReadMethod))))

(defn set-indexed-read-method
  "Sets the method that should be used to read an indexed property value.

  read-method - The new indexed read method. - `java.lang.reflect.Method`

  throws: java.beans.IntrospectionException - if an exception occurs during introspection."
  ([this read-method]
    (-> this (.setIndexedReadMethod read-method))))

(defn get-indexed-write-method
  "Gets the method that should be used to write an indexed property value.

  returns: The method that should be used to write an indexed
   property value.
   May return null if the property isn't indexed or is read-only. - `java.lang.reflect.Method`"
  ([this]
    (-> this (.getIndexedWriteMethod))))

(defn set-indexed-write-method
  "Sets the method that should be used to write an indexed property value.

  write-method - The new indexed write method. - `java.lang.reflect.Method`

  throws: java.beans.IntrospectionException - if an exception occurs during introspection."
  ([this write-method]
    (-> this (.setIndexedWriteMethod write-method))))

(defn get-indexed-property-type
  "Returns the Java type info for the indexed property.
   Note that the Class object may describe
   primitive Java types such as int.
   This type is returned by the indexed read method
   or is used as the parameter type of the indexed write method.

  returns: the Class object that represents the Java type info,
           or null if the type cannot be determined - `java.lang.Class<?>`"
  ([this]
    (-> this (.getIndexedPropertyType))))

(defn equals
  "Compares this PropertyDescriptor against the specified object.
   Returns true if the objects are the same. Two PropertyDescriptors
   are the same if the read, write, property types, property editor and
   flags  are equivalent.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for the object.
   See Object.hashCode() for a complete description.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

