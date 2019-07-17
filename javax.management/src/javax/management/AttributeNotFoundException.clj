(ns javax.management.AttributeNotFoundException
  "The specified attribute does not exist or cannot be retrieved."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management AttributeNotFoundException]))

(defn ->attribute-not-found-exception
  "Constructor.

  Constructor that allows a specific error message to be specified.

  message - detail message. - `java.lang.String`"
  ([message]
    (new AttributeNotFoundException message))
  ([]
    (new AttributeNotFoundException )))

