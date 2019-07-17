(ns jdk.sql.Array
  "The mapping in the Java programming language for the SQL type
  ARRAY.
  By default, an Array value is a transaction-duration
  reference to an SQL ARRAY value.  By default, an Array
  object is implemented using an SQL LOCATOR(array) internally, which
  means that an Array object contains a logical pointer
  to the data in the SQL ARRAY value rather
  than containing the ARRAY value's data.

  The Array interface provides methods for bringing an SQL
  ARRAY value's data to the client as either an array or a
  ResultSet object.
  If the elements of the SQL ARRAY
  are a UDT, they may be custom mapped.  To create a custom mapping,
  a programmer must do two things:

  create a class that implements the SQLData
  interface for the UDT to be custom mapped.
  make an entry in a type map that contains

    the fully-qualified SQL type name of the UDT
    the Class object for the class implementing
        SQLData



  When a type map with an entry for
  the base type is supplied to the methods getArray
  and getResultSet, the mapping
  it contains will be used to map the elements of the ARRAY value.
  If no type map is supplied, which would typically be the case,
  the connection's type map is used by default.
  If the connection's type map or a type map supplied to a method has no entry
  for the base type, the elements are mapped according to the standard mapping.

  All methods on the Array interface must be fully implemented if the
  JDBC driver supports the data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Array]))

(defn get-base-type-name
  "Retrieves the SQL type name of the elements in
   the array designated by this Array object.
   If the elements are a built-in type, it returns
   the database-specific type name of the elements.
   If the elements are a user-defined type (UDT),
   this method returns the fully-qualified SQL type name.

  returns: a String that is the database-specific
   name for a built-in base type; or the fully-qualified SQL type
   name for a base type that is a UDT - `java.lang.String`

  throws: java.sql.SQLException - if an error occurs while attempting to access the type name"
  ([^. this]
    (-> this (.getBaseTypeName))))

(defn get-base-type
  "Retrieves the JDBC type of the elements in the array designated
   by this Array object.

  returns: a constant from the class Types that is
   the type code for the elements in the array designated by this
   Array object - `int`

  throws: java.sql.SQLException - if an error occurs while attempting to access the base type"
  ([^. this]
    (-> this (.getBaseType))))

(defn get-array
  "Retreives a slice of the SQL ARRAY value
   designated by this Array object, beginning with the specified
   index and containing up to count
   successive elements of the SQL array.

   This method uses
   the specified map for type map customizations
   unless the base type of the array does not match a user-defined
   type in map, in which case it
   uses the standard mapping. This version of the method
   getArray uses either the given type map or the standard mapping;
   it never uses the type map associated with the connection.

   Note: When getArray is used to materialize
   a base type that maps to a primitive data type, then it is
   implementation-defined whether the array returned is an array of
   that primitive data type or an array of Object.

  index - the array index of the first element to retrieve; the first element is at index 1 - `long`
  count - the number of successive SQL array elements to retrieve - `int`
  map - a java.util.Map object that contains SQL type names and the classes in the Java programming language to which they are mapped - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: an array containing up to count
   consecutive elements of the SQL ARRAY value designated by this
   Array object, beginning with element
   index - `java.lang.Object`

  throws: java.sql.SQLException - if an error occurs while attempting to access the array"
  ([^. this ^Long index ^Integer count ^java.util.Map> map]
    (-> this (.getArray index count map)))
  ([^. this ^Long index ^Integer count]
    (-> this (.getArray index count)))
  ([^. this ^java.util.Map> map]
    (-> this (.getArray map)))
  ([^. this]
    (-> this (.getArray))))

(defn get-result-set
  "Retrieves a result set holding the elements of the subarray that
   starts at index index and contains up to
   count successive elements.
   This method uses
   the specified map for type map customizations
   unless the base type of the array does not match a user-defined
   type in map, in which case it
   uses the standard mapping. This version of the method
   getResultSet uses either the given type map or the standard mapping;
   it never uses the type map associated with the connection.

   The result set has one row for each element of the SQL array
   designated by this object, with the first row containing the
   element at index index.  The result set has
   up to count rows in ascending order based on the
   indices.  Each row has two columns:  The second column stores
   the element value; the first column stores the index into the
   array for that element.

  index - the array index of the first element to retrieve; the first element is at index 1 - `long`
  count - the number of successive SQL array elements to retrieve - `int`
  map - the Map object that contains the mapping of SQL type names to classes in the Java(tm) programming language - `java.util.Map<java.lang.String,java.lang.Class<?>>`

  returns: a ResultSet object containing up to
   count consecutive elements of the SQL array
   designated by this Array object, starting at
   index index. - `java.sql.ResultSet`

  throws: java.sql.SQLException - if an error occurs while attempting to access the array"
  ([^. this ^Long index ^Integer count ^java.util.Map> map]
    (-> this (.getResultSet index count map)))
  ([^. this ^Long index ^Integer count]
    (-> this (.getResultSet index count)))
  ([^. this ^java.util.Map> map]
    (-> this (.getResultSet map)))
  ([^. this]
    (-> this (.getResultSet))))

(defn free
  "This method frees the Array object and releases the resources that
   it holds. The object is invalid once the free
   method is called.

   After free has been called, any attempt to invoke a
   method other than free will result in a SQLException
   being thrown.  If free is called multiple times, the subsequent
   calls to free are treated as a no-op.

  throws: java.sql.SQLException - if an error occurs releasing the Array's resources"
  ([^. this]
    (-> this (.free))))

