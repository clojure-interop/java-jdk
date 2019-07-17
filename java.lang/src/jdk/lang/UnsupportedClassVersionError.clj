(ns jdk.lang.UnsupportedClassVersionError
  "Thrown when the Java Virtual Machine attempts to read a class
  file and determines that the major and minor version numbers
  in the file are not supported."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang UnsupportedClassVersionError]))

(defn ->unsupported-class-version-error
  "Constructor.

  Constructs a UnsupportedClassVersionError with
   the specified detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new UnsupportedClassVersionError s))
  ([]
    (new UnsupportedClassVersionError )))

