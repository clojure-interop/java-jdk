(ns jdk.util.Spliterator$OfDouble
  "A Spliterator specialized for double values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Spliterator$OfDouble]))

(defn try-split
  "Description copied from interface: Spliterator

  returns: a Spliterator covering some portion of the
   elements, or null if this spliterator cannot be split - `java.util.Spliterator.OfDouble`"
  ([^. this]
    (-> this (.trySplit))))

(defn try-advance
  "Description copied from interface: Spliterator.OfPrimitive

  action - The action - `java.util.function.DoubleConsumer`

  returns: false if no remaining elements existed
   upon entry to this method, else true. - `boolean`"
  ([^. this ^java.util.function.DoubleConsumer action]
    (-> this (.tryAdvance action))))

(defn for-each-remaining
  "Description copied from interface: Spliterator.OfPrimitive

  action - The action - `java.util.function.DoubleConsumer`

  returns: `default void`"
  ([^. this ^java.util.function.DoubleConsumer action]
    (-> this (.forEachRemaining action))))

