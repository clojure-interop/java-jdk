(ns javax.security.auth.Policy
  "Deprecated.
 as of JDK version 1.4 -- Replaced by java.security.Policy.
               java.security.Policy has a method:


       public PermissionCollection getPermissions
           (java.security.ProtectionDomain pd)
  and ProtectionDomain has a constructor:


       public ProtectionDomain
           (CodeSource cs,
            PermissionCollection permissions,
            ClassLoader loader,
            Principal[] principals)

  These two APIs provide callers the means to query the
  Policy for Principal-based Permission entries."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth Policy]))

(defn *get-policy
  "Deprecated.

  returns: the installed Policy.  The return value cannot be
            null. - `javax.security.auth.Policy`

  throws: java.lang.SecurityException - if the current thread does not have permission to get the Policy object."
  (^javax.security.auth.Policy []
    (Policy/getPolicy )))

(defn *set-policy
  "Deprecated.

  policy - the new system Policy object. - `javax.security.auth.Policy`

  throws: java.lang.SecurityException - if the current thread does not have permission to set the Policy."
  ([^javax.security.auth.Policy policy]
    (Policy/setPolicy policy)))

(defn get-permissions
  "Deprecated.

  subject - the Subject whose associated Principals, in conjunction with the provided CodeSource, determines the Permissions returned by this method. This parameter may be null. - `javax.security.auth.Subject`
  cs - the code specified by its CodeSource that determines, in conjunction with the provided Subject, the Permissions returned by this method. This parameter may be null. - `java.security.CodeSource`

  returns: the Collection of Permissions granted to all the
                    Subject and code specified in
                    the provided subject and cs
                    parameters. - `java.security.PermissionCollection`"
  (^java.security.PermissionCollection [^javax.security.auth.Policy this ^javax.security.auth.Subject subject ^java.security.CodeSource cs]
    (-> this (.getPermissions subject cs))))

(defn refresh
  "Deprecated.

  throws: java.lang.SecurityException - if the caller does not have permission to refresh the Policy."
  ([^javax.security.auth.Policy this]
    (-> this (.refresh))))

