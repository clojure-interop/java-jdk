(ns jdk.security.cert.CertPathBuilderResult
  "A specification of the result of a certification path builder algorithm.
  All results returned by the CertPathBuilder.build method must implement this interface.

  At a minimum, a CertPathBuilderResult contains the
  CertPath built by the CertPathBuilder instance.
  Implementations of this interface may add methods to return implementation
  or algorithm specific information, such as debugging information or
  certification path validation results.

  Concurrent Access

  Unless otherwise specified, the methods defined in this interface are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathBuilderResult]))

(defn get-cert-path
  "Returns the built certification path.

  returns: the certification path (never null) - `java.security.cert.CertPath`"
  ([^. this]
    (-> this (.getCertPath))))

(defn clone
  "Makes a copy of this CertPathBuilderResult. Changes to the
   copy will not affect the original and vice versa.

  returns: a copy of this CertPathBuilderResult - `java.lang.Object`"
  ([^. this]
    (-> this (.clone))))

