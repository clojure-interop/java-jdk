(ns jdk.lang.RuntimeException
  "RuntimeException is the superclass of those
  exceptions that can be thrown during the normal operation of the
  Java Virtual Machine.

  RuntimeException and its subclasses are unchecked
  exceptions.  Unchecked exceptions do not need to be
  declared in a method or constructor's throws clause if they
  can be thrown by the execution of the method or constructor and
  propagate outside the method or constructor boundary."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang RuntimeException]))

(defn ->runtime-exception
  "Constructor.

  Constructs a new runtime exception with the specified detail message and
   cause.  Note that the detail message associated with
   cause is not automatically incorporated in
   this runtime exception's detail message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([message cause]
    (new RuntimeException message cause))
  ([message]
    (new RuntimeException message))
  ([]
    (new RuntimeException )))

