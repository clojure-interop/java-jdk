(ns javax.management.openmbean.InvalidKeyException
  "This runtime exception is thrown to indicate that a method parameter which was expected to be
  an item name of a composite data or a row index of a tabular data is not valid."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean InvalidKeyException]))

(defn ->invalid-key-exception
  "Constructor.

  An InvalidKeyException with a detail message.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new InvalidKeyException msg))
  ([]
    (new InvalidKeyException )))

