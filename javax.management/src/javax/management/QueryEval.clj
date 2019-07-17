(ns javax.management.QueryEval
  "Allows a query to be performed in the context of a specific MBean server."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management QueryEval]))

(defn ->query-eval
  "Constructor."
  ([]
    (new QueryEval )))

(defn *get-m-bean-server
  "Return the MBean server that was most recently given to the
   setMBeanServer method by this thread.
   If this thread never called that method, the result is the
   value its parent thread would have obtained from
   getMBeanServer at the moment of the creation of
   this thread, or null if there is no parent thread.

  returns: the MBean server. - `javax.management.MBeanServer`"
  ([]
    (QueryEval/getMBeanServer )))

(defn set-m-bean-server
  "Sets the MBean server on which the query is to be performed.
   The setting is valid for the thread performing the set.
   It is copied to any threads created by that thread at the moment
   of their creation.

   For historical reasons, this method is not static, but its
   behavior does not depend on the instance on which it is
   called.

  s - The MBean server on which the query is to be performed. - `javax.management.MBeanServer`"
  ([this s]
    (-> this (.setMBeanServer s))))

