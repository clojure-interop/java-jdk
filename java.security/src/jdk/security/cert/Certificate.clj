(ns jdk.security.cert.Certificate
  "Abstract class for managing a variety of identity certificates.
  An identity certificate is a binding of a principal to a public key which
  is vouched for by another principal.  (A principal represents
  an entity such as an individual user, a group, or a corporation.)

  This class is an abstraction for certificates that have different
  formats but important common uses.  For example, different types of
  certificates, such as X.509 and PGP, share general certificate
  functionality (like encoding and verifying) and
  some types of information (like a public key).

  X.509, PGP, and SDSI certificates can all be implemented by
  subclassing the Certificate class, even though they contain different
  sets of information, and they store and retrieve the information in
  different ways."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert Certificate]))

(defn get-type
  "Returns the type of this certificate.

  returns: the type of this certificate. - `java.lang.String`"
  ([^java.security.cert.Certificate this]
    (-> this (.getType))))

(defn equals
  "Compares this certificate for equality with the specified
   object. If the other object is an
   instanceof Certificate, then
   its encoded form is retrieved and compared with the
   encoded form of this certificate.

  other - the object to test for equality with this certificate. - `java.lang.Object`

  returns: true iff the encoded forms of the two certificates
   match, false otherwise. - `boolean`"
  ([^java.security.cert.Certificate this ^java.lang.Object other]
    (-> this (.equals other))))

(defn hash-code
  "Returns a hashcode value for this certificate from its
   encoded form.

  returns: the hashcode value. - `int`"
  ([^java.security.cert.Certificate this]
    (-> this (.hashCode))))

(defn get-encoded
  "Returns the encoded form of this certificate. It is
   assumed that each certificate type would have only a single
   form of encoding; for example, X.509 certificates would
   be encoded as ASN.1 DER.

  returns: the encoded form of this certificate - `byte[]`

  throws: java.security.cert.CertificateEncodingException - if an encoding error occurs."
  ([^java.security.cert.Certificate this]
    (-> this (.getEncoded))))

(defn verify
  "Verifies that this certificate was signed using the
   private key that corresponds to the specified public key.
   This method uses the signature verification engine
   supplied by the specified provider.

  key - the PublicKey used to carry out the verification. - `java.security.PublicKey`
  sig-provider - the name of the signature provider. - `java.lang.String`

  throws: java.security.NoSuchAlgorithmException - on unsupported signature algorithms."
  ([^java.security.cert.Certificate this ^java.security.PublicKey key ^java.lang.String sig-provider]
    (-> this (.verify key sig-provider)))
  ([^java.security.cert.Certificate this ^java.security.PublicKey key]
    (-> this (.verify key))))

(defn to-string
  "Returns a string representation of this certificate.

  returns: a string representation of this certificate. - `java.lang.String`"
  ([^java.security.cert.Certificate this]
    (-> this (.toString))))

(defn get-public-key
  "Gets the public key from this certificate.

  returns: the public key. - `java.security.PublicKey`"
  ([^java.security.cert.Certificate this]
    (-> this (.getPublicKey))))

