(ns jdk.security.spec.InvalidParameterSpecException
  "This is the exception for invalid parameter specifications."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec InvalidParameterSpecException]))

(defn ->invalid-parameter-spec-exception
  "Constructor.

  Constructs an InvalidParameterSpecException with the specified detail
   message. A detail message is a String that describes this
   particular exception.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new InvalidParameterSpecException msg))
  ([]
    (new InvalidParameterSpecException )))

