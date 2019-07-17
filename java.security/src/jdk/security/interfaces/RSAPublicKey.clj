(ns jdk.security.interfaces.RSAPublicKey
  "The interface to an RSA public key."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces RSAPublicKey]))

(defn get-public-exponent
  "Returns the public exponent.

  returns: the public exponent - `java.math.BigInteger`"
  ([^java.security.interfaces.RSAPublicKey this]
    (-> this (.getPublicExponent))))

