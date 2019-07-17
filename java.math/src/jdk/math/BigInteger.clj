(ns jdk.math.BigInteger
  "Immutable arbitrary-precision integers.  All operations behave as if
  BigIntegers were represented in two's-complement notation (like Java's
  primitive integer types).  BigInteger provides analogues to all of Java's
  primitive integer operators, and all relevant methods from java.lang.Math.
  Additionally, BigInteger provides operations for modular arithmetic, GCD
  calculation, primality testing, prime generation, bit manipulation,
  and a few other miscellaneous operations.

  Semantics of arithmetic operations exactly mimic those of Java's integer
  arithmetic operators, as defined in The Java Language Specification.
  For example, division by zero throws an ArithmeticException, and
  division of a negative by a positive yields a negative (or zero) remainder.
  All of the details in the Spec concerning overflow are ignored, as
  BigIntegers are made as large as necessary to accommodate the results of an
  operation.

  Semantics of shift operations extend those of Java's shift operators
  to allow for negative shift distances.  A right-shift with a negative
  shift distance results in a left shift, and vice-versa.  The unsigned
  right shift operator (>>>) is omitted, as this operation makes
  little sense in combination with the `infinite word size` abstraction
  provided by this class.

  Semantics of bitwise logical operations exactly mimic those of Java's
  bitwise integer operators.  The binary operators (and,
  or, xor) implicitly perform sign extension on the shorter
  of the two operands prior to performing the operation.

  Comparison operations perform signed integer comparisons, analogous to
  those performed by Java's relational and equality operators.

  Modular arithmetic operations are provided to compute residues, perform
  exponentiation, and compute multiplicative inverses.  These methods always
  return a non-negative result, between 0 and (modulus - 1),
  inclusive.

  Bit operations operate on a single bit of the two's-complement
  representation of their operand.  If necessary, the operand is sign-
  extended so that it contains the designated bit.  None of the single-bit
  operations can produce a BigInteger with a different sign from the
  BigInteger being operated on, as they affect only a single bit, and the
  `infinite word size` abstraction provided by this class ensures that there
  are infinitely many `virtual sign bits` preceding each BigInteger.

  For the sake of brevity and clarity, pseudo-code is used throughout the
  descriptions of BigInteger methods.  The pseudo-code expression
  (i  j) is shorthand for `a BigInteger whose value is
  that of the BigInteger i plus that of the BigInteger j.`
  The pseudo-code expression (i == j) is shorthand for
  `true if and only if the BigInteger i represents the same
  value as the BigInteger j.`  Other pseudo-code expressions are
  interpreted similarly.

  All methods and constructors in this class throw
  NullPointerException when passed
  a null object reference for any input parameter.

  BigInteger must support values in the range
  -2Integer.MAX_VALUE (exclusive) to
  2Integer.MAX_VALUE (exclusive)
  and may support values outside of that range.

  The range of probable prime values is limited and may be less than
  the full supported positive range of BigInteger.
  The range must be at least 1 to 2500000000."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.math BigInteger]))

(defn ->big-integer
  "Constructor.

  Constructs a randomly generated positive BigInteger that is probably
   prime, with the specified bitLength.

   It is recommended that the probablePrime
   method be used in preference to this constructor unless there
   is a compelling need to specify a certainty.

  bit-length - bitLength of the returned BigInteger. - `int`
  certainty - a measure of the uncertainty that the caller is willing to tolerate. The probability that the new BigInteger represents a prime number will exceed (1 - 1/2certainty). The execution time of this constructor is proportional to the value of this parameter. - `int`
  rnd - source of random bits used to select candidates to be tested for primality. - `java.util.Random`

  throws: java.lang.ArithmeticException - bitLength < 2 or bitLength is too large."
  ([^Integer bit-length ^Integer certainty ^java.util.Random rnd]
    (new BigInteger bit-length certainty rnd))
  ([^Integer signum magnitude]
    (new BigInteger signum magnitude))
  ([val]
    (new BigInteger val)))

(def *-zero
  "Static Constant.

  The BigInteger constant zero.

  type: java.math.BigInteger"
  BigInteger/ZERO)

(def *-one
  "Static Constant.

  The BigInteger constant one.

  type: java.math.BigInteger"
  BigInteger/ONE)

(def *-ten
  "Static Constant.

  The BigInteger constant ten.

  type: java.math.BigInteger"
  BigInteger/TEN)

(defn *probable-prime
  "Returns a positive BigInteger that is probably prime, with the
   specified bitLength. The probability that a BigInteger returned
   by this method is composite does not exceed 2-100.

  bit-length - bitLength of the returned BigInteger. - `int`
  rnd - source of random bits used to select candidates to be tested for primality. - `java.util.Random`

  returns: a BigInteger of bitLength bits that is probably prime - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - bitLength < 2 or bitLength is too large."
  ([^Integer bit-length ^java.util.Random rnd]
    (BigInteger/probablePrime bit-length rnd)))

(defn *value-of
  "Returns a BigInteger whose value is equal to that of the
   specified long.  This `static factory method` is
   provided in preference to a (long) constructor
   because it allows for reuse of frequently used BigIntegers.

  val - value of the BigInteger to return. - `long`

  returns: a BigInteger with the specified value. - `java.math.BigInteger`"
  ([^Long val]
    (BigInteger/valueOf val)))

(defn bit-length
  "Returns the number of bits in the minimal two's-complement
   representation of this BigInteger, excluding a sign bit.
   For positive BigIntegers, this is equivalent to the number of bits in
   the ordinary binary representation.  (Computes
   (ceil(log2(this < 0 ? -this : this+1))).)

  returns: number of bits in the minimal two's-complement
           representation of this BigInteger, excluding a sign bit. - `int`"
  ([^java.math.BigInteger this]
    (-> this (.bitLength))))

(defn min
  "Returns the minimum of this BigInteger and val.

  val - value with which the minimum is to be computed. - `java.math.BigInteger`

  returns: the BigInteger whose value is the lesser of this BigInteger and
           val.  If they are equal, either may be returned. - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.min val))))

(defn test-bit
  "Returns true if and only if the designated bit is set.
   (Computes ((this & (1<<n)) != 0).)

  n - index of bit to test. - `int`

  returns: true if and only if the designated bit is set. - `boolean`

  throws: java.lang.ArithmeticException - n is negative."
  ([^java.math.BigInteger this ^Integer n]
    (-> this (.testBit n))))

(defn double-value
  "Converts this BigInteger to a double.  This
   conversion is similar to the
   narrowing primitive conversion from double to
   float as defined in section 5.1.3 of
   The Java™ Language Specification:
   if this BigInteger has too great a magnitude
   to represent as a double, it will be converted to
   Double.NEGATIVE_INFINITY or Double.POSITIVE_INFINITY as appropriate.  Note that even when
   the return value is finite, this conversion can lose
   information about the precision of the BigInteger value.

  returns: this BigInteger converted to a double. - `double`"
  ([^java.math.BigInteger this]
    (-> this (.doubleValue))))

(defn long-value
  "Converts this BigInteger to a long.  This
   conversion is analogous to a
   narrowing primitive conversion from long to
   int as defined in section 5.1.3 of
   The Java™ Language Specification:
   if this BigInteger is too big to fit in a
   long, only the low-order 64 bits are returned.
   Note that this conversion can lose information about the
   overall magnitude of the BigInteger value as well as return a
   result with the opposite sign.

  returns: this BigInteger converted to a long. - `long`"
  ([^java.math.BigInteger this]
    (-> this (.longValue))))

(defn multiply
  "Returns a BigInteger whose value is (this * val).

  val - value to be multiplied by this BigInteger. - `java.math.BigInteger`

  returns: this * val - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.multiply val))))

(defn not
  "Returns a BigInteger whose value is (~this).  (This method
   returns a negative value if and only if this BigInteger is
   non-negative.)

  returns: ~this - `java.math.BigInteger`"
  ([^java.math.BigInteger this]
    (-> this (.not))))

(defn shift-left
  "Returns a BigInteger whose value is (this << n).
   The shift distance, n, may be negative, in which case
   this method performs a right shift.
   (Computes floor(this * 2n).)

  n - shift distance, in bits. - `int`

  returns: this << n - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^Integer n]
    (-> this (.shiftLeft n))))

(defn negate
  "Returns a BigInteger whose value is (-this).

  returns: -this - `java.math.BigInteger`"
  ([^java.math.BigInteger this]
    (-> this (.negate))))

(defn long-value-exact
  "Converts this BigInteger to a long, checking
   for lost information.  If the value of this BigInteger
   is out of the range of the long type, then an
   ArithmeticException is thrown.

  returns: this BigInteger converted to a long. - `long`

  throws: java.lang.ArithmeticException - if the value of this will not exactly fit in a long."
  ([^java.math.BigInteger this]
    (-> this (.longValueExact))))

(defn next-probable-prime
  "Returns the first integer greater than this BigInteger that
   is probably prime.  The probability that the number returned by this
   method is composite does not exceed 2-100. This method will
   never skip over a prime when searching: if it returns p, there
   is no prime q such that this < q < p.

  returns: the first integer greater than this BigInteger that
           is probably prime. - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - this < 0 or this is too large."
  ([^java.math.BigInteger this]
    (-> this (.nextProbablePrime))))

(defn and-not
  "Returns a BigInteger whose value is (this & ~val).  This
   method, which is equivalent to and(val.not()), is provided as
   a convenience for masking operations.  (This method returns a negative
   BigInteger if and only if this is negative and val is
   positive.)

  val - value to be complemented and AND'ed with this BigInteger. - `java.math.BigInteger`

  returns: this & ~val - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.andNot val))))

(defn set-bit
  "Returns a BigInteger whose value is equivalent to this BigInteger
   with the designated bit set.  (Computes (this | (1<<n)).)

  n - index of bit to set. - `int`

  returns: this | (1<<n) - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - n is negative."
  ([^java.math.BigInteger this ^Integer n]
    (-> this (.setBit n))))

(defn max
  "Returns the maximum of this BigInteger and val.

  val - value with which the maximum is to be computed. - `java.math.BigInteger`

  returns: the BigInteger whose value is the greater of this and
           val.  If they are equal, either may be returned. - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.max val))))

(defn divide-and-remainder
  "Returns an array of two BigIntegers containing (this / val)
   followed by (this % val).

  val - value by which this BigInteger is to be divided, and the remainder computed. - `java.math.BigInteger`

  returns: an array of two BigIntegers: the quotient (this / val)
           is the initial element, and the remainder (this % val)
           is the final element. - `java.math.BigInteger[]`

  throws: java.lang.ArithmeticException - if val is zero."
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.divideAndRemainder val))))

(defn pow
  "Returns a BigInteger whose value is (thisexponent).
   Note that exponent is an integer rather than a BigInteger.

  exponent - exponent to which this BigInteger is to be raised. - `int`

  returns: thisexponent - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - exponent is negative. (This would cause the operation to yield a non-integer value.)"
  ([^java.math.BigInteger this ^Integer exponent]
    (-> this (.pow exponent))))

(defn to-string
  "Returns the String representation of this BigInteger in the
   given radix.  If the radix is outside the range from Character.MIN_RADIX to Character.MAX_RADIX inclusive,
   it will default to 10 (as is the case for
   Integer.toString).  The digit-to-character mapping
   provided by Character.forDigit is used, and a minus
   sign is prepended if appropriate.  (This representation is
   compatible with the (String,
   int) constructor.)

  radix - radix of the String representation. - `int`

  returns: String representation of this BigInteger in the given radix. - `java.lang.String`"
  ([^java.math.BigInteger this ^Integer radix]
    (-> this (.toString radix)))
  ([^java.math.BigInteger this]
    (-> this (.toString))))

(defn mod-inverse
  "Returns a BigInteger whose value is (this-1 mod m).

  m - the modulus. - `java.math.BigInteger`

  returns: this-1 mod m. - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - m ≤ 0, or this BigInteger has no multiplicative inverse mod m (that is, this BigInteger is not relatively prime to m)."
  ([^java.math.BigInteger this ^java.math.BigInteger m]
    (-> this (.modInverse m))))

(defn flip-bit
  "Returns a BigInteger whose value is equivalent to this BigInteger
   with the designated bit flipped.
   (Computes (this ^ (1<<n)).)

  n - index of bit to flip. - `int`

  returns: this ^ (1<<n) - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - n is negative."
  ([^java.math.BigInteger this ^Integer n]
    (-> this (.flipBit n))))

(defn gcd
  "Returns a BigInteger whose value is the greatest common divisor of
   abs(this) and abs(val).  Returns 0 if
   this == 0 && val == 0.

  val - value with which the GCD is to be computed. - `java.math.BigInteger`

  returns: GCD(abs(this), abs(val)) - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.gcd val))))

(defn float-value
  "Converts this BigInteger to a float.  This
   conversion is similar to the
   narrowing primitive conversion from double to
   float as defined in section 5.1.3 of
   The Java™ Language Specification:
   if this BigInteger has too great a magnitude
   to represent as a float, it will be converted to
   Float.NEGATIVE_INFINITY or Float.POSITIVE_INFINITY as appropriate.  Note that even when
   the return value is finite, this conversion can lose
   information about the precision of the BigInteger value.

  returns: this BigInteger converted to a float. - `float`"
  ([^java.math.BigInteger this]
    (-> this (.floatValue))))

(defn remainder
  "Returns a BigInteger whose value is (this % val).

  val - value by which this BigInteger is to be divided, and the remainder computed. - `java.math.BigInteger`

  returns: this % val - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - if val is zero."
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.remainder val))))

(defn subtract
  "Returns a BigInteger whose value is (this - val).

  val - value to be subtracted from this BigInteger. - `java.math.BigInteger`

  returns: this - val - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.subtract val))))

(defn or
  "Returns a BigInteger whose value is (this | val).  (This method
   returns a negative BigInteger if and only if either this or val is
   negative.)

  val - value to be OR'ed with this BigInteger. - `java.math.BigInteger`

  returns: this | val - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.or val))))

(defn byte-value-exact
  "Converts this BigInteger to a byte, checking
   for lost information.  If the value of this BigInteger
   is out of the range of the byte type, then an
   ArithmeticException is thrown.

  returns: this BigInteger converted to a byte. - `byte`

  throws: java.lang.ArithmeticException - if the value of this will not exactly fit in a byte."
  ([^java.math.BigInteger this]
    (-> this (.byteValueExact))))

(defn short-value-exact
  "Converts this BigInteger to a short, checking
   for lost information.  If the value of this BigInteger
   is out of the range of the short type, then an
   ArithmeticException is thrown.

  returns: this BigInteger converted to a short. - `short`

  throws: java.lang.ArithmeticException - if the value of this will not exactly fit in a short."
  ([^java.math.BigInteger this]
    (-> this (.shortValueExact))))

(defn bit-count
  "Returns the number of bits in the two's complement representation
   of this BigInteger that differ from its sign bit.  This method is
   useful when implementing bit-vector style sets atop BigIntegers.

  returns: number of bits in the two's complement representation
           of this BigInteger that differ from its sign bit. - `int`"
  ([^java.math.BigInteger this]
    (-> this (.bitCount))))

(defn and
  "Returns a BigInteger whose value is (this & val).  (This
   method returns a negative BigInteger if and only if this and val are
   both negative.)

  val - value to be AND'ed with this BigInteger. - `java.math.BigInteger`

  returns: this & val - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.and val))))

(defn mod
  "Returns a BigInteger whose value is (this mod m).  This method
   differs from remainder in that it always returns a
   non-negative BigInteger.

  m - the modulus. - `java.math.BigInteger`

  returns: this mod m - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - m ≤ 0"
  ([^java.math.BigInteger this ^java.math.BigInteger m]
    (-> this (.mod m))))

(defn abs
  "Returns a BigInteger whose value is the absolute value of this
   BigInteger.

  returns: abs(this) - `java.math.BigInteger`"
  ([^java.math.BigInteger this]
    (-> this (.abs))))

(defn int-value
  "Converts this BigInteger to an int.  This
   conversion is analogous to a
   narrowing primitive conversion from long to
   int as defined in section 5.1.3 of
   The Java™ Language Specification:
   if this BigInteger is too big to fit in an
   int, only the low-order 32 bits are returned.
   Note that this conversion can lose information about the
   overall magnitude of the BigInteger value as well as return a
   result with the opposite sign.

  returns: this BigInteger converted to an int. - `int`"
  ([^java.math.BigInteger this]
    (-> this (.intValue))))

(defn clear-bit
  "Returns a BigInteger whose value is equivalent to this BigInteger
   with the designated bit cleared.
   (Computes (this & ~(1<<n)).)

  n - index of bit to clear. - `int`

  returns: this & ~(1<<n) - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - n is negative."
  ([^java.math.BigInteger this ^Integer n]
    (-> this (.clearBit n))))

(defn divide
  "Returns a BigInteger whose value is (this / val).

  val - value by which this BigInteger is to be divided. - `java.math.BigInteger`

  returns: this / val - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - if val is zero."
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.divide val))))

(defn hash-code
  "Returns the hash code for this BigInteger.

  returns: hash code for this BigInteger. - `int`"
  ([^java.math.BigInteger this]
    (-> this (.hashCode))))

(defn mod-pow
  "Returns a BigInteger whose value is
   (thisexponent mod m).  (Unlike pow, this
   method permits negative exponents.)

  exponent - the exponent. - `java.math.BigInteger`
  m - the modulus. - `java.math.BigInteger`

  returns: thisexponent mod m - `java.math.BigInteger`

  throws: java.lang.ArithmeticException - m ≤ 0 or the exponent is negative and this BigInteger is not relatively prime to m."
  ([^java.math.BigInteger this ^java.math.BigInteger exponent ^java.math.BigInteger m]
    (-> this (.modPow exponent m))))

(defn add
  "Returns a BigInteger whose value is (this  val).

  val - value to be added to this BigInteger. - `java.math.BigInteger`

  returns: this  val - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.add val))))

(defn get-lowest-set-bit
  "Returns the index of the rightmost (lowest-order) one bit in this
   BigInteger (the number of zero bits to the right of the rightmost
   one bit).  Returns -1 if this BigInteger contains no one bits.
   (Computes (this == 0? -1 : log2(this & -this)).)

  returns: index of the rightmost one bit in this BigInteger. - `int`"
  ([^java.math.BigInteger this]
    (-> this (.getLowestSetBit))))

(defn int-value-exact
  "Converts this BigInteger to an int, checking
   for lost information.  If the value of this BigInteger
   is out of the range of the int type, then an
   ArithmeticException is thrown.

  returns: this BigInteger converted to an int. - `int`

  throws: java.lang.ArithmeticException - if the value of this will not exactly fit in a int."
  ([^java.math.BigInteger this]
    (-> this (.intValueExact))))

(defn compare-to
  "Compares this BigInteger with the specified BigInteger.  This
   method is provided in preference to individual methods for each
   of the six boolean comparison operators (<, ==,
   >, >=, !=, <=).  The suggested
   idiom for performing these comparisons is: (x.compareTo(y) <op> 0), where
   <op> is one of the six comparison operators.

  val - BigInteger to which this BigInteger is to be compared. - `java.math.BigInteger`

  returns: -1, 0 or 1 as this BigInteger is numerically less than, equal
           to, or greater than val. - `int`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.compareTo val))))

(defn shift-right
  "Returns a BigInteger whose value is (this >> n).  Sign
   extension is performed.  The shift distance, n, may be
   negative, in which case this method performs a left shift.
   (Computes floor(this / 2n).)

  n - shift distance, in bits. - `int`

  returns: this >> n - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^Integer n]
    (-> this (.shiftRight n))))

(defn to-byte-array
  "Returns a byte array containing the two's-complement
   representation of this BigInteger.  The byte array will be in
   big-endian byte-order: the most significant byte is in
   the zeroth element.  The array will contain the minimum number
   of bytes required to represent this BigInteger, including at
   least one sign bit, which is (ceil((this.bitLength()
   1)/8)).  (This representation is compatible with the
   (byte[]) constructor.)

  returns: a byte array containing the two's-complement representation of
           this BigInteger. - `byte[]`"
  ([^java.math.BigInteger this]
    (-> this (.toByteArray))))

(defn equals
  "Compares this BigInteger with the specified Object for equality.

  x - Object to which this BigInteger is to be compared. - `java.lang.Object`

  returns: true if and only if the specified Object is a
           BigInteger whose value is numerically equal to this BigInteger. - `boolean`"
  ([^java.math.BigInteger this ^java.lang.Object x]
    (-> this (.equals x))))

(defn xor
  "Returns a BigInteger whose value is (this ^ val).  (This method
   returns a negative BigInteger if and only if exactly one of this and
   val are negative.)

  val - value to be XOR'ed with this BigInteger. - `java.math.BigInteger`

  returns: this ^ val - `java.math.BigInteger`"
  ([^java.math.BigInteger this ^java.math.BigInteger val]
    (-> this (.xor val))))

(defn probable-prime?
  "Returns true if this BigInteger is probably prime,
   false if it's definitely composite.  If
   certainty is ≤ 0, true is
   returned.

  certainty - a measure of the uncertainty that the caller is willing to tolerate: if the call returns true the probability that this BigInteger is prime exceeds (1 - 1/2certainty). The execution time of this method is proportional to the value of this parameter. - `int`

  returns: true if this BigInteger is probably prime,
           false if it's definitely composite. - `boolean`"
  ([^java.math.BigInteger this ^Integer certainty]
    (-> this (.isProbablePrime certainty))))

(defn signum
  "Returns the signum function of this BigInteger.

  returns: -1, 0 or 1 as the value of this BigInteger is negative, zero or
           positive. - `int`"
  ([^java.math.BigInteger this]
    (-> this (.signum))))

