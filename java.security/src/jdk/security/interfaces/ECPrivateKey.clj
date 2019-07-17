(ns jdk.security.interfaces.ECPrivateKey
  "The interface to an elliptic curve (EC) private key."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces ECPrivateKey]))

(defn get-s
  "Returns the private value S.

  returns: the private value S. - `java.math.BigInteger`"
  ([^. this]
    (-> this (.getS))))

