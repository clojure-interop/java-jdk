(ns javax.xml.bind.TypeConstraintException
  "This exception indicates that a violation of a dynamically checked type
  constraint was detected.


  This exception can be thrown by the generated setter methods of the schema
  derived Java content classes.  However, since fail-fast validation is
  an optional feature for JAXB Providers to support, not all setter methods
  will throw this exception when a type constraint is violated.


  If this exception is throw while invoking a fail-fast setter, the value of
  the property is guaranteed to remain unchanged, as if the setter were never
  called."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind TypeConstraintException]))

(defn ->type-constraint-exception
  "Constructor.

  Construct a TypeConstraintException with the specified detail message,
   vendor specific errorCode, and linkedException.

  message - a description of the exception - `java.lang.String`
  error-code - a string specifying the vendor specific error code - `java.lang.String`
  exception - the linked exception - `java.lang.Throwable`"
  ([message error-code exception]
    (new TypeConstraintException message error-code exception))
  ([message error-code]
    (new TypeConstraintException message error-code))
  ([message]
    (new TypeConstraintException message)))

(defn get-error-code
  "Get the vendor specific error code

  returns: a string specifying the vendor specific error code - `java.lang.String`"
  ([this]
    (-> this (.getErrorCode))))

(defn get-linked-exception
  "Get the linked exception

  returns: the linked Exception, null if none exists - `java.lang.Throwable`"
  ([this]
    (-> this (.getLinkedException))))

(defn set-linked-exception
  "Add a linked Exception.

  exception - the linked Exception (A null value is permitted and indicates that the linked exception does not exist or is unknown). - `java.lang.Throwable`"
  ([this exception]
    (-> this (.setLinkedException exception))))

(defn to-string
  "Returns a short description of this TypeConstraintException.

  returns: a string representation of this throwable. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn print-stack-trace
  "Prints this TypeConstraintException and its stack trace (including the stack trace
   of the linkedException if it is non-null) to the PrintStream.

  s - PrintStream to use for output - `java.io.PrintStream`"
  ([this s]
    (-> this (.printStackTrace s)))
  ([this]
    (-> this (.printStackTrace))))

