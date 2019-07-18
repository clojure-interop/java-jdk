(ns jdk.security.PrivilegedActionException
  "This exception is thrown by
  doPrivileged(PrivilegedExceptionAction) and
  doPrivileged(PrivilegedExceptionAction,
  AccessControlContext context) to indicate
  that the action being performed threw a checked exception.  The exception
  thrown by the action can be obtained by calling the
  getException method.  In effect, an
  PrivilegedActionException is a `wrapper`
  for an exception thrown by a privileged action.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The `exception thrown
  by the privileged computation` that is provided at construction time and
  accessed via the getException() method is now known as the
  cause, and may be accessed via the Throwable.getCause()
  method, as well as the aforementioned `legacy method.`"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security PrivilegedActionException]))

(defn ->privileged-action-exception
  "Constructor.

  Constructs a new PrivilegedActionException `wrapping`
   the specific Exception.

  exception - The exception thrown - `java.lang.Exception`"
  (^PrivilegedActionException [^java.lang.Exception exception]
    (new PrivilegedActionException exception)))

(defn get-exception
  "Returns the exception thrown by the privileged computation that
   resulted in this PrivilegedActionException.

   This method predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  returns: the exception thrown by the privileged computation that
           resulted in this PrivilegedActionException. - `java.lang.Exception`"
  (^java.lang.Exception [^PrivilegedActionException this]
    (-> this (.getException))))

(defn get-cause
  "Returns the cause of this exception (the exception thrown by
   the privileged computation that resulted in this
   PrivilegedActionException).

  returns: the cause of this exception. - `java.lang.Throwable`"
  (^java.lang.Throwable [^PrivilegedActionException this]
    (-> this (.getCause))))

(defn to-string
  "Description copied from class: Throwable

  returns: a string representation of this throwable. - `java.lang.String`"
  (^java.lang.String [^PrivilegedActionException this]
    (-> this (.toString))))

