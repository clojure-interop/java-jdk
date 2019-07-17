(ns jdk.util.function.DoubleFunction
  "Represents a function that accepts a double-valued argument and produces a
  result.  This is the double-consuming primitive specialization for
  Function.

  This is a functional interface
  whose functional method is apply(double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function DoubleFunction]))

(defn apply
  "Applies this function to the given argument.

  value - the function argument - `double`

  returns: the function result - `DoubleFunction.R`"
  (^DoubleFunction.R [^java.util.function.DoubleFunction this ^Double value]
    (-> this (.apply value))))

