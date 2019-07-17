(ns javax.sound.sampled.AudioInputStream
  "An audio input stream is an input stream with a specified audio format and
  length.  The length is expressed in sample frames, not bytes.
  Several methods are provided for reading a certain number of bytes from
  the stream, or an unspecified number of bytes.
  The audio input stream keeps track  of the last byte that was read.
  You can skip over an arbitrary number of bytes to get to a later position
  for reading. An audio input stream may support marks.  When you set a mark,
  the current position is remembered so that you can return to it later.

  The AudioSystem class includes many methods that manipulate
  AudioInputStream objects.
  For example, the methods let you:

   obtain an
  audio input stream from an external audio file, stream, or URL
   write an external file from an audio input stream
   convert an audio input stream to a different audio format"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled AudioInputStream]))

(defn ->audio-input-stream
  "Constructor.

  Constructs an audio input stream that has the requested format and length in sample frames,
   using audio data from the specified input stream.

  stream - the stream on which this AudioInputStream object is based - `java.io.InputStream`
  format - the format of this stream's audio data - `javax.sound.sampled.AudioFormat`
  length - the length in sample frames of the data in this stream - `long`"
  ([stream format length]
    (new AudioInputStream stream format length))
  ([line]
    (new AudioInputStream line)))

(defn skip
  "Skips over and discards a specified number of bytes from this
   audio input stream.

  n - the requested number of bytes to be skipped - `long`

  returns: the actual number of bytes skipped - `long`

  throws: java.io.IOException - if an input or output error occurs"
  ([this n]
    (-> this (.skip n))))

(defn read
  "Reads up to a specified maximum number of bytes of data from the audio
   stream, putting them into the given byte array.
   This method will always read an integral number of frames.
   If len does not specify an integral number
   of frames, a maximum of len - (len % frameSize)
    bytes will be read.

  b - the buffer into which the data is read - `byte[]`
  off - the offset, from the beginning of array b, at which the data will be written - `int`
  len - the maximum number of bytes to read - `int`

  returns: the total number of bytes read into the buffer, or -1 if there
   is no more data because the end of the stream has been reached - `int`

  throws: java.io.IOException - if an input or output error occurs"
  ([this b off len]
    (-> this (.read b off len)))
  ([this b]
    (-> this (.read b)))
  ([this]
    (-> this (.read))))

(defn reset
  "Repositions this audio input stream to the position it had at the time its
   mark method was last invoked.

  throws: java.io.IOException - if an input or output error occurs."
  ([this]
    (-> this (.reset))))

(defn get-frame-length
  "Obtains the length of the stream, expressed in sample frames rather than bytes.

  returns: the length in sample frames - `long`"
  ([this]
    (-> this (.getFrameLength))))

(defn mark-supported
  "Tests whether this audio input stream supports the mark and
   reset methods.

  returns: true if this stream supports the mark
   and reset methods; false otherwise - `boolean`"
  ([this]
    (-> this (.markSupported))))

(defn close
  "Closes this audio input stream and releases any system resources associated
   with the stream.

  throws: java.io.IOException - if an input or output error occurs"
  ([this]
    (-> this (.close))))

(defn get-format
  "Obtains the audio format of the sound data in this audio input stream.

  returns: an audio format object describing this stream's format - `javax.sound.sampled.AudioFormat`"
  ([this]
    (-> this (.getFormat))))

(defn mark
  "Marks the current position in this audio input stream.

  readlimit - the maximum number of bytes that can be read before the mark position becomes invalid. - `int`"
  ([this readlimit]
    (-> this (.mark readlimit))))

(defn available
  "Returns the maximum number of bytes that can be read (or skipped over) from this
   audio input stream without blocking.  This limit applies only to the next invocation of
   a read or skip method for this audio input stream; the limit
   can vary each time these methods are invoked.
   Depending on the underlying stream,an IOException may be thrown if this
   stream is closed.

  returns: the number of bytes that can be read from this audio input stream without blocking - `int`

  throws: java.io.IOException - if an input or output error occurs"
  ([this]
    (-> this (.available))))

