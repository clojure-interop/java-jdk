(ns jdk.security.InvalidKeyException
  "This is the exception for invalid Keys (invalid encoding, wrong
  length, uninitialized, etc)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security InvalidKeyException]))

(defn ->invalid-key-exception
  "Constructor.

  Creates a InvalidKeyException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new InvalidKeyException message cause))
  ([msg]
    (new InvalidKeyException msg))
  ([]
    (new InvalidKeyException )))

