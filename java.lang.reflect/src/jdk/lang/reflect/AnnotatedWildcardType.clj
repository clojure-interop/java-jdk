(ns jdk.lang.reflect.AnnotatedWildcardType
  "AnnotatedWildcardType represents the potentially annotated use of a
  wildcard type argument, whose upper or lower bounds may themselves represent
  annotated uses of types."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect AnnotatedWildcardType]))

(defn get-annotated-lower-bounds
  "Returns the potentially annotated lower bounds of this wildcard type.

  returns: the potentially annotated lower bounds of this wildcard type - `java.lang.reflect.AnnotatedType[]`"
  ([^. this]
    (-> this (.getAnnotatedLowerBounds))))

(defn get-annotated-upper-bounds
  "Returns the potentially annotated upper bounds of this wildcard type.

  returns: the potentially annotated upper bounds of this wildcard type - `java.lang.reflect.AnnotatedType[]`"
  ([^. this]
    (-> this (.getAnnotatedUpperBounds))))

