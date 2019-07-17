(ns jdk.util.zip.GZIPOutputStream
  "This class implements a stream filter for writing compressed data in
  the GZIP file format."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip GZIPOutputStream]))

(defn ->gzip-output-stream
  "Constructor.

  Creates a new output stream with the specified buffer size and
   flush mode.

  out - the output stream - `java.io.OutputStream`
  size - the output buffer size - `int`
  sync-flush - if true invocation of the inherited flush() method of this instance flushes the compressor with flush mode Deflater.SYNC_FLUSH before flushing the output stream, otherwise only flushes the output stream - `boolean`

  throws: java.io.IOException - If an I/O error has occurred."
  ([^java.io.OutputStream out ^Integer size ^Boolean sync-flush]
    (new GZIPOutputStream out size sync-flush))
  ([^java.io.OutputStream out ^Integer size]
    (new GZIPOutputStream out size))
  ([^java.io.OutputStream out]
    (new GZIPOutputStream out)))

(defn write
  "Writes array of bytes to the compressed output stream. This method
   will block until all the bytes are written.

  buf - the data to be written - `byte[]`
  off - the start offset of the data - `int`
  len - the length of the data - `int`

  throws: java.io.IOException - If an I/O error has occurred."
  ([^java.util.zip.GZIPOutputStream this buf ^Integer off ^Integer len]
    (-> this (.write buf off len))))

(defn finish
  "Finishes writing compressed data to the output stream without closing
   the underlying stream. Use this method when applying multiple filters
   in succession to the same output stream.

  throws: java.io.IOException - if an I/O error has occurred"
  ([^java.util.zip.GZIPOutputStream this]
    (-> this (.finish))))

