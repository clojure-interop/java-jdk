(ns jdk.lang.reflect.AnnotatedArrayType
  "AnnotatedArrayType represents the potentially annotated use of an
  array type, whose component type may itself represent the annotated use of a
  type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect AnnotatedArrayType]))

(defn get-annotated-generic-component-type
  "Returns the potentially annotated generic component type of this array type.

  returns: the potentially annotated generic component type of this array type - `java.lang.reflect.AnnotatedType`"
  (^java.lang.reflect.AnnotatedType [^java.lang.reflect.AnnotatedArrayType this]
    (-> this (.getAnnotatedGenericComponentType))))

