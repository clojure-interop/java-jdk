(ns javax.management.BadAttributeValueExpException
  "Thrown when an invalid MBean attribute is passed to a query
  constructing method.  This exception is used internally by JMX
  during the evaluation of a query.  User code does not usually
  see it."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management BadAttributeValueExpException]))

(defn ->bad-attribute-value-exp-exception
  "Constructor.

  Constructs a BadAttributeValueExpException using the specified Object to
   create the toString() value.

  val - the inappropriate value. - `java.lang.Object`"
  ([^java.lang.Object val]
    (new BadAttributeValueExpException val)))

(defn to-string
  "Returns the string representing the object.

  returns: a string representation of this throwable. - `java.lang.String`"
  (^java.lang.String [^javax.management.BadAttributeValueExpException this]
    (-> this (.toString))))

