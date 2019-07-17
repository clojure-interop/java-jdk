(ns jdk.util.function.ObjIntConsumer
  "Represents an operation that accepts an object-valued and a
  int-valued argument, and returns no result.  This is the
  (reference, int) specialization of BiConsumer.
  Unlike most other functional interfaces, ObjIntConsumer is
  expected to operate via side-effects.

  This is a functional interface
  whose functional method is accept(Object, int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ObjIntConsumer]))

(defn accept
  "Performs this operation on the given arguments.

  t - the first input argument - `ObjIntConsumer.T`
  value - the second input argument - `int`"
  ([this t value]
    (-> this (.accept t value))))

