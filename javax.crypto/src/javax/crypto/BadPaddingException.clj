(ns javax.crypto.BadPaddingException
  "This exception is thrown when a particular padding mechanism is
  expected for the input data but the data is not padded properly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.crypto BadPaddingException]))

(defn ->bad-padding-exception
  "Constructor.

  Constructs a BadPaddingException with the specified
   detail message.

  msg - the detail message. - `java.lang.String`"
  ([msg]
    (new BadPaddingException msg))
  ([]
    (new BadPaddingException )))

