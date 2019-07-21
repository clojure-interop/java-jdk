(ns javax.management.RuntimeMBeanException
  "Represents runtime exceptions thrown by MBean methods in
  the agent. It \"wraps\" the actual java.lang.RuntimeException exception thrown.
  This exception will be built by the MBeanServer when a call to an
  MBean method throws a runtime exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management RuntimeMBeanException]))

(defn ->runtime-m-bean-exception
  "Constructor.

  Creates a RuntimeMBeanException that wraps the actual java.lang.RuntimeException with
   a detailed message.

  e - the wrapped exception. - `java.lang.RuntimeException`
  message - the detail message. - `java.lang.String`"
  (^RuntimeMBeanException [^java.lang.RuntimeException e ^java.lang.String message]
    (new RuntimeMBeanException e message))
  (^RuntimeMBeanException [^java.lang.RuntimeException e]
    (new RuntimeMBeanException e)))

(defn get-target-exception
  "Returns the actual RuntimeException thrown.

  returns: the wrapped RuntimeException. - `java.lang.RuntimeException`"
  (^java.lang.RuntimeException [^RuntimeMBeanException this]
    (-> this (.getTargetException))))

(defn get-cause
  "Returns the actual RuntimeException thrown.

  returns: the wrapped RuntimeException. - `java.lang.Throwable`"
  (^java.lang.Throwable [^RuntimeMBeanException this]
    (-> this (.getCause))))

