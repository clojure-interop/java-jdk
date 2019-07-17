(ns jdk.util.function.ToDoubleFunction
  "Represents a function that produces a double-valued result.  This is the
  double-producing primitive specialization for Function.

  This is a functional interface
  whose functional method is applyAsDouble(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ToDoubleFunction]))

(defn apply-as-double
  "Applies this function to the given argument.

  value - the function argument - `ToDoubleFunction.T`

  returns: the function result - `double`"
  (^Double [^java.util.function.ToDoubleFunction this ^ToDoubleFunction.T value]
    (-> this (.applyAsDouble value))))

