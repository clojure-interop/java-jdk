(ns javax.sound.midi.MidiEvent
  "MIDI events contain a MIDI message and a corresponding time-stamp
  expressed in ticks, and can represent the MIDI event information
  stored in a MIDI file or a Sequence object.  The
  duration of a tick is specified by the timing information contained
  in the MIDI file or Sequence object.

  In Java Sound, MidiEvent objects are typically contained in a
  Track, and Tracks are likewise
  contained in a Sequence."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiEvent]))

(defn ->midi-event
  "Constructor.

  Constructs a new MidiEvent.

  message - the MIDI message contained in the event - `javax.sound.midi.MidiMessage`
  tick - the time-stamp for the event, in MIDI ticks - `long`"
  ([^javax.sound.midi.MidiMessage message ^Long tick]
    (new MidiEvent message tick)))

(defn get-message
  "Obtains the MIDI message contained in the event.

  returns: the MIDI message - `javax.sound.midi.MidiMessage`"
  (^javax.sound.midi.MidiMessage [^javax.sound.midi.MidiEvent this]
    (-> this (.getMessage))))

(defn set-tick
  "Sets the time-stamp for the event, in MIDI ticks

  tick - the new time-stamp, in MIDI ticks - `long`"
  ([^javax.sound.midi.MidiEvent this ^Long tick]
    (-> this (.setTick tick))))

(defn get-tick
  "Obtains the time-stamp for the event, in MIDI ticks

  returns: the time-stamp for the event, in MIDI ticks - `long`"
  (^Long [^javax.sound.midi.MidiEvent this]
    (-> this (.getTick))))

