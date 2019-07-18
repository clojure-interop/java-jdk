(ns jdk.beans.IntrospectionException
  "Thrown when an exception happens during Introspection.

  Typical causes include not being able to map a string class name
  to a Class object, not being able to resolve a string method name,
  or specifying a method name that has the wrong type signature for
  its intended use."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans IntrospectionException]))

(defn ->introspection-exception
  "Constructor.

  Constructs an IntrospectionException with a
   detailed message.

  mess - Descriptive message - `java.lang.String`"
  (^IntrospectionException [^java.lang.String mess]
    (new IntrospectionException mess)))

