(ns jdk.util.concurrent.ThreadLocalRandom
  "A random number generator isolated to the current thread.  Like the
  global Random generator used by the Math class, a ThreadLocalRandom is initialized
  with an internally generated seed that may not otherwise be
  modified. When applicable, use of ThreadLocalRandom rather
  than shared Random objects in concurrent programs will
  typically encounter much less overhead and contention.  Use of
  ThreadLocalRandom is particularly appropriate when multiple
  tasks (for example, each a ForkJoinTask) use random numbers
  in parallel in thread pools.

  Usages of this class should typically be of the form:
  ThreadLocalRandom.current().nextX(...) (where
  X is Int, Long, etc).
  When all usages are of this form, it is never possible to
  accidently share a ThreadLocalRandom across multiple threads.

  This class also provides additional commonly used bounded random
  generation methods.

  Instances of ThreadLocalRandom are not cryptographically
  secure.  Consider instead using SecureRandom
  in security-sensitive applications. Additionally,
  default-constructed instances do not use a cryptographically random
  seed unless the system property
  java.util.secureRandomSeed is set to true."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent ThreadLocalRandom]))

(defn *current
  "Returns the current thread's ThreadLocalRandom.

  returns: the current thread's ThreadLocalRandom - `java.util.con.ThreadLocalRandom`"
  (^java.util.con.ThreadLocalRandom []
    (ThreadLocalRandom/current )))

(defn longs
  "Returns a stream producing the given streamSize number of
   pseudorandom long, each conforming to the given origin
   (inclusive) and bound (exclusive).

  stream-size - the number of values to generate - `long`
  random-number-origin - the origin (inclusive) of each random value - `long`
  random-number-bound - the bound (exclusive) of each random value - `long`

  returns: a stream of pseudorandom long values,
           each with the given origin (inclusive) and bound (exclusive) - `java.util.stream.LongStream`

  throws: java.lang.IllegalArgumentException - if streamSize is less than zero, or randomNumberOrigin is greater than or equal to randomNumberBound"
  (^java.util.stream.LongStream [^java.util.concurrent.ThreadLocalRandom this ^Long stream-size ^Long random-number-origin ^Long random-number-bound]
    (-> this (.longs stream-size random-number-origin random-number-bound)))
  (^java.util.stream.LongStream [^java.util.concurrent.ThreadLocalRandom this ^Long random-number-origin ^Long random-number-bound]
    (-> this (.longs random-number-origin random-number-bound)))
  (^java.util.stream.LongStream [^java.util.concurrent.ThreadLocalRandom this ^Long stream-size]
    (-> this (.longs stream-size)))
  (^java.util.stream.LongStream [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.longs))))

(defn set-seed
  "Throws UnsupportedOperationException.  Setting seeds in
   this generator is not supported.

  seed - the initial seed - `long`

  throws: java.lang.UnsupportedOperationException - always"
  ([^java.util.concurrent.ThreadLocalRandom this ^Long seed]
    (-> this (.setSeed seed))))

(defn next-float
  "Returns a pseudorandom float value between zero
   (inclusive) and one (exclusive).

  returns: a pseudorandom float value between zero
           (inclusive) and one (exclusive) - `float`"
  (^Float [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.nextFloat))))

(defn next-int
  "Returns a pseudorandom int value between the specified
   origin (inclusive) and the specified bound (exclusive).

  origin - the least value returned - `int`
  bound - the upper bound (exclusive) - `int`

  returns: a pseudorandom int value between the origin
           (inclusive) and the bound (exclusive) - `int`

  throws: java.lang.IllegalArgumentException - if origin is greater than or equal to bound"
  (^Integer [^java.util.concurrent.ThreadLocalRandom this ^Integer origin ^Integer bound]
    (-> this (.nextInt origin bound)))
  (^Integer [^java.util.concurrent.ThreadLocalRandom this ^Integer bound]
    (-> this (.nextInt bound)))
  (^Integer [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.nextInt))))

(defn next-long
  "Returns a pseudorandom long value between the specified
   origin (inclusive) and the specified bound (exclusive).

  origin - the least value returned - `long`
  bound - the upper bound (exclusive) - `long`

  returns: a pseudorandom long value between the origin
           (inclusive) and the bound (exclusive) - `long`

  throws: java.lang.IllegalArgumentException - if origin is greater than or equal to bound"
  (^Long [^java.util.concurrent.ThreadLocalRandom this ^Long origin ^Long bound]
    (-> this (.nextLong origin bound)))
  (^Long [^java.util.concurrent.ThreadLocalRandom this ^Long bound]
    (-> this (.nextLong bound)))
  (^Long [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.nextLong))))

(defn doubles
  "Returns a stream producing the given streamSize number of
   pseudorandom double values, each conforming to the given origin
   (inclusive) and bound (exclusive).

  stream-size - the number of values to generate - `long`
  random-number-origin - the origin (inclusive) of each random value - `double`
  random-number-bound - the bound (exclusive) of each random value - `double`

  returns: a stream of pseudorandom double values,
           each with the given origin (inclusive) and bound (exclusive) - `java.util.stream.DoubleStream`

  throws: java.lang.IllegalArgumentException - if randomNumberOrigin is greater than or equal to randomNumberBound"
  (^java.util.stream.DoubleStream [^java.util.concurrent.ThreadLocalRandom this ^Long stream-size ^Double random-number-origin ^Double random-number-bound]
    (-> this (.doubles stream-size random-number-origin random-number-bound)))
  (^java.util.stream.DoubleStream [^java.util.concurrent.ThreadLocalRandom this ^Double random-number-origin ^Double random-number-bound]
    (-> this (.doubles random-number-origin random-number-bound)))
  (^java.util.stream.DoubleStream [^java.util.concurrent.ThreadLocalRandom this ^Long stream-size]
    (-> this (.doubles stream-size)))
  (^java.util.stream.DoubleStream [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.doubles))))

(defn ints
  "Returns a stream producing the given streamSize number
   of pseudorandom int values, each conforming to the given
   origin (inclusive) and bound (exclusive).

  stream-size - the number of values to generate - `long`
  random-number-origin - the origin (inclusive) of each random value - `int`
  random-number-bound - the bound (exclusive) of each random value - `int`

  returns: a stream of pseudorandom int values,
           each with the given origin (inclusive) and bound (exclusive) - `java.util.stream.IntStream`

  throws: java.lang.IllegalArgumentException - if streamSize is less than zero, or randomNumberOrigin is greater than or equal to randomNumberBound"
  (^java.util.stream.IntStream [^java.util.concurrent.ThreadLocalRandom this ^Long stream-size ^Integer random-number-origin ^Integer random-number-bound]
    (-> this (.ints stream-size random-number-origin random-number-bound)))
  (^java.util.stream.IntStream [^java.util.concurrent.ThreadLocalRandom this ^Integer random-number-origin ^Integer random-number-bound]
    (-> this (.ints random-number-origin random-number-bound)))
  (^java.util.stream.IntStream [^java.util.concurrent.ThreadLocalRandom this ^Long stream-size]
    (-> this (.ints stream-size)))
  (^java.util.stream.IntStream [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.ints))))

(defn next-gaussian
  "Description copied from class: Random

  returns: the next pseudorandom, Gaussian (`normally`) distributed
           double value with mean 0.0 and
           standard deviation 1.0 from this random number
           generator's sequence - `double`"
  (^Double [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.nextGaussian))))

(defn next-double
  "Returns a pseudorandom double value between the specified
   origin (inclusive) and bound (exclusive).

  origin - the least value returned - `double`
  bound - the upper bound (exclusive) - `double`

  returns: a pseudorandom double value between the origin
           (inclusive) and the bound (exclusive) - `double`

  throws: java.lang.IllegalArgumentException - if origin is greater than or equal to bound"
  (^Double [^java.util.concurrent.ThreadLocalRandom this ^Double origin ^Double bound]
    (-> this (.nextDouble origin bound)))
  (^Double [^java.util.concurrent.ThreadLocalRandom this ^Double bound]
    (-> this (.nextDouble bound)))
  (^Double [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.nextDouble))))

(defn next-boolean
  "Returns a pseudorandom boolean value.

  returns: a pseudorandom boolean value - `boolean`"
  (^Boolean [^java.util.concurrent.ThreadLocalRandom this]
    (-> this (.nextBoolean))))

