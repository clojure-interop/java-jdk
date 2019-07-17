(ns jdk.security.spec.PKCS8EncodedKeySpec
  "This class represents the ASN.1 encoding of a private key,
  encoded according to the ASN.1 type PrivateKeyInfo.
  The PrivateKeyInfo syntax is defined in the PKCS#8 standard
  as follows:



  PrivateKeyInfo ::= SEQUENCE {
    version Version,
    privateKeyAlgorithm PrivateKeyAlgorithmIdentifier,
    privateKey PrivateKey,
    attributes [0] IMPLICIT Attributes OPTIONAL }

  Version ::= INTEGER

  PrivateKeyAlgorithmIdentifier ::= AlgorithmIdentifier

  PrivateKey ::= OCTET STRING

  Attributes ::= SET OF Attribute"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec PKCS8EncodedKeySpec]))

(defn ->pkcs-8-encoded-key-spec
  "Constructor.

  Creates a new PKCS8EncodedKeySpec with the given encoded key.

  encoded-key - the key, which is assumed to be encoded according to the PKCS #8 standard. The contents of the array are copied to protect against subsequent modification. - `byte[]`

  throws: java.lang.NullPointerException - if encodedKey is null."
  ([encoded-key]
    (new PKCS8EncodedKeySpec encoded-key)))

(defn get-encoded
  "Returns the key bytes, encoded according to the PKCS #8 standard.

  returns: the PKCS #8 encoding of the key. Returns a new array
   each time this method is called. - `byte[]`"
  ([^java.security.spec.PKCS8EncodedKeySpec this]
    (-> this (.getEncoded))))

(defn get-format
  "Returns the name of the encoding format associated with this
   key specification.

  returns: the string `PKCS#8`. - `java.lang.String`"
  ([^java.security.spec.PKCS8EncodedKeySpec this]
    (-> this (.getFormat))))

