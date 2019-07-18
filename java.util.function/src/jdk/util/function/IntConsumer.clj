(ns jdk.util.function.IntConsumer
  "Represents an operation that accepts a single int-valued argument and
  returns no result.  This is the primitive type specialization of
  Consumer for int.  Unlike most other functional interfaces,
  IntConsumer is expected to operate via side-effects.

  This is a functional interface
  whose functional method is accept(int)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function IntConsumer]))

(defn accept
  "Performs this operation on the given argument.

  value - the input argument - `int`"
  ([^IntConsumer this ^Integer value]
    (-> this (.accept value))))

(defn and-then
  "Returns a composed IntConsumer that performs, in sequence, this
   operation followed by the after operation. If performing either
   operation throws an exception, it is relayed to the caller of the
   composed operation.  If performing this operation throws an exception,
   the after operation will not be performed.

  after - the operation to perform after this operation - `java.util.function.IntConsumer`

  returns: a composed IntConsumer that performs in sequence this
   operation followed by the after operation - `default java.util.function.IntConsumer`

  throws: java.lang.NullPointerException - if after is null"
  ([^IntConsumer this ^java.util.function.IntConsumer after]
    (-> this (.andThen after))))

