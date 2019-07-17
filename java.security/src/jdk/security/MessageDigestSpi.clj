(ns jdk.security.MessageDigestSpi
  "This class defines the Service Provider Interface (SPI)
  for the MessageDigest class, which provides the functionality
  of a message digest algorithm, such as MD5 or SHA. Message digests are
  secure one-way hash functions that take arbitrary-sized data and output a
  fixed-length hash value.

   All the abstract methods in this class must be implemented by a
  cryptographic service provider who wishes to supply the implementation
  of a particular message digest algorithm.

   Implementations are free to implement the Cloneable interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security MessageDigestSpi]))

(defn ->message-digest-spi
  "Constructor."
  ([]
    (new MessageDigestSpi )))

(defn clone
  "Returns a clone if the implementation is cloneable.

  returns: a clone if the implementation is cloneable. - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if this is called on an implementation that does not support Cloneable."
  (^java.lang.Object [^java.security.MessageDigestSpi this]
    (-> this (.clone))))

