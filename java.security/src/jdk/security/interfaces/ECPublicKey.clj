(ns jdk.security.interfaces.ECPublicKey
  "The interface to an elliptic curve (EC) public key."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces ECPublicKey]))

(defn get-w
  "Returns the public point W.

  returns: the public point W. - `java.security.spec.ECPoint`"
  (^java.security.spec.ECPoint [^ECPublicKey this]
    (-> this (.getW))))

