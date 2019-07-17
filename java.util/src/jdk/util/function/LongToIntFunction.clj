(ns jdk.util.function.LongToIntFunction
  "Represents a function that accepts a long-valued argument and produces an
  int-valued result.  This is the long-to-int primitive
  specialization for Function.

  This is a functional interface
  whose functional method is applyAsInt(long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function LongToIntFunction]))

(defn apply-as-int
  "Applies this function to the given argument.

  value - the function argument - `long`

  returns: the function result - `int`"
  ([^. this ^Long value]
    (-> this (.applyAsInt value))))

