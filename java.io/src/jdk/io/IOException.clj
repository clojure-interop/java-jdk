(ns jdk.io.IOException
  "Signals that an I/O exception of some sort has occurred. This
  class is the general class of exceptions produced by failed or
  interrupted I/O operations."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io IOException]))

(defn ->io-exception
  "Constructor.

  Constructs an IOException with the specified detail message
   and cause.

    Note that the detail message associated with cause is
   not automatically incorporated into this exception's detail
   message.

  message - The detail message (which is saved for later retrieval by the Throwable.getMessage() method) - `java.lang.String`
  cause - The cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) - `java.lang.Throwable`"
  ([^java.lang.String message ^java.lang.Throwable cause]
    (new IOException message cause))
  ([^java.lang.String message]
    (new IOException message))
  ([]
    (new IOException )))

