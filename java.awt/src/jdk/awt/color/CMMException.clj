(ns jdk.awt.color.CMMException
  "This exception is thrown if the native CMM returns an error."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.color CMMException]))

(defn ->cmm-exception
  "Constructor.

  Constructs a CMMException with the specified detail message.

  s - the specified detail message - `java.lang.String`"
  ([^java.lang.String s]
    (new CMMException s)))

