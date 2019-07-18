(ns jdk.security.InvalidAlgorithmParameterException
  "This is the exception for invalid or inappropriate algorithm parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security InvalidAlgorithmParameterException]))

(defn ->invalid-algorithm-parameter-exception
  "Constructor.

  Creates a InvalidAlgorithmParameterException with the
   specified detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^InvalidAlgorithmParameterException [^java.lang.String message ^java.lang.Throwable cause]
    (new InvalidAlgorithmParameterException message cause))
  (^InvalidAlgorithmParameterException [^java.lang.String msg]
    (new InvalidAlgorithmParameterException msg))
  (^InvalidAlgorithmParameterException []
    (new InvalidAlgorithmParameterException )))

