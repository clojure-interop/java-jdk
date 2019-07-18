(ns jdk.security.cert.CertificateNotYetValidException
  "Certificate is not yet valid exception. This is thrown whenever
  the current Date or the specified Date
  is before the notBefore date/time in the Certificate
  validity period."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateNotYetValidException]))

(defn ->certificate-not-yet-valid-exception
  "Constructor.

  Constructs a CertificateNotYetValidException with the specified detail
   message. A detail message is a String that describes this
   particular exception.

  message - the detail message. - `java.lang.String`"
  (^CertificateNotYetValidException [^java.lang.String message]
    (new CertificateNotYetValidException message))
  (^CertificateNotYetValidException []
    (new CertificateNotYetValidException )))

