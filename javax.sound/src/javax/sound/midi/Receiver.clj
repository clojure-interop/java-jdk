(ns javax.sound.midi.Receiver
  "A Receiver receives MidiEvent objects and
  typically does something useful in response, such as interpreting them to
  generate sound or raw MIDI output.  Common MIDI receivers include
  synthesizers and MIDI Out ports."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Receiver]))

(defn send
  "Sends a MIDI message and time-stamp to this receiver.
   If time-stamping is not supported by this receiver, the time-stamp
   value should be -1.

  message - the MIDI message to send - `javax.sound.midi.MidiMessage`
  time-stamp - the time-stamp for the message, in microseconds. - `long`

  throws: java.lang.IllegalStateException - if the receiver is closed"
  ([^javax.sound.midi.Receiver this ^javax.sound.midi.MidiMessage message ^Long time-stamp]
    (-> this (.send message time-stamp))))

(defn close
  "Indicates that the application has finished using the receiver, and
   that limited resources it requires may be released or made available.

   If the creation of this Receiver resulted in
   implicitly opening the underlying device, the device is
   implicitly closed by this method. This is true unless the device is
   kept open by other Receiver or Transmitter
   instances that opened the device implicitly, and unless the device
   has been opened explicitly. If the device this
   Receiver is retrieved from is closed explicitly by
   calling MidiDevice.close, the
   Receiver is closed, too.  For a detailed
   description of open/close behaviour see the class description
   of MidiDevice."
  ([^javax.sound.midi.Receiver this]
    (-> this (.close))))

