(ns javax.sound.midi.ShortMessage
  "A ShortMessage contains a MIDI message that has at most
  two data bytes following its status byte.  The types of MIDI message
  that satisfy this criterion are channel voice, channel mode, system common,
  and system real-time--in other words, everything except system exclusive
  and meta-events.  The ShortMessage class provides methods
  for getting and setting the contents of the MIDI message.

  A number of ShortMessage methods have integer parameters by which
  you specify a MIDI status or data byte.  If you know the numeric value, you
  can express it directly.  For system common and system real-time messages,
  you can often use the corresponding fields of ShortMessage, such as
  SYSTEM_RESET.  For channel messages,
  the upper four bits of the status byte are specified by a command value and
  the lower four bits are specified by a MIDI channel number. To
  convert incoming MIDI data bytes that are in the form of Java's signed bytes,
  you can use the conversion code
  given in the MidiMessage class description."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi ShortMessage]))

(defn ->short-message
  "Constructor.

  Constructs a new ShortMessage which represents a channel
   MIDI message that takes up to two data bytes. If the message only takes
   one data byte, the second data byte is ignored. If the message does not
   take any data bytes, both data bytes are ignored.
   The contents of the message can be changed by using one of
   the setMessage methods.

  command - the MIDI command represented by this message - `int`
  channel - the channel associated with the message - `int`
  data-1 - the first data byte - `int`
  data-2 - the second data byte - `int`

  throws: javax.sound.midi.InvalidMidiDataException - if the command value, channel value or all data bytes belonging to the message do not specify a valid MIDI message"
  (^ShortMessage [^Integer command ^Integer channel ^Integer data-1 ^Integer data-2]
    (new ShortMessage command channel data-1 data-2))
  (^ShortMessage [^Integer status ^Integer data-1 ^Integer data-2]
    (new ShortMessage status data-1 data-2))
  (^ShortMessage [^Integer status]
    (new ShortMessage status))
  (^ShortMessage []
    (new ShortMessage )))

(def *-midi-time-code
  "Static Constant.

  Status byte for MIDI Time Code Quarter Frame message (0xF1, or 241).

  type: int"
  ShortMessage/MIDI_TIME_CODE)

(def *-song-position-pointer
  "Static Constant.

  Status byte for Song Position Pointer message (0xF2, or 242).

  type: int"
  ShortMessage/SONG_POSITION_POINTER)

(def *-song-select
  "Static Constant.

  Status byte for MIDI Song Select message (0xF3, or 243).

  type: int"
  ShortMessage/SONG_SELECT)

(def *-tune-request
  "Static Constant.

  Status byte for Tune Request message (0xF6, or 246).

  type: int"
  ShortMessage/TUNE_REQUEST)

(def *-end-of-exclusive
  "Static Constant.

  Status byte for End of System Exclusive message (0xF7, or 247).

  type: int"
  ShortMessage/END_OF_EXCLUSIVE)

(def *-timing-clock
  "Static Constant.

  Status byte for Timing Clock message (0xF8, or 248).

  type: int"
  ShortMessage/TIMING_CLOCK)

(def *-start
  "Static Constant.

  Status byte for Start message (0xFA, or 250).

  type: int"
  ShortMessage/START)

(def *-continue
  "Static Constant.

  Status byte for Continue message (0xFB, or 251).

  type: int"
  ShortMessage/CONTINUE)

(def *-stop
  "Static Constant.

  Status byte for Stop message (0xFC, or 252).

  type: int"
  ShortMessage/STOP)

(def *-active-sensing
  "Static Constant.

  Status byte for Active Sensing message (0xFE, or 254).

  type: int"
  ShortMessage/ACTIVE_SENSING)

(def *-system-reset
  "Static Constant.

  Status byte for System Reset message (0xFF, or 255).

  type: int"
  ShortMessage/SYSTEM_RESET)

(def *-note-off
  "Static Constant.

  Command value for Note Off message (0x80, or 128)

  type: int"
  ShortMessage/NOTE_OFF)

(def *-note-on
  "Static Constant.

  Command value for Note On message (0x90, or 144)

  type: int"
  ShortMessage/NOTE_ON)

(def *-poly-pressure
  "Static Constant.

  Command value for Polyphonic Key Pressure (Aftertouch) message (0xA0, or 160)

  type: int"
  ShortMessage/POLY_PRESSURE)

(def *-control-change
  "Static Constant.

  Command value for Control Change message (0xB0, or 176)

  type: int"
  ShortMessage/CONTROL_CHANGE)

(def *-program-change
  "Static Constant.

  Command value for Program Change message (0xC0, or 192)

  type: int"
  ShortMessage/PROGRAM_CHANGE)

(def *-channel-pressure
  "Static Constant.

  Command value for Channel Pressure (Aftertouch) message (0xD0, or 208)

  type: int"
  ShortMessage/CHANNEL_PRESSURE)

(def *-pitch-bend
  "Static Constant.

  Command value for Pitch Bend message (0xE0, or 224)

  type: int"
  ShortMessage/PITCH_BEND)

(defn set-message
  "Sets the short message parameters for a  channel message
   which takes up to two data bytes.  If the message only
   takes one data byte, the second data byte is ignored; if
   the message does not take any data bytes, both data bytes
   are ignored.

  command - the MIDI command represented by this message - `int`
  channel - the channel associated with the message - `int`
  data-1 - the first data byte - `int`
  data-2 - the second data byte - `int`

  throws: javax.sound.midi.InvalidMidiDataException - if the status byte or all data bytes belonging to the message, do not specify a valid MIDI message"
  ([^ShortMessage this ^Integer command ^Integer channel ^Integer data-1 ^Integer data-2]
    (-> this (.setMessage command channel data-1 data-2)))
  ([^ShortMessage this ^Integer status ^Integer data-1 ^Integer data-2]
    (-> this (.setMessage status data-1 data-2)))
  ([^ShortMessage this ^Integer status]
    (-> this (.setMessage status))))

(defn get-channel
  "Obtains the MIDI channel associated with this event.  This method
   assumes that the event is a MIDI channel message; if not, the return
   value will not be meaningful.

  returns: MIDI channel associated with the message. - `int`"
  (^Integer [^ShortMessage this]
    (-> this (.getChannel))))

(defn get-command
  "Obtains the MIDI command associated with this event.  This method
   assumes that the event is a MIDI channel message; if not, the return
   value will not be meaningful.

  returns: the MIDI command associated with this event - `int`"
  (^Integer [^ShortMessage this]
    (-> this (.getCommand))))

(defn get-data-1
  "Obtains the first data byte in the message.

  returns: the value of the data1 field - `int`"
  (^Integer [^ShortMessage this]
    (-> this (.getData1))))

(defn get-data-2
  "Obtains the second data byte in the message.

  returns: the value of the data2 field - `int`"
  (^Integer [^ShortMessage this]
    (-> this (.getData2))))

(defn clone
  "Creates a new object of the same class and with the same contents
   as this object.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^ShortMessage this]
    (-> this (.clone))))

