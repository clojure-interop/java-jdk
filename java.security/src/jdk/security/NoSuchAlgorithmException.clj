(ns jdk.security.NoSuchAlgorithmException
  "This exception is thrown when a particular cryptographic algorithm is
  requested but is not available in the environment."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security NoSuchAlgorithmException]))

(defn ->no-such-algorithm-exception
  "Constructor.

  Creates a NoSuchAlgorithmException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^NoSuchAlgorithmException [^java.lang.String message ^java.lang.Throwable cause]
    (new NoSuchAlgorithmException message cause))
  (^NoSuchAlgorithmException [^java.lang.String msg]
    (new NoSuchAlgorithmException msg))
  (^NoSuchAlgorithmException []
    (new NoSuchAlgorithmException )))

