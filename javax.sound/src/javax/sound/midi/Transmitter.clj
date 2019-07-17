(ns javax.sound.midi.Transmitter
  "A Transmitter sends MidiEvent objects to one or more
  Receivers. Common MIDI transmitters include sequencers
  and MIDI input ports."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Transmitter]))

(defn set-receiver
  "Sets the receiver to which this transmitter will deliver MIDI messages.
   If a receiver is currently set, it is replaced with this one.

  receiver - the desired receiver. - `javax.sound.midi.Receiver`"
  ([^javax.sound.midi.Transmitter this ^javax.sound.midi.Receiver receiver]
    (-> this (.setReceiver receiver))))

(defn get-receiver
  "Obtains the current receiver to which this transmitter will deliver MIDI messages.

  returns: the current receiver.  If no receiver is currently set,
   returns null - `javax.sound.midi.Receiver`"
  ([^javax.sound.midi.Transmitter this]
    (-> this (.getReceiver))))

(defn close
  "Indicates that the application has finished using the transmitter, and
   that limited resources it requires may be released or made available.

   If the creation of this Transmitter resulted in
   implicitly opening the underlying device, the device is
   implicitly closed by this method. This is true unless the device is
   kept open by other Receiver or Transmitter
   instances that opened the device implicitly, and unless the device
   has been opened explicitly. If the device this
   Transmitter is retrieved from is closed explicitly
   by calling MidiDevice.close, the
   Transmitter is closed, too.  For a detailed
   description of open/close behaviour see the class description
   of MidiDevice."
  ([^javax.sound.midi.Transmitter this]
    (-> this (.close))))

