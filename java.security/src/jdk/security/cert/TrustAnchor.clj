(ns jdk.security.cert.TrustAnchor
  "A trust anchor or most-trusted Certification Authority (CA).

  This class represents a `most-trusted CA`, which is used as a trust anchor
  for validating X.509 certification paths. A most-trusted CA includes the
  public key of the CA, the CA's name, and any constraints upon the set of
  paths which may be validated using this key. These parameters can be
  specified in the form of a trusted X509Certificate or as
  individual parameters.

  Concurrent Access
  All TrustAnchor objects must be immutable and
  thread-safe. That is, multiple threads may concurrently invoke the
  methods defined in this class on a single TrustAnchor
  object (or more than one) with no ill effects. Requiring
  TrustAnchor objects to be immutable and thread-safe
  allows them to be passed around to various pieces of code without
  worrying about coordinating access. This stipulation applies to all
  public fields and methods of this class and any added or overridden
  by subclasses."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert TrustAnchor]))

(defn ->trust-anchor
  "Constructor.

  Creates an instance of TrustAnchor where the
   most-trusted CA is specified as an X500Principal and public key.
   Name constraints are an optional parameter, and are intended to be used
   as additional constraints when validating an X.509 certification path.

   The name constraints are specified as a byte array. This byte array
   contains the DER encoded form of the name constraints, as they
   would appear in the NameConstraints structure defined in RFC 3280
   and X.509. The ASN.1 notation for this structure is supplied in the
   documentation for
   TrustAnchor(X509Certificate trustedCert, byte[] nameConstraints) .

   Note that the name constraints byte array supplied here is cloned to
   protect against subsequent modifications.

  ca-principal - the name of the most-trusted CA as X500Principal - `javax.security.auth.x500.X500Principal`
  pub-key - the public key of the most-trusted CA - `java.security.PublicKey`
  name-constraints - a byte array containing the ASN.1 DER encoding of a NameConstraints extension to be used for checking name constraints. Only the value of the extension is included, not the OID or criticality flag. Specify null to omit the parameter. - `byte[]`

  throws: java.lang.NullPointerException - if the specified caPrincipal or pubKey parameter is null"
  (^TrustAnchor [^javax.security.auth.x500.X500Principal ca-principal ^java.security.PublicKey pub-key name-constraints]
    (new TrustAnchor ca-principal pub-key name-constraints))
  (^TrustAnchor [^java.security.cert.X509Certificate trusted-cert name-constraints]
    (new TrustAnchor trusted-cert name-constraints)))

(defn get-trusted-cert
  "Returns the most-trusted CA certificate.

  returns: a trusted X509Certificate or null
   if the trust anchor was not specified as a trusted certificate - `java.security.cert.X509Certificate`"
  (^java.security.cert.X509Certificate [^TrustAnchor this]
    (-> this (.getTrustedCert))))

(defn get-ca
  "Returns the name of the most-trusted CA as an X500Principal.

  returns: the X.500 distinguished name of the most-trusted CA, or
   null if the trust anchor was not specified as a trusted
   public key and name or X500Principal pair - `javax.security.auth.x500.X500Principal`"
  (^javax.security.auth.x500.X500Principal [^TrustAnchor this]
    (-> this (.getCA))))

(defn get-ca-name
  "Returns the name of the most-trusted CA in RFC 2253 String
   format.

  returns: the X.500 distinguished name of the most-trusted CA, or
   null if the trust anchor was not specified as a trusted
   public key and name or X500Principal pair - `java.lang.String`"
  (^java.lang.String [^TrustAnchor this]
    (-> this (.getCAName))))

(defn get-ca-public-key
  "Returns the public key of the most-trusted CA.

  returns: the public key of the most-trusted CA, or null
   if the trust anchor was not specified as a trusted public key and name
   or X500Principal pair - `java.security.PublicKey`"
  (^java.security.PublicKey [^TrustAnchor this]
    (-> this (.getCAPublicKey))))

(defn get-name-constraints
  "Returns the name constraints parameter. The specified name constraints
   are associated with this trust anchor and are intended to be used
   as additional constraints when validating an X.509 certification path.

   The name constraints are returned as a byte array. This byte array
   contains the DER encoded form of the name constraints, as they
   would appear in the NameConstraints structure defined in RFC 3280
   and X.509. The ASN.1 notation for this structure is supplied in the
   documentation for
   TrustAnchor(X509Certificate trustedCert, byte[] nameConstraints) .

   Note that the byte array returned is cloned to protect against
   subsequent modifications.

  returns: a byte array containing the ASN.1 DER encoding of
           a NameConstraints extension used for checking name constraints,
           or null if not set. - `byte[]`"
  ([^TrustAnchor this]
    (-> this (.getNameConstraints))))

(defn to-string
  "Returns a formatted string describing the TrustAnchor.

  returns: a formatted string describing the TrustAnchor - `java.lang.String`"
  (^java.lang.String [^TrustAnchor this]
    (-> this (.toString))))

