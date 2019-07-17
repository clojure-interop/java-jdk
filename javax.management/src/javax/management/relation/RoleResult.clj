(ns javax.management.relation.RoleResult
  "Represents the result of a multiple access to several roles of a relation
  (either for reading or writing).

  The serialVersionUID of this class is -6304063118040985512L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleResult]))

(defn ->role-result
  "Constructor.

  Constructor.

  list - list of roles successfully accessed. - `javax.management.relation.RoleList`
  unresolved-list - list of roles not accessed (with problem descriptions). - `javax.management.relation.RoleUnresolvedList`"
  ([list unresolved-list]
    (new RoleResult list unresolved-list)))

(defn get-roles
  "Retrieves list of roles successfully accessed.

  returns: a RoleList - `javax.management.relation.RoleList`"
  ([this]
    (-> this (.getRoles))))

(defn get-roles-unresolved
  "Retrieves list of roles unsuccessfully accessed.

  returns: a RoleUnresolvedList. - `javax.management.relation.RoleUnresolvedList`"
  ([this]
    (-> this (.getRolesUnresolved))))

(defn set-roles
  "Sets list of roles successfully accessed.

  list - list of roles successfully accessed - `javax.management.relation.RoleList`"
  ([this list]
    (-> this (.setRoles list))))

(defn set-roles-unresolved
  "Sets list of roles unsuccessfully accessed.

  unresolved-list - list of roles unsuccessfully accessed - `javax.management.relation.RoleUnresolvedList`"
  ([this unresolved-list]
    (-> this (.setRolesUnresolved unresolved-list))))

