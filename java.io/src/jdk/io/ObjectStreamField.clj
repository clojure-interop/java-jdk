(ns jdk.io.ObjectStreamField
  "A description of a Serializable field from a Serializable class.  An array
  of ObjectStreamFields is used to declare the Serializable fields of a class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectStreamField]))

(defn ->object-stream-field
  "Constructor.

  Creates an ObjectStreamField representing a serializable field with the
   given name and type.  If unshared is false, values of the represented
   field are serialized and deserialized in the default manner--if the
   field is non-primitive, object values are serialized and deserialized as
   if they had been written and read by calls to writeObject and
   readObject.  If unshared is true, values of the represented field are
   serialized and deserialized as if they had been written and read by
   calls to writeUnshared and readUnshared.

  name - field name - `java.lang.String`
  type - field type - `java.lang.Class`
  unshared - if false, write/read field values in the same manner as writeObject/readObject; if true, write/read in the same manner as writeUnshared/readUnshared - `boolean`"
  (^ObjectStreamField [^java.lang.String name ^java.lang.Class type ^Boolean unshared]
    (new ObjectStreamField name type unshared))
  (^ObjectStreamField [^java.lang.String name ^java.lang.Class type]
    (new ObjectStreamField name type)))

(defn get-type
  "Get the type of the field.  If the type is non-primitive and this
   ObjectStreamField was obtained from a deserialized ObjectStreamClass instance, then Object.class is returned.
   Otherwise, the Class object for the type of the field is
   returned.

  returns: a Class object representing the type of the
            serializable field - `java.lang.Class<?>`"
  (^java.lang.Class [^ObjectStreamField this]
    (-> this (.getType))))

(defn get-type-string
  "Return the JVM type signature.

  returns: null if this field has a primitive type. - `java.lang.String`"
  (^java.lang.String [^ObjectStreamField this]
    (-> this (.getTypeString))))

(defn get-type-code
  "Returns character encoding of field type.  The encoding is as follows:


   B            byte
   C            char
   D            double
   F            float
   I            int
   J            long
   L            class or interface
   S            short
   Z            boolean
   [            array

  returns: the typecode of the serializable field - `char`"
  (^Character [^ObjectStreamField this]
    (-> this (.getTypeCode))))

(defn to-string
  "Return a string that describes this field.

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^ObjectStreamField this]
    (-> this (.toString))))

(defn unshared?
  "Returns boolean value indicating whether or not the serializable field
   represented by this ObjectStreamField instance is unshared.

  returns: true if this field is unshared - `boolean`"
  (^Boolean [^ObjectStreamField this]
    (-> this (.isUnshared))))

(defn primitive?
  "Return true if this field has a primitive type.

  returns: true if and only if this field corresponds to a primitive type - `boolean`"
  (^Boolean [^ObjectStreamField this]
    (-> this (.isPrimitive))))

(defn get-name
  "Get the name of this field.

  returns: a String representing the name of the serializable
            field - `java.lang.String`"
  (^java.lang.String [^ObjectStreamField this]
    (-> this (.getName))))

(defn get-offset
  "Offset of field within instance data.

  returns: the offset of this field - `int`"
  (^Integer [^ObjectStreamField this]
    (-> this (.getOffset))))

(defn compare-to
  "Compare this field with another ObjectStreamField.  Return
   -1 if this is smaller, 0 if equal, 1 if greater.  Types that are
   primitives are `smaller` than object types.  If equal, the field names
   are compared.

  obj - the object to be compared. - `java.lang.Object`

  returns: a negative integer, zero, or a positive integer as this object
            is less than, equal to, or greater than the specified object. - `int`"
  (^Integer [^ObjectStreamField this ^java.lang.Object obj]
    (-> this (.compareTo obj))))

