(ns javax.security.sasl.Sasl
  "A static class for creating SASL clients and servers.

  This class defines the policy of how to locate, load, and instantiate
  SASL clients and servers.

  For example, an application or library gets a SASL client by doing
  something like:


  SaslClient sc = Sasl.createSaslClient(mechanisms,
      authorizationId, protocol, serverName, props, callbackHandler);
  It can then proceed to use the instance to create an authentication connection.

  Similarly, a server gets a SASL server by using code that looks as follows:


  SaslServer ss = Sasl.createSaslServer(mechanism,
      protocol, serverName, props, callbackHandler);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl Sasl]))

(def *-qop
  "Static Constant.

  The name of a property that specifies the quality-of-protection to use.
   The property contains a comma-separated, ordered list
   of quality-of-protection values that the
   client or server is willing to support.  A qop value is one of

   `auth` - authentication only
   `auth-int` - authentication plus integrity protection
   `auth-conf` - authentication plus integrity and confidentiality
   protection


   The order of the list specifies the preference order of the client or
   server. If this property is absent, the default qop is `auth`.
   The value of this constant is `javax.security.sasl.qop`.

  type: java.lang.String"
  Sasl/QOP)

(def *-strength
  "Static Constant.

  The name of a property that specifies the cipher strength to use.
   The property contains a comma-separated, ordered list
   of cipher strength values that
   the client or server is willing to support. A strength value is one of

   `low`
   `medium`
   `high`

   The order of the list specifies the preference order of the client or
   server.  An implementation should allow configuration of the meaning
   of these values.  An application may use the Java Cryptography
   Extension (JCE) with JCE-aware mechanisms to control the selection of
   cipher suites that match the strength values.

   If this property is absent, the default strength is
   `high,medium,low`.
   The value of this constant is `javax.security.sasl.strength`.

  type: java.lang.String"
  Sasl/STRENGTH)

(def *-server-auth
  "Static Constant.

  The name of a property that specifies whether the
   server must authenticate to the client. The property contains
   `true` if the server must
   authenticate the to client; `false` otherwise.
   The default is `false`.
   The value of this constant is
   `javax.security.sasl.server.authentication`.

  type: java.lang.String"
  Sasl/SERVER_AUTH)

(def *-bound-server-name
  "Static Constant.

  The name of a property that specifies the bound server name for
   an unbound server. A server is created as an unbound server by setting
   the serverName argument in createSaslServer(java.lang.String, java.lang.String, java.lang.String, java.util.Map<java.lang.String, ?>, javax.security.auth.callback.CallbackHandler) as null.
   The property contains the bound host name after the authentication
   exchange has completed. It is only available on the server side.
   The value of this constant is
   `javax.security.sasl.bound.server.name`.

  type: java.lang.String"
  Sasl/BOUND_SERVER_NAME)

(def *-max-buffer
  "Static Constant.

  The name of a property that specifies the maximum size of the receive
   buffer in bytes of SaslClient/SaslServer.
   The property contains the string representation of an integer.
   If this property is absent, the default size
   is defined by the mechanism.
   The value of this constant is `javax.security.sasl.maxbuffer`.

  type: java.lang.String"
  Sasl/MAX_BUFFER)

(def *-raw-send-size
  "Static Constant.

  The name of a property that specifies the maximum size of the raw send
   buffer in bytes of SaslClient/SaslServer.
   The property contains the string representation of an integer.
   The value of this property is negotiated between the client and server
   during the authentication exchange.
   The value of this constant is `javax.security.sasl.rawsendsize`.

  type: java.lang.String"
  Sasl/RAW_SEND_SIZE)

(def *-reuse
  "Static Constant.

  The name of a property that specifies whether to reuse previously
   authenticated session information. The property contains `true` if the
   mechanism implementation may attempt to reuse previously authenticated
   session information; it contains `false` if the implementation must
   not reuse previously authenticated session information.  A setting of
   `true` serves only as a hint: it does not necessarily entail actual
   reuse because reuse might not be possible due to a number of reasons,
   including, but not limited to, lack of mechanism support for reuse,
   expiration of reusable information, and the peer's refusal to support
   reuse.

   The property's default value is `false`.  The value of this constant
   is `javax.security.sasl.reuse`.

   Note that all other parameters and properties required to create a
   SASL client/server instance must be provided regardless of whether
   this property has been supplied. That is, you cannot supply any less
   information in anticipation of reuse.

   Mechanism implementations that support reuse might allow customization
   of its implementation, for factors such as cache size, timeouts, and
   criteria for reusability. Such customizations are
   implementation-dependent.

  type: java.lang.String"
  Sasl/REUSE)

(def *-policy-noplaintext
  "Static Constant.

  The name of a property that specifies
   whether mechanisms susceptible to simple plain passive attacks (e.g.,
   `PLAIN`) are not permitted. The property
   contains `true` if such mechanisms are not permitted;
   `false` if such mechanisms are permitted.
   The default is `false`.
   The value of this constant is
   `javax.security.sasl.policy.noplaintext`.

  type: java.lang.String"
  Sasl/POLICY_NOPLAINTEXT)

(def *-policy-noactive
  "Static Constant.

  The name of a property that specifies whether
   mechanisms susceptible to active (non-dictionary) attacks
   are not permitted.
   The property contains `true`
   if mechanisms susceptible to active attacks
   are not permitted; `false` if such mechanisms are permitted.
   The default is `false`.
   The value of this constant is
   `javax.security.sasl.policy.noactive`.

  type: java.lang.String"
  Sasl/POLICY_NOACTIVE)

(def *-policy-nodictionary
  "Static Constant.

  The name of a property that specifies whether
   mechanisms susceptible to passive dictionary attacks are not permitted.
   The property contains `true`
   if mechanisms susceptible to dictionary attacks are not permitted;
   `false` if such mechanisms are permitted.
   The default is `false`.

   The value of this constant is
   `javax.security.sasl.policy.nodictionary`.

  type: java.lang.String"
  Sasl/POLICY_NODICTIONARY)

(def *-policy-noanonymous
  "Static Constant.

  The name of a property that specifies whether mechanisms that accept
   anonymous login are not permitted. The property contains `true`
   if mechanisms that accept anonymous login are not permitted;
   `false`
   if such mechanisms are permitted. The default is `false`.

   The value of this constant is
   `javax.security.sasl.policy.noanonymous`.

  type: java.lang.String"
  Sasl/POLICY_NOANONYMOUS)

(def *-policy-forward-secrecy
  "Static Constant.

  The name of a property that specifies whether mechanisms that implement
   forward secrecy between sessions are required. Forward secrecy
   means that breaking into one session will not automatically
   provide information for breaking into future sessions.
   The property
   contains `true` if mechanisms that implement forward secrecy
   between sessions are required; `false` if such mechanisms
   are not required. The default is `false`.

   The value of this constant is
   `javax.security.sasl.policy.forward`.

  type: java.lang.String"
  Sasl/POLICY_FORWARD_SECRECY)

(def *-policy-pass-credentials
  "Static Constant.

  The name of a property that specifies whether
   mechanisms that pass client credentials are required. The property
   contains `true` if mechanisms that pass
   client credentials are required; `false`
   if such mechanisms are not required. The default is `false`.

   The value of this constant is
   `javax.security.sasl.policy.credentials`.

  type: java.lang.String"
  Sasl/POLICY_PASS_CREDENTIALS)

(def *-credentials
  "Static Constant.

  The name of a property that specifies the credentials to use.
   The property contains a mechanism-specific Java credential object.
   Mechanism implementations may examine the value of this property
   to determine whether it is a class that they support.
   The property may be used to supply credentials to a mechanism that
   supports delegated authentication.

   The value of this constant is
   `javax.security.sasl.credentials`.

  type: java.lang.String"
  Sasl/CREDENTIALS)

(defn *create-sasl-client
  "Creates a SaslClient using the parameters supplied.

   This method uses the
  JCA Security Provider Framework, described in the
   `Java Cryptography Architecture API Specification & Reference`, for
   locating and selecting a SaslClient implementation.

   First, it
   obtains an ordered list of SaslClientFactory instances from
   the registered security providers for the `SaslClientFactory` service
   and the specified SASL mechanism(s). It then invokes
   createSaslClient() on each factory instance on the list
   until one produces a non-null SaslClient instance. It returns
   the non-null SaslClient instance, or null if the search fails
   to produce a non-null SaslClient instance.

   A security provider for SaslClientFactory registers with the
   JCA Security Provider Framework keys of the form
   SaslClientFactory.mechanism_name

   and values that are class names of implementations of
   javax.security.sasl.SaslClientFactory.

   For example, a provider that contains a factory class,
   com.wiz.sasl.digest.ClientFactory, that supports the
   `DIGEST-MD5` mechanism would register the following entry with the JCA:
   SaslClientFactory.DIGEST-MD5 com.wiz.sasl.digest.ClientFactory

   See the
   `Java Cryptography Architecture API Specification & Reference`
   for information about how to install and configure security service
    providers.

  mechanisms - The non-null list of mechanism names to try. Each is the IANA-registered name of a SASL mechanism. (e.g. `GSSAPI`, `CRAM-MD5`). - `java.lang.String[]`
  authorization-id - The possibly null protocol-dependent identification to be used for authorization. If null or empty, the server derives an authorization ID from the client's authentication credentials. When the SASL authentication completes successfully, the specified entity is granted access. - `java.lang.String`
  protocol - The non-null string name of the protocol for which the authentication is being performed (e.g., `ldap`). - `java.lang.String`
  server-name - The non-null fully-qualified host name of the server to authenticate to. - `java.lang.String`
  props - The possibly null set of properties used to select the SASL mechanism and to configure the authentication exchange of the selected mechanism. For example, if props contains the Sasl.POLICY_NOPLAINTEXT property with the value `true`, then the selected SASL mechanism must not be susceptible to simple plain passive attacks. In addition to the standard properties declared in this class, other, possibly mechanism-specific, properties can be included. Properties not relevant to the selected mechanism are ignored, including any map entries with non-String keys. - `java.util.Map<java.lang.String,?>`
  cbh - The possibly null callback handler to used by the SASL mechanisms to get further information from the application/library to complete the authentication. For example, a SASL mechanism might require the authentication ID, password and realm from the caller. The authentication ID is requested by using a NameCallback. The password is requested by using a PasswordCallback. The realm is requested by using a RealmChoiceCallback if there is a list of realms to choose from, and by using a RealmCallback if the realm must be entered. - `javax.security.auth.callback.CallbackHandler`

  returns: A possibly null SaslClient created using the parameters
   supplied. If null, cannot find a SaslClientFactory
   that will produce one. - `javax.security.sasl.SaslClient`

  throws: javax.security.sasl.SaslException - If cannot create a SaslClient because of an error."
  ([mechanisms authorization-id protocol server-name props cbh]
    (Sasl/createSaslClient mechanisms authorization-id protocol server-name props cbh)))

(defn *create-sasl-server
  "Creates a SaslServer for the specified mechanism.

   This method uses the
  JCA Security Provider Framework,
   described in the
   `Java Cryptography Architecture API Specification & Reference`, for
   locating and selecting a SaslServer implementation.

   First, it
   obtains an ordered list of SaslServerFactory instances from
   the registered security providers for the `SaslServerFactory` service
   and the specified mechanism. It then invokes
   createSaslServer() on each factory instance on the list
   until one produces a non-null SaslServer instance. It returns
   the non-null SaslServer instance, or null if the search fails
   to produce a non-null SaslServer instance.

   A security provider for SaslServerFactory registers with the
   JCA Security Provider Framework keys of the form
   SaslServerFactory.mechanism_name

   and values that are class names of implementations of
   javax.security.sasl.SaslServerFactory.

   For example, a provider that contains a factory class,
   com.wiz.sasl.digest.ServerFactory, that supports the
   `DIGEST-MD5` mechanism would register the following entry with the JCA:
   SaslServerFactory.DIGEST-MD5  com.wiz.sasl.digest.ServerFactory

   See the
   `Java Cryptography Architecture API Specification & Reference`
   for information about how to install and configure security
   service providers.

  mechanism - The non-null mechanism name. It must be an IANA-registered name of a SASL mechanism. (e.g. `GSSAPI`, `CRAM-MD5`). - `java.lang.String`
  protocol - The non-null string name of the protocol for which the authentication is being performed (e.g., `ldap`). - `java.lang.String`
  server-name - The fully qualified host name of the server, or null if the server is not bound to any specific host name. If the mechanism does not allow an unbound server, a SaslException will be thrown. - `java.lang.String`
  props - The possibly null set of properties used to select the SASL mechanism and to configure the authentication exchange of the selected mechanism. For example, if props contains the Sasl.POLICY_NOPLAINTEXT property with the value `true`, then the selected SASL mechanism must not be susceptible to simple plain passive attacks. In addition to the standard properties declared in this class, other, possibly mechanism-specific, properties can be included. Properties not relevant to the selected mechanism are ignored, including any map entries with non-String keys. - `java.util.Map<java.lang.String,?>`
  cbh - The possibly null callback handler to used by the SASL mechanisms to get further information from the application/library to complete the authentication. For example, a SASL mechanism might require the authentication ID, password and realm from the caller. The authentication ID is requested by using a NameCallback. The password is requested by using a PasswordCallback. The realm is requested by using a RealmChoiceCallback if there is a list of realms to choose from, and by using a RealmCallback if the realm must be entered. - `javax.security.auth.callback.CallbackHandler`

  returns: A possibly null SaslServer created using the parameters
   supplied. If null, cannot find a SaslServerFactory
   that will produce one. - `javax.security.sasl.SaslServer`

  throws: javax.security.sasl.SaslException - If cannot create a SaslServer because of an error."
  ([mechanism protocol server-name props cbh]
    (Sasl/createSaslServer mechanism protocol server-name props cbh)))

(defn *get-sasl-client-factories
  "Gets an enumeration of known factories for producing SaslClient.
   This method uses the same algorithm for locating factories as
   createSaslClient().

  returns: A non-null enumeration of known factories for producing
   SaslClient. - `java.util.Enumeration<javax.security.sasl.SaslClientFactory>`"
  ([]
    (Sasl/getSaslClientFactories )))

(defn *get-sasl-server-factories
  "Gets an enumeration of known factories for producing SaslServer.
   This method uses the same algorithm for locating factories as
   createSaslServer().

  returns: A non-null enumeration of known factories for producing
   SaslServer. - `java.util.Enumeration<javax.security.sasl.SaslServerFactory>`"
  ([]
    (Sasl/getSaslServerFactories )))

