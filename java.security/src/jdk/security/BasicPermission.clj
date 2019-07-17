(ns jdk.security.BasicPermission
  "The BasicPermission class extends the Permission class, and
  can be used as the base class for permissions that want to
  follow the same naming convention as BasicPermission.

  The name for a BasicPermission is the name of the given permission
  (for example, `exit`,
  `setFactory`, `print.queueJob`, etc). The naming
  convention follows the  hierarchical property naming convention.
  An asterisk may appear by itself, or if immediately preceded by a `.`
  may appear at the end of the name, to signify a wildcard match.
  For example, `*` and `java.*` signify a wildcard match, while `*java`, `a*b`,
  and `java*` do not.

  The action string (inherited from Permission) is unused.
  Thus, BasicPermission is commonly used as the base class for
  `named` permissions
  (ones that contain a name but no actions list; you either have the
  named permission or you don't.)
  Subclasses may implement actions on top of BasicPermission,
  if desired."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security BasicPermission]))

(defn ->basic-permission
  "Constructor.

  Creates a new BasicPermission object with the specified name.
   The name is the symbolic name of the BasicPermission, and the
   actions String is currently unused.

  name - the name of the BasicPermission. - `java.lang.String`
  actions - ignored. - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null."
  ([^java.lang.String name ^java.lang.String actions]
    (new BasicPermission name actions))
  ([^java.lang.String name]
    (new BasicPermission name)))

(defn implies
  "Checks if the specified permission is `implied` by
   this object.

   More specifically, this method returns true if:

    p's class is the same as this object's class, and
    p's name equals or (in the case of wildcards)
        is implied by this object's
        name. For example, `a.b.*` implies `a.b.c`.

  p - the permission to check against. - `java.security.Permission`

  returns: true if the passed permission is equal to or
   implied by this permission, false otherwise. - `boolean`"
  (^Boolean [^java.security.BasicPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Checks two BasicPermission objects for equality.
   Checks that obj's class is the same as this object's class
   and has the same name as this object.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if obj's class is the same as this object's class
    and has the same name as this BasicPermission object, false otherwise. - `boolean`"
  (^Boolean [^java.security.BasicPermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this object.
   The hash code used is the hash code of the name, that is,
   getName().hashCode(), where getName is
   from the Permission superclass.

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.security.BasicPermission this]
    (-> this (.hashCode))))

(defn get-actions
  "Returns the canonical string representation of the actions,
   which currently is the empty string ``, since there are no actions for
   a BasicPermission.

  returns: the empty string ``. - `java.lang.String`"
  (^java.lang.String [^java.security.BasicPermission this]
    (-> this (.getActions))))

(defn new-permission-collection
  "Returns a new PermissionCollection object for storing BasicPermission
   objects.

   BasicPermission objects must be stored in a manner that allows them
   to be inserted in any order, but that also enables the
   PermissionCollection implies method
   to be implemented in an efficient (and consistent) manner.

  returns: a new PermissionCollection object suitable for
   storing BasicPermissions. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^java.security.BasicPermission this]
    (-> this (.newPermissionCollection))))

