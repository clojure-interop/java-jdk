(ns javax.net.ssl.CertPathTrustManagerParameters
  "A wrapper for CertPathParameters. This class is used to pass validation
  settings to CertPath based TrustManagers using the
  TrustManagerFactory.init() method.

  Instances of this class are immutable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl CertPathTrustManagerParameters]))

(defn ->cert-path-trust-manager-parameters
  "Constructor.

  Construct new CertPathTrustManagerParameters from the specified
   parameters. The parameters are cloned to protect against subsequent
   modification.

  parameters - the CertPathParameters to be used - `java.security.cert.CertPathParameters`

  throws: java.lang.NullPointerException - if parameters is null"
  ([^java.security.cert.CertPathParameters parameters]
    (new CertPathTrustManagerParameters parameters)))

(defn get-parameters
  "Return a clone of the CertPathParameters encapsulated by this class.

  returns: a clone of the CertPathParameters encapsulated by this class. - `java.security.cert.CertPathParameters`"
  ([^javax.net.ssl.CertPathTrustManagerParameters this]
    (-> this (.getParameters))))

