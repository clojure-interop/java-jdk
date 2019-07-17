(ns javax.management.openmbean.KeyAlreadyExistsException
  "This runtime exception is thrown to indicate that the index of a row to be added to a tabular data instance
  is already used to refer to another row in this tabular data instance."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.openmbean KeyAlreadyExistsException]))

(defn ->key-already-exists-exception
  "Constructor.

  A KeyAlreadyExistsException with a detail message.

  msg - the detail message. - `java.lang.String`"
  ([^java.lang.String msg]
    (new KeyAlreadyExistsException msg))
  ([]
    (new KeyAlreadyExistsException )))

