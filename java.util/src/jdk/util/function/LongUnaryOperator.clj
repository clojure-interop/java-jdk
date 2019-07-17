(ns jdk.util.function.LongUnaryOperator
  "Represents an operation on a single long-valued operand that produces
  a long-valued result.  This is the primitive type specialization of
  UnaryOperator for long.

  This is a functional interface
  whose functional method is applyAsLong(long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function LongUnaryOperator]))

(defn apply-as-long
  "Applies this operator to the given operand.

  operand - the operand - `long`

  returns: the operator result - `long`"
  ([^java.util.function.LongUnaryOperator this ^Long operand]
    (-> this (.applyAsLong operand))))

(defn compose
  "Returns a composed operator that first applies the before
   operator to its input, and then applies this operator to the result.
   If evaluation of either operator throws an exception, it is relayed to
   the caller of the composed operator.

  before - the operator to apply before this operator is applied - `java.util.function.LongUnaryOperator`

  returns: a composed operator that first applies the before
   operator and then applies this operator - `default java.util.function.LongUnaryOperator`

  throws: java.lang.NullPointerException - if before is null"
  ([^java.util.function.LongUnaryOperator this ^java.util.function.LongUnaryOperator before]
    (-> this (.compose before))))

(defn and-then
  "Returns a composed operator that first applies this operator to
   its input, and then applies the after operator to the result.
   If evaluation of either operator throws an exception, it is relayed to
   the caller of the composed operator.

  after - the operator to apply after this operator is applied - `java.util.function.LongUnaryOperator`

  returns: a composed operator that first applies this operator and then
   applies the after operator - `default java.util.function.LongUnaryOperator`

  throws: java.lang.NullPointerException - if after is null"
  ([^java.util.function.LongUnaryOperator this ^java.util.function.LongUnaryOperator after]
    (-> this (.andThen after))))

(defn *identity
  "Returns a unary operator that always returns its input argument.

  returns: a unary operator that always returns its input argument - `java.util.function.LongUnaryOperator`"
  ([]
    (LongUnaryOperator/identity )))

