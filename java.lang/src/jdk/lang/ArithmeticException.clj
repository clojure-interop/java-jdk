(ns jdk.lang.ArithmeticException
  "Thrown when an exceptional arithmetic condition has occurred. For
  example, an integer \"divide by zero\" throws an
  instance of this class.

  ArithmeticException objects may be constructed by the
  virtual machine as if suppression were disabled and/or the
  stack trace was not writable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ArithmeticException]))

(defn ->arithmetic-exception
  "Constructor.

  Constructs an ArithmeticException with the specified
   detail message.

  s - the detail message. - `java.lang.String`"
  (^ArithmeticException [^java.lang.String s]
    (new ArithmeticException s))
  (^ArithmeticException []
    (new ArithmeticException )))

