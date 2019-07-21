(ns jdk.math.RoundingMode
  (:refer-clojure :only [require comment defn ->])
  (:import [java.math RoundingMode]))

(def UP
  "Enum Constant.

  Rounding mode to round away from zero.  Always increments the
   digit prior to a non-zero discarded fraction.  Note that this
   rounding mode never decreases the magnitude of the calculated
   value.

  Example:

   Rounding mode UP Examples
  Input Number
      Input rounded to one digit with UP rounding
  5.5  6
  2.5  3
  1.6  2
  1.1  2
  1.0  1
  -1.0 -1
  -1.1 -2
  -1.6 -2
  -2.5 -3
  -5.5 -6

  type: java.math.RoundingMode"
  RoundingMode/UP)

(def DOWN
  "Enum Constant.

  Rounding mode to round towards zero.  Never increments the digit
   prior to a discarded fraction (i.e., truncates).  Note that this
   rounding mode never increases the magnitude of the calculated value.

  Example:

   Rounding mode DOWN Examples
  Input Number
      Input rounded to one digit with DOWN rounding
  5.5  5
  2.5  2
  1.6  1
  1.1  1
  1.0  1
  -1.0 -1
  -1.1 -1
  -1.6 -1
  -2.5 -2
  -5.5 -5

  type: java.math.RoundingMode"
  RoundingMode/DOWN)

(def CEILING
  "Enum Constant.

  Rounding mode to round towards positive infinity.  If the
   result is positive, behaves as for RoundingMode.UP;
   if negative, behaves as for RoundingMode.DOWN.  Note
   that this rounding mode never decreases the calculated value.

  Example:

   Rounding mode CEILING Examples
  Input Number
      Input rounded to one digit with CEILING rounding
  5.5  6
  2.5  3
  1.6  2
  1.1  2
  1.0  1
  -1.0 -1
  -1.1 -1
  -1.6 -1
  -2.5 -2
  -5.5 -5

  type: java.math.RoundingMode"
  RoundingMode/CEILING)

(def FLOOR
  "Enum Constant.

  Rounding mode to round towards negative infinity.  If the
   result is positive, behave as for RoundingMode.DOWN;
   if negative, behave as for RoundingMode.UP.  Note that
   this rounding mode never increases the calculated value.

  Example:

   Rounding mode FLOOR Examples
  Input Number
      Input rounded to one digit with FLOOR rounding
  5.5  5
  2.5  2
  1.6  1
  1.1  1
  1.0  1
  -1.0 -1
  -1.1 -2
  -1.6 -2
  -2.5 -3
  -5.5 -6

  type: java.math.RoundingMode"
  RoundingMode/FLOOR)

(def HALF_UP
  "Enum Constant.

  Rounding mode to round towards \"nearest neighbor\"
   unless both neighbors are equidistant, in which case round up.
   Behaves as for RoundingMode.UP if the discarded
   fraction is ≥ 0.5; otherwise, behaves as for
   RoundingMode.DOWN.  Note that this is the rounding
   mode commonly taught at school.

  Example:

   Rounding mode HALF_UP Examples
  Input Number
      Input rounded to one digit with HALF_UP rounding
  5.5  6
  2.5  3
  1.6  2
  1.1  1
  1.0  1
  -1.0 -1
  -1.1 -1
  -1.6 -2
  -2.5 -3
  -5.5 -6

  type: java.math.RoundingMode"
  RoundingMode/HALF_UP)

(def HALF_DOWN
  "Enum Constant.

  Rounding mode to round towards \"nearest neighbor\"
   unless both neighbors are equidistant, in which case round
   down.  Behaves as for RoundingMode.UP if the discarded
   fraction is > 0.5; otherwise, behaves as for
   RoundingMode.DOWN.

  Example:

   Rounding mode HALF_DOWN Examples
  Input Number
      Input rounded to one digit with HALF_DOWN rounding
  5.5  5
  2.5  2
  1.6  2
  1.1  1
  1.0  1
  -1.0 -1
  -1.1 -1
  -1.6 -2
  -2.5 -2
  -5.5 -5

  type: java.math.RoundingMode"
  RoundingMode/HALF_DOWN)

(def HALF_EVEN
  "Enum Constant.

  Rounding mode to round towards the \"nearest neighbor\"
   unless both neighbors are equidistant, in which case, round
   towards the even neighbor.  Behaves as for
   RoundingMode.HALF_UP if the digit to the left of the
   discarded fraction is odd; behaves as for
   RoundingMode.HALF_DOWN if it's even.  Note that this
   is the rounding mode that statistically minimizes cumulative
   error when applied repeatedly over a sequence of calculations.
   It is sometimes known as \"Banker's rounding,\" and is
   chiefly used in the USA.  This rounding mode is analogous to
   the rounding policy used for float and double
   arithmetic in Java.

  Example:

   Rounding mode HALF_EVEN Examples
  Input Number
      Input rounded to one digit with HALF_EVEN rounding
  5.5  6
  2.5  2
  1.6  2
  1.1  1
  1.0  1
  -1.0 -1
  -1.1 -1
  -1.6 -2
  -2.5 -2
  -5.5 -6

  type: java.math.RoundingMode"
  RoundingMode/HALF_EVEN)

(def UNNECESSARY
  "Enum Constant.

  Rounding mode to assert that the requested operation has an exact
   result, hence no rounding is necessary.  If this rounding mode is
   specified on an operation that yields an inexact result, an
   ArithmeticException is thrown.
  Example:

   Rounding mode UNNECESSARY Examples
  Input Number
      Input rounded to one digit with UNNECESSARY rounding
  5.5  throw ArithmeticException
  2.5  throw ArithmeticException
  1.6  throw ArithmeticException
  1.1  throw ArithmeticException
  1.0  1
  -1.0 -1
  -1.1 throw ArithmeticException
  -1.6 throw ArithmeticException
  -2.5 throw ArithmeticException
  -5.5 throw ArithmeticException

  type: java.math.RoundingMode"
  RoundingMode/UNNECESSARY)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (RoundingMode c : RoundingMode.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.math.RoundingMode[]`"
  ([]
    (RoundingMode/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.math.RoundingMode`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.math.RoundingMode [^java.lang.String name]
    (RoundingMode/valueOf name)))

