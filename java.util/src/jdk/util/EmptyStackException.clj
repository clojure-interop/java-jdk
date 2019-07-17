(ns jdk.util.EmptyStackException
  "Thrown by methods in the Stack class to indicate
  that the stack is empty."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util EmptyStackException]))

(defn ->empty-stack-exception
  "Constructor.

  Constructs a new EmptyStackException with null
   as its error message string."
  ([]
    (new EmptyStackException )))

