(ns jdk.security.KeyStoreException
  "This is the generic KeyStore exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security KeyStoreException]))

(defn ->key-store-exception
  "Constructor.

  Creates a KeyStoreException with the specified
   detail message and cause.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new KeyStoreException message cause))
  ([msg]
    (new KeyStoreException msg))
  ([]
    (new KeyStoreException )))

