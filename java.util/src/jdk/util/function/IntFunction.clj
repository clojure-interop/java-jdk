(ns jdk.util.function.IntFunction
  "Represents a function that accepts an int-valued argument and produces a
  result.  This is the int-consuming primitive specialization for
  Function.

  This is a functional interface
  whose functional method is apply(int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntFunction]))

(defn apply
  "Applies this function to the given argument.

  value - the function argument - `int`

  returns: the function result - `IntFunction.R`"
  ([^java.util.function.IntFunction this ^Integer value]
    (-> this (.apply value))))

