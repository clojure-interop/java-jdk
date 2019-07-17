(ns jdk.lang.AbstractMethodError
  "Thrown when an application tries to call an abstract method.
  Normally, this error is caught by the compiler; this error can
  only occur at run time if the definition of some class has
  incompatibly changed since the currently executing method was last
  compiled."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang AbstractMethodError]))

(defn ->abstract-method-error
  "Constructor.

  Constructs an AbstractMethodError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new AbstractMethodError s))
  ([]
    (new AbstractMethodError )))

