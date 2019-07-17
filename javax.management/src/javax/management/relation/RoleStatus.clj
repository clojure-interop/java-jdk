(ns javax.management.relation.RoleStatus
  "This class describes the various problems which can be encountered when
  accessing a role."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleStatus]))

(defn ->role-status
  "Constructor."
  ([]
    (new RoleStatus )))

(def *-no-role-with-name
  "Static Constant.

  Problem type when trying to access an unknown role.

  type: int"
  RoleStatus/NO_ROLE_WITH_NAME)

(def *-role-not-readable
  "Static Constant.

  Problem type when trying to read a non-readable attribute.

  type: int"
  RoleStatus/ROLE_NOT_READABLE)

(def *-role-not-writable
  "Static Constant.

  Problem type when trying to update a non-writable attribute.

  type: int"
  RoleStatus/ROLE_NOT_WRITABLE)

(def *-less-than-min-role-degree
  "Static Constant.

  Problem type when trying to set a role value with less ObjectNames than
   the minimum expected cardinality.

  type: int"
  RoleStatus/LESS_THAN_MIN_ROLE_DEGREE)

(def *-more-than-max-role-degree
  "Static Constant.

  Problem type when trying to set a role value with more ObjectNames than
   the maximum expected cardinality.

  type: int"
  RoleStatus/MORE_THAN_MAX_ROLE_DEGREE)

(def *-ref-mbean-of-incorrect-class
  "Static Constant.

  Problem type when trying to set a role value including the ObjectName of
   a MBean not of the class expected for that role.

  type: int"
  RoleStatus/REF_MBEAN_OF_INCORRECT_CLASS)

(def *-ref-mbean-not-registered
  "Static Constant.

  Problem type when trying to set a role value including the ObjectName of
   a MBean not registered in the MBean Server.

  type: int"
  RoleStatus/REF_MBEAN_NOT_REGISTERED)

(defn *role-status?
  "Returns true if given value corresponds to a known role status, false
   otherwise.

  status - a status code. - `int`

  returns: true if this value is a known role status. - `boolean`"
  (^Boolean [^Integer status]
    (RoleStatus/isRoleStatus status)))

