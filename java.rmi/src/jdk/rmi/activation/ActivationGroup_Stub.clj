(ns jdk.rmi.activation.ActivationGroup_Stub
  "ActivationGroup_Stub is a stub class
  for the subclasses of java.rmi.activation.ActivationGroup
  that are exported as a java.rmi.server.UnicastRemoteObject."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.activation ActivationGroup_Stub]))

(defn ->activation-group-stub
  "Constructor.

  Constructs a stub for the ActivationGroup class.  It
   invokes the superclass RemoteStub(RemoteRef)
   constructor with its argument, ref.

  ref - a remote ref - `java.rmi.server.RemoteRef`"
  (^ActivationGroup_Stub [^java.rmi.server.RemoteRef ref]
    (new ActivationGroup_Stub ref)))

(defn new-instance
  "Stub method for ActivationGroup.newInstance.  Invokes
   the invoke method on this instance's
   RemoteObject.ref field, with this as the
   first argument, a two-element Object[] as the second
   argument (with id as the first element and
   desc as the second element), and -5274445189091581345L
   as the third argument, and returns the result.  If that invocation
   throws a RuntimeException, RemoteException,
   or an ActivationException, then that exception is
   thrown to the caller.  If that invocation throws any other
   java.lang.Exception, then a
   java.rmi.UnexpectedException is thrown to the caller
   with the original exception as the cause.

  id - an activation identifier - `java.rmi.activation.ActivationID`
  desc - an activation descriptor - `java.rmi.activation.ActivationDesc`

  returns: the result of the invocation - `java.rmi.MarshalledObject`

  throws: java.rmi.RemoteException - if invocation results in a RemoteException"
  (^java.rmi.MarshalledObject [^ActivationGroup_Stub this ^java.rmi.activation.ActivationID id ^java.rmi.activation.ActivationDesc desc]
    (-> this (.newInstance id desc))))

