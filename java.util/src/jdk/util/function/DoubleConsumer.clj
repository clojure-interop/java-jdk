(ns jdk.util.function.DoubleConsumer
  "Represents an operation that accepts a single double-valued argument and
  returns no result.  This is the primitive type specialization of
  Consumer for double.  Unlike most other functional interfaces,
  DoubleConsumer is expected to operate via side-effects.

  This is a functional interface
  whose functional method is accept(double)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function DoubleConsumer]))

(defn accept
  "Performs this operation on the given argument.

  value - the input argument - `double`"
  ([^java.util.function.DoubleConsumer this ^Double value]
    (-> this (.accept value))))

(defn and-then
  "Returns a composed DoubleConsumer that performs, in sequence, this
   operation followed by the after operation. If performing either
   operation throws an exception, it is relayed to the caller of the
   composed operation.  If performing this operation throws an exception,
   the after operation will not be performed.

  after - the operation to perform after this operation - `java.util.function.DoubleConsumer`

  returns: a composed DoubleConsumer that performs in sequence this
   operation followed by the after operation - `default java.util.function.DoubleConsumer`

  throws: java.lang.NullPointerException - if after is null"
  ([^java.util.function.DoubleConsumer this ^java.util.function.DoubleConsumer after]
    (-> this (.andThen after))))

