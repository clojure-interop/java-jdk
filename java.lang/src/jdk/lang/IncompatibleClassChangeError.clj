(ns jdk.lang.IncompatibleClassChangeError
  "Thrown when an incompatible class change has occurred to some class
  definition. The definition of some class, on which the currently
  executing method depends, has since changed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IncompatibleClassChangeError]))

(defn ->incompatible-class-change-error
  "Constructor.

  Constructs an IncompatibleClassChangeError with the
   specified detail message.

  s - the detail message. - `java.lang.String`"
  ([s]
    (new IncompatibleClassChangeError s))
  ([]
    (new IncompatibleClassChangeError )))

