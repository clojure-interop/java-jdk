(ns javax.sound.midi.MidiDeviceTransmitter
  "MidiDeviceTransmitter is a Transmitter which represents
  a MIDI input connector of a MidiDevice
  (see MidiDevice.getTransmitter())."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiDeviceTransmitter]))

(defn get-midi-device
  "Obtains a MidiDevice object which is an owner of this Transmitter.

  returns: a MidiDevice object which is an owner of this Transmitter - `javax.sound.midi.MidiDevice`"
  (^javax.sound.midi.MidiDevice [^MidiDeviceTransmitter this]
    (-> this (.getMidiDevice))))

