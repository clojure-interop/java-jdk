(ns javax.management.Attribute
  "Represents an MBean attribute by associating its name with its value.
  The MBean server and other objects use this class to get and set attributes values."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management Attribute]))

(defn ->attribute
  "Constructor.

  Constructs an Attribute object which associates the given attribute name with the given value.

  name - A String containing the name of the attribute to be created. Cannot be null. - `java.lang.String`
  value - The Object which is assigned to the attribute. This object must be of the same type as the attribute. - `java.lang.Object`"
  ([^java.lang.String name ^java.lang.Object value]
    (new Attribute name value)))

(defn get-name
  "Returns a String containing the  name of the attribute.

  returns: the name of the attribute. - `java.lang.String`"
  (^java.lang.String [^javax.management.Attribute this]
    (-> this (.getName))))

(defn get-value
  "Returns an Object that is the value of this attribute.

  returns: the value of the attribute. - `java.lang.Object`"
  (^java.lang.Object [^javax.management.Attribute this]
    (-> this (.getValue))))

(defn equals
  "Compares the current Attribute Object with another Attribute Object.

  object - The Attribute that the current Attribute is to be compared with. - `java.lang.Object`

  returns: True if the two Attribute objects are equal, otherwise false. - `boolean`"
  (^Boolean [^javax.management.Attribute this ^java.lang.Object object]
    (-> this (.equals object))))

(defn hash-code
  "Returns a hash code value for this attribute.

  returns: a hash code value for this attribute. - `int`"
  (^Integer [^javax.management.Attribute this]
    (-> this (.hashCode))))

(defn to-string
  "Returns a String object representing this Attribute's value. The format of this
   string is not specified, but users can expect that two Attributes return the
   same string if and only if they are equal.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^javax.management.Attribute this]
    (-> this (.toString))))

