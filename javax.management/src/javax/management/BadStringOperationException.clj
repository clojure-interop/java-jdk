(ns javax.management.BadStringOperationException
  "Thrown when an invalid string operation is passed
  to a method for constructing a query."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management BadStringOperationException]))

(defn ->bad-string-operation-exception
  "Constructor.

  Constructs a BadStringOperationException with the specified detail
   message.

  message - the detail message. - `java.lang.String`"
  (^BadStringOperationException [^java.lang.String message]
    (new BadStringOperationException message)))

(defn to-string
  "Returns the string representing the object.

  returns: a string representation of this throwable. - `java.lang.String`"
  (^java.lang.String [^BadStringOperationException this]
    (-> this (.toString))))

