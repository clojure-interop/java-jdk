(ns jdk.util.stream.Stream
  "A sequence of elements supporting sequential and parallel aggregate
  operations.  The following example illustrates an aggregate operation using
  Stream and IntStream:



      int sum = widgets.stream()
                       .filter(w -> w.getColor() == RED)
                       .mapToInt(w -> w.getWeight())
                       .sum();

  In this example, widgets is a Collection<Widget>.  We create
  a stream of Widget objects via Collection.stream(),
  filter it to produce a stream containing only the red widgets, and then
  transform it into a stream of int values representing the weight of
  each red widget. Then this stream is summed to produce a total weight.

  In addition to Stream, which is a stream of object references,
  there are primitive specializations for IntStream, LongStream,
  and DoubleStream, all of which are referred to as `streams` and
  conform to the characteristics and restrictions described here.

  To perform a computation, stream
  operations are composed into a
  stream pipeline.  A stream pipeline consists of a source (which
  might be an array, a collection, a generator function, an I/O channel,
  etc), zero or more intermediate operations (which transform a
  stream into another stream, such as filter(Predicate)), and a
  terminal operation (which produces a result or side-effect, such
  as count() or forEach(Consumer)).
  Streams are lazy; computation on the source data is only performed when the
  terminal operation is initiated, and source elements are consumed only
  as needed.

  Collections and streams, while bearing some superficial similarities,
  have different goals.  Collections are primarily concerned with the efficient
  management of, and access to, their elements.  By contrast, streams do not
  provide a means to directly access or manipulate their elements, and are
  instead concerned with declaratively describing their source and the
  computational operations which will be performed in aggregate on that source.
  However, if the provided stream operations do not offer the desired
  functionality, the BaseStream.iterator() and BaseStream.spliterator() operations
  can be used to perform a controlled traversal.

  A stream pipeline, like the `widgets` example above, can be viewed as
  a query on the stream source.  Unless the source was explicitly
  designed for concurrent modification (such as a ConcurrentHashMap),
  unpredictable or erroneous behavior may result from modifying the stream
  source while it is being queried.

  Most stream operations accept parameters that describe user-specified
  behavior, such as the lambda expression w -> w.getWeight() passed to
  mapToInt in the example above.  To preserve correct behavior,
  these behavioral parameters:

  must be non-interfering
  (they do not modify the stream source); and
  in most cases must be stateless
  (their result should not depend on any state that might change during execution
  of the stream pipeline).


  Such parameters are always instances of a
  functional interface such
  as Function, and are often lambda expressions or
  method references.  Unless otherwise specified these parameters must be
  non-null.

  A stream should be operated on (invoking an intermediate or terminal stream
  operation) only once.  This rules out, for example, `forked` streams, where
  the same source feeds two or more pipelines, or multiple traversals of the
  same stream.  A stream implementation may throw IllegalStateException
  if it detects that the stream is being reused. However, since some stream
  operations may return their receiver rather than a new stream object, it may
  not be possible to detect reuse in all cases.

  Streams have a BaseStream.close() method and implement AutoCloseable,
  but nearly all stream instances do not actually need to be closed after use.
  Generally, only streams whose source is an IO channel (such as those returned
  by Files.lines(Path, Charset)) will require closing.  Most streams
  are backed by collections, arrays, or generating functions, which require no
  special resource management.  (If a stream does require closing, it can be
  declared as a resource in a try-with-resources statement.)

  Stream pipelines may execute either sequentially or in
  parallel.  This
  execution mode is a property of the stream.  Streams are created
  with an initial choice of sequential or parallel execution.  (For example,
  Collection.stream() creates a sequential stream,
  and Collection.parallelStream() creates
  a parallel one.)  This choice of execution mode may be modified by the
  BaseStream.sequential() or BaseStream.parallel() methods, and may be queried with
  the BaseStream.isParallel() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream Stream]))

(defn skip
  "Returns a stream consisting of the remaining elements of this stream
   after discarding the first n elements of the stream.
   If this stream contains fewer than n elements then an
   empty stream will be returned.

   This is a stateful
   intermediate operation.

  n - the number of leading elements to skip - `long`

  returns: the new stream - `java.util.stream.Stream<Stream.T>`

  throws: java.lang.IllegalArgumentException - if n is negative"
  ([^. this ^Long n]
    (-> this (.skip n))))

(defn map
  "Returns a stream consisting of the results of applying the given
   function to the elements of this stream.

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element - `R>`

  returns: the new stream - `<R> java.util.stream.Stream<R>`"
  ([^. this mapper]
    (-> this (.map mapper))))

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

  action - a non-interfering action to perform on the elements as they are consumed from the stream - `Stream.T>`

  returns: the new stream - `java.util.stream.Stream<Stream.T>`"
  ([^. this ^Stream.T> action]
    (-> this (.peek action))))

(defn flat-map-to-int
  "Returns an IntStream consisting of the results of replacing each
   element of this stream with the contents of a mapped stream produced by
   applying the provided mapping function to each element.  Each mapped
   stream is closed after its
   contents have been placed into this stream.  (If a mapped stream is
   null an empty stream is used, instead.)

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element which produces a stream of new values - `java.util.stream.IntStream>`

  returns: the new stream - `java.util.stream.IntStream`"
  ([^. this ^java.util.stream.IntStream> mapper]
    (-> this (.flatMapToInt mapper))))

(defn min
  "Returns the minimum element of this stream according to the provided
   Comparator.  This is a special case of a
   reduction.

   This is a terminal operation.

  comparator - a non-interfering, stateless Comparator to compare elements of this stream - `Stream.T>`

  returns: an Optional describing the minimum element of this stream,
   or an empty Optional if the stream is empty - `java.util.Optional<Stream.T>`

  throws: java.lang.NullPointerException - if the minimum element is null"
  ([^. this ^Stream.T> comparator]
    (-> this (.min comparator))))

(defn for-each
  "Performs an action for each element of this stream.

   This is a terminal
   operation.

   The behavior of this operation is explicitly nondeterministic.
   For parallel stream pipelines, this operation does not
   guarantee to respect the encounter order of the stream, as doing so
   would sacrifice the benefit of parallelism.  For any given element, the
   action may be performed at whatever time and in whatever thread the
   library chooses.  If the action accesses shared state, it is
   responsible for providing the required synchronization.

  action - a non-interfering action to perform on the elements - `Stream.T>`"
  ([^. this ^Stream.T> action]
    (-> this (.forEach action))))

(defn for-each-ordered
  "Performs an action for each element of this stream, in the encounter
   order of the stream if the stream has a defined encounter order.

   This is a terminal
   operation.

   This operation processes the elements one at a time, in encounter
   order if one exists.  Performing the action for one element
   happens-before
   performing the action for subsequent elements, but for any given element,
   the action may be performed in whatever thread the library chooses.

  action - a non-interfering action to perform on the elements - `Stream.T>`"
  ([^. this ^Stream.T> action]
    (-> this (.forEachOrdered action))))

(defn *of
  "Returns a sequential Stream containing a single element.

  t - the single element - `T`

  returns: a singleton sequential stream - `<T> java.util.stream.Stream<T>`"
  ([t]
    (null/of t)))

(defn find-first
  "Returns an Optional describing the first element of this stream,
   or an empty Optional if the stream is empty.  If the stream has
   no encounter order, then any element may be returned.

   This is a short-circuiting
   terminal operation.

  returns: an Optional describing the first element of this stream,
   or an empty Optional if the stream is empty - `java.util.Optional<Stream.T>`

  throws: java.lang.NullPointerException - if the element selected is null"
  ([^. this]
    (-> this (.findFirst))))

(defn all-match
  "Returns whether all elements of this stream match the provided predicate.
   May not evaluate the predicate on all elements if not necessary for
   determining the result.  If the stream is empty then true is
   returned and the predicate is not evaluated.

   This is a short-circuiting
   terminal operation.

  predicate - a non-interfering, stateless predicate to apply to elements of this stream - `Stream.T>`

  returns: true if either all elements of the stream match the
   provided predicate or the stream is empty, otherwise false - `boolean`"
  ([^. this ^Stream.T> predicate]
    (-> this (.allMatch predicate))))

(defn flat-map-to-long
  "Returns an LongStream consisting of the results of replacing each
   element of this stream with the contents of a mapped stream produced by
   applying the provided mapping function to each element.  Each mapped
   stream is closed after its
   contents have been placed into this stream.  (If a mapped stream is
   null an empty stream is used, instead.)

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element which produces a stream of new values - `java.util.stream.LongStream>`

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this ^java.util.stream.LongStream> mapper]
    (-> this (.flatMapToLong mapper))))

(defn sorted
  "Returns a stream consisting of the elements of this stream, sorted
   according to the provided Comparator.

   For ordered streams, the sort is stable.  For unordered streams, no
   stability guarantees are made.

   This is a stateful
   intermediate operation.

  comparator - a non-interfering, stateless Comparator to be used to compare stream elements - `Stream.T>`

  returns: the new stream - `java.util.stream.Stream<Stream.T>`"
  ([^. this ^Stream.T> comparator]
    (-> this (.sorted comparator)))
  ([^. this]
    (-> this (.sorted))))

(defn map-to-long
  "Returns a LongStream consisting of the results of applying the
   given function to the elements of this stream.

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element - `Stream.T>`

  returns: the new stream - `java.util.stream.LongStream`"
  ([^. this ^Stream.T> mapper]
    (-> this (.mapToLong mapper))))

(defn *iterate
  "Returns an infinite sequential ordered Stream produced by iterative
   application of a function f to an initial element seed,
   producing a Stream consisting of seed, f(seed),
   f(f(seed)), etc.

   The first element (position 0) in the Stream will be
   the provided seed.  For n > 0, the element at position
   n, will be the result of applying the function f to the
   element at position n - 1.

  seed - the initial element - `T`
  f - a function to be applied to to the previous element to produce a new element - `java.util.function.UnaryOperator<T>`

  returns: a new sequential Stream - `<T> java.util.stream.Stream<T>`"
  ([seed ^java.util.function.UnaryOperator f]
    (null/iterate seed f)))

(defn max
  "Returns the maximum element of this stream according to the provided
   Comparator.  This is a special case of a
   reduction.

   This is a terminal
   operation.

  comparator - a non-interfering, stateless Comparator to compare elements of this stream - `Stream.T>`

  returns: an Optional describing the maximum element of this stream,
   or an empty Optional if the stream is empty - `java.util.Optional<Stream.T>`

  throws: java.lang.NullPointerException - if the maximum element is null"
  ([^. this ^Stream.T> comparator]
    (-> this (.max comparator))))

(defn *generate
  "Returns an infinite sequential unordered stream where each element is
   generated by the provided Supplier.  This is suitable for
   generating constant streams, streams of random elements, etc.

  s - the Supplier of generated elements - `java.util.function.Supplier<T>`

  returns: a new infinite sequential unordered Stream - `<T> java.util.stream.Stream<T>`"
  ([^java.util.function.Supplier s]
    (null/generate s)))

(defn *builder
  "Returns a builder for a Stream.

  returns: a stream builder - `<T> java.util.stream.Stream.Builder<T>`"
  ([]
    (null/builder )))

(defn count
  "Returns the count of elements in this stream.  This is a special case of
   a reduction and is
   equivalent to:


       return mapToLong(e -> 1L).sum();

   This is a terminal operation.

  returns: the count of elements in this stream - `long`"
  ([^. this]
    (-> this (.count))))

(defn map-to-double
  "Returns a DoubleStream consisting of the results of applying the
   given function to the elements of this stream.

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element - `Stream.T>`

  returns: the new stream - `java.util.stream.DoubleStream`"
  ([^. this ^Stream.T> mapper]
    (-> this (.mapToDouble mapper))))

(defn map-to-int
  "Returns an IntStream consisting of the results of applying the
   given function to the elements of this stream.

   This is an
       intermediate operation.

  mapper - a non-interfering, stateless function to apply to each element - `Stream.T>`

  returns: the new stream - `java.util.stream.IntStream`"
  ([^. this ^Stream.T> mapper]
    (-> this (.mapToInt mapper))))

(defn distinct
  "Returns a stream consisting of the distinct elements (according to
   Object.equals(Object)) of this stream.

   For ordered streams, the selection of distinct elements is stable
   (for duplicated elements, the element appearing first in the encounter
   order is preserved.)  For unordered streams, no stability guarantees
   are made.

   This is a stateful
   intermediate operation.

  returns: the new stream - `java.util.stream.Stream<Stream.T>`"
  ([^. this]
    (-> this (.distinct))))

(defn limit
  "Returns a stream consisting of the elements of this stream, truncated
   to be no longer than maxSize in length.

   This is a short-circuiting
   stateful intermediate operation.

  max-size - the number of elements the stream should be limited to - `long`

  returns: the new stream - `java.util.stream.Stream<Stream.T>`

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

  mapper - a non-interfering, stateless function to apply to each element which produces a stream of new values - `R>>`

  returns: the new stream - `<R> java.util.stream.Stream<R>`"
  ([^. this mapper]
    (-> this (.flatMap mapper))))

(defn flat-map-to-double
  "Returns an DoubleStream consisting of the results of replacing
   each element of this stream with the contents of a mapped stream produced
   by applying the provided mapping function to each element.  Each mapped
   stream is closed after its
   contents have placed been into this stream.  (If a mapped stream is
   null an empty stream is used, instead.)

   This is an intermediate
   operation.

  mapper - a non-interfering, stateless function to apply to each element which produces a stream of new values - `java.util.stream.DoubleStream>`

  returns: the new stream - `java.util.stream.DoubleStream`"
  ([^. this ^java.util.stream.DoubleStream> mapper]
    (-> this (.flatMapToDouble mapper))))

(defn *concat
  "Creates a lazily concatenated stream whose elements are all the
   elements of the first stream followed by all the elements of the
   second stream.  The resulting stream is ordered if both
   of the input streams are ordered, and parallel if either of the input
   streams is parallel.  When the resulting stream is closed, the close
   handlers for both input streams are invoked.

  a - the first stream - `T>`
  b - the second stream - `T>`

  returns: the concatenation of the two input streams - `<T> java.util.stream.Stream<T>`"
  ([a b]
    (null/concat a b)))

(defn filter
  "Returns a stream consisting of the elements of this stream that match
   the given predicate.

   This is an intermediate
   operation.

  predicate - a non-interfering, stateless predicate to apply to each element to determine if it should be included - `Stream.T>`

  returns: the new stream - `java.util.stream.Stream<Stream.T>`"
  ([^. this ^Stream.T> predicate]
    (-> this (.filter predicate))))

(defn *empty
  "Returns an empty sequential Stream.

  returns: an empty sequential stream - `<T> java.util.stream.Stream<T>`"
  ([]
    (null/empty )))

(defn find-any
  "Returns an Optional describing some element of the stream, or an
   empty Optional if the stream is empty.

   This is a short-circuiting
   terminal operation.

   The behavior of this operation is explicitly nondeterministic; it is
   free to select any element in the stream.  This is to allow for maximal
   performance in parallel operations; the cost is that multiple invocations
   on the same source may not return the same result.  (If a stable result
   is desired, use findFirst() instead.)

  returns: an Optional describing some element of this stream, or an
   empty Optional if the stream is empty - `java.util.Optional<Stream.T>`

  throws: java.lang.NullPointerException - if the element selected is null"
  ([^. this]
    (-> this (.findAny))))

(defn collect
  "Performs a mutable
   reduction operation on the elements of this stream.  A mutable
   reduction is one in which the reduced value is a mutable result container,
   such as an ArrayList, and elements are incorporated by updating
   the state of the result rather than by replacing the result.  This
   produces a result equivalent to:


       R result = supplier.get();
       for (T element : this stream)
           accumulator.accept(result, element);
       return result;

   Like reduce(Object, BinaryOperator), collect operations
   can be parallelized without requiring additional synchronization.

   This is a terminal
   operation.

  supplier - a function that creates a new result container. For a parallel execution, this function may be called multiple times and must return a fresh value each time. - `java.util.function.Supplier<R>`
  accumulator - an associative, non-interfering, stateless function for incorporating an additional element into a result - `Stream.T>`
  combiner - an associative, non-interfering, stateless function for combining two values, which must be compatible with the accumulator function - `java.util.function.BiConsumer<R,R>`

  returns: the result of the reduction - `<R> R`"
  ([^. this ^java.util.function.Supplier supplier ^Stream.T> accumulator ^java.util.function.BiConsumer combiner]
    (-> this (.collect supplier accumulator combiner)))
  ([^. this ^Stream.T,A,R> collector]
    (-> this (.collect collector))))

(defn any-match
  "Returns whether any elements of this stream match the provided
   predicate.  May not evaluate the predicate on all elements if not
   necessary for determining the result.  If the stream is empty then
   false is returned and the predicate is not evaluated.

   This is a short-circuiting
   terminal operation.

  predicate - a non-interfering, stateless predicate to apply to elements of this stream - `Stream.T>`

  returns: true if any elements of the stream match the provided
   predicate, otherwise false - `boolean`"
  ([^. this ^Stream.T> predicate]
    (-> this (.anyMatch predicate))))

(defn none-match
  "Returns whether no elements of this stream match the provided predicate.
   May not evaluate the predicate on all elements if not necessary for
   determining the result.  If the stream is empty then true is
   returned and the predicate is not evaluated.

   This is a short-circuiting
   terminal operation.

  predicate - a non-interfering, stateless predicate to apply to elements of this stream - `Stream.T>`

  returns: true if either no elements of the stream match the
   provided predicate or the stream is empty, otherwise false - `boolean`"
  ([^. this ^Stream.T> predicate]
    (-> this (.noneMatch predicate))))

(defn reduce
  "Performs a reduction on the
   elements of this stream, using the provided identity, accumulation and
   combining functions.  This is equivalent to:


       U result = identity;
       for (T element : this stream)
           result = accumulator.apply(result, element)
       return result;

   but is not constrained to execute sequentially.

   The identity value must be an identity for the combiner
   function.  This means that for all u, combiner(identity, u)
   is equal to u.  Additionally, the combiner function
   must be compatible with the accumulator function; for all
   u and t, the following must hold:


       combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)

   This is a terminal
   operation.

  identity - the identity value for the combiner function - `U`
  accumulator - an associative, non-interfering, stateless function for incorporating an additional element into a result - `Stream.T,U>`
  combiner - an associative, non-interfering, stateless function for combining two values, which must be compatible with the accumulator function - `java.util.function.BinaryOperator<U>`

  returns: the result of the reduction - `<U> U`"
  ([^. this identity ^Stream.T,U> accumulator ^java.util.function.BinaryOperator combiner]
    (-> this (.reduce identity accumulator combiner)))
  ([^. this ^Stream.T identity ^java.util.function.BinaryOperator accumulator]
    (-> this (.reduce identity accumulator)))
  ([^. this ^java.util.function.BinaryOperator accumulator]
    (-> this (.reduce accumulator))))

(defn to-array
  "Returns an array containing the elements of this stream, using the
   provided generator function to allocate the returned array, as
   well as any additional arrays that might be required for a partitioned
   execution or for resizing.

   This is a terminal
   operation.

  generator - a function which produces a new array of the desired type and the provided length - `java.util.function.IntFunction<A[]>`

  returns: an array containing the elements in this stream - `<A> A[]`

  throws: java.lang.ArrayStoreException - if the runtime type of the array returned from the array generator is not a supertype of the runtime type of every element in this stream"
  ([^. this ^java.util.function.IntFunction generator]
    (-> this (.toArray generator)))
  ([^. this]
    (-> this (.toArray))))

