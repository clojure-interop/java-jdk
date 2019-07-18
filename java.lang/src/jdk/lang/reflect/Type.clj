(ns jdk.lang.reflect.Type
  "Type is the common superinterface for all types in the Java
  programming language. These include raw types, parameterized types,
  array types, type variables and primitive types."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Type]))

(defn get-type-name
  "Returns a string describing this type, including information
   about any type parameters.

  returns: a string describing this type - `default java.lang.String`"
  ([^Type this]
    (-> this (.getTypeName))))

