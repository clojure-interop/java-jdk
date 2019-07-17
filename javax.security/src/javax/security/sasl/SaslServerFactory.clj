(ns javax.security.sasl.SaslServerFactory
  "An interface for creating instances of SaslServer.
  A class that implements this interface
  must be thread-safe and handle multiple simultaneous
  requests. It must also have a public constructor that accepts no
  argument.

  This interface is not normally accessed directly by a server, which will use the
  Sasl static methods
  instead. However, a particular environment may provide and install a
  new or different SaslServerFactory."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl SaslServerFactory]))

(defn create-sasl-server
  "Creates a SaslServer using the parameters supplied.
   It returns null
   if no SaslServer can be created using the parameters supplied.
   Throws SaslException if it cannot create a SaslServer
   because of an error.

  mechanism - The non-null IANA-registered name of a SASL mechanism. (e.g. `GSSAPI`, `CRAM-MD5`). - `java.lang.String`
  protocol - The non-null string name of the protocol for which the authentication is being performed (e.g., `ldap`). - `java.lang.String`
  server-name - The fully qualified host name of the server to authenticate to, or null if the server is not bound to any specific host name. If the mechanism does not allow an unbound server, a SaslException will be thrown. - `java.lang.String`
  props - The possibly null set of properties used to select the SASL mechanism and to configure the authentication exchange of the selected mechanism. See the Sasl class for a list of standard properties. Other, possibly mechanism-specific, properties can be included. Properties not relevant to the selected mechanism are ignored, including any map entries with non-String keys. - `java.util.Map<java.lang.String,?>`
  cbh - The possibly null callback handler to used by the SASL mechanisms to get further information from the application/library to complete the authentication. For example, a SASL mechanism might require the authentication ID, password and realm from the caller. The authentication ID is requested by using a NameCallback. The password is requested by using a PasswordCallback. The realm is requested by using a RealmChoiceCallback if there is a list of realms to choose from, and by using a RealmCallback if the realm must be entered. - `javax.security.auth.callback.CallbackHandler`

  returns: A possibly null SaslServer created using the parameters
   supplied. If null, this factory cannot produce a SaslServer
   using the parameters supplied. - `javax.security.sasl.SaslServer`

  throws: javax.security.sasl.SaslException - If cannot create a SaslServer because of an error."
  ([this mechanism protocol server-name props cbh]
    (-> this (.createSaslServer mechanism protocol server-name props cbh))))

(defn get-mechanism-names
  "Returns an array of names of mechanisms that match the specified
   mechanism selection policies.

  props - The possibly null set of properties used to specify the security policy of the SASL mechanisms. For example, if props contains the Sasl.POLICY_NOPLAINTEXT property with the value `true`, then the factory must not return any SASL mechanisms that are susceptible to simple plain passive attacks. See the Sasl class for a complete list of policy properties. Non-policy related properties, if present in props, are ignored, including any map entries with non-String keys. - `java.util.Map<java.lang.String,?>`

  returns: A non-null array containing a IANA-registered SASL mechanism names. - `java.lang.String[]`"
  ([this props]
    (-> this (.getMechanismNames props))))

