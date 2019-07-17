(ns javax.security.sasl.SaslClientFactory
  "An interface for creating instances of SaslClient.
  A class that implements this interface
  must be thread-safe and handle multiple simultaneous
  requests. It must also have a public constructor that accepts no
  argument.

  This interface is not normally accessed directly by a client, which will use the
  Sasl static methods
  instead. However, a particular environment may provide and install a
  new or different SaslClientFactory."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl SaslClientFactory]))

(defn create-sasl-client
  "Creates a SaslClient using the parameters supplied.

  mechanisms - The non-null list of mechanism names to try. Each is the IANA-registered name of a SASL mechanism. (e.g. `GSSAPI`, `CRAM-MD5`). - `java.lang.String[]`
  authorization-id - The possibly null protocol-dependent identification to be used for authorization. If null or empty, the server derives an authorization ID from the client's authentication credentials. When the SASL authentication completes successfully, the specified entity is granted access. - `java.lang.String`
  protocol - The non-null string name of the protocol for which the authentication is being performed (e.g., `ldap`). - `java.lang.String`
  server-name - The non-null fully qualified host name of the server to authenticate to. - `java.lang.String`
  props - The possibly null set of properties used to select the SASL mechanism and to configure the authentication exchange of the selected mechanism. See the Sasl class for a list of standard properties. Other, possibly mechanism-specific, properties can be included. Properties not relevant to the selected mechanism are ignored, including any map entries with non-String keys. - `java.util.Map<java.lang.String,?>`
  cbh - The possibly null callback handler to used by the SASL mechanisms to get further information from the application/library to complete the authentication. For example, a SASL mechanism might require the authentication ID, password and realm from the caller. The authentication ID is requested by using a NameCallback. The password is requested by using a PasswordCallback. The realm is requested by using a RealmChoiceCallback if there is a list of realms to choose from, and by using a RealmCallback if the realm must be entered. - `javax.security.auth.callback.CallbackHandler`

  returns: A possibly null SaslClient created using the parameters
   supplied. If null, this factory cannot produce a SaslClient
   using the parameters supplied. - `javax.security.sasl.SaslClient`

  throws: javax.security.sasl.SaslException - If cannot create a SaslClient because of an error."
  (^javax.security.sasl.SaslClient [^javax.security.sasl.SaslClientFactory this mechanisms ^java.lang.String authorization-id ^java.lang.String protocol ^java.lang.String server-name ^java.util.Map props ^javax.security.auth.callback.CallbackHandler cbh]
    (-> this (.createSaslClient mechanisms authorization-id protocol server-name props cbh))))

(defn get-mechanism-names
  "Returns an array of names of mechanisms that match the specified
   mechanism selection policies.

  props - The possibly null set of properties used to specify the security policy of the SASL mechanisms. For example, if props contains the Sasl.POLICY_NOPLAINTEXT property with the value `true`, then the factory must not return any SASL mechanisms that are susceptible to simple plain passive attacks. See the Sasl class for a complete list of policy properties. Non-policy related properties, if present in props, are ignored, including any map entries with non-String keys. - `java.util.Map<java.lang.String,?>`

  returns: A non-null array containing a IANA-registered SASL mechanism names. - `java.lang.String[]`"
  ([^javax.security.sasl.SaslClientFactory this ^java.util.Map props]
    (-> this (.getMechanismNames props))))

