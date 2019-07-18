(ns javax.sound.sampled.LineListener
  "Instances of classes that implement the LineListener interface can register to
  receive events when a line's status changes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled LineListener]))

(defn update
  "Informs the listener that a line's state has changed.  The listener can then invoke
   LineEvent methods to obtain information about the event.

  event - a line event that describes the change - `javax.sound.sampled.LineEvent`"
  ([^LineListener this ^javax.sound.sampled.LineEvent event]
    (-> this (.update event))))

