(ns jdk.security.UnresolvedPermission
  "The UnresolvedPermission class is used to hold Permissions that
  were \"unresolved\" when the Policy was initialized.
  An unresolved permission is one whose actual Permission class
  does not yet exist at the time the Policy is initialized (see below).

  The policy for a Java runtime (specifying
  which permissions are available for code from various principals)
  is represented by a Policy object.
  Whenever a Policy is initialized or refreshed, Permission objects of
  appropriate classes are created for all permissions
  allowed by the Policy.

  Many permission class types
  referenced by the policy configuration are ones that exist
  locally (i.e., ones that can be found on CLASSPATH).
  Objects for such permissions can be instantiated during
  Policy initialization. For example, it is always possible
  to instantiate a java.io.FilePermission, since the
  FilePermission class is found on the CLASSPATH.

  Other permission classes may not yet exist during Policy
  initialization. For example, a referenced permission class may
  be in a JAR file that will later be loaded.
  For each such class, an UnresolvedPermission is instantiated.
  Thus, an UnresolvedPermission is essentially a \"placeholder\"
  containing information about the permission.

  Later, when code calls AccessController.checkPermission
  on a permission of a type that was previously unresolved,
  but whose class has since been loaded, previously-unresolved
  permissions of that type are \"resolved\". That is,
  for each such UnresolvedPermission, a new object of
  the appropriate class type is instantiated, based on the
  information in the UnresolvedPermission.

   To instantiate the new class, UnresolvedPermission assumes
  the class provides a zero, one, and/or two-argument constructor.
  The zero-argument constructor would be used to instantiate
  a permission without a name and without actions.
  A one-arg constructor is assumed to take a String
  name as input, and a two-arg constructor is assumed to take a
  String name and String actions
  as input.  UnresolvedPermission may invoke a
  constructor with a null name and/or actions.
  If an appropriate permission constructor is not available,
  the UnresolvedPermission is ignored and the relevant permission
  will not be granted to executing code.

   The newly created permission object replaces the
  UnresolvedPermission, which is removed.

   Note that the getName method for an
  UnresolvedPermission returns the
  type (class name) for the underlying permission
  that has not been resolved."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security UnresolvedPermission]))

(defn ->unresolved-permission
  "Constructor.

  Creates a new UnresolvedPermission containing the permission
   information needed later to actually create a Permission of the
   specified class, when the permission is resolved.

  type - the class name of the Permission class that will be created when this unresolved permission is resolved. - `java.lang.String`
  name - the name of the permission. - `java.lang.String`
  actions - the actions of the permission. - `java.lang.String`
  certs - the certificates the permission's class was signed with. This is a list of certificate chains, where each chain is composed of a signer certificate and optionally its supporting certificate chain. Each chain is ordered bottom-to-top (i.e., with the signer certificate first and the (root) certificate authority last). The signer certificates are copied from the array. Subsequent changes to the array will not affect this UnsolvedPermission. - `java.security.cert.Certificate[]`"
  (^UnresolvedPermission [^java.lang.String type ^java.lang.String name ^java.lang.String actions certs]
    (new UnresolvedPermission type name actions certs)))

(defn get-unresolved-type
  "Get the type (class name) of the underlying permission that
   has not been resolved.

  returns: the type (class name) of the underlying permission that
    has not been resolved - `java.lang.String`"
  (^java.lang.String [^UnresolvedPermission this]
    (-> this (.getUnresolvedType))))

(defn get-unresolved-name
  "Get the target name of the underlying permission that
   has not been resolved.

  returns: the target name of the underlying permission that
            has not been resolved, or null,
            if there is no target name - `java.lang.String`"
  (^java.lang.String [^UnresolvedPermission this]
    (-> this (.getUnresolvedName))))

(defn implies
  "This method always returns false for unresolved permissions.
   That is, an UnresolvedPermission is never considered to
   imply another permission.

  p - the permission to check against. - `java.security.Permission`

  returns: false. - `boolean`"
  (^Boolean [^UnresolvedPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn to-string
  "Returns a string describing this UnresolvedPermission.  The convention
   is to specify the class name, the permission name, and the actions, in
   the following format: '(unresolved \"ClassName\" \"name\" \"actions\")'.

  returns: information about this UnresolvedPermission. - `java.lang.String`"
  (^java.lang.String [^UnresolvedPermission this]
    (-> this (.toString))))

(defn get-actions
  "Returns the canonical string representation of the actions,
   which currently is the empty string \"\", since there are no actions for
   an UnresolvedPermission. That is, the actions for the
   permission that will be created when this UnresolvedPermission
   is resolved may be non-null, but an UnresolvedPermission
   itself is never considered to have any actions.

  returns: the empty string \"\". - `java.lang.String`"
  (^java.lang.String [^UnresolvedPermission this]
    (-> this (.getActions))))

(defn get-unresolved-certs
  "Get the signer certificates (without any supporting chain)
   for the underlying permission that has not been resolved.

  returns: the signer certificates for the underlying permission that
   has not been resolved, or null, if there are no signer certificates.
   Returns a new array each time this method is called. - `java.security.cert.Certificate[]`"
  ([^UnresolvedPermission this]
    (-> this (.getUnresolvedCerts))))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  (^Integer [^UnresolvedPermission this]
    (-> this (.hashCode))))

(defn get-unresolved-actions
  "Get the actions for the underlying permission that
   has not been resolved.

  returns: the actions for the underlying permission that
            has not been resolved, or null
            if there are no actions - `java.lang.String`"
  (^java.lang.String [^UnresolvedPermission this]
    (-> this (.getUnresolvedActions))))

(defn new-permission-collection
  "Returns a new PermissionCollection object for storing
   UnresolvedPermission  objects.

  returns: a new PermissionCollection object suitable for
   storing UnresolvedPermissions. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^UnresolvedPermission this]
    (-> this (.newPermissionCollection))))

(defn equals
  "Checks two UnresolvedPermission objects for equality.
   Checks that obj is an UnresolvedPermission, and has
   the same type (class) name, permission name, actions, and
   certificates as this object.

    To determine certificate equality, this method only compares
   actual signer certificates.  Supporting certificate chains
   are not taken into consideration by this method.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if obj is an UnresolvedPermission, and has the same
   type (class) name, permission name, actions, and
   certificates as this object. - `boolean`"
  (^Boolean [^UnresolvedPermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

