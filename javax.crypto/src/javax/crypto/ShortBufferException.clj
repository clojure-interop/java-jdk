(ns javax.crypto.ShortBufferException
  "This exception is thrown when an output buffer provided by the user
  is too short to hold the operation result."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto ShortBufferException]))

(defn ->short-buffer-exception
  "Constructor.

  Constructs a ShortBufferException with the specified
   detail message.

  msg - the detail message. - `java.lang.String`"
  (^ShortBufferException [^java.lang.String msg]
    (new ShortBufferException msg))
  (^ShortBufferException []
    (new ShortBufferException )))

