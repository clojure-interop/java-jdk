(ns jdk.io.PipedReader
  "Piped character-input streams."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PipedReader]))

(defn ->piped-reader
  "Constructor.

  Creates a PipedReader so that it is connected
   to the piped writer src and uses the specified
   pipe size for the pipe's buffer. Data written to src
   will then be  available as input from this stream.

  src - the stream to connect to. - `java.io.PipedWriter`
  pipe-size - the size of the pipe's buffer. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.PipedWriter src ^Integer pipe-size]
    (new PipedReader src pipe-size))
  ([^java.io.PipedWriter src]
    (new PipedReader src))
  ([]
    (new PipedReader )))

(defn connect
  "Causes this piped reader to be connected
   to the piped  writer src.
   If this object is already connected to some
   other piped writer, an IOException
   is thrown.

   If src is an
   unconnected piped writer and snk
   is an unconnected piped reader, they
   may be connected by either the call:



  snk.connect(src)

   or the call:



  src.connect(snk)

   The two calls have the same effect.

  src - The piped writer to connect to. - `java.io.PipedWriter`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.PipedReader this ^java.io.PipedWriter src]
    (-> this (.connect src))))

(defn read
  "Reads up to len characters of data from this piped
   stream into an array of characters. Less than len characters
   will be read if the end of the data stream is reached or if
   len exceeds the pipe's buffer size. This method
   blocks until at least one character of input is available.

  cbuf - the buffer into which the data is read. - `char[]`
  off - the start offset of the data. - `int`
  len - the maximum number of characters read. - `int`

  returns: the total number of characters read into the buffer, or
               -1 if there is no more data because the end of
               the stream has been reached. - `int`

  throws: java.io.IOException - if the pipe is broken, unconnected, closed, or an I/O error occurs."
  (^Integer [^java.io.PipedReader this cbuf ^Integer off ^Integer len]
    (-> this (.read cbuf off len)))
  (^Integer [^java.io.PipedReader this]
    (-> this (.read))))

(defn ready
  "Tell whether this stream is ready to be read.  A piped character
   stream is ready if the circular buffer is not empty.

  returns: True if the next read() is guaranteed not to block for input,
   false otherwise.  Note that returning false does not guarantee that the
   next read will block. - `boolean`

  throws: java.io.IOException - if the pipe is broken, unconnected, or closed."
  (^Boolean [^java.io.PipedReader this]
    (-> this (.ready))))

(defn close
  "Closes this piped stream and releases any system resources
   associated with the stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.PipedReader this]
    (-> this (.close))))

