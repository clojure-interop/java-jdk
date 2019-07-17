(ns jdk.security.interfaces.ECKey
  "The interface to an elliptic curve (EC) key."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces ECKey]))

(defn get-params
  "Returns the domain parameters associated
   with this key. The domain parameters are
   either explicitly specified or implicitly
   created during key generation.

  returns: the associated domain parameters. - `java.security.spec.ECParameterSpec`"
  ([^. this]
    (-> this (.getParams))))

