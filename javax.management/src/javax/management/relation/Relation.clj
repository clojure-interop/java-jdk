(ns javax.management.relation.Relation
  "This interface has to be implemented by any MBean class expected to
  represent a relation managed using the Relation Service.
  Simple relations, i.e. having only roles, no properties or methods, can
  be created directly by the Relation Service (represented as RelationSupport
  objects, internally handled by the Relation Service).
  If the user wants to represent more complex relations, involving
  properties and/or methods, he has to provide his own class implementing the
  Relation interface. This can be achieved either by inheriting from
  RelationSupport class, or by implementing the interface (fully or delegation to
  a RelationSupport object member).
  Specifying such user relation class is to introduce properties and/or
  methods. Those have to be exposed for remote management. So this means that
  any user relation class must be a MBean class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation Relation]))

(defn get-roles
  "Retrieves values of roles with given names.
   Checks for each role if it exists and is readable according to the
   relation type.

  role-name-array - array of names of roles to be retrieved - `java.lang.String[]`

  returns: a RoleResult object, including a RoleList (for roles
   successfully retrieved) and a RoleUnresolvedList (for roles not
   retrieved). - `javax.management.relation.RoleResult`

  throws: java.lang.IllegalArgumentException - if null role name"
  ([^. this ^java.lang.String[] role-name-array]
    (-> this (.getRoles role-name-array))))

(defn get-relation-type-name
  "Returns name of associated relation type.

  returns: the name of the relation type. - `java.lang.String`"
  ([^. this]
    (-> this (.getRelationTypeName))))

(defn get-role
  "Retrieves role value for given role name.
   Checks if the role exists and is readable according to the relation
   type.

  role-name - name of role - `java.lang.String`

  returns: the ArrayList of ObjectName objects being the role value - `java.util.List<javax.management.ObjectName>`

  throws: java.lang.IllegalArgumentException - if null role name"
  ([^. this ^java.lang.String role-name]
    (-> this (.getRole role-name))))

(defn retrieve-all-roles
  "Returns all roles in the relation without checking read mode.

  returns: a RoleList. - `javax.management.relation.RoleList`"
  ([^. this]
    (-> this (.retrieveAllRoles))))

(defn get-role-cardinality
  "Returns the number of MBeans currently referenced in the given role.

  role-name - name of role - `java.lang.String`

  returns: the number of currently referenced MBeans in that role - `java.lang.Integer`

  throws: java.lang.IllegalArgumentException - if null role name"
  ([^. this ^java.lang.String role-name]
    (-> this (.getRoleCardinality role-name))))

(defn get-all-roles
  "Returns all roles present in the relation.

  returns: a RoleResult object, including a RoleList (for roles
   successfully retrieved) and a RoleUnresolvedList (for roles not
   readable). - `javax.management.relation.RoleResult`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  ([^. this]
    (-> this (.getAllRoles))))

(defn set-role
  "Sets the given role.
   Will check the role according to its corresponding role definition
   provided in relation's relation type
   Will send a notification (RelationNotification with type
   RELATION_BASIC_UPDATE or RELATION_MBEAN_UPDATE, depending if the
   relation is a MBean or not).

  role - role to be set (name and new value) - `javax.management.relation.Role`

  throws: java.lang.IllegalArgumentException - if null role"
  ([^. this ^javax.management.relation.Role role]
    (-> this (.setRole role))))

(defn get-relation-id
  "Returns relation identifier (used to uniquely identify the relation
   inside the Relation Service).

  returns: the relation id. - `java.lang.String`"
  ([^. this]
    (-> this (.getRelationId))))

(defn get-referenced-m-beans
  "Retrieves MBeans referenced in the various roles of the relation.

  returns: a HashMap mapping:
    ObjectName -> ArrayList of String (role names) - `java.util.Map<javax.management.ObjectName,java.util.List<java.lang.String>>`"
  ([^. this]
    (-> this (.getReferencedMBeans))))

(defn set-roles
  "Sets the given roles.
   Will check the role according to its corresponding role definition
   provided in relation's relation type
   Will send one notification (RelationNotification with type
   RELATION_BASIC_UPDATE or RELATION_MBEAN_UPDATE, depending if the
   relation is a MBean or not) per updated role.

  role-list - list of roles to be set - `javax.management.relation.RoleList`

  returns: a RoleResult object, including a RoleList (for roles
   successfully set) and a RoleUnresolvedList (for roles not
   set). - `javax.management.relation.RoleResult`

  throws: java.lang.IllegalArgumentException - if null role list"
  ([^. this ^javax.management.relation.RoleList role-list]
    (-> this (.setRoles role-list))))

(defn get-relation-service-name
  "Returns ObjectName of the Relation Service handling the relation.

  returns: the ObjectName of the Relation Service. - `javax.management.ObjectName`"
  ([^. this]
    (-> this (.getRelationServiceName))))

(defn handle-m-bean-unregistration
  "Callback used by the Relation Service when a MBean referenced in a role
   is unregistered.
   The Relation Service will call this method to let the relation
   take action to reflect the impact of such unregistration.
   BEWARE. the user is not expected to call this method.
   Current implementation is to set the role with its current value
   (list of ObjectNames of referenced MBeans) without the unregistered
   one.

  object-name - ObjectName of unregistered MBean - `javax.management.ObjectName`
  role-name - name of role where the MBean is referenced - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^. this ^javax.management.ObjectName object-name ^java.lang.String role-name]
    (-> this (.handleMBeanUnregistration object-name role-name))))

