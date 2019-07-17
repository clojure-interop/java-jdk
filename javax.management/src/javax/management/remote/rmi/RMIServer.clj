(ns javax.management.remote.rmi.RMIServer
  "RMI object used to establish connections to an RMI connector.
  There is one Remote object implementing this interface for each RMI
  connector.

  User code does not usually refer to this interface.  It is
  specified as part of the public API so that different
  implementations of that API will interoperate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIServer]))

(defn get-version
  "The version of the RMI Connector Protocol understood by this
   connector server.  This is a string with the following format:



   protocol-version implementation-name

   The protocol-version is a series of
   two or more non-negative integers separated by periods
   (.).  An implementation of the version described
   by this documentation must use the string 1.0
   here.

   After the protocol version there must be a space, followed
   by the implementation name.  The format of the implementation
   name is unspecified.  It is recommended that it include an
   implementation version number.  An implementation can use an
   empty string as its implementation name, for example for
   security reasons.

  returns: a string with the format described here. - `java.lang.String`

  throws: java.rmi.RemoteException - if there is a communication exception during the remote method call."
  ([this]
    (-> this (.getVersion))))

(defn new-client
  "Makes a new connection through this RMI connector.  Each
   remote client calls this method to obtain a new RMI object
   representing its connection.

  credentials - this object specifies the user-defined credentials to be passed in to the server in order to authenticate the user before creating the RMIConnection. Can be null. - `java.lang.Object`

  returns: the newly-created connection object. - `javax.management.remote.rmi.RMIConnection`

  throws: java.io.IOException - if the new client object cannot be created or exported, or if there is a communication exception during the remote method call."
  ([this credentials]
    (-> this (.newClient credentials))))

