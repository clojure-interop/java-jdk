(ns javax.crypto.NullCipher
  "The NullCipher class is a class that provides an
  `identity cipher` -- one that does not transform the plain text.  As
  a consequence, the ciphertext is identical to the plaintext.  All
  initialization methods do nothing, while the blocksize is set to 1
  byte."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto NullCipher]))

(defn ->null-cipher
  "Constructor.

  Creates a NullCipher object."
  (^NullCipher []
    (new NullCipher )))

