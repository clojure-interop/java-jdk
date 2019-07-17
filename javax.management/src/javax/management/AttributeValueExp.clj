(ns javax.management.AttributeValueExp
  "Represents attributes used as arguments to relational constraints.
  Instances of this class are usually obtained using Query.attr.

  An AttributeValueExp may be used anywhere a
  ValueExp is required."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management AttributeValueExp]))

(defn ->attribute-value-exp
  "Constructor.

  Creates a new AttributeValueExp representing the
   specified object attribute, named attr.

  attr - the name of the attribute whose value is the value of this ValueExp. - `java.lang.String`"
  ([attr]
    (new AttributeValueExp attr))
  ([]
    (new AttributeValueExp )))

(defn get-attribute-name
  "Returns a string representation of the name of the attribute.

  returns: the attribute name. - `java.lang.String`"
  ([this]
    (-> this (.getAttributeName))))

(defn apply
  "Applies the AttributeValueExp on an MBean.
   This method calls getAttribute(name) and wraps
   the result as a ValueExp.  The value returned by
   getAttribute must be a Number, String,
   or Boolean; otherwise this method throws a
   BadAttributeValueExpException, which will cause
   the containing query to be false for this name.

  name - The name of the MBean on which the AttributeValueExp will be applied. - `javax.management.ObjectName`

  returns: The ValueExp. - `javax.management.ValueExp`

  throws: javax.management.BadAttributeValueExpException"
  ([this name]
    (-> this (.apply name))))

(defn to-string
  "Returns the string representing its value.

  returns: a string representation of the object. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn set-m-bean-server
  "Deprecated. This method has no effect.  The MBean Server used to
   obtain an attribute value is QueryEval.getMBeanServer().

  s - The MBean server on which the query is to be performed. - `javax.management.MBeanServer`

  returns: `java.lang.  void`"
  ([this s]
    (-> this (.setMBeanServer s))))

