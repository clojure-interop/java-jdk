(ns javax.management.relation.RelationNotFoundException
  "This exception is raised when there is no relation for a given relation id
  in a Relation Service."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationNotFoundException]))

(defn ->relation-not-found-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  (^RelationNotFoundException [^java.lang.String message]
    (new RelationNotFoundException message))
  (^RelationNotFoundException []
    (new RelationNotFoundException )))

