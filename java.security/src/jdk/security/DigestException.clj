(ns jdk.security.DigestException
  "This is the generic Message Digest exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security DigestException]))

(defn ->digest-exception
  "Constructor.

  Creates a DigestException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new DigestException message cause))
  ([^java.lang.String msg]
    (new DigestException msg))
  ([]
    (new DigestException )))

