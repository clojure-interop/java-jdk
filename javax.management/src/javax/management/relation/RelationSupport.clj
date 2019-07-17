(ns javax.management.relation.RelationSupport
  "A RelationSupport object is used internally by the Relation Service to
  represent simple relations (only roles, no properties or methods), with an
  unlimited number of roles, of any relation type. As internal representation,
  it is not exposed to the user.
  RelationSupport class conforms to the design patterns of standard MBean. So
  the user can decide to instantiate a RelationSupport object himself as
  a MBean (as it follows the MBean design patterns), to register it in the
  MBean Server, and then to add it in the Relation Service.
  The user can also, when creating his own MBean relation class, have it
  extending RelationSupport, to retrieve the implementations of required
  interfaces (see below).
  It is also possible to have in a user relation MBean class a member
  being a RelationSupport object, and to implement the required interfaces by
  delegating all to this member.
   RelationSupport implements the Relation interface (to be handled by the
  Relation Service).
  It implements also the MBeanRegistration interface to be able to retrieve
  the MBean Server where it is registered (if registered as a MBean) to access
  to its Relation Service."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationSupport]))

(defn ->relation-support
  "Constructor.

  Creates a RelationSupport object.
   This constructor has to be used when the user relation MBean
   implements the interfaces expected to be supported by a relation by
   delegating to a RelationSupport object.
   This object needs to know the Relation Service expected to handle the
   relation. So it has to know the MBean Server where the Relation Service
   is registered.
   According to a limitation, a relation MBean must be registered in the
   same MBean Server as the Relation Service expected to handle it. So the
   user relation MBean has to be created and registered, and then the
   wrapped RelationSupport object can be created within the identified MBean
   Server.
   Nothing is done at the Relation Service level, i.e.
   the RelationSupport object is not added to the
   RelationService and no checks are performed to
   see if the provided values are correct.
   The object is always created, EXCEPT if:
   - any of the required parameters is null.
   - the same name is used for two roles.
   To be handled as a relation, the RelationSupport object has
   to be added to the Relation Service using the Relation Service method
   addRelation().

  relation-id - relation identifier, to identify the relation in the Relation Service. Expected to be unique in the given Relation Service. - `java.lang.String`
  relation-service-name - ObjectName of the Relation Service where the relation will be registered. This parameter is required as it is the Relation Service that is aware of the definition of the relation type of the given relation, so that will be able to check update operations (set). - `javax.management.ObjectName`
  relation-service-m-bean-server - MBean Server where the wrapping MBean is or will be registered. Expected to be the MBean Server where the Relation Service is or will be registered. - `javax.management.MBeanServer`
  relation-type-name - Name of relation type. Expected to have been created in the given Relation Service. - `java.lang.String`
  list - list of roles (Role objects) to initialize the relation. Can be null. Expected to conform to relation info in associated relation type. - `javax.management.relation.RoleList`

  throws: javax.management.relation.InvalidRoleValueException - if the same name is used for two roles."
  ([relation-id relation-service-name relation-service-m-bean-server relation-type-name list]
    (new RelationSupport relation-id relation-service-name relation-service-m-bean-server relation-type-name list))
  ([relation-id relation-service-name relation-type-name list]
    (new RelationSupport relation-id relation-service-name relation-type-name list)))

(defn get-roles
  "Retrieves values of roles with given names.
   Checks for each role if it exists and is readable according to the
   relation type.

  role-name-array - array of names of roles to be retrieved - `java.lang.String[]`

  returns: a RoleResult object, including a RoleList (for roles
   successfully retrieved) and a RoleUnresolvedList (for roles not
   retrieved). - `javax.management.relation.RoleResult`

  throws: java.lang.IllegalArgumentException - if null role name"
  ([this role-name-array]
    (-> this (.getRoles role-name-array))))

(defn get-relation-type-name
  "Returns name of associated relation type.

  returns: the name of the relation type. - `java.lang.String`"
  ([this]
    (-> this (.getRelationTypeName))))

(defn get-role
  "Retrieves role value for given role name.
   Checks if the role exists and is readable according to the relation
   type.

  role-name - name of role - `java.lang.String`

  returns: the ArrayList of ObjectName objects being the role value - `java.util.List<javax.management.ObjectName>`

  throws: java.lang.IllegalArgumentException - if null role name"
  ([this role-name]
    (-> this (.getRole role-name))))

(defn retrieve-all-roles
  "Returns all roles in the relation without checking read mode.

  returns: a RoleList - `javax.management.relation.RoleList`"
  ([this]
    (-> this (.retrieveAllRoles))))

(defn get-role-cardinality
  "Returns the number of MBeans currently referenced in the given role.

  role-name - name of role - `java.lang.String`

  returns: the number of currently referenced MBeans in that role - `java.lang.Integer`

  throws: java.lang.IllegalArgumentException - if null role name"
  ([this role-name]
    (-> this (.getRoleCardinality role-name))))

(defn get-all-roles
  "Returns all roles present in the relation.

  returns: a RoleResult object, including a RoleList (for roles
   successfully retrieved) and a RoleUnresolvedList (for roles not
   readable). - `javax.management.relation.RoleResult`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  ([this]
    (-> this (.getAllRoles))))

(defn post-deregister
  "Description copied from interface: MBeanRegistration"
  ([this]
    (-> this (.postDeregister))))

(defn pre-deregister
  "Description copied from interface: MBeanRegistration

  throws: java.lang.Exception - This exception will be caught by the MBean server and re-thrown as an MBeanRegistrationException."
  ([this]
    (-> this (.preDeregister))))

(defn set-role
  "Sets the given role.
   Will check the role according to its corresponding role definition
   provided in relation's relation type
   Will send a notification (RelationNotification with type
   RELATION_BASIC_UPDATE or RELATION_MBEAN_UPDATE, depending if the
   relation is a MBean or not).

  role - role to be set (name and new value) - `javax.management.relation.Role`

  throws: java.lang.IllegalArgumentException - if null role"
  ([this role]
    (-> this (.setRole role))))

(defn set-relation-service-management-flag
  "Description copied from interface: RelationSupportMBean

  flag - whether the relation is handled by the Relation Service. - `java.lang.Boolean`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([this flag]
    (-> this (.setRelationServiceManagementFlag flag))))

(defn post-register
  "Description copied from interface: MBeanRegistration

  registration-done - Indicates whether or not the MBean has been successfully registered in the MBean server. The value false means that the registration phase has failed. - `java.lang.Boolean`"
  ([this registration-done]
    (-> this (.postRegister registration-done))))

(defn get-relation-id
  "Returns relation identifier (used to uniquely identify the relation
   inside the Relation Service).

  returns: the relation id. - `java.lang.String`"
  ([this]
    (-> this (.getRelationId))))

(defn get-referenced-m-beans
  "Retrieves MBeans referenced in the various roles of the relation.

  returns: a HashMap mapping:
    ObjectName -> ArrayList of String (role names) - `java.util.Map<javax.management.ObjectName,java.util.List<java.lang.String>>`"
  ([this]
    (-> this (.getReferencedMBeans))))

(defn set-roles
  "Sets the given roles.
   Will check the role according to its corresponding role definition
   provided in relation's relation type
   Will send one notification (RelationNotification with type
   RELATION_BASIC_UPDATE or RELATION_MBEAN_UPDATE, depending if the
   relation is a MBean or not) per updated role.

  list - list of roles to be set - `javax.management.relation.RoleList`

  returns: a RoleResult object, including a RoleList (for roles
   successfully set) and a RoleUnresolvedList (for roles not
   set). - `javax.management.relation.RoleResult`

  throws: java.lang.IllegalArgumentException - if null role list"
  ([this list]
    (-> this (.setRoles list))))

(defn get-relation-service-name
  "Returns ObjectName of the Relation Service handling the relation.

  returns: the ObjectName of the Relation Service. - `javax.management.ObjectName`"
  ([this]
    (-> this (.getRelationServiceName))))

(defn pre-register
  "Description copied from interface: MBeanRegistration

  server - The MBean Server in which the MBean will be registered. - `javax.management.MBeanServer`
  name - The object name of the MBean. This name is null if the name parameter to one of the createMBean or registerMBean methods in the MBeanServer interface is null. In that case, this method must return a non-null ObjectName for the new MBean. - `javax.management.ObjectName`

  returns: The name under which the MBean is to be registered.
   This value must not be null.  If the name
   parameter is not null, it will usually but not necessarily be
   the returned value. - `javax.management.ObjectName`

  throws: java.lang.Exception - This exception will be caught by the MBean Server and re-thrown as an MBeanRegistrationException."
  ([this server name]
    (-> this (.preRegister server name))))

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
  ([this object-name role-name]
    (-> this (.handleMBeanUnregistration object-name role-name))))

(defn in-relation-service?
  "Returns an internal flag specifying if the object is still handled by
   the Relation Service.

  returns: a Boolean equal to Boolean.TRUE if the object
   is still handled by the Relation Service and Boolean.FALSE otherwise. - `java.lang.Boolean`"
  ([this]
    (-> this (.isInRelationService))))

