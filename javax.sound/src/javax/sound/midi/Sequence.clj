(ns javax.sound.midi.Sequence
  "A Sequence is a data structure containing musical
  information (often an entire song or composition) that can be played
  back by a Sequencer object. Specifically, the
  Sequence contains timing
  information and one or more tracks.  Each track consists of a
  series of MIDI events (such as note-ons, note-offs, program changes, and meta-events).
  The sequence's timing information specifies the type of unit that is used
  to time-stamp the events in the sequence.

  A Sequence can be created from a MIDI file by reading the file
  into an input stream and invoking one of the getSequence methods of
  MidiSystem.  A sequence can also be built from scratch by adding new
  Tracks to an empty Sequence, and adding
  MidiEvent objects to these Tracks."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Sequence]))

(defn ->sequence
  "Constructor.

  Constructs a new MIDI sequence with the specified timing division
   type, timing resolution, and number of tracks.  The division type must be one of the
   recognized MIDI timing types.  For tempo-based timing,
   divisionType is PPQ (pulses per quarter note) and
   the resolution is specified in ticks per beat.  For SMTPE timing,
   divisionType specifies the number of frames per
   second and the resolution is specified in ticks per frame.
   The sequence will be initialized with the number of tracks specified by
   numTracks. These tracks are initially empty (i.e.
   they contain only the meta-event End of Track).
   The tracks may be retrieved for editing using the getTracks()
   method.  Additional tracks may be added, or existing tracks removed,
   using createTrack() and deleteTrack(javax.sound.midi.Track).

  division-type - the timing division type (PPQ or one of the SMPTE types) - `float`
  resolution - the timing resolution - `int`
  num-tracks - the initial number of tracks in the sequence. - `int`

  throws: javax.sound.midi.InvalidMidiDataException - if divisionType is not valid"
  ([division-type resolution num-tracks]
    (new Sequence division-type resolution num-tracks))
  ([division-type resolution]
    (new Sequence division-type resolution)))

(def *-ppq
  "Static Constant.

  The tempo-based timing type, for which the resolution is expressed in pulses (ticks) per quarter note.

  type: float"
  Sequence/PPQ)

(def *-smpte-24
  "Static Constant.

  The SMPTE-based timing type with 24 frames per second (resolution is expressed in ticks per frame).

  type: float"
  Sequence/SMPTE_24)

(def *-smpte-25
  "Static Constant.

  The SMPTE-based timing type with 25 frames per second (resolution is expressed in ticks per frame).

  type: float"
  Sequence/SMPTE_25)

(def *-smpte-30-drop
  "Static Constant.

  The SMPTE-based timing type with 29.97 frames per second (resolution is expressed in ticks per frame).

  type: float"
  Sequence/SMPTE_30DROP)

(def *-smpte-30
  "Static Constant.

  The SMPTE-based timing type with 30 frames per second (resolution is expressed in ticks per frame).

  type: float"
  Sequence/SMPTE_30)

(defn get-division-type
  "Obtains the timing division type for this sequence.

  returns: the division type (PPQ or one of the SMPTE types) - `float`"
  ([this]
    (-> this (.getDivisionType))))

(defn get-resolution
  "Obtains the timing resolution for this sequence.
   If the sequence's division type is PPQ, the resolution is specified in ticks per beat.
   For SMTPE timing, the resolution is specified in ticks per frame.

  returns: the number of ticks per beat (PPQ) or per frame (SMPTE) - `int`"
  ([this]
    (-> this (.getResolution))))

(defn create-track
  "Creates a new, initially empty track as part of this sequence.
   The track initially contains the meta-event End of Track.
   The newly created track is returned.  All tracks in the sequence
   may be retrieved using getTracks().  Tracks may be
   removed from the sequence using deleteTrack(javax.sound.midi.Track).

  returns: the newly created track - `javax.sound.midi.Track`"
  ([this]
    (-> this (.createTrack))))

(defn delete-track
  "Removes the specified track from the sequence.

  track - the track to remove - `javax.sound.midi.Track`

  returns: true if the track existed in the track and was removed,
   otherwise false. - `boolean`"
  ([this track]
    (-> this (.deleteTrack track))))

(defn get-tracks
  "Obtains an array containing all the tracks in this sequence.
   If the sequence contains no tracks, an array of length 0 is returned.

  returns: the array of tracks - `javax.sound.midi.Track[]`"
  ([this]
    (-> this (.getTracks))))

(defn get-microsecond-length
  "Obtains the duration of this sequence, expressed in microseconds.

  returns: this sequence's duration in microseconds. - `long`"
  ([this]
    (-> this (.getMicrosecondLength))))

(defn get-tick-length
  "Obtains the duration of this sequence, expressed in MIDI ticks.

  returns: this sequence's length in ticks - `long`"
  ([this]
    (-> this (.getTickLength))))

(defn get-patch-list
  "Obtains a list of patches referenced in this sequence.
   This patch list may be used to load the required
   Instrument objects
   into a Synthesizer.

  returns: an array of Patch objects used in this sequence - `javax.sound.midi.Patch[]`"
  ([this]
    (-> this (.getPatchList))))

