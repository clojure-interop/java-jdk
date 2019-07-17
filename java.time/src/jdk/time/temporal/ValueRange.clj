(ns jdk.time.temporal.ValueRange
  "The range of valid values for a date-time field.

  All TemporalField instances have a valid range of values.
  For example, the ISO day-of-month runs from 1 to somewhere between 28 and 31.
  This class captures that valid range.

  It is important to be aware of the limitations of this class.
  Only the minimum and maximum values are provided.
  It is possible for there to be invalid values within the outer range.
  For example, a weird field may have valid values of 1, 2, 4, 6, 7, thus
  have a range of '1 - 7', despite that fact that values 3 and 5 are invalid.

  Instances of this class are not tied to a specific field."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time.temporal ValueRange]))

(defn *of
  "Obtains a fully variable value range.

   This factory obtains a range where both the minimum and maximum value may vary.

  min-smallest - the smallest minimum value - `long`
  min-largest - the largest minimum value - `long`
  max-smallest - the smallest maximum value - `long`
  max-largest - the largest maximum value - `long`

  returns: the ValueRange for smallest min, largest min, smallest max, largest max, not null - `java.time.temporal.ValueRange`

  throws: java.lang.IllegalArgumentException - if the smallest minimum is greater than the smallest maximum, or the smallest maximum is greater than the largest maximum or the largest minimum is greater than the largest maximum"
  ([min-smallest min-largest max-smallest max-largest]
    (ValueRange/of min-smallest min-largest max-smallest max-largest))
  ([min max-smallest max-largest]
    (ValueRange/of min max-smallest max-largest))
  ([min max]
    (ValueRange/of min max)))

(defn get-minimum
  "Gets the minimum value that the field can take.

   For example, the ISO day-of-month always starts at 1.
   The minimum is therefore 1.

  returns: the minimum value for this field - `long`"
  ([this]
    (-> this (.getMinimum))))

(defn valid-value?
  "Checks if the value is within the valid range.

   This checks that the value is within the stored range of values.

  value - the value to check - `long`

  returns: true if the value is valid - `boolean`"
  ([this value]
    (-> this (.isValidValue value))))

(defn check-valid-int-value
  "Checks that the specified value is valid and fits in an int.

   This validates that the value is within the valid range of values and that
   all valid values are within the bounds of an int.
   The field is only used to improve the error message.

  value - the value to check - `long`
  field - the field being checked, may be null - `java.time.temporal.TemporalField`

  returns: the value that was passed in - `int`"
  ([this value field]
    (-> this (.checkValidIntValue value field))))

(defn to-string
  "Outputs this range as a String.

   The format will be '{min}/{largestMin} - {smallestMax}/{max}',
   where the largestMin or smallestMax sections may be omitted, together
   with associated slash, if they are the same as the min or max.

  returns: a string representation of this range, not null - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn int-value?
  "Checks if all values in the range fit in an int.

   This checks that all valid values are within the bounds of an int.

   For example, the ISO month-of-year has values from 1 to 12, which fits in an int.
   By comparison, ISO nano-of-day runs from 1 to 86,400,000,000,000 which does not fit in an int.

   This implementation uses getMinimum() and getMaximum().

  returns: true if a valid value always fits in an int - `boolean`"
  ([this]
    (-> this (.isIntValue))))

(defn get-smallest-maximum
  "Gets the smallest possible maximum value that the field can take.

   For example, the ISO day-of-month runs to between 28 and 31 days.
   The smallest maximum is therefore 28.

  returns: the smallest possible maximum value for this field - `long`"
  ([this]
    (-> this (.getSmallestMaximum))))

(defn valid-int-value?
  "Checks if the value is within the valid range and that all values
   in the range fit in an int.

   This method combines isIntValue() and isValidValue(long).

  value - the value to check - `long`

  returns: true if the value is valid and fits in an int - `boolean`"
  ([this value]
    (-> this (.isValidIntValue value))))

(defn hash-code
  "A hash code for this range.

  returns: a suitable hash code - `int`"
  ([this]
    (-> this (.hashCode))))

(defn fixed?
  "Is the value range fixed and fully known.

   For example, the ISO day-of-month runs from 1 to between 28 and 31.
   Since there is uncertainty about the maximum value, the range is not fixed.
   However, for the month of January, the range is always 1 to 31, thus it is fixed.

  returns: true if the set of values is fixed - `boolean`"
  ([this]
    (-> this (.isFixed))))

(defn get-maximum
  "Gets the maximum value that the field can take.

   For example, the ISO day-of-month runs to between 28 and 31 days.
   The maximum is therefore 31.

  returns: the maximum value for this field - `long`"
  ([this]
    (-> this (.getMaximum))))

(defn equals
  "Checks if this range is equal to another range.

   The comparison is based on the four values, minimum, largest minimum,
   smallest maximum and maximum.
   Only objects of type ValueRange are compared, other types return false.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other range - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn get-largest-minimum
  "Gets the largest possible minimum value that the field can take.

   For example, the ISO day-of-month always starts at 1.
   The largest minimum is therefore 1.

  returns: the largest possible minimum value for this field - `long`"
  ([this]
    (-> this (.getLargestMinimum))))

(defn check-valid-value
  "Checks that the specified value is valid.

   This validates that the value is within the valid range of values.
   The field is only used to improve the error message.

  value - the value to check - `long`
  field - the field being checked, may be null - `java.time.temporal.TemporalField`

  returns: the value that was passed in - `long`"
  ([this value field]
    (-> this (.checkValidValue value field))))

