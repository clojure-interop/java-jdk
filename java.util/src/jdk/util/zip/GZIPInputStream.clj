(ns jdk.util.zip.GZIPInputStream
  "This class implements a stream filter for reading compressed data in
  the GZIP file format."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip GZIPInputStream]))

(defn ->gzip-input-stream
  "Constructor.

  Creates a new input stream with the specified buffer size.

  in - the input stream - `java.io.InputStream`
  size - the input buffer size - `int`

  throws: java.util.zip.ZipException - if a GZIP format error has occurred or the compression method used is unsupported"
  (^GZIPInputStream [^java.io.InputStream in ^Integer size]
    (new GZIPInputStream in size))
  (^GZIPInputStream [^java.io.InputStream in]
    (new GZIPInputStream in)))

(def *-gzip-magic
  "Static Constant.

  GZIP header magic number.

  type: int"
  GZIPInputStream/GZIP_MAGIC)

(defn read
  "Reads uncompressed data into an array of bytes. If len is not
   zero, the method will block until some input can be decompressed; otherwise,
   no bytes are read and 0 is returned.

  buf - the buffer into which the data is read - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read - `int`

  returns: the actual number of bytes read, or -1 if the end of the
            compressed input stream is reached - `int`

  throws: java.lang.NullPointerException - If buf is null."
  (^Integer [^GZIPInputStream this buf ^Integer off ^Integer len]
    (-> this (.read buf off len))))

(defn close
  "Closes this input stream and releases any system resources associated
   with the stream.

  throws: java.io.IOException - if an I/O error has occurred"
  ([^GZIPInputStream this]
    (-> this (.close))))

