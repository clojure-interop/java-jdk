(ns jdk.nio.channels.IllegalSelectorException
  "Unchecked exception thrown when an attempt is made to register a channel
  with a selector that was not created by the provider that created the
  channel."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels IllegalSelectorException]))

(defn ->illegal-selector-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new IllegalSelectorException )))

