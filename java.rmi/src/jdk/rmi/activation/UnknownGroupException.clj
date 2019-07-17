(ns jdk.rmi.activation.UnknownGroupException
  "An UnknownGroupException is thrown by methods of classes and
  interfaces in the java.rmi.activation package when the
  ActivationGroupID parameter to the method is determined to be
  invalid, i.e., not known by the ActivationSystem.  An
  UnknownGroupException is also thrown if the
  ActivationGroupID in an ActivationDesc refers to
  a group that is not registered with the ActivationSystem"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation UnknownGroupException]))

(defn ->unknown-group-exception
  "Constructor.

  Constructs an UnknownGroupException with the specified
   detail message.

  s - the detail message - `java.lang.String`"
  ([s]
    (new UnknownGroupException s)))

