(ns jdk.nio.BufferUnderflowException
  "Unchecked exception thrown when a relative get operation reaches
  the source buffer's limit."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio BufferUnderflowException]))

(defn ->buffer-underflow-exception
  "Constructor.

  Constructs an instance of this class."
  (^BufferUnderflowException []
    (new BufferUnderflowException )))

