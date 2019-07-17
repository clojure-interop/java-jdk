(ns jdk.util.concurrent.atomic.AtomicBoolean
  "A boolean value that may be updated atomically. See the
  java.util.concurrent.atomic package specification for
  description of the properties of atomic variables. An
  AtomicBoolean is used in applications such as atomically
  updated flags, and cannot be used as a replacement for a
  Boolean."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic AtomicBoolean]))

(defn ->atomic-boolean
  "Constructor.

  Creates a new AtomicBoolean with the given initial value.

  initial-value - the initial value - `boolean`"
  ([^Boolean initial-value]
    (new AtomicBoolean initial-value))
  ([]
    (new AtomicBoolean )))

(defn get
  "Returns the current value.

  returns: the current value - `boolean`"
  ([^java.util.concurrent.atomic.AtomicBoolean this]
    (-> this (.get))))

(defn compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

  expect - the expected value - `boolean`
  update - the new value - `boolean`

  returns: true if successful. False return indicates that
   the actual value was not equal to the expected value. - `boolean`"
  ([^java.util.concurrent.atomic.AtomicBoolean this ^Boolean expect ^Boolean update]
    (-> this (.compareAndSet expect update))))

(defn weak-compare-and-set
  "Atomically sets the value to the given updated value
   if the current value == the expected value.

   May fail
   spuriously and does not provide ordering guarantees, so is
   only rarely an appropriate alternative to compareAndSet.

  expect - the expected value - `boolean`
  update - the new value - `boolean`

  returns: true if successful - `boolean`"
  ([^java.util.concurrent.atomic.AtomicBoolean this ^Boolean expect ^Boolean update]
    (-> this (.weakCompareAndSet expect update))))

(defn set
  "Unconditionally sets to the given value.

  new-value - the new value - `boolean`"
  ([^java.util.concurrent.atomic.AtomicBoolean this ^Boolean new-value]
    (-> this (.set new-value))))

(defn lazy-set
  "Eventually sets to the given value.

  new-value - the new value - `boolean`"
  ([^java.util.concurrent.atomic.AtomicBoolean this ^Boolean new-value]
    (-> this (.lazySet new-value))))

(defn get-and-set?
  "Atomically sets to the given value and returns the previous value.

  new-value - the new value - `boolean`

  returns: the previous value - `boolean`"
  ([^java.util.concurrent.atomic.AtomicBoolean this ^Boolean new-value]
    (-> this (.getAndSet new-value))))

(defn to-string
  "Returns the String representation of the current value.

  returns: the String representation of the current value - `java.lang.String`"
  ([^java.util.concurrent.atomic.AtomicBoolean this]
    (-> this (.toString))))

