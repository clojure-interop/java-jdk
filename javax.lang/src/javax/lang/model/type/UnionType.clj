(ns javax.lang.model.type.UnionType
  "Represents a union type.

  As of the RELEASE_7 source version, union types can appear as the type
  of a multi-catch exception parameter."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type UnionType]))

(defn get-alternatives
  "Return the alternatives comprising this union type.

  returns: the alternatives comprising this union type. - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([this]
    (-> this (.getAlternatives))))

