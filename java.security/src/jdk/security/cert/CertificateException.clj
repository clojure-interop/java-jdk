(ns jdk.security.cert.CertificateException
  "This exception indicates one of a variety of certificate problems."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertificateException]))

(defn ->certificate-exception
  "Constructor.

  Creates a CertificateException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new CertificateException message cause))
  ([msg]
    (new CertificateException msg))
  ([]
    (new CertificateException )))

