(ns jdk.lang.IllegalThreadStateException
  "Thrown to indicate that a thread is not in an appropriate state
  for the requested operation. See, for example, the
  suspend and resume methods in class
  Thread."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IllegalThreadStateException]))

(defn ->illegal-thread-state-exception
  "Constructor.

  Constructs an IllegalThreadStateException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new IllegalThreadStateException s))
  ([]
    (new IllegalThreadStateException )))

