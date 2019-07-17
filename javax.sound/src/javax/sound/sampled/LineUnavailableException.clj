(ns javax.sound.sampled.LineUnavailableException
  "A LineUnavailableException is an exception indicating that a
  line cannot be opened because it is unavailable.  This situation
  arises most commonly when a requested line is already in use
  by another application."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled LineUnavailableException]))

(defn ->line-unavailable-exception
  "Constructor.

  Constructs a LineUnavailableException that has
   the specified detail message.

  message - a string containing the error detail message - `java.lang.String`"
  ([^java.lang.String message]
    (new LineUnavailableException message))
  ([]
    (new LineUnavailableException )))

