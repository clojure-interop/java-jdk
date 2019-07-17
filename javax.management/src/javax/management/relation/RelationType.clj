(ns javax.management.relation.RelationType
  "The RelationType interface has to be implemented by any class expected to
  represent a relation type."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationType]))

(defn get-relation-type-name
  "Returns the relation type name.

  returns: the relation type name. - `java.lang.String`"
  (^java.lang.String [^javax.management.relation.RelationType this]
    (-> this (.getRelationTypeName))))

(defn get-role-infos
  "Returns the list of role definitions (ArrayList of RoleInfo objects).

  returns: an ArrayList of RoleInfo. - `java.util.List<javax.management.relation.RoleInfo>`"
  (^java.util.List [^javax.management.relation.RelationType this]
    (-> this (.getRoleInfos))))

(defn get-role-info
  "Returns the role info (RoleInfo object) for the given role info name
   (null if not found).

  role-info-name - role info name - `java.lang.String`

  returns: RoleInfo object providing role definition
   does not exist - `javax.management.relation.RoleInfo`

  throws: java.lang.IllegalArgumentException - if null parameter"
  (^javax.management.relation.RoleInfo [^javax.management.relation.RelationType this ^java.lang.String role-info-name]
    (-> this (.getRoleInfo role-info-name))))

