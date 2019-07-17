(ns jdk.util.function.Predicate
  "Represents a predicate (boolean-valued function) of one argument.

  This is a functional interface
  whose functional method is test(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function Predicate]))

(defn test
  "Evaluates this predicate on the given argument.

  t - the input argument - `Predicate.T`

  returns: true if the input argument matches the predicate,
   otherwise false - `boolean`"
  ([^. this ^Predicate.T t]
    (-> this (.test t))))

(defn and
  "Returns a composed predicate that represents a short-circuiting logical
   AND of this predicate and another.  When evaluating the composed
   predicate, if this predicate is false, then the other
   predicate is not evaluated.

   Any exceptions thrown during evaluation of either predicate are relayed
   to the caller; if evaluation of this predicate throws an exception, the
   other predicate will not be evaluated.

  other - a predicate that will be logically-ANDed with this predicate - `Predicate.T>`

  returns: a composed predicate that represents the short-circuiting logical
   AND of this predicate and the other predicate - `default java.util.function.Predicate<Predicate.T>`

  throws: java.lang.NullPointerException - if other is null"
  ([^. this ^Predicate.T> other]
    (-> this (.and other))))

(defn negate
  "Returns a predicate that represents the logical negation of this
   predicate.

  returns: a predicate that represents the logical negation of this
   predicate - `default java.util.function.Predicate<Predicate.T>`"
  ([^. this]
    (-> this (.negate))))

(defn or
  "Returns a composed predicate that represents a short-circuiting logical
   OR of this predicate and another.  When evaluating the composed
   predicate, if this predicate is true, then the other
   predicate is not evaluated.

   Any exceptions thrown during evaluation of either predicate are relayed
   to the caller; if evaluation of this predicate throws an exception, the
   other predicate will not be evaluated.

  other - a predicate that will be logically-ORed with this predicate - `Predicate.T>`

  returns: a composed predicate that represents the short-circuiting logical
   OR of this predicate and the other predicate - `default java.util.function.Predicate<Predicate.T>`

  throws: java.lang.NullPointerException - if other is null"
  ([^. this ^Predicate.T> other]
    (-> this (.or other))))

(defn *is-equal
  "Returns a predicate that tests if two arguments are equal according
   to Objects.equals(Object, Object).

  target-ref - the object reference with which to compare for equality, which may be null - `java.lang.Object`

  returns: a predicate that tests if two arguments are equal according
   to Objects.equals(Object, Object) - `<T> java.util.function.Predicate<T>`"
  ([^java.lang.Object target-ref]
    (null/isEqual target-ref)))

