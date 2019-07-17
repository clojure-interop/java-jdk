(ns jdk.sql.Blob
  "The representation (mapping) in
  the Java™ programming
  language of an SQL
  BLOB value.  An SQL BLOB is a built-in type
  that stores a Binary Large Object as a column value in a row of
  a database table. By default drivers implement Blob using
  an SQL locator(BLOB), which means that a
  Blob object contains a logical pointer to the
  SQL BLOB data rather than the data itself.
  A Blob object is valid for the duration of the
  transaction in which is was created.

  Methods in the interfaces ResultSet,
  CallableStatement, and PreparedStatement, such as
  getBlob and setBlob allow a programmer to
  access an SQL BLOB value.
  The Blob interface provides methods for getting the
  length of an SQL BLOB (Binary Large Object) value,
  for materializing a BLOB value on the client, and for
  determining the position of a pattern of bytes within a
  BLOB value. In addition, this interface has methods for updating
  a BLOB value.

  All methods on the Blob interface must be fully implemented if the
  JDBC driver supports the data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Blob]))

(defn length
  "Returns the number of bytes in the BLOB value
   designated by this Blob object.

  returns: length of the BLOB in bytes - `long`

  throws: java.sql.SQLException - if there is an error accessing the length of the BLOB"
  ([^java.sql.Blob this]
    (-> this (.length))))

(defn get-bytes
  "Retrieves all or part of the BLOB
   value that this Blob object represents, as an array of
   bytes.  This byte array contains up to length
   consecutive bytes starting at position pos.

  pos - the ordinal position of the first byte in the BLOB value to be extracted; the first byte is at position 1 - `long`
  length - the number of consecutive bytes to be copied; the value for length must be 0 or greater - `int`

  returns: a byte array containing up to length
           consecutive bytes from the BLOB value designated
           by this Blob object, starting with the
           byte at position pos - `byte[]`

  throws: java.sql.SQLException - if there is an error accessing the BLOB value; if pos is less than 1 or length is less than 0"
  ([^java.sql.Blob this ^Long pos ^Integer length]
    (-> this (.getBytes pos length))))

(defn get-binary-stream
  "Returns an InputStream object that contains a partial Blob value,
   starting  with the byte specified by pos, which is length bytes in length.

  pos - the offset to the first byte of the partial value to be retrieved. The first byte in the Blob is at position 1 - `long`
  length - the length in bytes of the partial value to be retrieved - `long`

  returns: InputStream through which the partial Blob value can be read. - `java.io.InputStream`

  throws: java.sql.SQLException - if pos is less than 1 or if pos is greater than the number of bytes in the Blob or if pos length is greater than the number of bytes in the Blob"
  ([^java.sql.Blob this ^Long pos ^Long length]
    (-> this (.getBinaryStream pos length)))
  ([^java.sql.Blob this]
    (-> this (.getBinaryStream))))

(defn position
  "Retrieves the byte position at which the specified byte array
   pattern begins within the BLOB
   value that this Blob object represents.  The
   search for pattern begins at position
   start.

  pattern - the byte array for which to search - `byte[]`
  start - the position at which to begin searching; the first position is 1 - `long`

  returns: the position at which the pattern appears, else -1 - `long`

  throws: java.sql.SQLException - if there is an error accessing the BLOB or if start is less than 1"
  ([^java.sql.Blob this pattern ^Long start]
    (-> this (.position pattern start))))

(defn set-bytes
  "Writes all or part of the given byte array to the
   BLOB value that this Blob object represents
   and returns the number of bytes written.
   Writing starts at position pos in the BLOB
   value; len bytes from the given byte array are written.
   The array of bytes will overwrite the existing bytes
   in the Blob object starting at the position
   pos.  If the end of the Blob value is reached
   while writing the array of bytes, then the length of the Blob
   value will be increased to accommodate the extra bytes.

   Note: If the value specified for pos
   is greater then the length+1 of the BLOB value then the
   behavior is undefined. Some JDBC drivers may throw a
   SQLException while other drivers may support this
   operation.

  pos - the position in the BLOB object at which to start writing; the first position is 1 - `long`
  bytes - the array of bytes to be written to this BLOB object - `byte[]`
  offset - the offset into the array bytes at which to start reading the bytes to be set - `int`
  len - the number of bytes to be written to the BLOB value from the array of bytes bytes - `int`

  returns: the number of bytes written - `int`

  throws: java.sql.SQLException - if there is an error accessing the BLOB value or if pos is less than 1"
  ([^java.sql.Blob this ^Long pos bytes ^Integer offset ^Integer len]
    (-> this (.setBytes pos bytes offset len)))
  ([^java.sql.Blob this ^Long pos bytes]
    (-> this (.setBytes pos bytes))))

(defn set-binary-stream
  "Retrieves a stream that can be used to write to the BLOB
   value that this Blob object represents.  The stream begins
   at position pos.
   The  bytes written to the stream will overwrite the existing bytes
   in the Blob object starting at the position
   pos.  If the end of the Blob value is reached
   while writing to the stream, then the length of the Blob
   value will be increased to accommodate the extra bytes.

   Note: If the value specified for pos
   is greater then the length+1 of the BLOB value then the
   behavior is undefined. Some JDBC drivers may throw a
   SQLException while other drivers may support this
   operation.

  pos - the position in the BLOB value at which to start writing; the first position is 1 - `long`

  returns: a java.io.OutputStream object to which data can
           be written - `java.io.OutputStream`

  throws: java.sql.SQLException - if there is an error accessing the BLOB value or if pos is less than 1"
  ([^java.sql.Blob this ^Long pos]
    (-> this (.setBinaryStream pos))))

(defn truncate
  "Truncates the BLOB value that this Blob
   object represents to be len bytes in length.

   Note: If the value specified for pos
   is greater then the length+1 of the BLOB value then the
   behavior is undefined. Some JDBC drivers may throw a
   SQLException while other drivers may support this
   operation.

  len - the length, in bytes, to which the BLOB value that this Blob object represents should be truncated - `long`

  throws: java.sql.SQLException - if there is an error accessing the BLOB value or if len is less than 0"
  ([^java.sql.Blob this ^Long len]
    (-> this (.truncate len))))

(defn free
  "This method frees the Blob object and releases the resources that
   it holds. The object is invalid once the free
   method is called.

   After free has been called, any attempt to invoke a
   method other than free will result in a SQLException
   being thrown.  If free is called multiple times, the subsequent
   calls to free are treated as a no-op.

  throws: java.sql.SQLException - if an error occurs releasing the Blob's resources"
  ([^java.sql.Blob this]
    (-> this (.free))))

