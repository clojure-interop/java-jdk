(ns jdk.util.function.ToIntFunction
  "Represents a function that produces an int-valued result.  This is the
  int-producing primitive specialization for Function.

  This is a functional interface
  whose functional method is applyAsInt(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ToIntFunction]))

(defn apply-as-int
  "Applies this function to the given argument.

  value - the function argument - `ToIntFunction.T`

  returns: the function result - `int`"
  ([this value]
    (-> this (.applyAsInt value))))

