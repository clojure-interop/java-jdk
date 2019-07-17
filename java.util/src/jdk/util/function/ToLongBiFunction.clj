(ns jdk.util.function.ToLongBiFunction
  "Represents a function that accepts two arguments and produces a long-valued
  result.  This is the long-producing primitive specialization for
  BiFunction.

  This is a functional interface
  whose functional method is applyAsLong(Object, Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ToLongBiFunction]))

(defn apply-as-long
  "Applies this function to the given arguments.

  t - the first function argument - `ToLongBiFunction.T`
  u - the second function argument - `ToLongBiFunction.U`

  returns: the function result - `long`"
  ([^java.util.function.ToLongBiFunction this ^ToLongBiFunction.T t ^ToLongBiFunction.U u]
    (-> this (.applyAsLong t u))))

