(ns jdk.util.function.IntPredicate
  "Represents a predicate (boolean-valued function) of one int-valued
  argument. This is the int-consuming primitive type specialization of
  Predicate.

  This is a functional interface
  whose functional method is test(int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntPredicate]))

(defn test
  "Evaluates this predicate on the given argument.

  value - the input argument - `int`

  returns: true if the input argument matches the predicate,
   otherwise false - `boolean`"
  ([^java.util.function.IntPredicate this ^Integer value]
    (-> this (.test value))))

(defn and
  "Returns a composed predicate that represents a short-circuiting logical
   AND of this predicate and another.  When evaluating the composed
   predicate, if this predicate is false, then the other
   predicate is not evaluated.

   Any exceptions thrown during evaluation of either predicate are relayed
   to the caller; if evaluation of this predicate throws an exception, the
   other predicate will not be evaluated.

  other - a predicate that will be logically-ANDed with this predicate - `java.util.function.IntPredicate`

  returns: a composed predicate that represents the short-circuiting logical
   AND of this predicate and the other predicate - `default java.util.function.IntPredicate`

  throws: java.lang.NullPointerException - if other is null"
  ([^java.util.function.IntPredicate this ^java.util.function.IntPredicate other]
    (-> this (.and other))))

(defn negate
  "Returns a predicate that represents the logical negation of this
   predicate.

  returns: a predicate that represents the logical negation of this
   predicate - `default java.util.function.IntPredicate`"
  ([^java.util.function.IntPredicate this]
    (-> this (.negate))))

(defn or
  "Returns a composed predicate that represents a short-circuiting logical
   OR of this predicate and another.  When evaluating the composed
   predicate, if this predicate is true, then the other
   predicate is not evaluated.

   Any exceptions thrown during evaluation of either predicate are relayed
   to the caller; if evaluation of this predicate throws an exception, the
   other predicate will not be evaluated.

  other - a predicate that will be logically-ORed with this predicate - `java.util.function.IntPredicate`

  returns: a composed predicate that represents the short-circuiting logical
   OR of this predicate and the other predicate - `default java.util.function.IntPredicate`

  throws: java.lang.NullPointerException - if other is null"
  ([^java.util.function.IntPredicate this ^java.util.function.IntPredicate other]
    (-> this (.or other))))

