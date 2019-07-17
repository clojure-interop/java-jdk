(ns jdk.security.AlgorithmParametersSpi
  "This class defines the Service Provider Interface (SPI)
  for the AlgorithmParameters class, which is used to manage
  algorithm parameters.

   All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply parameter management
  for a particular algorithm."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AlgorithmParametersSpi]))

(defn ->algorithm-parameters-spi
  "Constructor."
  ([]
    (new AlgorithmParametersSpi )))

