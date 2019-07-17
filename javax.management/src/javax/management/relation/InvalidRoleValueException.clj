(ns javax.management.relation.InvalidRoleValueException
  "Role value is invalid.
  This exception is raised when, in a role, the number of referenced MBeans
  in given value is less than expected minimum degree, or the number of
  referenced MBeans in provided value exceeds expected maximum degree, or
  one referenced MBean in the value is not an Object of the MBean
  class expected for that role, or an MBean provided for that role does not
  exist."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation InvalidRoleValueException]))

(defn ->invalid-role-value-exception
  "Constructor.

  Constructor with given message put in exception.

  message - the detail message. - `java.lang.String`"
  ([^java.lang.String message]
    (new InvalidRoleValueException message))
  ([]
    (new InvalidRoleValueException )))

