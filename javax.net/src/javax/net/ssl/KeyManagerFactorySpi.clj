(ns javax.net.ssl.KeyManagerFactorySpi
  "This class defines the Service Provider Interface (SPI)
  for the KeyManagerFactory class.

   All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a particular key manager factory."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl KeyManagerFactorySpi]))

(defn ->key-manager-factory-spi
  "Constructor."
  ([]
    (new KeyManagerFactorySpi )))

