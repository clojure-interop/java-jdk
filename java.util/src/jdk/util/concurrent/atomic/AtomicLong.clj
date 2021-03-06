(ns jdk.util.concurrent.atomic.AtomicLong
  "A long value that may be updated atomically.  See the
  java.util.concurrent.atomic package specification for
  description of the properties of atomic variables. An
  AtomicLong is used in applications such as atomically
  incremented sequence numbers, and cannot be used as a replacement
  for a Long. However, this class does extend
  Number to allow uniform access by tools and utilities that
  deal with numerically-based classes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicLong]))

(defn ->atomic-long
  "Constructor.

  Creates a new AtomicLong with the given initial value.

  initial-value - the initial value - `long`"
  (^AtomicLong [^Long initial-value]
    (new AtomicLong initial-value))
  (^AtomicLong []
    (new AtomicLong )))

(defn get-and-add
  "Atomically adds the given value to the current value.

  delta - the value to add - `long`

  returns: the previous value - `long`"
  (^Long [^AtomicLong this ^Long delta]
    (-> this (.getAndAdd delta))))

(defn get-and-set
  "Atomically sets to the given value and returns the old value.

  new-value - the new value - `long`

  returns: the previous value - `long`"
  (^Long [^AtomicLong this ^Long new-value]
    (-> this (.getAndSet new-value))))

(defn update-and-get
  "Atomically updates the current value with the results of
   applying the given function, returning the updated value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  update-function - a side-effect-free function - `java.util.function.LongUnaryOperator`

  returns: the updated value - `long`"
  (^Long [^AtomicLong this ^java.util.function.LongUnaryOperator update-function]
    (-> this (.updateAndGet update-function))))

(defn double-value
  "Returns the value of this AtomicLong as a double
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  (^Double [^AtomicLong this]
    (-> this (.doubleValue))))

(defn add-and-get
  "Atomically adds the given value to the current value.

  delta - the value to add - `long`

  returns: the updated value - `long`"
  (^Long [^AtomicLong this ^Long delta]
    (-> this (.addAndGet delta))))

(defn long-value
  "Returns the value of this AtomicLong as a long.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  (^Long [^AtomicLong this]
    (-> this (.longValue))))

(defn get-and-update
  "Atomically updates the current value with the results of
   applying the given function, returning the previous value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  update-function - a side-effect-free function - `java.util.function.LongUnaryOperator`

  returns: the previous value - `long`"
  (^Long [^AtomicLong this ^java.util.function.LongUnaryOperator update-function]
    (-> this (.getAndUpdate update-function))))

(defn to-string
  "Returns the String representation of the current value.

  returns: the String representation of the current value - `java.lang.String`"
  (^java.lang.String [^AtomicLong this]
    (-> this (.toString))))

(defn float-value
  "Returns the value of this AtomicLong as a float
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  (^Float [^AtomicLong this]
    (-> this (.floatValue))))

(defn accumulate-and-get
  "Atomically updates the current value with the results of
   applying the given function to the current and given values,
   returning the updated value. The function should be
   side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function
   is applied with the current value as its first argument,
   and the given update as the second argument.

  x - the update value - `long`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.LongBinaryOperator`

  returns: the updated value - `long`"
  (^Long [^AtomicLong this ^Long x ^java.util.function.LongBinaryOperator accumulator-function]
    (-> this (.accumulateAndGet x accumulator-function))))

(defn get-and-decrement
  "Atomically decrements by one the current value.

  returns: the previous value - `long`"
  (^Long [^AtomicLong this]
    (-> this (.getAndDecrement))))

(defn decrement-and-get
  "Atomically decrements by one the current value.

  returns: the updated value - `long`"
  (^Long [^AtomicLong this]
    (-> this (.decrementAndGet))))

(defn weak-compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  expect - the expected value - `long`
  update - the new value - `long`

  returns: true if successful - `boolean`"
  (^Boolean [^AtomicLong this ^Long expect ^Long update]
    (-> this (.weakCompareAndSet expect update))))

(defn int-value
  "Returns the value of this AtomicLong as an int
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  (^Integer [^AtomicLong this]
    (-> this (.intValue))))

(defn get-and-increment
  "Atomically increments by one the current value.

  returns: the previous value - `long`"
  (^Long [^AtomicLong this]
    (-> this (.getAndIncrement))))

(defn lazy-set
  "Eventually sets to the given value.

  new-value - the new value - `long`"
  ([^AtomicLong this ^Long new-value]
    (-> this (.lazySet new-value))))

(defn set
  "Sets to the given value.

  new-value - the new value - `long`"
  ([^AtomicLong this ^Long new-value]
    (-> this (.set new-value))))

(defn get-and-accumulate
  "Atomically updates the current value with the results of
   applying the given function to the current and given values,
   returning the previous value. The function should be
   side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function
   is applied with the current value as its first argument,
   and the given update as the second argument.

  x - the update value - `long`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.LongBinaryOperator`

  returns: the previous value - `long`"
  (^Long [^AtomicLong this ^Long x ^java.util.function.LongBinaryOperator accumulator-function]
    (-> this (.getAndAccumulate x accumulator-function))))

(defn compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

  expect - the expected value - `long`
  update - the new value - `long`

  returns: true if successful. False return indicates that
   the actual value was not equal to the expected value. - `boolean`"
  (^Boolean [^AtomicLong this ^Long expect ^Long update]
    (-> this (.compareAndSet expect update))))

(defn get
  "Gets the current value.

  returns: the current value - `long`"
  (^Long [^AtomicLong this]
    (-> this (.get))))

(defn increment-and-get
  "Atomically increments by one the current value.

  returns: the updated value - `long`"
  (^Long [^AtomicLong this]
    (-> this (.incrementAndGet))))

