(ns javax.management.MBeanTrustPermission
  "This permission represents \"trust\" in a signer or codebase.

  MBeanTrustPermission contains a target name but no actions list.
  A single target name, \"register\", is defined for this permission.
  The target \"*\" is also allowed, permitting \"register\" and any future
  targets that may be defined.
  Only the null value or the empty string are allowed for the action
  to allow the policy object to create the permissions specified in
  the policy file.

  If a signer, or codesource is granted this permission, then it is
  considered a trusted source for MBeans. Only MBeans from trusted
  sources may be registered in the MBeanServer."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management MBeanTrustPermission]))

(defn ->m-bean-trust-permission
  "Constructor.

  Create a new MBeanTrustPermission with the given name.

  name - the name of the permission. It must be \"register\" or \"*\" for this permission. - `java.lang.String`
  actions - the actions for the permission. It must be null or \"\". - `java.lang.String`

  throws: java.lang.NullPointerException - if name is null."
  (^MBeanTrustPermission [^java.lang.String name ^java.lang.String actions]
    (new MBeanTrustPermission name actions))
  (^MBeanTrustPermission [^java.lang.String name]
    (new MBeanTrustPermission name)))

