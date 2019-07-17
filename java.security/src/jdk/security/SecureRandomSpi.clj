(ns jdk.security.SecureRandomSpi
  "This class defines the Service Provider Interface (SPI)
  for the SecureRandom class.
  All the abstract methods in this class must be implemented by each
  service provider who wishes to supply the implementation
  of a cryptographically strong pseudo-random number generator."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security SecureRandomSpi]))

(defn ->secure-random-spi
  "Constructor."
  ([]
    (new SecureRandomSpi )))

