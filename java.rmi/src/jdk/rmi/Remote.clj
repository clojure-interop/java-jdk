(ns jdk.rmi.Remote
  "The Remote interface serves to identify interfaces whose
  methods may be invoked from a non-local virtual machine.  Any object that
  is a remote object must directly or indirectly implement this interface.
  Only those methods specified in a `remote interface`, an interface that
  extends java.rmi.Remote are available remotely.

  Implementation classes can implement any number of remote interfaces and
  can extend other remote implementation classes.  RMI provides some
  convenience classes that remote object implementations can extend which
  facilitate remote object creation.  These classes are
  java.rmi.server.UnicastRemoteObject and
  java.rmi.activation.Activatable.

  For complete details on RMI, see the RMI Specification which describes the RMI API and system."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi Remote]))

