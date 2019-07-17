(ns jdk.security.AlgorithmParameterGeneratorSpi
  "This class defines the Service Provider Interface (SPI)
  for the AlgorithmParameterGenerator class, which
  is used to generate a set of parameters to be used with a certain algorithm.

   All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a parameter generator for a particular algorithm.

   In case the client does not explicitly initialize the
  AlgorithmParameterGenerator (via a call to an engineInit
  method), each provider must supply (and document) a default initialization.
  For example, the Sun provider uses a default modulus prime size of 1024
  bits for the generation of DSA parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AlgorithmParameterGeneratorSpi]))

(defn ->algorithm-parameter-generator-spi
  "Constructor."
  ([]
    (new AlgorithmParameterGeneratorSpi )))

