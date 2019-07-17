(ns jdk.util.Spliterator$OfInt
  "A Spliterator specialized for int values."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Spliterator$OfInt]))

(defn try-split
  "Description copied from interface: Spliterator

  returns: a Spliterator covering some portion of the
   elements, or null if this spliterator cannot be split - `java.util.Spliterator.OfInt`"
  (^java.util.Spliterator.OfInt [^java.util.Spliterator$OfInt this]
    (-> this (.trySplit))))

(defn try-advance
  "Description copied from interface: Spliterator.OfPrimitive

  action - The action - `java.util.function.IntConsumer`

  returns: false if no remaining elements existed
   upon entry to this method, else true. - `boolean`"
  (^Boolean [^java.util.Spliterator$OfInt this ^java.util.function.IntConsumer action]
    (-> this (.tryAdvance action))))

(defn for-each-remaining
  "Description copied from interface: Spliterator.OfPrimitive

  action - The action - `java.util.function.IntConsumer`

  returns: `default void`"
  ([^java.util.Spliterator$OfInt this ^java.util.function.IntConsumer action]
    (-> this (.forEachRemaining action))))

