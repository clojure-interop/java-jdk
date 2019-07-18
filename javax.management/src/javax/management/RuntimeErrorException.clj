(ns javax.management.RuntimeErrorException
  "When a java.lang.Error occurs in the agent it should be caught and
  re-thrown as a RuntimeErrorException."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management RuntimeErrorException]))

(defn ->runtime-error-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  e - the wrapped error. - `java.lang.Error`
  message - the detail message. - `java.lang.String`"
  (^RuntimeErrorException [^java.lang.Error e ^java.lang.String message]
    (new RuntimeErrorException e message))
  (^RuntimeErrorException [^java.lang.Error e]
    (new RuntimeErrorException e)))

(defn get-target-error
  "Returns the actual Error thrown.

  returns: the wrapped Error. - `java.lang.Error`"
  (^java.lang.Error [^RuntimeErrorException this]
    (-> this (.getTargetError))))

(defn get-cause
  "Returns the actual Error thrown.

  returns: the wrapped Error. - `java.lang.Throwable`"
  (^java.lang.Throwable [^RuntimeErrorException this]
    (-> this (.getCause))))

