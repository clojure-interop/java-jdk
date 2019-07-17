(ns jdk.io.BufferedOutputStream
  "The class implements a buffered output stream. By setting up such
  an output stream, an application can write bytes to the underlying
  output stream without necessarily causing a call to the underlying
  system for each byte written."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io BufferedOutputStream]))

(defn ->buffered-output-stream
  "Constructor.

  Creates a new buffered output stream to write data to the
   specified underlying output stream with the specified buffer
   size.

  out - the underlying output stream. - `java.io.OutputStream`
  size - the buffer size. - `int`

  throws: java.lang.IllegalArgumentException - if size <= 0."
  ([^java.io.OutputStream out ^Integer size]
    (new BufferedOutputStream out size))
  ([^java.io.OutputStream out]
    (new BufferedOutputStream out)))

(defn write
  "Writes len bytes from the specified byte array
   starting at offset off to this buffered output stream.

    Ordinarily this method stores bytes from the given array into this
   stream's buffer, flushing the buffer to the underlying output stream as
   needed.  If the requested length is at least as large as this stream's
   buffer, however, then this method will flush the buffer and write the
   bytes directly to the underlying output stream.  Thus redundant
   BufferedOutputStreams will not copy data unnecessarily.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.BufferedOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^java.io.BufferedOutputStream this ^Integer b]
    (-> this (.write b))))

(defn flush
  "Flushes this buffered output stream. This forces any buffered
   output bytes to be written out to the underlying output stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.BufferedOutputStream this]
    (-> this (.flush))))

