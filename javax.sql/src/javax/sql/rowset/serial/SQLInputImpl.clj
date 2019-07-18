(ns javax.sql.rowset.serial.SQLInputImpl
  "An input stream used for custom mapping user-defined types (UDTs).
  An SQLInputImpl object is an input stream that contains a
  stream of values that are the attributes of a UDT.

  This class is used by the driver behind the scenes when the method
  getObject is called on an SQL structured or distinct type
  that has a custom mapping; a programmer never invokes
  SQLInputImpl methods directly. They are provided here as a
  convenience for those who write RowSet implementations.

  The SQLInputImpl class provides a set of
  reader methods analogous to the ResultSet getter
  methods.  These methods make it possible to read the values in an
  SQLInputImpl object.

  The method wasNull is used to determine whether the
  the last value read was SQL NULL.
  When the method getObject is called with an
  object of a class implementing the interface SQLData,
  the JDBC driver calls the method SQLData.getSQLType
  to determine the SQL type of the UDT being custom mapped. The driver
  creates an instance of SQLInputImpl, populating it with the
  attributes of the UDT.  The driver then passes the input
  stream to the method SQLData.readSQL, which in turn
  calls the SQLInputImpl reader methods
  to read the attributes from the input stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SQLInputImpl]))

(defn ->sql-input-impl
  "Constructor.

  Creates an SQLInputImpl object initialized with the
   given array of attributes and the given type map. If any of the
   attributes is a UDT whose name is in an entry in the type map,
   the attribute will be mapped according to the corresponding
   SQLData implementation.

  attributes - an array of Object instances in which each element is an attribute of a UDT. The order of the attributes in the array is the same order in which the attributes were defined in the UDT definition. - `java.lang.Object[]`
  map - a java.util.Map object containing zero or more entries, with each entry consisting of 1) a String giving the fully qualified name of the UDT and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped - `java.util.Map`

  throws: java.sql.SQLException - if the attributes or the map is a null value"
  (^SQLInputImpl [attributes ^java.util.Map map]
    (new SQLInputImpl attributes map)))

(defn read-object
  "Retrieves the value at the head of this SQLInputImpl
   object as an Object in the Java programming language.  The
   actual type of the object returned is determined by the default
   mapping of SQL types to types in the Java programming language unless
   there is a custom mapping, in which case the type of the object
   returned is determined by this stream's type map.

   The JDBC technology-enabled driver registers a type map with the stream
   before passing the stream to the application.

   When the datum at the head of the stream is an SQL NULL,
   this method returns null.  If the datum is an SQL
   structured or distinct type with a custom mapping, this method
   determines the SQL type of the datum at the head of the stream,
   constructs an object of the appropriate class, and calls the method
   SQLData.readSQL on that object. The readSQL
   method then calls the appropriate SQLInputImpl.readXXX
   methods to retrieve the attribute values from the stream.

  returns: the value at the head of the stream as an Object
           in the Java programming language; null if
           the value is SQL NULL - `java.lang.Object`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.lang.Object [^SQLInputImpl this]
    (-> this (.readObject))))

(defn read-blob
  "Retrieves the BLOB value at the head of this
   SQLInputImpl object as a Blob object
   in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: a Blob object representing the SQL
           BLOB value at the head of this stream;
           if the value is SQL NULL, return
           null - `java.sql.Blob`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.sql.Blob [^SQLInputImpl this]
    (-> this (.readBlob))))

(defn read-bytes
  "Retrieves the next attribute in this SQLInputImpl object
   as an array of bytes.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `byte[]`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  ([^SQLInputImpl this]
    (-> this (.readBytes))))

(defn read-ascii-stream
  "Returns the next attribute in this SQLInputImpl object
   as a stream of ASCII characters.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: the attribute; if the value is SQL NULL,
   return null - `java.io.InputStream`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.io.InputStream [^SQLInputImpl this]
    (-> this (.readAsciiStream))))

(defn read-timestamp
  "Retrieves the next attribute in this SQLInputImpl object as
   a java.sql.Timestamp object.

  returns: the attribute; if the value is SQL NULL, return
   null - `java.sql.Timestamp`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.sql.Timestamp [^SQLInputImpl this]
    (-> this (.readTimestamp))))

(defn read-byte
  "Retrieves the next attribute in this SQLInputImpl object as
   a byte in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData
   implementation.

  returns: the next attribute in this SQLInputImpl object;
       if the value is SQL NULL, return null - `byte`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no further values in the stream"
  (^Byte [^SQLInputImpl this]
    (-> this (.readByte))))

(defn read-float
  "Retrieves the next attribute in this SQLInputImpl object
   as a float in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `float`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  (^Float [^SQLInputImpl this]
    (-> this (.readFloat))))

(defn read-character-stream
  "Retrieves the next attribute in this SQLInputImpl object
   as a stream of Unicode characters.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: the attribute; if the value is SQL NULL, return null - `java.io.Reader`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.io.Reader [^SQLInputImpl this]
    (-> this (.readCharacterStream))))

(defn read-sqlxml
  "Reads an SQL XML value from the stream and returns it as a
   SQLXML object in the Java programming language.

  returns: a SQLXML object representing data of the SQL XML value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.SQLXML`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.SQLXML [^SQLInputImpl this]
    (-> this (.readSQLXML))))

(defn read-n-clob
  "Reads an SQL NCLOB value from the stream and returns it as a
   Clob object in the Java programming language.

  returns: a NClob object representing data of the SQL NCLOB value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.NClob`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.NClob [^SQLInputImpl this]
    (-> this (.readNClob))))

(defn read-boolean
  "Retrieves the next attribute in this SQLInputImpl object as
   a boolean in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData
   implementation.

  returns: the next attribute in this SQLInputImpl object;
       if the value is SQL NULL, return null - `boolean`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no further values in the stream."
  (^Boolean [^SQLInputImpl this]
    (-> this (.readBoolean))))

(defn read-int
  "Retrieves the next attribute in this SQLInputImpl object
   as an int in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `int`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  (^Integer [^SQLInputImpl this]
    (-> this (.readInt))))

(defn read-string
  "Retrieves the next attribute in this SQLInputImpl object as
   a String in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData
   implementation.

  returns: the next attribute in this SQLInputImpl object;
       if the value is SQL NULL, return null - `java.lang.String`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no further values in the stream."
  (^java.lang.String [^SQLInputImpl this]
    (-> this (.readString))))

(defn read-long
  "Retrieves the next attribute in this SQLInputImpl object
   as a long in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `long`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  (^Long [^SQLInputImpl this]
    (-> this (.readLong))))

(defn read-clob
  "Retrieves the CLOB value at the head of this
   SQLInputImpl object as a Clob object
   in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: a Clob object representing the SQL
           CLOB value at the head of the stream;
           if the value is SQL NULL, return
           null - `java.sql.Clob`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.sql.Clob [^SQLInputImpl this]
    (-> this (.readClob))))

(defn read-url
  "Reads an SQL DATALINK value from the stream and
   returns it as an URL object in the Java programming
   language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: an URL object representing the SQL
           DATALINK value at the head of the stream; *
           if the value is SQL NULL, return
           null - `java.net.URL`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.net.URL [^SQLInputImpl this]
    (-> this (.readURL))))

(defn read-binary-stream
  "Returns the next attribute in this SQLInputImpl object
   as a stream of uninterpreted bytes.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: the attribute; if the value is SQL NULL, return
   null - `java.io.InputStream`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.io.InputStream [^SQLInputImpl this]
    (-> this (.readBinaryStream))))

(defn was-null
  "Ascertains whether the last value read from this
   SQLInputImpl object was null.

  returns: true if the SQL value read most recently was
           null; otherwise, false; by default it
           will return false - `boolean`

  throws: java.sql.SQLException - if an error occurs determining the last value read was a null value or not;"
  (^Boolean [^SQLInputImpl this]
    (-> this (.wasNull))))

(defn read-big-decimal
  "Retrieves the next attribute in this SQLInputImpl object
   as a java.math.BigDecimal.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `java.math.BigDecimal`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  (^java.math.BigDecimal [^SQLInputImpl this]
    (-> this (.readBigDecimal))))

(defn read-ref
  "Retrieves the value at the head of this SQLInputImpl object
   as a Ref object in the Java programming language.

  returns: a Ref object representing the SQL
           REF value at the head of the stream; if the value
           is SQL NULL return null - `java.sql.Ref`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.sql.Ref [^SQLInputImpl this]
    (-> this (.readRef))))

(defn read-row-id
  "Reads an SQL ROWID value from the stream and returns it as a
   RowId object in the Java programming language.

  returns: a RowId object representing data of the SQL ROWID value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.RowId`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.sql.RowId [^SQLInputImpl this]
    (-> this (.readRowId))))

(defn read-n-string
  "Reads the next attribute in the stream and returns it as a String
   in the Java programming language. It is intended for use when
   accessing  NCHAR,NVARCHAR
   and LONGNVARCHAR columns.

  returns: the attribute; if the value is SQL NULL, returns null - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  (^java.lang.String [^SQLInputImpl this]
    (-> this (.readNString))))

(defn read-short
  "Retrieves the next attribute in this SQLInputImpl object
   as a short in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `short`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  (^Short [^SQLInputImpl this]
    (-> this (.readShort))))

(defn read-array
  "Reads an SQL ARRAY value from the stream and
   returns it as an Array object in the Java programming
   language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: an Array object representing the SQL
           ARRAY value at the head of the stream; *
           if the value is SQL NULL, return
           null - `java.sql.Array`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.sql.Array [^SQLInputImpl this]
    (-> this (.readArray))))

(defn read-time
  "Retrieves the next attribute in this SQLInputImpl object as
   a java.sql.Time object.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type as this responsibility is delegated
   to the UDT mapping as implemented by a SQLData
   implementation.

  returns: the attribute; if the value is SQL NULL, return
   null - `java.sql.Time`

  throws: java.sql.SQLException - if the read position is located at an invalid position; or if there are no further values in the stream."
  (^java.sql.Time [^SQLInputImpl this]
    (-> this (.readTime))))

(defn read-double
  "Retrieves the next attribute in this SQLInputImpl object
   as a double in the Java programming language.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `double`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  (^Double [^SQLInputImpl this]
    (-> this (.readDouble))))

(defn read-date
  "Retrieves the next attribute in this SQLInputImpl as
   a java.sql.Date object.

   This method does not perform type-safe checking to determine if the
   returned type is the expected type; this responsibility is delegated
   to the UDT mapping as defined by a SQLData implementation.

  returns: the next attribute in this SQLInputImpl object;
         if the value is SQL NULL, return null - `java.sql.Date`

  throws: java.sql.SQLException - if the read position is located at an invalid position or if there are no more values in the stream"
  (^java.sql.Date [^SQLInputImpl this]
    (-> this (.readDate))))

