(ns jdk.util.function.LongToDoubleFunction
  "Represents a function that accepts a long-valued argument and produces a
  double-valued result.  This is the long-to-double primitive
  specialization for Function.

  This is a functional interface
  whose functional method is applyAsDouble(long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function LongToDoubleFunction]))

(defn apply-as-double
  "Applies this function to the given argument.

  value - the function argument - `long`

  returns: the function result - `double`"
  ([^. this ^Long value]
    (-> this (.applyAsDouble value))))

