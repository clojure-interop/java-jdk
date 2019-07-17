(ns jdk.io.PushbackReader
  "A character-stream reader that allows characters to be pushed back into the
  stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PushbackReader]))

(defn ->pushback-reader
  "Constructor.

  Creates a new pushback reader with a pushback buffer of the given size.

  in - The reader from which characters will be read - `java.io.Reader`
  size - The size of the pushback buffer - `int`

  throws: java.lang.IllegalArgumentException - if size <= 0"
  ([^java.io.Reader in ^Integer size]
    (new PushbackReader in size))
  ([^java.io.Reader in]
    (new PushbackReader in)))

(defn read
  "Reads characters into a portion of an array.

  cbuf - Destination buffer - `char[]`
  off - Offset at which to start writing characters - `int`
  len - Maximum number of characters to read - `int`

  returns: The number of characters read, or -1 if the end of the
               stream has been reached - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.PushbackReader this cbuf ^Integer off ^Integer len]
    (-> this (.read cbuf off len)))
  ([^java.io.PushbackReader this]
    (-> this (.read))))

(defn unread
  "Pushes back a portion of an array of characters by copying it to the
   front of the pushback buffer.  After this method returns, the next
   character to be read will have the value cbuf[off], the
   character after that will have the value cbuf[off+1], and
   so forth.

  cbuf - Character array - `char[]`
  off - Offset of first character to push back - `int`
  len - Number of characters to push back - `int`

  throws: java.io.IOException - If there is insufficient room in the pushback buffer, or if some other I/O error occurs"
  ([^java.io.PushbackReader this cbuf ^Integer off ^Integer len]
    (-> this (.unread cbuf off len)))
  ([^java.io.PushbackReader this ^Integer c]
    (-> this (.unread c))))

(defn ready
  "Tells whether this stream is ready to be read.

  returns: True if the next read() is guaranteed not to block for input,
   false otherwise.  Note that returning false does not guarantee that the
   next read will block. - `boolean`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.PushbackReader this]
    (-> this (.ready))))

(defn mark
  "Marks the present position in the stream. The mark
   for class PushbackReader always throws an exception.

  read-ahead-limit - Limit on the number of characters that may be read while still preserving the mark. After reading this many characters, attempting to reset the stream may fail. - `int`

  throws: java.io.IOException - Always, since mark is not supported"
  ([^java.io.PushbackReader this ^Integer read-ahead-limit]
    (-> this (.mark read-ahead-limit))))

(defn reset
  "Resets the stream. The reset method of
   PushbackReader always throws an exception.

  throws: java.io.IOException - Always, since reset is not supported"
  ([^java.io.PushbackReader this]
    (-> this (.reset))))

(defn mark-supported
  "Tells whether this stream supports the mark() operation, which it does
   not.

  returns: true if and only if this stream supports the mark operation. - `boolean`"
  ([^java.io.PushbackReader this]
    (-> this (.markSupported))))

(defn close
  "Closes the stream and releases any system resources associated with
   it. Once the stream has been closed, further read(),
   unread(), ready(), or skip() invocations will throw an IOException.
   Closing a previously closed stream has no effect.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.PushbackReader this]
    (-> this (.close))))

(defn skip
  "Skips characters.  This method will block until some characters are
   available, an I/O error occurs, or the end of the stream is reached.

  n - The number of characters to skip - `long`

  returns: The number of characters actually skipped - `long`

  throws: java.lang.IllegalArgumentException - If n is negative."
  ([^java.io.PushbackReader this ^Long n]
    (-> this (.skip n))))

