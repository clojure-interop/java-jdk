(ns jdk.security.cert.CertSelector
  "A selector that defines a set of criteria for selecting
  Certificates. Classes that implement this interface
  are often used to specify which Certificates should
  be retrieved from a CertStore.

  Concurrent Access

  Unless otherwise specified, the methods defined in this interface are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertSelector]))

(defn match
  "Decides whether a Certificate should be selected.

  cert - the Certificate to be checked - `java.security.cert.Certificate`

  returns: true if the Certificate
   should be selected, false otherwise - `boolean`"
  ([^java.security.cert.CertSelector this ^java.security.cert.Certificate cert]
    (-> this (.match cert))))

(defn clone
  "Makes a copy of this CertSelector. Changes to the
   copy will not affect the original and vice versa.

  returns: a copy of this CertSelector - `java.lang.Object`"
  ([^java.security.cert.CertSelector this]
    (-> this (.clone))))

