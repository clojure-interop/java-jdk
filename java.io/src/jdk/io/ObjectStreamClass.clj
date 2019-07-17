(ns jdk.io.ObjectStreamClass
  "Serialization's descriptor for classes.  It contains the name and
  serialVersionUID of the class.  The ObjectStreamClass for a specific class
  loaded in this Java VM can be found/created using the lookup method.

  The algorithm to compute the SerialVersionUID is described in
  Object
  Serialization Specification, Section 4.6, Stream Unique Identifiers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ObjectStreamClass]))

(def *-no-fields
  "Static Constant.

  serialPersistentFields value indicating no serializable fields

  type: java.io.ObjectStreamField[]"
  ObjectStreamClass/NO_FIELDS)

(defn *lookup
  "Find the descriptor for a class that can be serialized.  Creates an
   ObjectStreamClass instance if one does not exist yet for class. Null is
   returned if the specified class does not implement java.io.Serializable
   or java.io.Externalizable.

  cl - class for which to get the descriptor - `java.lang.Class<?>`

  returns: the class descriptor for the specified class - `java.io.ObjectStreamClass`"
  ([cl]
    (ObjectStreamClass/lookup cl)))

(defn *lookup-any
  "Returns the descriptor for any class, regardless of whether it
   implements Serializable.

  cl - class for which to get the descriptor - `java.lang.Class<?>`

  returns: the class descriptor for the specified class - `java.io.ObjectStreamClass`"
  ([cl]
    (ObjectStreamClass/lookupAny cl)))

(defn get-name
  "Returns the name of the class described by this descriptor.
   This method returns the name of the class in the format that
   is used by the Class.getName() method.

  returns: a string representing the name of the class - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-serial-version-uid
  "Return the serialVersionUID for this class.  The serialVersionUID
   defines a set of classes all with the same name that have evolved from a
   common root class and agree to be serialized and deserialized using a
   common format.  NonSerializable classes have a serialVersionUID of 0L.

  returns: the SUID of the class described by this descriptor - `long`"
  ([this]
    (-> this (.getSerialVersionUID))))

(defn for-class
  "Return the class in the local VM that this version is mapped to.  Null
   is returned if there is no corresponding local class.

  returns: the Class instance that this descriptor represents - `java.lang.Class<?>`"
  ([this]
    (-> this (.forClass))))

(defn get-fields
  "Return an array of the fields of this serializable class.

  returns: an array containing an element for each persistent field of
            this class. Returns an array of length zero if there are no
            fields. - `java.io.ObjectStreamField[]`"
  ([this]
    (-> this (.getFields))))

(defn get-field
  "Get the field of this class by name.

  name - the name of the data field to look for - `java.lang.String`

  returns: The ObjectStreamField object of the named field or null if
            there is no such named field. - `java.io.ObjectStreamField`"
  ([this name]
    (-> this (.getField name))))

(defn to-string
  "Return a string describing this ObjectStreamClass.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

