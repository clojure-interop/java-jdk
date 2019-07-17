(ns jdk.security.cert.CRLException
  "CRL (Certificate Revocation List) Exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CRLException]))

(defn ->crl-exception
  "Constructor.

  Creates a CRLException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new CRLException message cause))
  ([message]
    (new CRLException message))
  ([]
    (new CRLException )))

