(ns jdk.security.interfaces.RSAPrivateKey
  "The interface to an RSA private key."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces RSAPrivateKey]))

(defn get-private-exponent
  "Returns the private exponent.

  returns: the private exponent - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.security.interfaces.RSAPrivateKey this]
    (-> this (.getPrivateExponent))))

