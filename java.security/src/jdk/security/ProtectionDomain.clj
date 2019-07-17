(ns jdk.security.ProtectionDomain
  "The ProtectionDomain class encapsulates the characteristics of a domain,
  which encloses a set of classes whose instances are granted a set
  of permissions when being executed on behalf of a given set of Principals.

  A static set of permissions can be bound to a ProtectionDomain when it is
  constructed; such permissions are granted to the domain regardless of the
  Policy in force. However, to support dynamic security policies, a
  ProtectionDomain can also be constructed such that it is dynamically
  mapped to a set of permissions by the current Policy whenever a permission
  is checked."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security ProtectionDomain]))

(defn ->protection-domain
  "Constructor.

  Creates a new ProtectionDomain qualified by the given CodeSource,
   Permissions, ClassLoader and array of Principals. If the
   permissions object is not null, then setReadOnly()
   will be called on the passed in Permissions object.
   The permissions granted to this domain are dynamic; they include
   both the static permissions passed to this constructor, and any
   permissions granted to this domain by the current Policy at the
   time a permission is checked.

   This constructor is typically used by
   ClassLoaders
   and DomainCombiners which delegate to
   Policy to actively associate the permissions granted to
   this domain. This constructor affords the
   Policy provider the opportunity to augment the supplied
   PermissionCollection to reflect policy changes.

  codesource - the CodeSource associated with this domain - `java.security.CodeSource`
  permissions - the permissions granted to this domain - `java.security.PermissionCollection`
  classloader - the ClassLoader associated with this domain - `java.lang.ClassLoader`
  principals - the array of Principals associated with this domain. The contents of the array are copied to protect against subsequent modification. - `java.security.Principal[]`"
  ([codesource permissions classloader principals]
    (new ProtectionDomain codesource permissions classloader principals))
  ([codesource permissions]
    (new ProtectionDomain codesource permissions)))

(defn get-code-source
  "Returns the CodeSource of this domain.

  returns: the CodeSource of this domain which may be null. - `java.security.CodeSource`"
  ([this]
    (-> this (.getCodeSource))))

(defn get-class-loader
  "Returns the ClassLoader of this domain.

  returns: the ClassLoader of this domain which may be null. - `java.lang.ClassLoader`"
  ([this]
    (-> this (.getClassLoader))))

(defn get-principals
  "Returns an array of principals for this domain.

  returns: a non-null array of principals for this domain.
   Returns a new array each time this method is called. - `java.security.Principal[]`"
  ([this]
    (-> this (.getPrincipals))))

(defn get-permissions
  "Returns the static permissions granted to this domain.

  returns: the static set of permissions for this domain which may be null. - `java.security.PermissionCollection`"
  ([this]
    (-> this (.getPermissions))))

(defn implies
  "Check and see if this ProtectionDomain implies the permissions
   expressed in the Permission object.

   The set of permissions evaluated is a function of whether the
   ProtectionDomain was constructed with a static set of permissions
   or it was bound to a dynamically mapped set of permissions.

   If the ProtectionDomain was constructed to a
   statically bound PermissionCollection then the permission will
   only be checked against the PermissionCollection supplied at
   construction.

   However, if the ProtectionDomain was constructed with
   the constructor variant which supports
   dynamically binding
   permissions, then the permission will be checked against the
   combination of the PermissionCollection supplied at construction and
   the current Policy binding.

  permission - the Permission object to check. - `java.security.Permission`

  returns: true if `permission` is implicit to this ProtectionDomain. - `boolean`"
  ([this permission]
    (-> this (.implies permission))))

(defn to-string
  "Convert a ProtectionDomain to a String.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

