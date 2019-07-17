(ns jdk.math.BigDecimal
  "Immutable, arbitrary-precision signed decimal numbers.  A
  BigDecimal consists of an arbitrary precision integer
  unscaled value and a 32-bit integer scale.  If zero
  or positive, the scale is the number of digits to the right of the
  decimal point.  If negative, the unscaled value of the number is
  multiplied by ten to the power of the negation of the scale.  The
  value of the number represented by the BigDecimal is
  therefore (unscaledValue × 10-scale).

  The BigDecimal class provides operations for
  arithmetic, scale manipulation, rounding, comparison, hashing, and
  format conversion.  The toString() method provides a
  canonical representation of a BigDecimal.

  The BigDecimal class gives its user complete control
  over rounding behavior.  If no rounding mode is specified and the
  exact result cannot be represented, an exception is thrown;
  otherwise, calculations can be carried out to a chosen precision
  and rounding mode by supplying an appropriate MathContext
  object to the operation.  In either case, eight rounding
  modes are provided for the control of rounding.  Using the
  integer fields in this class (such as ROUND_HALF_UP) to
  represent rounding mode is largely obsolete; the enumeration values
  of the RoundingMode enum, (such as RoundingMode.HALF_UP) should be used instead.

  When a MathContext object is supplied with a precision
  setting of 0 (for example, MathContext.UNLIMITED),
  arithmetic operations are exact, as are the arithmetic methods
  which take no MathContext object.  (This is the only
  behavior that was supported in releases prior to 5.)  As a
  corollary of computing the exact result, the rounding mode setting
  of a MathContext object with a precision setting of 0 is
  not used and thus irrelevant.  In the case of divide, the exact
  quotient could have an infinitely long decimal expansion; for
  example, 1 divided by 3.  If the quotient has a nonterminating
  decimal expansion and the operation is specified to return an exact
  result, an ArithmeticException is thrown.  Otherwise, the
  exact result of the division is returned, as done for other
  operations.

  When the precision setting is not 0, the rules of
  BigDecimal arithmetic are broadly compatible with selected
  modes of operation of the arithmetic defined in ANSI X3.274-1996
  and ANSI X3.274-1996/AM 1-2000 (section 7.4).  Unlike those
  standards, BigDecimal includes many rounding modes, which
  were mandatory for division in BigDecimal releases prior
  to 5.  Any conflicts between these ANSI standards and the
  BigDecimal specification are resolved in favor of
  BigDecimal.

  Since the same numerical value can have different
  representations (with different scales), the rules of arithmetic
  and rounding must specify both the numerical result and the scale
  used in the result's representation.


  In general the rounding modes and precision setting determine
  how operations return results with a limited number of digits when
  the exact result has more digits (perhaps infinitely many in the
  case of division) than the number of digits returned.

  First, the
  total number of digits to return is specified by the
  MathContext's precision setting; this determines
  the result's precision.  The digit count starts from the
  leftmost nonzero digit of the exact result.  The rounding mode
  determines how any discarded trailing digits affect the returned
  result.

  For all arithmetic operators , the operation is carried out as
  though an exact intermediate result were first calculated and then
  rounded to the number of digits specified by the precision setting
  (if necessary), using the selected rounding mode.  If the exact
  result is not returned, some digit positions of the exact result
  are discarded.  When rounding increases the magnitude of the
  returned result, it is possible for a new digit position to be
  created by a carry propagating to a leading `9` digit.
  For example, rounding the value 999.9 to three digits rounding up
  would be numerically equal to one thousand, represented as
  100×101.  In such cases, the new `1` is
  the leading digit position of the returned result.

  Besides a logical exact result, each arithmetic operation has a
  preferred scale for representing a result.  The preferred
  scale for each operation is listed in the table below.


  Preferred Scales for Results of Arithmetic Operations

  OperationPreferred Scale of Result
  Addmax(addend.scale(), augend.scale())
  Subtractmax(minuend.scale(), subtrahend.scale())
  Multiplymultiplier.scale()  multiplicand.scale()
  Dividedividend.scale() - divisor.scale()


  These scales are the ones used by the methods which return exact
  arithmetic results; except that an exact divide may have to use a
  larger scale since the exact result may have more digits.  For
  example, 1/32 is 0.03125.

  Before rounding, the scale of the logical exact intermediate
  result is the preferred scale for that operation.  If the exact
  numerical result cannot be represented in precision
  digits, rounding selects the set of digits to return and the scale
  of the result is reduced from the scale of the intermediate result
  to the least scale which can represent the precision
  digits actually returned.  If the exact result can be represented
  with at most precision digits, the representation
  of the result with the scale closest to the preferred scale is
  returned.  In particular, an exactly representable quotient may be
  represented in fewer than precision digits by removing
  trailing zeros and decreasing the scale.  For example, rounding to
  three digits using the floor
  rounding mode,

  19/100 = 0.19   // integer=19,  scale=2

  but

  21/110 = 0.190  // integer=190, scale=3

  Note that for add, subtract, and multiply, the reduction in
  scale will equal the number of digit positions of the exact result
  which are discarded. If the rounding causes a carry propagation to
  create a new high-order digit position, an additional digit of the
  result is discarded than when no new digit position is created.

  Other methods may have slightly different rounding semantics.
  For example, the result of the pow method using the
  specified algorithm can
  occasionally differ from the rounded mathematical result by more
  than one unit in the last place, one ulp.

  Two types of operations are provided for manipulating the scale
  of a BigDecimal: scaling/rounding operations and decimal
  point motion operations.  Scaling/rounding operations (setScale and round) return a
  BigDecimal whose value is approximately (or exactly) equal
  to that of the operand, but whose scale or precision is the
  specified value; that is, they increase or decrease the precision
  of the stored number with minimal effect on its value.  Decimal
  point motion operations (movePointLeft and
  movePointRight) return a
  BigDecimal created from the operand by moving the decimal
  point a specified distance in the specified direction.

  For the sake of brevity and clarity, pseudo-code is used
  throughout the descriptions of BigDecimal methods.  The
  pseudo-code expression (i  j) is shorthand for `a
  BigDecimal whose value is that of the BigDecimal
  i added to that of the BigDecimal
  j.` The pseudo-code expression (i == j) is
  shorthand for `true if and only if the
  BigDecimal i represents the same value as the
  BigDecimal j.` Other pseudo-code expressions
  are interpreted similarly.  Square brackets are used to represent
  the particular BigInteger and scale pair defining a
  BigDecimal value; for example [19, 2] is the
  BigDecimal numerically equal to 0.19 having a scale of 2.

  Note: care should be exercised if BigDecimal objects
  are used as keys in a SortedMap or
  elements in a SortedSet since
  BigDecimal's natural ordering is inconsistent
  with equals.  See Comparable, SortedMap or SortedSet for more
  information.

  All methods and constructors for this class throw
  NullPointerException when passed a null object
  reference for any input parameter."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.math BigDecimal]))

(defn ->big-decimal
  "Constructor.

  Translates a character array representation of a
   BigDecimal into a BigDecimal, accepting the
   same sequence of characters as the BigDecimal(String)
   constructor, while allowing a sub-array to be specified and
   with rounding according to the context settings.

   Note that if the sequence of characters is already available
   within a character array, using this constructor is faster than
   converting the char array to string and using the
   BigDecimal(String) constructor .

  in - char array that is the source of characters. - `char[]`
  offset - first character in the array to inspect. - `int`
  len - number of characters to consider.. - `int`
  mc - the context to use. - `java.math.MathContext`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY."
  ([in ^Integer offset ^Integer len ^java.math.MathContext mc]
    (new BigDecimal in offset len mc))
  ([in ^Integer offset ^Integer len]
    (new BigDecimal in offset len))
  ([in ^java.math.MathContext mc]
    (new BigDecimal in mc))
  ([in]
    (new BigDecimal in)))

(def *-zero
  "Static Constant.

  The value 0, with a scale of 0.

  type: java.math.BigDecimal"
  BigDecimal/ZERO)

(def *-one
  "Static Constant.

  The value 1, with a scale of 0.

  type: java.math.BigDecimal"
  BigDecimal/ONE)

(def *-ten
  "Static Constant.

  The value 10, with a scale of 0.

  type: java.math.BigDecimal"
  BigDecimal/TEN)

(def *-round-up
  "Static Constant.

  Rounding mode to round away from zero.  Always increments the
   digit prior to a nonzero discarded fraction.  Note that this rounding
   mode never decreases the magnitude of the calculated value.

  type: int"
  BigDecimal/ROUND_UP)

(def *-round-down
  "Static Constant.

  Rounding mode to round towards zero.  Never increments the digit
   prior to a discarded fraction (i.e., truncates).  Note that this
   rounding mode never increases the magnitude of the calculated value.

  type: int"
  BigDecimal/ROUND_DOWN)

(def *-round-ceiling
  "Static Constant.

  Rounding mode to round towards positive infinity.  If the
   BigDecimal is positive, behaves as for
   ROUND_UP; if negative, behaves as for
   ROUND_DOWN.  Note that this rounding mode never
   decreases the calculated value.

  type: int"
  BigDecimal/ROUND_CEILING)

(def *-round-floor
  "Static Constant.

  Rounding mode to round towards negative infinity.  If the
   BigDecimal is positive, behave as for
   ROUND_DOWN; if negative, behave as for
   ROUND_UP.  Note that this rounding mode never
   increases the calculated value.

  type: int"
  BigDecimal/ROUND_FLOOR)

(def *-round-half-up
  "Static Constant.

  Rounding mode to round towards `nearest neighbor`
   unless both neighbors are equidistant, in which case round up.
   Behaves as for ROUND_UP if the discarded fraction is
   ≥ 0.5; otherwise, behaves as for ROUND_DOWN.  Note
   that this is the rounding mode that most of us were taught in
   grade school.

  type: int"
  BigDecimal/ROUND_HALF_UP)

(def *-round-half-down
  "Static Constant.

  Rounding mode to round towards `nearest neighbor`
   unless both neighbors are equidistant, in which case round
   down.  Behaves as for ROUND_UP if the discarded
   fraction is > 0.5; otherwise, behaves as for
   ROUND_DOWN.

  type: int"
  BigDecimal/ROUND_HALF_DOWN)

(def *-round-half-even
  "Static Constant.

  Rounding mode to round towards the `nearest neighbor`
   unless both neighbors are equidistant, in which case, round
   towards the even neighbor.  Behaves as for
   ROUND_HALF_UP if the digit to the left of the
   discarded fraction is odd; behaves as for
   ROUND_HALF_DOWN if it's even.  Note that this is the
   rounding mode that minimizes cumulative error when applied
   repeatedly over a sequence of calculations.

  type: int"
  BigDecimal/ROUND_HALF_EVEN)

(def *-round-unnecessary
  "Static Constant.

  Rounding mode to assert that the requested operation has an exact
   result, hence no rounding is necessary.  If this rounding mode is
   specified on an operation that yields an inexact result, an
   ArithmeticException is thrown.

  type: int"
  BigDecimal/ROUND_UNNECESSARY)

(defn *value-of
  "Translates a long unscaled value and an
   int scale into a BigDecimal.  This
   `static factory method` is provided in preference to
   a (long, int) constructor because it
   allows for reuse of frequently used BigDecimal values..

  unscaled-val - unscaled value of the BigDecimal. - `long`
  scale - scale of the BigDecimal. - `int`

  returns: a BigDecimal whose value is
           (unscaledVal × 10-scale). - `java.math.BigDecimal`"
  (^java.math.BigDecimal [^Long unscaled-val ^Integer scale]
    (BigDecimal/valueOf unscaled-val scale))
  (^java.math.BigDecimal [^Long val]
    (BigDecimal/valueOf val)))

(defn ulp
  "Returns the size of an ulp, a unit in the last place, of this
   BigDecimal.  An ulp of a nonzero BigDecimal
   value is the positive distance between this value and the
   BigDecimal value next larger in magnitude with the
   same number of digits.  An ulp of a zero value is numerically
   equal to 1 with the scale of this.  The result is
   stored with the same scale as this so the result
   for zero and nonzero values is equal to [1,
   this.scale()].

  returns: the size of an ulp of this - `java.math.BigDecimal`"
  (^java.math.BigDecimal [^java.math.BigDecimal this]
    (-> this (.ulp))))

(defn min
  "Returns the minimum of this BigDecimal and
   val.

  val - value with which the minimum is to be computed. - `java.math.BigDecimal`

  returns: the BigDecimal whose value is the lesser of this
           BigDecimal and val.  If they are equal,
           as defined by the compareTo
           method, this is returned. - `java.math.BigDecimal`"
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal val]
    (-> this (.min val))))

(defn precision
  "Returns the precision of this BigDecimal.  (The
   precision is the number of digits in the unscaled value.)

   The precision of a zero value is 1.

  returns: the precision of this BigDecimal. - `int`"
  (^Integer [^java.math.BigDecimal this]
    (-> this (.precision))))

(defn double-value
  "Converts this BigDecimal to a double.
   This conversion is similar to the
   narrowing primitive conversion from double to
   float as defined in section 5.1.3 of
   The Java™ Language Specification:
   if this BigDecimal has too great a
   magnitude represent as a double, it will be
   converted to Double.NEGATIVE_INFINITY or Double.POSITIVE_INFINITY as appropriate.  Note that even when
   the return value is finite, this conversion can lose
   information about the precision of the BigDecimal
   value.

  returns: this BigDecimal converted to a double. - `double`"
  (^Double [^java.math.BigDecimal this]
    (-> this (.doubleValue))))

(defn long-value
  "Converts this BigDecimal to a long.
   This conversion is analogous to the
   narrowing primitive conversion from double to
   short as defined in section 5.1.3 of
   The Java™ Language Specification:
   any fractional part of this
   BigDecimal will be discarded, and if the resulting
   `BigInteger` is too big to fit in a
   long, only the low-order 64 bits are returned.
   Note that this conversion can lose information about the
   overall magnitude and precision of this BigDecimal value as well
   as return a result with the opposite sign.

  returns: this BigDecimal converted to a long. - `long`"
  (^Long [^java.math.BigDecimal this]
    (-> this (.longValue))))

(defn multiply
  "Returns a BigDecimal whose value is (this ×
   multiplicand), with rounding according to the context settings.

  multiplicand - value to be multiplied by this BigDecimal. - `java.math.BigDecimal`
  mc - the context to use. - `java.math.MathContext`

  returns: this * multiplicand, rounded as necessary. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal multiplicand ^java.math.MathContext mc]
    (-> this (.multiply multiplicand mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal multiplicand]
    (-> this (.multiply multiplicand))))

(defn scale
  "Returns the scale of this BigDecimal.  If zero
   or positive, the scale is the number of digits to the right of
   the decimal point.  If negative, the unscaled value of the
   number is multiplied by ten to the power of the negation of the
   scale.  For example, a scale of -3 means the unscaled
   value is multiplied by 1000.

  returns: the scale of this BigDecimal. - `int`"
  (^Integer [^java.math.BigDecimal this]
    (-> this (.scale))))

(defn move-point-right
  "Returns a BigDecimal which is equivalent to this one
   with the decimal point moved n places to the right.
   If n is non-negative, the call merely subtracts
   n from the scale.  If n is negative, the call
   is equivalent to movePointLeft(-n).  The
   BigDecimal returned by this call has value (this
   × 10n) and scale max(this.scale()-n,
   0).

  n - number of places to move the decimal point to the right. - `int`

  returns: a BigDecimal which is equivalent to this one
           with the decimal point moved n places to the right. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if scale overflows."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^Integer n]
    (-> this (.movePointRight n))))

(defn negate
  "Returns a BigDecimal whose value is (-this),
   with rounding according to the context settings.

  mc - the context to use. - `java.math.MathContext`

  returns: -this, rounded as necessary. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.MathContext mc]
    (-> this (.negate mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this]
    (-> this (.negate))))

(defn plus
  "Returns a BigDecimal whose value is (+this),
   with rounding according to the context settings.

   The effect of this method is identical to that of the round(MathContext) method.

  mc - the context to use. - `java.math.MathContext`

  returns: this, rounded as necessary.  A zero result will
           have a scale of 0. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.MathContext mc]
    (-> this (.plus mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this]
    (-> this (.plus))))

(defn to-big-integer
  "Converts this BigDecimal to a BigInteger.
   This conversion is analogous to the
   narrowing primitive conversion from double to
   long as defined in section 5.1.3 of
   The Java™ Language Specification:
   any fractional part of this
   BigDecimal will be discarded.  Note that this
   conversion can lose information about the precision of the
   BigDecimal value.

   To have an exception thrown if the conversion is inexact (in
   other words if a nonzero fractional part is discarded), use the
   toBigIntegerExact() method.

  returns: this BigDecimal converted to a BigInteger. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.math.BigDecimal this]
    (-> this (.toBigInteger))))

(defn long-value-exact
  "Converts this BigDecimal to a long, checking
   for lost information.  If this BigDecimal has a
   nonzero fractional part or is out of the possible range for a
   long result then an ArithmeticException is
   thrown.

  returns: this BigDecimal converted to a long. - `long`

  throws: java.lang.ArithmeticException - if this has a nonzero fractional part, or will not fit in a long."
  (^Long [^java.math.BigDecimal this]
    (-> this (.longValueExact))))

(defn max
  "Returns the maximum of this BigDecimal and val.

  val - value with which the maximum is to be computed. - `java.math.BigDecimal`

  returns: the BigDecimal whose value is the greater of this
           BigDecimal and val.  If they are equal,
           as defined by the compareTo
           method, this is returned. - `java.math.BigDecimal`"
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal val]
    (-> this (.max val))))

(defn divide-and-remainder
  "Returns a two-element BigDecimal array containing the
   result of divideToIntegralValue followed by the result of
   remainder on the two operands calculated with rounding
   according to the context settings.

   Note that if both the integer quotient and remainder are
   needed, this method is faster than using the
   divideToIntegralValue and remainder methods
   separately because the division need only be carried out once.

  divisor - value by which this BigDecimal is to be divided, and the remainder computed. - `java.math.BigDecimal`
  mc - the context to use. - `java.math.MathContext`

  returns: a two element BigDecimal array: the quotient
           (the result of divideToIntegralValue) is the
           initial element and the remainder is the final element. - `java.math.BigDecimal[]`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY, or mc.precision > 0 and the result of this.divideToIntgralValue(divisor) would require a precision of more than mc.precision digits."
  ([^java.math.BigDecimal this ^java.math.BigDecimal divisor ^java.math.MathContext mc]
    (-> this (.divideAndRemainder divisor mc)))
  ([^java.math.BigDecimal this ^java.math.BigDecimal divisor]
    (-> this (.divideAndRemainder divisor))))

(defn pow
  "Returns a BigDecimal whose value is
   (thisn).  The current implementation uses
   the core algorithm defined in ANSI standard X3.274-1996 with
   rounding according to the context settings.  In general, the
   returned numerical value is within two ulps of the exact
   numerical value for the chosen precision.  Note that future
   releases may use a different algorithm with a decreased
   allowable error bound and increased allowable exponent range.

   The X3.274-1996 algorithm is:


    An ArithmeticException exception is thrown if

      abs(n) > 999999999
      mc.precision == 0 and n < 0
      mc.precision > 0 and n has more than
      mc.precision decimal digits


    if n is zero, ONE is returned even if
   this is zero, otherwise

      if n is positive, the result is calculated via
     the repeated squaring technique into a single accumulator.
     The individual multiplications with the accumulator use the
     same math context settings as in mc except for a
     precision increased to mc.precision  elength  1
     where elength is the number of decimal digits in
     n.

      if n is negative, the result is calculated as if
     n were positive; this value is then divided into one
     using the working precision specified above.

      The final value from either the positive or negative case
     is then rounded to the destination precision.

  n - power to raise this BigDecimal to. - `int`
  mc - the context to use. - `java.math.MathContext`

  returns: thisn using the ANSI standard X3.274-1996
           algorithm - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY, or n is out of range."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^Integer n ^java.math.MathContext mc]
    (-> this (.pow n mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^Integer n]
    (-> this (.pow n))))

(defn to-string
  "Returns the string representation of this BigDecimal,
   using scientific notation if an exponent is needed.

   A standard canonical string form of the BigDecimal
   is created as though by the following steps: first, the
   absolute value of the unscaled value of the BigDecimal
   is converted to a string in base ten using the characters
   '0' through '9' with no leading zeros (except
   if its value is zero, in which case a single '0'
   character is used).

   Next, an adjusted exponent is calculated; this is the
   negated scale, plus the number of characters in the converted
   unscaled value, less one.  That is,
   -scale+(ulength-1), where ulength is the
   length of the absolute value of the unscaled value in decimal
   digits (its precision).

   If the scale is greater than or equal to zero and the
   adjusted exponent is greater than or equal to -6, the
   number will be converted to a character form without using
   exponential notation.  In this case, if the scale is zero then
   no decimal point is added and if the scale is positive a
   decimal point will be inserted with the scale specifying the
   number of characters to the right of the decimal point.
   '0' characters are added to the left of the converted
   unscaled value as necessary.  If no character precedes the
   decimal point after this insertion then a conventional
   '0' character is prefixed.

   Otherwise (that is, if the scale is negative, or the
   adjusted exponent is less than -6), the number will be
   converted to a character form using exponential notation.  In
   this case, if the converted BigInteger has more than
   one digit a decimal point is inserted after the first digit.
   An exponent in character form is then suffixed to the converted
   unscaled value (perhaps with inserted decimal point); this
   comprises the letter 'E' followed immediately by the
   adjusted exponent converted to a character form.  The latter is
   in base ten, using the characters '0' through
   '9' with no leading zeros, and is always prefixed by a
   sign character '-' ('\u002D') if the
   adjusted exponent is negative, '+'
   ('\u002B') otherwise).

   Finally, the entire string is prefixed by a minus sign
   character '-' ('\u002D') if the unscaled
   value is less than zero.  No sign character is prefixed if the
   unscaled value is zero or positive.

   Examples:
   For each representation [unscaled value, scale]
   on the left, the resulting string is shown on the right.


   [123,0]      `123`
   [-123,0]     `-123`
   [123,-1]     `1.23E+3`
   [123,-3]     `1.23E+5`
   [123,1]      `12.3`
   [123,5]      `0.00123`
   [123,10]     `1.23E-8`
   [-123,12]    `-1.23E-10`

   Notes:


   There is a one-to-one mapping between the distinguishable
   BigDecimal values and the result of this conversion.
   That is, every distinguishable BigDecimal value
   (unscaled value and scale) has a unique string representation
   as a result of using toString.  If that string
   representation is converted back to a BigDecimal using
   the BigDecimal(String) constructor, then the original
   value will be recovered.

   The string produced for a given number is always the same;
   it is not affected by locale.  This means that it can be used
   as a canonical string representation for exchanging decimal
   data, or as a key for a Hashtable, etc.  Locale-sensitive
   number formatting and parsing is handled by the NumberFormat class and its subclasses.

   The toEngineeringString() method may be used for
   presenting numbers with exponents in engineering notation, and the
   setScale method may be used for
   rounding a BigDecimal so it has a known number of digits after
   the decimal point.

   The digit-to-character mapping provided by
   Character.forDigit is used.

  returns: string representation of this BigDecimal. - `java.lang.String`"
  (^java.lang.String [^java.math.BigDecimal this]
    (-> this (.toString))))

(defn to-engineering-string
  "Returns a string representation of this BigDecimal,
   using engineering notation if an exponent is needed.

   Returns a string that represents the BigDecimal as
   described in the toString() method, except that if
   exponential notation is used, the power of ten is adjusted to
   be a multiple of three (engineering notation) such that the
   integer part of nonzero values will be in the range 1 through
   999.  If exponential notation is used for zero values, a
   decimal point and one or two fractional zero digits are used so
   that the scale of the zero value is preserved.  Note that
   unlike the output of toString(), the output of this
   method is not guaranteed to recover the same [integer,
   scale] pair of this BigDecimal if the output string is
   converting back to a BigDecimal using the string constructor.  The result of this method meets
   the weaker constraint of always producing a numerically equal
   result from applying the string constructor to the method's output.

  returns: string representation of this BigDecimal, using
           engineering notation if an exponent is needed. - `java.lang.String`"
  (^java.lang.String [^java.math.BigDecimal this]
    (-> this (.toEngineeringString))))

(defn float-value
  "Converts this BigDecimal to a float.
   This conversion is similar to the
   narrowing primitive conversion from double to
   float as defined in section 5.1.3 of
   The Java™ Language Specification:
   if this BigDecimal has too great a
   magnitude to represent as a float, it will be
   converted to Float.NEGATIVE_INFINITY or Float.POSITIVE_INFINITY as appropriate.  Note that even when
   the return value is finite, this conversion can lose
   information about the precision of the BigDecimal
   value.

  returns: this BigDecimal converted to a float. - `float`"
  (^Float [^java.math.BigDecimal this]
    (-> this (.floatValue))))

(defn unscaled-value
  "Returns a BigInteger whose value is the unscaled
   value of this BigDecimal.  (Computes (this *
   10this.scale()).)

  returns: the unscaled value of this BigDecimal. - `java.math.BigInteger`"
  (^java.math.BigInteger [^java.math.BigDecimal this]
    (-> this (.unscaledValue))))

(defn to-plain-string
  "Returns a string representation of this BigDecimal
   without an exponent field.  For values with a positive scale,
   the number of digits to the right of the decimal point is used
   to indicate scale.  For values with a zero or negative scale,
   the resulting string is generated as if the value were
   converted to a numerically equal value with zero scale and as
   if all the trailing zeros of the zero scale value were present
   in the result.

   The entire string is prefixed by a minus sign character '-'
   ('\u002D') if the unscaled value is less than
   zero. No sign character is prefixed if the unscaled value is
   zero or positive.

   Note that if the result of this method is passed to the
   string constructor, only the
   numerical value of this BigDecimal will necessarily be
   recovered; the representation of the new BigDecimal
   may have a different scale.  In particular, if this
   BigDecimal has a negative scale, the string resulting
   from this method will have a scale of zero when processed by
   the string constructor.

   (This method behaves analogously to the toString
   method in 1.4 and earlier releases.)

  returns: a string representation of this BigDecimal
   without an exponent field. - `java.lang.String`"
  (^java.lang.String [^java.math.BigDecimal this]
    (-> this (.toPlainString))))

(defn scale-by-power-of-ten
  "Returns a BigDecimal whose numerical value is equal to
   (this * 10n).  The scale of
   the result is (this.scale() - n).

  n - the exponent power of ten to scale by - `int`

  returns: a BigDecimal whose numerical value is equal to
   (this * 10n) - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the scale would be outside the range of a 32-bit integer."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^Integer n]
    (-> this (.scaleByPowerOfTen n))))

(defn remainder
  "Returns a BigDecimal whose value is (this %
   divisor), with rounding according to the context settings.
   The MathContext settings affect the implicit divide
   used to compute the remainder.  The remainder computation
   itself is by definition exact.  Therefore, the remainder may
   contain more than mc.getPrecision() digits.

   The remainder is given by
   this.subtract(this.divideToIntegralValue(divisor,
   mc).multiply(divisor)).  Note that this is not the modulo
   operation (the result can be negative).

  divisor - value by which this BigDecimal is to be divided. - `java.math.BigDecimal`
  mc - the context to use. - `java.math.MathContext`

  returns: this % divisor, rounded as necessary. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY, or mc.precision > 0 and the result of this.divideToIntgralValue(divisor) would require a precision of more than mc.precision digits."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal divisor ^java.math.MathContext mc]
    (-> this (.remainder divisor mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal divisor]
    (-> this (.remainder divisor))))

(defn subtract
  "Returns a BigDecimal whose value is (this - subtrahend),
   with rounding according to the context settings.

   If subtrahend is zero then this, rounded if necessary, is used as the
   result.  If this is zero then the result is subtrahend.negate(mc).

  subtrahend - value to be subtracted from this BigDecimal. - `java.math.BigDecimal`
  mc - the context to use. - `java.math.MathContext`

  returns: this - subtrahend, rounded as necessary. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal subtrahend ^java.math.MathContext mc]
    (-> this (.subtract subtrahend mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal subtrahend]
    (-> this (.subtract subtrahend))))

(defn byte-value-exact
  "Converts this BigDecimal to a byte, checking
   for lost information.  If this BigDecimal has a
   nonzero fractional part or is out of the possible range for a
   byte result then an ArithmeticException is
   thrown.

  returns: this BigDecimal converted to a byte. - `byte`

  throws: java.lang.ArithmeticException - if this has a nonzero fractional part, or will not fit in a byte."
  (^Byte [^java.math.BigDecimal this]
    (-> this (.byteValueExact))))

(defn short-value-exact
  "Converts this BigDecimal to a short, checking
   for lost information.  If this BigDecimal has a
   nonzero fractional part or is out of the possible range for a
   short result then an ArithmeticException is
   thrown.

  returns: this BigDecimal converted to a short. - `short`

  throws: java.lang.ArithmeticException - if this has a nonzero fractional part, or will not fit in a short."
  (^Short [^java.math.BigDecimal this]
    (-> this (.shortValueExact))))

(defn to-big-integer-exact
  "Converts this BigDecimal to a BigInteger,
   checking for lost information.  An exception is thrown if this
   BigDecimal has a nonzero fractional part.

  returns: this BigDecimal converted to a BigInteger. - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - if this has a nonzero fractional part."
  (^java.math.BigInteger [^java.math.BigDecimal this]
    (-> this (.toBigIntegerExact))))

(defn move-point-left
  "Returns a BigDecimal which is equivalent to this one
   with the decimal point moved n places to the left.  If
   n is non-negative, the call merely adds n to
   the scale.  If n is negative, the call is equivalent
   to movePointRight(-n).  The BigDecimal
   returned by this call has value (this ×
   10-n) and scale max(this.scale()+n,
   0).

  n - number of places to move the decimal point to the left. - `int`

  returns: a BigDecimal which is equivalent to this one with the
           decimal point moved n places to the left. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if scale overflows."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^Integer n]
    (-> this (.movePointLeft n))))

(defn abs
  "Returns a BigDecimal whose value is the absolute value
   of this BigDecimal, with rounding according to the
   context settings.

  mc - the context to use. - `java.math.MathContext`

  returns: abs(this), rounded as necessary. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.MathContext mc]
    (-> this (.abs mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this]
    (-> this (.abs))))

(defn int-value
  "Converts this BigDecimal to an int.
   This conversion is analogous to the
   narrowing primitive conversion from double to
   short as defined in section 5.1.3 of
   The Java™ Language Specification:
   any fractional part of this
   BigDecimal will be discarded, and if the resulting
   `BigInteger` is too big to fit in an
   int, only the low-order 32 bits are returned.
   Note that this conversion can lose information about the
   overall magnitude and precision of this BigDecimal
   value as well as return a result with the opposite sign.

  returns: this BigDecimal converted to an int. - `int`"
  (^Integer [^java.math.BigDecimal this]
    (-> this (.intValue))))

(defn divide
  "Returns a BigDecimal whose value is (this /
   divisor), and whose scale is as specified.  If rounding must
   be performed to generate a result with the specified scale, the
   specified rounding mode is applied.

   The new divide(BigDecimal, int, RoundingMode) method
   should be used in preference to this legacy method.

  divisor - value by which this BigDecimal is to be divided. - `java.math.BigDecimal`
  scale - scale of the BigDecimal quotient to be returned. - `int`
  rounding-mode - rounding mode to apply. - `int`

  returns: this / divisor - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if divisor is zero, roundingMode==ROUND_UNNECESSARY and the specified scale is insufficient to represent the result of the division exactly."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal divisor ^Integer scale ^Integer rounding-mode]
    (-> this (.divide divisor scale rounding-mode)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal divisor ^Integer rounding-mode]
    (-> this (.divide divisor rounding-mode)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal divisor]
    (-> this (.divide divisor))))

(defn hash-code
  "Returns the hash code for this BigDecimal.  Note that
   two BigDecimal objects that are numerically equal but
   differ in scale (like 2.0 and 2.00) will generally not
   have the same hash code.

  returns: hash code for this BigDecimal. - `int`"
  (^Integer [^java.math.BigDecimal this]
    (-> this (.hashCode))))

(defn add
  "Returns a BigDecimal whose value is (this  augend),
   with rounding according to the context settings.

   If either number is zero and the precision setting is nonzero then
   the other number, rounded if necessary, is used as the result.

  augend - value to be added to this BigDecimal. - `java.math.BigDecimal`
  mc - the context to use. - `java.math.MathContext`

  returns: this  augend, rounded as necessary. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the result is inexact but the rounding mode is UNNECESSARY."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal augend ^java.math.MathContext mc]
    (-> this (.add augend mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal augend]
    (-> this (.add augend))))

(defn divide-to-integral-value
  "Returns a BigDecimal whose value is the integer part
   of (this / divisor).  Since the integer part of the
   exact quotient does not depend on the rounding mode, the
   rounding mode does not affect the values returned by this
   method.  The preferred scale of the result is
   (this.scale() - divisor.scale()).  An
   ArithmeticException is thrown if the integer part of
   the exact quotient needs more than mc.precision
   digits.

  divisor - value by which this BigDecimal is to be divided. - `java.math.BigDecimal`
  mc - the context to use. - `java.math.MathContext`

  returns: The integer part of this / divisor. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if mc.precision > 0 and the result requires a precision of more than mc.precision digits."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal divisor ^java.math.MathContext mc]
    (-> this (.divideToIntegralValue divisor mc)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.BigDecimal divisor]
    (-> this (.divideToIntegralValue divisor))))

(defn strip-trailing-zeros
  "Returns a BigDecimal which is numerically equal to
   this one but with any trailing zeros removed from the
   representation.  For example, stripping the trailing zeros from
   the BigDecimal value 600.0, which has
   [BigInteger, scale] components equals to
   [6000, 1], yields 6E2 with [BigInteger,
   scale] components equals to [6, -2].  If
   this BigDecimal is numerically equal to zero, then
   BigDecimal.ZERO is returned.

  returns: a numerically equal BigDecimal with any
   trailing zeros removed. - `java.math.BigDecimal`"
  (^java.math.BigDecimal [^java.math.BigDecimal this]
    (-> this (.stripTrailingZeros))))

(defn int-value-exact
  "Converts this BigDecimal to an int, checking
   for lost information.  If this BigDecimal has a
   nonzero fractional part or is out of the possible range for an
   int result then an ArithmeticException is
   thrown.

  returns: this BigDecimal converted to an int. - `int`

  throws: java.lang.ArithmeticException - if this has a nonzero fractional part, or will not fit in an int."
  (^Integer [^java.math.BigDecimal this]
    (-> this (.intValueExact))))

(defn compare-to
  "Compares this BigDecimal with the specified
   BigDecimal.  Two BigDecimal objects that are
   equal in value but have a different scale (like 2.0 and 2.00)
   are considered equal by this method.  This method is provided
   in preference to individual methods for each of the six boolean
   comparison operators (<, ==,
   >, >=, !=, <=).  The
   suggested idiom for performing these comparisons is:
   (x.compareTo(y) <op> 0), where
   <op> is one of the six comparison operators.

  val - BigDecimal to which this BigDecimal is to be compared. - `java.math.BigDecimal`

  returns: -1, 0, or 1 as this BigDecimal is numerically
            less than, equal to, or greater than val. - `int`"
  (^Integer [^java.math.BigDecimal this ^java.math.BigDecimal val]
    (-> this (.compareTo val))))

(defn set-scale
  "Returns a BigDecimal whose scale is the specified
   value, and whose unscaled value is determined by multiplying or
   dividing this BigDecimal's unscaled value by the
   appropriate power of ten to maintain its overall value.  If the
   scale is reduced by the operation, the unscaled value must be
   divided (rather than multiplied), and the value may be changed;
   in this case, the specified rounding mode is applied to the
   division.

   Note that since BigDecimal objects are immutable, calls of
   this method do not result in the original object being
   modified, contrary to the usual convention of having methods
   named setX mutate field X.
   Instead, setScale returns an object with the proper
   scale; the returned object may or may not be newly allocated.

  new-scale - scale of the BigDecimal value to be returned. - `int`
  rounding-mode - The rounding mode to apply. - `java.math.RoundingMode`

  returns: a BigDecimal whose scale is the specified value,
           and whose unscaled value is determined by multiplying or
           dividing this BigDecimal's unscaled value by the
           appropriate power of ten to maintain its overall value. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if roundingMode==UNNECESSARY and the specified scaling operation would require rounding."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^Integer new-scale ^java.math.RoundingMode rounding-mode]
    (-> this (.setScale new-scale rounding-mode)))
  (^java.math.BigDecimal [^java.math.BigDecimal this ^Integer new-scale]
    (-> this (.setScale new-scale))))

(defn round
  "Returns a BigDecimal rounded according to the
   MathContext settings.  If the precision setting is 0 then
   no rounding takes place.

   The effect of this method is identical to that of the
   plus(MathContext) method.

  mc - the context to use. - `java.math.MathContext`

  returns: a BigDecimal rounded according to the
           MathContext settings. - `java.math.BigDecimal`

  throws: java.lang.ArithmeticException - if the rounding mode is UNNECESSARY and the BigDecimal operation would require rounding."
  (^java.math.BigDecimal [^java.math.BigDecimal this ^java.math.MathContext mc]
    (-> this (.round mc))))

(defn equals
  "Compares this BigDecimal with the specified
   Object for equality.  Unlike compareTo, this method considers two
   BigDecimal objects equal only if they are equal in
   value and scale (thus 2.0 is not equal to 2.00 when compared by
   this method).

  x - Object to which this BigDecimal is to be compared. - `java.lang.Object`

  returns: true if and only if the specified Object is a
           BigDecimal whose value and scale are equal to this
           BigDecimal's. - `boolean`"
  (^Boolean [^java.math.BigDecimal this ^java.lang.Object x]
    (-> this (.equals x))))

(defn signum
  "Returns the signum function of this BigDecimal.

  returns: -1, 0, or 1 as the value of this BigDecimal
           is negative, zero, or positive. - `int`"
  (^Integer [^java.math.BigDecimal this]
    (-> this (.signum))))

