(ns jdk.io.PipedOutputStream
  "A piped output stream can be connected to a piped input stream
  to create a communications pipe. The piped output stream is the
  sending end of the pipe. Typically, data is written to a
  PipedOutputStream object by one thread and data is
  read from the connected PipedInputStream by some
  other thread. Attempting to use both objects from a single thread
  is not recommended as it may deadlock the thread.
  The pipe is said to be  broken  if a
  thread that was reading data bytes from the connected piped input
  stream is no longer alive."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PipedOutputStream]))

(defn ->piped-output-stream
  "Constructor.

  Creates a piped output stream connected to the specified piped
   input stream. Data bytes written to this stream will then be
   available as input from snk.

  snk - The piped input stream to connect to. - `java.io.PipedInputStream`

  throws: java.io.IOException - if an I/O error occurs."
  ([snk]
    (new PipedOutputStream snk))
  ([]
    (new PipedOutputStream )))

(defn connect
  "Connects this piped output stream to a receiver. If this object
   is already connected to some other piped input stream, an
   IOException is thrown.

   If snk is an unconnected piped input stream and
   src is an unconnected piped output stream, they may
   be connected by either the call:


   src.connect(snk)
   or the call:


   snk.connect(src)
   The two calls have the same effect.

  snk - the piped input stream to connect to. - `java.io.PipedInputStream`

  throws: java.io.IOException - if an I/O error occurs."
  ([this snk]
    (-> this (.connect snk))))

(defn write
  "Writes len bytes from the specified byte array
   starting at offset off to this piped output stream.
   This method blocks until all the bytes are written to the output
   stream.

  b - the data. - `byte[]`
  off - the start offset in the data. - `int`
  len - the number of bytes to write. - `int`

  throws: java.io.IOException - if the pipe is broken, unconnected, closed, or if an I/O error occurs."
  ([this b off len]
    (-> this (.write b off len)))
  ([this b]
    (-> this (.write b))))

(defn flush
  "Flushes this output stream and forces any buffered output bytes
   to be written out.
   This will notify any readers that bytes are waiting in the pipe.

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.flush))))

(defn close
  "Closes this piped output stream and releases any system resources
   associated with this stream. This stream may no longer be used for
   writing bytes.

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.close))))

