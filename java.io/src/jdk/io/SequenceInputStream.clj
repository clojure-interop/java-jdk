(ns jdk.io.SequenceInputStream
  "A SequenceInputStream represents
  the logical concatenation of other input
  streams. It starts out with an ordered
  collection of input streams and reads from
  the first one until end of file is reached,
  whereupon it reads from the second one,
  and so on, until end of file is reached
  on the last of the contained input streams."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io SequenceInputStream]))

(defn ->sequence-input-stream
  "Constructor.

  Initializes a newly
   created SequenceInputStream
   by remembering the two arguments, which
   will be read in order, first s1
   and then s2, to provide the
   bytes to be read from this SequenceInputStream.

  s-1 - the first input stream to read. - `java.io.InputStream`
  s-2 - the second input stream to read. - `java.io.InputStream`"
  ([^java.io.InputStream s-1 ^java.io.InputStream s-2]
    (new SequenceInputStream s-1 s-2))
  ([^java.io.InputStream> e]
    (new SequenceInputStream e)))

(defn available
  "Returns an estimate of the number of bytes that can be read (or
   skipped over) from the current underlying input stream without
   blocking by the next invocation of a method for the current
   underlying input stream. The next invocation might be
   the same thread or another thread.  A single read or skip of this
   many bytes will not block, but may read or skip fewer bytes.

   This method simply calls available of the current underlying
   input stream and returns the result.

  returns: an estimate of the number of bytes that can be read (or
           skipped over) from the current underlying input stream
           without blocking or 0 if this input stream
           has been closed by invoking its close() method - `int`

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.SequenceInputStream this]
    (-> this (.available))))

(defn read
  "Reads up to len bytes of data from this input stream
   into an array of bytes.  If len is not zero, the method
   blocks until at least 1 byte of input is available; otherwise, no
   bytes are read and 0 is returned.

   The read method of SequenceInputStream
   tries to read the data from the current substream. If it fails to
   read any characters because the substream has reached the end of
   the stream, it calls the close method of the current
   substream and begins reading from the next substream.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in array b at which the data is written. - `int`
  len - the maximum number of bytes read. - `int`

  returns: int   the number of bytes read. - `int`

  throws: java.lang.NullPointerException - If b is null."
  ([^java.io.SequenceInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  ([^java.io.SequenceInputStream this]
    (-> this (.read))))

(defn close
  "Closes this input stream and releases any system resources
   associated with the stream.
   A closed SequenceInputStream
   cannot  perform input operations and cannot
   be reopened.

   If this stream was created
   from an enumeration, all remaining elements
   are requested from the enumeration and closed
   before the close method returns.

  throws: java.io.IOException - if an I/O error occurs."
  ([^java.io.SequenceInputStream this]
    (-> this (.close))))

