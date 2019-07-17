(ns jdk.rmi.server.ServerRef
  "Deprecated.
 No replacement. This interface is unused and is obsolete."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server ServerRef]))

(defn export-object
  "Deprecated.

  obj - the remote object implementation - `java.rmi.Remote`
  data - information necessary to export the object - `java.lang.Object`

  returns: the stub for the remote object - `java.rmi.server.RemoteStub`

  throws: java.rmi.RemoteException - if an exception occurs attempting to export the object (e.g., stub class could not be found)"
  ([this obj data]
    (-> this (.exportObject obj data))))

(defn get-client-host
  "Deprecated.

  returns: the client's host name - `java.lang.String`

  throws: java.rmi.server.ServerNotActiveException - if called outside of servicing a remote method invocation"
  ([this]
    (-> this (.getClientHost))))

