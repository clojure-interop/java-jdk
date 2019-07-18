(ns javax.crypto.SecretKeyFactory
  "This class represents a factory for secret keys.

   Key factories are used to convert keys (opaque
  cryptographic keys of type Key) into key specifications
  (transparent representations of the underlying key material), and vice
  versa.
  Secret key factories operate only on secret (symmetric) keys.

   Key factories are bi-directional, i.e., they allow to build an opaque
  key object from a given key specification (key material), or to retrieve
  the underlying key material of a key object in a suitable format.

   Application developers should refer to their provider's documentation
  to find out which key specifications are supported by the
  generateSecret and
  getKeySpec
  methods.
  For example, the DES secret-key factory supplied by the `SunJCE` provider
  supports DESKeySpec as a transparent representation of DES
  keys, and that provider's secret-key factory for Triple DES keys supports
  DESedeKeySpec as a transparent representation of Triple DES
  keys.

   Every implementation of the Java platform is required to support the
  following standard SecretKeyFactory algorithms:

  DES
  DESede

  These algorithms are described in the
  SecretKeyFactory section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto SecretKeyFactory]))

(defn *get-instance
  "Returns a SecretKeyFactory object that converts
   secret keys of the specified algorithm.

    A new SecretKeyFactory object encapsulating the
   SecretKeyFactorySpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the standard name of the requested secret-key algorithm. See the SecretKeyFactory section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new SecretKeyFactory object. - `javax.crypto.SecretKeyFactory`

  throws: java.security.NoSuchAlgorithmException - if a SecretKeyFactorySpi implementation for the specified algorithm is not available from the specified provider."
  (^javax.crypto.SecretKeyFactory [^java.lang.String algorithm ^java.lang.String provider]
    (SecretKeyFactory/getInstance algorithm provider))
  (^javax.crypto.SecretKeyFactory [^java.lang.String algorithm]
    (SecretKeyFactory/getInstance algorithm)))

(defn get-provider
  "Returns the provider of this SecretKeyFactory object.

  returns: the provider of this SecretKeyFactory object - `java.security.Provider`"
  (^java.security.Provider [^SecretKeyFactory this]
    (-> this (.getProvider))))

(defn get-algorithm
  "Returns the algorithm name of this SecretKeyFactory object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   SecretKeyFactory object.

  returns: the algorithm name of this SecretKeyFactory
   object. - `java.lang.String`"
  (^java.lang.String [^SecretKeyFactory this]
    (-> this (.getAlgorithm))))

(defn generate-secret
  "Generates a SecretKey object from the provided key
   specification (key material).

  key-spec - the specification (key material) of the secret key - `java.security.spec.KeySpec`

  returns: the secret key - `javax.crypto.SecretKey`

  throws: java.security.spec.InvalidKeySpecException - if the given key specification is inappropriate for this secret-key factory to produce a secret key."
  (^javax.crypto.SecretKey [^SecretKeyFactory this ^java.security.spec.KeySpec key-spec]
    (-> this (.generateSecret key-spec))))

(defn get-key-spec
  "Returns a specification (key material) of the given key object
   in the requested format.

  key - the key - `javax.crypto.SecretKey`
  key-spec - the requested format in which the key material shall be returned - `java.lang.Class`

  returns: the underlying key specification (key material) in the
   requested format - `java.security.spec.KeySpec`

  throws: java.security.spec.InvalidKeySpecException - if the requested key specification is inappropriate for the given key (e.g., the algorithms associated with key and keySpec do not match, or key references a key on a cryptographic hardware device whereas keySpec is the specification of a software-based key), or the given key cannot be dealt with (e.g., the given key has an algorithm or format not supported by this secret-key factory)."
  (^java.security.spec.KeySpec [^SecretKeyFactory this ^javax.crypto.SecretKey key ^java.lang.Class key-spec]
    (-> this (.getKeySpec key key-spec))))

(defn translate-key
  "Translates a key object, whose provider may be unknown or potentially
   untrusted, into a corresponding key object of this secret-key factory.

  key - the key whose provider is unknown or untrusted - `javax.crypto.SecretKey`

  returns: the translated key - `javax.crypto.SecretKey`

  throws: java.security.InvalidKeyException - if the given key cannot be processed by this secret-key factory."
  (^javax.crypto.SecretKey [^SecretKeyFactory this ^javax.crypto.SecretKey key]
    (-> this (.translateKey key))))

