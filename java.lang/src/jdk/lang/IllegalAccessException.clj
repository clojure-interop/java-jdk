(ns jdk.lang.IllegalAccessException
  "An IllegalAccessException is thrown when an application tries
  to reflectively create an instance (other than an array),
  set or get a field, or invoke a method, but the currently
  executing method does not have access to the definition of
  the specified class, field, method or constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IllegalAccessException]))

(defn ->illegal-access-exception
  "Constructor.

  Constructs an IllegalAccessException with a detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new IllegalAccessException s))
  ([]
    (new IllegalAccessException )))

