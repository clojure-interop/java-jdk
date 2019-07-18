(ns javax.swing.SpinnerNumberModel
  "A SpinnerModel for sequences of numbers.
  The upper and lower bounds of the sequence are defined
  by properties called minimum and
  maximum. The size of the increase or decrease
  computed by the nextValue and
  previousValue methods is defined by a property called
  stepSize.  The minimum and
  maximum properties can be null
  to indicate that the sequence has no lower or upper limit.
  All of the properties in this class are defined in terms of two
  generic types: Number and
  Comparable, so that all Java numeric types
  may be accommodated.  Internally, there's only support for
  values whose type is one of the primitive Number types:
  Double, Float, Long,
  Integer, Short, or Byte.

  To create a SpinnerNumberModel for the integer
  range zero to one hundred, with
  fifty as the initial value, one could write:


  Integer value = new Integer(50);
  Integer min = new Integer(0);
  Integer max = new Integer(100);
  Integer step = new Integer(1);
  SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
  int fifty = model.getNumber().intValue();

  Spinners for integers and doubles are common, so special constructors
  for these cases are provided.  For example to create the model in
  the previous example, one could also write:


  SpinnerNumberModel model = new SpinnerNumberModel(50, 0, 100, 1);

  This model inherits a ChangeListener.
  The ChangeListeners are notified
  whenever the model's value, stepSize,
  minimum, or maximum properties changes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SpinnerNumberModel]))

(defn ->spinner-number-model
  "Constructor.

  Constructs a SpinnerModel that represents
   a closed sequence of
   numbers from minimum to maximum.  The
   nextValue and previousValue methods
   compute elements of the sequence by adding or subtracting
   stepSize respectively.  All of the parameters
   must be mutually Comparable, value
   and stepSize must be instances of Integer
   Long, Float, or Double.

   The minimum and maximum parameters
   can be null to indicate that the range doesn't
   have an upper or lower bound.
   If value or stepSize is null,
   or if both minimum and maximum
   are specified and minimum > maximum then an
   IllegalArgumentException is thrown.
   Similarly if (minimum <= value <= maximum) is false,
   an IllegalArgumentException is thrown.

  value - the current (non null) value of the model - `java.lang.Number`
  minimum - the first number in the sequence or null - `java.lang.Comparable`
  maximum - the last number in the sequence or null - `java.lang.Comparable`
  step-size - the difference between elements of the sequence - `java.lang.Number`

  throws: java.lang.IllegalArgumentException - if stepSize or value is null or if the following expression is false: minimum <= value <= maximum"
  (^SpinnerNumberModel [^java.lang.Number value ^java.lang.Comparable minimum ^java.lang.Comparable maximum ^java.lang.Number step-size]
    (new SpinnerNumberModel value minimum maximum step-size))
  (^SpinnerNumberModel []
    (new SpinnerNumberModel )))

(defn get-previous-value
  "Returns the previous number in the sequence.

  returns: value - stepSize, or
       null if the sum is less
       than minimum. - `java.lang.Object`"
  (^java.lang.Object [^SpinnerNumberModel this]
    (-> this (.getPreviousValue))))

(defn get-step-size
  "Returns the size of the value change computed by the
   getNextValue
   and getPreviousValue methods.

  returns: the value of the stepSize property - `java.lang.Number`"
  (^java.lang.Number [^SpinnerNumberModel this]
    (-> this (.getStepSize))))

(defn get-minimum
  "Returns the first number in this sequence.

  returns: the value of the minimum property - `java.lang.Comparable`"
  (^java.lang.Comparable [^SpinnerNumberModel this]
    (-> this (.getMinimum))))

(defn get-number
  "Returns the value of the current element of the sequence.

  returns: the value property - `java.lang.Number`"
  (^java.lang.Number [^SpinnerNumberModel this]
    (-> this (.getNumber))))

(defn get-value
  "Returns the value of the current element of the sequence.

  returns: the value property - `java.lang.Object`"
  (^java.lang.Object [^SpinnerNumberModel this]
    (-> this (.getValue))))

(defn set-step-size
  "Changes the size of the value change computed by the
   getNextValue and getPreviousValue
   methods.  An IllegalArgumentException
   is thrown if stepSize is null.

   This method fires a ChangeEvent if the
   stepSize has changed.

  step-size - the size of the value change computed by the getNextValue and getPreviousValue methods - `java.lang.Number`"
  ([^SpinnerNumberModel this ^java.lang.Number step-size]
    (-> this (.setStepSize step-size))))

(defn set-maximum
  "Changes the upper bound for numbers in this sequence.
   If maximum is null, then there
   is no upper bound.  No bounds checking is done here; the new
   maximum value may invalidate the
   (minimum <= value < maximum)
   invariant enforced by the constructors.  This is to simplify updating
   the model, naturally one should ensure that the invariant is true
   before calling the next, previous,
   or setValue methods.

   Typically this property is a Number of the same type
   as the value however it's possible to use any
   Comparable with a compareTo
   method for a Number with the same type as the value.
   See
   setMinimum for an example.

   This method fires a ChangeEvent if the
   maximum has changed.

  maximum - a Comparable that has a compareTo method for Numbers with the same type as value - `java.lang.Comparable`"
  ([^SpinnerNumberModel this ^java.lang.Comparable maximum]
    (-> this (.setMaximum maximum))))

(defn set-value
  "Sets the current value for this sequence.  If value is
   null, or not a Number, an
   IllegalArgumentException is thrown.  No
   bounds checking is done here; the new value may invalidate the
   (minimum <= value <= maximum)
   invariant enforced by the constructors.   It's also possible to set
   the value to be something that wouldn't naturally occur in the sequence,
   i.e. a value that's not modulo the stepSize.
   This is to simplify updating the model, and to accommodate
   spinners that don't want to restrict values that have been
   directly entered by the user. Naturally, one should ensure that the
   (minimum <= value <= maximum) invariant is true
   before calling the next, previous, or
   setValue methods.

   This method fires a ChangeEvent if the value has changed.

  value - the current (non null) Number for this sequence - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if value is null or not a Number"
  ([^SpinnerNumberModel this ^java.lang.Object value]
    (-> this (.setValue value))))

(defn set-minimum
  "Changes the lower bound for numbers in this sequence.
   If minimum is null,
   then there is no lower bound.  No bounds checking is done here;
   the new minimum value may invalidate the
   (minimum <= value <= maximum)
   invariant enforced by the constructors.  This is to simplify updating
   the model, naturally one should ensure that the invariant is true
   before calling the getNextValue,
   getPreviousValue, or setValue methods.

   Typically this property is a Number of the same type
   as the value however it's possible to use any
   Comparable with a compareTo
   method for a Number with the same type as the value.
   For example if value was a Long,
   minimum might be a Date subclass defined like this:


   MyDate extends Date {  // Date already implements Comparable
       public int compareTo(Long o) {
           long t = getTime();
           return (t < o.longValue() ? -1 : (t == o.longValue() ? 0 : 1));
       }
   }

   This method fires a ChangeEvent
   if the minimum has changed.

  minimum - a Comparable that has a compareTo method for Numbers with the same type as value - `java.lang.Comparable`"
  ([^SpinnerNumberModel this ^java.lang.Comparable minimum]
    (-> this (.setMinimum minimum))))

(defn get-next-value
  "Returns the next number in the sequence.

  returns: value  stepSize or null if the sum
       exceeds maximum. - `java.lang.Object`"
  (^java.lang.Object [^SpinnerNumberModel this]
    (-> this (.getNextValue))))

(defn get-maximum
  "Returns the last number in the sequence.

  returns: the value of the maximum property - `java.lang.Comparable`"
  (^java.lang.Comparable [^SpinnerNumberModel this]
    (-> this (.getMaximum))))

