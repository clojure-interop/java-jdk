(ns jdk.security.acl.Group
  "This interface is used to represent a group of principals. (A principal
  represents an entity such as an individual user or a company).

  Note that Group extends Principal. Thus, either a Principal or a Group can
  be passed as an argument to methods containing a Principal parameter. For
  example, you can add either a Principal or a Group to a Group object by
  calling the object's addMember method, passing it the
  Principal or Group."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.acl Group]))

(defn add-member
  "Adds the specified member to the group.

  user - the principal to add to this group. - `java.security.Principal`

  returns: true if the member was successfully added,
   false if the principal was already a member. - `boolean`"
  (^Boolean [^Group this ^java.security.Principal user]
    (-> this (.addMember user))))

(defn remove-member
  "Removes the specified member from the group.

  user - the principal to remove from this group. - `java.security.Principal`

  returns: true if the principal was removed, or
   false if the principal was not a member. - `boolean`"
  (^Boolean [^Group this ^java.security.Principal user]
    (-> this (.removeMember user))))

(defn member?
  "Returns true if the passed principal is a member of the group.
   This method does a recursive search, so if a principal belongs to a
   group which is a member of this group, true is returned.

  member - the principal whose membership is to be checked. - `java.security.Principal`

  returns: true if the principal is a member of this group,
   false otherwise. - `boolean`"
  (^Boolean [^Group this ^java.security.Principal member]
    (-> this (.isMember member))))

(defn members
  "Returns an enumeration of the members in the group.
   The returned objects can be instances of either Principal
   or Group (which is a subclass of Principal).

  returns: an enumeration of the group members. - `java.util.Enumeration<? extends java.security.Principal>`"
  ([^Group this]
    (-> this (.members))))

