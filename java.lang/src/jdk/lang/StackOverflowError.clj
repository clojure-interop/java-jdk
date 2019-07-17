(ns jdk.lang.StackOverflowError
  "Thrown when a stack overflow occurs because an application
  recurses too deeply."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang StackOverflowError]))

(defn ->stack-overflow-error
  "Constructor.

  Constructs a StackOverflowError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new StackOverflowError s))
  ([]
    (new StackOverflowError )))

