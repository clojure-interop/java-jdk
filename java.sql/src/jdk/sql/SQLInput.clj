(ns jdk.sql.SQLInput
  "An input stream that contains a stream of values representing an
  instance of an SQL structured type or an SQL distinct type.
  This interface, used only for custom mapping, is used by the driver
  behind the scenes, and a programmer never directly invokes
  SQLInput methods. The reader methods
  (readLong, readBytes, and so on)
  provide a way  for an implementation of the SQLData
   interface to read the values in an SQLInput object.
   And as described in SQLData, calls to reader methods must
  be made in the order that their corresponding attributes appear in the
  SQL definition of the type.
  The method wasNull is used to determine whether
  the last value read was SQL NULL.
  When the method getObject is called with an
  object of a class implementing the interface SQLData,
  the JDBC driver calls the method SQLData.getSQLType
  to determine the SQL type of the user-defined type (UDT)
  being custom mapped. The driver
  creates an instance of SQLInput, populating it with the
  attributes of the UDT.  The driver then passes the input
  stream to the method SQLData.readSQL, which in turn
  calls the SQLInput reader methods
  in its implementation for reading the
  attributes from the input stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLInput]))

(defn read-object
  "Reads the next attribute in the stream and returns it as an
   Object in the Java programming language. The
   actual type of the object returned is determined by the specified
   Java data type, and any customizations present in this
   stream's type map.

   A type map is registered with the stream by the JDBC driver before the
   stream is passed to the application.

   When the attribute at the head of the stream is an SQL NULL
   the method returns null. If the attribute is an SQL
   structured or distinct
   type, it determines the SQL type of the attribute at the head of the stream.
   If the stream's type map has an entry for that SQL type, the driver
   constructs an object of the appropriate class and calls the method
   SQLData.readSQL on that object, which reads additional data from the
   stream, using the protocol described for that method.

   The default implementation will throw SQLFeatureNotSupportedException

  type - Class representing the Java data type to convert the attribute to. - `java.lang.Class<T>`

  returns: the attribute at the head of the stream as an Object in the
   Java programming language;null if the attribute is SQL NULL - `default <T> T`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this ^java.lang.Class type]
    (-> this (.readObject type)))
  ([^java.sql.SQLInput this]
    (-> this (.readObject))))

(defn read-blob
  "Reads an SQL BLOB value from the stream and returns it as a
   Blob object in the Java programming language.

  returns: a Blob object representing data of the SQL BLOB value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.Blob`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readBlob))))

(defn read-bytes
  "Reads the next attribute in the stream and returns it as an array of bytes
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns null - `byte[]`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readBytes))))

(defn read-ascii-stream
  "Reads the next attribute in the stream and returns it as a stream of ASCII characters.

  returns: the attribute; if the value is SQL NULL, returns null - `java.io.InputStream`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readAsciiStream))))

(defn read-timestamp
  "Reads the next attribute in the stream and returns it as a java.sql.Timestamp object.

  returns: the attribute; if the value is SQL NULL, returns null - `java.sql.Timestamp`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readTimestamp))))

(defn read-byte
  "Reads the next attribute in the stream and returns it as a byte
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns 0 - `byte`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readByte))))

(defn read-float
  "Reads the next attribute in the stream and returns it as a float
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns 0 - `float`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readFloat))))

(defn read-character-stream
  "Reads the next attribute in the stream and returns it as a stream of Unicode characters.

  returns: the attribute; if the value is SQL NULL, returns null - `java.io.Reader`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readCharacterStream))))

(defn read-sqlxml
  "Reads an SQL XML value from the stream and returns it as a
   SQLXML object in the Java programming language.

  returns: a SQLXML object representing data of the SQL XML value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.SQLXML`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readSQLXML))))

(defn read-n-clob
  "Reads an SQL NCLOB value from the stream and returns it as a
   NClob object in the Java programming language.

  returns: a NClob object representing data of the SQL NCLOB value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.NClob`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readNClob))))

(defn read-boolean
  "Reads the next attribute in the stream and returns it as a boolean
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns false - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readBoolean))))

(defn read-int
  "Reads the next attribute in the stream and returns it as an int
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns 0 - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readInt))))

(defn read-string
  "Reads the next attribute in the stream and returns it as a String
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns null - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readString))))

(defn read-long
  "Reads the next attribute in the stream and returns it as a long
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns 0 - `long`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readLong))))

(defn read-clob
  "Reads an SQL CLOB value from the stream and returns it as a
   Clob object in the Java programming language.

  returns: a Clob object representing data of the SQL CLOB value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.Clob`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readClob))))

(defn read-url
  "Reads an SQL DATALINK value from the stream and returns it as a
   java.net.URL object in the Java programming language.

  returns: a java.net.URL object. - `java.net.URL`

  throws: java.sql.SQLException - if a database access error occurs, or if a URL is malformed"
  ([^java.sql.SQLInput this]
    (-> this (.readURL))))

(defn read-binary-stream
  "Reads the next attribute in the stream and returns it as a stream of uninterpreted
   bytes.

  returns: the attribute; if the value is SQL NULL, returns null - `java.io.InputStream`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readBinaryStream))))

(defn was-null
  "Retrieves whether the last value read was SQL NULL.

  returns: true if the most recently read SQL value was SQL
   NULL; false otherwise - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.wasNull))))

(defn read-big-decimal
  "Reads the next attribute in the stream and returns it as a java.math.BigDecimal
   object in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns null - `java.math.BigDecimal`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readBigDecimal))))

(defn read-ref
  "Reads an SQL REF value from the stream and returns it as a
   Ref object in the Java programming language.

  returns: a Ref object representing the SQL REF value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.Ref`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readRef))))

(defn read-row-id
  "Reads an SQL ROWID value from the stream and returns it as a
   RowId object in the Java programming language.

  returns: a RowId object representing data of the SQL ROWID value
   at the head of the stream; null if the value read is
   SQL NULL - `java.sql.RowId`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readRowId))))

(defn read-n-string
  "Reads the next attribute in the stream and returns it as a String
   in the Java programming language. It is intended for use when
   accessing  NCHAR,NVARCHAR
   and LONGNVARCHAR columns.

  returns: the attribute; if the value is SQL NULL, returns null - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readNString))))

(defn read-short
  "Reads the next attribute in the stream and returns it as a short
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns 0 - `short`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readShort))))

(defn read-array
  "Reads an SQL ARRAY value from the stream and returns it as an
   Array object in the Java programming language.

  returns: an Array object representing data of the SQL
   ARRAY value at the head of the stream; null
   if the value read is SQL NULL - `java.sql.Array`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readArray))))

(defn read-time
  "Reads the next attribute in the stream and returns it as a java.sql.Time object.

  returns: the attribute; if the value is SQL NULL, returns null - `java.sql.Time`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readTime))))

(defn read-double
  "Reads the next attribute in the stream and returns it as a double
   in the Java programming language.

  returns: the attribute; if the value is SQL NULL, returns 0 - `double`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readDouble))))

(defn read-date
  "Reads the next attribute in the stream and returns it as a java.sql.Date object.

  returns: the attribute; if the value is SQL NULL, returns null - `java.sql.Date`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^java.sql.SQLInput this]
    (-> this (.readDate))))

