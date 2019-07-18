(ns jdk.lang.InternalError
  "Thrown to indicate some unexpected internal error has occurred in
  the Java Virtual Machine."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang InternalError]))

(defn ->internal-error
  "Constructor.

  Constructs an InternalError with the specified detail
   message and cause.  Note that the detail message associated
   with cause is not automatically incorporated in
   this error's detail message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^InternalError [^java.lang.String message ^java.lang.Throwable cause]
    (new InternalError message cause))
  (^InternalError [^java.lang.String message]
    (new InternalError message))
  (^InternalError []
    (new InternalError )))

