(ns jdk.util.function.ToDoubleBiFunction
  "Represents a function that accepts two arguments and produces a double-valued
  result.  This is the double-producing primitive specialization for
  BiFunction.

  This is a functional interface
  whose functional method is applyAsDouble(Object, Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ToDoubleBiFunction]))

(defn apply-as-double
  "Applies this function to the given arguments.

  t - the first function argument - `ToDoubleBiFunction.T`
  u - the second function argument - `ToDoubleBiFunction.U`

  returns: the function result - `double`"
  ([^java.util.function.ToDoubleBiFunction this ^ToDoubleBiFunction.T t ^ToDoubleBiFunction.U u]
    (-> this (.applyAsDouble t u))))

