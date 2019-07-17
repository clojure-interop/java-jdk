(ns javax.xml.crypto.KeySelector
  "A selector that finds and returns a key using the data contained in a
  KeyInfo object. An example of an implementation of
  this class is one that searches a KeyStore for
  trusted keys that match information contained in a KeyInfo.

  Whether or not the returned key is trusted and the mechanisms
  used to determine that is implementation-specific."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto KeySelector]))

(defn *singleton-key-selector
  "Returns a KeySelector that always selects the specified
   key, regardless of the KeyInfo passed to it.

  key - the sole key to be stored in the key selector - `java.security.Key`

  returns: a key selector that always selects the specified key - `javax.xml.crypto.KeySelector`

  throws: java.lang.NullPointerException - if key is null"
  (^javax.xml.crypto.KeySelector [^java.security.Key key]
    (KeySelector/singletonKeySelector key)))

(defn select
  "Attempts to find a key that satisfies the specified constraints.

  key-info - a KeyInfo (may be null) - `javax.xml.crypto.dsig.keyinfo.KeyInfo`
  purpose - the key's purpose (KeySelector.Purpose.SIGN, KeySelector.Purpose.VERIFY, KeySelector.Purpose.ENCRYPT, or KeySelector.Purpose.DECRYPT) - `javax.xml.crypto.KeySelector.Purpose`
  method - the algorithm method that this key is to be used for. Only keys that are compatible with the algorithm and meet the constraints of the specified algorithm should be returned. - `javax.xml.crypto.AlgorithmMethod`
  context - an XMLCryptoContext that may contain useful information for finding an appropriate key. If this key selector supports resolving RetrievalMethod types, the context's baseURI and dereferencer parameters (if specified) should be used by the selector to resolve and dereference the URI. - `javax.xml.crypto.XMLCryptoContext`

  returns: the result of the key selector - `javax.xml.crypto.KeySelectorResult`

  throws: javax.xml.crypto.KeySelectorException - if an exceptional condition occurs while attempting to find a key. Note that an inability to find a key is not considered an exception (null should be returned in that case). However, an error condition (ex: network communications failure) that prevented the KeySelector from finding a potential key should be considered an exception."
  (^javax.xml.crypto.KeySelectorResult [^javax.xml.crypto.KeySelector this ^javax.xml.crypto.dsig.keyinfo.KeyInfo key-info ^javax.xml.crypto.KeySelector.Purpose purpose ^javax.xml.crypto.AlgorithmMethod method ^javax.xml.crypto.XMLCryptoContext context]
    (-> this (.select key-info purpose method context))))

