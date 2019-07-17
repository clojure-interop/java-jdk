(ns jdk.util.PrimitiveIterator$OfInt
  "An Iterator specialized for int values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util PrimitiveIterator$OfInt]))

(defn next-int
  "Returns the next int element in the iteration.

  returns: the next int element in the iteration - `int`

  throws: java.util.NoSuchElementException - if the iteration has no more elements"
  ([^java.util.PrimitiveIterator$OfInt this]
    (-> this (.nextInt))))

(defn for-each-remaining
  "Performs the given action for each remaining element until all elements
   have been processed or the action throws an exception.  Actions are
   performed in the order of iteration, if that order is specified.
   Exceptions thrown by the action are relayed to the caller.

  action - The action to be performed for each element - `java.util.function.IntConsumer`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.util.PrimitiveIterator$OfInt this ^java.util.function.IntConsumer action]
    (-> this (.forEachRemaining action))))

(defn next
  "Returns the next element in the iteration.

  returns: the next element in the iteration - `default java.lang.Integer`"
  ([^java.util.PrimitiveIterator$OfInt this]
    (-> this (.next))))

