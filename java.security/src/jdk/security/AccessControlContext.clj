(ns jdk.security.AccessControlContext
  "An AccessControlContext is used to make system resource access decisions
  based on the context it encapsulates.

  More specifically, it encapsulates a context and
  has a single method, checkPermission,
  that is equivalent to the checkPermission method
  in the AccessController class, with one difference: The AccessControlContext
  checkPermission method makes access decisions based on the
  context it encapsulates,
  rather than that of the current execution thread.

  Thus, the purpose of AccessControlContext is for those situations where
  a security check that should be made within a given context
  actually needs to be done from within a
  different context (for example, from within a worker thread).

   An AccessControlContext is created by calling the
  AccessController.getContext method.
  The getContext method takes a `snapshot`
  of the current calling context, and places
  it in an AccessControlContext object, which it returns. A sample call is
  the following:



    AccessControlContext acc = AccessController.getContext()


  Code within a different context can subsequently call the
  checkPermission method on the
  previously-saved AccessControlContext object. A sample call is the
  following:



    acc.checkPermission(permission)"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security AccessControlContext]))

(defn ->access-control-context
  "Constructor.

  Create a new AccessControlContext with the given
   AccessControlContext and DomainCombiner.
   This constructor associates the provided
   DomainCombiner with the provided
   AccessControlContext.

  acc - the AccessControlContext associated with the provided DomainCombiner. - `java.security.AccessControlContext`
  combiner - the DomainCombiner to be associated with the provided AccessControlContext. - `java.security.DomainCombiner`

  throws: java.lang.NullPointerException - if the provided context is null."
  (^AccessControlContext [^java.security.AccessControlContext acc ^java.security.DomainCombiner combiner]
    (new AccessControlContext acc combiner))
  (^AccessControlContext [context]
    (new AccessControlContext context)))

(defn get-domain-combiner
  "Get the DomainCombiner associated with this
   AccessControlContext.

  returns: the DomainCombiner associated with this
            AccessControlContext, or null
            if there is none. - `java.security.DomainCombiner`

  throws: java.lang.SecurityException - if a security manager is installed and the caller does not have the `getDomainCombiner` SecurityPermission"
  (^java.security.DomainCombiner [^AccessControlContext this]
    (-> this (.getDomainCombiner))))

(defn check-permission
  "Determines whether the access request indicated by the
   specified permission should be allowed or denied, based on
   the security policy currently in effect, and the context in
   this object. The request is allowed only if every ProtectionDomain
   in the context implies the permission. Otherwise the request is
   denied.


   This method quietly returns if the access request
   is permitted, or throws a suitable AccessControlException otherwise.

  perm - the requested permission. - `java.security.Permission`

  throws: java.security.AccessControlException - if the specified permission is not permitted, based on the current security policy and the context encapsulated by this object."
  ([^AccessControlContext this ^java.security.Permission perm]
    (-> this (.checkPermission perm))))

(defn equals
  "Checks two AccessControlContext objects for equality.
   Checks that obj is
   an AccessControlContext and has the same set of ProtectionDomains
   as this context.

  obj - the object we are testing for equality with this object. - `java.lang.Object`

  returns: true if obj is an AccessControlContext, and has the
   same set of ProtectionDomains as this context, false otherwise. - `boolean`"
  (^Boolean [^AccessControlContext this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns the hash code value for this context. The hash code
   is computed by exclusive or-ing the hash code of all the protection
   domains in the context together.

  returns: a hash code value for this context. - `int`"
  (^Integer [^AccessControlContext this]
    (-> this (.hashCode))))

