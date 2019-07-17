(ns javax.sound.midi.MidiMessage
  "MidiMessage is the base class for MIDI messages.  They include
  not only the standard MIDI messages that a synthesizer can respond to, but also
  `meta-events` that can be used by sequencer programs.  There are meta-events
  for such information as lyrics, copyrights, tempo indications, time and key
  signatures, markers, etc.  For more information, see the Standard MIDI Files 1.0
  specification, which is part of the Complete MIDI 1.0 Detailed Specification
  published by the MIDI Manufacturer's Association
  (http://www.midi.org).

  The base MidiMessage class provides access to three types of
  information about a MIDI message:

  The messages's status byte
  The total length of the message in bytes (the status byte plus any data bytes)
  A byte array containing the complete message


  MidiMessage includes methods to get, but not set, these values.
  Setting them is a subclass responsibility.


  The MIDI standard expresses MIDI data in bytes.  However, because
  JavaTM uses signed bytes, the Java Sound API uses integers
  instead of bytes when expressing MIDI data.  For example, the
  getStatus() method of
  MidiMessage returns MIDI status bytes as integers.  If you are
  processing MIDI data that originated outside Java Sound and now
  is encoded as signed bytes, the bytes can
  can be converted to integers using this conversion:
  int i = (int)(byte & 0xFF)

  If you simply need to pass a known MIDI byte value as a method parameter,
  it can be expressed directly as an integer, using (for example) decimal or
  hexadecimal notation.  For instance, to pass the `active sensing` status byte
  as the first argument to ShortMessage's
  setMessage(int)
  method, you can express it as 254 or 0xFE."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MidiMessage]))

(defn get-message
  "Obtains the MIDI message data.  The first byte of the returned byte
   array is the status byte of the message.  Any subsequent bytes up to
   the length of the message are data bytes.  The byte array may have a
   length which is greater than that of the actual message; the total
   length of the message in bytes is reported by the getLength()
   method.

  returns: the byte array containing the complete MidiMessage data - `byte[]`"
  ([^javax.sound.midi.MidiMessage this]
    (-> this (.getMessage))))

(defn get-status
  "Obtains the status byte for the MIDI message.  The status `byte` is
   represented as an integer; see the
   discussion in the
   MidiMessage class description.

  returns: the integer representation of this event's status byte - `int`"
  ([^javax.sound.midi.MidiMessage this]
    (-> this (.getStatus))))

(defn get-length
  "Obtains the total length of the MIDI message in bytes.  A
   MIDI message consists of one status byte and zero or more
   data bytes.  The return value ranges from 1 for system real-time messages,
   to 2 or 3 for channel messages, to any value for meta and system
   exclusive messages.

  returns: the length of the message in bytes - `int`"
  ([^javax.sound.midi.MidiMessage this]
    (-> this (.getLength))))

(defn clone
  "Creates a new object of the same class and with the same contents
   as this object.

  returns: a clone of this instance. - `java.lang.Object`"
  ([^javax.sound.midi.MidiMessage this]
    (-> this (.clone))))

