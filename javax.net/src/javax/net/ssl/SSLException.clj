(ns javax.net.ssl.SSLException
  "Indicates some kind of error detected by an SSL subsystem.
  This class is the general class of exceptions produced
  by failed SSL-related operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.net.ssl SSLException]))

(defn ->ssl-exception
  "Constructor.

  Creates a SSLException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new SSLException message cause))
  ([^java.lang.String reason]
    (new SSLException reason)))

