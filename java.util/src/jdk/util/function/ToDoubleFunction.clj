(ns jdk.util.function.ToDoubleFunction
  "Represents a function that produces a double-valued result.  This is the
  double-producing primitive specialization for Function.

  This is a functional interface
  whose functional method is applyAsDouble(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ToDoubleFunction]))

(defn apply-as-double
  "Applies this function to the given argument.

  value - the function argument - `T`

  returns: the function result - `double`"
  (^Double [^ToDoubleFunction this value]
    (-> this (.applyAsDouble value))))

