(ns javax.management.remote.rmi.RMIJRMPServerImpl
  "An RMIServer object that is exported through JRMP and that
  creates client connections as RMI objects exported through JRMP.
  User code does not usually reference this class directly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote.rmi RMIJRMPServerImpl]))

(defn ->rmijrmp-server-impl
  "Constructor.

  Creates a new RMIServer object that will be exported
   on the given port using the given socket factories.

  port - the port on which this object and the RMIConnectionImpl objects it creates will be exported. Can be zero, to indicate any available port. - `int`
  csf - the client socket factory for the created RMI objects. Can be null. - `java.rmi.server.RMIClientSocketFactory`
  ssf - the server socket factory for the created RMI objects. Can be null. - `java.rmi.server.RMIServerSocketFactory`
  env - the environment map. Can be null. - `java.util.Map<java.lang.String,?>`

  throws: java.io.IOException - if the RMIServer object cannot be created."
  ([^Integer port ^java.rmi.server.RMIClientSocketFactory csf ^java.rmi.server.RMIServerSocketFactory ssf ^java.util.Map env]
    (new RMIJRMPServerImpl port csf ssf env)))

(defn to-stub
  "Returns a serializable stub for this RMIServer object.

  returns: a serializable stub. - `java.rmi.Remote`

  throws: java.io.IOException - if the stub cannot be obtained - e.g the RMIJRMPServerImpl has not been exported yet."
  (^java.rmi.Remote [^javax.management.remote.rmi.RMIJRMPServerImpl this]
    (-> this (.toStub))))

