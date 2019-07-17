(ns javax.sound.midi.MidiUnavailableException
  "A MidiUnavailableException is thrown when a requested MIDI
  component cannot be opened or created because it is unavailable.  This often
  occurs when a device is in use by another application.  More generally, it
  can occur when there is a finite number of a certain kind of resource that can
  be used for some purpose, and all of them are already in use (perhaps all by
  this application).  For an example of the latter case, see the
  setReceiver method of
  Transmitter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiUnavailableException]))

(defn ->midi-unavailable-exception
  "Constructor.

  Constructs a MidiUnavailableException with the
   specified detail message.

  message - the string to display as an error detail message - `java.lang.String`"
  ([^java.lang.String message]
    (new MidiUnavailableException message))
  ([]
    (new MidiUnavailableException )))

