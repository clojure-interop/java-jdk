(ns jdk.util.function.IntToLongFunction
  "Represents a function that accepts an int-valued argument and produces a
  long-valued result.  This is the int-to-long primitive
  specialization for Function.

  This is a functional interface
  whose functional method is applyAsLong(int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntToLongFunction]))

(defn apply-as-long
  "Applies this function to the given argument.

  value - the function argument - `int`

  returns: the function result - `long`"
  ([^. this ^Integer value]
    (-> this (.applyAsLong value))))

