(ns jdk.io.PipedWriter
  "Piped character-output streams."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PipedWriter]))

(defn ->piped-writer
  "Constructor.

  Creates a piped writer connected to the specified piped
   reader. Data characters written to this stream will then be
   available as input from snk.

  snk - The piped reader to connect to. - `java.io.PipedReader`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.PipedReader snk]
    (new PipedWriter snk))
  ([]
    (new PipedWriter )))

(defn connect
  "Connects this piped writer to a receiver. If this object
   is already connected to some other piped reader, an
   IOException is thrown.

   If snk is an unconnected piped reader and
   src is an unconnected piped writer, they may
   be connected by either the call:


   src.connect(snk)
   or the call:


   snk.connect(src)
   The two calls have the same effect.

  snk - the piped reader to connect to. - `java.io.PipedReader`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.PipedWriter this ^java.io.PipedReader snk]
    (-> this (.connect snk))))

(defn write
  "Writes len characters from the specified character array
   starting at offset off to this piped output stream.
   This method blocks until all the characters are written to the output
   stream.
   If a thread was reading data characters from the connected piped input
   stream, but the thread is no longer alive, then an
   IOException is thrown.

  cbuf - the data. - `char[]`
  off - the start offset in the data. - `int`
  len - the number of characters to write. - `int`

  throws: java.io.IOException - if the pipe is broken, unconnected, closed or an I/O error occurs."
  ([^java.io.PipedWriter this cbuf ^Integer off ^Integer len]
    (-> this (.write cbuf off len)))
  ([^java.io.PipedWriter this ^Integer c]
    (-> this (.write c))))

(defn flush
  "Flushes this output stream and forces any buffered output characters
   to be written out.
   This will notify any readers that characters are waiting in the pipe.

  throws: java.io.IOException - if the pipe is closed, or an I/O error occurs."
  ([^java.io.PipedWriter this]
    (-> this (.flush))))

(defn close
  "Closes this piped output stream and releases any system resources
   associated with this stream. This stream may no longer be used for
   writing characters.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.PipedWriter this]
    (-> this (.close))))

