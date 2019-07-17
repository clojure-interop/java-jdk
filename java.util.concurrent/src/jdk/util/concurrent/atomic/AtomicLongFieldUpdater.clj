(ns jdk.util.concurrent.atomic.AtomicLongFieldUpdater
  "A reflection-based utility that enables atomic updates to
  designated volatile long fields of designated classes.
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
  (:import [java.util.concurrent.atomic AtomicLongFieldUpdater]))

(defn *new-updater
  "Creates and returns an updater for objects with the given field.
   The Class argument is needed to check that reflective types and
   generic types match.

  tclass - the class of the objects holding the field - `java.lang.Class<U>`
  field-name - the name of the field to be updated - `java.lang.String`

  returns: the updater - `<U> java.util.concurrent.atomic.AtomicLongFieldUpdater<U>`

  throws: java.lang.IllegalArgumentException - if the field is not a volatile long type"
  ([tclass field-name]
    (AtomicLongFieldUpdater/newUpdater tclass field-name)))

(defn get-and-add
  "Atomically adds the given value to the current value of the field of
   the given object managed by this updater.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`
  delta - the value to add - `long`

  returns: the previous value - `long`"
  ([this obj delta]
    (-> this (.getAndAdd obj delta))))

(defn get-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given value and returns the old value.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`
  new-value - the new value - `long`

  returns: the previous value - `long`"
  ([this obj new-value]
    (-> this (.getAndSet obj new-value))))

(defn update-and-get
  "Atomically updates the field of the given object managed by this updater
   with the results of applying the given function, returning the updated
   value. The function should be side-effect-free, since it may be
   re-applied when attempted updates fail due to contention among threads.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`
  update-function - a side-effect-free function - `java.util.function.LongUnaryOperator`

  returns: the updated value - `long`"
  ([this obj update-function]
    (-> this (.updateAndGet obj update-function))))

(defn add-and-get
  "Atomically adds the given value to the current value of the field of
   the given object managed by this updater.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`
  delta - the value to add - `long`

  returns: the updated value - `long`"
  ([this obj delta]
    (-> this (.addAndGet obj delta))))

(defn get-and-update
  "Atomically updates the field of the given object managed by this updater
   with the results of applying the given function, returning the previous
   value. The function should be side-effect-free, since it may be
   re-applied when attempted updates fail due to contention among threads.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`
  update-function - a side-effect-free function - `java.util.function.LongUnaryOperator`

  returns: the previous value - `long`"
  ([this obj update-function]
    (-> this (.getAndUpdate obj update-function))))

(defn accumulate-and-get
  "Atomically updates the field of the given object managed by this
   updater with the results of applying the given function to the
   current and given values, returning the updated value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.  The
   function is applied with the current value as its first argument,
   and the given update as the second argument.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`
  x - the update value - `long`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.LongBinaryOperator`

  returns: the updated value - `long`"
  ([this obj x accumulator-function]
    (-> this (.accumulateAndGet obj x accumulator-function))))

(defn get-and-decrement
  "Atomically decrements by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`

  returns: the previous value - `long`"
  ([this obj]
    (-> this (.getAndDecrement obj))))

(defn decrement-and-get
  "Atomically decrements by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`

  returns: the updated value - `long`"
  ([this obj]
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

  obj - An object whose field to conditionally set - `AtomicLongFieldUpdater.T`
  expect - the expected value - `long`
  update - the new value - `long`

  returns: true if successful - `boolean`

  throws: java.lang.ClassCastException - if obj is not an instance of the class possessing the field established in the constructor"
  ([this obj expect update]
    (-> this (.weakCompareAndSet obj expect update))))

(defn get-and-increment
  "Atomically increments by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`

  returns: the previous value - `long`"
  ([this obj]
    (-> this (.getAndIncrement obj))))

(defn lazy-set
  "Eventually sets the field of the given object managed by this
   updater to the given updated value.

  obj - An object whose field to set - `AtomicLongFieldUpdater.T`
  new-value - the new value - `long`"
  ([this obj new-value]
    (-> this (.lazySet obj new-value))))

(defn set
  "Sets the field of the given object managed by this updater to the
   given updated value. This operation is guaranteed to act as a volatile
   store with respect to subsequent invocations of compareAndSet.

  obj - An object whose field to set - `AtomicLongFieldUpdater.T`
  new-value - the new value - `long`"
  ([this obj new-value]
    (-> this (.set obj new-value))))

(defn get-and-accumulate
  "Atomically updates the field of the given object managed by this
   updater with the results of applying the given function to the
   current and given values, returning the previous value. The
   function should be side-effect-free, since it may be re-applied
   when attempted updates fail due to contention among threads.  The
   function is applied with the current value as its first argument,
   and the given update as the second argument.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`
  x - the update value - `long`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.LongBinaryOperator`

  returns: the previous value - `long`"
  ([this obj x accumulator-function]
    (-> this (.getAndAccumulate obj x accumulator-function))))

(defn compare-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given updated value if the current value == the
   expected value. This method is guaranteed to be atomic with respect to
   other calls to compareAndSet and set, but not
   necessarily with respect to other changes in the field.

  obj - An object whose field to conditionally set - `AtomicLongFieldUpdater.T`
  expect - the expected value - `long`
  update - the new value - `long`

  returns: true if successful - `boolean`

  throws: java.lang.ClassCastException - if obj is not an instance of the class possessing the field established in the constructor"
  ([this obj expect update]
    (-> this (.compareAndSet obj expect update))))

(defn get
  "Gets the current value held in the field of the given object managed
   by this updater.

  obj - An object whose field to get - `AtomicLongFieldUpdater.T`

  returns: the current value - `long`"
  ([this obj]
    (-> this (.get obj))))

(defn increment-and-get
  "Atomically increments by one the current value of the field of the
   given object managed by this updater.

  obj - An object whose field to get and set - `AtomicLongFieldUpdater.T`

  returns: the updated value - `long`"
  ([this obj]
    (-> this (.incrementAndGet obj))))

