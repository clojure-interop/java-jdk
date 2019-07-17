(ns jdk.util.concurrent.atomic.AtomicInteger
  "An int value that may be updated atomically.  See the
  java.util.concurrent.atomic package specification for
  description of the properties of atomic variables. An
  AtomicInteger is used in applications such as atomically
  incremented counters, and cannot be used as a replacement for an
  Integer. However, this class does extend
  Number to allow uniform access by tools and utilities that
  deal with numerically-based classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicInteger]))

(defn ->atomic-integer
  "Constructor.

  Creates a new AtomicInteger with the given initial value.

  initial-value - the initial value - `int`"
  ([^Integer initial-value]
    (new AtomicInteger initial-value))
  ([]
    (new AtomicInteger )))

(defn get-and-add
  "Atomically adds the given value to the current value.

  delta - the value to add - `int`

  returns: the previous value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer delta]
    (-> this (.getAndAdd delta))))

(defn get-and-set
  "Atomically sets to the given value and returns the old value.

  new-value - the new value - `int`

  returns: the previous value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer new-value]
    (-> this (.getAndSet new-value))))

(defn update-and-get
  "Atomically updates the current value with the results of
   applying the given function, returning the updated value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  update-function - a side-effect-free function - `java.util.function.IntUnaryOperator`

  returns: the updated value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^java.util.function.IntUnaryOperator update-function]
    (-> this (.updateAndGet update-function))))

(defn double-value
  "Returns the value of this AtomicInteger as a double
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.doubleValue))))

(defn add-and-get
  "Atomically adds the given value to the current value.

  delta - the value to add - `int`

  returns: the updated value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer delta]
    (-> this (.addAndGet delta))))

(defn long-value
  "Returns the value of this AtomicInteger as a long
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.longValue))))

(defn get-and-update
  "Atomically updates the current value with the results of
   applying the given function, returning the previous value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  update-function - a side-effect-free function - `java.util.function.IntUnaryOperator`

  returns: the previous value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^java.util.function.IntUnaryOperator update-function]
    (-> this (.getAndUpdate update-function))))

(defn to-string
  "Returns the String representation of the current value.

  returns: the String representation of the current value - `java.lang.String`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.toString))))

(defn float-value
  "Returns the value of this AtomicInteger as a float
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.floatValue))))

(defn accumulate-and-get
  "Atomically updates the current value with the results of
   applying the given function to the current and given values,
   returning the updated value. The function should be
   side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function
   is applied with the current value as its first argument,
   and the given update as the second argument.

  x - the update value - `int`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.IntBinaryOperator`

  returns: the updated value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer x ^java.util.function.IntBinaryOperator accumulator-function]
    (-> this (.accumulateAndGet x accumulator-function))))

(defn get-and-decrement
  "Atomically decrements by one the current value.

  returns: the previous value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.getAndDecrement))))

(defn decrement-and-get
  "Atomically decrements by one the current value.

  returns: the updated value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.decrementAndGet))))

(defn weak-compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  expect - the expected value - `int`
  update - the new value - `int`

  returns: true if successful - `boolean`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer expect ^Integer update]
    (-> this (.weakCompareAndSet expect update))))

(defn int-value
  "Returns the value of this AtomicInteger as an int.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.intValue))))

(defn get-and-increment
  "Atomically increments by one the current value.

  returns: the previous value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.getAndIncrement))))

(defn lazy-set
  "Eventually sets to the given value.

  new-value - the new value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer new-value]
    (-> this (.lazySet new-value))))

(defn set
  "Sets to the given value.

  new-value - the new value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer new-value]
    (-> this (.set new-value))))

(defn get-and-accumulate
  "Atomically updates the current value with the results of
   applying the given function to the current and given values,
   returning the previous value. The function should be
   side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function
   is applied with the current value as its first argument,
   and the given update as the second argument.

  x - the update value - `int`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.IntBinaryOperator`

  returns: the previous value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer x ^java.util.function.IntBinaryOperator accumulator-function]
    (-> this (.getAndAccumulate x accumulator-function))))

(defn compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

  expect - the expected value - `int`
  update - the new value - `int`

  returns: true if successful. False return indicates that
   the actual value was not equal to the expected value. - `boolean`"
  ([^java.util.concurrent.atomic.AtomicInteger this ^Integer expect ^Integer update]
    (-> this (.compareAndSet expect update))))

(defn get
  "Gets the current value.

  returns: the current value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.get))))

(defn increment-and-get
  "Atomically increments by one the current value.

  returns: the updated value - `int`"
  ([^java.util.concurrent.atomic.AtomicInteger this]
    (-> this (.incrementAndGet))))

