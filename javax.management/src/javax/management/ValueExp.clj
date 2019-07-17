(ns javax.management.ValueExp
  "Represents values that can be passed as arguments to
  relational expressions. Strings, numbers, attributes are valid values
  and should be represented by implementations of ValueExp."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management ValueExp]))

(defn apply
  "Applies the ValueExp on a MBean.

  name - The name of the MBean on which the ValueExp will be applied. - `javax.management.ObjectName`

  returns: The ValueExp. - `javax.management.ValueExp`

  throws: javax.management.BadStringOperationException"
  ([^javax.management.ValueExp this ^javax.management.ObjectName name]
    (-> this (.apply name))))

(defn set-m-bean-server
  "Deprecated. This method is not needed because a
   ValueExp can access the MBean server in which it
   is being evaluated by using QueryEval.getMBeanServer().

  s - The MBean server on which the query is to be performed. - `javax.management.MBeanServer`

  returns: `java.lang. void`"
  ([^javax.management.ValueExp this ^javax.management.MBeanServer s]
    (-> this (.setMBeanServer s))))

