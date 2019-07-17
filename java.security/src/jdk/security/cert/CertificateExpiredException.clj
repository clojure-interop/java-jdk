(ns jdk.security.cert.CertificateExpiredException
  "Certificate Expired Exception. This is thrown whenever the current
  Date or the specified Date is after the
  notAfter date/time specified in the validity period
  of the certificate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateExpiredException]))

(defn ->certificate-expired-exception
  "Constructor.

  Constructs a CertificateExpiredException with the specified detail
   message. A detail message is a String that describes this
   particular exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new CertificateExpiredException message))
  ([]
    (new CertificateExpiredException )))

