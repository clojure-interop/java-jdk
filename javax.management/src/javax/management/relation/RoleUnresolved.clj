(ns javax.management.relation.RoleUnresolved
  "Represents an unresolved role: a role not retrieved from a relation due
  to a problem. It provides the role name, value (if problem when trying to
  set the role) and an integer defining the problem (constants defined in
  RoleStatus).

  The serialVersionUID of this class is -48350262537070138L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleUnresolved]))

(defn ->role-unresolved
  "Constructor.

  Constructor.

  name - name of the role - `java.lang.String`
  value - value of the role (if problem when setting the role) - `java.util.List`
  pb-type - type of problem (according to known problem types, listed as static final members). - `int`

  throws: java.lang.IllegalArgumentException - if null parameter or incorrect problem type"
  (^RoleUnresolved [^java.lang.String name ^java.util.List value ^Integer pb-type]
    (new RoleUnresolved name value pb-type)))

(defn get-role-name
  "Retrieves role name.

  returns: the role name. - `java.lang.String`"
  (^java.lang.String [^RoleUnresolved this]
    (-> this (.getRoleName))))

(defn get-role-value
  "Retrieves role value.

  returns: an ArrayList of ObjectName objects, the one provided to be set
   in given role. Null if the unresolved role is returned for a read
   access. - `java.util.List<javax.management.ObjectName>`"
  (^java.util.List [^RoleUnresolved this]
    (-> this (.getRoleValue))))

(defn get-problem-type
  "Retrieves problem type.

  returns: an integer corresponding to a problem, those being described as
   static final members of current class. - `int`"
  (^Integer [^RoleUnresolved this]
    (-> this (.getProblemType))))

(defn set-role-name
  "Sets role name.

  name - the new role name. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^RoleUnresolved this ^java.lang.String name]
    (-> this (.setRoleName name))))

(defn set-role-value
  "Sets role value.

  value - List of ObjectName objects for referenced MBeans not set in role. - `java.util.List`"
  ([^RoleUnresolved this ^java.util.List value]
    (-> this (.setRoleValue value))))

(defn set-problem-type
  "Sets problem type.

  pb-type - integer corresponding to a problem. Must be one of those described as static final members of current class. - `int`

  throws: java.lang.IllegalArgumentException - if incorrect problem type"
  ([^RoleUnresolved this ^Integer pb-type]
    (-> this (.setProblemType pb-type))))

(defn clone
  "Clone this object.

  returns: an independent clone. - `java.lang.Object`"
  (^java.lang.Object [^RoleUnresolved this]
    (-> this (.clone))))

(defn to-string
  "Return a string describing this object.

  returns: a description of this RoleUnresolved object. - `java.lang.String`"
  (^java.lang.String [^RoleUnresolved this]
    (-> this (.toString))))

