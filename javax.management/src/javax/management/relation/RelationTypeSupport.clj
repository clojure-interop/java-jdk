(ns javax.management.relation.RelationTypeSupport
  "A RelationTypeSupport object implements the RelationType interface.
  It represents a relation type, providing role information for each role
  expected to be supported in every relation of that type.

  A relation type includes a relation type name and a list of
  role infos (represented by RoleInfo objects).

  A relation type has to be declared in the Relation Service:
  - either using the createRelationType() method, where a RelationTypeSupport
  object will be created and kept in the Relation Service
  - either using the addRelationType() method where the user has to create
  an object implementing the RelationType interface, and this object will be
  used as representing a relation type in the Relation Service.

  The serialVersionUID of this class is 4611072955724144607L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationTypeSupport]))

(defn ->relation-type-support
  "Constructor.

  Constructor where all role definitions are dynamically created and
   passed as parameter.

  relation-type-name - Name of relation type - `java.lang.String`
  role-info-array - List of role definitions (RoleInfo objects) - `javax.management.relation.RoleInfo[]`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^java.lang.String relation-type-name ^javax.management.relation.RoleInfo[] role-info-array]
    (new RelationTypeSupport relation-type-name role-info-array)))

(defn get-relation-type-name
  "Returns the relation type name.

  returns: the relation type name. - `java.lang.String`"
  ([^javax.management.relation.RelationTypeSupport this]
    (-> this (.getRelationTypeName))))

(defn get-role-infos
  "Returns the list of role definitions (ArrayList of RoleInfo objects).

  returns: an ArrayList of RoleInfo. - `java.util.List<javax.management.relation.RoleInfo>`"
  ([^javax.management.relation.RelationTypeSupport this]
    (-> this (.getRoleInfos))))

(defn get-role-info
  "Returns the role info (RoleInfo object) for the given role info name
   (null if not found).

  role-info-name - role info name - `java.lang.String`

  returns: RoleInfo object providing role definition
   does not exist - `javax.management.relation.RoleInfo`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^javax.management.relation.RelationTypeSupport this ^java.lang.String role-info-name]
    (-> this (.getRoleInfo role-info-name))))

