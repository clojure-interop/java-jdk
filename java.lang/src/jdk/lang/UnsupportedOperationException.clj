(ns jdk.lang.UnsupportedOperationException
  "Thrown to indicate that the requested operation is not supported.

  This class is a member of the

  Java Collections Framework."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang UnsupportedOperationException]))

(defn ->unsupported-operation-exception
  "Constructor.

  Constructs a new exception with the specified detail message and
   cause.

   Note that the detail message associated with cause is
   not automatically incorporated in this exception's detail
   message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^UnsupportedOperationException [^java.lang.String message ^java.lang.Throwable cause]
    (new UnsupportedOperationException message cause))
  (^UnsupportedOperationException [^java.lang.String message]
    (new UnsupportedOperationException message))
  (^UnsupportedOperationException []
    (new UnsupportedOperationException )))

