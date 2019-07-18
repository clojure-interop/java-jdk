(ns jdk.util.zip.DeflaterInputStream
  "Implements an input stream filter for compressing data in the `deflate`
  compression format."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip DeflaterInputStream]))

(defn ->deflater-input-stream
  "Constructor.

  Creates a new input stream with the specified compressor and buffer
   size.

  in - input stream to read the uncompressed data to - `java.io.InputStream`
  defl - compressor (`deflater`) for this stream - `java.util.zip.Deflater`
  buf-len - compression buffer size - `int`

  throws: java.lang.IllegalArgumentException - if bufLen <= 0"
  (^DeflaterInputStream [^java.io.InputStream in ^java.util.zip.Deflater defl ^Integer buf-len]
    (new DeflaterInputStream in defl buf-len))
  (^DeflaterInputStream [^java.io.InputStream in ^java.util.zip.Deflater defl]
    (new DeflaterInputStream in defl))
  (^DeflaterInputStream [^java.io.InputStream in]
    (new DeflaterInputStream in)))

(defn close
  "Closes this input stream and its underlying input stream, discarding
   any pending uncompressed data.

  throws: java.io.IOException - if an I/O error occurs"
  ([^DeflaterInputStream this]
    (-> this (.close))))

(defn read
  "Reads compressed data into a byte array.
   This method will block until some input can be read and compressed.

  b - buffer into which the data is read - `byte[]`
  off - starting offset of the data within b - `int`
  len - maximum number of compressed bytes to read into b - `int`

  returns: the actual number of bytes read, or -1 if the end of the
   uncompressed input stream is reached - `int`

  throws: java.lang.IndexOutOfBoundsException - if len > b.length - off"
  (^Integer [^DeflaterInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^DeflaterInputStream this]
    (-> this (.read))))

(defn skip
  "Skips over and discards data from the input stream.
   This method may block until the specified number of bytes are read and
   skipped. Note: While n is given as a long,
   the maximum number of bytes which can be skipped is
   Integer.MAX_VALUE.

  n - number of bytes to be skipped - `long`

  returns: the actual number of bytes skipped - `long`

  throws: java.io.IOException - if an I/O error occurs or if this stream is already closed"
  (^Long [^DeflaterInputStream this ^Long n]
    (-> this (.skip n))))

(defn available
  "Returns 0 after EOF has been reached, otherwise always return 1.

   Programs should not count on this method to return the actual number
   of bytes that could be read without blocking

  returns: zero after the end of the underlying input stream has been
   reached, otherwise always returns 1 - `int`

  throws: java.io.IOException - if an I/O error occurs or if this stream is already closed"
  (^Integer [^DeflaterInputStream this]
    (-> this (.available))))

(defn mark-supported
  "Always returns false because this input stream does not support
   the mark() and reset() methods.

  returns: false, always - `boolean`"
  (^Boolean [^DeflaterInputStream this]
    (-> this (.markSupported))))

(defn mark
  "This operation is not supported.

  limit - maximum bytes that can be read before invalidating the position marker - `int`"
  ([^DeflaterInputStream this ^Integer limit]
    (-> this (.mark limit))))

(defn reset
  "This operation is not supported.

  throws: java.io.IOException - always thrown"
  ([^DeflaterInputStream this]
    (-> this (.reset))))

