(ns jdk.security.GeneralSecurityException
  "The GeneralSecurityException class is a generic
  security exception class that provides type safety for all the
  security-related exception classes that extend from it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security GeneralSecurityException]))

(defn ->general-security-exception
  "Constructor.

  Creates a GeneralSecurityException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new GeneralSecurityException message cause))
  ([msg]
    (new GeneralSecurityException msg))
  ([]
    (new GeneralSecurityException )))

