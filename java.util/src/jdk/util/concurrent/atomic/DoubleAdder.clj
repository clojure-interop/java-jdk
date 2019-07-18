(ns jdk.util.concurrent.atomic.DoubleAdder
  "One or more variables that together maintain an initially zero
  double sum.  When updates (method add(double)) are
  contended across threads, the set of variables may grow dynamically
  to reduce contention.  Method sum() (or, equivalently doubleValue()) returns the current total combined across the
  variables maintaining the sum. The order of accumulation within or
  across threads is not guaranteed. Thus, this class may not be
  applicable if numerical stability is required, especially when
  combining values of substantially different orders of magnitude.

  This class is usually preferable to alternatives when multiple
  threads update a common value that is used for purposes such as
  summary statistics that are frequently updated but less frequently
  read.

  This class extends Number, but does not define
  methods such as equals, hashCode and compareTo because instances are expected to be mutated, and so are
  not useful as collection keys."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.concurrent.atomic DoubleAdder]))

(defn ->double-adder
  "Constructor.

  Creates a new adder with initial sum of zero."
  (^DoubleAdder []
    (new DoubleAdder )))

(defn double-value
  "Equivalent to sum().

  returns: the sum - `double`"
  (^Double [^DoubleAdder this]
    (-> this (.doubleValue))))

(defn long-value
  "Returns the sum() as a long after a
   narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  (^Long [^DoubleAdder this]
    (-> this (.longValue))))

(defn sum
  "Returns the current sum.  The returned value is NOT an
   atomic snapshot; invocation in the absence of concurrent
   updates returns an accurate result, but concurrent updates that
   occur while the sum is being calculated might not be
   incorporated.  Also, because floating-point arithmetic is not
   strictly associative, the returned result need not be identical
   to the value that would be obtained in a sequential series of
   updates to a single variable.

  returns: the sum - `double`"
  (^Double [^DoubleAdder this]
    (-> this (.sum))))

(defn sum-then-reset
  "Equivalent in effect to sum() followed by reset(). This method may apply for example during quiescent
   points between multithreaded computations.  If there are
   updates concurrent with this method, the returned value is
   not guaranteed to be the final value occurring before
   the reset.

  returns: the sum - `double`"
  (^Double [^DoubleAdder this]
    (-> this (.sumThenReset))))

(defn to-string
  "Returns the String representation of the sum().

  returns: the String representation of the sum() - `java.lang.String`"
  (^java.lang.String [^DoubleAdder this]
    (-> this (.toString))))

(defn reset
  "Resets variables maintaining the sum to zero.  This method may
   be a useful alternative to creating a new adder, but is only
   effective if there are no concurrent updates.  Because this
   method is intrinsically racy, it should only be used when it is
   known that no threads are concurrently updating."
  ([^DoubleAdder this]
    (-> this (.reset))))

(defn float-value
  "Returns the sum() as a float
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  (^Float [^DoubleAdder this]
    (-> this (.floatValue))))

(defn int-value
  "Returns the sum() as an int after a
   narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  (^Integer [^DoubleAdder this]
    (-> this (.intValue))))

(defn add
  "Adds the given value.

  x - the value to add - `double`"
  ([^DoubleAdder this ^Double x]
    (-> this (.add x))))

