(ns jdk.security.CodeSigner
  "This class encapsulates information about a code signer.
  It is immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security CodeSigner]))

(defn ->code-signer
  "Constructor.

  Constructs a CodeSigner object.

  signer-cert-path - The signer's certificate path. It must not be null. - `java.security.cert.CertPath`
  timestamp - A signature timestamp. If null then no timestamp was generated for the signature. - `java.security.Timestamp`

  throws: java.lang.NullPointerException - if signerCertPath is null."
  ([^java.security.cert.CertPath signer-cert-path ^java.security.Timestamp timestamp]
    (new CodeSigner signer-cert-path timestamp)))

(defn get-signer-cert-path
  "Returns the signer's certificate path.

  returns: A certificate path. - `java.security.cert.CertPath`"
  (^java.security.cert.CertPath [^java.security.CodeSigner this]
    (-> this (.getSignerCertPath))))

(defn get-timestamp
  "Returns the signature timestamp.

  returns: The timestamp or null if none is present. - `java.security.Timestamp`"
  (^java.security.Timestamp [^java.security.CodeSigner this]
    (-> this (.getTimestamp))))

(defn hash-code
  "Returns the hash code value for this code signer.
   The hash code is generated using the signer's certificate path and the
   timestamp, if present.

  returns: a hash code value for this code signer. - `int`"
  (^Integer [^java.security.CodeSigner this]
    (-> this (.hashCode))))

(defn equals
  "Tests for equality between the specified object and this
   code signer. Two code signers are considered equal if their
   signer certificate paths are equal and if their timestamps are equal,
   if present in both.

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if the objects are considered equal, false otherwise. - `boolean`"
  (^Boolean [^java.security.CodeSigner this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a string describing this code signer.

  returns: A string comprising the signer's certificate and a timestamp,
           if present. - `java.lang.String`"
  (^java.lang.String [^java.security.CodeSigner this]
    (-> this (.toString))))

