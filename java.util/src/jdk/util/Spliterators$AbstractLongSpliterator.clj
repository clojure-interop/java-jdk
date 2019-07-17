(ns jdk.util.Spliterators$AbstractLongSpliterator
  "An abstract Spliterator.OfLong that implements trySplit
  to permit limited parallelism.

  To implement a spliterator an extending class need only
  implement Spliterator.OfLong.tryAdvance(java.util.function.LongConsumer)
  tryAdvance}.  The extending class should override
  Spliterator.OfLong.forEachRemaining(java.util.function.LongConsumer) forEach} if it
  can provide a more performant implementation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Spliterators$AbstractLongSpliterator]))

(defn try-split
  "If this spliterator can be partitioned, returns a Spliterator
   covering elements, that will, upon return from this method, not
   be covered by this Spliterator.

   If this Spliterator is Spliterator.ORDERED, the returned Spliterator
   must cover a strict prefix of the elements.

   Unless this Spliterator covers an infinite number of elements,
   repeated calls to trySplit() must eventually return null.
   Upon non-null return:

   the value reported for estimateSize() before splitting,
   must, after splitting, be greater than or equal to estimateSize()
   for this and the returned Spliterator; and
   if this Spliterator is SUBSIZED, then estimateSize()
   for this spliterator before splitting must be equal to the sum of
   estimateSize() for this and the returned Spliterator after
   splitting.


   This method may return null for any reason,
   including emptiness, inability to split after traversal has
   commenced, data structure constraints, and efficiency
   considerations.

   This implementation permits limited parallelism.

  returns: a Spliterator covering some portion of the
   elements, or null if this spliterator cannot be split - `java.util.Spliterator.OfLong`"
  ([this]
    (-> this (.trySplit))))

(defn estimate-size
  "Returns an estimate of the number of elements that would be
   encountered by a Spliterator.forEachRemaining(java.util.function.Consumer<? super T>) traversal, or returns Long.MAX_VALUE if infinite, unknown, or too expensive to compute.

   If this Spliterator is Spliterator.SIZED and has not yet been partially
   traversed or split, or this Spliterator is Spliterator.SUBSIZED and has
   not yet been partially traversed, this estimate must be an accurate
   count of elements that would be encountered by a complete traversal.
   Otherwise, this estimate may be arbitrarily inaccurate, but must decrease
   as specified across invocations of Spliterator.trySplit().

  returns: the estimated size, or Long.MAX_VALUE if infinite,
           unknown, or too expensive to compute. - `long`"
  ([this]
    (-> this (.estimateSize))))

(defn characteristics
  "Returns a set of characteristics of this Spliterator and its
   elements. The result is represented as ORed values from Spliterator.ORDERED, Spliterator.DISTINCT, Spliterator.SORTED, Spliterator.SIZED,
   Spliterator.NONNULL, Spliterator.IMMUTABLE, Spliterator.CONCURRENT,
   Spliterator.SUBSIZED.  Repeated calls to characteristics() on
   a given spliterator, prior to or in-between calls to trySplit,
   should always return the same result.

   If a Spliterator reports an inconsistent set of
   characteristics (either those returned from a single invocation
   or across multiple invocations), no guarantees can be made
   about any computation using this Spliterator.

  returns: a representation of characteristics - `int`"
  ([this]
    (-> this (.characteristics))))

