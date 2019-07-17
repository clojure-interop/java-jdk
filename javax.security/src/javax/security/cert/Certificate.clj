(ns javax.security.cert.Certificate
  "Abstract class for managing a variety of identity certificates.
  An identity certificate is a guarantee by a principal that
  a public key is that of another principal.  (A principal represents
  an entity such as an individual user, a group, or a corporation.)

  This class is an abstraction for certificates that have different
  formats but important common uses.  For example, different types of
  certificates, such as X.509 and PGP, share general certificate
  functionality (like encoding and verifying) and
  some types of information (like a public key).

  X.509, PGP, and SDSI certificates can all be implemented by
  subclassing the Certificate class, even though they contain different
  sets of information, and they store and retrieve the information in
  different ways.

  Note: The classes in the package javax.security.cert
  exist for compatibility with earlier versions of the
  Java Secure Sockets Extension (JSSE). New applications should instead
  use the standard Java SE certificate classes located in
  java.security.cert."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.cert Certificate]))

(defn ->certificate
  "Constructor."
  ([]
    (new Certificate )))

(defn equals
  "Compares this certificate for equality with the specified
   object. If the other object is an
   instanceof Certificate, then
   its encoded form is retrieved and compared with the
   encoded form of this certificate.

  other - the object to test for equality with this certificate. - `java.lang.Object`

  returns: true if the encoded forms of the two certificates
           match, false otherwise. - `boolean`"
  ([this other]
    (-> this (.equals other))))

(defn hash-code
  "Returns a hashcode value for this certificate from its
   encoded form.

  returns: the hashcode value. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-encoded
  "Returns the encoded form of this certificate. It is
   assumed that each certificate type would have only a single
   form of encoding; for example, X.509 certificates would
   be encoded as ASN.1 DER.

  returns: encoded form of this certificate - `byte[]`

  throws: javax.security.cert.CertificateEncodingException - on internal certificate encoding failure"
  ([this]
    (-> this (.getEncoded))))

(defn verify
  "Verifies that this certificate was signed using the
   private key that corresponds to the specified public key.
   This method uses the signature verification engine
   supplied by the specified provider.

  key - the PublicKey used to carry out the verification. - `java.security.PublicKey`
  sig-provider - the name of the signature provider. - `java.lang.String`

  throws: java.security.NoSuchAlgorithmException - on unsupported signature algorithms."
  ([this key sig-provider]
    (-> this (.verify key sig-provider)))
  ([this key]
    (-> this (.verify key))))

(defn to-string
  "Returns a string representation of this certificate.

  returns: a string representation of this certificate. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn get-public-key
  "Gets the public key from this certificate.

  returns: the public key. - `java.security.PublicKey`"
  ([this]
    (-> this (.getPublicKey))))

