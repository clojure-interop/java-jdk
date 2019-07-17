(ns jdk.util.function.DoubleBinaryOperator
  "Represents an operation upon two double-valued operands and producing a
  double-valued result.   This is the primitive type specialization of
  BinaryOperator for double.

  This is a functional interface
  whose functional method is applyAsDouble(double, double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function DoubleBinaryOperator]))

(defn apply-as-double
  "Applies this operator to the given operands.

  left - the first operand - `double`
  right - the second operand - `double`

  returns: the operator result - `double`"
  ([^java.util.function.DoubleBinaryOperator this ^Double left ^Double right]
    (-> this (.applyAsDouble left right))))

