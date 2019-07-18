(ns jdk.security.SignatureSpi
  "This class defines the Service Provider Interface (SPI)
  for the Signature class, which is used to provide the
  functionality of a digital signature algorithm. Digital signatures are used
  for authentication and integrity assurance of digital data.
 .
   All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a particular signature algorithm."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security SignatureSpi]))

(defn ->signature-spi
  "Constructor."
  (^SignatureSpi []
    (new SignatureSpi )))

(defn clone
  "Returns a clone if the implementation is cloneable.

  returns: a clone if the implementation is cloneable. - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if this is called on an implementation that does not support Cloneable."
  (^java.lang.Object [^SignatureSpi this]
    (-> this (.clone))))

