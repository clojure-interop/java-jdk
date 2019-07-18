(ns javax.crypto.KeyAgreementSpi
  "This class defines the Service Provider Interface (SPI)
  for the KeyAgreement class.
  All the abstract methods in this class must be implemented by each
  cryptographic service provider who wishes to supply the implementation
  of a particular key agreement algorithm.

   The keys involved in establishing a shared secret are created by one
  of the
  key generators (KeyPairGenerator or
  KeyGenerator), a KeyFactory, or as a result from
  an intermediate phase of the key agreement protocol
  (engineDoPhase).

   For each of the correspondents in the key exchange,
  engineDoPhase
  needs to be called. For example, if the key exchange is with one other
  party, engineDoPhase needs to be called once, with the
  lastPhase flag set to true.
  If the key exchange is
  with two other parties, engineDoPhase needs to be called twice,
  the first time setting the lastPhase flag to
  false, and the second time setting it to true.
  There may be any number of parties involved in a key exchange."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto KeyAgreementSpi]))

(defn ->key-agreement-spi
  "Constructor."
  (^KeyAgreementSpi []
    (new KeyAgreementSpi )))

