(ns jdk.io.PipedInputStream
  "A piped input stream should be connected
  to a piped output stream; the piped  input
  stream then provides whatever data bytes
  are written to the piped output  stream.
  Typically, data is read from a PipedInputStream
  object by one thread  and data is written
  to the corresponding PipedOutputStream
  by some  other thread. Attempting to use
  both objects from a single thread is not
  recommended, as it may deadlock the thread.
  The piped input stream contains a buffer,
  decoupling read operations from write operations,
  within limits.
  A pipe is said to be  broken  if a
  thread that was providing data bytes to the connected
  piped output stream is no longer alive."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PipedInputStream]))

(defn ->piped-input-stream
  "Constructor.

  Creates a PipedInputStream so that it is
   connected to the piped output stream
   src and uses the specified pipe size for
   the pipe's buffer.
   Data bytes written to src will then
   be available as input from this stream.

  src - the stream to connect to. - `java.io.PipedOutputStream`
  pipe-size - the size of the pipe's buffer. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([src pipe-size]
    (new PipedInputStream src pipe-size))
  ([src]
    (new PipedInputStream src))
  ([]
    (new PipedInputStream )))

(defn connect
  "Causes this piped input stream to be connected
   to the piped  output stream src.
   If this object is already connected to some
   other piped output  stream, an IOException
   is thrown.

   If src is an
   unconnected piped output stream and snk
   is an unconnected piped input stream, they
   may be connected by either the call:



  snk.connect(src)

   or the call:



  src.connect(snk)

   The two calls have the same effect.

  src - The piped output stream to connect to. - `java.io.PipedOutputStream`

  throws: java.io.IOException - if an I/O error occurs."
  ([this src]
    (-> this (.connect src))))

(defn read
  "Reads up to len bytes of data from this piped input
   stream into an array of bytes. Less than len bytes
   will be read if the end of the data stream is reached or if
   len exceeds the pipe's buffer size.
   If len  is zero, then no bytes are read and 0 is returned;
   otherwise, the method blocks until at least 1 byte of input is
   available, end of the stream has been detected, or an exception is
   thrown.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the stream has been reached. - `int`

  throws: java.lang.NullPointerException - If b is null."
  ([this b off len]
    (-> this (.read b off len)))
  ([this]
    (-> this (.read))))

(defn available
  "Returns the number of bytes that can be read from this input
   stream without blocking.

  returns: the number of bytes that can be read from this input stream
           without blocking, or 0 if this input stream has been
           closed by invoking its close() method, or if the pipe
           is unconnected, or
             broken. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.available))))

(defn close
  "Closes this piped input stream and releases any system resources
   associated with the stream.

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.close))))

