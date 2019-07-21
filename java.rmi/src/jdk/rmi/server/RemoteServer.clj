(ns jdk.rmi.server.RemoteServer
  "The RemoteServer class is the common superclass to server
  implementations and provides the framework to support a wide range
  of remote reference semantics.  Specifically, the functions needed
  to create and export remote objects (i.e. to make them remotely
  available) are provided abstractly by RemoteServer and
  concretely by its subclass(es)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RemoteServer]))

(defn *get-client-host
  "Returns a string representation of the client host for the
   remote method invocation being processed in the current thread.

  returns: a string representation of the client host - `java.lang.String`

  throws: java.rmi.server.ServerNotActiveException - if no remote method invocation is being processed in the current thread"
  (^java.lang.String []
    (RemoteServer/getClientHost )))

(defn *set-log
  "Log RMI calls to the output stream out. If
   out is null, call logging is turned off.

   If there is a security manager, its
   checkPermission method will be invoked with a
   java.util.logging.LoggingPermission(\"control\")
   permission; this could result in a SecurityException.

  out - the output stream to which RMI calls should be logged - `java.io.OutputStream`

  throws: java.lang.SecurityException - if there is a security manager and the invocation of its checkPermission method fails"
  ([^java.io.OutputStream out]
    (RemoteServer/setLog out)))

(defn *get-log
  "Returns stream for the RMI call log.

  returns: the call log - `java.io.PrintStream`"
  (^java.io.PrintStream []
    (RemoteServer/getLog )))

