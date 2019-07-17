(ns jdk.io.IOError
  "Thrown when a serious I/O error has occurred."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io IOError]))

(defn ->io-error
  "Constructor.

  Constructs a new instance of IOError with the specified cause. The
   IOError is created with the detail message of
   (cause==null ? null : cause.toString()) (which typically
   contains the class and detail message of cause).

  cause - The cause of this error, or null if the cause is not known - `java.lang.Throwable`"
  ([cause]
    (new IOError cause)))

