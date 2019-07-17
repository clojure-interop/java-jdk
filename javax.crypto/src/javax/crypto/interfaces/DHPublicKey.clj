(ns javax.crypto.interfaces.DHPublicKey
  "The interface to a Diffie-Hellman public key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.interfaces DHPublicKey]))

(defn get-y
  "Returns the public value, y.

  returns: the public value, y - `java.math.BigInteger`"
  ([^javax.crypto.interfaces.DHPublicKey this]
    (-> this (.getY))))

