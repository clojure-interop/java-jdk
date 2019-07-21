(ns jdk.lang.ExceptionInInitializerError
  "Signals that an unexpected exception has occurred in a static initializer.
  An ExceptionInInitializerError is thrown to indicate that an
  exception occurred during evaluation of a static initializer or the
  initializer for a static variable.

  As of release 1.4, this exception has been retrofitted to conform to
  the general purpose exception-chaining mechanism.  The \"saved throwable
  object\" that may be provided at construction time and accessed via
  the getException() method is now known as the cause,
  and may be accessed via the Throwable.getCause() method, as well
  as the aforementioned \"legacy method.\""
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ExceptionInInitializerError]))

(defn ->exception-in-initializer-error
  "Constructor.

  Constructs a new ExceptionInInitializerError class by
   saving a reference to the Throwable object thrown for
   later retrieval by the getException() method. The detail
   message string is set to null.

  thrown - The exception thrown - `java.lang.Throwable`"
  (^ExceptionInInitializerError [^java.lang.Throwable thrown]
    (new ExceptionInInitializerError thrown))
  (^ExceptionInInitializerError []
    (new ExceptionInInitializerError )))

(defn get-exception
  "Returns the exception that occurred during a static initialization that
   caused this error to be created.

   This method predates the general-purpose exception chaining facility.
   The Throwable.getCause() method is now the preferred means of
   obtaining this information.

  returns: the saved throwable object of this
           ExceptionInInitializerError, or null
           if this ExceptionInInitializerError has no saved
           throwable object. - `java.lang.Throwable`"
  (^java.lang.Throwable [^ExceptionInInitializerError this]
    (-> this (.getException))))

(defn get-cause
  "Returns the cause of this error (the exception that occurred
   during a static initialization that caused this error to be created).

  returns: the cause of this error or null if the
            cause is nonexistent or unknown. - `java.lang.Throwable`"
  (^java.lang.Throwable [^ExceptionInInitializerError this]
    (-> this (.getCause))))

