(ns jdk.util.function.ToLongFunction
  "Represents a function that produces a long-valued result.  This is the
  long-producing primitive specialization for Function.

  This is a functional interface
  whose functional method is applyAsLong(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ToLongFunction]))

(defn apply-as-long
  "Applies this function to the given argument.

  value - the function argument - `ToLongFunction.T`

  returns: the function result - `long`"
  ([^java.util.function.ToLongFunction this ^ToLongFunction.T value]
    (-> this (.applyAsLong value))))

