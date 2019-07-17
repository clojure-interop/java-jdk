(ns javax.naming.ldap.StartTlsResponse
  "This class implements the LDAPv3 Extended Response for StartTLS as
  defined in
  Lightweight Directory
  Access Protocol (v3): Extension for Transport Layer Security

  The object identifier for StartTLS is 1.3.6.1.4.1.1466.20037
  and no extended response value is defined.


  The Start TLS extended request and response are used to establish
  a TLS connection over the existing LDAP connection associated with
  the JNDI context on which extendedOperation() is invoked.
  Typically, a JNDI program uses the StartTLS extended request and response
  classes as follows.


  import javax.naming.ldap.*;

  // Open an LDAP association
  LdapContext ctx = new InitialLdapContext();

  // Perform a StartTLS extended operation
  StartTlsResponse tls =
      (StartTlsResponse) ctx.extendedOperation(new StartTlsRequest());

  // Open a TLS connection (over the existing LDAP association) and get details
  // of the negotiated TLS session: cipher suite, peer certificate, ...
  SSLSession session = tls.negotiate();

  // ... use ctx to perform protected LDAP operations

  // Close the TLS connection (revert back to the underlying LDAP association)
  tls.close();

  // ... use ctx to perform unprotected LDAP operations

  // Close the LDAP association
  ctx.close;"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap StartTlsResponse]))

(def *-oid
  "Static Constant.

  The StartTLS extended response's assigned object identifier
   is 1.3.6.1.4.1.1466.20037.

  type: java.lang.String"
  StartTlsResponse/OID)

(defn get-id
  "Retrieves the StartTLS response's object identifier string.

  returns: The object identifier string, `1.3.6.1.4.1.1466.20037`. - `java.lang.String`"
  ([^javax.naming.ldap.StartTlsResponse this]
    (-> this (.getID))))

(defn get-encoded-value
  "Retrieves the StartTLS response's ASN.1 BER encoded value.
   Since the response has no defined value, null is always
   returned.

  returns: The null value. - `byte[]`"
  ([^javax.naming.ldap.StartTlsResponse this]
    (-> this (.getEncodedValue))))

(defn set-enabled-cipher-suites
  "Overrides the default list of cipher suites enabled for use on the
   TLS connection. The cipher suites must have already been listed by
   SSLSocketFactory.getSupportedCipherSuites() as being supported.
   Even if a suite has been enabled, it still might not be used because
   the peer does not support it, or because the requisite certificates
   (and private keys) are not available.

  suites - The non-null list of names of all the cipher suites to enable. - `java.lang.String[]`"
  ([^javax.naming.ldap.StartTlsResponse this ^java.lang.String[] suites]
    (-> this (.setEnabledCipherSuites suites))))

(defn set-hostname-verifier
  "Sets the hostname verifier used by negotiate()
   after the TLS handshake has completed and the default hostname
   verification has failed.
   setHostnameVerifier() must be called before
   negotiate() is invoked for it to have effect.
   If called after
   negotiate(), this method does not do anything.

  verifier - The non-null hostname verifier callback. - `javax.net.ssl.HostnameVerifier`"
  ([^javax.naming.ldap.StartTlsResponse this ^javax.net.ssl.HostnameVerifier verifier]
    (-> this (.setHostnameVerifier verifier))))

(defn negotiate
  "Negotiates a TLS session using an SSL socket factory.

   Creates an SSL socket using the supplied SSL socket factory and
   attaches it to the existing connection. Performs the TLS handshake
   and returns the negotiated session information.

   If cipher suites have been set via setEnabledCipherSuites
   then they are enabled before the TLS handshake begins.

   Hostname verification is performed after the TLS handshake completes.
   The default hostname verification performs a match of the server's
   hostname against the hostname information found in the server's certificate.
   If this verification fails and no callback has been set via
   setHostnameVerifier then the negotiation fails.
   If this verification fails and a callback has been set via
   setHostnameVerifier, then the callback is used to determine whether
   the negotiation succeeds.

   If an error occurs then the SSL socket is closed and an IOException
   is thrown. The underlying connection remains intact.

  factory - The possibly null SSL socket factory to use. If null, the default SSL socket factory is used. - `javax.net.ssl.SSLSocketFactory`

  returns: The negotiated SSL session - `javax.net.ssl.SSLSession`

  throws: java.io.IOException - If an IO error was encountered while establishing the TLS session."
  ([^javax.naming.ldap.StartTlsResponse this ^javax.net.ssl.SSLSocketFactory factory]
    (-> this (.negotiate factory)))
  ([^javax.naming.ldap.StartTlsResponse this]
    (-> this (.negotiate))))

(defn close
  "Closes the TLS connection gracefully and reverts back to the underlying
   connection.

  throws: java.io.IOException - If an IO error was encountered while closing the TLS connection"
  ([^javax.naming.ldap.StartTlsResponse this]
    (-> this (.close))))

