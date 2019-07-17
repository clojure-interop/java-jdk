(ns jdk.lang.ClassCircularityError
  "Thrown when the Java Virtual Machine detects a circularity in the
  superclass hierarchy of a class being loaded."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ClassCircularityError]))

(defn ->class-circularity-error
  "Constructor.

  Constructs a ClassCircularityError with the specified detail
   message.

  s - The detail message - `java.lang.String`"
  ([s]
    (new ClassCircularityError s))
  ([]
    (new ClassCircularityError )))

