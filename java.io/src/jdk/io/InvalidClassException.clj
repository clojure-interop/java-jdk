(ns jdk.io.InvalidClassException
  "Thrown when the Serialization runtime detects one of the following
  problems with a Class.

   The serial version of the class does not match that of the class
       descriptor read from the stream
   The class contains unknown datatypes
   The class does not have an accessible no-arg constructor"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io InvalidClassException]))

(defn ->invalid-class-exception
  "Constructor.

  Constructs an InvalidClassException object.

  cname - a String naming the invalid class. - `java.lang.String`
  reason - a String describing the reason for the exception. - `java.lang.String`"
  (^InvalidClassException [^java.lang.String cname ^java.lang.String reason]
    (new InvalidClassException cname reason))
  (^InvalidClassException [^java.lang.String reason]
    (new InvalidClassException reason)))

(defn classname
  "Instance Field.

  Name of the invalid class.

  type: java.lang.String"
  (^java.lang.String [^InvalidClassException this]
    (-> this .-classname)))

(defn get-message
  "Produce the message and include the classname, if present.

  returns: the detail message string of this Throwable instance
            (which may be null). - `java.lang.String`"
  (^java.lang.String [^InvalidClassException this]
    (-> this (.getMessage))))

