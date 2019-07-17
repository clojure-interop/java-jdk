(ns javax.sql.rowset.serial.SerialStruct
  "A serialized mapping in the Java programming language of an SQL
  structured type. Each attribute that is not already serialized
  is mapped to a serialized form, and if an attribute is itself
  a structured type, each of its attributes that is not already
  serialized is mapped to a serialized form.

  In addition, the structured type is custom mapped to a class in the
  Java programming language if there is such a mapping, as are
  its attributes, if appropriate.

  The SerialStruct class provides a constructor for creating
  an instance from a Struct object, a method for retrieving
  the SQL type name of the SQL structured type in the database, and methods
  for retrieving its attribute values.

   Thread safety

  A SerialStruct is not safe for use by multiple concurrent threads.  If a
  SerialStruct is to be used by more than one thread then access to the
  SerialStruct should be controlled by appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialStruct]))

(defn ->serial-struct
  "Constructor.

  Constructs a SerialStruct object from the given
   Struct object, using the given java.util.Map
   object for custom mapping the SQL structured type or any of its
   attributes that are SQL structured types.

  in - an instance of Struct - `java.sql.Struct`
  map - a java.util.Map object in which each entry consists of 1) a String object giving the fully qualified name of a UDT and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs"
  ([in map]
    (new SerialStruct in map)))

(defn get-sql-type-name
  "Retrieves the SQL type name for this SerialStruct
   object. This is the name used in the SQL definition of the
   structured type

  returns: a String object representing the SQL
           type name for the SQL structured type that this
           SerialStruct object represents - `java.lang.String`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs"
  ([this]
    (-> this (.getSQLTypeName))))

(defn get-attributes
  "Retrieves the attributes for the SQL structured type that
   this SerialStruct represents as an array of
   Object values, using the given type map for
   custom mapping if appropriate.

  map - a java.util.Map object in which each entry consists of 1) a String object giving the fully qualified name of a UDT and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: an array of Object values, with each
           element being an attribute of the SQL structured
           type that this SerialStruct object
           represents - `java.lang.Object[]`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs"
  ([this map]
    (-> this (.getAttributes map)))
  ([this]
    (-> this (.getAttributes))))

(defn equals
  "Compares this SerialStruct to the specified object.  The result is
   true if and only if the argument is not null and is a
   SerialStruct object whose attributes are identical to this
   object's attributes

  obj - The object to compare this SerialStruct against - `java.lang.Object`

  returns: true if the given object represents a SerialStruct
            equivalent to this SerialStruct, false otherwise - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code for this SerialStruct. The hash code for a
   SerialStruct object is computed using the hash codes
   of the attributes of the SerialStruct object and its
   SQLTypeName

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn clone
  "Returns a clone of this SerialStruct. The copy will contain a
   reference to a clone of the underlying attribs array, not a reference
   to the original underlying attribs array of this SerialStruct object.

  returns: a clone of this SerialStruct - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

