(ns jdk.lang.reflect.AnnotatedType
  "AnnotatedType represents the potentially annotated use of a type in
  the program currently running in this VM. The use may be of any type in the
  Java programming language, including an array type, a parameterized type, a
  type variable, or a wildcard type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect AnnotatedType]))

(defn get-type
  "Returns the underlying type that this annotated type represents.

  returns: the type this annotated type represents - `java.lang.reflect.Type`"
  (^java.lang.reflect.Type [^AnnotatedType this]
    (-> this (.getType))))

