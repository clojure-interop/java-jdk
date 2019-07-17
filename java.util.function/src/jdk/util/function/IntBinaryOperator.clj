(ns jdk.util.function.IntBinaryOperator
  "Represents an operation upon two int-valued operands and producing an
  int-valued result.   This is the primitive type specialization of
  BinaryOperator for int.

  This is a functional interface
  whose functional method is applyAsInt(int, int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntBinaryOperator]))

(defn apply-as-int
  "Applies this operator to the given operands.

  left - the first operand - `int`
  right - the second operand - `int`

  returns: the operator result - `int`"
  ([^java.util.function.IntBinaryOperator this ^Integer left ^Integer right]
    (-> this (.applyAsInt left right))))

