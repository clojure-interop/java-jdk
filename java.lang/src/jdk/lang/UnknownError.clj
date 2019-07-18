(ns jdk.lang.UnknownError
  "Thrown when an unknown but serious exception has occurred in the
  Java Virtual Machine."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang UnknownError]))

(defn ->unknown-error
  "Constructor.

  Constructs an UnknownError with the specified detail
   message.

  s - the detail message. - `java.lang.String`"
  (^UnknownError [^java.lang.String s]
    (new UnknownError s))
  (^UnknownError []
    (new UnknownError )))

