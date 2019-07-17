(ns javax.sound.midi.MetaEventListener
  "The MetaEventListener interface should be implemented
  by classes whose instances need to be notified when a Sequencer
  has processed a MetaMessage.
  To register a MetaEventListener object to receive such
  notifications, pass it as the argument to the
  addMetaEventListener
  method of Sequencer."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.midi MetaEventListener]))

(defn meta
  "Invoked when a Sequencer has encountered and processed
   a MetaMessage in the Sequence it is processing.

  meta - the meta-message that the sequencer encountered - `javax.sound.midi.MetaMessage`"
  ([^. this ^javax.sound.midi.MetaMessage meta]
    (-> this (.meta meta))))

