(ns jdk.lang.ReflectiveOperationException
  "Common superclass of exceptions thrown by reflective operations in
  core reflection."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ReflectiveOperationException]))

(defn ->reflective-operation-exception
  "Constructor.

  Constructs a new exception with the specified detail message
   and cause.

   Note that the detail message associated with
   cause is not automatically incorporated in
   this exception's detail message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^ReflectiveOperationException [^java.lang.String message ^java.lang.Throwable cause]
    (new ReflectiveOperationException message cause))
  (^ReflectiveOperationException [^java.lang.String message]
    (new ReflectiveOperationException message))
  (^ReflectiveOperationException []
    (new ReflectiveOperationException )))

