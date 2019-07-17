(ns jdk.util.Spliterators
  "Static classes and methods for operating on or creating instances of
  Spliterator and its primitive specializations
  Spliterator.OfInt, Spliterator.OfLong, and
  Spliterator.OfDouble."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Spliterators]))

(defn *empty-spliterator
  "Creates an empty Spliterator

   The empty spliterator reports Spliterator.SIZED and
   Spliterator.SUBSIZED.  Calls to
   Spliterator.trySplit() always return null.

  returns: An empty spliterator - `<T> java.util.Spliterator<T>`"
  ([]
    (Spliterators/emptySpliterator )))

(defn *empty-int-spliterator
  "Creates an empty Spliterator.OfInt

   The empty spliterator reports Spliterator.SIZED and
   Spliterator.SUBSIZED.  Calls to
   Spliterator.trySplit() always return null.

  returns: An empty spliterator - `java.util.Spliterator.OfInt`"
  (^java.util.Spliterator.OfInt []
    (Spliterators/emptyIntSpliterator )))

(defn *empty-long-spliterator
  "Creates an empty Spliterator.OfLong

   The empty spliterator reports Spliterator.SIZED and
   Spliterator.SUBSIZED.  Calls to
   Spliterator.trySplit() always return null.

  returns: An empty spliterator - `java.util.Spliterator.OfLong`"
  (^java.util.Spliterator.OfLong []
    (Spliterators/emptyLongSpliterator )))

(defn *empty-double-spliterator
  "Creates an empty Spliterator.OfDouble

   The empty spliterator reports Spliterator.SIZED and
   Spliterator.SUBSIZED.  Calls to
   Spliterator.trySplit() always return null.

  returns: An empty spliterator - `java.util.Spliterator.OfDouble`"
  (^java.util.Spliterator.OfDouble []
    (Spliterators/emptyDoubleSpliterator )))

(defn *spliterator
  "Creates a Spliterator covering a range of elements of a given
   array, using a customized set of spliterator characteristics.

   This method is provided as an implementation convenience for
   Spliterators which store portions of their elements in arrays, and need
   fine control over Spliterator characteristics.  Most other situations in
   which a Spliterator for an array is needed should use
   Arrays.spliterator(Object[]).

   The returned spliterator always reports the characteristics
   SIZED and SUBSIZED.  The caller may provide additional
   characteristics for the spliterator to report; it is common to
   additionally specify IMMUTABLE and ORDERED.

  array - The array, assumed to be unmodified during use - `java.lang.Object[]`
  from-index - The least index (inclusive) to cover - `int`
  to-index - One past the greatest index to cover - `int`
  additional-characteristics - Additional spliterator characteristics of this spliterator's source or elements beyond SIZED and SUBSIZED which are are always reported - `int`

  returns: A spliterator for an array - `<T> java.util.Spliterator<T>`

  throws: java.lang.NullPointerException - if the given array is null"
  ([array ^Integer from-index ^Integer to-index ^Integer additional-characteristics]
    (Spliterators/spliterator array from-index to-index additional-characteristics))
  ([iterator ^Long size ^Integer characteristics]
    (Spliterators/spliterator iterator size characteristics))
  ([array ^Integer additional-characteristics]
    (Spliterators/spliterator array additional-characteristics)))

(defn *spliterator-unknown-size
  "Creates a Spliterator using a given Iterator
   as the source of elements, with no initial size estimate.

   The spliterator is not
   late-binding, inherits
   the fail-fast properties of the iterator, and implements
   trySplit to permit limited parallelism.

   Traversal of elements should be accomplished through the spliterator.
   The behaviour of splitting and traversal is undefined if the iterator is
   operated on after the spliterator is returned.

  iterator - The iterator for the source - `T>`
  characteristics - Characteristics of this spliterator's source or elements (SIZED and SUBSIZED, if supplied, are ignored and are not reported.) - `int`

  returns: A spliterator from an iterator - `<T> java.util.Spliterator<T>`

  throws: java.lang.NullPointerException - if the given iterator is null"
  ([iterator ^Integer characteristics]
    (Spliterators/spliteratorUnknownSize iterator characteristics)))

(defn *iterator
  "Creates an Iterator from a Spliterator.

   Traversal of elements should be accomplished through the iterator.
   The behaviour of traversal is undefined if the spliterator is operated
   after the iterator is returned.

  spliterator - The spliterator - `T>`

  returns: An iterator - `<T> java.util.Iterator<T>`

  throws: java.lang.NullPointerException - if the given spliterator is null"
  ([spliterator]
    (Spliterators/iterator spliterator)))

