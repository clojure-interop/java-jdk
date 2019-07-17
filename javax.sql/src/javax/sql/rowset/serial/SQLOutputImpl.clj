(ns javax.sql.rowset.serial.SQLOutputImpl
  "The output stream for writing the attributes of a
  custom-mapped user-defined type (UDT) back to the database.
  The driver uses this interface internally, and its
  methods are never directly invoked by an application programmer.

  When an application calls the
  method PreparedStatement.setObject, the driver
  checks to see whether the value to be written is a UDT with
  a custom mapping.  If it is, there will be an entry in a
  type map containing the Class object for the
  class that implements SQLData for this UDT.
  If the value to be written is an instance of SQLData,
  the driver will create an instance of SQLOutputImpl
  and pass it to the method SQLData.writeSQL.
  The method writeSQL in turn calls the
  appropriate SQLOutputImpl.writeXXX methods
  to write data from the SQLData object to
  the SQLOutputImpl output stream as the
  representation of an SQL user-defined type."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SQLOutputImpl]))

(defn ->sql-output-impl
  "Constructor.

  Creates a new SQLOutputImpl object
   initialized with the given vector of attributes and
   type map.  The driver will use the type map to determine
   which SQLData.writeSQL method to invoke.
   This method will then call the appropriate
   SQLOutputImpl writer methods in order and
   thereby write the attributes to the new output stream.

  attributes - a Vector object containing the attributes of the UDT to be mapped to one or more objects in the Java programming language - `java.util.Vector<?>`
  map - a java.util.Map object containing zero or more entries, with each entry consisting of 1) a String giving the fully qualified name of a UDT and 2) the Class object for the SQLData implementation that defines how the UDT is to be mapped - `java.util.Map<java.lang.String,?>`

  throws: java.sql.SQLException - if the attributes or the map is a null value"
  ([attributes map]
    (new SQLOutputImpl attributes map)))

(defn write-date
  "Writes a java.sql.Date object in the Java programming
   language to this SQLOutputImpl object. The driver converts
   it to an SQL DATE before returning it to the database.

  x - the value to pass to the database - `java.sql.Date`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeDate x))))

(defn write-time
  "Writes a java.sql.Time object in the Java programming
   language to this SQLOutputImpl object. The driver converts
   it to an SQL TIME before returning it to the database.

  x - the value to pass to the database - `java.sql.Time`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeTime x))))

(defn write-url
  "Writes an java.sql.Type.DATALINK object in the Java
   programming language to this SQLOutputImpl object. The
   driver converts this value to a serializable SerialDatalink
   SQL DATALINK value before return it to the database.

  url - an object representing a SQL DATALINK value - `java.net.URL`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this url]
    (-> this (.writeURL url))))

(defn write-bytes
  "Writes an array of bytes in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL VARBINARY or LONGVARBINARY
   before returning it to the database.

  x - the value to pass to the database - `byte[]`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeBytes x))))

(defn write-double
  "Writes a double in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL DOUBLE before returning it to the database.

  x - the value to pass to the database - `double`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeDouble x))))

(defn write-clob
  "Writes a Clob object in the Java programming language
   to this SQLOutputImpl object.  The driver converts
   it to a serializable SerialClob SQL CLOB value
   before returning it to the database.

  x - an object representing an SQL CLOB value - `java.sql.Clob`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeClob x))))

(defn write-object
  "Writes to the stream the data contained in the given
   SQLData object.
   When the SQLData object is null, this
   method writes an SQL NULL to the stream.
   Otherwise, it calls the SQLData.writeSQL
   method of the given object, which
   writes the object's attributes to the stream.

   The implementation of the method SQLData.writeSQ
   calls the appropriate SQLOutputImpl.writeXXX method(s)
   for writing each of the object's attributes in order.
   The attributes must be read from an SQLInput
   input stream and written to an SQLOutputImpl
   output stream in the same order in which they were
   listed in the SQL definition of the user-defined type.

  x - the object representing data of an SQL structured or distinct type - `java.sql.SQLData`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeObject x))))

(defn write-boolean
  "Writes a boolean in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL BIT before returning it to the database.

  x - the value to pass to the database - `boolean`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeBoolean x))))

(defn write-long
  "Writes a long in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL BIGINT before returning it to the database.

  x - the value to pass to the database - `long`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeLong x))))

(defn write-short
  "Writes a short in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL SMALLINT before returning it to the database.

  x - the value to pass to the database - `short`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeShort x))))

(defn write-binary-stream
  "Writes a stream of uninterpreted bytes to this SQLOutputImpl
   object.

  x - the value to pass to the database - `java.io.InputStream`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeBinaryStream x))))

(defn write-blob
  "Writes a Blob object in the Java programming language
   to this SQLOutputImpl object.  The driver converts
   it to a serializable SerialBlob SQL BLOB value
   before returning it to the database.

  x - an object representing an SQL BLOB value - `java.sql.Blob`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeBlob x))))

(defn write-array
  "Writes an Array object in the Java
   programming language to this SQLOutputImpl
   object. The driver converts this value to a serializable
   SerialArray SQL ARRAY
   value before returning it to the database.

  x - an object representing an SQL ARRAY value - `java.sql.Array`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeArray x))))

(defn write-string
  "Writes a String in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL CHAR, VARCHAR, or
   LONGVARCHAR before returning it to the database.

  x - the value to pass to the database - `java.lang.String`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeString x))))

(defn write-character-stream
  "Writes a stream of Unicode characters to this
   SQLOutputImpl object. The driver will do any necessary
   conversion from Unicode to the database CHAR format.

  x - the value to pass to the database - `java.io.Reader`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeCharacterStream x))))

(defn write-struct
  "Writes a Struct object in the Java
   programming language to this SQLOutputImpl
   object. The driver converts this value to an SQL structured type
   before returning it to the database.

   This method should be used when an SQL structured type has been
   mapped to a Struct object in the Java programming
   language (the standard mapping).  The method
   writeObject should be used if an SQL structured type
   has been custom mapped to a class in the Java programming language.

  x - an object representing the attributes of an SQL structured type - `java.sql.Struct`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
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
  ([this x]
    (-> this (.writeNString x))))

(defn write-int
  "Writes an int in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL INTEGER before returning it to the database.

  x - the value to pass to the database - `int`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeInt x))))

(defn write-float
  "Writes a float in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL REAL before returning it to the database.

  x - the value to pass to the database - `float`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeFloat x))))

(defn write-n-clob
  "Writes an SQL NCLOB value to the stream.

  x - a NClob object representing data of an SQL NCLOB value - `java.sql.NClob`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this x]
    (-> this (.writeNClob x))))

(defn write-timestamp
  "Writes a java.sql.Timestamp object in the Java programming
   language to this SQLOutputImpl object. The driver converts
   it to an SQL TIMESTAMP before returning it to the database.

  x - the value to pass to the database - `java.sql.Timestamp`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeTimestamp x))))

(defn write-ascii-stream
  "Writes a stream of ASCII characters to this
   SQLOutputImpl object. The driver will do any necessary
   conversion from ASCII to the database CHAR format.

  x - the value to pass to the database - `java.io.InputStream`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeAsciiStream x))))

(defn write-sqlxml
  "Writes an SQL XML value to the stream.

  x - a SQLXML object representing data of an SQL XML value - `java.sql.SQLXML`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this x]
    (-> this (.writeSQLXML x))))

(defn write-big-decimal
  "Writes a java.math.BigDecimal object in the Java programming
   language to this SQLOutputImpl object. The driver converts
   it to an SQL NUMERIC before returning it to the database.

  x - the value to pass to the database - `java.math.BigDecimal`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeBigDecimal x))))

(defn write-byte
  "Writes a byte in the Java programming language
   to this SQLOutputImpl object. The driver converts
   it to an SQL BIT before returning it to the database.

  x - the value to pass to the database - `byte`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeByte x))))

(defn write-ref
  "Writes a Ref object in the Java programming language
   to this SQLOutputImpl object.  The driver converts
   it to a serializable SerialRef SQL REF value
   before returning it to the database.

  x - an object representing an SQL REF value - `java.sql.Ref`

  throws: java.sql.SQLException - if the SQLOutputImpl object is in use by a SQLData object attempting to write the attribute values of a UDT to the database."
  ([this x]
    (-> this (.writeRef x))))

(defn write-row-id
  "Writes an SQL ROWID value to the stream.

  x - a RowId object representing data of an SQL ROWID value - `java.sql.RowId`

  throws: java.sql.SQLException - if a database access error occurs"
  ([this x]
    (-> this (.writeRowId x))))

