(ns jdk.util.Spliterator
  "An object for traversing and partitioning elements of a source.  The source
  of elements covered by a Spliterator could be, for example, an array, a
  Collection, an IO channel, or a generator function.

  A Spliterator may traverse elements individually (tryAdvance()) or sequentially in bulk
  (forEachRemaining()).

  A Spliterator may also partition off some of its elements (using
  trySplit()) as another Spliterator, to be used in
  possibly-parallel operations.  Operations using a Spliterator that
  cannot split, or does so in a highly imbalanced or inefficient
  manner, are unlikely to benefit from parallelism.  Traversal
  and splitting exhaust elements; each Spliterator is useful for only a single
  bulk computation.

  A Spliterator also reports a set of characteristics() of its
  structure, source, and elements from among ORDERED,
  DISTINCT, SORTED, SIZED, NONNULL,
  IMMUTABLE, CONCURRENT, and SUBSIZED. These may
  be employed by Spliterator clients to control, specialize or simplify
  computation.  For example, a Spliterator for a Collection would
  report SIZED, a Spliterator for a Set would report
  DISTINCT, and a Spliterator for a SortedSet would also
  report SORTED.  Characteristics are reported as a simple unioned bit
  set.

  Some characteristics additionally constrain method behavior; for example if
  ORDERED, traversal methods must conform to their documented ordering.
  New characteristics may be defined in the future, so implementors should not
  assign meanings to unlisted values.

  A Spliterator that does not report IMMUTABLE or
  CONCURRENT is expected to have a documented policy concerning:
  when the spliterator binds to the element source; and detection of
  structural interference of the element source detected after binding.  A
  late-binding Spliterator binds to the source of elements at the
  point of first traversal, first split, or first query for estimated size,
  rather than at the time the Spliterator is created.  A Spliterator that is
  not late-binding binds to the source of elements at the point of
  construction or first invocation of any method.  Modifications made to the
  source prior to binding are reflected when the Spliterator is traversed.
  After binding a Spliterator should, on a best-effort basis, throw
  ConcurrentModificationException if structural interference is
  detected.  Spliterators that do this are called fail-fast.  The
  bulk traversal method (forEachRemaining()) of a
  Spliterator may optimize traversal and check for structural interference
  after all elements have been traversed, rather than checking per-element and
  failing immediately.

  Spliterators can provide an estimate of the number of remaining elements
  via the estimateSize() method.  Ideally, as reflected in characteristic
  SIZED, this value corresponds exactly to the number of elements
  that would be encountered in a successful traversal.  However, even when not
  exactly known, an estimated value value may still be useful to operations
  being performed on the source, such as helping to determine whether it is
  preferable to split further or traverse the remaining elements sequentially.

  Despite their obvious utility in parallel algorithms, spliterators are not
  expected to be thread-safe; instead, implementations of parallel algorithms
  using spliterators should ensure that the spliterator is only used by one
  thread at a time.  This is generally easy to attain via serial
  thread-confinement, which often is a natural consequence of typical
  parallel algorithms that work by recursive decomposition.  A thread calling
  trySplit() may hand over the returned Spliterator to another thread,
  which in turn may traverse or further split that Spliterator.  The behaviour
  of splitting and traversal is undefined if two or more threads operate
  concurrently on the same spliterator.  If the original thread hands a
  spliterator off to another thread for processing, it is best if that handoff
  occurs before any elements are consumed with tryAdvance(), as certain guarantees (such as the accuracy of
  estimateSize() for SIZED spliterators) are only valid before
  traversal has begun.

  Primitive subtype specializations of Spliterator are provided for
  int, long, and double values.
  The subtype default implementations of
  tryAdvance(java.util.function.Consumer)
  and forEachRemaining(java.util.function.Consumer) box
  primitive values to instances of their corresponding wrapper class.  Such
  boxing may undermine any performance advantages gained by using the primitive
  specializations.  To avoid boxing, the corresponding primitive-based methods
  should be used.  For example,
  Spliterator.OfInt.tryAdvance(java.util.function.IntConsumer)
  and Spliterator.OfInt.forEachRemaining(java.util.function.IntConsumer)
  should be used in preference to
  Spliterator.OfInt.tryAdvance(java.util.function.Consumer) and
  Spliterator.OfInt.forEachRemaining(java.util.function.Consumer).
  Traversal of primitive values using boxing-based methods
  tryAdvance() and
  forEachRemaining()
  does not affect the order in which the values, transformed to boxed values,
  are encountered."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Spliterator]))

(defn try-advance
  "If a remaining element exists, performs the given action on it,
   returning true; else returns false.  If this
   Spliterator is ORDERED the action is performed on the
   next element in encounter order.  Exceptions thrown by the
   action are relayed to the caller.

  action - The action - `Spliterator.T>`

  returns: false if no remaining elements existed
   upon entry to this method, else true. - `boolean`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.util.Spliterator this ^Spliterator.T> action]
    (-> this (.tryAdvance action))))

(defn for-each-remaining
  "Performs the given action for each remaining element, sequentially in
   the current thread, until all elements have been processed or the action
   throws an exception.  If this Spliterator is ORDERED, actions
   are performed in encounter order.  Exceptions thrown by the action
   are relayed to the caller.

  action - The action - `Spliterator.T>`

  returns: `default void`

  throws: java.lang.NullPointerException - if the specified action is null"
  ([^java.util.Spliterator this ^Spliterator.T> action]
    (-> this (.forEachRemaining action))))

(defn try-split
  "If this spliterator can be partitioned, returns a Spliterator
   covering elements, that will, upon return from this method, not
   be covered by this Spliterator.

   If this Spliterator is ORDERED, the returned Spliterator
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

  returns: a Spliterator covering some portion of the
   elements, or null if this spliterator cannot be split - `java.util.Spliterator<Spliterator.T>`"
  ([^java.util.Spliterator this]
    (-> this (.trySplit))))

(defn estimate-size
  "Returns an estimate of the number of elements that would be
   encountered by a forEachRemaining(java.util.function.Consumer<? super T>) traversal, or returns Long.MAX_VALUE if infinite, unknown, or too expensive to compute.

   If this Spliterator is SIZED and has not yet been partially
   traversed or split, or this Spliterator is SUBSIZED and has
   not yet been partially traversed, this estimate must be an accurate
   count of elements that would be encountered by a complete traversal.
   Otherwise, this estimate may be arbitrarily inaccurate, but must decrease
   as specified across invocations of trySplit().

  returns: the estimated size, or Long.MAX_VALUE if infinite,
           unknown, or too expensive to compute. - `long`"
  ([^java.util.Spliterator this]
    (-> this (.estimateSize))))

(defn get-exact-size-if-known
  "Convenience method that returns estimateSize() if this
   Spliterator is SIZED, else -1.

  returns: the exact size, if known, else -1. - `default long`"
  ([^java.util.Spliterator this]
    (-> this (.getExactSizeIfKnown))))

(defn characteristics
  "Returns a set of characteristics of this Spliterator and its
   elements. The result is represented as ORed values from ORDERED, DISTINCT, SORTED, SIZED,
   NONNULL, IMMUTABLE, CONCURRENT,
   SUBSIZED.  Repeated calls to characteristics() on
   a given spliterator, prior to or in-between calls to trySplit,
   should always return the same result.

   If a Spliterator reports an inconsistent set of
   characteristics (either those returned from a single invocation
   or across multiple invocations), no guarantees can be made
   about any computation using this Spliterator.

  returns: a representation of characteristics - `int`"
  ([^java.util.Spliterator this]
    (-> this (.characteristics))))

(defn has-characteristics
  "Returns true if this Spliterator's characteristics() contain all of the given characteristics.

  characteristics - the characteristics to check for - `int`

  returns: true if all the specified characteristics are present,
   else false - `default boolean`"
  ([^java.util.Spliterator this ^Integer characteristics]
    (-> this (.hasCharacteristics characteristics))))

(defn get-comparator
  "If this Spliterator's source is SORTED by a Comparator,
   returns that Comparator. If the source is SORTED in
   java.lang.natural order, returns null.  Otherwise,
   if the source is not SORTED, throws IllegalStateException.

  returns: a Comparator, or null if the elements are sorted in the
   natural order. - `default java.util.Comparator<? super Spliterator.T>`

  throws: java.lang.IllegalStateException - if the spliterator does not report a characteristic of SORTED."
  ([^java.util.Spliterator this]
    (-> this (.getComparator))))

