(ns javax.lang.model.type.TypeVariable
  "Represents a type variable.
  A type variable may be explicitly declared by a
  javax.lang.model.element.type parameter of a
  type, method, or constructor.
  A type variable may also be declared implicitly, as by
  the capture conversion of a wildcard type argument
  (see chapter 5 of
  The Java™ Language Specification)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type TypeVariable]))

(defn as-element
  "Returns the element corresponding to this type variable.

  returns: the element corresponding to this type variable - `javax.lang.model.element.Element`"
  (^javax.lang.model.element.Element [^javax.lang.model.type.TypeVariable this]
    (-> this (.asElement))))

(defn get-upper-bound
  "Returns the upper bound of this type variable.

    If this type variable was declared with no explicit
   upper bounds, the result is java.lang.Object.
   If it was declared with multiple upper bounds,
   the result is an javax.lang.model.type.intersection type;
   individual bounds can be found by examining the result's
   bounds.

  returns: the upper bound of this type variable - `javax.lang.model.type.TypeMirror`"
  (^javax.lang.model.type.TypeMirror [^javax.lang.model.type.TypeVariable this]
    (-> this (.getUpperBound))))

(defn get-lower-bound
  "Returns the lower bound of this type variable.  While a type
   parameter cannot include an explicit lower bound declaration,
   capture conversion can produce a type variable with a
   non-trivial lower bound.  Type variables otherwise have a
   lower bound of NullType.

  returns: the lower bound of this type variable - `javax.lang.model.type.TypeMirror`"
  (^javax.lang.model.type.TypeMirror [^javax.lang.model.type.TypeVariable this]
    (-> this (.getLowerBound))))

