(ns jdk.security.cert.CertStoreException
  "An exception indicating one of a variety of problems retrieving
  certificates and CRLs from a CertStore.

  A CertStoreException provides support for wrapping
  exceptions. The getCause method returns the throwable,
  if any, that caused this exception to be thrown.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertStoreException]))

(defn ->cert-store-exception
  "Constructor.

  Creates a CertStoreException with the specified detail
   message and cause.

  msg - the detail message - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^CertStoreException [^java.lang.String msg ^java.lang.Throwable cause]
    (new CertStoreException msg cause))
  (^CertStoreException [^java.lang.String msg]
    (new CertStoreException msg))
  (^CertStoreException []
    (new CertStoreException )))

