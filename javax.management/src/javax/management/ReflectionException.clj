(ns javax.management.ReflectionException
  "Represents exceptions thrown in the MBean server when using the
  java.lang.reflect classes to invoke methods on MBeans. It `wraps` the
  actual java.lang.Exception thrown."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management ReflectionException]))

(defn ->reflection-exception
  "Constructor.

  Creates a ReflectionException that wraps the actual java.lang.Exception with
   a detail message.

  e - the wrapped exception. - `java.lang.Exception`
  message - the detail message. - `java.lang.String`"
  (^ReflectionException [^java.lang.Exception e ^java.lang.String message]
    (new ReflectionException e message))
  (^ReflectionException [^java.lang.Exception e]
    (new ReflectionException e)))

(defn get-target-exception
  "Returns the actual Exception thrown.

  returns: the wrapped Exception. - `java.lang.Exception`"
  (^java.lang.Exception [^ReflectionException this]
    (-> this (.getTargetException))))

(defn get-cause
  "Returns the actual Exception thrown.

  returns: the wrapped Exception. - `java.lang.Throwable`"
  (^java.lang.Throwable [^ReflectionException this]
    (-> this (.getCause))))

