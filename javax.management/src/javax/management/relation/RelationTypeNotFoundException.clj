(ns javax.management.relation.RelationTypeNotFoundException
  "This exception is raised when there is no relation type with given name in
  Relation Service."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationTypeNotFoundException]))

(defn ->relation-type-not-found-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new RelationTypeNotFoundException message))
  ([]
    (new RelationTypeNotFoundException )))

