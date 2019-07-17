(ns javax.management.relation.InvalidRelationServiceException
  "This exception is raised when an invalid Relation Service is provided."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation InvalidRelationServiceException]))

(defn ->invalid-relation-service-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new InvalidRelationServiceException message))
  ([]
    (new InvalidRelationServiceException )))

