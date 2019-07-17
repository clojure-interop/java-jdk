(ns javax.management.InvalidApplicationException
  "Thrown when an attempt is made to apply either of the following: A
  subquery expression to an MBean or a qualified attribute expression
  to an MBean of the wrong class.  This exception is used internally
  by JMX during the evaluation of a query.  User code does not
  usually see it."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management InvalidApplicationException]))

(defn ->invalid-application-exception
  "Constructor.

  Constructs an InvalidApplicationException with the specified Object.

  val - the detail message of this exception. - `java.lang.Object`"
  ([val]
    (new InvalidApplicationException val)))

