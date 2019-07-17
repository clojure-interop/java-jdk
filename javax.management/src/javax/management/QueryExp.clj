(ns javax.management.QueryExp
  "Represents relational constraints similar to database query `where
  clauses`. Instances of QueryExp are returned by the static methods of the
  Query class.

  It is possible, but not
  recommended, to create custom queries by implementing this
  interface.  In that case, it is better to extend the QueryEval class than to implement the interface directly, so that
  the setMBeanServer(javax.management.MBeanServer) method works correctly."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management QueryExp]))

(defn apply
  "Applies the QueryExp on an MBean.

  name - The name of the MBean on which the QueryExp will be applied. - `javax.management.ObjectName`

  returns: True if the query was successfully applied to the MBean, false otherwise - `boolean`

  throws: javax.management.BadStringOperationException"
  ([^. this ^javax.management.ObjectName name]
    (-> this (.apply name))))

(defn set-m-bean-server
  "Sets the MBean server on which the query is to be performed.

  s - The MBean server on which the query is to be performed. - `javax.management.MBeanServer`"
  ([^. this ^javax.management.MBeanServer s]
    (-> this (.setMBeanServer s))))

