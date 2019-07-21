(ns javax.security.auth.AuthPermission
  "This class is for authentication permissions.
  An AuthPermission contains a name
  (also referred to as a \"target name\")
  but no actions list; you either have the named permission
  or you don't.

   The target name is the name of a security configuration parameter
  (see below).  Currently the AuthPermission object is used to
  guard access to the Policy, Subject, LoginContext,
  and Configuration objects.

   The possible target names for an Authentication Permission are:



       doAs -                  allow the caller to invoke the
                                Subject.doAs methods.

       doAsPrivileged -        allow the caller to invoke the
                                Subject.doAsPrivileged methods.

       getSubject -            allow for the retrieval of the
                               Subject(s) associated with the
                               current Thread.

       getSubjectFromDomainCombiner -  allow for the retrieval of the
                               Subject associated with the
                               a  SubjectDomainCombiner.

       setReadOnly -           allow the caller to set a Subject
                               to be read-only.

       modifyPrincipals -      allow the caller to modify the  Set
                               of Principals associated with a
                                Subject

       modifyPublicCredentials - allow the caller to modify the
                                Set of public credentials
                               associated with a  Subject

       modifyPrivateCredentials - allow the caller to modify the
                                Set of private credentials
                               associated with a  Subject

       refreshCredential -     allow code to invoke the  refresh
                               method on a credential which implements
                               the  Refreshable interface.

       destroyCredential -     allow code to invoke the  destroy
                               method on a credential  object
                               which implements the  Destroyable
                               interface.

       createLoginContext.{name} -  allow code to instantiate a
                                LoginContext with the
                               specified name.  name
                               is used as the index into the installed login
                                Configuration
                               (that returned by
                                Configuration.getConfiguration()).
                               name can be wildcarded (set to '*')
                               to allow for any name.

       getLoginConfiguration - allow for the retrieval of the system-wide
                               login Configuration.

       createLoginConfiguration.{type} - allow code to obtain a Configuration
                               object via
                                Configuration.getInstance.

       setLoginConfiguration - allow for the setting of the system-wide
                               login Configuration.

       refreshLoginConfiguration - allow for the refreshing of the system-wide
                               login Configuration.

   The following target name has been deprecated in favor of
  createLoginContext.{name}.



       createLoginContext -    allow code to instantiate a
                                LoginContext.

   javax.security.auth.Policy has been
  deprecated in favor of java.security.Policy.
  Therefore, the following target names have also been deprecated:



       getPolicy -             allow the caller to retrieve the system-wide
                               Subject-based access control policy.

       setPolicy -             allow the caller to set the system-wide
                               Subject-based access control policy.

       refreshPolicy -         allow the caller to refresh the system-wide
                               Subject-based access control policy."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth AuthPermission]))

(defn ->auth-permission
  "Constructor.

  Creates a new AuthPermission object with the specified name.
   The name is the symbolic name of the AuthPermission, and the
   actions String is currently unused and should be null.

  name - the name of the AuthPermission - `java.lang.String`
  actions - should be null. - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null."
  (^AuthPermission [^java.lang.String name ^java.lang.String actions]
    (new AuthPermission name actions))
  (^AuthPermission [^java.lang.String name]
    (new AuthPermission name)))

