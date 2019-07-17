(ns javax.management.ObjectInstance
  "Used to represent the object name of an MBean and its class name.
  If the MBean is a Dynamic MBean the class name should be retrieved from
  the MBeanInfo it provides."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management ObjectInstance]))

(defn ->object-instance
  "Constructor.

  Allows an object instance to be created given a string representation of
   an object name and the full class name, including the package name.

  object-name - A string representation of the object name. - `java.lang.String`
  class-name - The full class name, including the package name, of the object instance. If the MBean is a Dynamic MBean the class name corresponds to its getMBeanInfo().getClassName(). - `java.lang.String`

  throws: javax.management.MalformedObjectNameException - The string passed as a parameter does not have the right format."
  ([object-name class-name]
    (new ObjectInstance object-name class-name)))

(defn equals
  "Compares the current object instance with another object instance.

  object - The object instance that the current object instance is to be compared with. - `java.lang.Object`

  returns: True if the two object instances are equal, otherwise false. - `boolean`"
  ([this object]
    (-> this (.equals object))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-object-name
  "Returns the object name part.

  returns: the object name. - `javax.management.ObjectName`"
  ([this]
    (-> this (.getObjectName))))

(defn get-class-name
  "Returns the class part.

  returns: the class name. - `java.lang.String`"
  ([this]
    (-> this (.getClassName))))

(defn to-string
  "Returns a string representing this ObjectInstance object. The format of this string
   is not specified, but users can expect that two ObjectInstances return the same
   string if and only if they are equal.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

