(ns jdk.beans.PropertyDescriptor
  "A PropertyDescriptor describes one property that a Java Bean
  exports via a pair of accessor methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyDescriptor]))

(defn ->property-descriptor
  "Constructor.

  This constructor takes the name of a simple property, and method
   names for reading and writing the property.

  property-name - The programmatic name of the property. - `java.lang.String`
  bean-class - The Class object for the target bean. For example sun.beans.OurButton.class. - `java.lang.Class<?>`
  read-method-name - The name of the method used for reading the property value. May be null if the property is write-only. - `java.lang.String`
  write-method-name - The name of the method used for writing the property value. May be null if the property is read-only. - `java.lang.String`

  throws: java.beans.IntrospectionException - if an exception occurs during introspection."
  ([^java.lang.String property-name ^java.lang.Class bean-class ^java.lang.String read-method-name ^java.lang.String write-method-name]
    (new PropertyDescriptor property-name bean-class read-method-name write-method-name))
  ([^java.lang.String property-name ^java.lang.reflect.Method read-method ^java.lang.reflect.Method write-method]
    (new PropertyDescriptor property-name read-method write-method))
  ([^java.lang.String property-name ^java.lang.Class bean-class]
    (new PropertyDescriptor property-name bean-class)))

(defn get-write-method
  "Gets the method that should be used to write the property value.

  returns: The method that should be used to write the property value.
   May return null if the property can't be written. - `java.lang.reflect.Method`"
  (^java.lang.reflect.Method [^java.beans.PropertyDescriptor this]
    (-> this (.getWriteMethod))))

(defn set-write-method
  "Sets the method that should be used to write the property value.

  write-method - The new write method. - `java.lang.reflect.Method`

  throws: java.beans.IntrospectionException - if the write method is invalid"
  ([^java.beans.PropertyDescriptor this ^java.lang.reflect.Method write-method]
    (-> this (.setWriteMethod write-method))))

(defn set-constrained
  "Attempted updates to `Constrained` properties will cause a `VetoableChange`
   event to get fired when the property is changed.

  constrained - True if this is a constrained property. - `boolean`"
  ([^java.beans.PropertyDescriptor this ^Boolean constrained]
    (-> this (.setConstrained constrained))))

(defn create-property-editor
  "Constructs an instance of a property editor using the current
   property editor class.

   If the property editor class has a public constructor that takes an
   Object argument then it will be invoked using the bean parameter
   as the argument. Otherwise, the default constructor will be invoked.

  bean - the source object - `java.lang.Object`

  returns: a property editor instance or null if a property editor has
           not been defined or cannot be created - `java.beans.PropertyEditor`"
  (^java.beans.PropertyEditor [^java.beans.PropertyDescriptor this ^java.lang.Object bean]
    (-> this (.createPropertyEditor bean))))

(defn get-property-type
  "Returns the Java type info for the property.
   Note that the Class object may describe
   primitive Java types such as int.
   This type is returned by the read method
   or is used as the parameter type of the write method.
   Returns null if the type is an indexed property
   that does not support non-indexed access.

  returns: the Class object that represents the Java type info,
           or null if the type cannot be determined - `java.lang.Class<?>`"
  (^java.lang.Class [^java.beans.PropertyDescriptor this]
    (-> this (.getPropertyType))))

(defn set-read-method
  "Sets the method that should be used to read the property value.

  read-method - The new read method. - `java.lang.reflect.Method`

  throws: java.beans.IntrospectionException - if the read method is invalid"
  ([^java.beans.PropertyDescriptor this ^java.lang.reflect.Method read-method]
    (-> this (.setReadMethod read-method))))

(defn get-read-method
  "Gets the method that should be used to read the property value.

  returns: The method that should be used to read the property value.
   May return null if the property can't be read. - `java.lang.reflect.Method`"
  (^java.lang.reflect.Method [^java.beans.PropertyDescriptor this]
    (-> this (.getReadMethod))))

(defn hash-code
  "Returns a hash code value for the object.
   See Object.hashCode() for a complete description.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.beans.PropertyDescriptor this]
    (-> this (.hashCode))))

(defn constrained?
  "Attempted updates to `Constrained` properties will cause a `VetoableChange`
   event to get fired when the property is changed.

  returns: True if this is a constrained property. - `boolean`"
  (^Boolean [^java.beans.PropertyDescriptor this]
    (-> this (.isConstrained))))

(defn bound?
  "Updates to `bound` properties will cause a `PropertyChange` event to
   get fired when the property is changed.

  returns: True if this is a bound property. - `boolean`"
  (^Boolean [^java.beans.PropertyDescriptor this]
    (-> this (.isBound))))

(defn get-property-editor-class
  "Gets any explicit PropertyEditor Class that has been registered
   for this property.

  returns: Any explicit PropertyEditor Class that has been registered
            for this property.  Normally this will return `null`,
            indicating that no special editor has been registered,
            so the PropertyEditorManager should be used to locate
            a suitable PropertyEditor. - `java.lang.Class<?>`"
  (^java.lang.Class [^java.beans.PropertyDescriptor this]
    (-> this (.getPropertyEditorClass))))

(defn set-bound
  "Updates to `bound` properties will cause a `PropertyChange` event to
   get fired when the property is changed.

  bound - True if this is a bound property. - `boolean`"
  ([^java.beans.PropertyDescriptor this ^Boolean bound]
    (-> this (.setBound bound))))

(defn equals
  "Compares this PropertyDescriptor against the specified object.
   Returns true if the objects are the same. Two PropertyDescriptors
   are the same if the read, write, property types, property editor and
   flags  are equivalent.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^java.beans.PropertyDescriptor this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn set-property-editor-class
  "Normally PropertyEditors will be found using the PropertyEditorManager.
   However if for some reason you want to associate a particular
   PropertyEditor with a given property, then you can do it with
   this method.

  property-editor-class - The Class for the desired PropertyEditor. - `java.lang.Class<?>`"
  ([^java.beans.PropertyDescriptor this ^java.lang.Class property-editor-class]
    (-> this (.setPropertyEditorClass property-editor-class))))

