(ns jdk.util.function.BiFunction
  "Represents a function that accepts two arguments and produces a result.
  This is the two-arity specialization of Function.

  This is a functional interface
  whose functional method is apply(Object, Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function BiFunction]))

(defn apply
  "Applies this function to the given arguments.

  t - the first function argument - `T`
  u - the second function argument - `U`

  returns: the function result - `R`"
  ([^BiFunction this t u]
    (-> this (.apply t u))))

(defn and-then
  "Returns a composed function that first applies this function to
   its input, and then applies the after function to the result.
   If evaluation of either function throws an exception, it is relayed to
   the caller of the composed function.

  after - the function to apply after this function is applied - `java.util.function.Function`

  returns: a composed function that first applies this function and then
   applies the after function - `default <V> java.util.function.BiFunction<T,U,V>`

  throws: java.lang.NullPointerException - if after is null"
  ([^BiFunction this ^java.util.function.Function after]
    (-> this (.andThen after))))

