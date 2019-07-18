(ns jdk.security.Policy
  "A Policy object is responsible for determining whether code executing
  in the Java runtime environment has permission to perform a
  security-sensitive operation.

   There is only one Policy object installed in the runtime at any
  given time.  A Policy object can be installed by calling the
  setPolicy method.  The installed Policy object can be
  obtained by calling the getPolicy method.

   If no Policy object has been installed in the runtime, a call to
  getPolicy installs an instance of the default Policy
  implementation (a default subclass implementation of this abstract class).
  The default Policy implementation can be changed by setting the value
  of the policy.provider security property to the fully qualified
  name of the desired Policy subclass implementation.

   Application code can directly subclass Policy to provide a custom
  implementation.  In addition, an instance of a Policy object can be
  constructed by invoking one of the getInstance factory methods
  with a standard type.  The default policy type is `JavaPolicy`.

   Once a Policy instance has been installed (either by default, or by
  calling setPolicy), the Java runtime invokes its
  implies method when it needs to
  determine whether executing code (encapsulated in a ProtectionDomain)
  can perform SecurityManager-protected operations.  How a Policy object
  retrieves its policy data is up to the Policy implementation itself.
  The policy data may be stored, for example, in a flat ASCII file,
  in a serialized binary file of the Policy class, or in a database.

   The refresh method causes the policy object to
  refresh/reload its data.  This operation is implementation-dependent.
  For example, if the policy object stores its data in configuration files,
  calling refresh will cause it to re-read the configuration
  policy files.  If a refresh operation is not supported, this method does
  nothing.  Note that refreshed policy may not have an effect on classes
  in a particular ProtectionDomain. This is dependent on the Policy
  provider's implementation of the implies
  method and its PermissionCollection caching strategy."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security Policy]))

(defn ->policy
  "Constructor."
  (^Policy []
    (new Policy )))

(def *-unsupported-empty-collection
  "Static Constant.

  A read-only empty PermissionCollection instance.

  type: java.security.PermissionCollection"
  Policy/UNSUPPORTED_EMPTY_COLLECTION)

(defn *get-policy
  "Returns the installed Policy object. This value should not be cached,
   as it may be changed by a call to setPolicy.
   This method first calls
   SecurityManager.checkPermission with a
   SecurityPermission(`getPolicy`) permission
   to ensure it's ok to get the Policy object.

  returns: the installed Policy. - `java.security.Policy`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow getting the Policy object."
  (^java.security.Policy []
    (Policy/getPolicy )))

(defn *set-policy
  "Sets the system-wide Policy object. This method first calls
   SecurityManager.checkPermission with a
   SecurityPermission(`setPolicy`)
   permission to ensure it's ok to set the Policy.

  p - the new system Policy object. - `java.security.Policy`

  throws: java.lang.SecurityException - if a security manager exists and its checkPermission method doesn't allow setting the Policy."
  ([^java.security.Policy p]
    (Policy/setPolicy p)))

(defn *get-instance
  "Returns a Policy object of the specified type.

    A new Policy object encapsulating the
   PolicySpi implementation from the specified provider
   is returned.   The specified provider must be registered
   in the provider list.

    Note that the list of registered providers may be retrieved via
   the Security.getProviders() method.

  type - the specified Policy type. See the Policy section in the Java Cryptography Architecture Standard Algorithm Name Documentation for a list of standard Policy types. - `java.lang.String`
  params - parameters for the Policy, which may be null. - `java.security.Policy$Parameters`
  provider - the provider. - `java.lang.String`

  returns: the new Policy object. - `java.security.Policy`

  throws: java.lang.SecurityException - if the caller does not have permission to get a Policy instance for the specified type."
  (^java.security.Policy [^java.lang.String type ^java.security.Policy$Parameters params ^java.lang.String provider]
    (Policy/getInstance type params provider))
  (^java.security.Policy [^java.lang.String type ^java.security.Policy$Parameters params]
    (Policy/getInstance type params)))

(defn get-provider
  "Return the Provider of this Policy.

    This Policy instance will only have a Provider if it
   was obtained via a call to Policy.getInstance.
   Otherwise this method returns null.

  returns: the Provider of this Policy, or null. - `java.security.Provider`"
  (^java.security.Provider [^Policy this]
    (-> this (.getProvider))))

(defn get-type
  "Return the type of this Policy.

    This Policy instance will only have a type if it
   was obtained via a call to Policy.getInstance.
   Otherwise this method returns null.

  returns: the type of this Policy, or null. - `java.lang.String`"
  (^java.lang.String [^Policy this]
    (-> this (.getType))))

(defn get-parameters
  "Return Policy parameters.

    This Policy instance will only have parameters if it
   was obtained via a call to Policy.getInstance.
   Otherwise this method returns null.

  returns: Policy parameters, or null. - `java.security.Policy$Parameters`"
  (^java.security.Policy$Parameters [^Policy this]
    (-> this (.getParameters))))

(defn get-permissions
  "Return a PermissionCollection object containing the set of
   permissions granted to the specified CodeSource.

    Applications are discouraged from calling this method
   since this operation may not be supported by all policy implementations.
   Applications should solely rely on the implies method
   to perform policy checks.  If an application absolutely must call
   a getPermissions method, it should call
   getPermissions(ProtectionDomain).

    The default implementation of this method returns
   Policy.UNSUPPORTED_EMPTY_COLLECTION.  This method can be
   overridden if the policy implementation can return a set of
   permissions granted to a CodeSource.

  codesource - the CodeSource to which the returned PermissionCollection has been granted. - `java.security.CodeSource`

  returns: a set of permissions granted to the specified CodeSource.
            If this operation is supported, the returned
            set of permissions must be a new mutable instance
            and it must support heterogeneous Permission types.
            If this operation is not supported,
            Policy.UNSUPPORTED_EMPTY_COLLECTION is returned. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^Policy this ^java.security.CodeSource codesource]
    (-> this (.getPermissions codesource))))

(defn implies
  "Evaluates the global policy for the permissions granted to
   the ProtectionDomain and tests whether the permission is
   granted.

  domain - the ProtectionDomain to test - `java.security.ProtectionDomain`
  permission - the Permission object to be tested for implication. - `java.security.Permission`

  returns: true if `permission` is a proper subset of a permission
   granted to this ProtectionDomain. - `boolean`"
  (^Boolean [^Policy this ^java.security.ProtectionDomain domain ^java.security.Permission permission]
    (-> this (.implies domain permission))))

(defn refresh
  "Refreshes/reloads the policy configuration. The behavior of this method
   depends on the implementation. For example, calling refresh
   on a file-based policy will cause the file to be re-read.

    The default implementation of this method does nothing.
   This method should be overridden if a refresh operation is supported
   by the policy implementation."
  ([^Policy this]
    (-> this (.refresh))))

