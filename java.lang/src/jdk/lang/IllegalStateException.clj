(ns jdk.lang.IllegalStateException
  "Signals that a method has been invoked at an illegal or
  inappropriate time.  In other words, the Java environment or
  Java application is not in an appropriate state for the requested
  operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IllegalStateException]))

(defn ->illegal-state-exception
  "Constructor.

  Constructs a new exception with the specified detail message and
   cause.

   Note that the detail message associated with cause is
   not automatically incorporated in this exception's detail
   message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new IllegalStateException message cause))
  ([s]
    (new IllegalStateException s))
  ([]
    (new IllegalStateException )))

