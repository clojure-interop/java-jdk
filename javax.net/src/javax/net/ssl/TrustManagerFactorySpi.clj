(ns javax.net.ssl.TrustManagerFactorySpi
  "This class defines the Service Provider Interface (SPI)
  for the TrustManagerFactory class.

   All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a particular trust manager factory."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl TrustManagerFactorySpi]))

(defn ->trust-manager-factory-spi
  "Constructor."
  ([]
    (new TrustManagerFactorySpi )))

