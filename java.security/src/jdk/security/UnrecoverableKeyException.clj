(ns jdk.security.UnrecoverableKeyException
  "This exception is thrown if a key in the keystore cannot be recovered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security UnrecoverableKeyException]))

(defn ->unrecoverable-key-exception
  "Constructor.

  Constructs an UnrecoverableKeyException with the specified detail
   message, which provides more information about why this exception
   has been thrown.

  msg - the detail message. - `java.lang.String`"
  (^UnrecoverableKeyException [^java.lang.String msg]
    (new UnrecoverableKeyException msg))
  (^UnrecoverableKeyException []
    (new UnrecoverableKeyException )))

