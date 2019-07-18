(ns jdk.security.acl.Owner
  "Interface for managing owners of Access Control Lists (ACLs) or ACL
  configurations. (Note that the Acl interface in the
  java.security.acl package extends this Owner
  interface.) The initial owner Principal should be specified as an
  argument to the constructor of the class implementing this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.acl Owner]))

(defn add-owner
  "Adds an owner. Only owners can modify ACL contents. The caller
   principal must be an owner of the ACL in order to invoke this method.
   That is, only an owner can add another owner. The initial owner is
   configured at ACL construction time.

  caller - the principal invoking this method. It must be an owner of the ACL. - `java.security.Principal`
  owner - the owner that should be added to the list of owners. - `java.security.Principal`

  returns: true if successful, false if owner is already an owner. - `boolean`

  throws: java.security.acl.NotOwnerException - if the caller principal is not an owner of the ACL."
  (^Boolean [^Owner this ^java.security.Principal caller ^java.security.Principal owner]
    (-> this (.addOwner caller owner))))

(defn delete-owner
  "Deletes an owner. If this is the last owner in the ACL, an exception is
   raised.

   The caller principal must be an owner of the ACL in order to invoke
   this method.

  caller - the principal invoking this method. It must be an owner of the ACL. - `java.security.Principal`
  owner - the owner to be removed from the list of owners. - `java.security.Principal`

  returns: true if the owner is removed, false if the owner is not part
   of the list of owners. - `boolean`

  throws: java.security.acl.NotOwnerException - if the caller principal is not an owner of the ACL."
  (^Boolean [^Owner this ^java.security.Principal caller ^java.security.Principal owner]
    (-> this (.deleteOwner caller owner))))

(defn owner?
  "Returns true if the given principal is an owner of the ACL.

  owner - the principal to be checked to determine whether or not it is an owner. - `java.security.Principal`

  returns: true if the passed principal is in the list of owners, false
   if not. - `boolean`"
  (^Boolean [^Owner this ^java.security.Principal owner]
    (-> this (.isOwner owner))))

