(ns jdk.lang.NoSuchMethodError
  "Thrown if an application tries to call a specified method of a
  class (either static or instance), and that class no longer has a
  definition of that method.

  Normally, this error is caught by the compiler; this error can
  only occur at run time if the definition of a class has
  incompatibly changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang NoSuchMethodError]))

(defn ->no-such-method-error
  "Constructor.

  Constructs a NoSuchMethodError with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new NoSuchMethodError s))
  ([]
    (new NoSuchMethodError )))

