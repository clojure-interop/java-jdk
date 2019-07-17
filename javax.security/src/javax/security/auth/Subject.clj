(ns javax.security.auth.Subject
  " A Subject represents a grouping of related information
  for a single entity, such as a person.
  Such information includes the Subject's identities as well as
  its security-related attributes
  (passwords and cryptographic keys, for example).

   Subjects may potentially have multiple identities.
  Each identity is represented as a Principal
  within the Subject.  Principals simply bind names to a
  Subject.  For example, a Subject that happens
  to be a person, Alice, might have two Principals:
  one which binds `Alice Bar`, the name on her driver license,
  to the Subject, and another which binds,
  `999-99-9999`, the number on her student identification card,
  to the Subject.  Both Principals refer to the same
  Subject even though each has a different name.

   A Subject may also own security-related attributes,
  which are referred to as credentials.
  Sensitive credentials that require special protection, such as
  private cryptographic keys, are stored within a private credential
  Set.  Credentials intended to be shared, such as
  public key certificates or Kerberos server tickets are stored
  within a public credential Set.  Different permissions
  are required to access and modify the different credential Sets.

   To retrieve all the Principals associated with a Subject,
  invoke the getPrincipals method.  To retrieve
  all the public or private credentials belonging to a Subject,
  invoke the getPublicCredentials method or
  getPrivateCredentials method, respectively.
  To modify the returned Set of Principals and credentials,
  use the methods defined in the Set class.
  For example:


       Subject subject;
       Principal principal;
       Object credential;

       // add a Principal and credential to the Subject
       subject.getPrincipals().add(principal);
       subject.getPublicCredentials().add(credential);

   This Subject class implements Serializable.
  While the Principals associated with the Subject are serialized,
  the credentials associated with the Subject are not.
  Note that the java.security.Principal class
  does not implement Serializable.  Therefore all concrete
  Principal implementations associated with Subjects
  must implement Serializable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth Subject]))

(defn ->subject
  "Constructor.

  Create an instance of a Subject with
   Principals and credentials.

    The Principals and credentials from the specified Sets
   are copied into newly constructed Sets.
   These newly created Sets check whether this Subject
   has been set read-only before permitting subsequent modifications.
   The newly created Sets also prevent illegal modifications
   by ensuring that callers have sufficient permissions.

    To modify the Principals Set, the caller must have
   AuthPermission(`modifyPrincipals`).
   To modify the public credential Set, the caller must have
   AuthPermission(`modifyPublicCredentials`).
   To modify the private credential Set, the caller must have
   AuthPermission(`modifyPrivateCredentials`).

  read-only - true if the Subject is to be read-only, and false otherwise. - `boolean`
  principals - the Set of Principals to be associated with this Subject. - `java.security.Principal>`
  pub-credentials - the Set of public credentials to be associated with this Subject. - `java.util.Set<?>`
  priv-credentials - the Set of private credentials to be associated with this Subject. - `java.util.Set<?>`

  throws: java.lang.NullPointerException - if the specified principals, pubCredentials, or privCredentials are null."
  ([^Boolean read-only ^java.security.Principal> principals ^java.util.Set pub-credentials ^java.util.Set priv-credentials]
    (new Subject read-only principals pub-credentials priv-credentials))
  ([]
    (new Subject )))

(defn *get-subject
  "Get the Subject associated with the provided
   AccessControlContext.

    The AccessControlContext may contain many
   Subjects (from nested doAs calls).
   In this situation, the most recent Subject associated
   with the AccessControlContext is returned.

  acc - the AccessControlContext from which to retrieve the Subject. - `java.security.AccessControlContext`

  returns: the Subject associated with the provided
            AccessControlContext, or null
            if no Subject is associated
            with the provided AccessControlContext. - `javax.security.auth.Subject`

  throws: java.lang.SecurityException - if the caller does not have permission to get the Subject."
  ([^java.security.AccessControlContext acc]
    (Subject/getSubject acc)))

(defn *do-as
  "Perform work as a particular Subject.

    This method first retrieves the current Thread's
   AccessControlContext via
   AccessController.getContext,
   and then instantiates a new AccessControlContext
   using the retrieved context along with a new
   SubjectDomainCombiner (constructed using
   the provided Subject).
   Finally, this method invokes AccessController.doPrivileged,
   passing it the provided PrivilegedAction,
   as well as the newly constructed AccessControlContext.

  subject - the Subject that the specified action will run as. This parameter may be null. - `javax.security.auth.Subject`
  action - the code to be run as the specified Subject. - `java.security.PrivilegedAction<T>`

  returns: the value returned by the PrivilegedAction's
                    run method. - `<T> T`

  throws: java.lang.NullPointerException - if the PrivilegedAction is null."
  ([^javax.security.auth.Subject subject ^java.security.PrivilegedAction action]
    (Subject/doAs subject action)))

(defn *do-as-privileged
  "Perform privileged work as a particular Subject.

    This method behaves exactly as Subject.doAs,
   except that instead of retrieving the current Thread's
   AccessControlContext, it uses the provided
   AccessControlContext.  If the provided
   AccessControlContext is null,
   this method instantiates a new AccessControlContext
   with an empty collection of ProtectionDomains.

  subject - the Subject that the specified action will run as. This parameter may be null. - `javax.security.auth.Subject`
  action - the code to be run as the specified Subject. - `java.security.PrivilegedAction<T>`
  acc - the AccessControlContext to be tied to the specified subject and action. - `java.security.AccessControlContext`

  returns: the value returned by the PrivilegedAction's
                    run method. - `<T> T`

  throws: java.lang.NullPointerException - if the PrivilegedAction is null."
  ([^javax.security.auth.Subject subject ^java.security.PrivilegedAction action ^java.security.AccessControlContext acc]
    (Subject/doAsPrivileged subject action acc)))

(defn set-read-only
  "Set this Subject to be read-only.

    Modifications (additions and removals) to this Subject's
   Principal Set and
   credential Sets will be disallowed.
   The destroy operation on this Subject's credentials will
   still be permitted.

    Subsequent attempts to modify the Subject's Principal
   and credential Sets will result in an
   IllegalStateException being thrown.
   Also, once a Subject is read-only,
   it can not be reset to being writable again.

  throws: java.lang.SecurityException - if the caller does not have permission to set this Subject to be read-only."
  ([^javax.security.auth.Subject this]
    (-> this (.setReadOnly))))

(defn read-only?
  "Query whether this Subject is read-only.

  returns: true if this Subject is read-only, false otherwise. - `boolean`"
  ([^javax.security.auth.Subject this]
    (-> this (.isReadOnly))))

(defn get-principals
  "Return a Set of Principals associated with this
   Subject that are instances or subclasses of the specified
   Class.

    The returned Set is not backed by this Subject's
   internal Principal Set.  A new
   Set is created and returned for each method invocation.
   Modifications to the returned Set
   will not affect the internal Principal Set.

  c - the returned Set of Principals will all be instances of this class. - `java.lang.Class<T>`

  returns: a Set of Principals that are instances of the
            specified Class. - `<T extends java.security.Principal> java.util.Set<T>`

  throws: java.lang.NullPointerException - if the specified Class is null."
  ([^javax.security.auth.Subject this ^java.lang.Class c]
    (-> this (.getPrincipals c)))
  ([^javax.security.auth.Subject this]
    (-> this (.getPrincipals))))

(defn get-public-credentials
  "Return a Set of public credentials associated with this
   Subject that are instances or subclasses of the specified
   Class.

    The returned Set is not backed by this Subject's
   internal public Credential Set.  A new
   Set is created and returned for each method invocation.
   Modifications to the returned Set
   will not affect the internal public Credential Set.

  c - the returned Set of public credentials will all be instances of this class. - `java.lang.Class<T>`

  returns: a Set of public credentials that are instances
            of the  specified Class. - `<T> java.util.Set<T>`

  throws: java.lang.NullPointerException - if the specified Class is null."
  ([^javax.security.auth.Subject this ^java.lang.Class c]
    (-> this (.getPublicCredentials c)))
  ([^javax.security.auth.Subject this]
    (-> this (.getPublicCredentials))))

(defn get-private-credentials
  "Return a Set of private credentials associated with this
   Subject that are instances or subclasses of the specified
   Class.

    The caller must have permission to access all of the
   requested Credentials, or a SecurityException
   will be thrown.

    The returned Set is not backed by this Subject's
   internal private Credential Set.  A new
   Set is created and returned for each method invocation.
   Modifications to the returned Set
   will not affect the internal private Credential Set.

  c - the returned Set of private credentials will all be instances of this class. - `java.lang.Class<T>`

  returns: a Set of private credentials that are instances
            of the  specified Class. - `<T> java.util.Set<T>`

  throws: java.lang.NullPointerException - if the specified Class is null."
  ([^javax.security.auth.Subject this ^java.lang.Class c]
    (-> this (.getPrivateCredentials c)))
  ([^javax.security.auth.Subject this]
    (-> this (.getPrivateCredentials))))

(defn equals
  "Compares the specified Object with this Subject
   for equality.  Returns true if the given object is also a Subject
   and the two Subject instances are equivalent.
   More formally, two Subject instances are
   equal if their Principal and Credential
   Sets are equal.

  o - Object to be compared for equality with this Subject. - `java.lang.Object`

  returns: true if the specified Object is equal to this
            Subject. - `boolean`

  throws: java.lang.SecurityException - if the caller does not have permission to access the private credentials for this Subject, or if the caller does not have permission to access the private credentials for the provided Subject."
  ([^javax.security.auth.Subject this ^java.lang.Object o]
    (-> this (.equals o))))

(defn to-string
  "Return the String representation of this Subject.

  returns: the String representation of this Subject. - `java.lang.String`"
  ([^javax.security.auth.Subject this]
    (-> this (.toString))))

(defn hash-code
  "Returns a hashcode for this Subject.

  returns: a hashcode for this Subject. - `int`

  throws: java.lang.SecurityException - if the caller does not have permission to access this Subject's private credentials."
  ([^javax.security.auth.Subject this]
    (-> this (.hashCode))))

