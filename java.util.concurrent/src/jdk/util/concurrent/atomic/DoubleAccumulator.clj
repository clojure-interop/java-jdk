(ns jdk.util.concurrent.atomic.DoubleAccumulator
  "One or more variables that together maintain a running double
  value updated using a supplied function.  When updates (method
  accumulate(double)) are contended across threads, the set of variables
  may grow dynamically to reduce contention.  Method get()
  (or, equivalently, doubleValue()) returns the current value
  across the variables maintaining updates.

  This class is usually preferable to alternatives when multiple
  threads update a common value that is used for purposes such as
  summary statistics that are frequently updated but less frequently
  read.

  The supplied accumulator function should be side-effect-free,
  since it may be re-applied when attempted updates fail due to
  contention among threads. The function is applied with the current
  value as its first argument, and the given update as the second
  argument.  For example, to maintain a running maximum value, you
  could supply Double::max along with Double.NEGATIVE_INFINITY as the identity. The order of
  accumulation within or across threads is not guaranteed. Thus, this
  class may not be applicable if numerical stability is required,
  especially when combining values of substantially different orders
  of magnitude.

  Class DoubleAdder provides analogs of the functionality
  of this class for the common special case of maintaining sums.  The
  call new DoubleAdder() is equivalent to new
  DoubleAccumulator((x, y) -> x  y, 0.0).

  This class extends Number, but does not define
  methods such as equals, hashCode and compareTo because instances are expected to be mutated, and so are
  not useful as collection keys."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic DoubleAccumulator]))

(defn ->double-accumulator
  "Constructor.

  Creates a new instance using the given accumulator function
   and identity element.

  accumulator-function - a side-effect-free function of two arguments - `java.util.function.DoubleBinaryOperator`
  identity - identity (initial value) for the accumulator function - `double`"
  (^DoubleAccumulator [^java.util.function.DoubleBinaryOperator accumulator-function ^Double identity]
    (new DoubleAccumulator accumulator-function identity)))

(defn double-value
  "Equivalent to get().

  returns: the current value - `double`"
  (^Double [^DoubleAccumulator this]
    (-> this (.doubleValue))))

(defn long-value
  "Returns the current value as a long
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  (^Long [^DoubleAccumulator this]
    (-> this (.longValue))))

(defn to-string
  "Returns the String representation of the current value.

  returns: the String representation of the current value - `java.lang.String`"
  (^java.lang.String [^DoubleAccumulator this]
    (-> this (.toString))))

(defn reset
  "Resets variables maintaining updates to the identity value.
   This method may be a useful alternative to creating a new
   updater, but is only effective if there are no concurrent
   updates.  Because this method is intrinsically racy, it should
   only be used when it is known that no threads are concurrently
   updating."
  ([^DoubleAccumulator this]
    (-> this (.reset))))

(defn float-value
  "Returns the current value as a float
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  (^Float [^DoubleAccumulator this]
    (-> this (.floatValue))))

(defn get-then-reset
  "Equivalent in effect to get() followed by reset(). This method may apply for example during quiescent
   points between multithreaded computations.  If there are
   updates concurrent with this method, the returned value is
   not guaranteed to be the final value occurring before
   the reset.

  returns: the value before reset - `double`"
  (^Double [^DoubleAccumulator this]
    (-> this (.getThenReset))))

(defn accumulate
  "Updates with the given value.

  x - the value - `double`"
  ([^DoubleAccumulator this ^Double x]
    (-> this (.accumulate x))))

(defn int-value
  "Returns the current value as an int
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  (^Integer [^DoubleAccumulator this]
    (-> this (.intValue))))

(defn get
  "Returns the current value.  The returned value is NOT
   an atomic snapshot; invocation in the absence of concurrent
   updates returns an accurate result, but concurrent updates that
   occur while the value is being calculated might not be
   incorporated.

  returns: the current value - `double`"
  (^Double [^DoubleAccumulator this]
    (-> this (.get))))

