(ns jdk.security.interfaces.RSAKey
  "The interface to an RSA public or private key."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces RSAKey]))

(defn get-modulus
  "Returns the modulus.

  returns: the modulus - `java.math.BigInteger`"
  (^java.math.BigInteger [^RSAKey this]
    (-> this (.getModulus))))

