(ns jdk.lang.Exception
  "The class Exception and its subclasses are a form of
  Throwable that indicates conditions that a reasonable
  application might want to catch.

  The class Exception and any subclasses that are not also
  subclasses of RuntimeException are checked
  exceptions.  Checked exceptions need to be declared in a
  method or constructor's throws clause if they can be thrown
  by the execution of the method or constructor and propagate outside
  the method or constructor boundary."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Exception]))

(defn ->exception
  "Constructor.

  Constructs a new exception with the specified detail message and
   cause.  Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new Exception message cause))
  ([message]
    (new Exception message))
  ([]
    (new Exception )))

