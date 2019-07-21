(ns javax.xml.crypto.KeySelector$Purpose
  "The purpose of the key that is to be selected."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.crypto KeySelector$Purpose]))

(def *-sign
  "Static Constant.

  A key for signing.

  type: javax.xml.crypto.KeySelector$Purpose"
  KeySelector$Purpose/SIGN)

(def *-verify
  "Static Constant.

  A key for verifying.

  type: javax.xml.crypto.KeySelector$Purpose"
  KeySelector$Purpose/VERIFY)

(def *-encrypt
  "Static Constant.

  A key for encrypting.

  type: javax.xml.crypto.KeySelector$Purpose"
  KeySelector$Purpose/ENCRYPT)

(def *-decrypt
  "Static Constant.

  A key for decrypting.

  type: javax.xml.crypto.KeySelector$Purpose"
  KeySelector$Purpose/DECRYPT)

(defn to-string
  "Returns a string representation of this purpose (\"sign\",
   \"verify\", \"encrypt\", or \"decrypt\").

  returns: a string representation of this purpose - `java.lang.String`"
  (^java.lang.String [^KeySelector$Purpose this]
    (-> this (.toString))))

