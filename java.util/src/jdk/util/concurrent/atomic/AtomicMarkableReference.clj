(ns jdk.util.concurrent.atomic.AtomicMarkableReference
  "An AtomicMarkableReference maintains an object reference
  along with a mark bit, that can be updated atomically.

  Implementation note: This implementation maintains markable
  references by creating internal objects representing `boxed`
  [reference, boolean] pairs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicMarkableReference]))

(defn ->atomic-markable-reference
  "Constructor.

  Creates a new AtomicMarkableReference with the given
   initial values.

  initial-ref - the initial reference - `V`
  initial-mark - the initial mark - `boolean`"
  (^AtomicMarkableReference [initial-ref ^Boolean initial-mark]
    (new AtomicMarkableReference initial-ref initial-mark)))

(defn get-reference
  "Returns the current value of the reference.

  returns: the current value of the reference - `V`"
  ([^AtomicMarkableReference this]
    (-> this (.getReference))))

(defn marked?
  "Returns the current value of the mark.

  returns: the current value of the mark - `boolean`"
  (^Boolean [^AtomicMarkableReference this]
    (-> this (.isMarked))))

(defn get
  "Returns the current values of both the reference and the mark.
   Typical usage is boolean[1] holder; ref = v.get(holder); .

  mark-holder - an array of size of at least one. On return, markholder[0] will hold the value of the mark. - `boolean[]`

  returns: the current value of the reference - `V`"
  ([^AtomicMarkableReference this mark-holder]
    (-> this (.get mark-holder))))

(defn weak-compare-and-set
  "Atomically sets the value of both the reference and mark
   to the given update values if the
   current reference is == to the expected reference
   and the current mark is equal to the expected mark.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  expected-reference - the expected value of the reference - `V`
  new-reference - the new value for the reference - `V`
  expected-mark - the expected value of the mark - `boolean`
  new-mark - the new value for the mark - `boolean`

  returns: true if successful - `boolean`"
  (^Boolean [^AtomicMarkableReference this expected-reference new-reference ^Boolean expected-mark ^Boolean new-mark]
    (-> this (.weakCompareAndSet expected-reference new-reference expected-mark new-mark))))

(defn compare-and-set
  "Atomically sets the value of both the reference and mark
   to the given update values if the
   current reference is == to the expected reference
   and the current mark is equal to the expected mark.

  expected-reference - the expected value of the reference - `V`
  new-reference - the new value for the reference - `V`
  expected-mark - the expected value of the mark - `boolean`
  new-mark - the new value for the mark - `boolean`

  returns: true if successful - `boolean`"
  (^Boolean [^AtomicMarkableReference this expected-reference new-reference ^Boolean expected-mark ^Boolean new-mark]
    (-> this (.compareAndSet expected-reference new-reference expected-mark new-mark))))

(defn set
  "Unconditionally sets the value of both the reference and mark.

  new-reference - the new value for the reference - `V`
  new-mark - the new value for the mark - `boolean`"
  ([^AtomicMarkableReference this new-reference ^Boolean new-mark]
    (-> this (.set new-reference new-mark))))

(defn attempt-mark
  "Atomically sets the value of the mark to the given update value
   if the current reference is == to the expected
   reference.  Any given invocation of this operation may fail
   (return false) spuriously, but repeated invocation
   when the current value holds the expected value and no other
   thread is also attempting to set the value will eventually
   succeed.

  expected-reference - the expected value of the reference - `V`
  new-mark - the new value for the mark - `boolean`

  returns: true if successful - `boolean`"
  (^Boolean [^AtomicMarkableReference this expected-reference ^Boolean new-mark]
    (-> this (.attemptMark expected-reference new-mark))))

