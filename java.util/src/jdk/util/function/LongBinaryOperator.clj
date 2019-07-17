(ns jdk.util.function.LongBinaryOperator
  "Represents an operation upon two long-valued operands and producing a
  long-valued result.   This is the primitive type specialization of
  BinaryOperator for long.

  This is a functional interface
  whose functional method is applyAsLong(long, long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function LongBinaryOperator]))

(defn apply-as-long
  "Applies this operator to the given operands.

  left - the first operand - `long`
  right - the second operand - `long`

  returns: the operator result - `long`"
  ([^java.util.function.LongBinaryOperator this ^Long left ^Long right]
    (-> this (.applyAsLong left right))))

