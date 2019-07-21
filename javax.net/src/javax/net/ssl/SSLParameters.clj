(ns javax.net.ssl.SSLParameters
  "Encapsulates parameters for an SSL/TLS connection. The parameters
  are the list of ciphersuites to be accepted in an SSL/TLS handshake,
  the list of protocols to be allowed, the endpoint identification
  algorithm during SSL/TLS handshaking, the Server Name Indication (SNI),
  the algorithm constraints and whether SSL/TLS servers should request
  or require client authentication, etc.

  SSLParameters can be created via the constructors in this class.
  Objects can also be obtained using the getSSLParameters()
  methods in
  SSLSocket and
  SSLServerSocket and
  SSLEngine or the
  getDefaultSSLParameters() and
  getSupportedSSLParameters()
  methods in SSLContext.

  SSLParameters can be applied to a connection via the methods
  SSLSocket.setSSLParameters() and
  SSLServerSocket.setSSLParameters()
  and SSLEngine.setSSLParameters()."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLParameters]))

(defn ->ssl-parameters
  "Constructor.

  Constructs SSLParameters from the specified array of ciphersuites
   and protocols.

   Calling this constructor is equivalent to calling the no-args
   constructor followed by
   setCipherSuites(cipherSuites); setProtocols(protocols);.

  cipher-suites - the array of ciphersuites (or null) - `java.lang.String[]`
  protocols - the array of protocols (or null) - `java.lang.String[]`"
  (^SSLParameters [cipher-suites protocols]
    (new SSLParameters cipher-suites protocols))
  (^SSLParameters [cipher-suites]
    (new SSLParameters cipher-suites))
  (^SSLParameters []
    (new SSLParameters )))

(defn get-need-client-auth?
  "Returns whether client authentication should be required.

  returns: whether client authentication should be required. - `boolean`"
  (^Boolean [^SSLParameters this]
    (-> this (.getNeedClientAuth))))

(defn get-use-cipher-suites-order?
  "Returns whether the local cipher suites preference should be honored.

  returns: whether local cipher suites order in #getCipherSuites
           should be honored during SSL/TLS handshaking. - `boolean`"
  (^Boolean [^SSLParameters this]
    (-> this (.getUseCipherSuitesOrder))))

(defn set-use-cipher-suites-order
  "Sets whether the local cipher suites preference should be honored.

  honor-order - whether local cipher suites order in #getCipherSuites should be honored during SSL/TLS handshaking. - `boolean`"
  ([^SSLParameters this ^Boolean honor-order]
    (-> this (.setUseCipherSuitesOrder honor-order))))

(defn set-server-names
  "Sets the desired SNIServerNames of the Server Name
   Indication (SNI) parameter.

   This method is only useful to SSLSockets or SSLEngines
   operating in client mode.

   Note that the serverNames list is cloned
   to protect against subsequent modification.

  server-names - the list of desired SNIServerNames (or null) - `java.util.List`

  throws: java.lang.NullPointerException - if the serverNames contains null element"
  ([^SSLParameters this ^java.util.List server-names]
    (-> this (.setServerNames server-names))))

(defn get-sni-matchers
  "Returns a Collection containing all SNIMatchers of the
   Server Name Indication (SNI) parameter, or null if none has been set.

   This method is only useful to SSLSockets or SSLEngines
   operating in server mode.

   For better interoperability, providers generally will not define
   default matchers so that by default servers will ignore the SNI
   extension and continue the handshake.

  returns: null or an immutable collection of non-null SNIMatchers - `java.util.Collection<javax.net.ssl.SNIMatcher>`"
  (^java.util.Collection [^SSLParameters this]
    (-> this (.getSNIMatchers))))

(defn set-algorithm-constraints
  "Sets the cryptographic algorithm constraints, which will be used
   in addition to any configured by the runtime environment.

   If the constraints parameter is non-null, every
   cryptographic algorithm, key and algorithm parameters used in the
   SSL/TLS handshake must be permitted by the constraints.

  constraints - the algorithm constraints (or null) - `java.security.AlgorithmConstraints`"
  ([^SSLParameters this ^java.security.AlgorithmConstraints constraints]
    (-> this (.setAlgorithmConstraints constraints))))

(defn set-want-client-auth
  "Sets whether client authentication should be requested. Calling
   this method clears the needClientAuth flag.

  want-client-auth - whether client authentication should be requested - `boolean`"
  ([^SSLParameters this ^Boolean want-client-auth]
    (-> this (.setWantClientAuth want-client-auth))))

(defn get-algorithm-constraints
  "Returns the cryptographic algorithm constraints.

  returns: the cryptographic algorithm constraints, or null if the
       constraints have not been set - `java.security.AlgorithmConstraints`"
  (^java.security.AlgorithmConstraints [^SSLParameters this]
    (-> this (.getAlgorithmConstraints))))

(defn set-cipher-suites
  "Sets the array of ciphersuites.

  cipher-suites - the array of ciphersuites (or null) - `java.lang.String[]`"
  ([^SSLParameters this cipher-suites]
    (-> this (.setCipherSuites cipher-suites))))

(defn set-sni-matchers
  "Sets the SNIMatchers of the Server Name Indication (SNI)
   parameter.

   This method is only useful to SSLSockets or SSLEngines
   operating in server mode.

   Note that the matchers collection is cloned to protect
   against subsequent modification.

  matchers - the collection of SNIMatchers (or null) - `java.util.Collection`

  throws: java.lang.NullPointerException - if the matchers contains null element"
  ([^SSLParameters this ^java.util.Collection matchers]
    (-> this (.setSNIMatchers matchers))))

(defn get-server-names
  "Returns a List containing all SNIServerNames of the
   Server Name Indication (SNI) parameter, or null if none has been set.

   This method is only useful to SSLSockets or SSLEngines
   operating in client mode.

   For SSL/TLS connections, the underlying SSL/TLS provider
   may specify a default value for a certain server name type.  In
   client mode, it is recommended that, by default, providers should
   include the server name indication whenever the server can be located
   by a supported server name type.

   It is recommended that providers initialize default Server Name
   Indications when creating SSLSocket/SSLEngines.
   In the following examples, the server name could be represented by an
   instance of SNIHostName which has been initialized with the
   hostname \"www.example.com\" and type
   StandardConstants.SNI_HOST_NAME.



       Socket socket =
           sslSocketFactory.createSocket(\"www.example.com\", 443);
   or


       SSLEngine engine =
           sslContext.createSSLEngine(\"www.example.com\", 443);

  returns: null or an immutable list of non-null SNIServerNames - `java.util.List<javax.net.ssl.SNIServerName>`"
  (^java.util.List [^SSLParameters this]
    (-> this (.getServerNames))))

(defn get-protocols
  "Returns a copy of the array of protocols or null if none
   have been set.

  returns: a copy of the array of protocols or null if none
   have been set. - `java.lang.String[]`"
  ([^SSLParameters this]
    (-> this (.getProtocols))))

(defn get-cipher-suites
  "Returns a copy of the array of ciphersuites or null if none
   have been set.

  returns: a copy of the array of ciphersuites or null if none
   have been set. - `java.lang.String[]`"
  ([^SSLParameters this]
    (-> this (.getCipherSuites))))

(defn get-endpoint-identification-algorithm
  "Gets the endpoint identification algorithm.

  returns: the endpoint identification algorithm, or null if none
   has been set. - `java.lang.String`"
  (^java.lang.String [^SSLParameters this]
    (-> this (.getEndpointIdentificationAlgorithm))))

(defn set-endpoint-identification-algorithm
  "Sets the endpoint identification algorithm.

   If the algorithm parameter is non-null or non-empty, the
   endpoint identification/verification procedures must be handled during
   SSL/TLS handshaking.  This is to prevent man-in-the-middle attacks.

  algorithm - The standard string name of the endpoint identification algorithm (or null). See Appendix A in the Java Cryptography Architecture API Specification & Reference for information about standard algorithm names. - `java.lang.String`"
  ([^SSLParameters this ^java.lang.String algorithm]
    (-> this (.setEndpointIdentificationAlgorithm algorithm))))

(defn set-need-client-auth
  "Sets whether client authentication should be required. Calling
   this method clears the wantClientAuth flag.

  need-client-auth - whether client authentication should be required - `boolean`"
  ([^SSLParameters this ^Boolean need-client-auth]
    (-> this (.setNeedClientAuth need-client-auth))))

(defn get-want-client-auth?
  "Returns whether client authentication should be requested.

  returns: whether client authentication should be requested. - `boolean`"
  (^Boolean [^SSLParameters this]
    (-> this (.getWantClientAuth))))

(defn set-protocols
  "Sets the array of protocols.

  protocols - the array of protocols (or null) - `java.lang.String[]`"
  ([^SSLParameters this protocols]
    (-> this (.setProtocols protocols))))

