(ns jdk.security.cert.LDAPCertStoreParameters
  "Parameters used as input for the LDAP CertStore algorithm.

  This class is used to provide necessary configuration parameters (server
  name and port number) to implementations of the LDAP CertStore
  algorithm.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert LDAPCertStoreParameters]))

(defn ->ldap-cert-store-parameters
  "Constructor.

  Creates an instance of LDAPCertStoreParameters with the
   specified parameter values.

  server-name - the DNS name of the LDAP server - `java.lang.String`
  port - the port number of the LDAP server - `int`

  throws: java.lang.NullPointerException - if serverName is null"
  ([server-name port]
    (new LDAPCertStoreParameters server-name port))
  ([server-name]
    (new LDAPCertStoreParameters server-name))
  ([]
    (new LDAPCertStoreParameters )))

(defn get-server-name
  "Returns the DNS name of the LDAP server.

  returns: the name (not null) - `java.lang.String`"
  ([this]
    (-> this (.getServerName))))

(defn get-port
  "Returns the port number of the LDAP server.

  returns: the port number - `int`"
  ([this]
    (-> this (.getPort))))

(defn clone
  "Returns a copy of this object. Changes to the copy will not affect
   the original and vice versa.

   Note: this method currently performs a shallow copy of the object
   (simply calls Object.clone()). This may be changed in a
   future revision to perform a deep copy if new parameters are added
   that should not be shared.

  returns: the copy - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn to-string
  "Returns a formatted string describing the parameters.

  returns: a formatted string describing the parameters - `java.lang.String`"
  ([this]
    (-> this (.toString))))

