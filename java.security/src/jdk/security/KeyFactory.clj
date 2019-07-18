(ns jdk.security.KeyFactory
  "Key factories are used to convert keys (opaque
  cryptographic keys of type Key) into key specifications
  (transparent representations of the underlying key material), and vice
  versa.

   Key factories are bi-directional. That is, they allow you to build an
  opaque key object from a given key specification (key material), or to
  retrieve the underlying key material of a key object in a suitable format.

   Multiple compatible key specifications may exist for the same key.
  For example, a DSA public key may be specified using
  DSAPublicKeySpec or
  X509EncodedKeySpec. A key factory can be used to translate
  between compatible key specifications.

   The following is an example of how to use a key factory in order to
  instantiate a DSA public key from its encoding.
  Assume Alice has received a digital signature from Bob.
  Bob also sent her his public key (in encoded format) to verify
  his signature. Alice then performs the following actions:



  X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(bobEncodedPubKey);
  KeyFactory keyFactory = KeyFactory.getInstance(`DSA`);
  PublicKey bobPubKey = keyFactory.generatePublic(bobPubKeySpec);
  Signature sig = Signature.getInstance(`DSA`);
  sig.initVerify(bobPubKey);
  sig.update(data);
  sig.verify(signature);

   Every implementation of the Java platform is required to support the
  following standard KeyFactory algorithms:

  DiffieHellman
  DSA
  RSA

  These algorithms are described in the
  KeyFactory section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyFactory]))

(defn *get-instance
  "Returns a KeyFactory object that converts
   public/private keys of the specified algorithm.

    A new KeyFactory object encapsulating the
   KeyFactorySpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the name of the requested key algorithm. See the KeyFactory section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new KeyFactory object. - `java.security.KeyFactory`

  throws: java.security.NoSuchAlgorithmException - if a KeyFactorySpi implementation for the specified algorithm is not available from the specified provider."
  (^java.security.KeyFactory [^java.lang.String algorithm ^java.lang.String provider]
    (KeyFactory/getInstance algorithm provider))
  (^java.security.KeyFactory [^java.lang.String algorithm]
    (KeyFactory/getInstance algorithm)))

(defn get-provider
  "Returns the provider of this key factory object.

  returns: the provider of this key factory object - `java.security.Provider`"
  (^java.security.Provider [^KeyFactory this]
    (-> this (.getProvider))))

(defn get-algorithm
  "Gets the name of the algorithm
   associated with this KeyFactory.

  returns: the name of the algorithm associated with this
   KeyFactory - `java.lang.String`"
  (^java.lang.String [^KeyFactory this]
    (-> this (.getAlgorithm))))

(defn generate-public
  "Generates a public key object from the provided key specification
   (key material).

  key-spec - the specification (key material) of the public key. - `java.security.spec.KeySpec`

  returns: the public key. - `java.security.PublicKey`

  throws: java.security.spec.InvalidKeySpecException - if the given key specification is inappropriate for this key factory to produce a public key."
  (^java.security.PublicKey [^KeyFactory this ^java.security.spec.KeySpec key-spec]
    (-> this (.generatePublic key-spec))))

(defn generate-private
  "Generates a private key object from the provided key specification
   (key material).

  key-spec - the specification (key material) of the private key. - `java.security.spec.KeySpec`

  returns: the private key. - `java.security.PrivateKey`

  throws: java.security.spec.InvalidKeySpecException - if the given key specification is inappropriate for this key factory to produce a private key."
  (^java.security.PrivateKey [^KeyFactory this ^java.security.spec.KeySpec key-spec]
    (-> this (.generatePrivate key-spec))))

(defn get-key-spec
  "Returns a specification (key material) of the given key object.
   keySpec identifies the specification class in which
   the key material should be returned. It could, for example, be
   DSAPublicKeySpec.class, to indicate that the
   key material should be returned in an instance of the
   DSAPublicKeySpec class.

  key - the key. - `java.security.Key`
  key-spec - the specification class in which the key material should be returned. - `java.lang.Class`

  returns: the underlying key specification (key material) in an instance
   of the requested specification class. - `<T extends java.security.spec.KeySpec> T`

  throws: java.security.spec.InvalidKeySpecException - if the requested key specification is inappropriate for the given key, or the given key cannot be processed (e.g., the given key has an unrecognized algorithm or format)."
  ([^KeyFactory this ^java.security.Key key ^java.lang.Class key-spec]
    (-> this (.getKeySpec key key-spec))))

(defn translate-key
  "Translates a key object, whose provider may be unknown or potentially
   untrusted, into a corresponding key object of this key factory.

  key - the key whose provider is unknown or untrusted. - `java.security.Key`

  returns: the translated key. - `java.security.Key`

  throws: java.security.InvalidKeyException - if the given key cannot be processed by this key factory."
  (^java.security.Key [^KeyFactory this ^java.security.Key key]
    (-> this (.translateKey key))))

