(ns javax.crypto.MacSpi
  "This class defines the Service Provider Interface (SPI)
  for the Mac class.
  All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a particular MAC algorithm.

   Implementations are free to implement the Cloneable interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto MacSpi]))

(defn ->mac-spi
  "Constructor."
  ([]
    (new MacSpi )))

(defn clone
  "Returns a clone if the implementation is cloneable.

  returns: a clone if the implementation is cloneable. - `java.lang.Object`

  throws: java.lang.CloneNotSupportedException - if this is called on an implementation that does not support Cloneable."
  ([this]
    (-> this (.clone))))

