(ns jdk.util.function.LongConsumer
  "Represents an operation that accepts a single long-valued argument and
  returns no result.  This is the primitive type specialization of
  Consumer for long.  Unlike most other functional interfaces,
  LongConsumer is expected to operate via side-effects.

  This is a functional interface
  whose functional method is accept(long)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function LongConsumer]))

(defn accept
  "Performs this operation on the given argument.

  value - the input argument - `long`"
  ([this value]
    (-> this (.accept value))))

(defn and-then
  "Returns a composed LongConsumer that performs, in sequence, this
   operation followed by the after operation. If performing either
   operation throws an exception, it is relayed to the caller of the
   composed operation.  If performing this operation throws an exception,
   the after operation will not be performed.

  after - the operation to perform after this operation - `java.util.function.LongConsumer`

  returns: a composed LongConsumer that performs in sequence this
   operation followed by the after operation - `default java.util.function.LongConsumer`

  throws: java.lang.NullPointerException - if after is null"
  ([this after]
    (-> this (.andThen after))))

