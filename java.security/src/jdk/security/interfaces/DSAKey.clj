(ns jdk.security.interfaces.DSAKey
  "The interface to a DSA public or private key. DSA (Digital Signature
  Algorithm) is defined in NIST's FIPS-186."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.interfaces DSAKey]))

(defn get-params
  "Returns the DSA-specific key parameters. These parameters are
   never secret.

  returns: the DSA-specific key parameters. - `java.security.interfaces.DSAParams`"
  ([this]
    (-> this (.getParams))))

