(ns jdk.io.NotActiveException
  "Thrown when serialization or deserialization is not active."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io NotActiveException]))

(defn ->not-active-exception
  "Constructor.

  Constructor to create a new NotActiveException with the reason given.

  reason - a String describing the reason for the exception. - `java.lang.String`"
  ([^java.lang.String reason]
    (new NotActiveException reason))
  ([]
    (new NotActiveException )))

