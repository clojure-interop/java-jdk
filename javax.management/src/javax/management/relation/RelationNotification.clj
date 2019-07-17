(ns javax.management.relation.RelationNotification
  "A notification of a change in the Relation Service.
  A RelationNotification notification is sent when a relation is created via
  the Relation Service, or an MBean is added as a relation in the Relation
  Service, or a role is updated in a relation, or a relation is removed from
  the Relation Service.

  The serialVersionUID of this class is -6871117877523310399L."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RelationNotification]))

(defn ->relation-notification
  "Constructor.

  Creates a notification for a role update in a relation.

  notif-type - type of the notification; either: - RELATION_BASIC_UPDATE - RELATION_MBEAN_UPDATE - `java.lang.String`
  source-obj - source object, sending the notification. This is either an ObjectName or a RelationService object. In the latter case it must be the MBean emitting the notification; the MBean Server will rewrite the source to be the ObjectName under which that MBean is registered. - `java.lang.Object`
  sequence - sequence number to identify the notification - `long`
  time-stamp - time stamp - `long`
  message - human-readable message describing the notification - `java.lang.String`
  id - relation id identifying the relation in the Relation Service - `java.lang.String`
  type-name - name of the relation type - `java.lang.String`
  object-name - ObjectName of the relation object if it is an MBean (null for relations internally handled by the Relation Service) - `javax.management.ObjectName`
  name - name of the updated role - `java.lang.String`
  new-value - new role value (List of ObjectName objects) - `java.util.List<javax.management.ObjectName>`
  old-value - old role value (List of ObjectName objects) - `java.util.List<javax.management.ObjectName>`

  throws: java.lang.IllegalArgumentException - if null parameter"
  ([^java.lang.String notif-type ^java.lang.Object source-obj ^Long sequence ^Long time-stamp ^java.lang.String message ^java.lang.String id ^java.lang.String type-name ^javax.management.ObjectName object-name ^java.lang.String name ^java.util.List new-value ^java.util.List old-value]
    (new RelationNotification notif-type source-obj sequence time-stamp message id type-name object-name name new-value old-value))
  ([^java.lang.String notif-type ^java.lang.Object source-obj ^Long sequence ^Long time-stamp ^java.lang.String message ^java.lang.String id ^java.lang.String type-name ^javax.management.ObjectName object-name ^java.util.List unreg-m-bean-list]
    (new RelationNotification notif-type source-obj sequence time-stamp message id type-name object-name unreg-m-bean-list)))

(def *-relation-basic-creation
  "Static Constant.

  Type for the creation of an internal relation.

  type: java.lang.String"
  RelationNotification/RELATION_BASIC_CREATION)

(def *-relation-mbean-creation
  "Static Constant.

  Type for the relation MBean added into the Relation Service.

  type: java.lang.String"
  RelationNotification/RELATION_MBEAN_CREATION)

(def *-relation-basic-update
  "Static Constant.

  Type for an update of an internal relation.

  type: java.lang.String"
  RelationNotification/RELATION_BASIC_UPDATE)

(def *-relation-mbean-update
  "Static Constant.

  Type for the update of a relation MBean.

  type: java.lang.String"
  RelationNotification/RELATION_MBEAN_UPDATE)

(def *-relation-basic-removal
  "Static Constant.

  Type for the removal from the Relation Service of an internal relation.

  type: java.lang.String"
  RelationNotification/RELATION_BASIC_REMOVAL)

(def *-relation-mbean-removal
  "Static Constant.

  Type for the removal from the Relation Service of a relation MBean.

  type: java.lang.String"
  RelationNotification/RELATION_MBEAN_REMOVAL)

(defn get-relation-id
  "Returns the relation identifier of created/removed/updated relation.

  returns: the relation id. - `java.lang.String`"
  ([^javax.management.relation.RelationNotification this]
    (-> this (.getRelationId))))

(defn get-relation-type-name
  "Returns the relation type name of created/removed/updated relation.

  returns: the relation type name. - `java.lang.String`"
  ([^javax.management.relation.RelationNotification this]
    (-> this (.getRelationTypeName))))

(defn get-object-name
  "Returns the ObjectName of the
   created/removed/updated relation.

  returns: the ObjectName if the relation is an MBean, otherwise null. - `javax.management.ObjectName`"
  ([^javax.management.relation.RelationNotification this]
    (-> this (.getObjectName))))

(defn get-m-beans-to-unregister
  "Returns the list of ObjectNames of MBeans expected to be unregistered
   due to a relation removal (only for relation removal).

  returns: a List of ObjectName. - `java.util.List<javax.management.ObjectName>`"
  ([^javax.management.relation.RelationNotification this]
    (-> this (.getMBeansToUnregister))))

(defn get-role-name
  "Returns name of updated role of updated relation (only for role update).

  returns: the name of the updated role. - `java.lang.String`"
  ([^javax.management.relation.RelationNotification this]
    (-> this (.getRoleName))))

(defn get-old-role-value
  "Returns old value of updated role (only for role update).

  returns: the old value of the updated role. - `java.util.List<javax.management.ObjectName>`"
  ([^javax.management.relation.RelationNotification this]
    (-> this (.getOldRoleValue))))

(defn get-new-role-value
  "Returns new value of updated role (only for role update).

  returns: the new value of the updated role. - `java.util.List<javax.management.ObjectName>`"
  ([^javax.management.relation.RelationNotification this]
    (-> this (.getNewRoleValue))))

