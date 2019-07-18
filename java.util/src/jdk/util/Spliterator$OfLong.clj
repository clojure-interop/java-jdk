(ns jdk.util.Spliterator$OfLong
  "A Spliterator specialized for long values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Spliterator$OfLong]))

(defn try-split
  "Description copied from interface: Spliterator

  returns: a Spliterator covering some portion of the
   elements, or null if this spliterator cannot be split - `java.util.Spliterator$OfLong`"
  (^java.util.Spliterator$OfLong [^Spliterator$OfLong this]
    (-> this (.trySplit))))

(defn try-advance
  "Description copied from interface: Spliterator.OfPrimitive

  action - The action - `java.util.function.LongConsumer`

  returns: false if no remaining elements existed
   upon entry to this method, else true. - `boolean`"
  (^Boolean [^Spliterator$OfLong this ^java.util.function.LongConsumer action]
    (-> this (.tryAdvance action))))

(defn for-each-remaining
  "Description copied from interface: Spliterator.OfPrimitive

  action - The action - `java.util.function.LongConsumer`

  returns: `default void`"
  ([^Spliterator$OfLong this ^java.util.function.LongConsumer action]
    (-> this (.forEachRemaining action))))

