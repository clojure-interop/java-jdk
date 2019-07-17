(ns jdk.util.function.LongFunction
  "Represents a function that accepts a long-valued argument and produces a
  result.  This is the long-consuming primitive specialization for
  Function.

  This is a functional interface
  whose functional method is apply(long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function LongFunction]))

(defn apply
  "Applies this function to the given argument.

  value - the function argument - `long`

  returns: the function result - `LongFunction.R`"
  ([this value]
    (-> this (.apply value))))

