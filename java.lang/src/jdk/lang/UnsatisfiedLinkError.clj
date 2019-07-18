(ns jdk.lang.UnsatisfiedLinkError
  "Thrown if the Java Virtual Machine cannot find an appropriate
  native-language definition of a method declared native."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang UnsatisfiedLinkError]))

(defn ->unsatisfied-link-error
  "Constructor.

  Constructs an UnsatisfiedLinkError with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  (^UnsatisfiedLinkError [^java.lang.String s]
    (new UnsatisfiedLinkError s))
  (^UnsatisfiedLinkError []
    (new UnsatisfiedLinkError )))

