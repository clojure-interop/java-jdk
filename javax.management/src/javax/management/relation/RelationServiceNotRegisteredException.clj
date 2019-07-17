(ns javax.management.relation.RelationServiceNotRegisteredException
  "This exception is raised when an access is done to the Relation Service and
  that one is not registered."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationServiceNotRegisteredException]))

(defn ->relation-service-not-registered-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new RelationServiceNotRegisteredException message))
  ([]
    (new RelationServiceNotRegisteredException )))

