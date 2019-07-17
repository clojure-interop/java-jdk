(ns jdk.io.StringReader
  "A character stream whose source is a string."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io StringReader]))

(defn ->string-reader
  "Constructor.

  Creates a new string reader.

  s - String providing the character stream. - `java.lang.String`"
  ([^java.lang.String s]
    (new StringReader s)))

(defn read
  "Reads characters into a portion of an array.

  cbuf - Destination buffer - `char[]`
  off - Offset at which to start writing characters - `int`
  len - Maximum number of characters to read - `int`

  returns: The number of characters read, or -1 if the end of the
               stream has been reached - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.StringReader this cbuf ^Integer off ^Integer len]
    (-> this (.read cbuf off len)))
  ([^java.io.StringReader this]
    (-> this (.read))))

(defn skip
  "Skips the specified number of characters in the stream. Returns
   the number of characters that were skipped.

   The ns parameter may be negative, even though the
   skip method of the Reader superclass throws
   an exception in this case. Negative values of ns cause the
   stream to skip backwards. Negative return values indicate a skip
   backwards. It is not possible to skip backwards past the beginning of
   the string.

   If the entire string has been read or skipped, then this method has
   no effect and always returns 0.

  ns - The number of characters to skip - `long`

  returns: The number of characters actually skipped - `long`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.StringReader this ^Long ns]
    (-> this (.skip ns))))

(defn ready
  "Tells whether this stream is ready to be read.

  returns: True if the next read() is guaranteed not to block for input - `boolean`

  throws: java.io.IOException - If the stream is closed"
  ([^java.io.StringReader this]
    (-> this (.ready))))

(defn mark-supported
  "Tells whether this stream supports the mark() operation, which it does.

  returns: true if and only if this stream supports the mark operation. - `boolean`"
  ([^java.io.StringReader this]
    (-> this (.markSupported))))

(defn mark
  "Marks the present position in the stream.  Subsequent calls to reset()
   will reposition the stream to this point.

  read-ahead-limit - Limit on the number of characters that may be read while still preserving the mark. Because the stream's input comes from a string, there is no actual limit, so this argument must not be negative, but is otherwise ignored. - `int`

  throws: java.lang.IllegalArgumentException - If readAheadLimit < 0"
  ([^java.io.StringReader this ^Integer read-ahead-limit]
    (-> this (.mark read-ahead-limit))))

(defn reset
  "Resets the stream to the most recent mark, or to the beginning of the
   string if it has never been marked.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.StringReader this]
    (-> this (.reset))))

(defn close
  "Closes the stream and releases any system resources associated with
   it. Once the stream has been closed, further read(),
   ready(), mark(), or reset() invocations will throw an IOException.
   Closing a previously closed stream has no effect."
  ([^java.io.StringReader this]
    (-> this (.close))))

