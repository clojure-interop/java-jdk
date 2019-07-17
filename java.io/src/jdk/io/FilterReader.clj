(ns jdk.io.FilterReader
  "Abstract class for reading filtered character streams.
  The abstract class FilterReader itself
  provides default methods that pass all requests to
  the contained stream. Subclasses of FilterReader
  should override some of these methods and may also provide
  additional methods and fields."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FilterReader]))

(defn read
  "Reads characters into a portion of an array.

  cbuf - Destination buffer - `char[]`
  off - Offset at which to start storing characters - `int`
  len - Maximum number of characters to read - `int`

  returns: The number of characters read, or -1 if the end of the
               stream has been reached - `int`

  throws: java.io.IOException - If an I/O error occurs"
  (^Integer [^java.io.FilterReader this cbuf ^Integer off ^Integer len]
    (-> this (.read cbuf off len)))
  (^Integer [^java.io.FilterReader this]
    (-> this (.read))))

(defn skip
  "Skips characters.

  n - The number of characters to skip - `long`

  returns: The number of characters actually skipped - `long`

  throws: java.io.IOException - If an I/O error occurs"
  (^Long [^java.io.FilterReader this ^Long n]
    (-> this (.skip n))))

(defn ready
  "Tells whether this stream is ready to be read.

  returns: True if the next read() is guaranteed not to block for input,
   false otherwise.  Note that returning false does not guarantee that the
   next read will block. - `boolean`

  throws: java.io.IOException - If an I/O error occurs"
  (^Boolean [^java.io.FilterReader this]
    (-> this (.ready))))

(defn mark-supported
  "Tells whether this stream supports the mark() operation.

  returns: true if and only if this stream supports the mark operation. - `boolean`"
  (^Boolean [^java.io.FilterReader this]
    (-> this (.markSupported))))

(defn mark
  "Marks the present position in the stream.

  read-ahead-limit - Limit on the number of characters that may be read while still preserving the mark. After reading this many characters, attempting to reset the stream may fail. - `int`

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.FilterReader this ^Integer read-ahead-limit]
    (-> this (.mark read-ahead-limit))))

(defn reset
  "Resets the stream.

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.FilterReader this]
    (-> this (.reset))))

(defn close
  "Description copied from class: Reader

  throws: java.io.IOException - If an I/O error occurs"
  ([^java.io.FilterReader this]
    (-> this (.close))))

