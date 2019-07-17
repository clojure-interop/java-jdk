(ns javax.net.ssl.SSLContextSpi
  "This class defines the Service Provider Interface (SPI)
  for the SSLContext class.

   All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a particular SSL context."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLContextSpi]))

(defn ->ssl-context-spi
  "Constructor."
  ([]
    (new SSLContextSpi )))

