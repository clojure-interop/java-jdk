(ns jdk.security.KeyPairGeneratorSpi
  " This class defines the Service Provider Interface (SPI)
  for the KeyPairGenerator class, which is used to generate
  pairs of public and private keys.

   All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a key pair generator for a particular algorithm.

   In case the client does not explicitly initialize the KeyPairGenerator
  (via a call to an initialize method), each provider must
  supply (and document) a default initialization.
  For example, the Sun provider uses a default modulus size (keysize)
  of 1024 bits."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyPairGeneratorSpi]))

(defn ->key-pair-generator-spi
  "Constructor."
  ([]
    (new KeyPairGeneratorSpi )))

(defn initialize
  "Initializes the key pair generator for a certain keysize, using
   the default parameter set.

  keysize - the keysize. This is an algorithm-specific metric, such as modulus length, specified in number of bits. - `int`
  random - the source of randomness for this generator. - `java.security.SecureRandom`

  throws: java.security.InvalidParameterException - if the keysize is not supported by this KeyPairGeneratorSpi object."
  ([^java.security.KeyPairGeneratorSpi this ^Integer keysize ^java.security.SecureRandom random]
    (-> this (.initialize keysize random))))

(defn generate-key-pair
  "Generates a key pair. Unless an initialization method is called
   using a KeyPairGenerator interface, algorithm-specific defaults
   will be used. This will generate a new key pair every time it
   is called.

  returns: the newly generated KeyPair - `java.security.KeyPair`"
  (^java.security.KeyPair [^java.security.KeyPairGeneratorSpi this]
    (-> this (.generateKeyPair))))

