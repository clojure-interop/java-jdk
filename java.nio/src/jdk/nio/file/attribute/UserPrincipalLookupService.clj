(ns jdk.nio.file.attribute.UserPrincipalLookupService
  "An object to lookup user and group principals by name. A UserPrincipal
  represents an identity that may be used to determine access rights to objects
  in a file system. A GroupPrincipal represents a group identity.
  A UserPrincipalLookupService defines methods to lookup identities by
  name or group name (which are typically user or account names). Whether names
  and group names are case sensitive or not depends on the implementation.
  The exact definition of a group is implementation specific but typically a
  group represents an identity created for administrative purposes so as to
  determine the access rights for the members of the group. In particular it is
  implementation specific if the namespace for names and groups is the
  same or is distinct. To ensure consistent and correct behavior across
  platforms it is recommended that this API be used as if the namespaces are
  distinct. In other words, the lookupPrincipalByName should be used to lookup users, and lookupPrincipalByGroupName should be used to
  lookup groups."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute UserPrincipalLookupService]))

(defn lookup-principal-by-name
  "Lookup a user principal by name.

  name - the string representation of the user principal to lookup - `java.lang.String`

  returns: a user principal - `java.nio.file.attribute.UserPrincipal`

  throws: java.nio.file.attribute.UserPrincipalNotFoundException - the principal does not exist"
  ([^java.nio.file.attribute.UserPrincipalLookupService this ^java.lang.String name]
    (-> this (.lookupPrincipalByName name))))

(defn lookup-principal-by-group-name
  "Lookup a group principal by group name.

    Where an implementation does not support any notion of group then
   this method always throws UserPrincipalNotFoundException. Where
   the namespace for user accounts and groups is the same, then this method
   is identical to invoking lookupPrincipalByName.

  group - the string representation of the group to lookup - `java.lang.String`

  returns: a group principal - `java.nio.file.attribute.GroupPrincipal`

  throws: java.nio.file.attribute.UserPrincipalNotFoundException - the principal does not exist or is not a group"
  ([^java.nio.file.attribute.UserPrincipalLookupService this ^java.lang.String group]
    (-> this (.lookupPrincipalByGroupName group))))

