(ns javax.activation.UnsupportedDataTypeException
  "Signals that the requested operation does not support the
  requested data type."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation UnsupportedDataTypeException]))

(defn ->unsupported-data-type-exception
  "Constructor.

  Constructs an UnsupportedDataTypeException with the specified
   message.

  s - The detail message. - `java.lang.String`"
  ([s]
    (new UnsupportedDataTypeException s))
  ([]
    (new UnsupportedDataTypeException )))

