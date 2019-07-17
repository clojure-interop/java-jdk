(ns jdk.util.function.Consumer
  "Represents an operation that accepts a single input argument and returns no
  result. Unlike most other functional interfaces, Consumer is expected
  to operate via side-effects.

  This is a functional interface
  whose functional method is accept(Object)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.function Consumer]))

(defn accept
  "Performs this operation on the given argument.

  t - the input argument - `Consumer.T`"
  ([^. this ^Consumer.T t]
    (-> this (.accept t))))

(defn and-then
  "Returns a composed Consumer that performs, in sequence, this
   operation followed by the after operation. If performing either
   operation throws an exception, it is relayed to the caller of the
   composed operation.  If performing this operation throws an exception,
   the after operation will not be performed.

  after - the operation to perform after this operation - `Consumer.T>`

  returns: a composed Consumer that performs in sequence this
   operation followed by the after operation - `default java.util.function.Consumer<Consumer.T>`

  throws: java.lang.NullPointerException - if after is null"
  ([^. this ^Consumer.T> after]
    (-> this (.andThen after))))

