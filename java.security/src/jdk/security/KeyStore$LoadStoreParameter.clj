(ns jdk.security.KeyStore$LoadStoreParameter
  "A marker interface for KeyStore
  load
  and
  store
  parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStore$LoadStoreParameter]))

(defn get-protection-parameter
  "Gets the parameter used to protect keystore data.

  returns: the parameter used to protect keystore data, or null - `java.security.KeyStore.ProtectionParameter`"
  ([this]
    (-> this (.getProtectionParameter))))

