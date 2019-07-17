(ns jdk.util.stream.BaseStream>
  "Base interface for streams, which are sequences of elements supporting
  sequential and parallel aggregate operations.  The following example
  illustrates an aggregate operation using the stream types Stream
  and IntStream, computing the sum of the weights of the red widgets:



      int sum = widgets.stream()
                       .filter(w -> w.getColor() == RED)
                       .mapToInt(w -> w.getWeight())
                       .sum();

  See the class documentation for Stream and the package documentation
  for java.util.stream for additional
  specification of streams, stream operations, stream pipelines, and
  parallelism, which governs the behavior of all stream types."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream BaseStream>]))

(defn iterator
  "Returns an iterator for the elements of this stream.

   This is a terminal
   operation.

  returns: the element iterator for this stream - `java.util.Iterator<BaseStream.T>`"
  ([^. this]
    (-> this (.iterator))))

(defn spliterator
  "Returns a spliterator for the elements of this stream.

   This is a terminal
   operation.

  returns: the element spliterator for this stream - `java.util.Spliterator<BaseStream.T>`"
  ([^. this]
    (-> this (.spliterator))))

(defn parallel?
  "Returns whether this stream, if a terminal operation were to be executed,
   would execute in parallel.  Calling this method after invoking an
   terminal stream operation method may yield unpredictable results.

  returns: true if this stream would execute in parallel if executed - `boolean`"
  ([^. this]
    (-> this (.isParallel))))

(defn sequential
  "Returns an equivalent stream that is sequential.  May return
   itself, either because the stream was already sequential, or because
   the underlying stream state was modified to be sequential.

   This is an intermediate
   operation.

  returns: a sequential stream - `BaseStream.S`"
  ([^. this]
    (-> this (.sequential))))

(defn parallel
  "Returns an equivalent stream that is parallel.  May return
   itself, either because the stream was already parallel, or because
   the underlying stream state was modified to be parallel.

   This is an intermediate
   operation.

  returns: a parallel stream - `BaseStream.S`"
  ([^. this]
    (-> this (.parallel))))

(defn unordered
  "Returns an equivalent stream that is
   unordered.  May return
   itself, either because the stream was already unordered, or because
   the underlying stream state was modified to be unordered.

   This is an intermediate
   operation.

  returns: an unordered stream - `BaseStream.S`"
  ([^. this]
    (-> this (.unordered))))

(defn on-close
  "Returns an equivalent stream with an additional close handler.  Close
   handlers are run when the close() method
   is called on the stream, and are executed in the order they were
   added.  All close handlers are run, even if earlier close handlers throw
   exceptions.  If any close handler throws an exception, the first
   exception thrown will be relayed to the caller of close(), with
   any remaining exceptions added to that exception as suppressed exceptions
   (unless one of the remaining exceptions is the same exception as the
   first exception, since an exception cannot suppress itself.)  May
   return itself.

   This is an intermediate
   operation.

  close-handler - A task to execute when the stream is closed - `java.lang.Runnable`

  returns: a stream with a handler that is run if the stream is closed - `BaseStream.S`"
  ([^. this ^java.lang.Runnable close-handler]
    (-> this (.onClose close-handler))))

(defn close
  "Closes this stream, causing all close handlers for this stream pipeline
   to be called."
  ([^. this]
    (-> this (.close))))

