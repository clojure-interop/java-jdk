(ns jdk.util.zip.ZipError
  "Signals that an unrecoverable error has occurred."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.zip ZipError]))

(defn ->zip-error
  "Constructor.

  Constructs a ZipError with the given detail message.

  s - the String containing a detail message - `java.lang.String`"
  ([s]
    (new ZipError s)))

