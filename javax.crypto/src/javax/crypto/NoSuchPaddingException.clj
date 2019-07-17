(ns javax.crypto.NoSuchPaddingException
  "This exception is thrown when a particular padding mechanism is
  requested but is not available in the environment."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto NoSuchPaddingException]))

(defn ->no-such-padding-exception
  "Constructor.

  Constructs a NoSuchPaddingException with the specified
   detail message.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new NoSuchPaddingException msg))
  ([]
    (new NoSuchPaddingException )))

