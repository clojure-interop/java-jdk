(ns javax.crypto.SecretKeyFactorySpi
  "This class defines the Service Provider Interface (SPI)
  for the SecretKeyFactory class.
  All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a secret-key factory for a particular algorithm.

   A provider should document all the key specifications supported by its
  secret key factory.
  For example, the DES secret-key factory supplied by the `SunJCE` provider
  supports DESKeySpec as a transparent representation of DES
  keys, and that provider's secret-key factory for Triple DES keys supports
  DESedeKeySpec as a transparent representation of Triple DES
  keys."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto SecretKeyFactorySpi]))

(defn ->secret-key-factory-spi
  "Constructor."
  ([]
    (new SecretKeyFactorySpi )))

