(ns jdk.util.function.DoubleUnaryOperator
  "Represents an operation on a single double-valued operand that produces
  a double-valued result.  This is the primitive type specialization of
  UnaryOperator for double.

  This is a functional interface
  whose functional method is applyAsDouble(double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function DoubleUnaryOperator]))

(defn apply-as-double
  "Applies this operator to the given operand.

  operand - the operand - `double`

  returns: the operator result - `double`"
  ([^. this ^Double operand]
    (-> this (.applyAsDouble operand))))

(defn compose
  "Returns a composed operator that first applies the before
   operator to its input, and then applies this operator to the result.
   If evaluation of either operator throws an exception, it is relayed to
   the caller of the composed operator.

  before - the operator to apply before this operator is applied - `java.util.function.DoubleUnaryOperator`

  returns: a composed operator that first applies the before
   operator and then applies this operator - `default java.util.function.DoubleUnaryOperator`

  throws: java.lang.NullPointerException - if before is null"
  ([^. this ^java.util.function.DoubleUnaryOperator before]
    (-> this (.compose before))))

(defn and-then
  "Returns a composed operator that first applies this operator to
   its input, and then applies the after operator to the result.
   If evaluation of either operator throws an exception, it is relayed to
   the caller of the composed operator.

  after - the operator to apply after this operator is applied - `java.util.function.DoubleUnaryOperator`

  returns: a composed operator that first applies this operator and then
   applies the after operator - `default java.util.function.DoubleUnaryOperator`

  throws: java.lang.NullPointerException - if after is null"
  ([^. this ^java.util.function.DoubleUnaryOperator after]
    (-> this (.andThen after))))

(defn *identity
  "Returns a unary operator that always returns its input argument.

  returns: a unary operator that always returns its input argument - `java.util.function.DoubleUnaryOperator`"
  ([]
    (null/identity )))

