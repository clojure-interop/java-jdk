(ns jdk.lang.reflect.InvocationTargetException
  "InvocationTargetException is a checked exception that wraps
  an exception thrown by an invoked method or constructor.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The `target exception`
  that is provided at construction time and accessed via the
  getTargetException() method is now known as the cause,
  and may be accessed via the Throwable.getCause() method,
  as well as the aforementioned `legacy method.`"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect InvocationTargetException]))

(defn ->invocation-target-exception
  "Constructor.

  Constructs a InvocationTargetException with a target exception
   and a detail message.

  target - the target exception - `java.lang.Throwable`
  s - the detail message - `java.lang.String`"
  ([^java.lang.Throwable target ^java.lang.String s]
    (new InvocationTargetException target s))
  ([^java.lang.Throwable target]
    (new InvocationTargetException target)))

(defn get-target-exception
  "Get the thrown target exception.

   This method predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  returns: the thrown target exception (cause of this exception). - `java.lang.Throwable`"
  ([^java.lang.reflect.InvocationTargetException this]
    (-> this (.getTargetException))))

(defn get-cause
  "Returns the cause of this exception (the thrown target exception,
   which may be null).

  returns: the cause of this exception. - `java.lang.Throwable`"
  ([^java.lang.reflect.InvocationTargetException this]
    (-> this (.getCause))))

