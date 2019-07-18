(ns jdk.sql.SQLOutput
  "The output stream for writing the attributes of a user-defined
  type back to the database.  This interface, used
  only for custom mapping, is used by the driver, and its
  methods are never directly invoked by a programmer.
  When an object of a class implementing the interface
  SQLData is passed as an argument to an SQL statement, the
  JDBC driver calls the method SQLData.getSQLType to
  determine the  kind of SQL
  datum being passed to the database.
  The driver then creates an instance of SQLOutput and
  passes it to the method SQLData.writeSQL.
  The method writeSQL in turn calls the
  appropriate SQLOutput writer methods
  writeBoolean, writeCharacterStream, and so on)
  to write data from the SQLData object to
  the SQLOutput output stream as the
  representation of an SQL user-defined type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql SQLOutput]))

(defn write-date
  "Writes the next attribute to the stream as a java.sql.Date object.
   Writes the next attribute to the stream as a java.sql.Date object
   in the Java programming language.

  x - the value to pass to the database - `java.sql.Date`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Date x]
    (-> this (.writeDate x))))

(defn write-time
  "Writes the next attribute to the stream as a java.sql.Time object.
   Writes the next attribute to the stream as a java.sql.Date object
   in the Java programming language.

  x - the value to pass to the database - `java.sql.Time`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Time x]
    (-> this (.writeTime x))))

(defn write-url
  "Writes a SQL DATALINK value to the stream.

  x - a java.net.URL object representing the data of SQL DATALINK type - `java.net.URL`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.net.URL x]
    (-> this (.writeURL x))))

(defn write-bytes
  "Writes the next attribute to the stream as an array of bytes.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `byte[]`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this x]
    (-> this (.writeBytes x))))

(defn write-double
  "Writes the next attribute to the stream as a Java double.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `double`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^Double x]
    (-> this (.writeDouble x))))

(defn write-clob
  "Writes an SQL CLOB value to the stream.

  x - a Clob object representing data of an SQL CLOB value - `java.sql.Clob`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Clob x]
    (-> this (.writeClob x))))

(defn write-object
  "Writes to the stream the data contained in the given object. The
   object will be converted to the specified targetSqlType
   before being sent to the stream.

   When the object is null, this
   method writes an SQL NULL to the stream.

   If the object has a custom mapping (is of a class implementing the
   interface SQLData),
   the JDBC driver should call the method SQLData.writeSQL to
   write it to the SQL data stream.
   If, on the other hand, the object is of a class implementing
   Ref, Blob, Clob,  NClob,
    Struct, java.net.URL,
   or Array, the driver should pass it to the database as a
   value of the corresponding SQL type.

   The default implementation will throw SQLFeatureNotSupportedException

  x - the object containing the input parameter value - `java.lang.Object`
  target-sql-type - the SQL type to be sent to the database. - `java.sql.SQLType`

  returns: `default void`

  throws: java.sql.SQLException - if a database access error occurs or if the Java Object specified by x is an InputStream or Reader object and the value of the scale parameter is less than zero"
  ([^SQLOutput this ^java.lang.Object x ^java.sql.SQLType target-sql-type]
    (-> this (.writeObject x target-sql-type)))
  ([^SQLOutput this ^java.sql.SQLData x]
    (-> this (.writeObject x))))

(defn write-boolean
  "Writes the next attribute to the stream as a Java boolean.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `boolean`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^Boolean x]
    (-> this (.writeBoolean x))))

(defn write-long
  "Writes the next attribute to the stream as a Java long.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `long`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^Long x]
    (-> this (.writeLong x))))

(defn write-short
  "Writes the next attribute to the stream as a Java short.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `short`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^Short x]
    (-> this (.writeShort x))))

(defn write-binary-stream
  "Writes the next attribute to the stream as a stream of uninterpreted
   bytes.

  x - the value to pass to the database - `java.io.InputStream`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.io.InputStream x]
    (-> this (.writeBinaryStream x))))

(defn write-blob
  "Writes an SQL BLOB value to the stream.

  x - a Blob object representing data of an SQL BLOB value - `java.sql.Blob`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Blob x]
    (-> this (.writeBlob x))))

(defn write-array
  "Writes an SQL ARRAY value to the stream.

  x - an Array object representing data of an SQL ARRAY type - `java.sql.Array`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Array x]
    (-> this (.writeArray x))))

(defn write-string
  "Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.lang.String x]
    (-> this (.writeString x))))

(defn write-character-stream
  "Writes the next attribute to the stream as a stream of Unicode characters.

  x - the value to pass to the database - `java.io.Reader`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.io.Reader x]
    (-> this (.writeCharacterStream x))))

(defn write-struct
  "Writes an SQL structured type value to the stream.

  x - a Struct object representing data of an SQL structured type - `java.sql.Struct`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Struct x]
    (-> this (.writeStruct x))))

(defn write-n-string
  "Writes the next attribute to the stream as a String
   in the Java programming language. The driver converts this to a
   SQL NCHAR or
   NVARCHAR or LONGNVARCHAR value
   (depending on the argument's
   size relative to the driver's limits on NVARCHAR values)
   when it sends it to the stream.

  x - the value to pass to the database - `java.lang.String`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.lang.String x]
    (-> this (.writeNString x))))

(defn write-int
  "Writes the next attribute to the stream as a Java int.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `int`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^Integer x]
    (-> this (.writeInt x))))

(defn write-float
  "Writes the next attribute to the stream as a Java float.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `float`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^Float x]
    (-> this (.writeFloat x))))

(defn write-n-clob
  "Writes an SQL NCLOB value to the stream.

  x - a NClob object representing data of an SQL NCLOB value - `java.sql.NClob`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.NClob x]
    (-> this (.writeNClob x))))

(defn write-timestamp
  "Writes the next attribute to the stream as a java.sql.Timestamp object.
   Writes the next attribute to the stream as a java.sql.Date object
   in the Java programming language.

  x - the value to pass to the database - `java.sql.Timestamp`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Timestamp x]
    (-> this (.writeTimestamp x))))

(defn write-ascii-stream
  "Writes the next attribute to the stream as a stream of ASCII characters.

  x - the value to pass to the database - `java.io.InputStream`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.io.InputStream x]
    (-> this (.writeAsciiStream x))))

(defn write-sqlxml
  "Writes an SQL XML value to the stream.

  x - a SQLXML object representing data of an SQL XML value - `java.sql.SQLXML`

  throws: java.sql.SQLException - if a database access error occurs, the java.xml.transform.Result, Writer or OutputStream has not been closed for the SQLXML object or if there is an error processing the XML value. The getCause method of the exception may provide a more detailed exception, for example, if the stream does not contain valid XML."
  ([^SQLOutput this ^java.sql.SQLXML x]
    (-> this (.writeSQLXML x))))

(defn write-big-decimal
  "Writes the next attribute to the stream as a java.math.BigDecimal object.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `java.math.BigDecimal`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.math.BigDecimal x]
    (-> this (.writeBigDecimal x))))

(defn write-byte
  "Writes the next attribute to the stream as a Java byte.
   Writes the next attribute to the stream as a String
   in the Java programming language.

  x - the value to pass to the database - `byte`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^Byte x]
    (-> this (.writeByte x))))

(defn write-ref
  "Writes an SQL REF value to the stream.

  x - a Ref object representing data of an SQL REF value - `java.sql.Ref`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.Ref x]
    (-> this (.writeRef x))))

(defn write-row-id
  "Writes an SQL ROWID value to the stream.

  x - a RowId object representing data of an SQL ROWID value - `java.sql.RowId`

  throws: java.sql.SQLException - if a database access error occurs"
  ([^SQLOutput this ^java.sql.RowId x]
    (-> this (.writeRowId x))))

