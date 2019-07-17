(ns jdk.security.Permission
  "Abstract class for representing access to a system resource.
  All permissions have a name (whose interpretation depends on the subclass),
  as well as abstract functions for defining the semantics of the
  particular Permission subclass.

  Most Permission objects also include an `actions` list that tells the actions
  that are permitted for the object.  For example,
  for a java.io.FilePermission object, the permission name is
  the pathname of a file (or directory), and the actions list
  (such as `read, write`) specifies which actions are granted for the
  specified file (or for files in the specified directory).
  The actions list is optional for Permission objects, such as
  java.lang.RuntimePermission,
  that don't need such a list; you either have the named permission (such
  as `system.exit`) or you don't.

  An important method that must be implemented by each subclass is
  the implies method to compare Permissions. Basically,
  `permission p1 implies permission p2` means that
  if one is granted permission p1, one is naturally granted permission p2.
  Thus, this is not an equality test, but rather more of a
  subset test.

   Permission objects are similar to String objects in that they
  are immutable once they have been created. Subclasses should not
  provide methods that can change the state of a permission
  once it has been created."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Permission]))

(defn ->permission
  "Constructor.

  Constructs a permission with the specified name.

  name - name of the Permission object being created. - `java.lang.String`"
  ([name]
    (new Permission name)))

(defn check-guard
  "Implements the guard interface for a permission. The
   SecurityManager.checkPermission method is called,
   passing this permission object as the permission to check.
   Returns silently if access is granted. Otherwise, throws
   a SecurityException.

  object - the object being guarded (currently ignored). - `java.lang.Object`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow access."
  ([this object]
    (-> this (.checkGuard object))))

(defn implies
  "Checks if the specified permission's actions are `implied by`
   this object's actions.

   This must be implemented by subclasses of Permission, as they are the
   only ones that can impose semantics on a Permission object.

   The implies method is used by the AccessController to determine
   whether or not a requested permission is implied by another permission that
   is known to be valid in the current execution context.

  permission - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  ([this permission]
    (-> this (.implies permission))))

(defn equals
  "Checks two Permission objects for equality.

   Do not use the equals method for making access control
   decisions; use the implies method.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if both Permission objects are equivalent. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this Permission object.

   The required hashCode behavior for Permission Objects is
   the following:

   Whenever it is invoked on the same Permission object more than
       once during an execution of a Java application, the
       hashCode method
       must consistently return the same integer. This integer need not
       remain consistent from one execution of an application to another
       execution of the same application.
   If two Permission objects are equal according to the
       equals
       method, then calling the hashCode method on each of the
       two Permission objects must produce the same integer result.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-name
  "Returns the name of this Permission.
   For example, in the case of a java.io.FilePermission,
   the name will be a pathname.

  returns: the name of this Permission. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-actions
  "Returns the actions as a String. This is abstract
   so subclasses can defer creating a String representation until
   one is needed. Subclasses should always return actions in what they
   consider to be their
   canonical form. For example, two FilePermission objects created via
   the following:



     perm1 = new FilePermission(p1,`read,write`);
     perm2 = new FilePermission(p2,`write,read`);

   both return
   `read,write` when the getActions method is invoked.

  returns: the actions of this Permission. - `java.lang.String`"
  ([this]
    (-> this (.getActions))))

(defn new-permission-collection
  "Returns an empty PermissionCollection for a given Permission object, or null if
   one is not defined. Subclasses of class Permission should
   override this if they need to store their permissions in a particular
   PermissionCollection object in order to provide the correct semantics
   when the PermissionCollection.implies method is called.
   If null is returned,
   then the caller of this method is free to store permissions of this
   type in any PermissionCollection they choose (one that uses a Hashtable,
   one that uses a Vector, etc).

  returns: a new PermissionCollection object for this type of Permission, or
   null if one is not defined. - `java.security.PermissionCollection`"
  ([this]
    (-> this (.newPermissionCollection))))

(defn to-string
  "Returns a string describing this Permission.  The convention is to
   specify the class name, the permission name, and the actions in
   the following format: '(`ClassName` `name` `actions`)', or
   '(`ClassName` `name`)' if actions list is null or empty.

  returns: information about this Permission. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

