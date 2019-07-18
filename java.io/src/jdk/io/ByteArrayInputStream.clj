(ns jdk.io.ByteArrayInputStream
  "A ByteArrayInputStream contains
  an internal buffer that contains bytes that
  may be read from the stream. An internal
  counter keeps track of the next byte to
  be supplied by the read method.

  Closing a ByteArrayInputStream has no effect. The methods in
  this class can be called after the stream has been closed without
  generating an IOException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io ByteArrayInputStream]))

(defn ->byte-array-input-stream
  "Constructor.

  Creates ByteArrayInputStream
   that uses buf as its
   buffer array. The initial value of pos
   is offset and the initial value
   of count is the minimum of offset+length
   and buf.length.
   The buffer array is not copied. The buffer's mark is
   set to the specified offset.

  buf - the input buffer. - `byte[]`
  offset - the offset in the buffer of the first byte to read. - `int`
  length - the maximum number of bytes to read from the buffer. - `int`"
  (^ByteArrayInputStream [buf ^Integer offset ^Integer length]
    (new ByteArrayInputStream buf offset length))
  (^ByteArrayInputStream [buf]
    (new ByteArrayInputStream buf)))

(defn read
  "Reads up to len bytes of data into an array of bytes
   from this input stream.
   If pos equals count,
   then -1 is returned to indicate
   end of file. Otherwise, the  number k
   of bytes read is equal to the smaller of
   len and count-pos.
   If k is positive, then bytes
   buf[pos] through buf[pos+k-1]
   are copied into b[off]  through
   b[off+k-1] in the manner performed
   by System.arraycopy. The
   value k is added into pos
   and k is returned.

   This read method cannot block.

  b - the buffer into which the data is read. - `byte[]`
  off - the start offset in the destination array b - `int`
  len - the maximum number of bytes read. - `int`

  returns: the total number of bytes read into the buffer, or
            -1 if there is no more data because the end of
            the stream has been reached. - `int`

  throws: java.lang.NullPointerException - If b is null."
  (^Integer [^ByteArrayInputStream this b ^Integer off ^Integer len]
    (-> this (.read b off len)))
  (^Integer [^ByteArrayInputStream this]
    (-> this (.read))))

(defn skip
  "Skips n bytes of input from this input stream. Fewer
   bytes might be skipped if the end of the input stream is reached.
   The actual number k
   of bytes to be skipped is equal to the smaller
   of n and  count-pos.
   The value k is added into pos
   and k is returned.

  n - the number of bytes to be skipped. - `long`

  returns: the actual number of bytes skipped. - `long`"
  (^Long [^ByteArrayInputStream this ^Long n]
    (-> this (.skip n))))

(defn available
  "Returns the number of remaining bytes that can be read (or skipped over)
   from this input stream.

   The value returned is count - pos,
   which is the number of bytes remaining to be read from the input buffer.

  returns: the number of remaining bytes that can be read (or skipped
            over) from this input stream without blocking. - `int`"
  (^Integer [^ByteArrayInputStream this]
    (-> this (.available))))

(defn mark-supported
  "Tests if this InputStream supports mark/reset. The
   markSupported method of ByteArrayInputStream
   always returns true.

  returns: true if this stream instance supports the mark
            and reset methods; false otherwise. - `boolean`"
  (^Boolean [^ByteArrayInputStream this]
    (-> this (.markSupported))))

(defn mark
  "Set the current marked position in the stream.
   ByteArrayInputStream objects are marked at position zero by
   default when constructed.  They may be marked at another
   position within the buffer by this method.

   If no mark has been set, then the value of the mark is the
   offset passed to the constructor (or 0 if the offset was not
   supplied).

    Note: The readAheadLimit for this class
    has no meaning.

  read-ahead-limit - the maximum limit of bytes that can be read before the mark position becomes invalid. - `int`"
  ([^ByteArrayInputStream this ^Integer read-ahead-limit]
    (-> this (.mark read-ahead-limit))))

(defn reset
  "Resets the buffer to the marked position.  The marked position
   is 0 unless another position was marked or an offset was specified
   in the constructor."
  ([^ByteArrayInputStream this]
    (-> this (.reset))))

(defn close
  "Closing a ByteArrayInputStream has no effect. The methods in
   this class can be called after the stream has been closed without
   generating an IOException.

  throws: java.io.IOException - if an I/O error occurs."
  ([^ByteArrayInputStream this]
    (-> this (.close))))

