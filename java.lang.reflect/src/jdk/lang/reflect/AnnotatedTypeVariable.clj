(ns jdk.lang.reflect.AnnotatedTypeVariable
  "AnnotatedTypeVariable represents the potentially annotated use of a
  type variable, whose declaration may have bounds which themselves represent
  annotated uses of types."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect AnnotatedTypeVariable]))

(defn get-annotated-bounds
  "Returns the potentially annotated bounds of this type variable.

  returns: the potentially annotated bounds of this type variable - `java.lang.reflect.AnnotatedType[]`"
  ([^. this]
    (-> this (.getAnnotatedBounds))))

