(ns javax.management.BadBinaryOpValueExpException
  "Thrown when an invalid expression is passed to a method for
  constructing a query.  This exception is used internally by JMX
  during the evaluation of a query.  User code does not usually see
  it."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management BadBinaryOpValueExpException]))

(defn ->bad-binary-op-value-exp-exception
  "Constructor.

  Constructs a BadBinaryOpValueExpException with the specified ValueExp.

  exp - the expression whose value was inappropriate. - `javax.management.ValueExp`"
  (^BadBinaryOpValueExpException [^javax.management.ValueExp exp]
    (new BadBinaryOpValueExpException exp)))

(defn get-exp
  "Returns the ValueExp that originated the exception.

  returns: the problematic ValueExp. - `javax.management.ValueExp`"
  (^javax.management.ValueExp [^BadBinaryOpValueExpException this]
    (-> this (.getExp))))

(defn to-string
  "Returns the string representing the object.

  returns: a string representation of this throwable. - `java.lang.String`"
  (^java.lang.String [^BadBinaryOpValueExpException this]
    (-> this (.toString))))

