(ns javax.sql.rowset.serial.SerialBlob
  "A serialized mapping in the Java programming language of an SQL
  BLOB value.

  The SerialBlob class provides a constructor for creating
  an instance from a Blob object.  Note that the
  Blob
  object should have brought the SQL BLOB value's data over
  to the client before a SerialBlob object
  is constructed from it.  The data of an SQL BLOB value can
  be materialized on the client as an array of bytes (using the method
  Blob.getBytes) or as a stream of uninterpreted bytes
  (using the method Blob.getBinaryStream).

  SerialBlob methods make it possible to make a copy of a
  SerialBlob object as an array of bytes or as a stream.
  They also make it possible to locate a given pattern of bytes or a
  Blob object within a SerialBlob object
  and to update or truncate a Blob object.

   Thread safety

   A SerialBlob is not safe for use by multiple concurrent threads.  If a
  SerialBlob is to be used by more than one thread then access to the SerialBlob
  should be controlled by appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialBlob]))

(defn ->serial-blob
  "Constructor.

  Constructs a SerialBlob object that is a serialized version of
   the given byte array.

   The new SerialBlob object is initialized with the data from the
   byte array, thus allowing disconnected RowSet
   objects to establish serialized Blob objects without
   touching the data source.

  b - the byte array containing the data for the Blob object to be serialized - `byte[]`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs during serialization"
  ([b]
    (new SerialBlob b)))

(defn get-binary-stream
  "Returns an
   InputStream object that contains a partial
   Blob value, starting with the byte specified by pos, which is
   length bytes in length.

  pos - the offset to the first byte of the partial value to be retrieved. The first byte in the Blob is at position 1 - `long`
  length - the length in bytes of the partial value to be retrieved - `long`

  returns: InputStream through which the partial Blob value can
   be read. - `java.io.InputStream`

  throws: java.sql.SQLException - if pos is less than 1 or if pos is greater than the number of bytes in the Blob or if pos length is greater than the number of bytes in the Blob"
  ([this pos length]
    (-> this (.getBinaryStream pos length)))
  ([this]
    (-> this (.getBinaryStream))))

(defn set-bytes
  "Writes all or part of the given byte array to the
   BLOB value that this Blob object represents
   and returns the number of bytes written.
   Writing starts at position pos in the BLOB
   value; len bytes from the given byte array are written.

  pos - the position in the BLOB object at which to start writing. The first position is 1; must not be less than 1 nor greater than the length of this SerialBlob object. - `long`
  bytes - the array of bytes to be written to the BLOB value - `byte[]`
  offset - the offset in the byte array at which to start reading the bytes. The first offset position is 0; must not be less than 0 nor greater than the length of the byte array - `int`
  length - the number of bytes to be written to the BLOB value from the array of bytes bytes. - `int`

  returns: the number of bytes written - `int`

  throws: javax.sql.rowset.serial.SerialException - if there is an error accessing the BLOB value; if an invalid position is set; if an invalid offset value is set; if number of bytes to be written is greater than the SerialBlob length; or the combined values of the length and offset is greater than the Blob buffer; if free had previously been called on this object"
  ([this pos bytes offset length]
    (-> this (.setBytes pos bytes offset length)))
  ([this pos bytes]
    (-> this (.setBytes pos bytes))))

(defn free
  "This method frees the SeriableBlob object and releases the
   resources that it holds. The object is invalid once the free
   method is called.  If free is called multiple times, the
   subsequent calls to free are treated as a no-op.

  throws: java.sql.SQLException - if an error occurs releasing the Blob's resources"
  ([this]
    (-> this (.free))))

(defn set-binary-stream
  "Retrieves a stream that can be used to write to the BLOB
   value that this Blob object represents.  The stream begins
   at position pos. This method forwards the
   setBinaryStream() call to the underlying Blob in
   the event that this SerialBlob object is instantiated with a
   Blob. If this SerialBlob is instantiated with
   a byte array, a SerialException is thrown.

  pos - the position in the BLOB value at which to start writing - `long`

  returns: a java.io.OutputStream object to which data can
           be written - `java.io.OutputStream`

  throws: java.sql.SQLException - if there is an error accessing the BLOB value"
  ([this pos]
    (-> this (.setBinaryStream pos))))

(defn get-bytes
  "Copies the specified number of bytes, starting at the given
   position, from this SerialBlob object to
   another array of bytes.

   Note that if the given number of bytes to be copied is larger than
   the length of this SerialBlob object's array of
   bytes, the given number will be shortened to the array's length.

  pos - the ordinal position of the first byte in this SerialBlob object to be copied; numbering starts at 1; must not be less than 1 and must be less than or equal to the length of this SerialBlob object - `long`
  length - the number of bytes to be copied - `int`

  returns: an array of bytes that is a copy of a region of this
           SerialBlob object, starting at the given
           position and containing the given number of consecutive bytes - `byte[]`

  throws: javax.sql.rowset.serial.SerialException - if the given starting position is out of bounds; if free had previously been called on this object"
  ([this pos length]
    (-> this (.getBytes pos length))))

(defn position
  "Returns the position in this SerialBlob object where
   the given pattern of bytes begins, starting the search at the
   specified position.

  pattern - the pattern of bytes for which to search - `byte[]`
  start - the position of the byte in this SerialBlob object from which to begin the search; the first position is 1; must not be less than 1 nor greater than the length of this SerialBlob object - `long`

  returns: the position in this SerialBlob object
           where the given pattern begins, starting at the specified
           position; -1 if the pattern is not found
           or the given starting position is out of bounds; position
           numbering for the return value starts at 1 - `long`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs when serializing the blob; if free had previously been called on this object"
  ([this pattern start]
    (-> this (.position pattern start))))

(defn length
  "Retrieves the number of bytes in this SerialBlob
   object's array of bytes.

  returns: a long indicating the length in bytes of this
           SerialBlob object's array of bytes - `long`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs; if free had previously been called on this object"
  ([this]
    (-> this (.length))))

(defn truncate
  "Truncates the BLOB value that this Blob
   object represents to be len bytes in length.

  length - the length, in bytes, to which the BLOB value that this Blob object represents should be truncated - `long`

  throws: javax.sql.rowset.serial.SerialException - if there is an error accessing the Blob value; or the length to truncate is greater that the SerialBlob length; if free had previously been called on this object"
  ([this length]
    (-> this (.truncate length))))

(defn clone
  "Returns a clone of this SerialBlob. The copy will contain a
   reference to a clone of the internal byte array, not a reference
   to the original internal byte array of this SerialBlob object.
   The underlying Blob object will be set to null.

  returns: a clone of this SerialBlob - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn hash-code
  "Returns a hash code for this SerialBlob.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn equals
  "Compares this SerialBlob to the specified object.  The result is true if and only if the argument is not null and is a SerialBlob object that represents the same sequence of bytes as this
   object.

  obj - The object to compare this SerialBlob against - `java.lang.Object`

  returns: true if the given object represents a SerialBlob
            equivalent to this SerialBlob, false otherwise - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

