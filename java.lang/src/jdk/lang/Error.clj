(ns jdk.lang.Error
  "An Error is a subclass of Throwable
  that indicates serious problems that a reasonable application
  should not try to catch. Most such errors are abnormal conditions.
  The ThreadDeath error, though a \"normal\" condition,
  is also a subclass of Error because most applications
  should not try to catch it.

  A method is not required to declare in its throws
  clause any subclasses of Error that might be thrown
  during the execution of the method but not caught, since these
  errors are abnormal conditions that should never occur.

  That is, Error and its subclasses are regarded as unchecked
  exceptions for the purposes of compile-time checking of exceptions."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Error]))

(defn ->error
  "Constructor.

  Constructs a new error with the specified detail message and
   cause.  Note that the detail message associated with
   cause is not automatically incorporated in
   this error's detail message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^Error [^java.lang.String message ^java.lang.Throwable cause]
    (new Error message cause))
  (^Error [^java.lang.String message]
    (new Error message))
  (^Error []
    (new Error )))

