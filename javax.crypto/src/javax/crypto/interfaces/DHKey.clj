(ns javax.crypto.interfaces.DHKey
  "The interface to a Diffie-Hellman key."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto.interfaces DHKey]))

(defn get-params
  "Returns the key parameters.

  returns: the key parameters - `javax.crypto.spec.DHParameterSpec`"
  ([^. this]
    (-> this (.getParams))))

