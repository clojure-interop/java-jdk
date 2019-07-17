(ns javax.security.auth.SubjectDomainCombiner
  "A SubjectDomainCombiner updates ProtectionDomains
  with Principals from the Subject associated with this
  SubjectDomainCombiner."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth SubjectDomainCombiner]))

(defn ->subject-domain-combiner
  "Constructor.

  Associate the provided Subject with this
   SubjectDomainCombiner.

  subject - the Subject to be associated with with this SubjectDomainCombiner. - `javax.security.auth.Subject`"
  ([^javax.security.auth.Subject subject]
    (new SubjectDomainCombiner subject)))

(defn get-subject
  "Get the Subject associated with this
   SubjectDomainCombiner.

  returns: the Subject associated with this
            SubjectDomainCombiner, or null
            if no Subject is associated with this
            SubjectDomainCombiner. - `javax.security.auth.Subject`

  throws: java.lang.SecurityException - if the caller does not have permission to get the Subject associated with this SubjectDomainCombiner."
  ([^javax.security.auth.SubjectDomainCombiner this]
    (-> this (.getSubject))))

(defn combine
  "Update the relevant ProtectionDomains with the Principals
   from the Subject associated with this
   SubjectDomainCombiner.

    A new ProtectionDomain instance is created
   for each ProtectionDomain in the
   currentDomains array.  Each new ProtectionDomain
   instance is created using the CodeSource,
   Permissions and ClassLoader
   from the corresponding ProtectionDomain in
   currentDomains, as well as with the Principals from
   the Subject associated with this
   SubjectDomainCombiner.

    All of the newly instantiated ProtectionDomains are
   combined into a new array.  The ProtectionDomains from the
   assignedDomains array are appended to this new array,
   and the result is returned.

    Note that optimizations such as the removal of duplicate
   ProtectionDomains may have occurred.
   In addition, caching of ProtectionDomains may be permitted.

  current-domains - the ProtectionDomains associated with the current execution Thread, up to the most recent privileged ProtectionDomain. The ProtectionDomains are are listed in order of execution, with the most recently executing ProtectionDomain residing at the beginning of the array. This parameter may be null if the current execution Thread has no associated ProtectionDomains. - `java.security.ProtectionDomain[]`
  assigned-domains - the ProtectionDomains inherited from the parent Thread, or the ProtectionDomains from the privileged context, if a call to AccessController.doPrivileged(..., context) had occurred This parameter may be null if there were no ProtectionDomains inherited from the parent Thread, or from the privileged context. - `java.security.ProtectionDomain[]`

  returns: a new array consisting of the updated ProtectionDomains,
            or null. - `java.security.ProtectionDomain[]`"
  ([^javax.security.auth.SubjectDomainCombiner this ^java.security.ProtectionDomain[] current-domains ^java.security.ProtectionDomain[] assigned-domains]
    (-> this (.combine current-domains assigned-domains))))

