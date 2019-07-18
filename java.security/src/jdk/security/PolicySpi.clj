(ns jdk.security.PolicySpi
  "This class defines the Service Provider Interface (SPI)
  for the Policy class.
  All the abstract methods in this class must be implemented by each
  service provider who wishes to supply a Policy implementation.

   Subclass implementations of this abstract class must provide
  a public constructor that takes a Policy.Parameters
  object as an input parameter.  This constructor also must throw
  an IllegalArgumentException if it does not understand the
  Policy.Parameters input."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security PolicySpi]))

(defn ->policy-spi
  "Constructor."
  (^PolicySpi []
    (new PolicySpi )))

