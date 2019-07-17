(ns jdk.io.Reader
  "Abstract class for reading character streams.  The only methods that a
  subclass must implement are read(char[], int, int) and close().  Most
  subclasses, however, will override some of the methods defined here in order
  to provide higher efficiency, additional functionality, or both."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io Reader]))

(defn read
  "Reads characters into a portion of an array.  This method will block
   until some input is available, an I/O error occurs, or the end of the
   stream is reached.

  cbuf - Destination buffer - `char[]`
  off - Offset at which to start storing characters - `int`
  len - Maximum number of characters to read - `int`

  returns: The number of characters read, or -1 if the end of the
               stream has been reached - `int`

  throws: java.io.IOException - If an I/O error occurs"
  (^Integer [^java.io.Reader this cbuf ^Integer off ^Integer len]
    (-> this (.read cbuf off len)))
  (^Integer [^java.io.Reader this ^java.nio.CharBuffer target]
    (-> this (.read target)))
  (^Integer [^java.io.Reader this]
    (-> this (.read))))

(defn skip
  "Skips characters.  This method will block until some characters are
   available, an I/O error occurs, or the end of the stream is reached.

  n - The number of characters to skip - `long`

  returns: The number of characters actually skipped - `long`

  throws: java.lang.IllegalArgumentException - If n is negative."
  (^Long [^java.io.Reader this ^Long n]
    (-> this (.skip n))))

(defn ready
  "Tells whether this stream is ready to be read.

  returns: True if the next read() is guaranteed not to block for input,
   false otherwise.  Note that returning false does not guarantee that the
   next read will block. - `boolean`

  throws: java.io.IOException - If an I/O error occurs"
  (^Boolean [^java.io.Reader this]
    (-> this (.ready))))

(defn mark-supported
  "Tells whether this stream supports the mark() operation. The default
   implementation always returns false. Subclasses should override this
   method.

  returns: true if and only if this stream supports the mark operation. - `boolean`"
  (^Boolean [^java.io.Reader this]
    (-> this (.markSupported))))

(defn mark
  "Marks the present position in the stream.  Subsequent calls to reset()
   will attempt to reposition the stream to this point.  Not all
   character-input streams support the mark() operation.

  read-ahead-limit - Limit on the number of characters that may be read while still preserving the mark. After reading this many characters, attempting to reset the stream may fail. - `int`

  throws: java.io.IOException - If the stream does not support mark(), or if some other I/O error occurs"
  ([^java.io.Reader this ^Integer read-ahead-limit]
    (-> this (.mark read-ahead-limit))))

(defn reset
  "Resets the stream.  If the stream has been marked, then attempt to
   reposition it at the mark.  If the stream has not been marked, then
   attempt to reset it in some way appropriate to the particular stream,
   for example by repositioning it to its starting point.  Not all
   character-input streams support the reset() operation, and some support
   reset() without supporting mark().

  throws: java.io.IOException - If the stream has not been marked, or if the mark has been invalidated, or if the stream does not support reset(), or if some other I/O error occurs"
  ([^java.io.Reader this]
    (-> this (.reset))))

(defn close
  "Closes the stream and releases any system resources associated with
   it.  Once the stream has been closed, further read(), ready(),
   mark(), reset(), or skip() invocations will throw an IOException.
   Closing a previously closed stream has no effect.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.Reader this]
    (-> this (.close))))

