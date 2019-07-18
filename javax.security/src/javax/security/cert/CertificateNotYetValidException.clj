(ns javax.security.cert.CertificateNotYetValidException
  "Certificate is not yet valid exception. This is thrown whenever
  the current Date or the specified Date
  is before the notBefore date/time in the Certificate
  validity period.

  Note: The classes in the package javax.security.cert
  exist for compatibility with earlier versions of the
  Java Secure Sockets Extension (JSSE). New applications should instead
  use the standard Java SE certificate classes located in
  java.security.cert."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.cert CertificateNotYetValidException]))

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

