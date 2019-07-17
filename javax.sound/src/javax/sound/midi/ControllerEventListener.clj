(ns javax.sound.midi.ControllerEventListener
  "The ControllerEventListener interface should be implemented
  by classes whose instances need to be notified when a Sequencer
  has processed a requested type of MIDI control-change event.
  To register a ControllerEventListener object to receive such
  notifications, invoke the
  addControllerEventListener method of Sequencer,
  specifying the types of MIDI controllers about which you are interested in
  getting control-change notifications."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi ControllerEventListener]))

(defn control-change
  "Invoked when a Sequencer has encountered and processed
   a control-change event of interest to this listener.  The event passed
   in is a ShortMessage whose first data byte indicates
   the controller number and whose second data byte is the value to which
   the controller was set.

  event - the control-change event that the sequencer encountered in the sequence it is processing - `javax.sound.midi.ShortMessage`"
  ([^javax.sound.midi.ControllerEventListener this ^javax.sound.midi.ShortMessage event]
    (-> this (.controlChange event))))

