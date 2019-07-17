(ns jdk.security.DomainCombiner
  "A DomainCombiner provides a means to dynamically
  update the ProtectionDomains associated with the current
  AccessControlContext.

   A DomainCombiner is passed as a parameter to the
  appropriate constructor for AccessControlContext.
  The newly constructed context is then passed to the
  AccessController.doPrivileged(..., context) method
  to bind the provided context (and associated DomainCombiner)
  with the current execution Thread.  Subsequent calls to
  AccessController.getContext or
  AccessController.checkPermission
  cause the DomainCombiner.combine to get invoked.

   The combine method takes two arguments.  The first argument represents
  an array of ProtectionDomains from the current execution Thread,
  since the most recent call to AccessController.doPrivileged.
  If no call to doPrivileged was made, then the first argument will contain
  all the ProtectionDomains from the current execution Thread.
  The second argument represents an array of inherited ProtectionDomains,
  which may be null.  ProtectionDomains may be inherited
  from a parent Thread, or from a privileged context.  If no call to
  doPrivileged was made, then the second argument will contain the
  ProtectionDomains inherited from the parent Thread.  If one or more calls
  to doPrivileged were made, and the most recent call was to
  doPrivileged(action, context), then the second argument will contain the
  ProtectionDomains from the privileged context.  If the most recent call
  was to doPrivileged(action), then there is no privileged context,
  and the second argument will be null.

   The combine method investigates the two input arrays
  of ProtectionDomains and returns a single array containing the updated
  ProtectionDomains.  In the simplest case, the combine
  method merges the two stacks into one.  In more complex cases,
  the combine method returns a modified
  stack of ProtectionDomains.  The modification may have added new
  ProtectionDomains, removed certain ProtectionDomains, or simply
  updated existing ProtectionDomains.  Re-ordering and other optimizations
  to the ProtectionDomains are also permitted.  Typically the
  combine method bases its updates on the information
  encapsulated in the DomainCombiner.

   After the AccessController.getContext method
  receives the combined stack of ProtectionDomains back from
  the DomainCombiner, it returns a new
  AccessControlContext that has both the combined ProtectionDomains
  as well as the DomainCombiner."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security DomainCombiner]))

(defn combine
  "Modify or update the provided ProtectionDomains.
   ProtectionDomains may be added to or removed from the given
   ProtectionDomains.  The ProtectionDomains may be re-ordered.
   Individual ProtectionDomains may be modified (with a new
   set of Permissions, for example).

  current-domains - the ProtectionDomains associated with the current execution Thread, up to the most recent privileged ProtectionDomain. The ProtectionDomains are are listed in order of execution, with the most recently executing ProtectionDomain residing at the beginning of the array. This parameter may be null if the current execution Thread has no associated ProtectionDomains. - `java.security.ProtectionDomain[]`
  assigned-domains - an array of inherited ProtectionDomains. ProtectionDomains may be inherited from a parent Thread, or from a privileged AccessControlContext. This parameter may be null if there are no inherited ProtectionDomains. - `java.security.ProtectionDomain[]`

  returns: a new array consisting of the updated ProtectionDomains,
            or null. - `java.security.ProtectionDomain[]`"
  ([^java.security.DomainCombiner this current-domains assigned-domains]
    (-> this (.combine current-domains assigned-domains))))

