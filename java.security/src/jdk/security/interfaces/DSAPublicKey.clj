(ns jdk.security.interfaces.DSAPublicKey
  "The interface to a DSA public key. DSA (Digital Signature Algorithm)
  is defined in NIST's FIPS-186."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces DSAPublicKey]))

(defn get-y
  "Returns the value of the public key, y.

  returns: the value of the public key, y. - `java.math.BigInteger`"
  (^java.math.BigInteger [^DSAPublicKey this]
    (-> this (.getY))))

