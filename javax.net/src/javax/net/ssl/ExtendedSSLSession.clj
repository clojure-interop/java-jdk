(ns javax.net.ssl.ExtendedSSLSession
  "Extends the SSLSession interface to support additional
  session attributes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl ExtendedSSLSession]))

(defn ->extended-ssl-session
  "Constructor."
  (^ExtendedSSLSession []
    (new ExtendedSSLSession )))

(defn get-local-supported-signature-algorithms
  "Obtains an array of supported signature algorithms that the local side
   is willing to use.

   Note: this method is used to indicate to the peer which signature
   algorithms may be used for digital signatures in TLS 1.2. It is
   not meaningful for TLS versions prior to 1.2.

   The signature algorithm name must be a standard Java Security
   name (such as \"SHA1withRSA\", \"SHA256withECDSA\", and so on).
   See Appendix A in the
   Java Cryptography Architecture API Specification & Reference
   for information about standard algorithm names.

   Note: the local supported signature algorithms should conform to
   the algorithm constraints specified by
   getAlgorithmConstraints()
   method in SSLParameters.

  returns: An array of supported signature algorithms, in descending
       order of preference.  The return value is an empty array if
       no signature algorithm is supported. - `java.lang.String[]`"
  ([^ExtendedSSLSession this]
    (-> this (.getLocalSupportedSignatureAlgorithms))))

(defn get-peer-supported-signature-algorithms
  "Obtains an array of supported signature algorithms that the peer is
   able to use.

   Note: this method is used to indicate to the local side which signature
   algorithms may be used for digital signatures in TLS 1.2. It is
   not meaningful for TLS versions prior to 1.2.

   The signature algorithm name must be a standard Java Security
   name (such as \"SHA1withRSA\", \"SHA256withECDSA\", and so on).
   See Appendix A in the
   Java Cryptography Architecture API Specification & Reference
   for information about standard algorithm names.

  returns: An array of supported signature algorithms, in descending
       order of preference.  The return value is an empty array if
       the peer has not sent the supported signature algorithms. - `java.lang.String[]`"
  ([^ExtendedSSLSession this]
    (-> this (.getPeerSupportedSignatureAlgorithms))))

(defn get-requested-server-names
  "Obtains a List containing all SNIServerNames
   of the requested Server Name Indication (SNI) extension.

   In server mode, unless the return List is empty,
   the server should use the requested server names to guide its
   selection of an appropriate authentication certificate, and/or
   other aspects of security policy.

   In client mode, unless the return List is empty,
   the client should use the requested server names to guide its
   endpoint identification of the peer's identity, and/or
   other aspects of security policy.

  returns: a non-null immutable list of SNIServerNames of the
           requested server name indications. The returned list may be
           empty if no server name indications were requested. - `java.util.List<javax.net.ssl.SNIServerName>`

  throws: java.lang.UnsupportedOperationException - if the underlying provider does not implement the operation"
  (^java.util.List [^ExtendedSSLSession this]
    (-> this (.getRequestedServerNames))))

