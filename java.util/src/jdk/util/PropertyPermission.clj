(ns jdk.util.PropertyPermission
  "This class is for property permissions.


  The name is the name of the property (`java.home`,
  `os.name`, etc). The naming
  convention follows the  hierarchical property naming convention.
  Also, an asterisk
  may appear at the end of the name, following a `.`, or by itself, to
  signify a wildcard match. For example: `java.*` and `*` signify a wildcard
  match, while `*java` and `a*b` do not.

  The actions to be granted are passed to the constructor in a string containing
  a list of one or more comma-separated keywords. The possible keywords are
  `read` and `write`. Their meaning is defined as follows:


      read
      read permission. Allows System.getProperty to
          be called.
      write
      write permission. Allows System.setProperty to
          be called.


  The actions string is converted to lowercase before processing.

  Care should be taken before granting code permission to access
  certain system properties.  For example, granting permission to
  access the `java.home` system property gives potentially malevolent
  code sensitive information about the system environment (the Java
  installation directory).  Also, granting permission to access
  the `user.name` and `user.home` system properties gives potentially
  malevolent code sensitive information about the user environment
  (the user's account name and home directory)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util PropertyPermission]))

(defn ->property-permission
  "Constructor.

  Creates a new PropertyPermission object with the specified name.
   The name is the name of the system property, and
   actions contains a comma-separated list of the
   desired actions granted on the property. Possible actions are
   `read` and `write`.

  name - the name of the PropertyPermission. - `java.lang.String`
  actions - the actions string. - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null."
  ([^java.lang.String name ^java.lang.String actions]
    (new PropertyPermission name actions)))

(defn implies
  "Checks if this PropertyPermission object `implies` the specified
   permission.

   More specifically, this method returns true if:

    p is an instanceof PropertyPermission,
    p's actions are a subset of this
   object's actions, and
    p's name is implied by this object's
        name. For example, `java.*` implies `java.home`.

  p - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  ([^java.util.PropertyPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Checks two PropertyPermission objects for equality. Checks that obj is
   a PropertyPermission, and has the same name and actions as this object.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if obj is a PropertyPermission, and has the same name and
   actions as this PropertyPermission object. - `boolean`"
  ([^java.util.PropertyPermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this object.
   The hash code used is the hash code of this permissions name, that is,
   getName().hashCode(), where getName is
   from the Permission superclass.

  returns: a hash code value for this object. - `int`"
  ([^java.util.PropertyPermission this]
    (-> this (.hashCode))))

(defn get-actions
  "Returns the `canonical string representation` of the actions.
   That is, this method always returns present actions in the following order:
   read, write. For example, if this PropertyPermission object
   allows both write and read actions, a call to getActions
   will return the string `read,write`.

  returns: the canonical string representation of the actions. - `java.lang.String`"
  ([^java.util.PropertyPermission this]
    (-> this (.getActions))))

(defn new-permission-collection
  "Returns a new PermissionCollection object for storing
   PropertyPermission objects.

  returns: a new PermissionCollection object suitable for storing
   PropertyPermissions. - `java.security.PermissionCollection`"
  ([^java.util.PropertyPermission this]
    (-> this (.newPermissionCollection))))

