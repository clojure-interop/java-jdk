(ns javax.management.RuntimeOperationsException
  "Represents runtime exceptions thrown in the agent when performing operations on MBeans.
  It wraps the actual java.lang.RuntimeException thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management RuntimeOperationsException]))

(defn ->runtime-operations-exception
  "Constructor.

  Creates a RuntimeOperationsException that wraps the actual java.lang.RuntimeException
   with a detailed message.

  e - the wrapped exception. - `java.lang.RuntimeException`
  message - the detail message. - `java.lang.String`"
  ([e message]
    (new RuntimeOperationsException e message))
  ([e]
    (new RuntimeOperationsException e)))

(defn get-target-exception
  "Returns the actual RuntimeException thrown.

  returns: the wrapped RuntimeException. - `java.lang.RuntimeException`"
  ([this]
    (-> this (.getTargetException))))

(defn get-cause
  "Returns the actual RuntimeException thrown.

  returns: the wrapped RuntimeException. - `java.lang.Throwable`"
  ([this]
    (-> this (.getCause))))

