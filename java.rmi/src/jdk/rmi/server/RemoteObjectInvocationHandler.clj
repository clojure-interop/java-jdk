(ns jdk.rmi.server.RemoteObjectInvocationHandler
  "An implementation of the InvocationHandler interface for
  use with Java Remote Method Invocation (Java RMI).  This invocation
  handler can be used in conjunction with a dynamic proxy instance as a
  replacement for a pregenerated stub class.

  Applications are not expected to use this class directly.  A remote
  object exported to use a dynamic proxy with UnicastRemoteObject
  or Activatable has an instance of this class as that proxy's
  invocation handler."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server RemoteObjectInvocationHandler]))

(defn ->remote-object-invocation-handler
  "Constructor.

  Creates a new RemoteObjectInvocationHandler constructed
   with the specified RemoteRef.

  ref - the remote ref - `java.rmi.server.RemoteRef`

  throws: java.lang.NullPointerException - if ref is null"
  ([ref]
    (new RemoteObjectInvocationHandler ref)))

(defn invoke
  "Processes a method invocation made on the encapsulating
   proxy instance, proxy, and returns the result.

   RemoteObjectInvocationHandler implements this method
   as follows:

   If method is one of the following methods, it
   is processed as described below:



   Object.hashCode: Returns the hash
   code value for the proxy.

   Object.equals: Returns true
   if the argument (args[0]) is an instance of a dynamic
   proxy class and this invocation handler is equal to the invocation
   handler of that argument, and returns false otherwise.

   Object.toString: Returns a string
   representation of the proxy.


   Otherwise, a remote call is made as follows:


   If proxy is not an instance of the interface
   Remote, then an IllegalArgumentException is thrown.

   Otherwise, the invoke method is invoked
   on this invocation handler's RemoteRef, passing
   proxy, method, args, and the
   method hash (defined in section 8.3 of the `Java Remote Method
   Invocation (RMI) Specification`) for method, and the
   result is returned.

   If an exception is thrown by RemoteRef.invoke and
   that exception is a checked exception that is not assignable to any
   exception in the throws clause of the method
   implemented by the proxy's class, then that exception
   is wrapped in an UnexpectedException and the wrapped
   exception is thrown.  Otherwise, the exception thrown by
   invoke is thrown by this method.


   The semantics of this method are unspecified if the
   arguments could not have been produced by an instance of some
   valid dynamic proxy class containing this invocation handler.

  proxy - the proxy instance that the method was invoked on - `java.lang.Object`
  method - the Method instance corresponding to the interface method invoked on the proxy instance - `java.lang.reflect.Method`
  args - an array of objects containing the values of the arguments passed in the method invocation on the proxy instance, or null if the method takes no arguments - `java.lang.Object[]`

  returns: the value to return from the method invocation on the proxy
   instance - `java.lang.Object`

  throws: java.lang.Throwable - the exception to throw from the method invocation on the proxy instance"
  ([this proxy method args]
    (-> this (.invoke proxy method args))))

