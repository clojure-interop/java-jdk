(ns jdk.util.jar.Attributes
  "The Attributes class maps Manifest attribute names to associated string
  values. Valid attribute names are case-insensitive, are restricted to
  the ASCII characters in the set [0-9a-zA-Z_-], and cannot exceed 70
  characters in length. Attribute values can contain any characters and
  will be UTF8-encoded when written to the output stream.  See the
  JAR File Specification
  for more information about valid attribute names and values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.jar Attributes]))

(defn ->attributes
  "Constructor.

  Constructs a new, empty Attributes object with the specified
   initial size.

  size - the initial number of attributes - `int`"
  ([^Integer size]
    (new Attributes size))
  ([]
    (new Attributes )))

(defn values
  "Returns a Collection view of the attribute values contained in this Map.

  returns: a collection view of the values contained in this map - `java.util.Collection<java.lang.Object>`"
  (^java.util.Collection [^java.util.jar.Attributes this]
    (-> this (.values))))

(defn put-all
  "Copies all of the attribute name-value mappings from the specified
   Attributes to this Map. Duplicate mappings will be replaced.

  attr - the Attributes to be stored in this map - `java.util.Map<?,?>`

  throws: java.lang.ClassCastException - if attr is not an Attributes"
  ([^java.util.jar.Attributes this ^java.util.Map attr]
    (-> this (.putAll attr))))

(defn put
  "Associates the specified value with the specified attribute name
   (key) in this Map. If the Map previously contained a mapping for
   the attribute name, the old value is replaced.

  name - the attribute name - `java.lang.Object`
  value - the attribute value - `java.lang.Object`

  returns: the previous value of the attribute, or null if none - `java.lang.Object`

  throws: java.lang.ClassCastException - if the name is not a Attributes.Name or the value is not a String"
  (^java.lang.Object [^java.util.jar.Attributes this ^java.lang.Object name ^java.lang.Object value]
    (-> this (.put name value))))

(defn entry-set
  "Returns a Collection view of the attribute name-value mappings
   contained in this Map.

  returns: a set view of the mappings contained in this map - `java.util.Set<java.util.Map.Entry<java.lang.Object,java.lang.Object>>`"
  (^java.util.Set> [^java.util.jar.Attributes this]
    (-> this (.entrySet))))

(defn put-value
  "Associates the specified value with the specified attribute name,
   specified as a String. The attributes name is case-insensitive.
   If the Map previously contained a mapping for the attribute name,
   the old value is replaced.

   This method is defined as:


        return (String)put(new Attributes.Name(name), value);

  name - the attribute name as a string - `java.lang.String`
  value - the attribute value - `java.lang.String`

  returns: the previous value of the attribute, or null if none - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the attribute name is invalid"
  (^java.lang.String [^java.util.jar.Attributes this ^java.lang.String name ^java.lang.String value]
    (-> this (.putValue name value))))

(defn get-value
  "Returns the value of the specified attribute name, specified as
   a string, or null if the attribute was not found. The attribute
   name is case-insensitive.

   This method is defined as:


        return (String)get(new Attributes.Name((String)name));

  name - the attribute name as a string - `java.lang.String`

  returns: the String value of the specified attribute name, or null if
           not found. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the attribute name is invalid"
  (^java.lang.String [^java.util.jar.Attributes this ^java.lang.String name]
    (-> this (.getValue name))))

(defn contains-value
  "Returns true if this Map maps one or more attribute names (keys)
   to the specified value.

  value - the attribute value - `java.lang.Object`

  returns: true if this Map maps one or more attribute names to
           the specified value - `boolean`"
  (^Boolean [^java.util.jar.Attributes this ^java.lang.Object value]
    (-> this (.containsValue value))))

(defn remove
  "Removes the attribute with the specified name (key) from this Map.
   Returns the previous attribute value, or null if none.

  name - attribute name - `java.lang.Object`

  returns: the previous value of the attribute, or null if none - `java.lang.Object`"
  (^java.lang.Object [^java.util.jar.Attributes this ^java.lang.Object name]
    (-> this (.remove name))))

(defn key-set
  "Returns a Set view of the attribute names (keys) contained in this Map.

  returns: a set view of the keys contained in this map - `java.util.Set<java.lang.Object>`"
  (^java.util.Set [^java.util.jar.Attributes this]
    (-> this (.keySet))))

(defn clone
  "Returns a copy of the Attributes, implemented as follows:


       public Object clone() { return new Attributes(this); }
   Since the attribute names and values are themselves immutable,
   the Attributes returned can be safely modified without affecting
   the original.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^java.util.jar.Attributes this]
    (-> this (.clone))))

(defn hash-code
  "Returns the hash code value for this Map.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.util.jar.Attributes this]
    (-> this (.hashCode))))

(defn empty?
  "Returns true if this Map contains no attributes.

  returns: true if this map contains no key-value mappings - `boolean`"
  (^Boolean [^java.util.jar.Attributes this]
    (-> this (.isEmpty))))

(defn size
  "Returns the number of attributes in this Map.

  returns: the number of key-value mappings in this map - `int`"
  (^Integer [^java.util.jar.Attributes this]
    (-> this (.size))))

(defn clear
  "Removes all attributes from this Map."
  ([^java.util.jar.Attributes this]
    (-> this (.clear))))

(defn contains-key
  "Returns true if this Map contains the specified attribute name (key).

  name - the attribute name - `java.lang.Object`

  returns: true if this Map contains the specified attribute name - `boolean`"
  (^Boolean [^java.util.jar.Attributes this ^java.lang.Object name]
    (-> this (.containsKey name))))

(defn get
  "Returns the value of the specified attribute name, or null if the
   attribute name was not found.

  name - the attribute name - `java.lang.Object`

  returns: the value of the specified attribute name, or null if
           not found. - `java.lang.Object`"
  (^java.lang.Object [^java.util.jar.Attributes this ^java.lang.Object name]
    (-> this (.get name))))

(defn equals
  "Compares the specified Attributes object with this Map for equality.
   Returns true if the given object is also an instance of Attributes
   and the two Attributes objects represent the same mappings.

  o - the Object to be compared - `java.lang.Object`

  returns: true if the specified Object is equal to this Map - `boolean`"
  (^Boolean [^java.util.jar.Attributes this ^java.lang.Object o]
    (-> this (.equals o))))

