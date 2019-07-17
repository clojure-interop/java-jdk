(ns javax.accessibility.AccessibleRelationSet
  "Class AccessibleRelationSet determines a component's relation set.  The
  relation set of a component is a set of AccessibleRelation objects that
  describe the component's relationships with other components."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleRelationSet]))

(defn ->accessible-relation-set
  "Constructor.

  Creates a new relation with the initial set of relations contained in
   the array of relations passed in.  Duplicate entries are ignored.

  relations - an array of AccessibleRelation describing the relation set. - `javax.accessibility.AccessibleRelation[]`"
  ([relations]
    (new AccessibleRelationSet relations))
  ([]
    (new AccessibleRelationSet )))

(defn add-all
  "Adds all of the relations to the existing relation set.  Duplicate
   entries are ignored.

  relations - AccessibleRelation array describing the relation set. - `javax.accessibility.AccessibleRelation[]`"
  ([this relations]
    (-> this (.addAll relations))))

(defn contains
  "Returns whether the relation set contains a relation
   that matches the specified key.

  key - the AccessibleRelation key - `java.lang.String`

  returns: true if the relation is in the relation set; otherwise false - `boolean`"
  ([this key]
    (-> this (.contains key))))

(defn to-string
  "Creates a localized String representing all the relations in the set
   using the default locale.

  returns: comma separated localized String - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn remove
  "Removes a relation from the current relation set.  If the relation
   is not in the set, the relation set will be unchanged and the
   return value will be false.  If the relation is in the relation
   set, it will be removed from the set and the return value will be
   true.

  relation - the relation to remove from the relation set - `javax.accessibility.AccessibleRelation`

  returns: true if the relation is in the relation set; false if the
   relation set is unchanged - `boolean`"
  ([this relation]
    (-> this (.remove relation))))

(defn add
  "Adds a new relation to the current relation set.  If the relation
   is already in the relation set, the target(s) of the specified
   relation is merged with the target(s) of the existing relation.
   Otherwise,  the new relation is added to the relation set.

  relation - the relation to add to the relation set - `javax.accessibility.AccessibleRelation`

  returns: true if relation is added to the relation set; false if the
   relation set is unchanged - `boolean`"
  ([this relation]
    (-> this (.add relation))))

(defn size
  "Returns the number of relations in the relation set.

  returns: the number of relations in the relation set - `int`"
  ([this]
    (-> this (.size))))

(defn clear
  "Removes all the relations from the current relation set."
  ([this]
    (-> this (.clear))))

(defn to-array
  "Returns the current relation set as an array of AccessibleRelation

  returns: AccessibleRelation array contacting the current relation. - `javax.accessibility.AccessibleRelation[]`"
  ([this]
    (-> this (.toArray))))

(defn get
  "Returns the relation that matches the specified key.

  key - the AccessibleRelation key - `java.lang.String`

  returns: the relation, if one exists, that matches the specified key.
   Otherwise, null is returned. - `javax.accessibility.AccessibleRelation`"
  ([this key]
    (-> this (.get key))))

