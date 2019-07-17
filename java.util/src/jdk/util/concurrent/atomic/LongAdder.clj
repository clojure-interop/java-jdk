(ns jdk.util.concurrent.atomic.LongAdder
  "One or more variables that together maintain an initially zero
  long sum.  When updates (method add(long)) are contended
  across threads, the set of variables may grow dynamically to reduce
  contention. Method sum() (or, equivalently, longValue()) returns the current total combined across the
  variables maintaining the sum.

  This class is usually preferable to AtomicLong when
  multiple threads update a common sum that is used for purposes such
  as collecting statistics, not for fine-grained synchronization
  control.  Under low update contention, the two classes have similar
  characteristics. But under high contention, expected throughput of
  this class is significantly higher, at the expense of higher space
  consumption.

  LongAdders can be used with a ConcurrentHashMap to maintain a scalable
  frequency map (a form of histogram or multiset). For example, to
  add a count to a ConcurrentHashMap<String,LongAdder> freqs,
  initializing if not already present, you can use freqs.computeIfAbsent(k -> new LongAdder()).increment();

  This class extends Number, but does not define
  methods such as equals, hashCode and compareTo because instances are expected to be mutated, and so are
  not useful as collection keys."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic LongAdder]))

(defn ->long-adder
  "Constructor.

  Creates a new adder with initial sum of zero."
  ([]
    (new LongAdder )))

(defn double-value
  "Returns the sum() as a double after a widening
   primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.doubleValue))))

(defn long-value
  "Equivalent to sum().

  returns: the sum - `long`"
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.longValue))))

(defn sum
  "Returns the current sum.  The returned value is NOT an
   atomic snapshot; invocation in the absence of concurrent
   updates returns an accurate result, but concurrent updates that
   occur while the sum is being calculated might not be
   incorporated.

  returns: the sum - `long`"
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.sum))))

(defn sum-then-reset
  "Equivalent in effect to sum() followed by reset(). This method may apply for example during quiescent
   points between multithreaded computations.  If there are
   updates concurrent with this method, the returned value is
   not guaranteed to be the final value occurring before
   the reset.

  returns: the sum - `long`"
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.sumThenReset))))

(defn to-string
  "Returns the String representation of the sum().

  returns: the String representation of the sum() - `java.lang.String`"
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.toString))))

(defn increment
  "Equivalent to add(1)."
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.increment))))

(defn reset
  "Resets variables maintaining the sum to zero.  This method may
   be a useful alternative to creating a new adder, but is only
   effective if there are no concurrent updates.  Because this
   method is intrinsically racy, it should only be used when it is
   known that no threads are concurrently updating."
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.reset))))

(defn float-value
  "Returns the sum() as a float
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.floatValue))))

(defn decrement
  "Equivalent to add(-1)."
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.decrement))))

(defn int-value
  "Returns the sum() as an int after a narrowing
   primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  ([^java.util.concurrent.atomic.LongAdder this]
    (-> this (.intValue))))

(defn add
  "Adds the given value.

  x - the value to add - `long`"
  ([^java.util.concurrent.atomic.LongAdder this ^Long x]
    (-> this (.add x))))

