(ns javax.management.relation.InvalidRelationTypeException
  "Invalid relation type.
  This exception is raised when, in a relation type, there is already a
  relation type with that name, or the same name has been used for two
  different role infos, or no role info provided, or one null role info
  provided."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation InvalidRelationTypeException]))

(defn ->invalid-relation-type-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new InvalidRelationTypeException message))
  ([]
    (new InvalidRelationTypeException )))

