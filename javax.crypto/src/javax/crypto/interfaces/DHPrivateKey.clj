(ns javax.crypto.interfaces.DHPrivateKey
  "The interface to a Diffie-Hellman private key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.interfaces DHPrivateKey]))

(defn get-x
  "Returns the private value, x.

  returns: the private value, x - `java.math.BigInteger`"
  (^java.math.BigInteger [^javax.crypto.interfaces.DHPrivateKey this]
    (-> this (.getX))))

