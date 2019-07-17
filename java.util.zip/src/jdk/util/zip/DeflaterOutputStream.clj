(ns jdk.util.zip.DeflaterOutputStream
  "This class implements an output stream filter for compressing data in
  the `deflate` compression format. It is also used as the basis for other
  types of compression filters, such as GZIPOutputStream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip DeflaterOutputStream]))

(defn ->deflater-output-stream
  "Constructor.

  Creates a new output stream with the specified compressor,
   buffer size and flush mode.

  out - the output stream - `java.io.OutputStream`
  def - the compressor (`deflater`) - `java.util.zip.Deflater`
  size - the output buffer size - `int`
  sync-flush - if true the flush() method of this instance flushes the compressor with flush mode Deflater.SYNC_FLUSH before flushing the output stream, otherwise only flushes the output stream - `boolean`

  throws: java.lang.IllegalArgumentException - if size <= 0"
  ([out def size sync-flush]
    (new DeflaterOutputStream out def size sync-flush))
  ([out def size]
    (new DeflaterOutputStream out def size))
  ([out def]
    (new DeflaterOutputStream out def))
  ([out]
    (new DeflaterOutputStream out)))

(defn write
  "Writes an array of bytes to the compressed output stream. This
   method will block until all the bytes are written.

  b - the data to be written - `byte[]`
  off - the start offset of the data - `int`
  len - the length of the data - `int`

  throws: java.io.IOException - if an I/O error has occurred"
  ([this b off len]
    (-> this (.write b off len)))
  ([this b]
    (-> this (.write b))))

(defn finish
  "Finishes writing compressed data to the output stream without closing
   the underlying stream. Use this method when applying multiple filters
   in succession to the same output stream.

  throws: java.io.IOException - if an I/O error has occurred"
  ([this]
    (-> this (.finish))))

(defn close
  "Writes remaining compressed data to the output stream and closes the
   underlying stream.

  throws: java.io.IOException - if an I/O error has occurred"
  ([this]
    (-> this (.close))))

(defn flush
  "Flushes the compressed output stream.

   If syncFlush is true when this compressed output stream is
   constructed, this method first flushes the underlying compressor
   with the flush mode Deflater.SYNC_FLUSH to force
   all pending data to be flushed out to the output stream and then
   flushes the output stream. Otherwise this method only flushes the
   output stream without flushing the compressor.

  throws: java.io.IOException - if an I/O error has occurred"
  ([this]
    (-> this (.flush))))

