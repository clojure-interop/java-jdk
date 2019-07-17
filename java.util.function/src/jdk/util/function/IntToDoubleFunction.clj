(ns jdk.util.function.IntToDoubleFunction
  "Represents a function that accepts an int-valued argument and produces a
  double-valued result.  This is the int-to-double primitive
  specialization for Function.

  This is a functional interface
  whose functional method is applyAsDouble(int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntToDoubleFunction]))

(defn apply-as-double
  "Applies this function to the given argument.

  value - the function argument - `int`

  returns: the function result - `double`"
  ([^java.util.function.IntToDoubleFunction this ^Integer value]
    (-> this (.applyAsDouble value))))

