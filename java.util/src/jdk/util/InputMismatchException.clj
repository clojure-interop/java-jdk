(ns jdk.util.InputMismatchException
  "Thrown by a Scanner to indicate that the token
  retrieved does not match the pattern for the expected type, or
  that the token is out of range for the expected type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util InputMismatchException]))

(defn ->input-mismatch-exception
  "Constructor.

  Constructs an InputMismatchException, saving a reference
   to the error message string s for later retrieval by the
   getMessage method.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new InputMismatchException s))
  ([]
    (new InputMismatchException )))

