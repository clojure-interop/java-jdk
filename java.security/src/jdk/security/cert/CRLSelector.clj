(ns jdk.security.cert.CRLSelector
  "A selector that defines a set of criteria for selecting CRLs.
  Classes that implement this interface are often used to specify
  which CRLs should be retrieved from a CertStore.

  Concurrent Access

  Unless otherwise specified, the methods defined in this interface are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CRLSelector]))

(defn match
  "Decides whether a CRL should be selected.

  crl - the CRL to be checked - `java.security.cert.CRL`

  returns: true if the CRL should be selected,
   false otherwise - `boolean`"
  ([this crl]
    (-> this (.match crl))))

(defn clone
  "Makes a copy of this CRLSelector. Changes to the
   copy will not affect the original and vice versa.

  returns: a copy of this CRLSelector - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

