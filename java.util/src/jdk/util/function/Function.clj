(ns jdk.util.function.Function
  "Represents a function that accepts one argument and produces a result.

  This is a functional interface
  whose functional method is apply(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function Function]))

(defn apply
  "Applies this function to the given argument.

  t - the function argument - `Function.T`

  returns: the function result - `Function.R`"
  ([^java.util.function.Function this ^Function.T t]
    (-> this (.apply t))))

(defn compose
  "Returns a composed function that first applies the before
   function to its input, and then applies this function to the result.
   If evaluation of either function throws an exception, it is relayed to
   the caller of the composed function.

  before - the function to apply before this function is applied - `Function.T>`

  returns: a composed function that first applies the before
   function and then applies this function - `default <V> java.util.function.Function<V,Function.R>`

  throws: java.lang.NullPointerException - if before is null"
  ([^java.util.function.Function this ^Function.T> before]
    (-> this (.compose before))))

(defn and-then
  "Returns a composed function that first applies this function to
   its input, and then applies the after function to the result.
   If evaluation of either function throws an exception, it is relayed to
   the caller of the composed function.

  after - the function to apply after this function is applied - `V>`

  returns: a composed function that first applies this function and then
   applies the after function - `default <V> java.util.function.Function<Function.T,V>`

  throws: java.lang.NullPointerException - if after is null"
  ([^java.util.function.Function this after]
    (-> this (.andThen after))))

(defn *identity
  "Returns a function that always returns its input argument.

  returns: a function that always returns its input argument - `<T> java.util.function.Function<T,T>`"
  ([]
    (Function/identity )))

