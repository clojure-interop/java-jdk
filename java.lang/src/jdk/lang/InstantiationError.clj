(ns jdk.lang.InstantiationError
  "Thrown when an application tries to use the Java new
  construct to instantiate an abstract class or an interface.

  Normally, this error is caught by the compiler; this error can
  only occur at run time if the definition of a class has
  incompatibly changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang InstantiationError]))

(defn ->instantiation-error
  "Constructor.

  Constructs an InstantiationError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new InstantiationError s))
  ([]
    (new InstantiationError )))

