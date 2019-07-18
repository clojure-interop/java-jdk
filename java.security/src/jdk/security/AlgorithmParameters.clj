(ns jdk.security.AlgorithmParameters
  "This class is used as an opaque representation of cryptographic parameters.

  An AlgorithmParameters object for managing the parameters
  for a particular algorithm can be obtained by
  calling one of the getInstance factory methods
  (static methods that return instances of a given class).

  Once an AlgorithmParameters object is obtained, it must be
  initialized via a call to init, using an appropriate parameter
  specification or parameter encoding.

  A transparent parameter specification is obtained from an
  AlgorithmParameters object via a call to
  getParameterSpec, and a byte encoding of the parameters is
  obtained via a call to getEncoded.

   Every implementation of the Java platform is required to support the
  following standard AlgorithmParameters algorithms:

  AES
  DES
  DESede
  DiffieHellman
  DSA

  These algorithms are described in the
  AlgorithmParameters section of the
  Java Cryptography Architecture Standard Algorithm Name Documentation.
  Consult the release documentation for your implementation to see if any
  other algorithms are supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AlgorithmParameters]))

(defn *get-instance
  "Returns a parameter object for the specified algorithm.

    A new AlgorithmParameters object encapsulating the
   AlgorithmParametersSpi implementation from the specified provider
   is returned.  The specified provider must be registered
   in the security provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

   The returned parameter object must be initialized via a call to
   init, using an appropriate parameter specification or
   parameter encoding.

  algorithm - the name of the algorithm requested. See the AlgorithmParameters section in the Java Cryptography Architecture Standard Algorithm Name Documentation for information about standard algorithm names. - `java.lang.String`
  provider - the name of the provider. - `java.lang.String`

  returns: the new parameter object. - `java.security.AlgorithmParameters`

  throws: java.security.NoSuchAlgorithmException - if an AlgorithmParametersSpi implementation for the specified algorithm is not available from the specified provider."
  (^java.security.AlgorithmParameters [^java.lang.String algorithm ^java.lang.String provider]
    (AlgorithmParameters/getInstance algorithm provider))
  (^java.security.AlgorithmParameters [^java.lang.String algorithm]
    (AlgorithmParameters/getInstance algorithm)))

(defn get-algorithm
  "Returns the name of the algorithm associated with this parameter object.

  returns: the algorithm name. - `java.lang.String`"
  (^java.lang.String [^AlgorithmParameters this]
    (-> this (.getAlgorithm))))

(defn get-provider
  "Returns the provider of this parameter object.

  returns: the provider of this parameter object - `java.security.Provider`"
  (^java.security.Provider [^AlgorithmParameters this]
    (-> this (.getProvider))))

(defn init
  "Imports the parameters from params and decodes them
   according to the specified decoding scheme.
   If format is null, the
   primary decoding format for parameters is used. The primary decoding
   format is ASN.1, if an ASN.1 specification for these parameters
   exists.

  params - the encoded parameters. - `byte[]`
  format - the name of the decoding scheme. - `java.lang.String`

  throws: java.io.IOException - on decoding errors, or if this parameter object has already been initialized."
  ([^AlgorithmParameters this params ^java.lang.String format]
    (-> this (.init params format)))
  ([^AlgorithmParameters this ^java.security.spec.AlgorithmParameterSpec param-spec]
    (-> this (.init param-spec))))

(defn get-parameter-spec
  "Returns a (transparent) specification of this parameter object.
   paramSpec identifies the specification class in which
   the parameters should be returned. It could, for example, be
   DSAParameterSpec.class, to indicate that the
   parameters should be returned in an instance of the
   DSAParameterSpec class.

  param-spec - the specification class in which the parameters should be returned. - `java.lang.Class`

  returns: the parameter specification. - `<T extends java.security.spec.AlgorithmParameterSpec> T`

  throws: java.security.spec.InvalidParameterSpecException - if the requested parameter specification is inappropriate for this parameter object, or if this parameter object has not been initialized."
  ([^AlgorithmParameters this ^java.lang.Class param-spec]
    (-> this (.getParameterSpec param-spec))))

(defn get-encoded
  "Returns the parameters encoded in the specified scheme.
   If format is null, the
   primary encoding format for parameters is used. The primary encoding
   format is ASN.1, if an ASN.1 specification for these parameters
   exists.

  format - the name of the encoding format. - `java.lang.String`

  returns: the parameters encoded using the specified encoding scheme. - `byte[]`

  throws: java.io.IOException - on encoding errors, or if this parameter object has not been initialized."
  ([^AlgorithmParameters this ^java.lang.String format]
    (-> this (.getEncoded format)))
  ([^AlgorithmParameters this]
    (-> this (.getEncoded))))

(defn to-string
  "Returns a formatted string describing the parameters.

  returns: a formatted string describing the parameters, or null if this
   parameter object has not been initialized. - `java.lang.String`"
  (^java.lang.String [^AlgorithmParameters this]
    (-> this (.toString))))

