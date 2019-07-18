(ns jdk.security.cert.CertificateParsingException
  "Certificate Parsing Exception. This is thrown whenever an
  invalid DER-encoded certificate is parsed or unsupported DER features
  are found in the Certificate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateParsingException]))

(defn ->certificate-parsing-exception
  "Constructor.

  Creates a CertificateParsingException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^CertificateParsingException [^java.lang.String message ^java.lang.Throwable cause]
    (new CertificateParsingException message cause))
  (^CertificateParsingException [^java.lang.String message]
    (new CertificateParsingException message))
  (^CertificateParsingException []
    (new CertificateParsingException )))

