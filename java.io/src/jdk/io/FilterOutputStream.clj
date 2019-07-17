(ns jdk.io.FilterOutputStream
  "This class is the superclass of all classes that filter output
  streams. These streams sit on top of an already existing output
  stream (the underlying output stream) which it uses as its
  basic sink of data, but possibly transforming the data along the
  way or providing additional functionality.

  The class FilterOutputStream itself simply overrides
  all methods of OutputStream with versions that pass
  all requests to the underlying output stream. Subclasses of
  FilterOutputStream may further override some of these
  methods as well as provide additional methods and fields."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FilterOutputStream]))

(defn ->filter-output-stream
  "Constructor.

  Creates an output stream filter built on top of the specified
   underlying output stream.

  out - the underlying output stream to be assigned to the field this.out for later use, or null if this instance is to be created without an underlying stream. - `java.io.OutputStream`"
  ([^java.io.OutputStream out]
    (new FilterOutputStream out)))

(defn write
  "Writes len bytes from the specified
   byte array starting at offset off to
   this output stream.

   The write method of FilterOutputStream
   calls the write method of one argument on each
   byte to output.

   Note that this method does not call the write method
   of its underlying input stream with the same arguments. Subclasses
   of FilterOutputStream should provide a more efficient
   implementation of this method.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FilterOutputStream this b ^Integer off ^Integer len]
    (-> this (.write b off len)))
  ([^java.io.FilterOutputStream this ^Integer b]
    (-> this (.write b))))

(defn flush
  "Flushes this output stream and forces any buffered output bytes
   to be written out to the stream.

   The flush method of FilterOutputStream
   calls the flush method of its underlying output stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FilterOutputStream this]
    (-> this (.flush))))

(defn close
  "Closes this output stream and releases any system resources
   associated with the stream.

   The close method of FilterOutputStream
   calls its flush method, and then calls the
   close method of its underlying output stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.FilterOutputStream this]
    (-> this (.close))))

