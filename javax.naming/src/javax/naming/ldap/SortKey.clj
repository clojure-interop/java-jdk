(ns javax.naming.ldap.SortKey
  "A sort key and its associated sort parameters.
  This class implements a sort key which is used by the LDAPv3
  Control for server-side sorting of search results as defined in
  RFC 2891."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap SortKey]))

(defn ->sort-key
  "Constructor.

  Creates a sort key for an attribute. Entries will be sorted according to
   the specified attribute in the specified sort order and using the
   specified matching rule, if supplied.

  attr-id - The non-null ID of the attribute to be used as a sort key. - `java.lang.String`
  ascending-order - If true then entries are arranged in ascending order. Otherwise there are arranged in descending order. - `boolean`
  matching-rule-id - The possibly null ID of the matching rule to use to order the attribute values. If not specified then the ordering matching rule defined for the sort key attribute is used. - `java.lang.String`"
  (^SortKey [^java.lang.String attr-id ^Boolean ascending-order ^java.lang.String matching-rule-id]
    (new SortKey attr-id ascending-order matching-rule-id))
  (^SortKey [^java.lang.String attr-id]
    (new SortKey attr-id)))

(defn get-attribute-id
  "Retrieves the attribute ID of the sort key.

  returns: The non-null Attribute ID of the sort key. - `java.lang.String`"
  (^java.lang.String [^SortKey this]
    (-> this (.getAttributeID))))

(defn ascending?
  "Determines the sort order.

  returns: true if the sort order is ascending, false if descending. - `boolean`"
  (^Boolean [^SortKey this]
    (-> this (.isAscending))))

(defn get-matching-rule-id
  "Retrieves the matching rule ID used to order the attribute values.

  returns: The possibly null matching rule ID. If null then the
              ordering matching rule defined for the sort key attribute
              is used. - `java.lang.String`"
  (^java.lang.String [^SortKey this]
    (-> this (.getMatchingRuleID))))

