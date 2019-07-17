(ns jdk.rmi.registry.RegistryHandler
  "Deprecated.
 no replacement"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.registry RegistryHandler]))

(defn registry-stub
  "Deprecated. no replacement.  As of the Java 2 platform v1.2, RMI no
   longer uses the RegistryHandler to obtain the registry's
   stub.

  host - name of remote registry host - `java.lang.String`
  port - remote registry port - `int`

  returns: remote registry stub - `java.lang..rmi.registry.Registry`

  throws: java.rmi.RemoteException - if a remote error occurs"
  ([this host port]
    (-> this (.registryStub host port))))

(defn registry-impl
  "Deprecated. no replacement.  As of the Java 2 platform v1.2, RMI no
   longer uses the RegistryHandler to obtain the registry's
   implementation.

  port - port to export registry on - `int`

  returns: registry stub - `java.lang..rmi.registry.Registry`

  throws: java.rmi.RemoteException - if a remote error occurs"
  ([this port]
    (-> this (.registryImpl port))))

