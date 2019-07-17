(ns javax.sound.sampled.TargetDataLine
  "A target data line is a type of DataLine from which
  audio data can be read.  The most common example is a data line that gets
  its data from an audio capture device.  (The device is implemented as a
  mixer that writes to the target data line.)

  Note that the naming convention for this interface reflects the relationship
  between the line and its mixer.  From the perspective of an application,
  a target data line may act as a source for audio data.

  The target data line can be obtained from a mixer by invoking the
  getLine
  method of Mixer with an appropriate
  DataLine.Info object.

  The TargetDataLine interface provides a method for reading the
  captured data from the target data line's buffer.Applications
  that record audio should read data from the target data line quickly enough
  to keep the buffer from overflowing, which could cause discontinuities in
  the captured data that are perceived as clicks.  Applications can use the
  available method defined in the
  DataLine interface to determine the amount of data currently
  queued in the data line's buffer.  If the buffer does overflow,
  the oldest queued data is discarded and replaced by new data."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled TargetDataLine]))

(defn open
  "Opens the line with the specified format and requested buffer size,
   causing the line to acquire any required system resources and become
   operational.

   The buffer size is specified in bytes, but must represent an integral
   number of sample frames.  Invoking this method with a requested buffer
   size that does not meet this requirement may result in an
   IllegalArgumentException.  The actual buffer size for the open line may
   differ from the requested buffer size.  The value actually set may be
   queried by subsequently calling DataLine.getBufferSize()

   If this operation succeeds, the line is marked as open, and an
   OPEN event is dispatched to the
   line's listeners.

   Invoking this method on a line that is already open is illegal
   and may result in an IllegalStateException.

   Some lines, once closed, cannot be reopened.  Attempts
   to reopen such a line will always result in a
   LineUnavailableException.

  format - the desired audio format - `javax.sound.sampled.AudioFormat`
  buffer-size - the desired buffer size, in bytes. - `int`

  throws: javax.sound.sampled.LineUnavailableException - if the line cannot be opened due to resource restrictions"
  ([^. this ^javax.sound.sampled.AudioFormat format ^Integer buffer-size]
    (-> this (.open format buffer-size)))
  ([^. this ^javax.sound.sampled.AudioFormat format]
    (-> this (.open format))))

(defn read
  "Reads audio data from the data line's input buffer.   The requested
   number of bytes is read into the specified array, starting at
   the specified offset into the array in bytes.  This method blocks until
   the requested amount of data has been read.  However, if the data line
   is closed, stopped, drained, or flushed before the requested amount has
   been read, the method no longer blocks, but returns the number of bytes
   read thus far.

   The number of bytes that can be read without blocking can be ascertained
   using the available method of the
   DataLine interface.  (While it is guaranteed that
   this number of bytes can be read without blocking, there is no guarantee
   that attempts to read additional data will block.)

   The number of bytes to be read must represent an integral number of
   sample frames, such that:

   [ bytes read ] % [frame size in bytes ] == 0

   The return value will always meet this requirement.  A request to read a
   number of bytes representing a non-integral number of sample frames cannot
   be fulfilled and may result in an IllegalArgumentException.

  b - a byte array that will contain the requested input data when this method returns - `byte[]`
  off - the offset from the beginning of the array, in bytes - `int`
  len - the requested number of bytes to read - `int`

  returns: the number of bytes actually read - `int`

  throws: java.lang.IllegalArgumentException - if the requested number of bytes does not represent an integral number of sample frames. or if len is negative."
  ([^. this b ^Integer off ^Integer len]
    (-> this (.read b off len))))

