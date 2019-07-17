(ns javax.crypto.IllegalBlockSizeException
  "This exception is thrown when the length of data provided to a block
  cipher is incorrect, i.e., does not match the block size of the cipher."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto IllegalBlockSizeException]))

(defn ->illegal-block-size-exception
  "Constructor.

  Constructs an IllegalBlockSizeException with the specified
   detail message.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new IllegalBlockSizeException msg))
  ([]
    (new IllegalBlockSizeException )))

