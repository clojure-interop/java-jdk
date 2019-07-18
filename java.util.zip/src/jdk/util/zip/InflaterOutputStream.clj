(ns jdk.util.zip.InflaterOutputStream
  "Implements an output stream filter for uncompressing data stored in the
  `deflate` compression format."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip InflaterOutputStream]))

(defn ->inflater-output-stream
  "Constructor.

  Creates a new output stream with the specified decompressor and
   buffer size.

  out - output stream to write the uncompressed data to - `java.io.OutputStream`
  infl - decompressor (`inflater`) for this stream - `java.util.zip.Inflater`
  buf-len - decompression buffer size - `int`

  throws: java.lang.IllegalArgumentException - if bufLen <= 0"
  (^InflaterOutputStream [^java.io.OutputStream out ^java.util.zip.Inflater infl ^Integer buf-len]
    (new InflaterOutputStream out infl buf-len))
  (^InflaterOutputStream [^java.io.OutputStream out ^java.util.zip.Inflater infl]
    (new InflaterOutputStream out infl))
  (^InflaterOutputStream [^java.io.OutputStream out]
    (new InflaterOutputStream out)))

(defn close
  "Writes any remaining uncompressed data to the output stream and closes
   the underlying output stream.

  throws: java.io.IOException - if an I/O error occurs"
  ([^InflaterOutputStream this]
    (-> this (.close))))

(defn flush
  "Flushes this output stream, forcing any pending buffered output bytes to be
   written.

  throws: java.io.IOException - if an I/O error occurs or this stream is already closed"
  ([^InflaterOutputStream this]
    (-> this (.flush))))

(defn finish
  "Finishes writing uncompressed data to the output stream without closing
   the underlying stream.  Use this method when applying multiple filters in
   succession to the same output stream.

  throws: java.io.IOException - if an I/O error occurs or this stream is already closed"
  ([^InflaterOutputStream this]
    (-> this (.finish))))

(defn write
  "Writes an array of bytes to the uncompressed output stream.

  b - buffer containing compressed data to decompress and write to the output stream - `byte[]`
  off - starting offset of the compressed data within b - `int`
  len - number of bytes to decompress from b - `int`

  throws: java.lang.IndexOutOfBoundsException - if off < 0, or if len < 0, or if len > b.length - off"
  ([^InflaterOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^InflaterOutputStream this ^Integer b]
    (-> this (.write b))))

