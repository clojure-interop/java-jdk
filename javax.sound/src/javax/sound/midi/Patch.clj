(ns javax.sound.midi.Patch
  "A Patch object represents a location, on a MIDI
  synthesizer, into which a single instrument is stored (loaded).
  Every Instrument object has its own Patch
  object that specifies the memory location
  into which that instrument should be loaded. The
  location is specified abstractly by a bank index and a program number (not by
  any scheme that directly refers to a specific address or offset in RAM).
  This is a hierarchical indexing scheme: MIDI provides for up to 16384 banks,
  each of which contains up to 128 program locations.  For example, a
  minimal sort of synthesizer might have only one bank of instruments, and
  only 32 instruments (programs) in that bank.

  To select what instrument should play the notes on a particular MIDI
  channel, two kinds of MIDI message are used that specify a patch location:
  a bank-select command, and a program-change channel command.  The Java Sound
  equivalent is the
  programChange(int, int)
  method of MidiChannel."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Patch]))

(defn ->patch
  "Constructor.

  Constructs a new patch object from the specified bank and program
   numbers.

  bank - the bank index (in the range from 0 to 16383) - `int`
  program - the program index (in the range from 0 to 127) - `int`"
  ([^Integer bank ^Integer program]
    (new Patch bank program)))

(defn get-bank
  "Returns the number of the bank that contains the instrument
   whose location this Patch specifies.

  returns: the bank number, whose range is from 0 to 16383 - `int`"
  ([^javax.sound.midi.Patch this]
    (-> this (.getBank))))

(defn get-program
  "Returns the index, within
   a bank, of the instrument whose location this Patch specifies.

  returns: the instrument's program number, whose range is from 0 to 127 - `int`"
  ([^javax.sound.midi.Patch this]
    (-> this (.getProgram))))

