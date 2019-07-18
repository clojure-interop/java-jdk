(ns javax.crypto.EncryptedPrivateKeyInfo
  "This class implements the EncryptedPrivateKeyInfo type
  as defined in PKCS #8.
  Its ASN.1 definition is as follows:



  EncryptedPrivateKeyInfo ::=  SEQUENCE {
      encryptionAlgorithm   AlgorithmIdentifier,
      encryptedData   OCTET STRING }

  AlgorithmIdentifier  ::=  SEQUENCE  {
      algorithm              OBJECT IDENTIFIER,
      parameters             ANY DEFINED BY algorithm OPTIONAL  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto EncryptedPrivateKeyInfo]))

(defn ->encrypted-private-key-info
  "Constructor.

  Constructs an EncryptedPrivateKeyInfo from the
   encryption algorithm name and the encrypted data.

   Note: This constructor will use null as the value of the
   algorithm parameters. If the encryption algorithm has
   parameters whose value is not null, a different constructor,
   e.g. EncryptedPrivateKeyInfo(AlgorithmParameters, byte[]),
   should be used.

  alg-name - encryption algorithm name. See Appendix A in the Java Cryptography Architecture Reference Guide for information about standard Cipher algorithm names. - `java.lang.String`
  encrypted-data - encrypted data. The contents of encrypedData are copied to protect against subsequent modification when constructing this object. - `byte[]`

  throws: java.lang.NullPointerException - if algName or encryptedData is null."
  (^EncryptedPrivateKeyInfo [^java.lang.String alg-name encrypted-data]
    (new EncryptedPrivateKeyInfo alg-name encrypted-data))
  (^EncryptedPrivateKeyInfo [encoded]
    (new EncryptedPrivateKeyInfo encoded)))

(defn get-alg-name
  "Returns the encryption algorithm.
   Note: Standard name is returned instead of the specified one
   in the constructor when such mapping is available.
   See Appendix A in the

   Java Cryptography Architecture Reference Guide
   for information about standard Cipher algorithm names.

  returns: the encryption algorithm name. - `java.lang.String`"
  (^java.lang.String [^EncryptedPrivateKeyInfo this]
    (-> this (.getAlgName))))

(defn get-alg-parameters
  "Returns the algorithm parameters used by the encryption algorithm.

  returns: the algorithm parameters. - `java.security.AlgorithmParameters`"
  (^java.security.AlgorithmParameters [^EncryptedPrivateKeyInfo this]
    (-> this (.getAlgParameters))))

(defn get-encrypted-data
  "Returns the encrypted data.

  returns: the encrypted data. Returns a new array
   each time this method is called. - `byte[]`"
  ([^EncryptedPrivateKeyInfo this]
    (-> this (.getEncryptedData))))

(defn get-key-spec
  "Extract the enclosed PKCS8EncodedKeySpec object from the
   encrypted data and return it.

  decrypt-key - key used for decrypting the encrypted data. - `java.security.Key`
  provider-name - the name of provider whose Cipher implementation will be used. - `java.lang.String`

  returns: the PKCS8EncodedKeySpec object. - `java.security.spec.PKCS8EncodedKeySpec`

  throws: java.lang.NullPointerException - if decryptKey or providerName is null."
  (^java.security.spec.PKCS8EncodedKeySpec [^EncryptedPrivateKeyInfo this ^java.security.Key decrypt-key ^java.lang.String provider-name]
    (-> this (.getKeySpec decrypt-key provider-name)))
  (^java.security.spec.PKCS8EncodedKeySpec [^EncryptedPrivateKeyInfo this ^javax.crypto.Cipher cipher]
    (-> this (.getKeySpec cipher))))

(defn get-encoded
  "Returns the ASN.1 encoding of this object.

  returns: the ASN.1 encoding. Returns a new array
   each time this method is called. - `byte[]`

  throws: java.io.IOException - if error occurs when constructing its ASN.1 encoding."
  ([^EncryptedPrivateKeyInfo this]
    (-> this (.getEncoded))))

