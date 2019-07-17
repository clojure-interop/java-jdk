(ns jdk.util.concurrent.atomic.AtomicIntegerFieldUpdater
  "A reflection-based utility that enables atomic updates to
  designated volatile int fields of designated classes.
  This class is designed for use in atomic data structures in which
  several fields of the same node are independently subject to atomic
  updates.

  Note that the guarantees of the compareAndSet
  method in this class are weaker than in other atomic classes.
  Because this class cannot ensure that all uses of the field
  are appropriate for purposes of atomic access, it can
  guarantee atomicity only with respect to other invocations of
  compareAndSet and set on the same updater."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicIntegerFieldUpdater]))

(defn *new-updater
  "Creates and returns an updater for objects with the given field.
   The Class argument is needed to check that reflective types and
   generic types match.

  tclass - the class of the objects holding the field - `java.lang.Class<U>`
  field-name - the name of the field to be updated - `java.lang.String`

  returns: the updater - `<U> java.util.concurrent.atomic.AtomicIntegerFieldUpdater<U>`

  throws: java.lang.IllegalArgumentException - if the field is not a volatile integer type"
  ([^java.lang.Class tclass ^java.lang.String field-name]
    (AtomicIntegerFieldUpdater/newUpdater tclass field-name)))

(defn get-and-add
  "Atomically adds the given value to the current value of the field of
   the given object managed by this updater.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`
  delta - the value to add - `int`

  returns: the previous value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer delta]
    (-> this (.getAndAdd obj delta))))

(defn get-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given value and returns the old value.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`
  new-value - the new value - `int`

  returns: the previous value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer new-value]
    (-> this (.getAndSet obj new-value))))

(defn update-and-get
  "Atomically updates the field of the given object managed by this updater
   with the results of applying the given function, returning the updated
   value. The function should be side-effect-free, since it may be
   re-applied when attempted updates fail due to contention among threads.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`
  update-function - a side-effect-free function - `java.util.function.IntUnaryOperator`

  returns: the updated value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^java.util.function.IntUnaryOperator update-function]
    (-> this (.updateAndGet obj update-function))))

(defn add-and-get
  "Atomically adds the given value to the current value of the field of
   the given object managed by this updater.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`
  delta - the value to add - `int`

  returns: the updated value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer delta]
    (-> this (.addAndGet obj delta))))

(defn get-and-update
  "Atomically updates the field of the given object managed by this updater
   with the results of applying the given function, returning the previous
   value. The function should be side-effect-free, since it may be
   re-applied when attempted updates fail due to contention among threads.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`
  update-function - a side-effect-free function - `java.util.function.IntUnaryOperator`

  returns: the previous value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^java.util.function.IntUnaryOperator update-function]
    (-> this (.getAndUpdate obj update-function))))

(defn accumulate-and-get
  "Atomically updates the field of the given object managed by this
   updater with the results of applying the given function to the
   current and given values, returning the updated value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.  The
   function is applied with the current value as its first argument,
   and the given update as the second argument.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`
  x - the update value - `int`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.IntBinaryOperator`

  returns: the updated value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer x ^java.util.function.IntBinaryOperator accumulator-function]
    (-> this (.accumulateAndGet obj x accumulator-function))))

(defn get-and-decrement
  "Atomically decrements by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`

  returns: the previous value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj]
    (-> this (.getAndDecrement obj))))

(defn decrement-and-get
  "Atomically decrements by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`

  returns: the updated value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj]
    (-> this (.decrementAndGet obj))))

(defn weak-compare-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given updated value if the current value == the
   expected value. This method is guaranteed to be atomic with respect to
   other calls to compareAndSet and set, but not
   necessarily with respect to other changes in the field.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  obj - An object whose field to conditionally set - `AtomicIntegerFieldUpdater.T`
  expect - the expected value - `int`
  update - the new value - `int`

  returns: true if successful - `boolean`

  throws: java.lang.ClassCastException - if obj is not an instance of the class possessing the field established in the constructor"
  (^Boolean [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer expect ^Integer update]
    (-> this (.weakCompareAndSet obj expect update))))

(defn get-and-increment
  "Atomically increments by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`

  returns: the previous value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj]
    (-> this (.getAndIncrement obj))))

(defn lazy-set
  "Eventually sets the field of the given object managed by this
   updater to the given updated value.

  obj - An object whose field to set - `AtomicIntegerFieldUpdater.T`
  new-value - the new value - `int`"
  ([^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer new-value]
    (-> this (.lazySet obj new-value))))

(defn set
  "Sets the field of the given object managed by this updater to the
   given updated value. This operation is guaranteed to act as a volatile
   store with respect to subsequent invocations of compareAndSet.

  obj - An object whose field to set - `AtomicIntegerFieldUpdater.T`
  new-value - the new value - `int`"
  ([^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer new-value]
    (-> this (.set obj new-value))))

(defn get-and-accumulate
  "Atomically updates the field of the given object managed by this
   updater with the results of applying the given function to the
   current and given values, returning the previous value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.  The
   function is applied with the current value as its first argument,
   and the given update as the second argument.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`
  x - the update value - `int`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.IntBinaryOperator`

  returns: the previous value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer x ^java.util.function.IntBinaryOperator accumulator-function]
    (-> this (.getAndAccumulate obj x accumulator-function))))

(defn compare-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given updated value if the current value == the
   expected value. This method is guaranteed to be atomic with respect to
   other calls to compareAndSet and set, but not
   necessarily with respect to other changes in the field.

  obj - An object whose field to conditionally set - `AtomicIntegerFieldUpdater.T`
  expect - the expected value - `int`
  update - the new value - `int`

  returns: true if successful - `boolean`

  throws: java.lang.ClassCastException - if obj is not an instance of the class possessing the field established in the constructor"
  (^Boolean [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj ^Integer expect ^Integer update]
    (-> this (.compareAndSet obj expect update))))

(defn get
  "Gets the current value held in the field of the given object managed
   by this updater.

  obj - An object whose field to get - `AtomicIntegerFieldUpdater.T`

  returns: the current value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj]
    (-> this (.get obj))))

(defn increment-and-get
  "Atomically increments by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicIntegerFieldUpdater.T`

  returns: the updated value - `int`"
  (^Integer [^java.util.concurrent.atomic.AtomicIntegerFieldUpdater this ^AtomicIntegerFieldUpdater.T obj]
    (-> this (.incrementAndGet obj))))

