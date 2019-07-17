(ns jdk.lang.NegativeArraySizeException
  "Thrown if an application tries to create an array with negative size."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang NegativeArraySizeException]))

(defn ->negative-array-size-exception
  "Constructor.

  Constructs a NegativeArraySizeException with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  ([^java.lang.String s]
    (new NegativeArraySizeException s))
  ([]
    (new NegativeArraySizeException )))

