(ns jdk.io.PushbackInputStream
  "A PushbackInputStream adds
  functionality to another input stream, namely
  the  ability to \"push back\" or \"unread\"
  one byte. This is useful in situations where
  it is  convenient for a fragment of code
  to read an indefinite number of data bytes
  that  are delimited by a particular byte
  value; after reading the terminating byte,
  the  code fragment can \"unread\" it, so that
  the next read operation on the input stream
  will reread the byte that was pushed back.
  For example, bytes representing the  characters
  constituting an identifier might be terminated
  by a byte representing an  operator character;
  a method whose job is to read just an identifier
  can read until it  sees the operator and
  then push the operator back to be re-read."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io PushbackInputStream]))

(defn ->pushback-input-stream
  "Constructor.

  Creates a PushbackInputStream
   with a pushback buffer of the specified size,
   and saves its  argument, the input stream
   in, for later use. Initially,
   there is no pushed-back byte  (the field
   pushBack is initialized to
   -1).

  in - the input stream from which bytes will be read. - `java.io.InputStream`
  size - the size of the pushback buffer. - `int`

  throws: java.lang.IllegalArgumentException - if size <= 0"
  (^PushbackInputStream [^java.io.InputStream in ^Integer size]
    (new PushbackInputStream in size))
  (^PushbackInputStream [^java.io.InputStream in]
    (new PushbackInputStream in)))

(defn read
  "Reads up to len bytes of data from this input stream into
   an array of bytes.  This method first reads any pushed-back bytes; after
   that, if fewer than len bytes have been read then it
   reads from the underlying input stream. If len is not zero, the method
   blocks until at least 1 byte of input is available; otherwise, no
   bytes are read and 0 is returned.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
               -1 if there is no more data because the end of
               the stream has been reached. - `int`

  throws: java.lang.NullPointerException - If b is null."
  (^Integer [^PushbackInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^PushbackInputStream this]
    (-> this (.read))))

(defn unread
  "Pushes back a portion of an array of bytes by copying it to the front
   of the pushback buffer.  After this method returns, the next byte to be
   read will have the value b[off], the byte after that will
   have the value b[off+1], and so forth.

  b - the byte array to push back. - `byte[]`
  off - the start offset of the data. - `int`
  len - the number of bytes to push back. - `int`

  throws: java.io.IOException - If there is not enough room in the pushback buffer for the specified number of bytes, or this input stream has been closed by invoking its close() method."
  ([^PushbackInputStream this b ^Integer off ^Integer len]
    (-> this (.unread b off len)))
  ([^PushbackInputStream this ^Integer b]
    (-> this (.unread b))))

(defn available
  "Returns an estimate of the number of bytes that can be read (or
   skipped over) from this input stream without blocking by the next
   invocation of a method for this input stream. The next invocation might be
   the same thread or another thread.  A single read or skip of this
   many bytes will not block, but may read or skip fewer bytes.

    The method returns the sum of the number of bytes that have been
   pushed back and the value returned by available.

  returns: the number of bytes that can be read (or skipped over) from
               the input stream without blocking. - `int`

  throws: java.io.IOException - if this input stream has been closed by invoking its close() method, or an I/O error occurs."
  (^Integer [^PushbackInputStream this]
    (-> this (.available))))

(defn skip
  "Skips over and discards n bytes of data from this
   input stream. The skip method may, for a variety of
   reasons, end up skipping over some smaller number of bytes,
   possibly zero.  If n is negative, no bytes are skipped.

    The skip method of PushbackInputStream
   first skips over the bytes in the pushback buffer, if any.  It then
   calls the skip method of the underlying input stream if
   more bytes need to be skipped.  The actual number of bytes skipped
   is returned.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`

  throws: java.io.IOException - if the stream does not support seek, or the stream has been closed by invoking its close() method, or an I/O error occurs."
  (^Long [^PushbackInputStream this ^Long n]
    (-> this (.skip n))))

(defn mark-supported
  "Tests if this input stream supports the mark and
   reset methods, which it does not.

  returns: false, since this class does not support the
             mark and reset methods. - `boolean`"
  (^Boolean [^PushbackInputStream this]
    (-> this (.markSupported))))

(defn mark
  "Marks the current position in this input stream.

    The mark method of PushbackInputStream
   does nothing.

  readlimit - the maximum limit of bytes that can be read before the mark position becomes invalid. - `int`"
  ([^PushbackInputStream this ^Integer readlimit]
    (-> this (.mark readlimit))))

(defn reset
  "Repositions this stream to the position at the time the
   mark method was last called on this input stream.

    The method reset for class
   PushbackInputStream does nothing except throw an
   IOException.

  throws: java.io.IOException - if this method is invoked."
  ([^PushbackInputStream this]
    (-> this (.reset))))

(defn close
  "Closes this input stream and releases any system resources
   associated with the stream.
   Once the stream has been closed, further read(), unread(),
   available(), reset(), or skip() invocations will throw an IOException.
   Closing a previously closed stream has no effect.

  throws: java.io.IOException - if an I/O error occurs."
  ([^PushbackInputStream this]
    (-> this (.close))))

