(ns jdk.io.InvalidObjectException
  "Indicates that one or more deserialized objects failed validation
  tests.  The argument should provide the reason for the failure."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io InvalidObjectException]))

(defn ->invalid-object-exception
  "Constructor.

  Constructs an InvalidObjectException.

  reason - Detailed message explaining the reason for the failure. - `java.lang.String`"
  ([^java.lang.String reason]
    (new InvalidObjectException reason)))

