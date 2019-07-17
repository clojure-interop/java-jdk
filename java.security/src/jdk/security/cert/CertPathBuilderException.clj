(ns jdk.security.cert.CertPathBuilderException
  "An exception indicating one of a variety of problems encountered when
  building a certification path with a CertPathBuilder.

  A CertPathBuilderException provides support for wrapping
  exceptions. The getCause method returns the throwable,
  if any, that caused this exception to be thrown.

  Concurrent Access

  Unless otherwise specified, the methods defined in this class are not
  thread-safe. Multiple threads that need to access a single
  object concurrently should synchronize amongst themselves and
  provide the necessary locking. Multiple threads each manipulating
  separate objects need not synchronize."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.cert CertPathBuilderException]))

(defn ->cert-path-builder-exception
  "Constructor.

  Creates a CertPathBuilderException with the specified
   detail message and cause.

  msg - the detail message - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String msg ^java.lang.Throwable cause]
    (new CertPathBuilderException msg cause))
  ([^java.lang.String msg]
    (new CertPathBuilderException msg))
  ([]
    (new CertPathBuilderException )))

