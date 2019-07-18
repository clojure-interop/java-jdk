(ns jdk.security.spec.X509EncodedKeySpec
  "This class represents the ASN.1 encoding of a public key,
  encoded according to the ASN.1 type SubjectPublicKeyInfo.
  The SubjectPublicKeyInfo syntax is defined in the X.509
  standard as follows:



  SubjectPublicKeyInfo ::= SEQUENCE {
    algorithm AlgorithmIdentifier,
    subjectPublicKey BIT STRING }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec X509EncodedKeySpec]))

(defn ->x-509-encoded-key-spec
  "Constructor.

  Creates a new X509EncodedKeySpec with the given encoded key.

  encoded-key - the key, which is assumed to be encoded according to the X.509 standard. The contents of the array are copied to protect against subsequent modification. - `byte[]`

  throws: java.lang.NullPointerException - if encodedKey is null."
  (^X509EncodedKeySpec [encoded-key]
    (new X509EncodedKeySpec encoded-key)))

(defn get-encoded
  "Returns the key bytes, encoded according to the X.509 standard.

  returns: the X.509 encoding of the key. Returns a new array
   each time this method is called. - `byte[]`"
  ([^X509EncodedKeySpec this]
    (-> this (.getEncoded))))

(defn get-format
  "Returns the name of the encoding format associated with this
   key specification.

  returns: the string `X.509`. - `java.lang.String`"
  (^java.lang.String [^X509EncodedKeySpec this]
    (-> this (.getFormat))))

