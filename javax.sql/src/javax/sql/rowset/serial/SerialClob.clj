(ns javax.sql.rowset.serial.SerialClob
  "A serialized mapping in the Java programming language of an SQL
  CLOB value.

  The SerialClob class provides a constructor for creating
  an instance from a Clob object.  Note that the Clob
  object should have brought the SQL CLOB value's data over
  to the client before a SerialClob object
  is constructed from it.  The data of an SQL CLOB value can
  be materialized on the client as a stream of Unicode characters.

  SerialClob methods make it possible to get a substring
  from a SerialClob object or to locate the start of
  a pattern of characters.

   Thread safety

   A SerialClob is not safe for use by multiple concurrent threads.  If a
  SerialClob is to be used by more than one thread then access to the SerialClob
  should be controlled by appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sql.rowset.serial SerialClob]))

(defn ->serial-clob
  "Constructor.

  Constructs a SerialClob object that is a serialized version of
   the given char array.

   The new SerialClob object is initialized with the data from the
   char array, thus allowing disconnected RowSet
   objects to establish a serialized Clob object without touching
   the data source.

  ch - the char array representing the Clob object to be serialized - `char[]`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs during serialization"
  ([ch]
    (new SerialClob ch)))

(defn get-ascii-stream
  "Retrieves the CLOB value designated by this SerialClob
   object as an ascii stream. This method forwards the getAsciiStream
   call to the underlying Clob object in the event that this
   SerialClob object is instantiated with a Clob
   object. If this SerialClob object is instantiated with
   a char array, a SerialException object is thrown.

  returns: a java.io.InputStream object containing
       this SerialClob object's data - `java.io.InputStream`

  throws: javax.sql.rowset.serial.SerialException - if this SerialClob object was not instantiated with a Clob object; if free had previously been called on this object"
  ([^javax.sql.rowset.serial.SerialClob this]
    (-> this (.getAsciiStream))))

(defn set-string
  "Writes len characters of str, starting
   at character offset, to the CLOB value
   that this Clob represents.

  pos - the position at which to start writing to the CLOB value that this SerialClob object represents; the first position is 1; must not be less than 1 nor greater than the length of this SerialClob object - `long`
  str - the string to be written to the CLOB value that this Clob object represents - `java.lang.String`
  offset - the offset into str to start reading the characters to be written - `int`
  length - the number of characters to be written - `int`

  returns: the number of characters written - `int`

  throws: javax.sql.rowset.serial.SerialException - if there is an error accessing the CLOB value; if an invalid position is set; if an invalid offset value is set; if number of bytes to be written is greater than the SerialClob length; or the combined values of the length and offset is greater than the Clob buffer; if the free method had been previously called on this object"
  ([^javax.sql.rowset.serial.SerialClob this ^Long pos ^java.lang.String str ^Integer offset ^Integer length]
    (-> this (.setString pos str offset length)))
  ([^javax.sql.rowset.serial.SerialClob this ^Long pos ^java.lang.String str]
    (-> this (.setString pos str))))

(defn free
  "This method frees the SeriableClob object and releases the
   resources that it holds.
   The object is invalid once the free method is called.

   If free is called multiple times, the subsequent
   calls to free are treated as a no-op.

  throws: java.sql.SQLException - if an error occurs releasing the Clob's resources"
  ([^javax.sql.rowset.serial.SerialClob this]
    (-> this (.free))))

(defn position
  "Returns the position in this SerialClob object
   where the given String object begins, starting
   the search at the specified position. This method returns
   -1 if the pattern is not found.

  search-str - the String object for which to search - `java.lang.String`
  start - the position in this SerialClob object at which to start the search; the first position is 1; must not be less than 1 nor greater than the length of this SerialClob object - `long`

  returns: the position at which the given String object
           begins, starting the search at the specified position;
           -1 if the given String object is
           not found or the starting position is out of bounds; position
           numbering for the return value starts at 1 - `long`

  throws: javax.sql.rowset.serial.SerialException - if the free method had been previously called on this object"
  ([^javax.sql.rowset.serial.SerialClob this ^java.lang.String search-str ^Long start]
    (-> this (.position search-str start))))

(defn get-character-stream
  "Returns a Reader object that contains a partial
   SerialClob value, starting
   with the character specified by pos, which is length characters in length.

  pos - the offset to the first character of the partial value to be retrieved. The first character in the SerialClob is at position 1. - `long`
  length - the length in characters of the partial value to be retrieved. - `long`

  returns: Reader through which the partial SerialClob
   value can be read. - `java.io.Reader`

  throws: java.sql.SQLException - if pos is less than 1 or if pos is greater than the number of characters in the SerialClob or if pos length is greater than the number of characters in the SerialClob;"
  ([^javax.sql.rowset.serial.SerialClob this ^Long pos ^Long length]
    (-> this (.getCharacterStream pos length)))
  ([^javax.sql.rowset.serial.SerialClob this]
    (-> this (.getCharacterStream))))

(defn length
  "Retrieves the number of characters in this SerialClob
   object's array of characters.

  returns: a long indicating the length in characters of this
           SerialClob object's array of character - `long`

  throws: javax.sql.rowset.serial.SerialException - if an error occurs; if free had previously been called on this object"
  ([^javax.sql.rowset.serial.SerialClob this]
    (-> this (.length))))

(defn truncate
  "Truncates the CLOB value that this SerialClob
   object represents so that it has a length of len
   characters.

   Truncating a SerialClob object to length 0 has the effect of
   clearing its contents.

  length - the length, in bytes, to which the CLOB value should be truncated - `long`

  throws: javax.sql.rowset.serial.SerialException - if there is an error accessing the CLOB value; if the free method had been previously called on this object"
  ([^javax.sql.rowset.serial.SerialClob this ^Long length]
    (-> this (.truncate length))))

(defn get-sub-string
  "Returns a copy of the substring contained in this
   SerialClob object, starting at the given position
   and continuing for the specified number or characters.

  pos - the position of the first character in the substring to be copied; the first character of the SerialClob object is at position 1; must not be less than 1, and the sum of the starting position and the length of the substring must be less than the length of this SerialClob object - `long`
  length - the number of characters in the substring to be returned; must not be greater than the length of this SerialClob object, and the sum of the starting position and the length of the substring must be less than the length of this SerialClob object - `int`

  returns: a String object containing a substring of
           this SerialClob object beginning at the
           given position and containing the specified number of
           consecutive characters - `java.lang.String`

  throws: javax.sql.rowset.serial.SerialException - if either of the arguments is out of bounds; if free had previously been called on this object"
  ([^javax.sql.rowset.serial.SerialClob this ^Long pos ^Integer length]
    (-> this (.getSubString pos length))))

(defn set-ascii-stream
  "Retrieves a stream to be used to write Ascii characters to the
   CLOB value that this SerialClob object represents,
   starting at position pos. This method forwards the
   setAsciiStream() call to the underlying Clob object in
   the event that this SerialClob object is instantiated with a
   Clob object. If this SerialClob object is instantiated
    with a char array, a SerialException object is thrown.

  pos - the position at which to start writing to the CLOB object - `long`

  returns: the stream to which ASCII encoded characters can be written - `java.io.OutputStream`

  throws: javax.sql.rowset.serial.SerialException - if SerialClob is not instantiated with a Clob object; if the free method had been previously called on this object"
  ([^javax.sql.rowset.serial.SerialClob this ^Long pos]
    (-> this (.setAsciiStream pos))))

(defn clone
  "Returns a clone of this SerialClob. The copy will contain a
   reference to a clone of the internal character array, not a reference
   to the original internal character array of this SerialClob object.
   The underlying Clob object will be set to null.

  returns: a clone of this SerialClob - `java.lang.Object`"
  ([^javax.sql.rowset.serial.SerialClob this]
    (-> this (.clone))))

(defn hash-code
  "Returns a hash code for this SerialClob.

  returns: a hash code value for this object. - `int`"
  ([^javax.sql.rowset.serial.SerialClob this]
    (-> this (.hashCode))))

(defn set-character-stream
  "Retrieves a stream to be used to write a stream of Unicode characters
   to the CLOB value that this SerialClob object
   represents, at position pos. This method forwards the
   setCharacterStream() call to the underlying Clob
   object in the event that this SerialClob object is instantiated with a
   Clob object. If this SerialClob object is instantiated with
   a char array, a SerialException is thrown.

  pos - the position at which to start writing to the CLOB value - `long`

  returns: a stream to which Unicode encoded characters can be written - `java.io.Writer`

  throws: javax.sql.rowset.serial.SerialException - if the SerialClob is not instantiated with a Clob object; if the free method had been previously called on this object"
  ([^javax.sql.rowset.serial.SerialClob this ^Long pos]
    (-> this (.setCharacterStream pos))))

(defn equals
  "Compares this SerialClob to the specified object.  The result is true if and only if the argument is not null and is a SerialClob object that represents the same sequence of characters as this
   object.

  obj - The object to compare this SerialClob against - `java.lang.Object`

  returns: true if the given object represents a SerialClob
            equivalent to this SerialClob, false otherwise - `boolean`"
  ([^javax.sql.rowset.serial.SerialClob this ^java.lang.Object obj]
    (-> this (.equals obj))))

