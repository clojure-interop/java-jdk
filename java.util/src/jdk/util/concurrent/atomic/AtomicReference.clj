(ns jdk.util.concurrent.atomic.AtomicReference
  "An object reference that may be updated atomically. See the java.util.concurrent.atomic package specification for description
  of the properties of atomic variables."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicReference]))

(defn ->atomic-reference
  "Constructor.

  Creates a new AtomicReference with the given initial value.

  initial-value - the initial value - `AtomicReference.V`"
  ([^AtomicReference.V initial-value]
    (new AtomicReference initial-value))
  ([]
    (new AtomicReference )))

(defn get-and-set
  "Atomically sets to the given value and returns the old value.

  new-value - the new value - `AtomicReference.V`

  returns: the previous value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this ^AtomicReference.V new-value]
    (-> this (.getAndSet new-value))))

(defn update-and-get
  "Atomically updates the current value with the results of
   applying the given function, returning the updated value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  update-function - a side-effect-free function - `java.util.function.UnaryOperator<AtomicReference.V>`

  returns: the updated value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this ^java.util.function.UnaryOperator update-function]
    (-> this (.updateAndGet update-function))))

(defn get-and-update
  "Atomically updates the current value with the results of
   applying the given function, returning the previous value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.

  update-function - a side-effect-free function - `java.util.function.UnaryOperator<AtomicReference.V>`

  returns: the previous value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this ^java.util.function.UnaryOperator update-function]
    (-> this (.getAndUpdate update-function))))

(defn to-string
  "Returns the String representation of the current value.

  returns: the String representation of the current value - `java.lang.String`"
  ([^java.util.concurrent.atomic.AtomicReference this]
    (-> this (.toString))))

(defn accumulate-and-get
  "Atomically updates the current value with the results of
   applying the given function to the current and given values,
   returning the updated value. The function should be
   side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function
   is applied with the current value as its first argument,
   and the given update as the second argument.

  x - the update value - `AtomicReference.V`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.BinaryOperator<AtomicReference.V>`

  returns: the updated value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this ^AtomicReference.V x ^java.util.function.BinaryOperator accumulator-function]
    (-> this (.accumulateAndGet x accumulator-function))))

(defn weak-compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  expect - the expected value - `AtomicReference.V`
  update - the new value - `AtomicReference.V`

  returns: true if successful - `boolean`"
  ([^java.util.concurrent.atomic.AtomicReference this ^AtomicReference.V expect ^AtomicReference.V update]
    (-> this (.weakCompareAndSet expect update))))

(defn lazy-set
  "Eventually sets to the given value.

  new-value - the new value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this ^AtomicReference.V new-value]
    (-> this (.lazySet new-value))))

(defn set
  "Sets to the given value.

  new-value - the new value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this ^AtomicReference.V new-value]
    (-> this (.set new-value))))

(defn get-and-accumulate
  "Atomically updates the current value with the results of
   applying the given function to the current and given values,
   returning the previous value. The function should be
   side-effect-free, since it may be re-applied when attempted
   updates fail due to contention among threads.  The function
   is applied with the current value as its first argument,
   and the given update as the second argument.

  x - the update value - `AtomicReference.V`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.BinaryOperator<AtomicReference.V>`

  returns: the previous value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this ^AtomicReference.V x ^java.util.function.BinaryOperator accumulator-function]
    (-> this (.getAndAccumulate x accumulator-function))))

(defn compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

  expect - the expected value - `AtomicReference.V`
  update - the new value - `AtomicReference.V`

  returns: true if successful. False return indicates that
   the actual value was not equal to the expected value. - `boolean`"
  ([^java.util.concurrent.atomic.AtomicReference this ^AtomicReference.V expect ^AtomicReference.V update]
    (-> this (.compareAndSet expect update))))

(defn get
  "Gets the current value.

  returns: the current value - `AtomicReference.V`"
  ([^java.util.concurrent.atomic.AtomicReference this]
    (-> this (.get))))

