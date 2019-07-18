(ns javax.management.MBeanException
  "Represents `user defined` exceptions thrown by MBean methods
  in the agent. It `wraps` the actual `user defined` exception thrown.
  This exception will be built by the MBeanServer when a call to an
  MBean method results in an unknown exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanException]))

(defn ->m-bean-exception
  "Constructor.

  Creates an MBeanException that wraps the actual java.lang.Exception with
   a detail message.

  e - the wrapped exception. - `java.lang.Exception`
  message - the detail message. - `java.lang.String`"
  (^MBeanException [^java.lang.Exception e ^java.lang.String message]
    (new MBeanException e message))
  (^MBeanException [^java.lang.Exception e]
    (new MBeanException e)))

(defn get-target-exception
  "Return the actual Exception thrown.

  returns: the wrapped exception. - `java.lang.Exception`"
  (^java.lang.Exception [^MBeanException this]
    (-> this (.getTargetException))))

(defn get-cause
  "Return the actual Exception thrown.

  returns: the wrapped exception. - `java.lang.Throwable`"
  (^java.lang.Throwable [^MBeanException this]
    (-> this (.getCause))))

