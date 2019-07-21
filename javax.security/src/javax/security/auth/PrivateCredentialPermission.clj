(ns javax.security.auth.PrivateCredentialPermission
  "This class is used to protect access to private Credentials
  belonging to a particular Subject.  The Subject
  is represented by a Set of Principals.

   The target name of this Permission specifies
  a Credential class name, and a Set of Principals.
  The only valid value for this Permission's actions is, \"read\".
  The target name must abide by the following syntax:



       CredentialClass {PrincipalClass \"PrincipalName\"}*

  For example, the following permission grants access to the
  com.sun.PrivateCredential owned by Subjects which have
  a com.sun.Principal with the name, \"duke\".  Note that although
  this example, as well as all the examples below, do not contain
  Codebase, SignedBy, or Principal information in the grant statement
  (for simplicity reasons), actual policy configurations should
  specify that information when appropriate.



     grant {
       permission javax.security.auth.PrivateCredentialPermission
               \"com.sun.PrivateCredential com.sun.Principal \\\"duke\\\"\",
               \"read\";
     };

  If CredentialClass is \"*\", then access is granted to
  all private Credentials belonging to the specified
  Subject.
  If \"PrincipalName\" is \"*\", then access is granted to the
  specified Credential owned by any Subject that has the
  specified Principal (the actual PrincipalName doesn't matter).
  For example, the following grants access to the
  a.b.Credential owned by any Subject that has
  an a.b.Principal.



     grant {
       permission javax.security.auth.PrivateCredentialPermission
               \"a.b.Credential a.b.Principal \"*\"\",
               \"read\";
     };

  If both the PrincipalClass and \"PrincipalName\" are \"*\",
  then access is granted to the specified Credential owned by
  any Subject.

   In addition, the PrincipalClass/PrincipalName pairing may be repeated:



     grant {
       permission javax.security.auth.PrivateCredentialPermission
               \"a.b.Credential a.b.Principal \"duke\" c.d.Principal \"dukette\"\",
               \"read\";
     };

  The above grants access to the private Credential, \"a.b.Credential\",
  belonging to a Subject with at least two associated Principals:
  \"a.b.Principal\" with the name, \"duke\", and \"c.d.Principal\", with the name,
  \"dukette\"."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth PrivateCredentialPermission]))

(defn ->private-credential-permission
  "Constructor.

  Creates a new PrivateCredentialPermission
   with the specified name.  The name
   specifies both a Credential class and a Principal Set.

  name - the name specifying the Credential class and Principal Set. - `java.lang.String`
  actions - the actions specifying that the Credential can be read. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if name does not conform to the correct syntax or if actions is not \"read\"."
  (^PrivateCredentialPermission [^java.lang.String name ^java.lang.String actions]
    (new PrivateCredentialPermission name actions)))

(defn get-credential-class
  "Returns the Class name of the Credential associated with this
   PrivateCredentialPermission.

  returns: the Class name of the Credential associated with this
            PrivateCredentialPermission. - `java.lang.String`"
  (^java.lang.String [^PrivateCredentialPermission this]
    (-> this (.getCredentialClass))))

(defn get-principals
  "Returns the Principal classes and names
   associated with this PrivateCredentialPermission.
   The information is returned as a two-dimensional array (array[x][y]).
   The 'x' value corresponds to the number of Principal
   class and name pairs.  When (y==0), it corresponds to
   the Principal class value, and when (y==1),
   it corresponds to the Principal name value.
   For example, array[0][0] corresponds to the class name of
   the first Principal in the array.  array[0][1]
   corresponds to the Principal name of the
   first Principal in the array.

  returns: the Principal class and names associated
            with this PrivateCredentialPermission. - `java.lang.String[][]`"
  ([^PrivateCredentialPermission this]
    (-> this (.getPrincipals))))

(defn implies
  "Checks if this PrivateCredentialPermission implies
   the specified Permission.



   This method returns true if:

    p is an instanceof PrivateCredentialPermission and
    the target name for p is implied by this object's
            target name.  For example:


    [* P1 \"duke\"] implies [a.b.Credential P1 \"duke\"].
    [C1 P1 \"duke\"] implies [C1 P1 \"duke\" P2 \"dukette\"].
    [C1 P2 \"dukette\"] implies [C1 P1 \"duke\" P2 \"dukette\"].

  p - the Permission to check against. - `java.security.Permission`

  returns: true if this PrivateCredentialPermission implies
   the specified Permission, false if not. - `boolean`"
  (^Boolean [^PrivateCredentialPermission this ^java.security.Permission p]
    (-> this (.implies p))))

(defn equals
  "Checks two PrivateCredentialPermission objects for
   equality.  Checks that obj is a
   PrivateCredentialPermission,
   and has the same credential class as this object,
   as well as the same Principals as this object.
   The order of the Principals in the respective Permission's
   target names is not relevant.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if obj is a PrivateCredentialPermission,
            has the same credential class as this object,
            and has the same Principals as this object. - `boolean`"
  (^Boolean [^PrivateCredentialPermission this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this object.

  returns: a hash code value for this object. - `int`"
  (^Integer [^PrivateCredentialPermission this]
    (-> this (.hashCode))))

(defn get-actions
  "Returns the \"canonical string representation\" of the actions.
   This method always returns the String, \"read\".

  returns: the actions (always returns \"read\"). - `java.lang.String`"
  (^java.lang.String [^PrivateCredentialPermission this]
    (-> this (.getActions))))

(defn new-permission-collection
  "Return a homogeneous collection of PrivateCredentialPermissions
   in a PermissionCollection.
   No such PermissionCollection is defined,
   so this method always returns null.

  returns: null in all cases. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^PrivateCredentialPermission this]
    (-> this (.newPermissionCollection))))

