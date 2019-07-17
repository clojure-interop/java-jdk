(ns jdk.security.SignatureException
  "This is the generic Signature exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security SignatureException]))

(defn ->signature-exception
  "Constructor.

  Creates a SignatureException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new SignatureException message cause))
  ([msg]
    (new SignatureException msg))
  ([]
    (new SignatureException )))

