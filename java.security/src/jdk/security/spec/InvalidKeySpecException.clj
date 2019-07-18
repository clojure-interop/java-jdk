(ns jdk.security.spec.InvalidKeySpecException
  "This is the exception for invalid key specifications."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec InvalidKeySpecException]))

(defn ->invalid-key-spec-exception
  "Constructor.

  Creates a InvalidKeySpecException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^InvalidKeySpecException [^java.lang.String message ^java.lang.Throwable cause]
    (new InvalidKeySpecException message cause))
  (^InvalidKeySpecException [^java.lang.String msg]
    (new InvalidKeySpecException msg))
  (^InvalidKeySpecException []
    (new InvalidKeySpecException )))

