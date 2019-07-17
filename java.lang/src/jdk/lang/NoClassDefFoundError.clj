(ns jdk.lang.NoClassDefFoundError
  "Thrown if the Java Virtual Machine or a ClassLoader instance
  tries to load in the definition of a class (as part of a normal method call
  or as part of creating a new instance using the new expression)
  and no definition of the class could be found.

  The searched-for class definition existed when the currently
  executing class was compiled, but the definition can no longer be
  found."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang NoClassDefFoundError]))

(defn ->no-class-def-found-error
  "Constructor.

  Constructs a NoClassDefFoundError with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new NoClassDefFoundError s))
  ([]
    (new NoClassDefFoundError )))

