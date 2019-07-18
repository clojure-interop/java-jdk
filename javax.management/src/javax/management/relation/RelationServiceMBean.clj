(ns javax.management.relation.RelationServiceMBean
  "The Relation Service is in charge of creating and deleting relation types
  and relations, of handling the consistency and of providing query
  mechanisms."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationServiceMBean]))

(defn get-roles
  "Retrieves values of roles with given names in given relation.

  relation-id - relation id - `java.lang.String`
  role-name-array - array of names of roles to be retrieved - `java.lang.String[]`

  returns: a RoleResult object, including a RoleList (for roles
   successfully retrieved) and a RoleUnresolvedList (for roles not
   retrieved). - `javax.management.relation.RoleResult`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  (^javax.management.relation.RoleResult [^RelationServiceMBean this ^java.lang.String relation-id role-name-array]
    (-> this (.getRoles relation-id role-name-array))))

(defn update-role-map
  "Handles update of the Relation Service role map for the update of given
   role in given relation.
   It is called in relation MBean setRole() (for given role) and
   setRoles() (for each role) methods (implementation provided in
   RelationSupport class).
   It is also called in Relation Service setRole() (for given role) and
   setRoles() (for each role) methods.
   To allow the Relation Service to maintain the consistency (in case
   of MBean unregistration) and to be able to perform queries, this method
   must be called when a role is updated.

  relation-id - relation identifier of the updated relation - `java.lang.String`
  new-role - new role (name and new value) - `javax.management.relation.Role`
  old-role-value - old role value (List of ObjectName objects) - `java.util.List`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^RelationServiceMBean this ^java.lang.String relation-id ^javax.management.relation.Role new-role ^java.util.List old-role-value]
    (-> this (.updateRoleMap relation-id new-role old-role-value))))

(defn get-role-info
  "Retrieves role info for given role of a given relation type.

  relation-type-name - name of relation type - `java.lang.String`
  role-info-name - name of role - `java.lang.String`

  returns: RoleInfo object. - `javax.management.relation.RoleInfo`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^javax.management.relation.RoleInfo [^RelationServiceMBean this ^java.lang.String relation-type-name ^java.lang.String role-info-name]
    (-> this (.getRoleInfo relation-type-name role-info-name))))

(defn is-active
  "Checks if the Relation Service is active.
   Current condition is that the Relation Service must be registered in the
   MBean Server

  throws: javax.management.relation.RelationServiceNotRegisteredException - if it is not registered"
  ([^RelationServiceMBean this]
    (-> this (.isActive))))

(defn get-relation-type-name
  "Returns name of associated relation type for given relation.

  relation-id - relation id - `java.lang.String`

  returns: the name of the associated relation type. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.lang.String [^RelationServiceMBean this ^java.lang.String relation-id]
    (-> this (.getRelationTypeName relation-id))))

(defn get-role
  "Retrieves role value for given role name in given relation.

  relation-id - relation id - `java.lang.String`
  role-name - name of role - `java.lang.String`

  returns: the ArrayList of ObjectName objects being the role value - `java.util.List<javax.management.ObjectName>`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered"
  (^java.util.List [^RelationServiceMBean this ^java.lang.String relation-id ^java.lang.String role-name]
    (-> this (.getRole relation-id role-name))))

(defn get-purge-flag?
  "Returns the flag to indicate if when a notification is received for the
   unregistration of an MBean referenced in a relation, if an immediate
   `purge` of the relations (look for the relations no longer valid)
   has to be performed, or if that will be performed only when the
   purgeRelations method is explicitly called.
   true is immediate purge.

  returns: true if purges are immediate. - `boolean`"
  (^Boolean [^RelationServiceMBean this]
    (-> this (.getPurgeFlag))))

(defn find-associated-m-beans
  "Retrieves the MBeans associated to given one in a relation.
   This corresponds to CIM Associators and AssociatorNames operations.

  mbean-name - ObjectName of MBean - `javax.management.ObjectName`
  relation-type-name - can be null; if specified, only the relations of that type will be considered in the search. Else all relation types are considered. - `java.lang.String`
  role-name - can be null; if specified, only the relations where the MBean is referenced in that role will be considered. Else all roles are considered. - `java.lang.String`

  returns: an HashMap, where the keys are the ObjectNames of the MBeans
   associated to given MBean, and the value is, for each key, an ArrayList
   of the relation ids of the relations where the key MBean is
   associated to given one (as they can be associated in several different
   relations). - `java.util.Map<javax.management.ObjectName,java.util.List<java.lang.String>>`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.util.Map [^RelationServiceMBean this ^javax.management.ObjectName mbean-name ^java.lang.String relation-type-name ^java.lang.String role-name]
    (-> this (.findAssociatedMBeans mbean-name relation-type-name role-name))))

(defn check-role-reading
  "Checks if given Role can be read in a relation of the given type.

  role-name - name of role to be checked - `java.lang.String`
  relation-type-name - name of the relation type - `java.lang.String`

  returns: an Integer wrapping an integer corresponding to possible
   problems represented as constants in RoleUnresolved:
   - 0 if role can be read
   - integer corresponding to RoleStatus.NO_ROLE_WITH_NAME
   - integer corresponding to RoleStatus.ROLE_NOT_READABLE - `java.lang.Integer`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.lang.Integer [^RelationServiceMBean this ^java.lang.String role-name ^java.lang.String relation-type-name]
    (-> this (.checkRoleReading role-name relation-type-name))))

(defn is-relation
  "Returns the relation id associated to the given ObjectName if the
   MBean has been added as a relation in the Relation Service.

  object-name - ObjectName of supposed relation - `javax.management.ObjectName`

  returns: relation id (String) or null (if the ObjectName is not a
   relation handled by the Relation Service) - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.lang.String [^RelationServiceMBean this ^javax.management.ObjectName object-name]
    (-> this (.isRelation object-name))))

(defn get-role-cardinality
  "Retrieves the number of MBeans currently referenced in the
   given role.

  relation-id - relation id - `java.lang.String`
  role-name - name of role - `java.lang.String`

  returns: the number of currently referenced MBeans in that role - `java.lang.Integer`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.lang.Integer [^RelationServiceMBean this ^java.lang.String relation-id ^java.lang.String role-name]
    (-> this (.getRoleCardinality relation-id role-name))))

(defn create-relation
  "Creates a simple relation (represented by a RelationSupport object) of
   given relation type, and adds it in the Relation Service.
   Roles are initialized according to the role list provided in
   parameter. The ones not initialized in this way are set to an empty
   ArrayList of ObjectNames.
   A RelationNotification, with type RELATION_BASIC_CREATION, is sent.

  relation-id - relation identifier, to identify uniquely the relation inside the Relation Service - `java.lang.String`
  relation-type-name - name of the relation type (has to be created in the Relation Service) - `java.lang.String`
  role-list - role list to initialize roles of the relation (can be null). - `javax.management.relation.RoleList`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  ([^RelationServiceMBean this ^java.lang.String relation-id ^java.lang.String relation-type-name ^javax.management.relation.RoleList role-list]
    (-> this (.createRelation relation-id relation-type-name role-list))))

(defn send-relation-removal-notification
  "Sends a notification (RelationNotification) for a relation removal.
   The notification type is:
   - RelationNotification.RELATION_BASIC_REMOVAL if the relation is an
   object internal to the Relation Service
   - RelationNotification.RELATION_MBEAN_REMOVAL if the relation is a
   MBean added as a relation.
   The source object is the Relation Service itself.
   It is called in Relation Service removeRelation() method.

  relation-id - relation identifier of the updated relation - `java.lang.String`
  unreg-m-bean-list - List of ObjectNames of MBeans expected to be unregistered due to relation removal (can be null) - `java.util.List`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^RelationServiceMBean this ^java.lang.String relation-id ^java.util.List unreg-m-bean-list]
    (-> this (.sendRelationRemovalNotification relation-id unreg-m-bean-list))))

(defn get-all-roles
  "Returns all roles present in the relation.

  relation-id - relation id - `java.lang.String`

  returns: a RoleResult object, including a RoleList (for roles
   successfully retrieved) and a RoleUnresolvedList (for roles not
   readable). - `javax.management.relation.RoleResult`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^javax.management.relation.RoleResult [^RelationServiceMBean this ^java.lang.String relation-id]
    (-> this (.getAllRoles relation-id))))

(defn set-role
  "Sets the given role in given relation.
   Will check the role according to its corresponding role definition
   provided in relation's relation type
   The Relation Service will keep track of the change to keep the
   consistency of relations by handling referenced MBean deregistrations.

  relation-id - relation id - `java.lang.String`
  role - role to be set (name and new value) - `javax.management.relation.Role`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  ([^RelationServiceMBean this ^java.lang.String relation-id ^javax.management.relation.Role role]
    (-> this (.setRole relation-id role))))

(defn get-all-relation-type-names
  "Retrieves names of all known relation types.

  returns: ArrayList of relation type names (Strings) - `java.util.List<java.lang.String>`"
  (^java.util.List [^RelationServiceMBean this]
    (-> this (.getAllRelationTypeNames))))

(defn add-relation-type
  "Adds given object as a relation type. The object is expected to
   implement the RelationType interface.

  relation-type-obj - relation type object (implementing the RelationType interface) - `javax.management.relation.RelationType`

  throws: java.lang.IllegalArgumentException - if null parameter or if relationTypeObj.getRelationTypeName() returns null."
  ([^RelationServiceMBean this ^javax.management.relation.RelationType relation-type-obj]
    (-> this (.addRelationType relation-type-obj))))

(defn check-role-writing
  "Checks if given Role can be set in a relation of given type.

  role - role to be checked - `javax.management.relation.Role`
  relation-type-name - name of relation type - `java.lang.String`
  init-flag - flag to specify that the checking is done for the initialization of a role, write access shall not be verified. - `java.lang.Boolean`

  returns: an Integer wrapping an integer corresponding to possible
   problems represented as constants in RoleUnresolved:
   - 0 if role can be set
   - integer corresponding to RoleStatus.NO_ROLE_WITH_NAME
   - integer for RoleStatus.ROLE_NOT_WRITABLE
   - integer for RoleStatus.LESS_THAN_MIN_ROLE_DEGREE
   - integer for RoleStatus.MORE_THAN_MAX_ROLE_DEGREE
   - integer for RoleStatus.REF_MBEAN_OF_INCORRECT_CLASS
   - integer for RoleStatus.REF_MBEAN_NOT_REGISTERED - `java.lang.Integer`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.lang.Integer [^RelationServiceMBean this ^javax.management.relation.Role role ^java.lang.String relation-type-name ^java.lang.Boolean init-flag]
    (-> this (.checkRoleWriting role relation-type-name init-flag))))

(defn get-all-relation-ids
  "Returns all the relation ids for all the relations handled by the
   Relation Service.

  returns: ArrayList of String - `java.util.List<java.lang.String>`"
  (^java.util.List [^RelationServiceMBean this]
    (-> this (.getAllRelationIds))))

(defn has-relation?
  "Checks if there is a relation identified in Relation Service with given
   relation id.

  relation-id - relation id identifying the relation - `java.lang.String`

  returns: boolean: true if there is a relation, false else - `java.lang.Boolean`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.lang.Boolean [^RelationServiceMBean this ^java.lang.String relation-id]
    (-> this (.hasRelation relation-id))))

(defn set-purge-flag
  "Sets the flag to indicate if when a notification is received for the
   unregistration of an MBean referenced in a relation, if an immediate
   `purge` of the relations (look for the relations no longer valid)
   has to be performed, or if that will be performed only when the
   purgeRelations method is explicitly called.
   true is immediate purge.

  purge-flag - flag - `boolean`"
  ([^RelationServiceMBean this ^Boolean purge-flag]
    (-> this (.setPurgeFlag purge-flag))))

(defn send-relation-creation-notification
  "Sends a notification (RelationNotification) for a relation creation.
   The notification type is:
   - RelationNotification.RELATION_BASIC_CREATION if the relation is an
   object internal to the Relation Service
   - RelationNotification.RELATION_MBEAN_CREATION if the relation is a
   MBean added as a relation.
   The source object is the Relation Service itself.
   It is called in Relation Service createRelation() and
   addRelation() methods.

  relation-id - relation identifier of the updated relation - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^RelationServiceMBean this ^java.lang.String relation-id]
    (-> this (.sendRelationCreationNotification relation-id))))

(defn get-referenced-m-beans
  "Retrieves MBeans referenced in the various roles of the relation.

  relation-id - relation id - `java.lang.String`

  returns: a HashMap mapping:
    ObjectName -> ArrayList of String (role
   names) - `java.util.Map<javax.management.ObjectName,java.util.List<java.lang.String>>`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.util.Map [^RelationServiceMBean this ^java.lang.String relation-id]
    (-> this (.getReferencedMBeans relation-id))))

(defn set-roles
  "Sets the given roles in given relation.
   Will check the role according to its corresponding role definition
   provided in relation's relation type
   The Relation Service keeps track of the changes to keep the
   consistency of relations by handling referenced MBean deregistrations.

  relation-id - relation id - `java.lang.String`
  role-list - list of roles to be set - `javax.management.relation.RoleList`

  returns: a RoleResult object, including a RoleList (for roles
   successfully set) and a RoleUnresolvedList (for roles not
   set). - `javax.management.relation.RoleResult`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  (^javax.management.relation.RoleResult [^RelationServiceMBean this ^java.lang.String relation-id ^javax.management.relation.RoleList role-list]
    (-> this (.setRoles relation-id role-list))))

(defn send-role-update-notification
  "Sends a notification (RelationNotification) for a role update in the
   given relation. The notification type is:
   - RelationNotification.RELATION_BASIC_UPDATE if the relation is an
   object internal to the Relation Service
   - RelationNotification.RELATION_MBEAN_UPDATE if the relation is a
   MBean added as a relation.
   The source object is the Relation Service itself.
   It is called in relation MBean setRole() (for given role) and
   setRoles() (for each role) methods (implementation provided in
   RelationSupport class).
   It is also called in Relation Service setRole() (for given role) and
   setRoles() (for each role) methods.

  relation-id - relation identifier of the updated relation - `java.lang.String`
  new-role - new role (name and new value) - `javax.management.relation.Role`
  old-role-value - old role value (List of ObjectName objects) - `java.util.List`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^RelationServiceMBean this ^java.lang.String relation-id ^javax.management.relation.Role new-role ^java.util.List old-role-value]
    (-> this (.sendRoleUpdateNotification relation-id new-role old-role-value))))

(defn create-relation-type
  "Creates a relation type (RelationTypeSupport object) with given
   role infos (provided by the RoleInfo objects), and adds it in the
   Relation Service.

  relation-type-name - name of the relation type - `java.lang.String`
  role-info-array - array of role infos - `javax.management.relation.RoleInfo[]`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^RelationServiceMBean this ^java.lang.String relation-type-name role-info-array]
    (-> this (.createRelationType relation-type-name role-info-array))))

(defn is-relation-m-bean
  "If the relation is represented by an MBean (created by the user and
   added as a relation in the Relation Service), returns the ObjectName of
   the MBean.

  relation-id - relation id identifying the relation - `java.lang.String`

  returns: ObjectName of the corresponding relation MBean, or null if
   the relation is not an MBean. - `javax.management.ObjectName`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^javax.management.ObjectName [^RelationServiceMBean this ^java.lang.String relation-id]
    (-> this (.isRelationMBean relation-id))))

(defn find-referencing-relations
  "Retrieves the relations where a given MBean is referenced.
   This corresponds to the CIM `References` and `ReferenceNames`
   operations.

  mbean-name - ObjectName of MBean - `javax.management.ObjectName`
  relation-type-name - can be null; if specified, only the relations of that type will be considered in the search. Else all relation types are considered. - `java.lang.String`
  role-name - can be null; if specified, only the relations where the MBean is referenced in that role will be returned. Else all roles are considered. - `java.lang.String`

  returns: an HashMap, where the keys are the relation ids of the relations
   where the MBean is referenced, and the value is, for each key,
   an ArrayList of role names (as an MBean can be referenced in several
   roles in the same relation). - `java.util.Map<java.lang.String,java.util.List<java.lang.String>>`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.util.Map [^RelationServiceMBean this ^javax.management.ObjectName mbean-name ^java.lang.String relation-type-name ^java.lang.String role-name]
    (-> this (.findReferencingRelations mbean-name relation-type-name role-name))))

(defn add-relation
  "Adds an MBean created by the user (and registered by him in the MBean
   Server) as a relation in the Relation Service.
   To be added as a relation, the MBean must conform to the
   following:
   - implement the Relation interface
   - have for RelationService ObjectName the ObjectName of current
   Relation Service
   - have a relation id that is unique and unused in current Relation Service
   - have for relation type a relation type created in the Relation
   Service
   - have roles conforming to the role info provided in the relation
   type.

  relation-object-name - ObjectName of the relation MBean to be added. - `javax.management.ObjectName`

  throws: javax.management.relation.InvalidRelationServiceException - if: - no Relation Service name in MBean - the Relation Service name in the MBean is not the one of the current Relation Service"
  ([^RelationServiceMBean this ^javax.management.ObjectName relation-object-name]
    (-> this (.addRelation relation-object-name))))

(defn find-relations-of-type
  "Returns the relation ids for relations of the given type.

  relation-type-name - relation type name - `java.lang.String`

  returns: an ArrayList of relation ids. - `java.util.List<java.lang.String>`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.util.List [^RelationServiceMBean this ^java.lang.String relation-type-name]
    (-> this (.findRelationsOfType relation-type-name))))

(defn purge-relations
  "Purges the relations.

   Depending on the purgeFlag value, this method is either called
   automatically when a notification is received for the unregistration of
   an MBean referenced in a relation (if the flag is set to true), or not
   (if the flag is set to false).
   In that case it is up to the user to call it to maintain the
   consistency of the relations. To be kept in mind that if an MBean is
   unregistered and the purge not done immediately, if the ObjectName is
   reused and assigned to another MBean referenced in a relation, calling
   manually this purgeRelations() method will cause trouble, as will
   consider the ObjectName as corresponding to the unregistered MBean, not
   seeing the new one.

   The behavior depends on the cardinality of the role where the
   unregistered MBean is referenced:
   - if removing one MBean reference in the role makes its number of
   references less than the minimum degree, the relation has to be removed.
   - if the remaining number of references after removing the MBean
   reference is still in the cardinality range, keep the relation and
   update it calling its handleMBeanUnregistration() callback.

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server."
  ([^RelationServiceMBean this]
    (-> this (.purgeRelations))))

(defn get-role-infos
  "Retrieves list of role infos (RoleInfo objects) of a given relation
   type.

  relation-type-name - name of relation type - `java.lang.String`

  returns: ArrayList of RoleInfo. - `java.util.List<javax.management.relation.RoleInfo>`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^java.util.List [^RelationServiceMBean this ^java.lang.String relation-type-name]
    (-> this (.getRoleInfos relation-type-name))))

(defn remove-relation-type
  "Removes given relation type from Relation Service.
   The relation objects of that type will be removed from the
   Relation Service.

  relation-type-name - name of the relation type to be removed - `java.lang.String`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  ([^RelationServiceMBean this ^java.lang.String relation-type-name]
    (-> this (.removeRelationType relation-type-name))))

(defn remove-relation
  "Removes given relation from the Relation Service.
   A RelationNotification notification is sent, its type being:
   - RelationNotification.RELATION_BASIC_REMOVAL if the relation was
   only internal to the Relation Service
   - RelationNotification.RELATION_MBEAN_REMOVAL if the relation is
   registered as an MBean.
   For MBeans referenced in such relation, nothing will be done,

  relation-id - relation id of the relation to be removed - `java.lang.String`

  throws: javax.management.relation.RelationServiceNotRegisteredException - if the Relation Service is not registered in the MBean Server"
  ([^RelationServiceMBean this ^java.lang.String relation-id]
    (-> this (.removeRelation relation-id))))

