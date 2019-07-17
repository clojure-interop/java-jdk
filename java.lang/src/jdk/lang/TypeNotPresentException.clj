(ns jdk.lang.TypeNotPresentException
  "Thrown when an application tries to access a type using a string
  representing the type's name, but no definition for the type with
  the specified name can be found.   This exception differs from
  ClassNotFoundException in that ClassNotFoundException is a
  checked exception, whereas this exception is unchecked.

  Note that this exception may be used when undefined type variables
  are accessed as well as when types (e.g., classes, interfaces or
  annotation types) are loaded.
  In particular, this exception can be thrown by the java.lang.reflect.API used to read annotations
  reflectively."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang TypeNotPresentException]))

(defn ->type-not-present-exception
  "Constructor.

  Constructs a TypeNotPresentException for the named type
   with the specified cause.

  type-name - the fully qualified name of the unavailable type - `java.lang.String`
  cause - the exception that was thrown when the system attempted to load the named type, or null if unavailable or inapplicable - `java.lang.Throwable`"
  ([^java.lang.String type-name ^java.lang.Throwable cause]
    (new TypeNotPresentException type-name cause)))

(defn type-name
  "Returns the fully qualified name of the unavailable type.

  returns: the fully qualified name of the unavailable type - `java.lang.String`"
  (^java.lang.String [^java.lang.TypeNotPresentException this]
    (-> this (.typeName))))

