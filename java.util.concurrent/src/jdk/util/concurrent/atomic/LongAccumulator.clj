(ns jdk.util.concurrent.atomic.LongAccumulator
  "One or more variables that together maintain a running long
  value updated using a supplied function.  When updates (method
  accumulate(long)) are contended across threads, the set of variables
  may grow dynamically to reduce contention.  Method get()
  (or, equivalently, longValue()) returns the current value
  across the variables maintaining updates.

  This class is usually preferable to AtomicLong when
  multiple threads update a common value that is used for purposes such
  as collecting statistics, not for fine-grained synchronization
  control.  Under low update contention, the two classes have similar
  characteristics. But under high contention, expected throughput of
  this class is significantly higher, at the expense of higher space
  consumption.

  The order of accumulation within or across threads is not
  guaranteed and cannot be depended upon, so this class is only
  applicable to functions for which the order of accumulation does
  not matter. The supplied accumulator function should be
  side-effect-free, since it may be re-applied when attempted updates
  fail due to contention among threads. The function is applied with
  the current value as its first argument, and the given update as
  the second argument.  For example, to maintain a running maximum
  value, you could supply Long::max along with Long.MIN_VALUE as the identity.

  Class LongAdder provides analogs of the functionality of
  this class for the common special case of maintaining counts and
  sums.  The call new LongAdder() is equivalent to new
  LongAccumulator((x, y) -> x  y, 0L.

  This class extends Number, but does not define
  methods such as equals, hashCode and compareTo because instances are expected to be mutated, and so are
  not useful as collection keys."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic LongAccumulator]))

(defn ->long-accumulator
  "Constructor.

  Creates a new instance using the given accumulator function
   and identity element.

  accumulator-function - a side-effect-free function of two arguments - `java.util.function.LongBinaryOperator`
  identity - identity (initial value) for the accumulator function - `long`"
  ([^java.util.function.LongBinaryOperator accumulator-function ^Long identity]
    (new LongAccumulator accumulator-function identity)))

(defn double-value
  "Returns the current value as a double
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  (^Double [^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.doubleValue))))

(defn long-value
  "Equivalent to get().

  returns: the current value - `long`"
  (^Long [^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.longValue))))

(defn to-string
  "Returns the String representation of the current value.

  returns: the String representation of the current value - `java.lang.String`"
  (^java.lang.String [^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.toString))))

(defn reset
  "Resets variables maintaining updates to the identity value.
   This method may be a useful alternative to creating a new
   updater, but is only effective if there are no concurrent
   updates.  Because this method is intrinsically racy, it should
   only be used when it is known that no threads are concurrently
   updating."
  ([^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.reset))))

(defn float-value
  "Returns the current value as a float
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  (^Float [^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.floatValue))))

(defn get-then-reset
  "Equivalent in effect to get() followed by reset(). This method may apply for example during quiescent
   points between multithreaded computations.  If there are
   updates concurrent with this method, the returned value is
   not guaranteed to be the final value occurring before
   the reset.

  returns: the value before reset - `long`"
  (^Long [^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.getThenReset))))

(defn accumulate
  "Updates with the given value.

  x - the value - `long`"
  ([^java.util.concurrent.atomic.LongAccumulator this ^Long x]
    (-> this (.accumulate x))))

(defn int-value
  "Returns the current value as an int
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  (^Integer [^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.intValue))))

(defn get
  "Returns the current value.  The returned value is NOT
   an atomic snapshot; invocation in the absence of concurrent
   updates returns an accurate result, but concurrent updates that
   occur while the value is being calculated might not be
   incorporated.

  returns: the current value - `long`"
  (^Long [^java.util.concurrent.atomic.LongAccumulator this]
    (-> this (.get))))

