(ns jdk.util.concurrent.atomic.AtomicLongArray
  "A long array in which elements may be updated atomically.
  See the java.util.concurrent.atomic package specification
  for description of the properties of atomic variables."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicLongArray]))

(defn ->atomic-long-array
  "Constructor.

  Creates a new AtomicLongArray of the given length, with all
   elements initially zero.

  length - the length of the array - `int`"
  (^AtomicLongArray [^Integer length]
    (new AtomicLongArray length)))

(defn get-and-add
  "Atomically adds the given value to the element at index i.

  i - the index - `int`
  delta - the value to add - `long`

  returns: the previous value - `long`"
  (^Long [^AtomicLongArray this ^Integer i ^Long delta]
    (-> this (.getAndAdd i delta))))

(defn get-and-set
  "Atomically sets the element at position i to the given value
   and returns the old value.

  i - the index - `int`
  new-value - the new value - `long`

  returns: the previous value - `long`"
  (^Long [^AtomicLongArray this ^Integer i ^Long new-value]
    (-> this (.getAndSet i new-value))))

(defn update-and-get
  "Atomically updates the element at index i with the results
   of applying the given function, returning the updated value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  i - the index - `int`
  update-function - a side-effect-free function - `java.util.function.LongUnaryOperator`

  returns: the updated value - `long`"
  (^Long [^AtomicLongArray this ^Integer i ^java.util.function.LongUnaryOperator update-function]
    (-> this (.updateAndGet i update-function))))

(defn add-and-get
  "Atomically adds the given value to the element at index i.

  i - the index - `int`
  delta - the value to add - `long`

  returns: the updated value - `long`"
  (^Long [^AtomicLongArray this ^Integer i ^Long delta]
    (-> this (.addAndGet i delta))))

(defn get-and-update
  "Atomically updates the element at index i with the results
   of applying the given function, returning the previous value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  i - the index - `int`
  update-function - a side-effect-free function - `java.util.function.LongUnaryOperator`

  returns: the previous value - `long`"
  (^Long [^AtomicLongArray this ^Integer i ^java.util.function.LongUnaryOperator update-function]
    (-> this (.getAndUpdate i update-function))))

(defn to-string
  "Returns the String representation of the current values of array.

  returns: the String representation of the current values of array - `java.lang.String`"
  (^java.lang.String [^AtomicLongArray this]
    (-> this (.toString))))

(defn accumulate-and-get
  "Atomically updates the element at index i with the
   results of applying the given function to the current and
   given values, returning the updated value. The function should
   be side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function is
   applied with the current value at index i as its first
   argument, and the given update as the second argument.

  i - the index - `int`
  x - the update value - `long`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.LongBinaryOperator`

  returns: the updated value - `long`"
  (^Long [^AtomicLongArray this ^Integer i ^Long x ^java.util.function.LongBinaryOperator accumulator-function]
    (-> this (.accumulateAndGet i x accumulator-function))))

(defn get-and-decrement
  "Atomically decrements by one the element at index i.

  i - the index - `int`

  returns: the previous value - `long`"
  (^Long [^AtomicLongArray this ^Integer i]
    (-> this (.getAndDecrement i))))

(defn length
  "Returns the length of the array.

  returns: the length of the array - `int`"
  (^Integer [^AtomicLongArray this]
    (-> this (.length))))

(defn decrement-and-get
  "Atomically decrements by one the element at index i.

  i - the index - `int`

  returns: the updated value - `long`"
  (^Long [^AtomicLongArray this ^Integer i]
    (-> this (.decrementAndGet i))))

(defn weak-compare-and-set
  "Atomically sets the element at position i to the given
   updated value if the current value == the expected value.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  i - the index - `int`
  expect - the expected value - `long`
  update - the new value - `long`

  returns: true if successful - `boolean`"
  (^Boolean [^AtomicLongArray this ^Integer i ^Long expect ^Long update]
    (-> this (.weakCompareAndSet i expect update))))

(defn get-and-increment
  "Atomically increments by one the element at index i.

  i - the index - `int`

  returns: the previous value - `long`"
  (^Long [^AtomicLongArray this ^Integer i]
    (-> this (.getAndIncrement i))))

(defn lazy-set
  "Eventually sets the element at position i to the given value.

  i - the index - `int`
  new-value - the new value - `long`"
  ([^AtomicLongArray this ^Integer i ^Long new-value]
    (-> this (.lazySet i new-value))))

(defn set
  "Sets the element at position i to the given value.

  i - the index - `int`
  new-value - the new value - `long`"
  ([^AtomicLongArray this ^Integer i ^Long new-value]
    (-> this (.set i new-value))))

(defn get-and-accumulate
  "Atomically updates the element at index i with the
   results of applying the given function to the current and
   given values, returning the previous value. The function should
   be side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function is
   applied with the current value at index i as its first
   argument, and the given update as the second argument.

  i - the index - `int`
  x - the update value - `long`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.LongBinaryOperator`

  returns: the previous value - `long`"
  (^Long [^AtomicLongArray this ^Integer i ^Long x ^java.util.function.LongBinaryOperator accumulator-function]
    (-> this (.getAndAccumulate i x accumulator-function))))

(defn compare-and-set
  "Atomically sets the element at position i to the given
   updated value if the current value == the expected value.

  i - the index - `int`
  expect - the expected value - `long`
  update - the new value - `long`

  returns: true if successful. False return indicates that
   the actual value was not equal to the expected value. - `boolean`"
  (^Boolean [^AtomicLongArray this ^Integer i ^Long expect ^Long update]
    (-> this (.compareAndSet i expect update))))

(defn get
  "Gets the current value at position i.

  i - the index - `int`

  returns: the current value - `long`"
  (^Long [^AtomicLongArray this ^Integer i]
    (-> this (.get i))))

(defn increment-and-get
  "Atomically increments by one the element at index i.

  i - the index - `int`

  returns: the updated value - `long`"
  (^Long [^AtomicLongArray this ^Integer i]
    (-> this (.incrementAndGet i))))

