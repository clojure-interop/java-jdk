(ns jdk.rmi.RemoteException
  "A RemoteException is the common superclass for a number of
  communication-related exceptions that may occur during the execution of a
  remote method call.  Each method of a remote interface, an interface that
  extends java.rmi.Remote, must list
  RemoteException in its throws clause.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The `wrapped remote
  exception` that may be provided at construction time and accessed via
  the public detail field is now known as the cause, and
  may be accessed via the Throwable.getCause() method, as well as
  the aforementioned `legacy field.`

  Invoking the method Throwable.initCause(Throwable) on an
  instance of RemoteException always throws IllegalStateException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi RemoteException]))

(defn ->remote-exception
  "Constructor.

  Constructs a RemoteException with the specified detail
   message and cause.  This constructor sets the detail
   field to the specified Throwable.

  s - the detail message - `java.lang.String`
  cause - the cause - `java.lang.Throwable`"
  (^RemoteException [^java.lang.String s ^java.lang.Throwable cause]
    (new RemoteException s cause))
  (^RemoteException [^java.lang.String s]
    (new RemoteException s))
  (^RemoteException []
    (new RemoteException )))

(defn -detail
  "Instance Field.

  The cause of the remote exception.

   This field predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  type: java.lang.Throwable"
  [this]
  (-> this .-detail))

(defn get-message
  "Returns the detail message, including the message from the cause, if
   any, of this exception.

  returns: the detail message - `java.lang.String`"
  (^java.lang.String [^RemoteException this]
    (-> this (.getMessage))))

(defn get-cause
  "Returns the cause of this exception.  This method returns the value
   of the detail field.

  returns: the cause, which may be null. - `java.lang.Throwable`"
  (^java.lang.Throwable [^RemoteException this]
    (-> this (.getCause))))

