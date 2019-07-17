(ns jdk.lang.NoSuchFieldError
  "Thrown if an application tries to access or modify a specified
  field of an object, and that object no longer has that field.

  Normally, this error is caught by the compiler; this error can
  only occur at run time if the definition of a class has
  incompatibly changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang NoSuchFieldError]))

(defn ->no-such-field-error
  "Constructor.

  Constructs a NoSuchFieldError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new NoSuchFieldError s))
  ([]
    (new NoSuchFieldError )))

