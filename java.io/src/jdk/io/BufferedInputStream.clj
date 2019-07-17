(ns jdk.io.BufferedInputStream
  "A BufferedInputStream adds
  functionality to another input stream-namely,
  the ability to buffer the input and to
  support the mark and reset
  methods. When  the BufferedInputStream
  is created, an internal buffer array is
  created. As bytes  from the stream are read
  or skipped, the internal buffer is refilled
  as necessary  from the contained input stream,
  many bytes at a time. The mark
  operation  remembers a point in the input
  stream and the reset operation
  causes all the  bytes read since the most
  recent mark operation to be
  reread before new bytes are  taken from
  the contained input stream."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io BufferedInputStream]))

(defn ->buffered-input-stream
  "Constructor.

  Creates a BufferedInputStream
   with the specified buffer size,
   and saves its  argument, the input stream
   in, for later use.  An internal
   buffer array of length  size
   is created and stored in buf.

  in - the underlying input stream. - `java.io.InputStream`
  size - the buffer size. - `int`

  throws: java.lang.IllegalArgumentException - if size <= 0."
  ([in size]
    (new BufferedInputStream in size))
  ([in]
    (new BufferedInputStream in)))

(defn read
  "Reads bytes from this byte-input stream into the specified byte array,
   starting at the given offset.

    This method implements the general contract of the corresponding
   read method of
   the InputStream class.  As an additional
   convenience, it attempts to read as many bytes as possible by repeatedly
   invoking the read method of the underlying stream.  This
   iterated read continues until one of the following
   conditions becomes true:

      The specified number of bytes have been read,

      The read method of the underlying stream returns
     -1, indicating end-of-file, or

      The available method of the underlying stream
     returns zero, indicating that further input requests would block.

    If the first read on the underlying stream returns
   -1 to indicate end-of-file then this method returns
   -1.  Otherwise this method returns the number of bytes
   actually read.

    Subclasses of this class are encouraged, but not required, to
   attempt to read as many bytes as possible in the same fashion.

  b - destination buffer. - `byte[]`
  off - offset at which to start storing bytes. - `int`
  len - maximum number of bytes to read. - `int`

  returns: the number of bytes read, or -1 if the end of
               the stream has been reached. - `int`

  throws: java.io.IOException - if this input stream has been closed by invoking its close() method, or an I/O error occurs."
  ([this b off len]
    (-> this (.read b off len)))
  ([this]
    (-> this (.read))))

(defn skip
  "See the general contract of the skip
   method of InputStream.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if the stream does not support seek, or if this input stream has been closed by invoking its close() method, or an I/O error occurs."
  ([this n]
    (-> this (.skip n))))

(defn available
  "Returns an estimate of the number of bytes that can be read (or
   skipped over) from this input stream without blocking by the next
   invocation of a method for this input stream. The next invocation might be
   the same thread or another thread.  A single read or skip of this
   many bytes will not block, but may read or skip fewer bytes.

   This method returns the sum of the number of bytes remaining to be read in
   the buffer (count - pos) and the result of calling the
   in.available().

  returns: an estimate of the number of bytes that can be read (or skipped
               over) from this input stream without blocking. - `int`

  throws: java.io.IOException - if this input stream has been closed by invoking its close() method, or an I/O error occurs."
  ([this]
    (-> this (.available))))

(defn mark
  "See the general contract of the mark
   method of InputStream.

  readlimit - the maximum limit of bytes that can be read before the mark position becomes invalid. - `int`"
  ([this readlimit]
    (-> this (.mark readlimit))))

(defn reset
  "See the general contract of the reset
   method of InputStream.

   If markpos is -1
   (no mark has been set or the mark has been
   invalidated), an IOException
   is thrown. Otherwise, pos is
   set equal to markpos.

  throws: java.io.IOException - if this stream has not been marked or, if the mark has been invalidated, or the stream has been closed by invoking its close() method, or an I/O error occurs."
  ([this]
    (-> this (.reset))))

(defn mark-supported
  "Tests if this input stream supports the mark
   and reset methods. The markSupported
   method of BufferedInputStream returns
   true.

  returns: a boolean indicating if this stream type supports
            the mark and reset methods. - `boolean`"
  ([this]
    (-> this (.markSupported))))

(defn close
  "Closes this input stream and releases any system resources
   associated with the stream.
   Once the stream has been closed, further read(), available(), reset(),
   or skip() invocations will throw an IOException.
   Closing a previously closed stream has no effect.

  throws: java.io.IOException - if an I/O error occurs."
  ([this]
    (-> this (.close))))

