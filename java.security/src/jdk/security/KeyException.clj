(ns jdk.security.KeyException
  "This is the basic key exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyException]))

(defn ->key-exception
  "Constructor.

  Creates a KeyException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new KeyException message cause))
  ([^java.lang.String msg]
    (new KeyException msg))
  ([]
    (new KeyException )))

