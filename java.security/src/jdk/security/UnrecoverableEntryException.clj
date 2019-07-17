(ns jdk.security.UnrecoverableEntryException
  "This exception is thrown if an entry in the keystore cannot be recovered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security UnrecoverableEntryException]))

(defn ->unrecoverable-entry-exception
  "Constructor.

  Constructs an UnrecoverableEntryException with the specified detail
   message, which provides more information about why this exception
   has been thrown.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new UnrecoverableEntryException msg))
  ([]
    (new UnrecoverableEntryException )))

