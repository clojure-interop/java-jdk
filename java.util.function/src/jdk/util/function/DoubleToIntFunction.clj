(ns jdk.util.function.DoubleToIntFunction
  "Represents a function that accepts a double-valued argument and produces an
  int-valued result.  This is the double-to-int primitive
  specialization for Function.

  This is a functional interface
  whose functional method is applyAsInt(double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function DoubleToIntFunction]))

(defn apply-as-int
  "Applies this function to the given argument.

  value - the function argument - `double`

  returns: the function result - `int`"
  (^Integer [^DoubleToIntFunction this ^Double value]
    (-> this (.applyAsInt value))))

