(ns jdk.util.function.ObjDoubleConsumer
  "Represents an operation that accepts an object-valued and a
  double-valued argument, and returns no result.  This is the
  (reference, double) specialization of BiConsumer.
  Unlike most other functional interfaces, ObjDoubleConsumer is
  expected to operate via side-effects.

  This is a functional interface
  whose functional method is accept(Object, double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ObjDoubleConsumer]))

(defn accept
  "Performs this operation on the given arguments.

  t - the first input argument - `ObjDoubleConsumer.T`
  value - the second input argument - `double`"
  ([this t value]
    (-> this (.accept t value))))

