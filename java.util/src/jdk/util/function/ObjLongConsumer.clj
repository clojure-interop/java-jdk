(ns jdk.util.function.ObjLongConsumer
  "Represents an operation that accepts an object-valued and a
  long-valued argument, and returns no result.  This is the
  (reference, long) specialization of BiConsumer.
  Unlike most other functional interfaces, ObjLongConsumer is
  expected to operate via side-effects.

  This is a functional interface
  whose functional method is accept(Object, long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function ObjLongConsumer]))

(defn accept
  "Performs this operation on the given arguments.

  t - the first input argument - `ObjLongConsumer.T`
  value - the second input argument - `long`"
  ([this t value]
    (-> this (.accept t value))))

