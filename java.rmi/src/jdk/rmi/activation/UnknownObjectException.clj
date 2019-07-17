(ns jdk.rmi.activation.UnknownObjectException
  "An UnknownObjectException is thrown by methods of classes and
  interfaces in the java.rmi.activation package when the
  ActivationID parameter to the method is determined to be
  invalid.  An ActivationID is invalid if it is not currently
  known by the ActivationSystem.  An ActivationID
  is obtained by the ActivationSystem.registerObject method.
  An ActivationID is also obtained during the
  Activatable.register call."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation UnknownObjectException]))

(defn ->unknown-object-exception
  "Constructor.

  Constructs an UnknownObjectException with the specified
   detail message.

  s - the detail message - `java.lang.String`"
  ([s]
    (new UnknownObjectException s)))

