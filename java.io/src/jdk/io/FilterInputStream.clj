(ns jdk.io.FilterInputStream
  "A FilterInputStream contains
  some other input stream, which it uses as
  its  basic source of data, possibly transforming
  the data along the way or providing  additional
  functionality. The class FilterInputStream
  itself simply overrides all  methods of
  InputStream with versions that
  pass all requests to the contained  input
  stream. Subclasses of FilterInputStream
  may further override some of  these methods
  and may also provide additional methods
  and fields."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io FilterInputStream]))

(defn read
  "Reads up to len bytes of data from this input stream
   into an array of bytes. If len is not zero, the method
   blocks until some input is available; otherwise, no
   bytes are read and 0 is returned.

   This method simply performs in.read(b, off, len)
   and returns the result.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the stream has been reached. - `int`

  throws: java.lang.NullPointerException - If b is null."
  (^Integer [^FilterInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^FilterInputStream this b]
    (-> this (.read b)))
  (^Integer [^FilterInputStream this]
    (-> this (.read))))

(defn skip
  "Skips over and discards n bytes of data from the
   input stream. The skip method may, for a variety of
   reasons, end up skipping over some smaller number of bytes,
   possibly 0. The actual number of bytes skipped is
   returned.

   This method simply performs in.skip(n).

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if the stream does not support seek, or if some other I/O error occurs."
  (^Long [^FilterInputStream this ^Long n]
    (-> this (.skip n))))

(defn available
  "Returns an estimate of the number of bytes that can be read (or
   skipped over) from this input stream without blocking by the next
   caller of a method for this input stream. The next caller might be
   the same thread or another thread.  A single read or skip of this
   many bytes will not block, but may read or skip fewer bytes.

   This method returns the result of in.available().

  returns: an estimate of the number of bytes that can be read (or skipped
               over) from this input stream without blocking. - `int`

  throws: java.io.IOException - if an I/O error occurs."
  (^Integer [^FilterInputStream this]
    (-> this (.available))))

(defn close
  "Closes this input stream and releases any system resources
   associated with the stream.
   This
   method simply performs in.close().

  throws: java.io.IOException - if an I/O error occurs."
  ([^FilterInputStream this]
    (-> this (.close))))

(defn mark
  "Marks the current position in this input stream. A subsequent
   call to the reset method repositions this stream at
   the last marked position so that subsequent reads re-read the same bytes.

   The readlimit argument tells this input stream to
   allow that many bytes to be read before the mark position gets
   invalidated.

   This method simply performs in.mark(readlimit).

  readlimit - the maximum limit of bytes that can be read before the mark position becomes invalid. - `int`"
  ([^FilterInputStream this ^Integer readlimit]
    (-> this (.mark readlimit))))

(defn reset
  "Repositions this stream to the position at the time the
   mark method was last called on this input stream.

   This method
   simply performs in.reset().

   Stream marks are intended to be used in
   situations where you need to read ahead a little to see what's in
   the stream. Often this is most easily done by invoking some
   general parser. If the stream is of the type handled by the
   parse, it just chugs along happily. If the stream is not of
   that type, the parser should toss an exception when it fails.
   If this happens within readlimit bytes, it allows the outer
   code to reset the stream and try another parser.

  throws: java.io.IOException - if the stream has not been marked or if the mark has been invalidated."
  ([^FilterInputStream this]
    (-> this (.reset))))

(defn mark-supported
  "Tests if this input stream supports the mark
   and reset methods.
   This method
   simply performs in.markSupported().

  returns: true if this stream type supports the
            mark and reset method;
            false otherwise. - `boolean`"
  (^Boolean [^FilterInputStream this]
    (-> this (.markSupported))))

