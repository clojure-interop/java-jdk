(ns javax.management.relation.InvalidRoleInfoException
  "This exception is raised when, in a role info, its minimum degree is greater
  than its maximum degree."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation InvalidRoleInfoException]))

(defn ->invalid-role-info-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  (^InvalidRoleInfoException [^java.lang.String message]
    (new InvalidRoleInfoException message))
  (^InvalidRoleInfoException []
    (new InvalidRoleInfoException )))

