(ns jdk.util.function.DoubleToLongFunction
  "Represents a function that accepts a double-valued argument and produces a
  long-valued result.  This is the double-to-long primitive
  specialization for Function.

  This is a functional interface
  whose functional method is applyAsLong(double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function DoubleToLongFunction]))

(defn apply-as-long
  "Applies this function to the given argument.

  value - the function argument - `double`

  returns: the function result - `long`"
  ([^java.util.function.DoubleToLongFunction this ^Double value]
    (-> this (.applyAsLong value))))

