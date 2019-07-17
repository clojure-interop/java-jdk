(ns jdk.sql.Clob
  "The mapping in the Java™ programming language
  for the SQL CLOB type.
  An SQL CLOB is a built-in type
  that stores a Character Large Object as a column value in a row of
  a database table.
  By default drivers implement a Clob object using an SQL
  locator(CLOB), which means that a Clob object
  contains a logical pointer to the SQL CLOB data rather than
  the data itself. A Clob object is valid for the duration
  of the transaction in which it was created.
  The Clob interface provides methods for getting the
  length of an SQL CLOB (Character Large Object) value,
  for materializing a CLOB value on the client, and for
  searching for a substring or CLOB object within a
  CLOB value.
  Methods in the interfaces ResultSet,
  CallableStatement, and PreparedStatement, such as
  getClob and setClob allow a programmer to
  access an SQL CLOB value.  In addition, this interface
  has methods for updating a CLOB value.

  All methods on the Clob interface must be fully implemented if the
  JDBC driver supports the data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql Clob]))

(defn get-ascii-stream
  "Retrieves the CLOB value designated by this Clob
   object as an ascii stream.

  returns: a java.io.InputStream object containing the
           CLOB data - `java.io.InputStream`

  throws: java.sql.SQLException - if there is an error accessing the CLOB value"
  (^java.io.InputStream [^java.sql.Clob this]
    (-> this (.getAsciiStream))))

(defn set-string
  "Writes len characters of str, starting
   at character offset, to the CLOB value
   that this Clob represents.  The string will overwrite the existing characters
   in the Clob object starting at the position
   pos.  If the end of the Clob value is reached
   while writing the given string, then the length of the Clob
   value will be increased to accommodate the extra characters.

   Note: If the value specified for pos
   is greater then the length+1 of the CLOB value then the
   behavior is undefined. Some JDBC drivers may throw a
   SQLException while other drivers may support this
   operation.

  pos - the position at which to start writing to this CLOB object; The first position is 1 - `long`
  str - the string to be written to the CLOB value that this Clob object represents - `java.lang.String`
  offset - the offset into str to start reading the characters to be written - `int`
  len - the number of characters to be written - `int`

  returns: the number of characters written - `int`

  throws: java.sql.SQLException - if there is an error accessing the CLOB value or if pos is less than 1"
  (^Integer [^java.sql.Clob this ^Long pos ^java.lang.String str ^Integer offset ^Integer len]
    (-> this (.setString pos str offset len)))
  (^Integer [^java.sql.Clob this ^Long pos ^java.lang.String str]
    (-> this (.setString pos str))))

(defn free
  "This method frees the Clob object and releases the resources the resources
   that it holds.  The object is invalid once the free method
   is called.

   After free has been called, any attempt to invoke a
   method other than free will result in a SQLException
   being thrown.  If free is called multiple times, the subsequent
   calls to free are treated as a no-op.

  throws: java.sql.SQLException - if an error occurs releasing the Clob's resources"
  ([^java.sql.Clob this]
    (-> this (.free))))

(defn position
  "Retrieves the character position at which the specified substring
   searchstr appears in the SQL CLOB value
   represented by this Clob object.  The search
   begins at position start.

  searchstr - the substring for which to search - `java.lang.String`
  start - the position at which to begin searching; the first position is 1 - `long`

  returns: the position at which the substring appears or -1 if it is not
           present; the first position is 1 - `long`

  throws: java.sql.SQLException - if there is an error accessing the CLOB value or if pos is less than 1"
  (^Long [^java.sql.Clob this ^java.lang.String searchstr ^Long start]
    (-> this (.position searchstr start))))

(defn get-character-stream
  "Returns a Reader object that contains a partial Clob value, starting
   with the character specified by pos, which is length characters in length.

  pos - the offset to the first character of the partial value to be retrieved. The first character in the Clob is at position 1. - `long`
  length - the length in characters of the partial value to be retrieved. - `long`

  returns: Reader through which the partial Clob value can be read. - `java.io.Reader`

  throws: java.sql.SQLException - if pos is less than 1 or if pos is greater than the number of characters in the Clob or if pos length is greater than the number of characters in the Clob"
  (^java.io.Reader [^java.sql.Clob this ^Long pos ^Long length]
    (-> this (.getCharacterStream pos length)))
  (^java.io.Reader [^java.sql.Clob this]
    (-> this (.getCharacterStream))))

(defn length
  "Retrieves the number of characters
   in the CLOB value
   designated by this Clob object.

  returns: length of the CLOB in characters - `long`

  throws: java.sql.SQLException - if there is an error accessing the length of the CLOB value"
  (^Long [^java.sql.Clob this]
    (-> this (.length))))

(defn truncate
  "Truncates the CLOB value that this Clob
   designates to have a length of len
   characters.

   Note: If the value specified for pos
   is greater then the length+1 of the CLOB value then the
   behavior is undefined. Some JDBC drivers may throw a
   SQLException while other drivers may support this
   operation.

  len - the length, in characters, to which the CLOB value should be truncated - `long`

  throws: java.sql.SQLException - if there is an error accessing the CLOB value or if len is less than 0"
  ([^java.sql.Clob this ^Long len]
    (-> this (.truncate len))))

(defn get-sub-string
  "Retrieves a copy of the specified substring
   in the CLOB value
   designated by this Clob object.
   The substring begins at position
   pos and has up to length consecutive
   characters.

  pos - the first character of the substring to be extracted. The first character is at position 1. - `long`
  length - the number of consecutive characters to be copied; the value for length must be 0 or greater - `int`

  returns: a String that is the specified substring in
           the CLOB value designated by this Clob object - `java.lang.String`

  throws: java.sql.SQLException - if there is an error accessing the CLOB value; if pos is less than 1 or length is less than 0"
  (^java.lang.String [^java.sql.Clob this ^Long pos ^Integer length]
    (-> this (.getSubString pos length))))

(defn set-ascii-stream
  "Retrieves a stream to be used to write Ascii characters to the
   CLOB value that this Clob object represents,
   starting at position pos.  Characters written to the stream
   will overwrite the existing characters
   in the Clob object starting at the position
   pos.  If the end of the Clob value is reached
   while writing characters to the stream, then the length of the Clob
   value will be increased to accommodate the extra characters.

   Note: If the value specified for pos
   is greater then the length+1 of the CLOB value then the
   behavior is undefined. Some JDBC drivers may throw a
   SQLException while other drivers may support this
   operation.

  pos - the position at which to start writing to this CLOB object; The first position is 1 - `long`

  returns: the stream to which ASCII encoded characters can be written - `java.io.OutputStream`

  throws: java.sql.SQLException - if there is an error accessing the CLOB value or if pos is less than 1"
  (^java.io.OutputStream [^java.sql.Clob this ^Long pos]
    (-> this (.setAsciiStream pos))))

(defn set-character-stream
  "Retrieves a stream to be used to write a stream of Unicode characters
   to the CLOB value that this Clob object
   represents, at position pos. Characters written to the stream
   will overwrite the existing characters
   in the Clob object starting at the position
   pos.  If the end of the Clob value is reached
   while writing characters to the stream, then the length of the Clob
   value will be increased to accommodate the extra characters.

   Note: If the value specified for pos
   is greater then the length+1 of the CLOB value then the
   behavior is undefined. Some JDBC drivers may throw a
   SQLException while other drivers may support this
   operation.

  pos - the position at which to start writing to the CLOB value; The first position is 1 - `long`

  returns: a stream to which Unicode encoded characters can be written - `java.io.Writer`

  throws: java.sql.SQLException - if there is an error accessing the CLOB value or if pos is less than 1"
  (^java.io.Writer [^java.sql.Clob this ^Long pos]
    (-> this (.setCharacterStream pos))))

