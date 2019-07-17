(ns jdk.security.interfaces.DSAPrivateKey
  "The standard interface to a DSA private key. DSA (Digital Signature
  Algorithm) is defined in NIST's FIPS-186."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces DSAPrivateKey]))

(defn get-x
  "Returns the value of the private key, x.

  returns: the value of the private key, x. - `java.math.BigInteger`"
  ([^java.security.interfaces.DSAPrivateKey this]
    (-> this (.getX))))

