(ns javax.sql.rowset.serial.SerialArray
  "A serialized version of an Array
  object, which is the mapping in the Java programming language of an SQL
  ARRAY value.

  The SerialArray class provides a constructor for creating
  a SerialArray instance from an Array object,
  methods for getting the base type and the SQL name for the base type, and
  methods for copying all or part of a SerialArray object.


  Note: In order for this class to function correctly, a connection to the
  data source
  must be available in order for the SQL Array object to be
  materialized (have all of its elements brought to the client server)
  if necessary. At this time, logical pointers to the data in the data source,
  such as locators, are not currently supported.

   Thread safety

  A SerialArray is not safe for use by multiple concurrent threads.  If a
  SerialArray is to be used by more than one thread then access to the
  SerialArray should be controlled by appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialArray]))

(defn ->serial-array
  "Constructor.

  Constructs a new SerialArray object from the given
   Array object, using the given type map for the custom
   mapping of each element when the elements are SQL UDTs.

   This method does custom mapping if the array elements are a UDT
   and the given type map has an entry for that UDT.
   Custom mapping is recursive,
   meaning that if, for instance, an element of an SQL structured type
   is an SQL structured type that itself has an element that is an SQL
   structured type, each structured type that has a custom mapping will be
   mapped according to the given type map.

   The new SerialArray
   object contains the same elements as the Array object
   from which it is built, except when the base type is the SQL type
   STRUCT, ARRAY, BLOB,
   CLOB, DATALINK or JAVA_OBJECT.
   In this case, each element in the new
   SerialArray object is the appropriate serialized form,
   that is, a SerialStruct, SerialArray,
   SerialBlob, SerialClob,
   SerialDatalink, or SerialJavaObject object.

   Note: (1) The Array object from which a SerialArray
   object is created must have materialized the SQL ARRAY value's
   data on the client before it is passed to the constructor.  Otherwise,
   the new SerialArray object will contain no data.

   Note: (2) If the Array contains java.sql.Types.JAVA_OBJECT
   types, the SerialJavaObject constructor is called where checks
   are made to ensure this object is serializable.

   Note: (3) The Array object supplied to this constructor cannot
   return null for any Array.getArray() methods.
   SerialArray cannot serialize null array values.

  array - the Array object to be serialized - `java.sql.Array`
  map - a java.util.Map object in which each entry consists of 1) a String object giving the fully qualified name of a UDT (an SQL structured type or distinct type) and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped. The map parameter does not have any effect for Blob, Clob, DATALINK, or JAVA_OBJECT types. - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs serializing the Array object"
  ([array map]
    (new SerialArray array map))
  ([array]
    (new SerialArray array)))

(defn free
  "This method frees the SeriableArray object and releases the
   resources that it holds. The object is invalid once the free
   method is called.  If free is called multiple times, the
   subsequent calls to free are treated as a no-op.

  throws: java.sql.SQLException - if an error occurs releasing the SerialArray's resources"
  ([this]
    (-> this (.free))))

(defn get-array
  "Returns a new array that is a copy of a slice
   of this SerialArray object, starting with the
   element at the given index and containing the given number
   of consecutive elements.

   This method does custom mapping if the array elements are a UDT
   and the given type map has an entry for that UDT.
   Custom mapping is recursive,
   meaning that if, for instance, an element of an SQL structured type
   is an SQL structured type that itself has an element that is an SQL
   structured type, each structured type that has a custom mapping will be
   mapped according to the given type map.

  index - the index into this SerialArray object of the first element to be copied; the index of the first element in the array is 0 - `long`
  count - the number of consecutive elements to be copied, starting at the given index - `int`
  map - a java.util.Map object in which each entry consists of 1) a String object giving the fully qualified name of a UDT and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: a copy of the designated elements in this SerialArray
           object as an Object in the Java programming language - `java.lang.Object`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs; if free had previously been called on this object"
  ([this index count map]
    (-> this (.getArray index count map)))
  ([this index count]
    (-> this (.getArray index count)))
  ([this map]
    (-> this (.getArray map)))
  ([this]
    (-> this (.getArray))))

(defn get-base-type
  "Retrieves the SQL type of the elements in this SerialArray
   object.  The int returned is one of the constants in the class
   java.sql.Types.

  returns: one of the constants in java.sql.Types, indicating
           the SQL type of the elements in this SerialArray object - `int`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs; if free had previously been called on this object"
  ([this]
    (-> this (.getBaseType))))

(defn get-base-type-name
  "Retrieves the DBMS-specific type name for the elements in this
   SerialArray object.

  returns: the SQL type name used by the DBMS for the base type of this
           SerialArray object - `java.lang.String`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs; if free had previously been called on this object"
  ([this]
    (-> this (.getBaseTypeName))))

(defn get-result-set
  "Retrieves a result set holding the elements of the subarray that starts at
   Retrieves a ResultSet object that contains a subarray of the
   elements in this SerialArray object, starting at
   index index and containing up to count successive
   elements. This method uses
   the specified map for type map customizations unless the base type of the
   array does not match a user-defined type (UDT) in map, in
   which case it uses the
   standard mapping. This version of the method getResultSet uses
   either the given type map or the standard mapping; it never uses the type
   map associated with the connection.

  index - the index into this SerialArray object of the first element to be copied; the index of the first element in the array is 0 - `long`
  count - the number of consecutive elements to be copied, starting at the given index - `int`
  map - a java.util.Map object in which each entry consists of 1) a String object giving the fully qualified name of a UDT and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: a ResultSet object containing the designated
           elements in this SerialArray object, with a
           separate row for each element - `java.sql.ResultSet`

  throws: javax.sql.rowset.serial.SerialException - if called with the cause set to UnsupportedOperationException"
  ([this index count map]
    (-> this (.getResultSet index count map)))
  ([this index count]
    (-> this (.getResultSet index count)))
  ([this map]
    (-> this (.getResultSet map)))
  ([this]
    (-> this (.getResultSet))))

(defn equals
  "Compares this SerialArray to the specified object.  The result is true if and only if the argument is not null and is a SerialArray object whose elements are identical to this object's elements

  obj - The object to compare this SerialArray against - `java.lang.Object`

  returns: true if the given object represents a SerialArray
            equivalent to this SerialArray, false otherwise - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code for this SerialArray. The hash code for a
   SerialArray object is computed using the hash codes
   of the elements of the  SerialArray object

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn clone
  "Returns a clone of this SerialArray. The copy will contain a
   reference to a clone of the underlying objects array, not a reference
   to the original underlying object array of this SerialArray object.

  returns: a clone of this SerialArray - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

