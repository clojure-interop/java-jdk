(ns jdk.util.function.IntUnaryOperator
  "Represents an operation on a single int-valued operand that produces
  an int-valued result.  This is the primitive type specialization of
  UnaryOperator for int.

  This is a functional interface
  whose functional method is applyAsInt(int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntUnaryOperator]))

(defn apply-as-int
  "Applies this operator to the given operand.

  operand - the operand - `int`

  returns: the operator result - `int`"
  (^Integer [^java.util.function.IntUnaryOperator this ^Integer operand]
    (-> this (.applyAsInt operand))))

(defn compose
  "Returns a composed operator that first applies the before
   operator to its input, and then applies this operator to the result.
   If evaluation of either operator throws an exception, it is relayed to
   the caller of the composed operator.

  before - the operator to apply before this operator is applied - `java.util.function.IntUnaryOperator`

  returns: a composed operator that first applies the before
   operator and then applies this operator - `default java.util.function.IntUnaryOperator`

  throws: java.lang.NullPointerException - if before is null"
  ([^java.util.function.IntUnaryOperator this ^java.util.function.IntUnaryOperator before]
    (-> this (.compose before))))

(defn and-then
  "Returns a composed operator that first applies this operator to
   its input, and then applies the after operator to the result.
   If evaluation of either operator throws an exception, it is relayed to
   the caller of the composed operator.

  after - the operator to apply after this operator is applied - `java.util.function.IntUnaryOperator`

  returns: a composed operator that first applies this operator and then
   applies the after operator - `default java.util.function.IntUnaryOperator`

  throws: java.lang.NullPointerException - if after is null"
  ([^java.util.function.IntUnaryOperator this ^java.util.function.IntUnaryOperator after]
    (-> this (.andThen after))))

(defn *identity
  "Returns a unary operator that always returns its input argument.

  returns: a unary operator that always returns its input argument - `java.util.function.IntUnaryOperator`"
  (^java.util.function.IntUnaryOperator []
    (IntUnaryOperator/identity )))

