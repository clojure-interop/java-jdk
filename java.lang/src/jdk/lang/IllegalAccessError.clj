(ns jdk.lang.IllegalAccessError
  "Thrown if an application attempts to access or modify a field, or
  to call a method that it does not have access to.

  Normally, this error is caught by the compiler; this error can
  only occur at run time if the definition of a class has
  incompatibly changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IllegalAccessError]))

(defn ->illegal-access-error
  "Constructor.

  Constructs an IllegalAccessError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  (^IllegalAccessError [^java.lang.String s]
    (new IllegalAccessError s))
  (^IllegalAccessError []
    (new IllegalAccessError )))

