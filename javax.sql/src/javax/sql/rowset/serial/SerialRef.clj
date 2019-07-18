(ns javax.sql.rowset.serial.SerialRef
  "A serialized mapping of a Ref object, which is the mapping in the
  Java programming language of an SQL REF value.

  The SerialRef class provides a constructor  for
  creating a SerialRef instance from a Ref
  object and provides methods for getting and setting the Ref object.

   Thread safety

  A SerialRef is not safe for use by multiple concurrent threads.  If a
  SerialRef is to be used by more than one thread then access to the SerialRef
  should be controlled by appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialRef]))

(defn ->serial-ref
  "Constructor.

  Constructs a SerialRef object from the given Ref
   object.

  ref - a Ref object; cannot be null - `java.sql.Ref`

  throws: java.sql.SQLException - if a database access occurs; if ref is null; or if the Ref object returns a null value base type name."
  (^SerialRef [^java.sql.Ref ref]
    (new SerialRef ref)))

(defn get-base-type-name
  "Returns a string describing the base type name of the Ref.

  returns: a string of the base type name of the Ref - `java.lang.String`

  throws: javax.sql.rowset.serial.SerialException - in no Ref object has been set"
  (^java.lang.String [^SerialRef this]
    (-> this (.getBaseTypeName))))

(defn get-object
  "Returns an Object representing the SQL structured type
   to which this SerialRef object refers.  The attributes
   of the structured type are mapped according to the given type map.

  map - a java.util.Map object containing zero or more entries, with each entry consisting of 1) a String giving the fully qualified name of a UDT and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped - `java.util.Map`

  returns: an object instance resolved from the Ref reference and mapped
          according to the supplied type map - `java.lang.Object`

  throws: javax.sql.rowset.serial.SerialException - if an error is encountered in the reference resolution"
  (^java.lang.Object [^SerialRef this ^java.util.Map map]
    (-> this (.getObject map)))
  (^java.lang.Object [^SerialRef this]
    (-> this (.getObject))))

(defn set-object
  "Sets the SQL structured type that this SerialRef object
   references to the given Object object.

  obj - an Object representing the SQL structured type to be referenced - `java.lang.Object`

  throws: javax.sql.rowset.serial.SerialException - if an error is encountered generating the the structured type referenced by this SerialRef object"
  ([^SerialRef this ^java.lang.Object obj]
    (-> this (.setObject obj))))

(defn equals
  "Compares this SerialRef to the specified object.  The result is true if and only if the argument is not null and is a SerialRef object that represents the same object as this
   object.

  obj - The object to compare this SerialRef against - `java.lang.Object`

  returns: true if the given object represents a SerialRef
            equivalent to this SerialRef, false otherwise - `boolean`"
  (^Boolean [^SerialRef this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code for this SerialRef.

  returns: a hash code value for this object. - `int`"
  (^Integer [^SerialRef this]
    (-> this (.hashCode))))

(defn clone
  "Returns a clone of this SerialRef.
   The underlying Ref object will be set to null.

  returns: a clone of this SerialRef - `java.lang.Object`"
  (^java.lang.Object [^SerialRef this]
    (-> this (.clone))))

