(ns jdk.util.function.UnaryOperator
  "Represents an operation on a single operand that produces a result of the
  same type as its operand.  This is a specialization of Function for
  the case where the operand and result are of the same type.

  This is a functional interface
  whose functional method is Function.apply(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function UnaryOperator]))

(defn *identity
  "Returns a unary operator that always returns its input argument.

  returns: a unary operator that always returns its input argument - `<T> java.util.function.UnaryOperator<T>`"
  ([]
    (UnaryOperator/identity )))

