(ns jdk.beans.ExceptionListener
  "An ExceptionListener is notified of internal exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans ExceptionListener]))

(defn exception-thrown
  "This method is called when a recoverable exception has
   been caught.

  e - The exception that was caught. - `java.lang.Exception`"
  ([^ExceptionListener this ^java.lang.Exception e]
    (-> this (.exceptionThrown e))))

