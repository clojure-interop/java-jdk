(ns javax.sound.midi.Sequencer
  "A hardware or software device that plays back a MIDI
  sequence is known as a sequencer.
  A MIDI sequence contains lists of time-stamped MIDI data, such as
  might be read from a standard MIDI file.  Most
  sequencers also provide functions for creating and editing sequences.

  The Sequencer interface includes methods for the following
  basic MIDI sequencer operations:

  obtaining a sequence from MIDI file data
  starting and stopping playback
  moving to an arbitrary position in the sequence
  changing the tempo (speed) of playback
  synchronizing playback to an internal clock or to received MIDI
  messages
  controlling the timing of another device

  In addition, the following operations are supported, either directly, or
  indirectly through objects that the Sequencer has access to:

  editing the data by adding or deleting individual MIDI events or entire
  tracks
  muting or soloing individual tracks in the sequence
  notifying listener objects about any meta-events or
  control-change events encountered while playing back the sequence."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Sequencer]))

(defn stop
  "Stops recording, if active, and playback of the currently loaded sequence,
   if any.

  throws: java.lang.IllegalStateException - if the Sequencer is closed."
  ([^. this]
    (-> this (.stop))))

(defn recording?
  "Indicates whether the Sequencer is currently recording.  The default is false.
   The Sequencer begins recording when startRecording() is called,
   and then returns true until stop() or stopRecording()
   is called.

  returns: true if the Sequencer is recording, otherwise false - `boolean`"
  ([^. this]
    (-> this (.isRecording))))

(defn get-tick-position
  "Obtains the current position in the sequence, expressed in MIDI
   ticks.  (The duration of a tick in seconds is determined both by
   the tempo and by the timing resolution stored in the
   Sequence.)

  returns: current tick - `long`"
  ([^. this]
    (-> this (.getTickPosition))))

(defn get-track-solo?
  "Obtains the current solo state for a track.  The default mute
   state for all tracks which have not been solo'd is false.  In any
   case where the specified track has not been solo'd, this method should
   return false.  This applies if the sequencer does not support soloing
   of tracks, and if the specified track index is not valid.

  track - the track number. Tracks in the current sequence are numbered from 0 to the number of tracks in the sequence minus 1. - `int`

  returns: true if solo'd, false if not. - `boolean`"
  ([^. this ^Integer track]
    (-> this (.getTrackSolo track))))

(defn set-track-mute
  "Sets the mute state for a track.  This method may fail for a number
   of reasons.  For example, the track number specified may not be valid
   for the current sequence, or the sequencer may not support this functionality.
   An application which needs to verify whether this operation succeeded should
   follow this call with a call to getTrackMute(int).

  track - the track number. Tracks in the current sequence are numbered from 0 to the number of tracks in the sequence minus 1. - `int`
  mute - the new mute state for the track. true implies the track should be muted, false implies the track should be unmuted. - `boolean`"
  ([^. this ^Integer track ^Boolean mute]
    (-> this (.setTrackMute track mute))))

(defn get-microsecond-position
  "Obtains the current position in the sequence, expressed in
   microseconds.

  returns: the current position in microseconds - `long`"
  ([^. this]
    (-> this (.getMicrosecondPosition))))

(defn get-loop-count
  "Obtains the number of repetitions for
   playback.

  returns: the number of loops after which
           playback plays to the end of the
           sequence - `int`"
  ([^. this]
    (-> this (.getLoopCount))))

(defn set-master-sync-mode
  "Sets the source of timing information used by this sequencer.
   The sequencer synchronizes to the master, which is the internal clock,
   MIDI clock, or MIDI time code, depending on the value of
   sync.  The sync argument must be one
   of the supported modes, as returned by
   getMasterSyncModes().

  sync - the desired master synchronization mode - `javax.sound.midi.Sequencer.SyncMode`"
  ([^. this ^javax.sound.midi.Sequencer.SyncMode sync]
    (-> this (.setMasterSyncMode sync))))

(defn record-enable
  "Prepares the specified track for recording events received on a particular channel.
   Once enabled, a track will receive events when recording is active.

  track - the track to which events will be recorded - `javax.sound.midi.Track`
  channel - the channel on which events will be received. If -1 is specified for the channel value, the track will receive data from all channels. - `int`

  throws: java.lang.IllegalArgumentException - thrown if the track is not part of the current sequence."
  ([^. this ^javax.sound.midi.Track track ^Integer channel]
    (-> this (.recordEnable track channel))))

(defn add-controller-event-listener
  "Registers a controller event listener to receive notification
   whenever the sequencer processes a control-change event of the
   requested type or types.  The types are specified by the
   controllers argument, which should contain an array of
   MIDI controller numbers.  (Each number should be between 0 and 127,
   inclusive.  See the MIDI 1.0 Specification for the numbers that
   correspond to various types of controllers.)

   The returned array contains the MIDI controller
   numbers for which the listener will now receive events.
   Some sequencers might not support controller event notification, in
   which case the array has a length of 0.  Other sequencers might
   support notification for some controllers but not all.
   This method may be invoked repeatedly.
   Each time, the returned array indicates all the controllers
   that the listener will be notified about, not only the controllers
   requested in that particular invocation.

  listener - the controller event listener to add to the list of registered listeners - `javax.sound.midi.ControllerEventListener`
  controllers - the MIDI controller numbers for which change notification is requested - `int[]`

  returns: the numbers of all the MIDI controllers whose changes will
   now be reported to the specified listener - `int[]`"
  ([^. this ^javax.sound.midi.ControllerEventListener listener controllers]
    (-> this (.addControllerEventListener listener controllers))))

(defn get-sequence
  "Obtains the sequence on which the Sequencer is currently operating.

   This method can be called even if the
   Sequencer is closed.

  returns: the current sequence, or null if no sequence is currently set. - `javax.sound.midi.Sequence`"
  ([^. this]
    (-> this (.getSequence))))

(defn get-master-sync-mode
  "Obtains the current master synchronization mode for this sequencer.

  returns: the current master synchronization mode - `javax.sound.midi.Sequencer.SyncMode`"
  ([^. this]
    (-> this (.getMasterSyncMode))))

(defn set-tempo-in-mpq
  "Sets the tempo in microseconds per quarter note.  The actual tempo
   of playback is the product of the specified value and the tempo
   factor.

  mpq - desired new tempo in microseconds per quarter note. - `float`"
  ([^. this ^Float mpq]
    (-> this (.setTempoInMPQ mpq))))

(defn set-microsecond-position
  "Sets the current position in the sequence, expressed in microseconds

  microseconds - desired position in microseconds - `long`"
  ([^. this ^Long microseconds]
    (-> this (.setMicrosecondPosition microseconds))))

(defn get-master-sync-modes
  "Obtains the set of master synchronization modes supported by this
   sequencer.

  returns: the available master synchronization modes - `javax.sound.midi.Sequencer.SyncMode[]`"
  ([^. this]
    (-> this (.getMasterSyncModes))))

(defn get-slave-sync-modes
  "Obtains the set of slave synchronization modes supported by the sequencer.

  returns: the available slave synchronization modes - `javax.sound.midi.Sequencer.SyncMode[]`"
  ([^. this]
    (-> this (.getSlaveSyncModes))))

(defn set-loop-start-point
  "Sets the first MIDI tick that will be
   played in the loop. If the loop count is
   greater than 0, playback will jump to this
   point when reaching the loop end point.

   A value of 0 for the starting point means the
   beginning of the loaded sequence. The starting
   point must be lower than or equal to the ending
   point, and it must fall within the size of the
   loaded sequence.

   A sequencer's loop start point defaults to
   start of the sequence.

  tick - the loop's starting position, in MIDI ticks (zero-based) - `long`

  throws: java.lang.IllegalArgumentException - if the requested loop start point cannot be set, usually because it falls outside the sequence's duration or because the start point is after the end point"
  ([^. this ^Long tick]
    (-> this (.setLoopStartPoint tick))))

(defn get-track-mute?
  "Obtains the current mute state for a track.  The default mute
   state for all tracks which have not been muted is false.  In any
   case where the specified track has not been muted, this method should
   return false.  This applies if the sequencer does not support muting
   of tracks, and if the specified track index is not valid.

  track - the track number. Tracks in the current sequence are numbered from 0 to the number of tracks in the sequence minus 1. - `int`

  returns: true if muted, false if not. - `boolean`"
  ([^. this ^Integer track]
    (-> this (.getTrackMute track))))

(defn stop-recording
  "Stops recording, if active.  Playback of the current sequence continues.

  throws: java.lang.IllegalStateException - if the Sequencer is closed."
  ([^. this]
    (-> this (.stopRecording))))

(defn get-tempo-in-bpm
  "Obtains the current tempo, expressed in beats per minute.  The
   actual tempo of playback is the product of the returned value
   and the tempo factor.

  returns: the current tempo in beats per minute - `float`"
  ([^. this]
    (-> this (.getTempoInBPM))))

(defn get-microsecond-length
  "Obtains the length of the current sequence, expressed in microseconds,
   or 0 if no sequence is set.

  returns: length of the sequence in microseconds. - `long`"
  ([^. this]
    (-> this (.getMicrosecondLength))))

(defn record-disable
  "Disables recording to the specified track.  Events will no longer be recorded
   into this track.

  track - the track to disable for recording, or null to disable recording for all tracks. - `javax.sound.midi.Track`"
  ([^. this ^javax.sound.midi.Track track]
    (-> this (.recordDisable track))))

(defn start-recording
  "Starts recording and playback of MIDI data.  Data is recorded to all enabled tracks,
   on the channel(s) for which they were enabled.  Recording begins at the current position
   of the sequencer.   Any events already in the track are overwritten for the duration
   of the recording session.  Events from the currently loaded sequence,
   if any, are delivered to the sequencer's transmitter(s) along with messages
   received during recording.

   Note that tracks are not by default enabled for recording.  In order to record MIDI data,
   at least one track must be specifically enabled for recording.

  throws: java.lang.IllegalStateException - if the Sequencer is closed."
  ([^. this]
    (-> this (.startRecording))))

(defn get-loop-end-point
  "Obtains the end position of the loop,
   in MIDI ticks.

  returns: the end position of the loop, in MIDI
           ticks (zero-based), or -1 to indicate
           the end of the sequence - `long`"
  ([^. this]
    (-> this (.getLoopEndPoint))))

(defn get-tick-length
  "Obtains the length of the current sequence, expressed in MIDI ticks,
   or 0 if no sequence is set.

  returns: length of the sequence in ticks - `long`"
  ([^. this]
    (-> this (.getTickLength))))

(defn start
  "Starts playback of the MIDI data in the currently
   loaded sequence.
   Playback will begin from the current position.
   If the playback position reaches the loop end point,
   and the loop count is greater than 0, playback will
   resume at the loop start point for the number of
   repetitions set with setLoopCount.
   After that, or if the loop count is 0, playback will
   continue to play to the end of the sequence.

   The implementation ensures that the synthesizer
   is brought to a consistent state when jumping
   to the loop start point by sending appropriate
   controllers, pitch bend, and program change events.

  throws: java.lang.IllegalStateException - if the Sequencer is closed."
  ([^. this]
    (-> this (.start))))

(defn get-tempo-in-mpq
  "Obtains the current tempo, expressed in microseconds per quarter
   note.  The actual tempo of playback is the product of the returned
   value and the tempo factor.

  returns: the current tempo in microseconds per quarter note - `float`"
  ([^. this]
    (-> this (.getTempoInMPQ))))

(defn set-sequence
  "Sets the current sequence on which the sequencer operates.

   This method can be called even if the
   Sequencer is closed.

  sequence - the sequence to be loaded. - `javax.sound.midi.Sequence`

  throws: javax.sound.midi.InvalidMidiDataException - if the sequence contains invalid MIDI data, or is not supported."
  ([^. this ^javax.sound.midi.Sequence sequence]
    (-> this (.setSequence sequence))))

(defn remove-meta-event-listener
  "Removes the specified meta-event listener from this sequencer's
   list of registered listeners, if in fact the listener is registered.

  listener - the meta-event listener to remove - `javax.sound.midi.MetaEventListener`"
  ([^. this ^javax.sound.midi.MetaEventListener listener]
    (-> this (.removeMetaEventListener listener))))

(defn set-loop-end-point
  "Sets the last MIDI tick that will be played in
   the loop. If the loop count is 0, the loop end
   point has no effect and playback continues to
   play when reaching the loop end point.

   A value of -1 for the ending point
   indicates the last tick of the sequence.
   Otherwise, the ending point must be greater
   than or equal to the starting point, and it must
   fall within the size of the loaded sequence.

   A sequencer's loop end point defaults to -1,
   meaning the end of the sequence.

  tick - the loop's ending position, in MIDI ticks (zero-based), or -1 to indicate the final tick - `long`

  throws: java.lang.IllegalArgumentException - if the requested loop point cannot be set, usually because it falls outside the sequence's duration or because the ending point is before the starting point"
  ([^. this ^Long tick]
    (-> this (.setLoopEndPoint tick))))

(defn set-tempo-in-bpm
  "Sets the tempo in beats per minute.   The actual tempo of playback
   is the product of the specified value and the tempo factor.

  bpm - desired new tempo in beats per minute - `float`"
  ([^. this ^Float bpm]
    (-> this (.setTempoInBPM bpm))))

(defn set-track-solo
  "Sets the solo state for a track.  If solo is true
   only this track and other solo'd tracks will sound. If solo
   is false then only other solo'd tracks will sound, unless no
   tracks are solo'd in which case all un-muted tracks will sound.

   This method may fail for a number
   of reasons.  For example, the track number specified may not be valid
   for the current sequence, or the sequencer may not support this functionality.
   An application which needs to verify whether this operation succeeded should
   follow this call with a call to getTrackSolo(int).

  track - the track number. Tracks in the current sequence are numbered from 0 to the number of tracks in the sequence minus 1. - `int`
  solo - the new solo state for the track. true implies the track should be solo'd, false implies the track should not be solo'd. - `boolean`"
  ([^. this ^Integer track ^Boolean solo]
    (-> this (.setTrackSolo track solo))))

(defn running?
  "Indicates whether the Sequencer is currently running.  The default is false.
   The Sequencer starts running when either start() or startRecording()
   is called.  isRunning then returns true until playback of the
   sequence completes or stop() is called.

  returns: true if the Sequencer is running, otherwise false - `boolean`"
  ([^. this]
    (-> this (.isRunning))))

(defn set-loop-count
  "Sets the number of repetitions of the loop for
   playback.
   When the playback position reaches the loop end point,
   it will loop back to the loop start point
   count times, after which playback will
   continue to play to the end of the sequence.

   If the current position when this method is invoked
   is greater than the loop end point, playback
   continues to the end of the sequence without looping,
   unless the loop end point is changed subsequently.

   A count value of 0 disables looping:
   playback will continue at the loop end point, and it
   will not loop back to the loop start point.
   This is a sequencer's default.

   If playback is stopped during looping, the
   current loop status is cleared; subsequent start
   requests are not affected by an interrupted loop
   operation.

  count - the number of times playback should loop back from the loop's end position to the loop's start position, or LOOP_CONTINUOUSLY to indicate that looping should continue until interrupted - `int`

  throws: java.lang.IllegalArgumentException - if count is negative and not equal to LOOP_CONTINUOUSLY"
  ([^. this ^Integer count]
    (-> this (.setLoopCount count))))

(defn set-tick-position
  "Sets the current sequencer position in MIDI ticks

  tick - the desired tick position - `long`"
  ([^. this ^Long tick]
    (-> this (.setTickPosition tick))))

(defn get-slave-sync-mode
  "Obtains the current slave synchronization mode for this sequencer.

  returns: the current slave synchronization mode - `javax.sound.midi.Sequencer.SyncMode`"
  ([^. this]
    (-> this (.getSlaveSyncMode))))

(defn set-tempo-factor
  "Scales the sequencer's actual playback tempo by the factor provided.
   The default is 1.0.  A value of 1.0 represents the natural rate (the
   tempo specified in the sequence), 2.0 means twice as fast, etc.
   The tempo factor does not affect the values returned by
   getTempoInMPQ() and getTempoInBPM().
   Those values indicate the tempo prior to scaling.

   Note that the tempo factor cannot be adjusted when external
   synchronization is used.  In that situation,
   setTempoFactor always sets the tempo factor to 1.0.

  factor - the requested tempo scalar - `float`"
  ([^. this ^Float factor]
    (-> this (.setTempoFactor factor))))

(defn add-meta-event-listener
  "Registers a meta-event listener to receive
   notification whenever a meta-event is encountered in the sequence
   and processed by the sequencer. This method can fail if, for
   instance,this class of sequencer does not support meta-event
   notification.

  listener - listener to add - `javax.sound.midi.MetaEventListener`

  returns: true if the listener was successfully added,
   otherwise false - `boolean`"
  ([^. this ^javax.sound.midi.MetaEventListener listener]
    (-> this (.addMetaEventListener listener))))

(defn remove-controller-event-listener
  "Removes a controller event listener's interest in one or more
   types of controller event. The controllers argument
   is an array of MIDI numbers corresponding to the  controllers for
   which the listener should no longer receive change notifications.
   To completely remove this listener from the list of registered
   listeners, pass in null for controllers.
   The returned array contains the MIDI controller
   numbers for which the listener will now receive events.  The
   array has a length of 0 if the listener will not receive
   change notifications for any controllers.

  listener - old listener - `javax.sound.midi.ControllerEventListener`
  controllers - the MIDI controller numbers for which change notification should be cancelled, or null to cancel for all controllers - `int[]`

  returns: the numbers of all the MIDI controllers whose changes will
   now be reported to the specified listener - `int[]`"
  ([^. this ^javax.sound.midi.ControllerEventListener listener controllers]
    (-> this (.removeControllerEventListener listener controllers))))

(defn set-slave-sync-mode
  "Sets the slave synchronization mode for the sequencer.
   This indicates the type of timing information sent by the sequencer
   to its receiver.  The sync argument must be one
   of the supported modes, as returned by
   getSlaveSyncModes().

  sync - the desired slave synchronization mode - `javax.sound.midi.Sequencer.SyncMode`"
  ([^. this ^javax.sound.midi.Sequencer.SyncMode sync]
    (-> this (.setSlaveSyncMode sync))))

(defn get-tempo-factor
  "Returns the current tempo factor for the sequencer.  The default is
   1.0.

  returns: tempo factor. - `float`"
  ([^. this]
    (-> this (.getTempoFactor))))

(defn get-loop-start-point
  "Obtains the start position of the loop,
   in MIDI ticks.

  returns: the start position of the loop,
                 in MIDI ticks (zero-based) - `long`"
  ([^. this]
    (-> this (.getLoopStartPoint))))

