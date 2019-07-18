(ns jdk.security.cert.CertificateEncodingException
  "Certificate Encoding Exception. This is thrown whenever an error
  occurs while attempting to encode a certificate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateEncodingException]))

(defn ->certificate-encoding-exception
  "Constructor.

  Creates a CertificateEncodingException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^CertificateEncodingException [^java.lang.String message ^java.lang.Throwable cause]
    (new CertificateEncodingException message cause))
  (^CertificateEncodingException [^java.lang.String message]
    (new CertificateEncodingException message))
  (^CertificateEncodingException []
    (new CertificateEncodingException )))

