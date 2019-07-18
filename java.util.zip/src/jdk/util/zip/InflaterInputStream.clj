(ns jdk.util.zip.InflaterInputStream
  "This class implements a stream filter for uncompressing data in the
  `deflate` compression format. It is also used as the basis for other
  decompression filters, such as GZIPInputStream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip InflaterInputStream]))

(defn ->inflater-input-stream
  "Constructor.

  Creates a new input stream with the specified decompressor and
   buffer size.

  in - the input stream - `java.io.InputStream`
  inf - the decompressor (`inflater`) - `java.util.zip.Inflater`
  size - the input buffer size - `int`

  throws: java.lang.IllegalArgumentException - if size <= 0"
  (^InflaterInputStream [^java.io.InputStream in ^java.util.zip.Inflater inf ^Integer size]
    (new InflaterInputStream in inf size))
  (^InflaterInputStream [^java.io.InputStream in ^java.util.zip.Inflater inf]
    (new InflaterInputStream in inf))
  (^InflaterInputStream [^java.io.InputStream in]
    (new InflaterInputStream in)))

(defn read
  "Reads uncompressed data into an array of bytes. If len is not
   zero, the method will block until some input can be decompressed; otherwise,
   no bytes are read and 0 is returned.

  b - the buffer into which the data is read - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read - `int`

  returns: the actual number of bytes read, or -1 if the end of the
           compressed input is reached or a preset dictionary is needed - `int`

  throws: java.lang.NullPointerException - If b is null."
  (^Integer [^InflaterInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^InflaterInputStream this]
    (-> this (.read))))

(defn available
  "Returns 0 after EOF has been reached, otherwise always return 1.

   Programs should not count on this method to return the actual number
   of bytes that could be read without blocking.

  returns: 1 before EOF and 0 after EOF. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^InflaterInputStream this]
    (-> this (.available))))

(defn skip
  "Skips specified number of bytes of uncompressed data.

  n - the number of bytes to skip - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if an I/O error has occurred"
  (^Long [^InflaterInputStream this ^Long n]
    (-> this (.skip n))))

(defn close
  "Closes this input stream and releases any system resources associated
   with the stream.

  throws: java.io.IOException - if an I/O error has occurred"
  ([^InflaterInputStream this]
    (-> this (.close))))

(defn mark-supported
  "Tests if this input stream supports the mark and
   reset methods. The markSupported
   method of InflaterInputStream returns
   false.

  returns: a boolean indicating if this stream type supports
            the mark and reset methods. - `boolean`"
  (^Boolean [^InflaterInputStream this]
    (-> this (.markSupported))))

(defn mark
  "Marks the current position in this input stream.

    The mark method of InflaterInputStream
   does nothing.

  readlimit - the maximum limit of bytes that can be read before the mark position becomes invalid. - `int`"
  ([^InflaterInputStream this ^Integer readlimit]
    (-> this (.mark readlimit))))

(defn reset
  "Repositions this stream to the position at the time the
   mark method was last called on this input stream.

    The method reset for class
   InflaterInputStream does nothing except throw an
   IOException.

  throws: java.io.IOException - if this method is invoked."
  ([^InflaterInputStream this]
    (-> this (.reset))))

