(ns jdk.lang.reflect.UndeclaredThrowableException
  "Thrown by a method invocation on a proxy instance if its invocation
  handler's invoke method throws a
  checked exception (a Throwable that is not assignable
  to RuntimeException or Error) that
  is not assignable to any of the exception types declared in the
  throws clause of the method that was invoked on the
  proxy instance and dispatched to the invocation handler.

  An UndeclaredThrowableException instance contains
  the undeclared checked exception that was thrown by the invocation
  handler, and it can be retrieved with the
  getUndeclaredThrowable() method.
  UndeclaredThrowableException extends
  RuntimeException, so it is an unchecked exception
  that wraps a checked exception.

  As of release 1.4, this exception has been retrofitted to
  conform to the general purpose exception-chaining mechanism.  The
  \"undeclared checked exception that was thrown by the invocation
  handler\" that may be provided at construction time and accessed via
  the getUndeclaredThrowable() method is now known as the
  cause, and may be accessed via the Throwable.getCause() method, as well as the aforementioned \"legacy
  method.\""
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect UndeclaredThrowableException]))

(defn ->undeclared-throwable-exception
  "Constructor.

  Constructs an UndeclaredThrowableException with the
   specified Throwable and a detail message.

  undeclared-throwable - the undeclared checked exception that was thrown - `java.lang.Throwable`
  s - the detail message - `java.lang.String`"
  (^UndeclaredThrowableException [^java.lang.Throwable undeclared-throwable ^java.lang.String s]
    (new UndeclaredThrowableException undeclared-throwable s))
  (^UndeclaredThrowableException [^java.lang.Throwable undeclared-throwable]
    (new UndeclaredThrowableException undeclared-throwable)))

(defn get-undeclared-throwable
  "Returns the Throwable instance wrapped in this
   UndeclaredThrowableException, which may be null.

   This method predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  returns: the undeclared checked exception that was thrown - `java.lang.Throwable`"
  (^java.lang.Throwable [^UndeclaredThrowableException this]
    (-> this (.getUndeclaredThrowable))))

(defn get-cause
  "Returns the cause of this exception (the Throwable
   instance wrapped in this UndeclaredThrowableException,
   which may be null).

  returns: the cause of this exception. - `java.lang.Throwable`"
  (^java.lang.Throwable [^UndeclaredThrowableException this]
    (-> this (.getCause))))

