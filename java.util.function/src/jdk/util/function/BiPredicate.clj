(ns jdk.util.function.BiPredicate
  "Represents a predicate (boolean-valued function) of two arguments.  This is
  the two-arity specialization of Predicate.

  This is a functional interface
  whose functional method is test(Object, Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function BiPredicate]))

(defn test
  "Evaluates this predicate on the given arguments.

  t - the first input argument - `BiPredicate.T`
  u - the second input argument - `BiPredicate.U`

  returns: true if the input arguments match the predicate,
   otherwise false - `boolean`"
  ([this t u]
    (-> this (.test t u))))

(defn and
  "Returns a composed predicate that represents a short-circuiting logical
   AND of this predicate and another.  When evaluating the composed
   predicate, if this predicate is false, then the other
   predicate is not evaluated.

   Any exceptions thrown during evaluation of either predicate are relayed
   to the caller; if evaluation of this predicate throws an exception, the
   other predicate will not be evaluated.

  other - a predicate that will be logically-ANDed with this predicate - `BiPredicate.U>`

  returns: a composed predicate that represents the short-circuiting logical
   AND of this predicate and the other predicate - `default java.util.function.BiPredicate<BiPredicate.T,BiPredicate.U>`

  throws: java.lang.NullPointerException - if other is null"
  ([this other]
    (-> this (.and other))))

(defn negate
  "Returns a predicate that represents the logical negation of this
   predicate.

  returns: a predicate that represents the logical negation of this
   predicate - `default java.util.function.BiPredicate<BiPredicate.T,BiPredicate.U>`"
  ([this]
    (-> this (.negate))))

(defn or
  "Returns a composed predicate that represents a short-circuiting logical
   OR of this predicate and another.  When evaluating the composed
   predicate, if this predicate is true, then the other
   predicate is not evaluated.

   Any exceptions thrown during evaluation of either predicate are relayed
   to the caller; if evaluation of this predicate throws an exception, the
   other predicate will not be evaluated.

  other - a predicate that will be logically-ORed with this predicate - `BiPredicate.U>`

  returns: a composed predicate that represents the short-circuiting logical
   OR of this predicate and the other predicate - `default java.util.function.BiPredicate<BiPredicate.T,BiPredicate.U>`

  throws: java.lang.NullPointerException - if other is null"
  ([this other]
    (-> this (.or other))))

