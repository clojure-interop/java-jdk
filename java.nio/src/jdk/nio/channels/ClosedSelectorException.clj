(ns jdk.nio.channels.ClosedSelectorException
  "Unchecked exception thrown when an attempt is made to invoke an I/O
  operation upon a closed selector."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels ClosedSelectorException]))

(defn ->closed-selector-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new ClosedSelectorException )))

