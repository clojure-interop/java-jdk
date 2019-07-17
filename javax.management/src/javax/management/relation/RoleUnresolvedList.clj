(ns javax.management.relation.RoleUnresolvedList
  "A RoleUnresolvedList represents a list of RoleUnresolved objects,
  representing roles not retrieved from a relation due to a problem
  encountered when trying to access (read or write) the roles."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.relation RoleUnresolvedList]))

(defn ->role-unresolved-list
  "Constructor.

  Constructs an empty RoleUnresolvedList with the initial capacity
   specified.

  initial-capacity - initial capacity - `int`"
  ([^Integer initial-capacity]
    (new RoleUnresolvedList initial-capacity))
  ([]
    (new RoleUnresolvedList )))

(defn as-list
  "Return a view of this list as a List<RoleUnresolved>.
   Changes to the returned value are reflected by changes
   to the original RoleUnresolvedList and vice versa.

  returns: a List<RoleUnresolved> whose contents
   reflect the contents of this RoleUnresolvedList.

   If this method has ever been called on a given
   RoleUnresolvedList instance, a subsequent attempt to add
   an object to that instance which is not a RoleUnresolved
   will fail with an IllegalArgumentException. For compatibility
   reasons, a RoleUnresolvedList on which this method has never
   been called does allow objects other than RoleUnresolveds to
   be added. - `java.util.List<javax.management.relation.RoleUnresolved>`

  throws: java.lang.IllegalArgumentException - if this RoleUnresolvedList contains an element that is not a RoleUnresolved."
  ([^javax.management.relation.RoleUnresolvedList this]
    (-> this (.asList))))

(defn add
  "Inserts the unresolved role specified as an element at the position
   specified.
   Elements with an index greater than or equal to the current position are
   shifted up.

  index - - The position in the list where the new RoleUnresolved object is to be inserted. - `int`
  role - - The RoleUnresolved object to be inserted. - `javax.management.relation.RoleUnresolved`

  throws: java.lang.IllegalArgumentException - if the unresolved role is null."
  ([^javax.management.relation.RoleUnresolvedList this ^Integer index ^javax.management.relation.RoleUnresolved role]
    (-> this (.add index role)))
  ([^javax.management.relation.RoleUnresolvedList this ^javax.management.relation.RoleUnresolved role]
    (-> this (.add role))))

(defn set
  "Sets the element at the position specified to be the unresolved role
   specified.
   The previous element at that position is discarded.

  index - - The position specified. - `int`
  role - - The value to which the unresolved role element should be set. - `javax.management.relation.RoleUnresolved`

  throws: java.lang.IllegalArgumentException - if the unresolved role is null."
  ([^javax.management.relation.RoleUnresolvedList this ^Integer index ^javax.management.relation.RoleUnresolved role]
    (-> this (.set index role))))

(defn add-all
  "Inserts all of the elements in the RoleUnresolvedList specified into
   this list, starting at the specified position, in the order in which
   they are returned by the Iterator of the RoleUnresolvedList specified.

  index - - Position at which to insert the first element from the RoleUnresolvedList specified. - `int`
  role-list - - Elements to be inserted into the list. - `javax.management.relation.RoleUnresolvedList`

  returns: true if this list changed as a result of the call. - `boolean`

  throws: java.lang.IllegalArgumentException - if the role is null."
  ([^javax.management.relation.RoleUnresolvedList this ^Integer index ^javax.management.relation.RoleUnresolvedList role-list]
    (-> this (.addAll index role-list)))
  ([^javax.management.relation.RoleUnresolvedList this ^javax.management.relation.RoleUnresolvedList role-list]
    (-> this (.addAll role-list))))

