(ns jdk.net.SecureCacheResponse
  "Represents a cache response originally retrieved through secure
  means, such as TLS."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SecureCacheResponse]))

(defn ->secure-cache-response
  "Constructor."
  (^SecureCacheResponse []
    (new SecureCacheResponse )))

(defn get-cipher-suite
  "Returns the cipher suite in use on the original connection that
   retrieved the network resource.

  returns: a string representing the cipher suite - `java.lang.String`"
  (^java.lang.String [^SecureCacheResponse this]
    (-> this (.getCipherSuite))))

(defn get-local-certificate-chain
  "Returns the certificate chain that were sent to the server during
   handshaking of the original connection that retrieved the
   network resource.  Note: This method is useful only
   when using certificate-based cipher suites.

  returns: an immutable List of Certificate representing the
             certificate chain that was sent to the server. If no
             certificate chain was sent, null will be returned. - `java.util.List<java.security.cert.Certificate>`"
  (^java.util.List [^SecureCacheResponse this]
    (-> this (.getLocalCertificateChain))))

(defn get-server-certificate-chain
  "Returns the server's certificate chain, which was established as
   part of defining the session in the original connection that
   retrieved the network resource, from cache.  Note: This method
   can be used only when using certificate-based cipher suites;
   using it with non-certificate-based cipher suites, such as
   Kerberos, will throw an SSLPeerUnverifiedException.

  returns: an immutable List of Certificate representing the server's
           certificate chain. - `java.util.List<java.security.cert.Certificate>`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer is not verified."
  (^java.util.List [^SecureCacheResponse this]
    (-> this (.getServerCertificateChain))))

(defn get-peer-principal
  "Returns the server's principal which was established as part of
   defining the session during the original connection that
   retrieved the network resource.

  returns: the server's principal. Returns an X500Principal of the
   end-entity certiticate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. - `java.security.Principal`

  throws: javax.net.ssl.SSLPeerUnverifiedException - if the peer was not verified."
  (^java.security.Principal [^SecureCacheResponse this]
    (-> this (.getPeerPrincipal))))

(defn get-local-principal
  "Returns the principal that was sent to the server during
   handshaking in the original connection that retrieved the
   network resource.

  returns: the principal sent to the server. Returns an X500Principal
   of the end-entity certificate for X509-based cipher suites, and
   KerberosPrincipal for Kerberos cipher suites. If no principal was
   sent, then null is returned. - `java.security.Principal`"
  (^java.security.Principal [^SecureCacheResponse this]
    (-> this (.getLocalPrincipal))))

