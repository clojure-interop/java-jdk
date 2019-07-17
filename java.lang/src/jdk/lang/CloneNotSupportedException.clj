(ns jdk.lang.CloneNotSupportedException
  "Thrown to indicate that the clone method in class
  Object has been called to clone an object, but that
  the object's class does not implement the Cloneable
  interface.

  Applications that override the clone method can also
  throw this exception to indicate that an object could not or
  should not be cloned."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang CloneNotSupportedException]))

(defn ->clone-not-supported-exception
  "Constructor.

  Constructs a CloneNotSupportedException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new CloneNotSupportedException s))
  ([]
    (new CloneNotSupportedException )))

