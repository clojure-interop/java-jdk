(ns javax.crypto.KeyGeneratorSpi
  "This class defines the Service Provider Interface (SPI)
  for the KeyGenerator class.
  All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a key generator for a particular algorithm."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto KeyGeneratorSpi]))

(defn ->key-generator-spi
  "Constructor."
  (^KeyGeneratorSpi []
    (new KeyGeneratorSpi )))

