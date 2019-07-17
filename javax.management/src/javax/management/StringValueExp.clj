(ns javax.management.StringValueExp
  "Represents strings that are arguments to relational constraints.
  A StringValueExp may be used anywhere a ValueExp is required."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management StringValueExp]))

(defn ->string-value-exp
  "Constructor.

  Creates a new StringValueExp representing the
   given string.

  val - the string that will be the value of this expression - `java.lang.String`"
  ([val]
    (new StringValueExp val))
  ([]
    (new StringValueExp )))

(defn get-value
  "Returns the string represented by the
   StringValueExp instance.

  returns: the string. - `java.lang.String`"
  ([this]
    (-> this (.getValue))))

(defn to-string
  "Returns the string representing the object.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn set-m-bean-server
  "Deprecated.

  s - The MBean server on which the query is to be performed. - `javax.management.MBeanServer`

  returns: `java.lang.  void`"
  ([this s]
    (-> this (.setMBeanServer s))))

(defn apply
  "Applies the ValueExp on a MBean.

  name - The name of the MBean on which the ValueExp will be applied. - `javax.management.ObjectName`

  returns: The ValueExp. - `javax.management.ValueExp`

  throws: javax.management.BadStringOperationException"
  ([this name]
    (-> this (.apply name))))

