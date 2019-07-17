(ns javax.lang.model.type.WildcardType
  "Represents a wildcard type argument.
  Examples include:

    ?
    ? extends Number
    ? super T

   A wildcard may have its upper bound explicitly set by an
  extends clause, its lower bound explicitly set by a
  super clause, or neither (but not both)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type WildcardType]))

(defn get-extends-bound
  "Returns the upper bound of this wildcard.
   If no upper bound is explicitly declared,
   null is returned.

  returns: the upper bound of this wildcard - `javax.lang.model.type.TypeMirror`"
  ([^. this]
    (-> this (.getExtendsBound))))

(defn get-super-bound
  "Returns the lower bound of this wildcard.
   If no lower bound is explicitly declared,
   null is returned.

  returns: the lower bound of this wildcard - `javax.lang.model.type.TypeMirror`"
  ([^. this]
    (-> this (.getSuperBound))))

