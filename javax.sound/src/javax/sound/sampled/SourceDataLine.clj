(ns javax.sound.sampled.SourceDataLine
  "A source data line is a data line to which data may be written.  It acts as
  a source to its mixer. An application writes audio bytes to a source data line,
  which handles the buffering of the bytes and delivers them to the mixer.
  The mixer may mix the samples with those from other sources and then deliver
  the mix to a target such as an output port (which may represent an audio output
  device on a sound card).

  Note that the naming convention for this interface reflects the relationship
  between the line and its mixer.  From the perspective of an application,
  a source data line may act as a target for audio data.

  A source data line can be obtained from a mixer by invoking the
  getLine method of Mixer with
  an appropriate DataLine.Info object.

  The SourceDataLine interface provides a method for writing
  audio data to the data line's buffer. Applications that play or mix
  audio should write data to the source data line quickly enough to keep the
  buffer from underflowing (emptying), which could cause discontinuities in
  the audio that are perceived as clicks.  Applications can use the
  available method defined in the
  DataLine interface to determine the amount of data currently
  queued in the data line's buffer.  The amount of data which can be written
  to the buffer without blocking is the difference between the buffer size
  and the amount of queued data.  If the delivery of audio output
  stops due to underflow, a STOP event is
  generated.  A START event is generated
  when the audio output resumes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled SourceDataLine]))

(defn open
  "Opens the line with the specified format and suggested buffer size,
   causing the line to acquire any required
   system resources and become operational.

   The buffer size is specified in bytes, but must represent an integral
   number of sample frames.  Invoking this method with a requested buffer
   size that does not meet this requirement may result in an
   IllegalArgumentException.  The actual buffer size for the open line may
   differ from the requested buffer size.  The value actually set may be
   queried by subsequently calling DataLine.getBufferSize().

   If this operation succeeds, the line is marked as open, and an
   OPEN event is dispatched to the
   line's listeners.

   Invoking this method on a line which is already open is illegal
   and may result in an IllegalStateException.

   Note that some lines, once closed, cannot be reopened.  Attempts
   to reopen such a line will always result in a
   LineUnavailableException.

  format - the desired audio format - `javax.sound.sampled.AudioFormat`
  buffer-size - the desired buffer size - `int`

  throws: javax.sound.sampled.LineUnavailableException - if the line cannot be opened due to resource restrictions"
  ([^javax.sound.sampled.SourceDataLine this ^javax.sound.sampled.AudioFormat format ^Integer buffer-size]
    (-> this (.open format buffer-size)))
  ([^javax.sound.sampled.SourceDataLine this ^javax.sound.sampled.AudioFormat format]
    (-> this (.open format))))

(defn write
  "Writes audio data to the mixer via this source data line.  The requested
   number of bytes of data are read from the specified array,
   starting at the given offset into the array, and written to the data
   line's buffer.  If the caller attempts to write more data than can
   currently be written (see available),
   this method blocks until the requested amount of data has been written.
   This applies even if the requested amount of data to write is greater
   than the data line's buffer size.  However, if the data line is closed,
   stopped, or flushed before the requested amount has been written,
   the method no longer blocks, but returns the number of bytes
   written thus far.

   The number of bytes that can be written without blocking can be ascertained
   using the available method of the
   DataLine interface.  (While it is guaranteed that
   this number of bytes can be written without blocking, there is no guarantee
   that attempts to write additional data will block.)

   The number of bytes to write must represent an integral number of
   sample frames, such that:

   [ bytes written ] % [frame size in bytes ] == 0

   The return value will always meet this requirement.  A request to write a
   number of bytes representing a non-integral number of sample frames cannot
   be fulfilled and may result in an IllegalArgumentException.

  b - a byte array containing data to be written to the data line - `byte[]`
  off - the offset from the beginning of the array, in bytes - `int`
  len - the length, in bytes, of the valid data in the array (in other words, the requested amount of data to write, in bytes) - `int`

  returns: the number of bytes actually written - `int`

  throws: java.lang.IllegalArgumentException - if the requested number of bytes does not represent an integral number of sample frames, or if len is negative"
  (^Integer [^javax.sound.sampled.SourceDataLine this b ^Integer off ^Integer len]
    (-> this (.write b off len))))

