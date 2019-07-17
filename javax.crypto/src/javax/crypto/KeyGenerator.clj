(ns javax.crypto.KeyGenerator
  "This class provides the functionality of a secret (symmetric) key generator.

  Key generators are constructed using one of the getInstance
  class methods of this class.

  KeyGenerator objects are reusable, i.e., after a key has been
  generated, the same KeyGenerator object can be re-used to generate further
  keys.

  There are two ways to generate a key: in an algorithm-independent
  manner, and in an algorithm-specific manner.
  The only difference between the two is the initialization of the object:


  Algorithm-Independent Initialization
  All key generators share the concepts of a keysize and a
  source of randomness.
  There is an
  init
  method in this KeyGenerator class that takes these two universally
  shared types of arguments. There is also one that takes just a
  keysize argument, and uses the SecureRandom implementation
  of the highest-priority installed provider as the source of randomness
  (or a system-provided source of randomness if none of the installed
  providers supply a SecureRandom implementation), and one that takes just a
  source of randomness.

  Since no other parameters are specified when you call the above
  algorithm-independent init methods, it is up to the
  provider what to do about the algorithm-specific parameters (if any) to be
  associated with each of the keys.

  Algorithm-Specific Initialization
  For situations where a set of algorithm-specific parameters already
  exists, there are two
  init
  methods that have an AlgorithmParameterSpec
  argument. One also has a SecureRandom argument, while the
  other uses the SecureRandom implementation
  of the highest-priority installed provider as the source of randomness
  (or a system-provided source of randomness if none of the installed
  providers supply a SecureRandom implementation).


  In case the client does not explicitly initialize the KeyGenerator
  (via a call to an init method), each provider must
  supply (and document) a default initialization.

   Every implementation of the Java platform is required to support the
  following standard KeyGenerator algorithms with the keysizes in
  parentheses:

  AES (128)
  DES (56)
  DESede (168)
  HmacSHA1
  HmacSHA256

  These algorithms are described in the
  KeyGenerator section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto KeyGenerator]))

(defn *get-instance
  "Returns a KeyGenerator object that generates secret keys
   for the specified algorithm.

    A new KeyGenerator object encapsulating the
   KeyGeneratorSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the standard name of the requested key algorithm. See the KeyGenerator section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new KeyGenerator object. - `javax.crypto.KeyGenerator`

  throws: java.lang.NullPointerException - if the specified algorithm is null."
  (^javax.crypto.KeyGenerator [^java.lang.String algorithm ^java.lang.String provider]
    (KeyGenerator/getInstance algorithm provider))
  (^javax.crypto.KeyGenerator [^java.lang.String algorithm]
    (KeyGenerator/getInstance algorithm)))

(defn get-algorithm
  "Returns the algorithm name of this KeyGenerator object.

   This is the same name that was specified in one of the
   getInstance calls that created this
   KeyGenerator object.

  returns: the algorithm name of this KeyGenerator object. - `java.lang.String`"
  (^java.lang.String [^javax.crypto.KeyGenerator this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this KeyGenerator object.

  returns: the provider of this KeyGenerator object - `java.security.Provider`"
  (^java.security.Provider [^javax.crypto.KeyGenerator this]
    (-> this (.getProvider))))

(defn init
  "Initializes this key generator with the specified parameter
   set and a user-provided source of randomness.

  params - the key generation parameters - `java.security.spec.AlgorithmParameterSpec`
  random - the source of randomness for this key generator - `java.security.SecureRandom`

  throws: java.security.InvalidAlgorithmParameterException - if params is inappropriate for this key generator"
  ([^javax.crypto.KeyGenerator this ^java.security.spec.AlgorithmParameterSpec params ^java.security.SecureRandom random]
    (-> this (.init params random)))
  ([^javax.crypto.KeyGenerator this ^java.security.SecureRandom random]
    (-> this (.init random))))

(defn generate-key
  "Generates a secret key.

  returns: the new key - `javax.crypto.SecretKey`"
  (^javax.crypto.SecretKey [^javax.crypto.KeyGenerator this]
    (-> this (.generateKey))))

