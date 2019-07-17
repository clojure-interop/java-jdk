(ns javax.management.relation.RoleNotFoundException
  "This exception is raised when a role in a relation does not exist, or is not
  readable, or is not settable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleNotFoundException]))

(defn ->role-not-found-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([message]
    (new RoleNotFoundException message))
  ([]
    (new RoleNotFoundException )))

