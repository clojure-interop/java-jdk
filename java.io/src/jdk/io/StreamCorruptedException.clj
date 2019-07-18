(ns jdk.io.StreamCorruptedException
  "Thrown when control information that was read from an object stream
  violates internal consistency checks."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io StreamCorruptedException]))

(defn ->stream-corrupted-exception
  "Constructor.

  Create a StreamCorruptedException and list a reason why thrown.

  reason - String describing the reason for the exception. - `java.lang.String`"
  (^StreamCorruptedException [^java.lang.String reason]
    (new StreamCorruptedException reason))
  (^StreamCorruptedException []
    (new StreamCorruptedException )))

