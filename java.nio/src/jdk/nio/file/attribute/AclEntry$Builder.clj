(ns jdk.nio.file.attribute.AclEntry$Builder
  "A builder of AclEntry objects.

   A Builder object is obtained by invoking one of the newBuilder methods defined by the AclEntry
  class.

   Builder objects are mutable and are not safe for use by multiple
  concurrent threads without appropriate synchronization."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute AclEntry$Builder]))

(defn build
  "Constructs an AclEntry from the components of this builder.
   The type and who components are required to have been set in order
   to construct an AclEntry.

  returns: a new ACL entry - `java.nio.file.attribute.AclEntry`

  throws: java.lang.IllegalStateException - if the type or who component have not been set"
  ([^java.nio.file.attribute.AclEntry$Builder this]
    (-> this (.build))))

(defn set-type
  "Sets the type component of this builder.

  type - the component type - `java.nio.file.attribute.AclEntryType`

  returns: this builder - `java.nio.file.attribute.AclEntry.Builder`"
  ([^java.nio.file.attribute.AclEntry$Builder this ^java.nio.file.attribute.AclEntryType type]
    (-> this (.setType type))))

(defn set-principal
  "Sets the principal component of this builder.

  who - the principal component - `java.nio.file.attribute.UserPrincipal`

  returns: this builder - `java.nio.file.attribute.AclEntry.Builder`"
  ([^java.nio.file.attribute.AclEntry$Builder this ^java.nio.file.attribute.UserPrincipal who]
    (-> this (.setPrincipal who))))

(defn set-permissions
  "Sets the permissions component of this builder. On return, the
   permissions component of this builder is a copy of the given set.

  perms - the permissions component - `java.util.Set<java.nio.file.attribute.AclEntryPermission>`

  returns: this builder - `java.nio.file.attribute.AclEntry.Builder`

  throws: java.lang.ClassCastException - if the set contains elements that are not of type AclEntryPermission"
  ([^java.nio.file.attribute.AclEntry$Builder this ^java.util.Set perms]
    (-> this (.setPermissions perms))))

(defn set-flags
  "Sets the flags component of this builder. On return, the flags
   component of this builder is a copy of the given set.

  flags - the flags component - `java.util.Set<java.nio.file.attribute.AclEntryFlag>`

  returns: this builder - `java.nio.file.attribute.AclEntry.Builder`

  throws: java.lang.ClassCastException - if the set contains elements that are not of type AclEntryFlag"
  ([^java.nio.file.attribute.AclEntry$Builder this ^java.util.Set flags]
    (-> this (.setFlags flags))))

