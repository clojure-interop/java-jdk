(ns javax.crypto.ExemptionMechanismSpi
  "This class defines the Service Provider Interface (SPI)
  for the ExemptionMechanism class.
  All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a particular exemption mechanism."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto ExemptionMechanismSpi]))

(defn ->exemption-mechanism-spi
  "Constructor."
  ([]
    (new ExemptionMechanismSpi )))

