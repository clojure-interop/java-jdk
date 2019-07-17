(ns javax.security.auth.kerberos.DelegationPermission
  "This class is used to restrict the usage of the Kerberos
  delegation model, ie: forwardable and proxiable tickets.

  The target name of this Permission specifies a pair of
  kerberos service principals. The first is the subordinate service principal
  being entrusted to use the TGT. The second service principal designates
  the target service the subordinate service principal is to
  interact with on behalf of the initiating KerberosPrincipal. This
  latter service principal is specified to restrict the use of a
  proxiable ticket.

  For example, to specify the `host` service use of a forwardable TGT the
  target permission is specified as follows:



   DelegationPermission(`\`host/foo.example.com@EXAMPLE.COM\` \`krbtgt/EXAMPLE.COM@EXAMPLE.COM\``);

  To give the `backup` service a proxiable nfs service ticket the target permission
  might be specified:



   DelegationPermission(`\`backup/bar.example.com@EXAMPLE.COM\` \`nfs/home.EXAMPLE.COM@EXAMPLE.COM\``);"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.kerberos DelegationPermission]))

(defn ->delegation-permission
  "Constructor.

  Create a new DelegationPermission
   with the specified subordinate and target principals.

  principals - the name of the subordinate and target principals - `java.lang.String`
  actions - should be null. - `java.lang.String`

  throws: java.lang.NullPointerException - if principals is null."
  ([^java.lang.String principals ^java.lang.String actions]
    (new DelegationPermission principals actions))
  ([^java.lang.String principals]
    (new DelegationPermission principals)))

(defn implies
  "Checks if this Kerberos delegation permission object `implies` the
   specified permission.

   If none of the above are true, implies returns false.

  p - the permission to check against. - `java.security.Permission`

  returns: true if the specified permission is implied by this object,
   false if not. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.DelegationPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Checks two DelegationPermission objects for equality.

  obj - the object to test for equality with this object. - `java.lang.Object`

  returns: true if obj is a DelegationPermission, and
    has the same subordinate and service principal as this.
    DelegationPermission object. - `boolean`"
  (^Boolean [^javax.security.auth.kerberos.DelegationPermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  (^Integer [^javax.security.auth.kerberos.DelegationPermission this]
    (-> this (.hashCode))))

(defn new-permission-collection
  "Returns a PermissionCollection object for storing
   DelegationPermission objects.

   DelegationPermission objects must be stored in a manner that
   allows them to be inserted into the collection in any order, but
   that also enables the PermissionCollection implies method to
   be implemented in an efficient (and consistent) manner.

  returns: a new PermissionCollection object suitable for storing
   DelegationPermissions. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^javax.security.auth.kerberos.DelegationPermission this]
    (-> this (.newPermissionCollection))))

