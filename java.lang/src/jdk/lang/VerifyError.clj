(ns jdk.lang.VerifyError
  "Thrown when the \"verifier\" detects that a class file,
  though well formed, contains some sort of internal inconsistency
  or security problem."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang VerifyError]))

(defn ->verify-error
  "Constructor.

  Constructs an VerifyError with the specified detail message.

  s - the detail message. - `java.lang.String`"
  (^VerifyError [^java.lang.String s]
    (new VerifyError s))
  (^VerifyError []
    (new VerifyError )))

