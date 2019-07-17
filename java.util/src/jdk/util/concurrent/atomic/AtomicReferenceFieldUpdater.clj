(ns jdk.util.concurrent.atomic.AtomicReferenceFieldUpdater
  "A reflection-based utility that enables atomic updates to
  designated volatile reference fields of designated
  classes.  This class is designed for use in atomic data structures
  in which several reference fields of the same node are
  independently subject to atomic updates. For example, a tree node
  might be declared as



  class Node {
    private volatile Node left, right;

    private static final AtomicReferenceFieldUpdater<Node, Node> leftUpdater =
      AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, `left`);
    private static AtomicReferenceFieldUpdater<Node, Node> rightUpdater =
      AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, `right`);

    Node getLeft() { return left; }
    boolean compareAndSetLeft(Node expect, Node update) {
      return leftUpdater.compareAndSet(this, expect, update);
    }
    // ... and so on
  }

  Note that the guarantees of the compareAndSet
  method in this class are weaker than in other atomic classes.
  Because this class cannot ensure that all uses of the field
  are appropriate for purposes of atomic access, it can
  guarantee atomicity only with respect to other invocations of
  compareAndSet and set on the same updater."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicReferenceFieldUpdater]))

(defn *new-updater
  "Creates and returns an updater for objects with the given field.
   The Class arguments are needed to check that reflective types and
   generic types match.

  tclass - the class of the objects holding the field - `java.lang.Class<U>`
  vclass - the class of the field - `java.lang.Class<W>`
  field-name - the name of the field to be updated - `java.lang.String`

  returns: the updater - `<U,W> java.util.concurrent.atomic.AtomicReferenceFieldUpdater<U,W>`

  throws: java.lang.ClassCastException - if the field is of the wrong type"
  ([tclass vclass field-name]
    (AtomicReferenceFieldUpdater/newUpdater tclass vclass field-name)))

(defn get-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given value and returns the old value.

  obj - An object whose field to get and set - `AtomicReferenceFieldUpdater.T`
  new-value - the new value - `AtomicReferenceFieldUpdater.V`

  returns: the previous value - `AtomicReferenceFieldUpdater.V`"
  ([this obj new-value]
    (-> this (.getAndSet obj new-value))))

(defn update-and-get
  "Atomically updates the field of the given object managed by this updater
   with the results of applying the given function, returning the updated
   value. The function should be side-effect-free, since it may be
   re-applied when attempted updates fail due to contention among threads.

  obj - An object whose field to get and set - `AtomicReferenceFieldUpdater.T`
  update-function - a side-effect-free function - `java.util.function.UnaryOperator<AtomicReferenceFieldUpdater.V>`

  returns: the updated value - `AtomicReferenceFieldUpdater.V`"
  ([this obj update-function]
    (-> this (.updateAndGet obj update-function))))

(defn get-and-update
  "Atomically updates the field of the given object managed by this updater
   with the results of applying the given function, returning the previous
   value. The function should be side-effect-free, since it may be
   re-applied when attempted updates fail due to contention among threads.

  obj - An object whose field to get and set - `AtomicReferenceFieldUpdater.T`
  update-function - a side-effect-free function - `java.util.function.UnaryOperator<AtomicReferenceFieldUpdater.V>`

  returns: the previous value - `AtomicReferenceFieldUpdater.V`"
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

  obj - An object whose field to get and set - `AtomicReferenceFieldUpdater.T`
  x - the update value - `AtomicReferenceFieldUpdater.V`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.BinaryOperator<AtomicReferenceFieldUpdater.V>`

  returns: the updated value - `AtomicReferenceFieldUpdater.V`"
  ([this obj x accumulator-function]
    (-> this (.accumulateAndGet obj x accumulator-function))))

(defn weak-compare-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given updated value if the current value == the
   expected value. This method is guaranteed to be atomic with respect to
   other calls to compareAndSet and set, but not
   necessarily with respect to other changes in the field.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  obj - An object whose field to conditionally set - `AtomicReferenceFieldUpdater.T`
  expect - the expected value - `AtomicReferenceFieldUpdater.V`
  update - the new value - `AtomicReferenceFieldUpdater.V`

  returns: true if successful - `boolean`"
  ([this obj expect update]
    (-> this (.weakCompareAndSet obj expect update))))

(defn lazy-set
  "Eventually sets the field of the given object managed by this
   updater to the given updated value.

  obj - An object whose field to set - `AtomicReferenceFieldUpdater.T`
  new-value - the new value - `AtomicReferenceFieldUpdater.V`"
  ([this obj new-value]
    (-> this (.lazySet obj new-value))))

(defn set
  "Sets the field of the given object managed by this updater to the
   given updated value. This operation is guaranteed to act as a volatile
   store with respect to subsequent invocations of compareAndSet.

  obj - An object whose field to set - `AtomicReferenceFieldUpdater.T`
  new-value - the new value - `AtomicReferenceFieldUpdater.V`"
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

  obj - An object whose field to get and set - `AtomicReferenceFieldUpdater.T`
  x - the update value - `AtomicReferenceFieldUpdater.V`
  accumulator-function - a side-effect-free function of two arguments - `java.util.function.BinaryOperator<AtomicReferenceFieldUpdater.V>`

  returns: the previous value - `AtomicReferenceFieldUpdater.V`"
  ([this obj x accumulator-function]
    (-> this (.getAndAccumulate obj x accumulator-function))))

(defn compare-and-set
  "Atomically sets the field of the given object managed by this updater
   to the given updated value if the current value == the
   expected value. This method is guaranteed to be atomic with respect to
   other calls to compareAndSet and set, but not
   necessarily with respect to other changes in the field.

  obj - An object whose field to conditionally set - `AtomicReferenceFieldUpdater.T`
  expect - the expected value - `AtomicReferenceFieldUpdater.V`
  update - the new value - `AtomicReferenceFieldUpdater.V`

  returns: true if successful - `boolean`"
  ([this obj expect update]
    (-> this (.compareAndSet obj expect update))))

(defn get
  "Gets the current value held in the field of the given object managed
   by this updater.

  obj - An object whose field to get - `AtomicReferenceFieldUpdater.T`

  returns: the current value - `AtomicReferenceFieldUpdater.V`"
  ([this obj]
    (-> this (.get obj))))

