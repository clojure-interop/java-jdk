(ns javax.tools.JavaFileObject
  "File abstraction for tools operating on Java™ programming language
  source and class files.

  All methods in this interface might throw a SecurityException if
  a security exception occurs.

  Unless explicitly allowed, all methods in this interface might
  throw a NullPointerException if given a null argument."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools JavaFileObject]))

(defn get-kind
  "Gets the kind of this file object.

  returns: the kind - `javax.tools.JavaFileObject$Kind`"
  (^javax.tools.JavaFileObject$Kind [^JavaFileObject this]
    (-> this (.getKind))))

(defn name-compatible?
  "Checks if this file object is compatible with the specified
   simple name and kind.  A simple name is a single identifier
   (not qualified) as defined in
   The Java™ Language Specification,
   section 6.2 \"Names and Identifiers\".

  simple-name - a simple name of a class - `java.lang.String`
  kind - a kind - `javax.tools.JavaFileObject$Kind`

  returns: true if this file object is compatible; false
   otherwise - `boolean`"
  (^Boolean [^JavaFileObject this ^java.lang.String simple-name ^javax.tools.JavaFileObject$Kind kind]
    (-> this (.isNameCompatible simple-name kind))))

(defn get-nesting-kind
  "Provides a hint about the nesting level of the class
   represented by this file object.  This method may return
   NestingKind.MEMBER to mean
   NestingKind.LOCAL or NestingKind.ANONYMOUS.
   If the nesting level is not known or this file object does not
   represent a class file this method returns null.

  returns: the nesting kind, or null if the nesting kind
   is not known - `javax.lang.model.element.NestingKind`"
  (^javax.lang.model.element.NestingKind [^JavaFileObject this]
    (-> this (.getNestingKind))))

(defn get-access-level
  "Provides a hint about the access level of the class represented
   by this file object.  If the access level is not known or if
   this file object does not represent a class file this method
   returns null.

  returns: the access level - `javax.lang.model.element.Modifier`"
  (^javax.lang.model.element.Modifier [^JavaFileObject this]
    (-> this (.getAccessLevel))))

