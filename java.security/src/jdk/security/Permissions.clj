(ns jdk.security.Permissions
  "This class represents a heterogeneous collection of Permissions. That is,
  it contains different types of Permission objects, organized into
  PermissionCollections. For example, if any
  java.io.FilePermission objects are added to an instance of
  this class, they are all stored in a single
  PermissionCollection. It is the PermissionCollection returned by a call to
  the newPermissionCollection method in the FilePermission class.
  Similarly, any java.lang.RuntimePermission objects are
  stored in the PermissionCollection returned by a call to the
  newPermissionCollection method in the
  RuntimePermission class. Thus, this class represents a collection of
  PermissionCollections.

  When the add method is called to add a Permission, the
  Permission is stored in the appropriate PermissionCollection. If no such
  collection exists yet, the Permission object's class is determined and the
  newPermissionCollection method is called on that class to create
  the PermissionCollection and add it to the Permissions object. If
  newPermissionCollection returns null, then a default
  PermissionCollection that uses a hashtable will be created and used. Each
  hashtable entry stores a Permission object as both the key and the value.

   Enumerations returned via the elements method are
  not fail-fast.  Modifications to a collection should not be
  performed while enumerating over that collection."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Permissions]))

(defn ->permissions
  "Constructor.

  Creates a new Permissions object containing no PermissionCollections."
  (^Permissions []
    (new Permissions )))

(defn add
  "Adds a permission object to the PermissionCollection for the class the
   permission belongs to. For example, if permission is a
   FilePermission, it is added to the FilePermissionCollection stored
   in this Permissions object.

   This method creates
   a new PermissionCollection object (and adds the permission to it)
   if an appropriate collection does not yet exist.

  permission - the Permission object to add. - `java.security.Permission`

  throws: java.lang.SecurityException - if this Permissions object is marked as readonly."
  ([^Permissions this ^java.security.Permission permission]
    (-> this (.add permission))))

(defn implies
  "Checks to see if this object's PermissionCollection for permissions of
   the specified permission's class implies the permissions
   expressed in the permission object. Returns true if the
   combination of permissions in the appropriate PermissionCollection
   (e.g., a FilePermissionCollection for a FilePermission) together
   imply the specified permission.

   For example, suppose there is a FilePermissionCollection in this
   Permissions object, and it contains one FilePermission that specifies
   `read` access for  all files in all subdirectories of the `/tmp`
   directory, and another FilePermission that specifies `write` access
   for all files in the `/tmp/scratch/foo` directory.
   Then if the implies method
   is called with a permission specifying both `read` and `write` access
   to files in the `/tmp/scratch/foo` directory, true is
   returned.

   Additionally, if this PermissionCollection contains the
   AllPermission, this method will always return true.

  permission - the Permission object to check. - `java.security.Permission`

  returns: true if `permission` is implied by the permissions in the
   PermissionCollection it
   belongs to, false if not. - `boolean`"
  (^Boolean [^Permissions this ^java.security.Permission permission]
    (-> this (.implies permission))))

(defn elements
  "Returns an enumeration of all the Permission objects in all the
   PermissionCollections in this Permissions object.

  returns: an enumeration of all the Permissions. - `java.util.Enumeration<java.security.Permission>`"
  (^java.util.Enumeration [^Permissions this]
    (-> this (.elements))))

