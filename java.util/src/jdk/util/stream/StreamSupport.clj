(ns jdk.util.stream.StreamSupport
  "Low-level utility methods for creating and manipulating streams.

  This class is mostly for library writers presenting stream views
  of data structures; most static stream methods intended for end users are in
  the various Stream classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.stream StreamSupport]))

(defn *stream
  "Creates a new sequential or parallel Stream from a
   Supplier of Spliterator.

   The Supplier.get() method will be invoked on the supplier no
   more than once, and only after the terminal operation of the stream pipeline
   commences.

   For spliterators that report a characteristic of IMMUTABLE
   or CONCURRENT, or that are
   late-binding, it is likely
   more efficient to use stream(java.util.Spliterator, boolean)
   instead.
   The use of a Supplier in this form provides a level of
   indirection that reduces the scope of potential interference with the
   source.  Since the supplier is only invoked after the terminal operation
   commences, any modifications to the source up to the start of the
   terminal operation are reflected in the stream result.  See
   Non-Interference for
   more details.

  supplier - a Supplier of a Spliterator - `java.util.Spliterator<T>>`
  characteristics - Spliterator characteristics of the supplied Spliterator. The characteristics must be equal to supplier.get().characteristics(), otherwise undefined behavior may occur when terminal operation commences. - `int`
  parallel - if true then the returned stream is a parallel stream; if false the returned stream is a sequential stream. - `boolean`

  returns: a new sequential or parallel Stream - `<T> java.util..Stream<T>`"
  ([^java.util.Spliterator> supplier ^Integer characteristics ^Boolean parallel]
    (StreamSupport/stream supplier characteristics parallel))
  ([^java.util.Spliterator spliterator ^Boolean parallel]
    (StreamSupport/stream spliterator parallel)))

(defn *int-stream
  "Creates a new sequential or parallel IntStream from a
   Supplier of Spliterator.OfInt.

   The Supplier.get() method will be invoked on the supplier no
   more than once, and only after the terminal operation of the stream pipeline
   commences.

   For spliterators that report a characteristic of IMMUTABLE
   or CONCURRENT, or that are
   late-binding, it is likely
   more efficient to use intStream(java.util.Spliterator.OfInt, boolean)
   instead.
   The use of a Supplier in this form provides a level of
   indirection that reduces the scope of potential interference with the
   source.  Since the supplier is only invoked after the terminal operation
   commences, any modifications to the source up to the start of the
   terminal operation are reflected in the stream result.  See
   Non-Interference for
   more details.

  supplier - a Supplier of a Spliterator.OfInt - `java.util.Spliterator.OfInt>`
  characteristics - Spliterator characteristics of the supplied Spliterator.OfInt. The characteristics must be equal to supplier.get().characteristics(), otherwise undefined behavior may occur when terminal operation commences. - `int`
  parallel - if true then the returned stream is a parallel stream; if false the returned stream is a sequential stream. - `boolean`

  returns: a new sequential or parallel IntStream - `java.util.stream.IntStream`"
  ([^java.util.Spliterator.OfInt> supplier ^Integer characteristics ^Boolean parallel]
    (StreamSupport/intStream supplier characteristics parallel))
  ([^java.util.Spliterator.OfInt spliterator ^Boolean parallel]
    (StreamSupport/intStream spliterator parallel)))

(defn *long-stream
  "Creates a new sequential or parallel LongStream from a
   Supplier of Spliterator.OfLong.

   The Supplier.get() method will be invoked on the supplier no
   more than once, and only after the terminal operation of the stream pipeline
   commences.

   For spliterators that report a characteristic of IMMUTABLE
   or CONCURRENT, or that are
   late-binding, it is likely
   more efficient to use longStream(java.util.Spliterator.OfLong, boolean)
   instead.
   The use of a Supplier in this form provides a level of
   indirection that reduces the scope of potential interference with the
   source.  Since the supplier is only invoked after the terminal operation
   commences, any modifications to the source up to the start of the
   terminal operation are reflected in the stream result.  See
   Non-Interference for
   more details.

  supplier - a Supplier of a Spliterator.OfLong - `java.util.Spliterator.OfLong>`
  characteristics - Spliterator characteristics of the supplied Spliterator.OfLong. The characteristics must be equal to supplier.get().characteristics(), otherwise undefined behavior may occur when terminal operation commences. - `int`
  parallel - if true then the returned stream is a parallel stream; if false the returned stream is a sequential stream. - `boolean`

  returns: a new sequential or parallel LongStream - `java.util.stream.LongStream`"
  ([^java.util.Spliterator.OfLong> supplier ^Integer characteristics ^Boolean parallel]
    (StreamSupport/longStream supplier characteristics parallel))
  ([^java.util.Spliterator.OfLong spliterator ^Boolean parallel]
    (StreamSupport/longStream spliterator parallel)))

(defn *double-stream
  "Creates a new sequential or parallel DoubleStream from a
   Supplier of Spliterator.OfDouble.

   The Supplier.get() method will be invoked on the supplier no
   more than once, and only after the terminal operation of the stream pipeline
   commences.

   For spliterators that report a characteristic of IMMUTABLE
   or CONCURRENT, or that are
   late-binding, it is likely
   more efficient to use doubleStream(java.util.Spliterator.OfDouble, boolean)
   instead.
   The use of a Supplier in this form provides a level of
   indirection that reduces the scope of potential interference with the
   source.  Since the supplier is only invoked after the terminal operation
   commences, any modifications to the source up to the start of the
   terminal operation are reflected in the stream result.  See
   Non-Interference for
   more details.

  supplier - A Supplier of a Spliterator.OfDouble - `java.util.Spliterator.OfDouble>`
  characteristics - Spliterator characteristics of the supplied Spliterator.OfDouble. The characteristics must be equal to supplier.get().characteristics(), otherwise undefined behavior may occur when terminal operation commences. - `int`
  parallel - if true then the returned stream is a parallel stream; if false the returned stream is a sequential stream. - `boolean`

  returns: a new sequential or parallel DoubleStream - `java.util.stream.DoubleStream`"
  ([^java.util.Spliterator.OfDouble> supplier ^Integer characteristics ^Boolean parallel]
    (StreamSupport/doubleStream supplier characteristics parallel))
  ([^java.util.Spliterator.OfDouble spliterator ^Boolean parallel]
    (StreamSupport/doubleStream spliterator parallel)))

