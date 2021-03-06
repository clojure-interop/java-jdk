(ns jdk.lang.IllegalArgumentException
  "Thrown to indicate that a method has been passed an illegal or
  inappropriate argument."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang IllegalArgumentException]))

(defn ->illegal-argument-exception
  "Constructor.

  Constructs a new exception with the specified detail message and
   cause.

   Note that the detail message associated with cause is
   not automatically incorporated in this exception's detail
   message.

  message - the detail message (which is saved for later retrieval by the Throwable.getMessage() method). - `java.lang.String`
  cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  (^IllegalArgumentException [^java.lang.String message ^java.lang.Throwable cause]
    (new IllegalArgumentException message cause))
  (^IllegalArgumentException [^java.lang.String s]
    (new IllegalArgumentException s))
  (^IllegalArgumentException []
    (new IllegalArgumentException )))

