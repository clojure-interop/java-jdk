(ns jdk.security.acl.AclEntry
  "This is the interface used for representing one entry in an Access
  Control List (ACL).

  An ACL can be thought of as a data structure with multiple ACL entry
  objects. Each ACL entry object contains a set of permissions associated
  with a particular principal. (A principal represents an entity such as
  an individual user or a group). Additionally, each ACL entry is specified
  as being either positive or negative. If positive, the permissions are
  to be granted to the associated principal. If negative, the permissions
  are to be denied. Each principal can have at most one positive ACL entry
  and one negative entry; that is, multiple positive or negative ACL
  entries are not allowed for any principal.

  Note: ACL entries are by default positive. An entry becomes a
  negative entry only if the
  setNegativePermissions
  method is called on it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.acl AclEntry]))

(defn get-principal
  "Returns the principal for which permissions are granted or denied by
   this ACL entry. Returns null if there is no principal set for this
   entry yet.

  returns: the principal associated with this entry. - `java.security.Principal`"
  ([^java.security.acl.AclEntry this]
    (-> this (.getPrincipal))))

(defn permissions
  "Returns an enumeration of the permissions in this ACL entry.

  returns: an enumeration of the permissions in this ACL entry. - `java.util.Enumeration<java.security.acl.Permission>`"
  ([^java.security.acl.AclEntry this]
    (-> this (.permissions))))

(defn check-permission
  "Checks if the specified permission is part of the
   permission set in this entry.

  permission - the permission to be checked for. - `java.security.acl.Permission`

  returns: true if the permission is part of the
   permission set in this entry, false otherwise. - `boolean`"
  ([^java.security.acl.AclEntry this ^java.security.acl.Permission permission]
    (-> this (.checkPermission permission))))

(defn negative?
  "Returns true if this is a negative ACL entry (one denying the
   associated principal the set of permissions in the entry), false
   otherwise.

  returns: true if this is a negative ACL entry, false if it's not. - `boolean`"
  ([^java.security.acl.AclEntry this]
    (-> this (.isNegative))))

(defn set-negative-permissions
  "Sets this ACL entry to be a negative one. That is, the associated
   principal (e.g., a user or a group) will be denied the permission set
   specified in the entry.

   Note: ACL entries are by default positive. An entry becomes a
   negative entry only if this setNegativePermissions
   method is called on it."
  ([^java.security.acl.AclEntry this]
    (-> this (.setNegativePermissions))))

(defn to-string
  "Returns a string representation of the contents of this ACL entry.

  returns: a string representation of the contents. - `java.lang.String`"
  ([^java.security.acl.AclEntry this]
    (-> this (.toString))))

(defn remove-permission
  "Removes the specified permission from this ACL entry.

  permission - the permission to be removed from this entry. - `java.security.acl.Permission`

  returns: true if the permission is removed, false if the
   permission was not part of this entry's permission set. - `boolean`"
  ([^java.security.acl.AclEntry this ^java.security.acl.Permission permission]
    (-> this (.removePermission permission))))

(defn clone
  "Clones this ACL entry.

  returns: a clone of this ACL entry. - `java.lang.Object`"
  ([^java.security.acl.AclEntry this]
    (-> this (.clone))))

(defn set-principal
  "Specifies the principal for which permissions are granted or denied
   by this ACL entry. If a principal was already set for this ACL entry,
   false is returned, otherwise true is returned.

  user - the principal to be set for this entry. - `java.security.Principal`

  returns: true if the principal is set, false if there was
   already a principal set for this entry. - `boolean`"
  ([^java.security.acl.AclEntry this ^java.security.Principal user]
    (-> this (.setPrincipal user))))

(defn add-permission
  "Adds the specified permission to this ACL entry. Note: An entry can
   have multiple permissions.

  permission - the permission to be associated with the principal in this entry. - `java.security.acl.Permission`

  returns: true if the permission was added, false if the
   permission was already part of this entry's permission set. - `boolean`"
  ([^java.security.acl.AclEntry this ^java.security.acl.Permission permission]
    (-> this (.addPermission permission))))

