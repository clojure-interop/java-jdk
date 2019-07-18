(ns jdk.util.PrimitiveIterator$OfLong
  "An Iterator specialized for long values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util PrimitiveIterator$OfLong]))

(defn next-long
  "Returns the next long element in the iteration.

  returns: the next long element in the iteration - `long`

  throws: java.util.NoSuchElementException - if the iteration has no more elements"
  (^Long [^PrimitiveIterator$OfLong this]
    (-> this (.nextLong))))

(defn for-each-remaining
  "Performs the given action for each remaining element until all elements
   have been processed or the action throws an exception.  Actions are
   performed in the order of iteration, if that order is specified.
   Exceptions thrown by the action are relayed to the caller.

  action - The action to be performed for each element - `java.util.function.LongConsumer`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^PrimitiveIterator$OfLong this ^java.util.function.LongConsumer action]
    (-> this (.forEachRemaining action))))

(defn next
  "Returns the next element in the iteration.

  returns: the next element in the iteration - `default java.lang.Long`"
  ([^PrimitiveIterator$OfLong this]
    (-> this (.next))))

