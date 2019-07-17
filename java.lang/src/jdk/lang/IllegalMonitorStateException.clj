(ns jdk.lang.IllegalMonitorStateException
  "Thrown to indicate that a thread has attempted to wait on an
  object's monitor or to notify other threads waiting on an object's
  monitor without owning the specified monitor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IllegalMonitorStateException]))

(defn ->illegal-monitor-state-exception
  "Constructor.

  Constructs an IllegalMonitorStateException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new IllegalMonitorStateException s))
  ([]
    (new IllegalMonitorStateException )))

