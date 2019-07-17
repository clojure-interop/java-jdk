(ns javax.management.MBeanServerPermission
  "A Permission to perform actions related to MBeanServers.
     The name of the permission specifies the operation requested
     or granted by the permission.  For a granted permission, it can be
     * to allow all of the MBeanServer operations specified below.
     Otherwise, for a granted or requested permission, it must be one of the
     following:

     createMBeanServer
     Create a new MBeanServer object using the method
     MBeanServerFactory.createMBeanServer() or
     MBeanServerFactory.createMBeanServer(java.lang.String).
     findMBeanServer
     Find an MBeanServer with a given name, or all MBeanServers in this
     JVM, using the method MBeanServerFactory.findMBeanServer(java.lang.String).
     newMBeanServer
     Create a new MBeanServer object without keeping a reference to it,
     using the method MBeanServerFactory.newMBeanServer() or
     MBeanServerFactory.newMBeanServer(java.lang.String).
     releaseMBeanServer
     Remove the MBeanServerFactory's reference to an MBeanServer,
     using the method MBeanServerFactory.releaseMBeanServer(javax.management.MBeanServer).

     The name of the permission can also denote a list of one or more
     comma-separated operations.  Spaces are allowed at the beginning and
     end of the name and before and after commas.

     MBeanServerPermission(`createMBeanServer`) implies
     MBeanServerPermission(`newMBeanServer`)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanServerPermission]))

(defn ->m-bean-server-permission
  "Constructor.

  Create a new MBeanServerPermission with the given name.

  name - the name of the granted permission. It must respect the constraints spelt out in the description of the MBeanServerPermission class. - `java.lang.String`
  actions - the associated actions. This parameter is not currently used and must be null or the empty string. - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null."
  ([^java.lang.String name ^java.lang.String actions]
    (new MBeanServerPermission name actions))
  ([^java.lang.String name]
    (new MBeanServerPermission name)))

(defn hash-code
  "Description copied from class: BasicPermission

  returns: a hash code value for this object. - `int`"
  ([^javax.management.MBeanServerPermission this]
    (-> this (.hashCode))))

(defn implies
  "Checks if this MBeanServerPermission object `implies` the specified
   permission.

   More specifically, this method returns true if:


    p is an instance of MBeanServerPermission,
    p's target names are a subset of this object's target
   names


   The createMBeanServer permission implies the
   newMBeanServer permission.

  p - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  ([^javax.management.MBeanServerPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Checks two MBeanServerPermission objects for equality. Checks that
   obj is an MBeanServerPermission, and represents the same
   list of allowable actions as this object.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if the objects are equal. - `boolean`"
  ([^javax.management.MBeanServerPermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn new-permission-collection
  "Description copied from class: BasicPermission

  returns: a new PermissionCollection object suitable for
   storing BasicPermissions. - `java.security.PermissionCollection`"
  ([^javax.management.MBeanServerPermission this]
    (-> this (.newPermissionCollection))))

