(ns jdk.security.cert.CRL
  "This class is an abstraction of certificate revocation lists (CRLs) that
  have different formats but important common uses. For example, all CRLs
  share the functionality of listing revoked certificates, and can be queried
  on whether or not they list a given certificate.

  Specialized CRL types can be defined by subclassing off of this abstract
  class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CRL]))

(defn get-type
  "Returns the type of this CRL.

  returns: the type of this CRL. - `java.lang.String`"
  (^java.lang.String [^java.security.cert.CRL this]
    (-> this (.getType))))

(defn to-string
  "Returns a string representation of this CRL.

  returns: a string representation of this CRL. - `java.lang.String`"
  (^java.lang.String [^java.security.cert.CRL this]
    (-> this (.toString))))

(defn revoked?
  "Checks whether the given certificate is on this CRL.

  cert - the certificate to check for. - `java.security.cert.Certificate`

  returns: true if the given certificate is on this CRL,
   false otherwise. - `boolean`"
  (^Boolean [^java.security.cert.CRL this ^java.security.cert.Certificate cert]
    (-> this (.isRevoked cert))))

