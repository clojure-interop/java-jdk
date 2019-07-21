(ns jdk.rmi.server.ServerCloneException
  "A ServerCloneException is thrown if a remote exception occurs
  during the cloning of a UnicastRemoteObject.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The \"nested exception\"
  that may be provided at construction time and accessed via the public
  detail field is now known as the cause, and may be
  accessed via the Throwable.getCause() method, as well as
  the aforementioned \"legacy field.\"

  Invoking the method Throwable.initCause(Throwable) on an
  instance of ServerCloneException always throws IllegalStateException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.rmi.server ServerCloneException]))

(defn ->server-clone-exception
  "Constructor.

  Constructs a ServerCloneException with the specified
   detail message and cause.

  s - the detail message. - `java.lang.String`
  cause - the cause - `java.lang.Exception`"
  (^ServerCloneException [^java.lang.String s ^java.lang.Exception cause]
    (new ServerCloneException s cause))
  (^ServerCloneException [^java.lang.String s]
    (new ServerCloneException s)))

(defn detail
  "Instance Field.

  The cause of the exception.

   This field predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  type: java.lang.Exception"
  (^java.lang.Exception [^ServerCloneException this]
    (-> this .-detail)))

(defn get-message
  "Returns the detail message, including the message from the cause, if
   any, of this exception.

  returns: the detail message - `java.lang.String`"
  (^java.lang.String [^ServerCloneException this]
    (-> this (.getMessage))))

(defn get-cause
  "Returns the cause of this exception.  This method returns the value
   of the detail field.

  returns: the cause, which may be null. - `java.lang.Throwable`"
  (^java.lang.Throwable [^ServerCloneException this]
    (-> this (.getCause))))

