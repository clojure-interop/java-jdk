(ns jdk.util.stream.LongStream
  "A sequence of primitive long-valued elements supporting sequential and parallel
  aggregate operations.  This is the long primitive specialization of
  Stream.

  The following example illustrates an aggregate operation using
  Stream and LongStream, computing the sum of the weights of the
  red widgets:



      long sum = widgets.stream()
                        .filter(w -> w.getColor() == RED)
                        .mapToLong(w -> w.getWeight())
                        .sum();

  See the class documentation for Stream and the package documentation
  for java.util.stream for additional
  specification of streams, stream operations, stream pipelines, and
  parallelism."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream LongStream]))

(defn skip
  "Returns a stream consisting of the remaining elements of this stream
   after discarding the first n elements of the stream.
   If this stream contains fewer than n elements then an
   empty stream will be returned.

   This is a stateful
   intermediate operation.

  n - the number of leading elements to skip - `long`

  returns: the new stream - `java.util.stream.LongStream`

  throws: java.lang.IllegalArgumentException - if n is negative"
  ([^. this ^Long n]
    (-> this (.skip n))))

(defn map
  "Returns a stream consisting of the results of applying the given
   function to the elements of this stream.

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element - `java.util.function.LongUnaryOperator`

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this ^java.util.function.LongUnaryOperator mapper]
    (-> this (.map mapper))))

(defn *range
  "Returns a sequential ordered LongStream from startInclusive
   (inclusive) to endExclusive (exclusive) by an incremental step of
   1.

  start-inclusive - the (inclusive) initial value - `long`
  end-exclusive - the exclusive upper bound - `long`

  returns: a sequential LongStream for the range of long
           elements - `java.util.stream.LongStream`"
  ([^Long start-inclusive ^Long end-exclusive]
    (null/range start-inclusive end-exclusive)))

(defn peek
  "Returns a stream consisting of the elements of this stream, additionally
   performing the provided action on each element as elements are consumed
   from the resulting stream.

   This is an intermediate
   operation.

   For parallel stream pipelines, the action may be called at
   whatever time and in whatever thread the element is made available by the
   upstream operation.  If the action modifies shared state,
   it is responsible for providing the required synchronization.

  action - a non-interfering action to perform on the elements as they are consumed from the stream - `java.util.function.LongConsumer`

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this ^java.util.function.LongConsumer action]
    (-> this (.peek action))))

(defn min
  "Returns an OptionalLong describing the minimum element of this
   stream, or an empty optional if this stream is empty.  This is a special
   case of a reduction
   and is equivalent to:


       return reduce(Long::min);

   This is a terminal operation.

  returns: an OptionalLong containing the minimum element of this
   stream, or an empty OptionalLong if the stream is empty - `java.util.OptionalLong`"
  ([^. this]
    (-> this (.min))))

(defn spliterator
  "Description copied from interface: BaseStream

  returns: the element spliterator for this stream - `java.util.Spliterator.OfLong`"
  ([^. this]
    (-> this (.spliterator))))

(defn for-each
  "Performs an action for each element of this stream.

   This is a terminal
   operation.

   For parallel stream pipelines, this operation does not
   guarantee to respect the encounter order of the stream, as doing so
   would sacrifice the benefit of parallelism.  For any given element, the
   action may be performed at whatever time and in whatever thread the
   library chooses.  If the action accesses shared state, it is
   responsible for providing the required synchronization.

  action - a non-interfering action to perform on the elements - `java.util.function.LongConsumer`"
  ([^. this ^java.util.function.LongConsumer action]
    (-> this (.forEach action))))

(defn for-each-ordered
  "Performs an action for each element of this stream, guaranteeing that
   each element is processed in encounter order for streams that have a
   defined encounter order.

   This is a terminal
   operation.

  action - a non-interfering action to perform on the elements - `java.util.function.LongConsumer`"
  ([^. this ^java.util.function.LongConsumer action]
    (-> this (.forEachOrdered action))))

(defn *of
  "Returns a sequential LongStream containing a single element.

  t - the single element - `long`

  returns: a singleton sequential stream - `java.util.stream.LongStream`"
  ([^Long t]
    (null/of t)))

(defn sequential
  "Description copied from interface: BaseStream

  returns: a sequential stream - `java.util.stream.LongStream`"
  ([^. this]
    (-> this (.sequential))))

(defn find-first
  "Returns an OptionalLong describing the first element of this
   stream, or an empty OptionalLong if the stream is empty.  If the
   stream has no encounter order, then any element may be returned.

   This is a short-circuiting
   terminal operation.

  returns: an OptionalLong describing the first element of this
   stream, or an empty OptionalLong if the stream is empty - `java.util.OptionalLong`"
  ([^. this]
    (-> this (.findFirst))))

(defn average
  "Returns an OptionalDouble describing the arithmetic mean of elements of
   this stream, or an empty optional if this stream is empty.  This is a
   special case of a
   reduction.

   This is a terminal
   operation.

  returns: an OptionalDouble containing the average element of this
   stream, or an empty optional if the stream is empty - `java.util.OptionalDouble`"
  ([^. this]
    (-> this (.average))))

(defn all-match
  "Returns whether all elements of this stream match the provided predicate.
   May not evaluate the predicate on all elements if not necessary for
   determining the result.  If the stream is empty then true is
   returned and the predicate is not evaluated.

   This is a short-circuiting
   terminal operation.

  predicate - a non-interfering, stateless predicate to apply to elements of this stream - `java.util.function.LongPredicate`

  returns: true if either all elements of the stream match the
   provided predicate or the stream is empty, otherwise false - `boolean`"
  ([^. this ^java.util.function.LongPredicate predicate]
    (-> this (.allMatch predicate))))

(defn parallel
  "Description copied from interface: BaseStream

  returns: a parallel stream - `java.util.stream.LongStream`"
  ([^. this]
    (-> this (.parallel))))

(defn sum
  "Returns the sum of elements in this stream.  This is a special case
   of a reduction
   and is equivalent to:


       return reduce(0, Long::sum);

   This is a terminal
   operation.

  returns: the sum of elements in this stream - `long`"
  ([^. this]
    (-> this (.sum))))

(defn sorted
  "Returns a stream consisting of the elements of this stream in sorted
   order.

   This is a stateful
   intermediate operation.

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this]
    (-> this (.sorted))))

(defn *iterate
  "Returns an infinite sequential ordered LongStream produced by iterative
   application of a function f to an initial element seed,
   producing a Stream consisting of seed, f(seed),
   f(f(seed)), etc.

   The first element (position 0) in the LongStream will
   be the provided seed.  For n > 0, the element at position
   n, will be the result of applying the function f to the
   element at position n - 1.

  seed - the initial element - `long`
  f - a function to be applied to to the previous element to produce a new element - `java.util.function.LongUnaryOperator`

  returns: a new sequential LongStream - `java.util.stream.LongStream`"
  ([^Long seed ^java.util.function.LongUnaryOperator f]
    (null/iterate seed f)))

(defn max
  "Returns an OptionalLong describing the maximum element of this
   stream, or an empty optional if this stream is empty.  This is a special
   case of a reduction
   and is equivalent to:


       return reduce(Long::max);

   This is a terminal
   operation.

  returns: an OptionalLong containing the maximum element of this
   stream, or an empty OptionalLong if the stream is empty - `java.util.OptionalLong`"
  ([^. this]
    (-> this (.max))))

(defn *generate
  "Returns an infinite sequential unordered stream where each element is
   generated by the provided LongSupplier.  This is suitable for
   generating constant streams, streams of random elements, etc.

  s - the LongSupplier for generated elements - `java.util.function.LongSupplier`

  returns: a new infinite sequential unordered LongStream - `java.util.stream.LongStream`"
  ([^java.util.function.LongSupplier s]
    (null/generate s)))

(defn *builder
  "Returns a builder for a LongStream.

  returns: a stream builder - `java.util.stream.LongStream.Builder`"
  ([]
    (null/builder )))

(defn count
  "Returns the count of elements in this stream.  This is a special case of
   a reduction and is
   equivalent to:


       return map(e -> 1L).sum();

   This is a terminal operation.

  returns: the count of elements in this stream - `long`"
  ([^. this]
    (-> this (.count))))

(defn map-to-double
  "Returns a DoubleStream consisting of the results of applying the
   given function to the elements of this stream.

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element - `java.util.function.LongToDoubleFunction`

  returns: the new stream - `java.util.stream.DoubleStream`"
  ([^. this ^java.util.function.LongToDoubleFunction mapper]
    (-> this (.mapToDouble mapper))))

(defn iterator
  "Description copied from interface: BaseStream

  returns: the element iterator for this stream - `java.util.PrimitiveIterator.OfLong`"
  ([^. this]
    (-> this (.iterator))))

(defn map-to-int
  "Returns an IntStream consisting of the results of applying the
   given function to the elements of this stream.

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element - `java.util.function.LongToIntFunction`

  returns: the new stream - `java.util.stream.IntStream`"
  ([^. this ^java.util.function.LongToIntFunction mapper]
    (-> this (.mapToInt mapper))))

(defn distinct
  "Returns a stream consisting of the distinct elements of this stream.

   This is a stateful
   intermediate operation.

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this]
    (-> this (.distinct))))

(defn boxed
  "Returns a Stream consisting of the elements of this stream,
   each boxed to a Long.

   This is an intermediate
   operation.

  returns: a Stream consistent of the elements of this stream,
   each boxed to Long - `java.util.stream.Stream<java.lang.Long>`"
  ([^. this]
    (-> this (.boxed))))

(defn limit
  "Returns a stream consisting of the elements of this stream, truncated
   to be no longer than maxSize in length.

   This is a short-circuiting
   stateful intermediate operation.

  max-size - the number of elements the stream should be limited to - `long`

  returns: the new stream - `java.util.stream.LongStream`

  throws: java.lang.IllegalArgumentException - if maxSize is negative"
  ([^. this ^Long max-size]
    (-> this (.limit max-size))))

(defn flat-map
  "Returns a stream consisting of the results of replacing each element of
   this stream with the contents of a mapped stream produced by applying
   the provided mapping function to each element.  Each mapped stream is
   closed after its contents
   have been placed into this stream.  (If a mapped stream is null
   an empty stream is used, instead.)

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element which produces a LongStream of new values - `java.util.stream.LongStream>`

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this ^java.util.stream.LongStream> mapper]
    (-> this (.flatMap mapper))))

(defn *concat
  "Creates a lazily concatenated stream whose elements are all the
   elements of the first stream followed by all the elements of the
   second stream.  The resulting stream is ordered if both
   of the input streams are ordered, and parallel if either of the input
   streams is parallel.  When the resulting stream is closed, the close
   handlers for both input streams are invoked.

  a - the first stream - `java.util.stream.LongStream`
  b - the second stream - `java.util.stream.LongStream`

  returns: the concatenation of the two input streams - `java.util.stream.LongStream`"
  ([^java.util.stream.LongStream a ^java.util.stream.LongStream b]
    (null/concat a b)))

(defn filter
  "Returns a stream consisting of the elements of this stream that match
   the given predicate.

   This is an intermediate
   operation.

  predicate - a non-interfering, stateless predicate to apply to each element to determine if it should be included - `java.util.function.LongPredicate`

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this ^java.util.function.LongPredicate predicate]
    (-> this (.filter predicate))))

(defn *empty
  "Returns an empty sequential LongStream.

  returns: an empty sequential stream - `java.util.stream.LongStream`"
  ([]
    (null/empty )))

(defn map-to-obj
  "Returns an object-valued Stream consisting of the results of
   applying the given function to the elements of this stream.

   This is an
       intermediate operation.

  mapper - a non-interfering, stateless function to apply to each element - `U>`

  returns: the new stream - `<U> java.util.stream.Stream<U>`"
  ([^. this mapper]
    (-> this (.mapToObj mapper))))

(defn find-any
  "Returns an OptionalLong describing some element of the stream, or
   an empty OptionalLong if the stream is empty.

   This is a short-circuiting
   terminal operation.

   The behavior of this operation is explicitly nondeterministic; it is
   free to select any element in the stream.  This is to allow for maximal
   performance in parallel operations; the cost is that multiple invocations
   on the same source may not return the same result.  (If a stable result
   is desired, use findFirst() instead.)

  returns: an OptionalLong describing some element of this stream,
   or an empty OptionalLong if the stream is empty - `java.util.OptionalLong`"
  ([^. this]
    (-> this (.findAny))))

(defn summary-statistics
  "Returns a LongSummaryStatistics describing various summary data
   about the elements of this stream.  This is a special case of a
   reduction.

   This is a terminal
   operation.

  returns: a LongSummaryStatistics describing various summary data
   about the elements of this stream - `java.util.LongSummaryStatistics`"
  ([^. this]
    (-> this (.summaryStatistics))))

(defn collect
  "Performs a mutable
   reduction operation on the elements of this stream.  A mutable
   reduction is one in which the reduced value is a mutable result container,
   such as an ArrayList, and elements are incorporated by updating
   the state of the result rather than by replacing the result.  This
   produces a result equivalent to:


       R result = supplier.get();
       for (long element : this stream)
           accumulator.accept(result, element);
       return result;

   Like reduce(long, LongBinaryOperator), collect operations
   can be parallelized without requiring additional synchronization.

   This is a terminal
   operation.

  supplier - a function that creates a new result container. For a parallel execution, this function may be called multiple times and must return a fresh value each time. - `java.util.function.Supplier<R>`
  accumulator - an associative, non-interfering, stateless function for incorporating an additional element into a result - `java.util.function.ObjLongConsumer<R>`
  combiner - an associative, non-interfering, stateless function for combining two values, which must be compatible with the accumulator function - `java.util.function.BiConsumer<R,R>`

  returns: the result of the reduction - `<R> R`"
  ([^. this ^java.util.function.Supplier supplier ^java.util.function.ObjLongConsumer accumulator ^java.util.function.BiConsumer combiner]
    (-> this (.collect supplier accumulator combiner))))

(defn any-match
  "Returns whether any elements of this stream match the provided
   predicate.  May not evaluate the predicate on all elements if not
   necessary for determining the result.  If the stream is empty then
   false is returned and the predicate is not evaluated.

   This is a short-circuiting
   terminal operation.

  predicate - a non-interfering, stateless predicate to apply to elements of this stream - `java.util.function.LongPredicate`

  returns: true if any elements of the stream match the provided
   predicate, otherwise false - `boolean`"
  ([^. this ^java.util.function.LongPredicate predicate]
    (-> this (.anyMatch predicate))))

(defn none-match
  "Returns whether no elements of this stream match the provided predicate.
   May not evaluate the predicate on all elements if not necessary for
   determining the result.  If the stream is empty then true is
   returned and the predicate is not evaluated.

   This is a short-circuiting
   terminal operation.

  predicate - a non-interfering, stateless predicate to apply to elements of this stream - `java.util.function.LongPredicate`

  returns: true if either no elements of the stream match the
   provided predicate or the stream is empty, otherwise false - `boolean`"
  ([^. this ^java.util.function.LongPredicate predicate]
    (-> this (.noneMatch predicate))))

(defn reduce
  "Performs a reduction on the
   elements of this stream, using the provided identity value and an
   associative
   accumulation function, and returns the reduced value.  This is equivalent
   to:


       long result = identity;
       for (long element : this stream)
           result = accumulator.applyAsLong(result, element)
       return result;

   but is not constrained to execute sequentially.

   The identity value must be an identity for the accumulator
   function. This means that for all x,
   accumulator.apply(identity, x) is equal to x.
   The accumulator function must be an
   associative function.

   This is a terminal
   operation.

  identity - the identity value for the accumulating function - `long`
  op - an associative, non-interfering, stateless function for combining two values - `java.util.function.LongBinaryOperator`

  returns: the result of the reduction - `long`"
  ([^. this ^Long identity ^java.util.function.LongBinaryOperator op]
    (-> this (.reduce identity op)))
  ([^. this ^java.util.function.LongBinaryOperator op]
    (-> this (.reduce op))))

(defn to-array
  "Returns an array containing the elements of this stream.

   This is a terminal
   operation.

  returns: an array containing the elements of this stream - `long[]`"
  ([^. this]
    (-> this (.toArray))))

(defn as-double-stream
  "Returns a DoubleStream consisting of the elements of this stream,
   converted to double.

   This is an intermediate
   operation.

  returns: a DoubleStream consisting of the elements of this stream,
   converted to double - `java.util.stream.DoubleStream`"
  ([^. this]
    (-> this (.asDoubleStream))))

(defn *range-closed
  "Returns a sequential ordered LongStream from startInclusive
   (inclusive) to endInclusive (inclusive) by an incremental step of
   1.

  start-inclusive - the (inclusive) initial value - `long`
  end-inclusive - the inclusive upper bound - `long`

  returns: a sequential LongStream for the range of long
           elements - `java.util.stream.LongStream`"
  ([^Long start-inclusive ^Long end-inclusive]
    (null/rangeClosed start-inclusive end-inclusive)))

