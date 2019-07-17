(ns jdk.security.ProviderException
  "A runtime exception for Provider exceptions (such as
  misconfiguration errors or unrecoverable internal errors),
  which may be subclassed by Providers to
  throw specialized, provider-specific runtime errors."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security ProviderException]))

(defn ->provider-exception
  "Constructor.

  Creates a ProviderException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new ProviderException message cause))
  ([^java.lang.String s]
    (new ProviderException s))
  ([]
    (new ProviderException )))

