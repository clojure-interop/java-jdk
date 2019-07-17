(ns javax.sound.sampled.FloatControl
  "A FloatControl object provides control over a range of
  floating-point values.  Float controls are often
  represented in graphical user interfaces by continuously
  adjustable objects such as sliders or rotary knobs.  Concrete subclasses
  of FloatControl implement controls, such as gain and pan, that
  affect a line's audio signal in some way that an application can manipulate.
  The FloatControl.Type
  inner class provides static instances of types that are used to
  identify some common kinds of float control.

  The FloatControl abstract class provides methods to set and get
  the control's current floating-point value.  Other methods obtain the possible
  range of values and the control's resolution (the smallest increment between
  returned values).  Some float controls allow ramping to a
  new value over a specified period of time.  FloatControl also
  includes methods that return string labels for the minimum, maximum, and midpoint
  positions of the control."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled FloatControl]))

(defn get-precision
  "Obtains the resolution or granularity of the control, in the units
   that the control measures.
   The precision is the size of the increment between discrete valid values
   for this control, over the set of supported floating-point values.

  returns: the control's precision - `float`"
  (^Float [^javax.sound.sampled.FloatControl this]
    (-> this (.getPrecision))))

(defn get-minimum
  "Obtains the minimum value permitted.

  returns: the minimum allowable value - `float`"
  (^Float [^javax.sound.sampled.FloatControl this]
    (-> this (.getMinimum))))

(defn get-update-period
  "Obtains the smallest time interval, in microseconds, over which the control's value can
   change during a shift.  The update period is the inverse of the frequency with which
   the control updates its value during a shift.  If the implementation does not support value shifting over
   time, it should set the control's value to the final value immediately
   and return -1 from this method.

  returns: update period in microseconds, or -1 if shifting over time is unsupported - `int`"
  (^Integer [^javax.sound.sampled.FloatControl this]
    (-> this (.getUpdatePeriod))))

(defn get-units
  "Obtains the label for the units in which the control's values are expressed,
   such as `dB` or `frames per second.`

  returns: the units label, or a zero-length string if no label - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.FloatControl this]
    (-> this (.getUnits))))

(defn to-string
  "Provides a string representation of the control

  returns: a string description - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.FloatControl this]
    (-> this (.toString))))

(defn get-value
  "Obtains this control's current value.

  returns: the current value - `float`"
  (^Float [^javax.sound.sampled.FloatControl this]
    (-> this (.getValue))))

(defn get-max-label
  "Obtains the label for the maximum value, such as `Right` or `Full.`

  returns: the maximum value label, or a zero-length string if no label      * has been set - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.FloatControl this]
    (-> this (.getMaxLabel))))

(defn shift
  "Changes the control value from the initial value to the final
   value linearly over the specified time period, specified in microseconds.
   This method returns without blocking; it does not wait for the shift
   to complete.  An implementation should complete the operation within the time
   specified.  The default implementation simply changes the value
   to the final value immediately.

  from - initial value at the beginning of the shift - `float`
  to - final value after the shift - `float`
  microseconds - maximum duration of the shift in microseconds - `int`

  throws: java.lang.IllegalArgumentException - if either from or to value does not fall within the allowable range"
  ([^javax.sound.sampled.FloatControl this ^Float from ^Float to ^Integer microseconds]
    (-> this (.shift from to microseconds))))

(defn set-value
  "Sets the current value for the control.  The default implementation
   simply sets the value as indicated.  If the value indicated is greater
   than the maximum value, or smaller than the minimum value, an
   IllegalArgumentException is thrown.
   Some controls require that their line be open before they can be affected
   by setting a value.

  new-value - desired new value - `float`

  throws: java.lang.IllegalArgumentException - if the value indicated does not fall within the allowable range"
  ([^javax.sound.sampled.FloatControl this ^Float new-value]
    (-> this (.setValue new-value))))

(defn get-mid-label
  "Obtains the label for the mid-point value, such as `Center` or `Default.`

  returns: the mid-point value label, or a zero-length string if no label    * has been set - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.FloatControl this]
    (-> this (.getMidLabel))))

(defn get-maximum
  "Obtains the maximum value permitted.

  returns: the maximum allowable value - `float`"
  (^Float [^javax.sound.sampled.FloatControl this]
    (-> this (.getMaximum))))

(defn get-min-label
  "Obtains the label for the minimum value, such as `Left` or `Off.`

  returns: the minimum value label, or a zero-length string if no label      * has been set - `java.lang.String`"
  (^java.lang.String [^javax.sound.sampled.FloatControl this]
    (-> this (.getMinLabel))))

