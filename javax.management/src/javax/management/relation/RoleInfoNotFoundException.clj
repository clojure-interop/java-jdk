(ns javax.management.relation.RoleInfoNotFoundException
  "This exception is raised when there is no role info with given name in a
  given relation type."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleInfoNotFoundException]))

(defn ->role-info-not-found-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  (^RoleInfoNotFoundException [^java.lang.String message]
    (new RoleInfoNotFoundException message))
  (^RoleInfoNotFoundException []
    (new RoleInfoNotFoundException )))

