(ns javax.sound.midi.MetaMessage
  "A MetaMessage is a MidiMessage that is not meaningful to synthesizers, but
  that can be stored in a MIDI file and interpreted by a sequencer program.
  (See the discussion in the MidiMessage
  class description.)  The Standard MIDI Files specification defines
  various types of meta-events, such as sequence number, lyric, cue point,
  and set tempo.  There are also meta-events
  for such information as lyrics, copyrights, tempo indications, time and key
  signatures, markers, etc.  For more information, see the Standard MIDI Files 1.0
  specification, which is part of the Complete MIDI 1.0 Detailed Specification
  published by the MIDI Manufacturer's Association
  (http://www.midi.org).


  When data is being transported using MIDI wire protocol,
  a ShortMessage with the status value 0xFF represents
  a system reset message.  In MIDI files, this same status value denotes a MetaMessage.
  The types of meta-message are distinguished from each other by the first byte
  that follows the status byte 0xFF.  The subsequent bytes are data
  bytes.  As with system exclusive messages, there are an arbitrary number of
  data bytes, depending on the type of MetaMessage."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MetaMessage]))

(defn ->meta-message
  "Constructor.

  Constructs a new MetaMessage and sets the message parameters.
   The contents of the message can be changed by using
   the setMessage method.

  type - meta-message type (must be less than 128) - `int`
  data - the data bytes in the MIDI message - `byte[]`
  length - an amount of bytes in the data byte array; it should be non-negative and less than or equal to data.length - `int`

  throws: javax.sound.midi.InvalidMidiDataException - if the parameter values do not specify a valid MIDI meta message"
  ([^Integer type data ^Integer length]
    (new MetaMessage type data length))
  ([]
    (new MetaMessage )))

(def *-meta
  "Static Constant.

  Status byte for MetaMessage (0xFF, or 255), which is used
   in MIDI files.  It has the same value as SYSTEM_RESET, which
   is used in the real-time `MIDI wire` protocol.

  type: int"
  MetaMessage/META)

(defn set-message
  "Sets the message parameters for a MetaMessage.
   Since only one status byte value, 0xFF, is allowed for meta-messages,
   it does not need to be specified here.  Calls to getStatus return
   0xFF for all meta-messages.

   The type argument should be a valid value for the byte that
   follows the status byte in the MetaMessage.  The data argument
   should contain all the subsequent bytes of the MetaMessage.  In other words,
   the byte that specifies the type of MetaMessage is not considered a data byte.

  type - meta-message type (must be less than 128) - `int`
  data - the data bytes in the MIDI message - `byte[]`
  length - the number of bytes in the data byte array - `int`

  throws: javax.sound.midi.InvalidMidiDataException - if the parameter values do not specify a valid MIDI meta message"
  ([^javax.sound.midi.MetaMessage this ^Integer type data ^Integer length]
    (-> this (.setMessage type data length))))

(defn get-type
  "Obtains the type of the MetaMessage.

  returns: an integer representing the MetaMessage type - `int`"
  (^Integer [^javax.sound.midi.MetaMessage this]
    (-> this (.getType))))

(defn get-data
  "Obtains a copy of the data for the meta message.  The returned
   array of bytes does not include the status byte or the message
   length data.  The length of the data for the meta message is
   the length of the array.  Note that the length of the entire
   message includes the status byte and the meta message type
   byte, and therefore may be longer than the returned array.

  returns: array containing the meta message data. - `byte[]`"
  ([^javax.sound.midi.MetaMessage this]
    (-> this (.getData))))

(defn clone
  "Creates a new object of the same class and with the same contents
   as this object.

  returns: a clone of this instance - `java.lang.Object`"
  (^java.lang.Object [^javax.sound.midi.MetaMessage this]
    (-> this (.clone))))

