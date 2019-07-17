(ns jdk.security.AllPermission
  "The AllPermission is a permission that implies all other permissions.

  Note: Granting AllPermission should be done with extreme care,
  as it implies all other permissions. Thus, it grants code the ability
  to run with security
  disabled.  Extreme caution should be taken before granting such
  a permission to code.  This permission should be used only during testing,
  or in extremely rare cases where an application or applet is
  completely trusted and adding the necessary permissions to the policy
  is prohibitively cumbersome."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AllPermission]))

(defn ->all-permission
  "Constructor.

  Creates a new AllPermission object. This
   constructor exists for use by the Policy object
   to instantiate new Permission objects.

  name - ignored - `java.lang.String`
  actions - ignored. - `java.lang.String`"
  ([name actions]
    (new AllPermission name actions))
  ([]
    (new AllPermission )))

(defn implies
  "Checks if the specified permission is `implied` by
   this object. This method always returns true.

  p - the permission to check against. - `java.security.Permission`

  returns: return - `boolean`"
  ([this p]
    (-> this (.implies p))))

(defn equals
  "Checks two AllPermission objects for equality. Two AllPermission
   objects are always equal.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if obj is an AllPermission, false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-actions
  "Returns the canonical string representation of the actions.

  returns: the actions. - `java.lang.String`"
  ([this]
    (-> this (.getActions))))

(defn new-permission-collection
  "Returns a new PermissionCollection object for storing AllPermission
   objects.

  returns: a new PermissionCollection object suitable for
   storing AllPermissions. - `java.security.PermissionCollection`"
  ([this]
    (-> this (.newPermissionCollection))))

