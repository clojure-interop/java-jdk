(ns javax.management.relation.Role
  "Represents a role: includes a role name and referenced MBeans (via their
  ObjectNames). The role value is always represented as an ArrayList
  collection (of ObjectNames) to homogenize the access.

  The serialVersionUID of this class is -279985518429862552L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation Role]))

(defn ->role
  "Constructor.

  Make a new Role object.
   No check is made that the ObjectNames in the role value exist in
   an MBean server.  That check will be made when the role is set
   in a relation.

  role-name - role name - `java.lang.String`
  role-value - role value (List of ObjectName objects) - `java.util.List`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^Role [^java.lang.String role-name ^java.util.List role-value]
    (new Role role-name role-value)))

(defn *role-value-to-string
  "Returns a string for the given role value.

  role-value - List of ObjectName objects - `java.util.List`

  returns: A String consisting of the ObjectNames separated by
   newlines (\\n). - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.lang.String [^java.util.List role-value]
    (Role/roleValueToString role-value)))

(defn get-role-name
  "Retrieves role name.

  returns: the role name. - `java.lang.String`"
  (^java.lang.String [^Role this]
    (-> this (.getRoleName))))

(defn get-role-value
  "Retrieves role value.

  returns: ArrayList of ObjectName objects for referenced MBeans. - `java.util.List<javax.management.ObjectName>`"
  (^java.util.List [^Role this]
    (-> this (.getRoleValue))))

(defn set-role-name
  "Sets role name.

  role-name - role name - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^Role this ^java.lang.String role-name]
    (-> this (.setRoleName role-name))))

(defn set-role-value
  "Sets role value.

  role-value - List of ObjectName objects for referenced MBeans. - `java.util.List`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^Role this ^java.util.List role-value]
    (-> this (.setRoleValue role-value))))

(defn to-string
  "Returns a string describing the role.

  returns: the description of the role. - `java.lang.String`"
  (^java.lang.String [^Role this]
    (-> this (.toString))))

(defn clone
  "Clone the role object.

  returns: a Role that is an independent copy of the current Role object. - `java.lang.Object`"
  (^java.lang.Object [^Role this]
    (-> this (.clone))))

