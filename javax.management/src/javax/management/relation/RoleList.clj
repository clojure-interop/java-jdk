(ns javax.management.relation.RoleList
  "A RoleList represents a list of roles (Role objects). It is used as
  parameter when creating a relation, and when trying to set several roles in
  a relation (via 'setRoles()' method). It is returned as part of a
  RoleResult, to provide roles successfully retrieved."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleList]))

(defn ->role-list
  "Constructor.

  Constructs an empty RoleList with the initial capacity
   specified.

  initial-capacity - initial capacity - `int`"
  ([^Integer initial-capacity]
    (new RoleList initial-capacity))
  ([]
    (new RoleList )))

(defn as-list
  "Return a view of this list as a List<Role>.
   Changes to the returned value are reflected by changes
   to the original RoleList and vice versa.

  returns: a List<Role> whose contents
   reflect the contents of this RoleList.

   If this method has ever been called on a given
   RoleList instance, a subsequent attempt to add
   an object to that instance which is not a Role
   will fail with an IllegalArgumentException. For compatibility
   reasons, a RoleList on which this method has never
   been called does allow objects other than Roles to
   be added. - `java.util.List<javax.management.relation.Role>`

  throws: java.lang.IllegalArgumentException - if this RoleList contains an element that is not a Role."
  (^java.util.List [^javax.management.relation.RoleList this]
    (-> this (.asList))))

(defn add
  "Inserts the role specified as an element at the position specified.
   Elements with an index greater than or equal to the current position are
   shifted up.

  index - The position in the list where the new Role object is to be inserted. - `int`
  role - The Role object to be inserted. - `javax.management.relation.Role`

  throws: java.lang.IllegalArgumentException - if the role is null."
  ([^javax.management.relation.RoleList this ^Integer index ^javax.management.relation.Role role]
    (-> this (.add index role)))
  ([^javax.management.relation.RoleList this ^javax.management.relation.Role role]
    (-> this (.add role))))

(defn set
  "Sets the element at the position specified to be the role
   specified.
   The previous element at that position is discarded.

  index - The position specified. - `int`
  role - The value to which the role element should be set. - `javax.management.relation.Role`

  throws: java.lang.IllegalArgumentException - if the role is null."
  ([^javax.management.relation.RoleList this ^Integer index ^javax.management.relation.Role role]
    (-> this (.set index role))))

(defn add-all
  "Inserts all of the elements in the RoleList specified into this
   list, starting at the specified position, in the order in which they are
   returned by the Iterator of the RoleList specified.

  index - Position at which to insert the first element from the RoleList specified. - `int`
  role-list - Elements to be inserted into the list. - `javax.management.relation.RoleList`

  returns: true if this list changed as a result of the call. - `boolean`

  throws: java.lang.IllegalArgumentException - if the role is null."
  (^Boolean [^javax.management.relation.RoleList this ^Integer index ^javax.management.relation.RoleList role-list]
    (-> this (.addAll index role-list)))
  (^Boolean [^javax.management.relation.RoleList this ^javax.management.relation.RoleList role-list]
    (-> this (.addAll role-list))))

