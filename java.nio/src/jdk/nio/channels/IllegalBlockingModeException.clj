(ns jdk.nio.channels.IllegalBlockingModeException
  "Unchecked exception thrown when a blocking-mode-specific operation
  is invoked upon a channel in the incorrect blocking mode."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels IllegalBlockingModeException]))

(defn ->illegal-blocking-mode-exception
  "Constructor.

  Constructs an instance of this class."
  ([]
    (new IllegalBlockingModeException )))

