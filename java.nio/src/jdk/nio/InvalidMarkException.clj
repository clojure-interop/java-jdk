(ns jdk.nio.InvalidMarkException
  "Unchecked exception thrown when an attempt is made to reset a buffer
  when its mark is not defined."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio InvalidMarkException]))

(defn ->invalid-mark-exception
  "Constructor.

  Constructs an instance of this class."
  (^InvalidMarkException []
    (new InvalidMarkException )))

