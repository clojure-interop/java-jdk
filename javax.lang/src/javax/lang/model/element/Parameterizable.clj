(ns javax.lang.model.element.Parameterizable
  "A mixin interface for an element that has type parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element Parameterizable]))

(defn get-type-parameters
  "Returns the formal type parameters of the type element in
   declaration order.

  returns: the formal type parameters, or an empty list
   if there are none - `java.util.List<? extends javax.lang.model.element.TypeParameterElement>`"
  ([^javax.lang.model.element.Parameterizable this]
    (-> this (.getTypeParameters))))

