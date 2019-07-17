(ns jdk.security.cert.CertPathValidatorResult
  "A specification of the result of a certification path validator algorithm.

  The purpose of this interface is to group (and provide type safety
  for) all certification path validator results. All results returned
  by the CertPathValidator.validate
  method must implement this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathValidatorResult]))

(defn clone
  "Makes a copy of this CertPathValidatorResult. Changes to the
   copy will not affect the original and vice versa.

  returns: a copy of this CertPathValidatorResult - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

