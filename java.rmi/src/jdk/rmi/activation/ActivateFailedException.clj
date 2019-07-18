(ns jdk.rmi.activation.ActivateFailedException
  "This exception is thrown by the RMI runtime when activation
  fails during a remote call to an activatable object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivateFailedException]))

(defn ->activate-failed-exception
  "Constructor.

  Constructs an ActivateFailedException with the specified
   detail message and nested exception.

  s - the detail message - `java.lang.String`
  ex - the nested exception - `java.lang.Exception`"
  (^ActivateFailedException [^java.lang.String s ^java.lang.Exception ex]
    (new ActivateFailedException s ex))
  (^ActivateFailedException [^java.lang.String s]
    (new ActivateFailedException s)))

