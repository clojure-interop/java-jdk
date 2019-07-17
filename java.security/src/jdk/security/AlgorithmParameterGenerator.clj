(ns jdk.security.AlgorithmParameterGenerator
  "The AlgorithmParameterGenerator class is used to generate a
  set of
  parameters to be used with a certain algorithm. Parameter generators
  are constructed using the getInstance factory methods
  (static methods that return instances of a given class).

  The object that will generate the parameters can be initialized
  in two different ways: in an algorithm-independent manner, or in an
  algorithm-specific manner:


  The algorithm-independent approach uses the fact that all parameter
  generators share the concept of a `size` and a
  source of randomness. The measure of size is universally shared
  by all algorithm parameters, though it is interpreted differently
  for different algorithms. For example, in the case of parameters for
  the DSA algorithm, `size` corresponds to the size
  of the prime modulus (in bits).
  When using this approach, algorithm-specific parameter generation
  values - if any - default to some standard values, unless they can be
  derived from the specified size.

  The other approach initializes a parameter generator object
  using algorithm-specific semantics, which are represented by a set of
  algorithm-specific parameter generation values. To generate
  Diffie-Hellman system parameters, for example, the parameter generation
  values usually
  consist of the size of the prime modulus and the size of the
  random exponent, both specified in number of bits.


  In case the client does not explicitly initialize the
  AlgorithmParameterGenerator
  (via a call to an init method), each provider must supply (and
  document) a default initialization. For example, the Sun provider uses a
  default modulus prime size of 1024 bits for the generation of DSA
  parameters.

   Every implementation of the Java platform is required to support the
  following standard AlgorithmParameterGenerator algorithms and
  keysizes in parentheses:

  DiffieHellman (1024)
  DSA (1024)

  These algorithms are described in the
  AlgorithmParameterGenerator section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AlgorithmParameterGenerator]))

(defn *get-instance
  "Returns an AlgorithmParameterGenerator object for generating
   a set of parameters to be used with the specified algorithm.

    A new AlgorithmParameterGenerator object encapsulating the
   AlgorithmParameterGeneratorSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  algorithm - the name of the algorithm this parameter generator is associated with. See the AlgorithmParameterGenerator section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the string name of the Provider. - `java.lang.String`

  returns: the new AlgorithmParameterGenerator object. - `java.security.AlgorithmParameterGenerator`

  throws: java.security.NoSuchAlgorithmException - if an AlgorithmParameterGeneratorSpi implementation for the specified algorithm is not available from the specified provider."
  ([algorithm provider]
    (AlgorithmParameterGenerator/getInstance algorithm provider))
  ([algorithm]
    (AlgorithmParameterGenerator/getInstance algorithm)))

(defn get-algorithm
  "Returns the standard name of the algorithm this parameter
   generator is associated with.

  returns: the string name of the algorithm. - `java.lang.String`"
  ([this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this algorithm parameter generator object.

  returns: the provider of this algorithm parameter generator object - `java.security.Provider`"
  ([this]
    (-> this (.getProvider))))

(defn init
  "Initializes this parameter generator for a certain size and source
   of randomness.

  size - the size (number of bits). - `int`
  random - the source of randomness. - `java.security.SecureRandom`"
  ([this size random]
    (-> this (.init size random)))
  ([this size]
    (-> this (.init size))))

(defn generate-parameters
  "Generates the parameters.

  returns: the new AlgorithmParameters object. - `java.security.AlgorithmParameters`"
  ([this]
    (-> this (.generateParameters))))

