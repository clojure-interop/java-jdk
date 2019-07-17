(ns jdk.util.concurrent.atomic.AtomicReferenceArray
  "An array of object references in which elements may be updated
  atomically.  See the java.util.concurrent.atomic package
  specification for description of the properties of atomic
  variables."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicReferenceArray]))

(defn ->atomic-reference-array
  "Constructor.

  Creates a new AtomicReferenceArray of the given length, with all
   elements initially null.

  length - the length of the array - `int`"
  ([^Integer length]
    (new AtomicReferenceArray length)))

(defn get-and-set
  "Atomically sets the element at position i to the given
   value and returns the old value.

  i - the index - `int`
  new-value - the new value - `AtomicReferenceArray.E`

  returns: the previous value - `AtomicReferenceArray.E`"
  (^AtomicReferenceArray.E [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^AtomicReferenceArray.E new-value]
    (-> this (.getAndSet i new-value))))

(defn update-and-get
  "Atomically updates the element at index i with the results
   of applying the given function, returning the updated value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  i - the index - `int`
  update-function - a side-effect-free function - `java.util.function.UnaryOperator<AtomicReferenceArray.E>`

  returns: the updated value - `AtomicReferenceArray.E`"
  (^AtomicReferenceArray.E [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^java.util.function.UnaryOperator update-function]
    (-> this (.updateAndGet i update-function))))

(defn get-and-update
  "Atomically updates the element at index i with the results
   of applying the given function, returning the previous value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  i - the index - `int`
  update-function - a side-effect-free function - `java.util.function.UnaryOperator<AtomicReferenceArray.E>`

  returns: the previous value - `AtomicReferenceArray.E`"
  (^AtomicReferenceArray.E [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^java.util.function.UnaryOperator update-function]
    (-> this (.getAndUpdate i update-function))))

(defn to-string
  "Returns the String representation of the current values of array.

  returns: the String representation of the current values of array - `java.lang.String`"
  (^java.lang.String [^java.util.concurrent.atomic.AtomicReferenceArray this]
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
  x - the update value - `AtomicReferenceArray.E`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.BinaryOperator<AtomicReferenceArray.E>`

  returns: the updated value - `AtomicReferenceArray.E`"
  (^AtomicReferenceArray.E [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^AtomicReferenceArray.E x ^java.util.function.BinaryOperator accumulator-function]
    (-> this (.accumulateAndGet i x accumulator-function))))

(defn length
  "Returns the length of the array.

  returns: the length of the array - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicReferenceArray this]
    (-> this (.length))))

(defn weak-compare-and-set
  "Atomically sets the element at position i to the given
   updated value if the current value == the expected value.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  i - the index - `int`
  expect - the expected value - `AtomicReferenceArray.E`
  update - the new value - `AtomicReferenceArray.E`

  returns: true if successful - `boolean`"
  (^Boolean [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^AtomicReferenceArray.E expect ^AtomicReferenceArray.E update]
    (-> this (.weakCompareAndSet i expect update))))

(defn lazy-set
  "Eventually sets the element at position i to the given value.

  i - the index - `int`
  new-value - the new value - `AtomicReferenceArray.E`"
  ([^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^AtomicReferenceArray.E new-value]
    (-> this (.lazySet i new-value))))

(defn set
  "Sets the element at position i to the given value.

  i - the index - `int`
  new-value - the new value - `AtomicReferenceArray.E`"
  ([^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^AtomicReferenceArray.E new-value]
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
  x - the update value - `AtomicReferenceArray.E`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.BinaryOperator<AtomicReferenceArray.E>`

  returns: the previous value - `AtomicReferenceArray.E`"
  (^AtomicReferenceArray.E [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^AtomicReferenceArray.E x ^java.util.function.BinaryOperator accumulator-function]
    (-> this (.getAndAccumulate i x accumulator-function))))

(defn compare-and-set
  "Atomically sets the element at position i to the given
   updated value if the current value == the expected value.

  i - the index - `int`
  expect - the expected value - `AtomicReferenceArray.E`
  update - the new value - `AtomicReferenceArray.E`

  returns: true if successful. False return indicates that
   the actual value was not equal to the expected value. - `boolean`"
  (^Boolean [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i ^AtomicReferenceArray.E expect ^AtomicReferenceArray.E update]
    (-> this (.compareAndSet i expect update))))

(defn get
  "Gets the current value at position i.

  i - the index - `int`

  returns: the current value - `AtomicReferenceArray.E`"
  (^AtomicReferenceArray.E [^java.util.concurrent.atomic.AtomicReferenceArray this ^Integer i]
    (-> this (.get i))))

