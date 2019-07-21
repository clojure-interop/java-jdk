(ns jdk.security.interfaces.DSAKeyPairGenerator
  "An interface to an object capable of generating DSA key pairs.

  The initialize methods may each be called any number
  of times. If no initialize method is called on a
  DSAKeyPairGenerator, the default is to generate 1024-bit keys, using
  precomputed p, q and g parameters and an instance of SecureRandom as
  the random bit source.

  Users wishing to indicate DSA-specific parameters, and to generate a key
  pair suitable for use with the DSA algorithm typically



  Get a key pair generator for the DSA algorithm by calling the
  KeyPairGenerator getInstance method with \"DSA\"
  as its argument.

  Initialize the generator by casting the result to a DSAKeyPairGenerator
  and calling one of the
  initialize methods from this DSAKeyPairGenerator interface.

  Generate a key pair by calling the generateKeyPair
  method from the KeyPairGenerator class.



  Note: it is not always necessary to do do algorithm-specific
  initialization for a DSA key pair generator. That is, it is not always
  necessary to call an initialize method in this interface.
  Algorithm-independent initialization using the initialize method
  in the KeyPairGenerator
  interface is all that is needed when you accept defaults for algorithm-specific
  parameters.

  Note: Some earlier implementations of this interface may not support
  larger sizes of DSA parameters such as 2048 and 3072-bit."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces DSAKeyPairGenerator]))

(defn initialize
  "Initializes the key pair generator for a given modulus length
   (instead of parameters), and an optional SecureRandom bit source.
   If a SecureRandom bit source is needed but not supplied, i.e.
   null, a default SecureRandom instance will be used.

   If genParams is true, this method generates new
   p, q and g parameters. If it is false, the method uses precomputed
   parameters for the modulus length requested. If there are no
   precomputed parameters for that modulus length, an exception will be
   thrown. It is guaranteed that there will always be
   default parameters for modulus lengths of 512 and 1024 bits.

  modlen - the modulus length in bits. Valid values are any multiple of 64 between 512 and 1024, inclusive, 2048, and 3072. - `int`
  gen-params - whether or not to generate new parameters for the modulus length requested. - `boolean`
  random - the random bit source to use to generate key bits; can be null. - `java.security.SecureRandom`

  throws: java.security.InvalidParameterException - if modlen is invalid, or unsupported, or if genParams is false and there are no precomputed parameters for the requested modulus length."
  ([^DSAKeyPairGenerator this ^Integer modlen ^Boolean gen-params ^java.security.SecureRandom random]
    (-> this (.initialize modlen gen-params random)))
  ([^DSAKeyPairGenerator this ^java.security.interfaces.DSAParams params ^java.security.SecureRandom random]
    (-> this (.initialize params random))))

