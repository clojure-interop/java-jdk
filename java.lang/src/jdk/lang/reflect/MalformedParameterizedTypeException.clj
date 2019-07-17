(ns jdk.lang.reflect.MalformedParameterizedTypeException
  "Thrown when a semantically malformed parameterized type is
  encountered by a reflective method that needs to instantiate it.
  For example, if the number of type arguments to a parameterized type
  is wrong."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect MalformedParameterizedTypeException]))

(defn ->malformed-parameterized-type-exception
  "Constructor."
  ([]
    (new MalformedParameterizedTypeException )))

