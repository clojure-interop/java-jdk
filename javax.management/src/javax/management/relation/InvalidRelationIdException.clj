(ns javax.management.relation.InvalidRelationIdException
  "This exception is raised when relation id provided for a relation is already
  used."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation InvalidRelationIdException]))

(defn ->invalid-relation-id-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new InvalidRelationIdException message))
  ([]
    (new InvalidRelationIdException )))

