(ns jdk.util.concurrent.atomic.AtomicStampedReference
  "An AtomicStampedReference maintains an object reference
  along with an integer `stamp`, that can be updated atomically.

  Implementation note: This implementation maintains stamped
  references by creating internal objects representing `boxed`
  [reference, integer] pairs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicStampedReference]))

(defn ->atomic-stamped-reference
  "Constructor.

  Creates a new AtomicStampedReference with the given
   initial values.

  initial-ref - the initial reference - `AtomicStampedReference.V`
  initial-stamp - the initial stamp - `int`"
  ([initial-ref initial-stamp]
    (new AtomicStampedReference initial-ref initial-stamp)))

(defn get-reference
  "Returns the current value of the reference.

  returns: the current value of the reference - `AtomicStampedReference.V`"
  ([this]
    (-> this (.getReference))))

(defn get-stamp
  "Returns the current value of the stamp.

  returns: the current value of the stamp - `int`"
  ([this]
    (-> this (.getStamp))))

(defn get
  "Returns the current values of both the reference and the stamp.
   Typical usage is int[1] holder; ref = v.get(holder); .

  stamp-holder - an array of size of at least one. On return, stampholder[0] will hold the value of the stamp. - `int[]`

  returns: the current value of the reference - `AtomicStampedReference.V`"
  ([this stamp-holder]
    (-> this (.get stamp-holder))))

(defn weak-compare-and-set
  "Atomically sets the value of both the reference and stamp
   to the given update values if the
   current reference is == to the expected reference
   and the current stamp is equal to the expected stamp.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  expected-reference - the expected value of the reference - `AtomicStampedReference.V`
  new-reference - the new value for the reference - `AtomicStampedReference.V`
  expected-stamp - the expected value of the stamp - `int`
  new-stamp - the new value for the stamp - `int`

  returns: true if successful - `boolean`"
  ([this expected-reference new-reference expected-stamp new-stamp]
    (-> this (.weakCompareAndSet expected-reference new-reference expected-stamp new-stamp))))

(defn compare-and-set
  "Atomically sets the value of both the reference and stamp
   to the given update values if the
   current reference is == to the expected reference
   and the current stamp is equal to the expected stamp.

  expected-reference - the expected value of the reference - `AtomicStampedReference.V`
  new-reference - the new value for the reference - `AtomicStampedReference.V`
  expected-stamp - the expected value of the stamp - `int`
  new-stamp - the new value for the stamp - `int`

  returns: true if successful - `boolean`"
  ([this expected-reference new-reference expected-stamp new-stamp]
    (-> this (.compareAndSet expected-reference new-reference expected-stamp new-stamp))))

(defn set
  "Unconditionally sets the value of both the reference and stamp.

  new-reference - the new value for the reference - `AtomicStampedReference.V`
  new-stamp - the new value for the stamp - `int`"
  ([this new-reference new-stamp]
    (-> this (.set new-reference new-stamp))))

(defn attempt-stamp
  "Atomically sets the value of the stamp to the given update value
   if the current reference is == to the expected
   reference.  Any given invocation of this operation may fail
   (return false) spuriously, but repeated invocation
   when the current value holds the expected value and no other
   thread is also attempting to set the value will eventually
   succeed.

  expected-reference - the expected value of the reference - `AtomicStampedReference.V`
  new-stamp - the new value for the stamp - `int`

  returns: true if successful - `boolean`"
  ([this expected-reference new-stamp]
    (-> this (.attemptStamp expected-reference new-stamp))))

