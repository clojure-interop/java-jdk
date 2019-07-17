(ns javax.sound.midi.MidiDeviceReceiver
  "MidiDeviceReceiver is a Receiver which represents
  a MIDI input connector of a MidiDevice
  (see MidiDevice.getReceiver())."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiDeviceReceiver]))

(defn get-midi-device
  "Obtains a MidiDevice object which is an owner of this Receiver.

  returns: a MidiDevice object which is an owner of this Receiver - `javax.sound.midi.MidiDevice`"
  ([this]
    (-> this (.getMidiDevice))))

