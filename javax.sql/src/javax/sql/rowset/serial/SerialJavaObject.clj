(ns javax.sql.rowset.serial.SerialJavaObject
  "A serializable mapping in the Java programming language of an SQL
  JAVA_OBJECT value. Assuming the Java object
  implements the Serializable interface, this class simply wraps the
  serialization process.

  If however, the serialization is not possible because
  the Java object is not immediately serializable, this class will
  attempt to serialize all non-static members to permit the object
  state to be serialized.
  Static or transient fields cannot be serialized; an attempt to serialize
  them will result in a SerialException object being thrown.

   Thread safety

  A SerialJavaObject is not safe for use by multiple concurrent threads.  If a
  SerialJavaObject is to be used by more than one thread then access to the
  SerialJavaObject should be controlled by appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialJavaObject]))

(defn ->serial-java-object
  "Constructor.

  Constructor for SerialJavaObject helper class.

  obj - the Java Object to be serialized - `java.lang.Object`

  throws: javax.sql.rowset.serial.SerialException - if the object is found not to be serializable"
  ([^java.lang.Object obj]
    (new SerialJavaObject obj)))

(defn get-object
  "Returns an Object that is a copy of this SerialJavaObject
   object.

  returns: a copy of this SerialJavaObject object as an
           Object in the Java programming language - `java.lang.Object`

  throws: javax.sql.rowset.serial.SerialException - if the instance is corrupt"
  ([^javax.sql.rowset.serial.SerialJavaObject this]
    (-> this (.getObject))))

(defn get-fields
  "Returns an array of Field objects that contains each
   field of the object that this helper class is serializing.

  returns: an array of Field objects - `java.lang.reflect.Field[]`

  throws: javax.sql.rowset.serial.SerialException - if an error is encountered accessing the serialized object"
  ([^javax.sql.rowset.serial.SerialJavaObject this]
    (-> this (.getFields))))

(defn equals
  "Compares this SerialJavaObject to the specified object.
   The result is true if and only if the argument
   is not null and is a SerialJavaObject
   object that is identical to this object

  o - The object to compare this SerialJavaObject against - `java.lang.Object`

  returns: true if the given object represents a SerialJavaObject
            equivalent to this SerialJavaObject, false otherwise - `boolean`"
  ([^javax.sql.rowset.serial.SerialJavaObject this ^java.lang.Object o]
    (-> this (.equals o))))

(defn hash-code
  "Returns a hash code for this SerialJavaObject. The hash code for a
   SerialJavaObject object is taken as the hash code of
   the Object it stores

  returns: a hash code value for this object. - `int`"
  ([^javax.sql.rowset.serial.SerialJavaObject this]
    (-> this (.hashCode))))

(defn clone
  "Returns a clone of this SerialJavaObject.

  returns: a clone of this SerialJavaObject - `java.lang.Object`"
  ([^javax.sql.rowset.serial.SerialJavaObject this]
    (-> this (.clone))))

