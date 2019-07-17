(ns jdk.util.function.BiConsumer
  "Represents an operation that accepts two input arguments and returns no
  result.  This is the two-arity specialization of Consumer.
  Unlike most other functional interfaces, BiConsumer is expected
  to operate via side-effects.

  This is a functional interface
  whose functional method is accept(Object, Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function BiConsumer]))

(defn accept
  "Performs this operation on the given arguments.

  t - the first input argument - `BiConsumer.T`
  u - the second input argument - `BiConsumer.U`"
  ([this t u]
    (-> this (.accept t u))))

(defn and-then
  "Returns a composed BiConsumer that performs, in sequence, this
   operation followed by the after operation. If performing either
   operation throws an exception, it is relayed to the caller of the
   composed operation.  If performing this operation throws an exception,
   the after operation will not be performed.

  after - the operation to perform after this operation - `BiConsumer.U>`

  returns: a composed BiConsumer that performs in sequence this
   operation followed by the after operation - `default java.util.function.BiConsumer<BiConsumer.T,BiConsumer.U>`

  throws: java.lang.NullPointerException - if after is null"
  ([this after]
    (-> this (.andThen after))))

