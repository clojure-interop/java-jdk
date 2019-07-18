(ns jdk.util.FormatterClosedException
  "Unchecked exception thrown when the formatter has been closed.

   Unless otherwise specified, passing a null argument to any
  method or constructor in this class will cause a NullPointerException to be thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util FormatterClosedException]))

(defn ->formatter-closed-exception
  "Constructor.

  Constructs an instance of this class."
  (^FormatterClosedException []
    (new FormatterClosedException )))

