(ns jdk.lang.SecurityException
  "Thrown by the security manager to indicate a security violation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang SecurityException]))

(defn ->security-exception
  "Constructor.

  Creates a SecurityException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new SecurityException message cause))
  ([^java.lang.String s]
    (new SecurityException s))
  ([]
    (new SecurityException )))

