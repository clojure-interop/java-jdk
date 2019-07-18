(ns jdk.security.KeyManagementException
  "This is the general key management exception for all operations
  dealing with key management. Examples of subclasses of
  KeyManagementException that developers might create for
  giving more detailed information could include:


  KeyIDConflictException
  KeyAuthorizationFailureException
  ExpiredKeyException"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyManagementException]))

(defn ->key-management-exception
  "Constructor.

  Creates a KeyManagementException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^KeyManagementException [^java.lang.String message ^java.lang.Throwable cause]
    (new KeyManagementException message cause))
  (^KeyManagementException [^java.lang.String msg]
    (new KeyManagementException msg))
  (^KeyManagementException []
    (new KeyManagementException )))

