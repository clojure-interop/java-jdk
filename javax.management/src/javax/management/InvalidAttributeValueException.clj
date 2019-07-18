(ns javax.management.InvalidAttributeValueException
  "The value specified is not valid for the attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management InvalidAttributeValueException]))

(defn ->invalid-attribute-value-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - the detail message. - `java.lang.String`"
  (^InvalidAttributeValueException [^java.lang.String message]
    (new InvalidAttributeValueException message))
  (^InvalidAttributeValueException []
    (new InvalidAttributeValueException )))

