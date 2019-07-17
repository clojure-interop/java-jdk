(ns jdk.io.CharArrayReader
  "This class implements a character buffer that can be used as a
  character-input stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io CharArrayReader]))

(defn ->char-array-reader
  "Constructor.

  Creates a CharArrayReader from the specified array of chars.

    The resulting reader will start reading at the given
   offset.  The total number of char values that can be
   read from this reader will be either length or
   buf.length-offset, whichever is smaller.

  buf - Input buffer (not copied) - `char[]`
  offset - Offset of the first char to read - `int`
  length - Number of chars to read - `int`

  throws: java.lang.IllegalArgumentException - If offset is negative or greater than buf.length, or if length is negative, or if the sum of these two values is negative."
  ([buf ^Integer offset ^Integer length]
    (new CharArrayReader buf offset length))
  ([buf]
    (new CharArrayReader buf)))

(defn read
  "Reads characters into a portion of an array.

  b - Destination buffer - `char[]`
  off - Offset at which to start storing characters - `int`
  len - Maximum number of characters to read - `int`

  returns: The actual number of characters read, or -1 if
            the end of the stream has been reached - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.CharArrayReader this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  ([^java.io.CharArrayReader this]
    (-> this (.read))))

(defn skip
  "Skips characters.  Returns the number of characters that were skipped.

   The n parameter may be negative, even though the
   skip method of the Reader superclass throws
   an exception in this case. If n is negative, then
   this method does nothing and returns 0.

  n - The number of characters to skip - `long`

  returns: The number of characters actually skipped - `long`

  throws: java.io.IOException - If the stream is closed, or an I/O error occurs"
  ([^java.io.CharArrayReader this ^Long n]
    (-> this (.skip n))))

(defn ready
  "Tells whether this stream is ready to be read.  Character-array readers
   are always ready to be read.

  returns: True if the next read() is guaranteed not to block for input,
   false otherwise.  Note that returning false does not guarantee that the
   next read will block. - `boolean`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.CharArrayReader this]
    (-> this (.ready))))

(defn mark-supported
  "Tells whether this stream supports the mark() operation, which it does.

  returns: true if and only if this stream supports the mark operation. - `boolean`"
  ([^java.io.CharArrayReader this]
    (-> this (.markSupported))))

(defn mark
  "Marks the present position in the stream.  Subsequent calls to reset()
   will reposition the stream to this point.

  read-ahead-limit - Limit on the number of characters that may be read while still preserving the mark. Because the stream's input comes from a character array, there is no actual limit; hence this argument is ignored. - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.CharArrayReader this ^Integer read-ahead-limit]
    (-> this (.mark read-ahead-limit))))

(defn reset
  "Resets the stream to the most recent mark, or to the beginning if it has
   never been marked.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.CharArrayReader this]
    (-> this (.reset))))

(defn close
  "Closes the stream and releases any system resources associated with
   it.  Once the stream has been closed, further read(), ready(),
   mark(), reset(), or skip() invocations will throw an IOException.
   Closing a previously closed stream has no effect."
  ([^java.io.CharArrayReader this]
    (-> this (.close))))

