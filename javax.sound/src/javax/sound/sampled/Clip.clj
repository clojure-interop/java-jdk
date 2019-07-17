(ns javax.sound.sampled.Clip
  "The Clip interface represents a special kind of data line whose
  audio data can be loaded prior to playback, instead of being streamed in
  real time.

  Because the data is pre-loaded and has a known length, you can set a clip
  to start playing at any position in its audio data.  You can also create a
  loop, so that when the clip is played it will cycle repeatedly.  Loops are
  specified with a starting and ending sample frame, along with the number of
  times that the loop should be played.

  Clips may be obtained from a Mixer that supports lines
  of this type.  Data is loaded into a clip when it is opened.

  Playback of an audio clip may be started and stopped using the start
  and stop methods.  These methods do not reset the media position;
  start causes playback to continue from the position where playback
  was last stopped.  To restart playback from the beginning of the clip's audio
  data, simply follow the invocation of stop
  with setFramePosition(0), which rewinds the media to the beginning
  of the clip."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Clip]))

(defn open
  "Opens the clip, meaning that it should acquire any required
   system resources and become operational.  The clip is opened
   with the format and audio data indicated.
   If this operation succeeds, the line is marked as open and an
   OPEN event is dispatched
   to the line's listeners.

   Invoking this method on a line which is already open is illegal
   and may result in an IllegalStateException.

   Note that some lines, once closed, cannot be reopened.  Attempts
   to reopen such a line will always result in a
   LineUnavailableException.

  format - the format of the supplied audio data - `javax.sound.sampled.AudioFormat`
  data - a byte array containing audio data to load into the clip - `byte[]`
  offset - the point at which to start copying, expressed in bytes from the beginning of the array - `int`
  buffer-size - the number of bytes of data to load into the clip from the array. - `int`

  throws: javax.sound.sampled.LineUnavailableException - if the line cannot be opened due to resource restrictions"
  ([^. this ^javax.sound.sampled.AudioFormat format data ^Integer offset ^Integer buffer-size]
    (-> this (.open format data offset buffer-size)))
  ([^. this ^javax.sound.sampled.AudioInputStream stream]
    (-> this (.open stream))))

(defn get-frame-length
  "Obtains the media length in sample frames.

  returns: the media length, expressed in sample frames,
   or AudioSystem.NOT_SPECIFIED if the line is not open. - `int`"
  ([^. this]
    (-> this (.getFrameLength))))

(defn get-microsecond-length
  "Obtains the media duration in microseconds

  returns: the media duration, expressed in microseconds,
   or AudioSystem.NOT_SPECIFIED if the line is not open. - `long`"
  ([^. this]
    (-> this (.getMicrosecondLength))))

(defn set-frame-position
  "Sets the media position in sample frames.  The position is zero-based;
   the first frame is frame number zero.  When the clip begins playing the
   next time, it will start by playing the frame at this position.

   To obtain the current position in sample frames, use the
   getFramePosition
   method of DataLine.

  frames - the desired new media position, expressed in sample frames - `int`"
  ([^. this ^Integer frames]
    (-> this (.setFramePosition frames))))

(defn set-microsecond-position
  "Sets the media position in microseconds.  When the clip begins playing the
   next time, it will start at this position.
   The level of precision is not guaranteed.  For example, an implementation
   might calculate the microsecond position from the current frame position
   and the audio sample frame rate.  The precision in microseconds would
   then be limited to the number of microseconds per sample frame.

   To obtain the current position in microseconds, use the
   getMicrosecondPosition
   method of DataLine.

  microseconds - the desired new media position, expressed in microseconds - `long`"
  ([^. this ^Long microseconds]
    (-> this (.setMicrosecondPosition microseconds))))

(defn set-loop-points
  "Sets the first and last sample frames that will be played in
   the loop.  The ending point must be greater than
   or equal to the starting point, and both must fall within the
   the size of the loaded media.  A value of 0 for the starting
   point means the beginning of the loaded media.  Similarly, a value of -1
   for the ending point indicates the last frame of the media.

  start - the loop's starting position, in sample frames (zero-based) - `int`
  end - the loop's ending position, in sample frames (zero-based), or -1 to indicate the final frame - `int`

  throws: java.lang.IllegalArgumentException - if the requested loop points cannot be set, usually because one or both falls outside the media's duration or because the ending point is before the starting point"
  ([^. this ^Integer start ^Integer end]
    (-> this (.setLoopPoints start end))))

(defn loop
  "Starts looping playback from the current position.   Playback will
   continue to the loop's end point, then loop back to the loop start point
   count times, and finally continue playback to the end of
   the clip.

   If the current position when this method is invoked is greater than the
   loop end point, playback simply continues to the
   end of the clip without looping.

   A count value of 0 indicates that any current looping should
   cease and playback should continue to the end of the clip.  The behavior
   is undefined when this method is invoked with any other value during a
   loop operation.

   If playback is stopped during looping, the current loop status is
   cleared; the behavior of subsequent loop and start requests is not
   affected by an interrupted loop operation.

  count - the number of times playback should loop back from the loop's end position to the loop's start position, or LOOP_CONTINUOUSLY to indicate that looping should continue until interrupted - `int`"
  ([^. this ^Integer count]
    (-> this (.loop count))))

