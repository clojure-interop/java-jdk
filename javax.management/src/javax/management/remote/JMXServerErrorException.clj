(ns javax.management.remote.JMXServerErrorException
  "Exception thrown as the result of a remote MBeanServer
  method invocation when an Error is thrown while
  processing the invocation in the remote MBean server.  A
  JMXServerErrorException instance contains the original
  Error that occurred as its cause."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXServerErrorException]))

(defn ->jmx-server-error-exception
  "Constructor.

  Constructs a JMXServerErrorException with the specified
   detail message and nested error.

  s - the detail message. - `java.lang.String`
  err - the nested error. An instance of this class can be constructed where this parameter is null, but the standard connectors will never do so. - `java.lang.Error`"
  ([s err]
    (new JMXServerErrorException s err)))

(defn get-cause
  "Description copied from class: Throwable

  returns: the cause of this throwable or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  ([this]
    (-> this (.getCause))))

