(ns javax.sound.midi.Track
  "A MIDI track is an independent stream of MIDI events (time-stamped MIDI
  data) that can be stored along with other tracks in a standard MIDI file.
  The MIDI specification allows only 16 channels of MIDI data, but tracks
  are a way to get around this limitation.  A MIDI file can contain any number
  of tracks, each containing its own stream of up to 16 channels of MIDI data.

  A Track occupies a middle level in the hierarchy of data played
  by a Sequencer: sequencers play sequences, which contain tracks,
  which contain MIDI events.  A sequencer may provide controls that mute
  or solo individual tracks.

  The timing information and resolution for a track is controlled by and stored
  in the sequence containing the track. A given Track
  is considered to belong to the particular Sequence that
  maintains its timing. For this reason, a new (empty) track is created by calling the
  Sequence.createTrack() method, rather than by directly invoking a
  Track constructor.

  The Track class provides methods to edit the track by adding
  or removing MidiEvent objects from it.  These operations keep
  the event list in the correct time order.  Methods are also
  included to obtain the track's size, in terms of either the number of events
  it contains or its duration in ticks."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Track]))

(defn add
  "Adds a new event to the track.  However, if the event is already
   contained in the track, it is not added again.  The list of events
   is kept in time order, meaning that this event inserted at the
   appropriate place in the list, not necessarily at the end.

  event - the event to add - `javax.sound.midi.MidiEvent`

  returns: true if the event did not already exist in the
   track and was added, otherwise false - `boolean`"
  (^Boolean [^Track this ^javax.sound.midi.MidiEvent event]
    (-> this (.add event))))

(defn remove
  "Removes the specified event from the track.

  event - the event to remove - `javax.sound.midi.MidiEvent`

  returns: true if the event existed in the track and was removed,
   otherwise false - `boolean`"
  (^Boolean [^Track this ^javax.sound.midi.MidiEvent event]
    (-> this (.remove event))))

(defn get
  "Obtains the event at the specified index.

  index - the location of the desired event in the event vector - `int`

  returns: the event at the specified index - `javax.sound.midi.MidiEvent`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the specified index is negative or not less than the current size of this track."
  (^javax.sound.midi.MidiEvent [^Track this ^Integer index]
    (-> this (.get index))))

(defn size
  "Obtains the number of events in this track.

  returns: the size of the track's event vector - `int`"
  (^Integer [^Track this]
    (-> this (.size))))

(defn ticks
  "Obtains the length of the track, expressed in MIDI ticks.  (The
   duration of a tick in seconds is determined by the timing resolution
   of the Sequence containing this track, and also by
   the tempo of the music as set by the sequencer.)

  returns: the duration, in ticks - `long`"
  (^Long [^Track this]
    (-> this (.ticks))))

