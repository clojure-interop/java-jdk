(ns javax.management.remote.rmi.RMIServerImpl_Stub
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIServerImpl_Stub]))

(defn ->rmi-server-impl-stub
  "Constructor.

  ref - `java.rmi.server.RemoteRef`"
  ([^java.rmi.server.RemoteRef ref]
    (new RMIServerImpl_Stub ref)))

(defn get-version
  "Description copied from interface: RMIServer

  returns: a string with the format described here. - `java.lang.String`

  throws: java.rmi.RemoteException - if there is a communication exception during the remote method call."
  ([^javax.management.remote.rmi.RMIServerImpl_Stub this]
    (-> this (.getVersion))))

(defn new-client
  "Description copied from interface: RMIServer

  $param-object-1 - this object specifies the user-defined credentials to be passed in to the server in order to authenticate the user before creating the RMIConnection. Can be null. - `java.lang.Object`

  returns: the newly-created connection object. - `javax.management.remote.rmi.RMIConnection`

  throws: java.io.IOException - if the new client object cannot be created or exported, or if there is a communication exception during the remote method call."
  ([^javax.management.remote.rmi.RMIServerImpl_Stub this ^java.lang.Object $param-object-1]
    (-> this (.newClient $param-object-1))))

