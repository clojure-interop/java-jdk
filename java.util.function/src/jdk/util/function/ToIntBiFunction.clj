(ns jdk.util.function.ToIntBiFunction
  "Represents a function that accepts two arguments and produces an int-valued
  result.  This is the int-producing primitive specialization for
  BiFunction.

  This is a functional interface
  whose functional method is applyAsInt(Object, Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ToIntBiFunction]))

(defn apply-as-int
  "Applies this function to the given arguments.

  t - the first function argument - `ToIntBiFunction.T`
  u - the second function argument - `ToIntBiFunction.U`

  returns: the function result - `int`"
  ([this t u]
    (-> this (.applyAsInt t u))))

