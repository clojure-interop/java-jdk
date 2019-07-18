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

  t - the input argument - `T`"
  ([^Consumer this t]
    (-> this (.accept t))))

(defn and-then
  "Returns a composed Consumer that performs, in sequence, this
   operation followed by the after operation. If performing either
   operation throws an exception, it is relayed to the caller of the
   composed operation.  If performing this operation throws an exception,
   the after operation will not be performed.

  after - the operation to perform after this operation - `java.util.function.Consumer`

  returns: a composed Consumer that performs in sequence this
   operation followed by the after operation - `default java.util.function.Consumer<T>`

  throws: java.lang.NullPointerException - if after is null"
  ([^Consumer this ^java.util.function.Consumer after]
    (-> this (.andThen after))))

