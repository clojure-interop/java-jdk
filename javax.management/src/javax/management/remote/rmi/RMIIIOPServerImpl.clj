(ns javax.management.remote.rmi.RMIIIOPServerImpl
  "An RMIServerImpl that is exported through IIOP and that
  creates client connections as RMI objects exported through IIOP.
  User code does not usually reference this class directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIIIOPServerImpl]))

(defn ->rmiiiop-server-impl
  "Constructor.

  Creates a new RMIServerImpl.

  env - the environment containing attributes for the new RMIServerImpl. Can be null, which is equivalent to an empty Map. - `java.util.Map<java.lang.String,?>`

  throws: java.io.IOException - if the RMI object cannot be created."
  ([env]
    (new RMIIIOPServerImpl env)))

(defn to-stub
  "Returns an IIOP stub.
   The stub might not yet be connected to the ORB. The stub will
   be serializable only if it is connected to the ORB.

  returns: an IIOP stub. - `java.rmi.Remote`

  throws: java.io.IOException - if the stub cannot be created - e.g the RMIIIOPServerImpl has not been exported yet."
  ([this]
    (-> this (.toStub))))

