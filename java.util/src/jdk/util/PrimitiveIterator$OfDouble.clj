(ns jdk.util.PrimitiveIterator$OfDouble
  "An Iterator specialized for double values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util PrimitiveIterator$OfDouble]))

(defn next-double
  "Returns the next double element in the iteration.

  returns: the next double element in the iteration - `double`

  throws: java.util.NoSuchElementException - if the iteration has no more elements"
  ([^java.util.PrimitiveIterator$OfDouble this]
    (-> this (.nextDouble))))

(defn for-each-remaining
  "Performs the given action for each remaining element until all elements
   have been processed or the action throws an exception.  Actions are
   performed in the order of iteration, if that order is specified.
   Exceptions thrown by the action are relayed to the caller.

  action - The action to be performed for each element - `java.util.function.DoubleConsumer`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.util.PrimitiveIterator$OfDouble this ^java.util.function.DoubleConsumer action]
    (-> this (.forEachRemaining action))))

(defn next
  "Returns the next element in the iteration.

  returns: the next element in the iteration - `default java.lang.Double`"
  ([^java.util.PrimitiveIterator$OfDouble this]
    (-> this (.next))))

