(ns javax.sound.midi.Instrument
  "An instrument is a sound-synthesis algorithm with certain parameter
  settings, usually designed to emulate a specific real-world
  musical instrument or to achieve a specific sort of sound effect.
  Instruments are typically stored in collections called soundbanks.
  Before the instrument can be used to play notes, it must first be loaded
  onto a synthesizer, and then it must be selected for use on
  one or more channels, via a program-change command.  MIDI notes
  that are subsequently received on those channels will be played using
  the sound of the selected instrument."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Instrument]))

(defn get-patch
  "Obtains the Patch object that indicates the bank and program
   numbers where this instrument is to be stored in the synthesizer.

  returns: this instrument's patch - `javax.sound.midi.Patch`"
  (^javax.sound.midi.Patch [^Instrument this]
    (-> this (.getPatch))))

