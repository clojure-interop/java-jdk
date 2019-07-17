(ns jdk.lang.reflect.AnnotatedParameterizedType
  "AnnotatedParameterizedType represents the potentially annotated use
  of a parameterized type, whose type arguments may themselves represent
  annotated uses of types."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect AnnotatedParameterizedType]))

(defn get-annotated-actual-type-arguments
  "Returns the potentially annotated actual type arguments of this parameterized type.

  returns: the potentially annotated actual type arguments of this parameterized type - `java.lang.reflect.AnnotatedType[]`"
  ([^. this]
    (-> this (.getAnnotatedActualTypeArguments))))

