(ns jdk.security.cert.CertPathParameters
  "A specification of certification path algorithm parameters.
  The purpose of this interface is to group (and provide type safety for)
  all CertPath parameter specifications. All
  CertPath parameter specifications must implement this
  interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathParameters]))

(defn clone
  "Makes a copy of this CertPathParameters. Changes to the
   copy will not affect the original and vice versa.

  returns: a copy of this CertPathParameters - `java.lang.Object`"
  (^java.lang.Object [^java.security.cert.CertPathParameters this]
    (-> this (.clone))))

