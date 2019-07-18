(ns jdk.lang.InstantiationException
  "Thrown when an application tries to create an instance of a class
  using the newInstance method in class
  Class, but the specified class object cannot be
  instantiated.  The instantiation can fail for a variety of
  reasons including but not limited to:


   the class object represents an abstract class, an interface,
       an array class, a primitive type, or void
   the class has no nullary constructor"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang InstantiationException]))

(defn ->instantiation-exception
  "Constructor.

  Constructs an InstantiationException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  (^InstantiationException [^java.lang.String s]
    (new InstantiationException s))
  (^InstantiationException []
    (new InstantiationException )))

