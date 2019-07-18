(ns jdk.util.function.BinaryOperator
  "Represents an operation upon two operands of the same type, producing a result
  of the same type as the operands.  This is a specialization of
  BiFunction for the case where the operands and the result are all of
  the same type.

  This is a functional interface
  whose functional method is BiFunction.apply(Object, Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function BinaryOperator]))

(defn *min-by
  "Returns a BinaryOperator which returns the lesser of two elements
   according to the specified Comparator.

  comparator - a Comparator for comparing the two values - `java.util.Comparator`

  returns: a BinaryOperator which returns the lesser of its operands,
           according to the supplied Comparator - `<T> java.util.function.BinaryOperator<T>`

  throws: java.lang.NullPointerException - if the argument is null"
  ([^java.util.Comparator comparator]
    (BinaryOperator/minBy comparator)))

(defn *max-by
  "Returns a BinaryOperator which returns the greater of two elements
   according to the specified Comparator.

  comparator - a Comparator for comparing the two values - `java.util.Comparator`

  returns: a BinaryOperator which returns the greater of its operands,
           according to the supplied Comparator - `<T> java.util.function.BinaryOperator<T>`

  throws: java.lang.NullPointerException - if the argument is null"
  ([^java.util.Comparator comparator]
    (BinaryOperator/maxBy comparator)))

