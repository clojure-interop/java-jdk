(ns javax.sound.midi.Sequencer$SyncMode
  "A SyncMode object represents one of the ways in which
  a MIDI sequencer's notion of time can be synchronized with a master
  or slave device.
  If the sequencer is being synchronized to a master, the
  sequencer revises its current time in response to messages from
  the master.  If the sequencer has a slave, the sequencer
  similarly sends messages to control the slave's timing.

  There are three predefined modes that specify possible masters
  for a sequencer: INTERNAL_CLOCK,
  MIDI_SYNC, and MIDI_TIME_CODE.  The
  latter two work if the sequencer receives MIDI messages from
  another device.  In these two modes, the sequencer's time gets reset
  based on system real-time timing clock messages or MIDI time code
  (MTC) messages, respectively.  These two modes can also be used
  as slave modes, in which case the sequencer sends the corresponding
  types of MIDI messages to its receiver (whether or not the sequencer
  is also receiving them from a master).  A fourth mode,
  NO_SYNC, is used to indicate that the sequencer should
  not control its receiver's timing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi Sequencer$SyncMode]))

(def *-internal-clock
  "Static Constant.

  A master synchronization mode that makes the sequencer get
   its timing information from its internal clock.  This is not
   a legal slave sync mode.

  type: javax.sound.midi.Sequencer.SyncMode"
  Sequencer$SyncMode/INTERNAL_CLOCK)

(def *-midi-sync
  "Static Constant.

  A master or slave synchronization mode that specifies the
   use of MIDI clock
   messages.  If this mode is used as the master sync mode,
   the sequencer gets its timing information from system real-time
   MIDI clock messages.  This mode only applies as the master sync
   mode for sequencers that are also MIDI receivers.  If this is the
   slave sync mode, the sequencer sends system real-time MIDI clock
   messages to its receiver.  MIDI clock messages are sent at a rate
   of 24 per quarter note.

  type: javax.sound.midi.Sequencer.SyncMode"
  Sequencer$SyncMode/MIDI_SYNC)

(def *-midi-time-code
  "Static Constant.

  A master or slave synchronization mode that specifies the
   use of MIDI Time Code.
   If this mode is used as the master sync mode,
   the sequencer gets its timing information from MIDI Time Code
   messages.  This mode only applies as the master sync
   mode to sequencers that are also MIDI receivers.  If this
   mode is used as the
   slave sync mode, the sequencer sends MIDI Time Code
   messages to its receiver.  (See the MIDI 1.0 Detailed
   Specification for a description of MIDI Time Code.)

  type: javax.sound.midi.Sequencer.SyncMode"
  Sequencer$SyncMode/MIDI_TIME_CODE)

(def *-no-sync
  "Static Constant.

  A slave synchronization mode indicating that no timing information
   should be sent to the receiver.  This is not a legal master sync
   mode.

  type: javax.sound.midi.Sequencer.SyncMode"
  Sequencer$SyncMode/NO_SYNC)

(defn equals
  "Determines whether two objects are equal.
   Returns true if the objects are identical

  obj - the reference object with which to compare - `java.lang.Object`

  returns: true if this object is the same as the
   obj argument, false otherwise - `boolean`"
  (^Boolean [^javax.sound.midi.Sequencer$SyncMode this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Finalizes the hashcode method.

  returns: a hash code value for this object. - `int`"
  (^Integer [^javax.sound.midi.Sequencer$SyncMode this]
    (-> this (.hashCode))))

(defn to-string
  "Provides this synchronization mode's name as the string
   representation of the mode.

  returns: the name of this synchronization mode - `java.lang.String`"
  (^java.lang.String [^javax.sound.midi.Sequencer$SyncMode this]
    (-> this (.toString))))

