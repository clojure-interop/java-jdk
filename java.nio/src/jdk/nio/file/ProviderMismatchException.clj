(ns jdk.nio.file.ProviderMismatchException
  "Unchecked exception thrown when an attempt is made to invoke a method on an
  object created by one file system provider with a parameter created by a
  different file system provider."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file ProviderMismatchException]))

(defn ->provider-mismatch-exception
  "Constructor.

  Constructs an instance of this class.

  msg - the detail message - `java.lang.String`"
  ([msg]
    (new ProviderMismatchException msg))
  ([]
    (new ProviderMismatchException )))

