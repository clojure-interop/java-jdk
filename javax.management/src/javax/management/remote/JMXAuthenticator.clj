(ns javax.management.remote.JMXAuthenticator
  "Interface to define how remote credentials are converted into a
  JAAS Subject.  This interface is used by the RMI Connector Server,
  and can be used by other connector servers.

  The user-defined authenticator instance is passed to the
  connector server in the environment map as the value of the
  attribute JMXConnectorServer.AUTHENTICATOR.  For connector
  servers that use only this authentication system, if this attribute
  is not present or its value is null then no user
  authentication will be performed and full access to the methods
  exported by the MBeanServerConnection object will be
  allowed.

  If authentication is successful then an authenticated
  subject filled in with its associated
  principals is returned. Authorization checks
  will be then performed based on the given set of principals."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.remote JMXAuthenticator]))

(defn authenticate
  "Authenticates the MBeanServerConnection client
   with the given client credentials.

  credentials - the user-defined credentials to be passed into the server in order to authenticate the user before creating the MBeanServerConnection. The actual type of this parameter, and whether it can be null, depends on the connector. - `java.lang.Object`

  returns: the authenticated subject containing its associated principals. - `javax.security.auth.Subject`

  throws: java.lang.SecurityException - if the server cannot authenticate the user with the provided credentials."
  ([this credentials]
    (-> this (.authenticate credentials))))

