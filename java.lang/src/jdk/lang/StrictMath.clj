(ns jdk.lang.StrictMath
  "The class StrictMath contains methods for performing basic
  numeric operations such as the elementary exponential, logarithm,
  square root, and trigonometric functions.

  To help ensure portability of Java programs, the definitions of
  some of the numeric functions in this package require that they
  produce the same results as certain published algorithms. These
  algorithms are available from the well-known network library
  netlib as the package `Freely Distributable Math
  Library,` fdlibm. These
  algorithms, which are written in the C programming language, are
  then to be understood as executed with all floating-point
  operations following the rules of Java floating-point arithmetic.

  The Java math library is defined with respect to
  fdlibm version 5.3. Where fdlibm provides
  more than one definition for a function (such as
  acos), use the `IEEE 754 core function` version
  (residing in a file whose name begins with the letter
  e).  The methods which require fdlibm
  semantics are sin, cos, tan,
  asin, acos, atan,
  exp, log, log10,
  cbrt, atan2, pow,
  sinh, cosh, tanh,
  hypot, expm1, and log1p.


  The platform uses signed two's complement integer arithmetic with
  int and long primitive types.  The developer should choose
  the primitive type to ensure that arithmetic operations consistently
  produce correct results, which in some cases means the operations
  will not overflow the range of values of the computation.
  The best practice is to choose the primitive type and algorithm to avoid
  overflow. In cases where the size is int or long and
  overflow errors need to be detected, the methods addExact,
  subtractExact, multiplyExact, and toIntExact
  throw an ArithmeticException when the results overflow.
  For other arithmetic operations such as divide, absolute value,
  increment, decrement, and negation overflow occurs only with
  a specific minimum or maximum value and should be checked against
  the minimum or maximum as appropriate."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang StrictMath]))

(def *-e
  "Static Constant.

  The double value that is closer than any other to
   e, the base of the natural logarithms.

  type: double"
  StrictMath/E)

(def *-pi
  "Static Constant.

  The double value that is closer than any other to
   pi, the ratio of the circumference of a circle to its
   diameter.

  type: double"
  StrictMath/PI)

(defn *floor
  "Returns the largest (closest to positive infinity)
   double value that is less than or equal to the
   argument and is equal to a mathematical integer. Special cases:
   If the argument value is already equal to a
   mathematical integer, then the result is the same as the
   argument.  If the argument is NaN or an infinity or
   positive zero or negative zero, then the result is the same as
   the argument.

  a - a value. - `double`

  returns: the largest (closest to positive infinity)
            floating-point value that less than or equal to the argument
            and is equal to a mathematical integer. - `double`"
  ([^Double a]
    (StrictMath/floor a)))

(defn *log-1p
  "Returns the natural logarithm of the sum of the argument and 1.
   Note that for small values x, the result of
   log1p(x) is much closer to the true result of ln(1
    x) than the floating-point evaluation of
   log(1.0+x).

   Special cases:


   If the argument is NaN or less than -1, then the result is
   NaN.

   If the argument is positive infinity, then the result is
   positive infinity.

   If the argument is negative one, then the result is
   negative infinity.

   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  x - a value - `double`

  returns: the value ln(x  1), the natural
   log of x  1 - `double`"
  ([^Double x]
    (StrictMath/log1p x)))

(defn *ceil
  "Returns the smallest (closest to negative infinity)
   double value that is greater than or equal to the
   argument and is equal to a mathematical integer. Special cases:
   If the argument value is already equal to a
   mathematical integer, then the result is the same as the
   argument.  If the argument is NaN or an infinity or
   positive zero or negative zero, then the result is the same as
   the argument.  If the argument value is less than zero but
   greater than -1.0, then the result is negative zero. Note
   that the value of StrictMath.ceil(x) is exactly the
   value of -StrictMath.floor(-x).

  a - a value. - `double`

  returns: the smallest (closest to negative infinity)
            floating-point value that is greater than or equal to
            the argument and is equal to a mathematical integer. - `double`"
  ([^Double a]
    (StrictMath/ceil a)))

(defn *ulp
  "Returns the size of an ulp of the argument.  An ulp, unit in
   the last place, of a double value is the positive
   distance between this floating-point value and the double value next larger in magnitude.  Note that for non-NaN
   x, ulp(-x) == ulp(x).

   Special Cases:

    If the argument is NaN, then the result is NaN.
    If the argument is positive or negative infinity, then the
   result is positive infinity.
    If the argument is positive or negative zero, then the result is
   Double.MIN_VALUE.
    If the argument is ±Double.MAX_VALUE, then
   the result is equal to 2971.

  d - the floating-point value whose ulp is to be returned - `double`

  returns: the size of an ulp of the argument - `double`"
  ([^Double d]
    (StrictMath/ulp d)))

(defn *multiply-exact
  "Returns the product of the arguments,
   throwing an exception if the result overflows an int.

  x - the first value - `int`
  y - the second value - `int`

  returns: the result - `int`

  throws: java.lang.ArithmeticException - if the result overflows an int"
  ([^Integer x ^Integer y]
    (StrictMath/multiplyExact x y)))

(defn *next-down
  "Returns the floating-point value adjacent to d in
   the direction of negative infinity.  This method is
   semantically equivalent to nextAfter(d,
   Double.NEGATIVE_INFINITY); however, a
   nextDown implementation may run faster than its
   equivalent nextAfter call.

   Special Cases:

    If the argument is NaN, the result is NaN.

    If the argument is negative infinity, the result is
   negative infinity.

    If the argument is zero, the result is
   -Double.MIN_VALUE

  d - starting floating-point value - `double`

  returns: The adjacent floating-point value closer to negative
   infinity. - `double`"
  ([^Double d]
    (StrictMath/nextDown d)))

(defn *random
  "Returns a double value with a positive sign, greater
   than or equal to 0.0 and less than 1.0.
   Returned values are chosen pseudorandomly with (approximately)
   uniform distribution from that range.

   When this method is first called, it creates a single new
   pseudorandom-number generator, exactly as if by the expression

   new java.util.Random()

   This new pseudorandom-number generator is used thereafter for
   all calls to this method and is used nowhere else.

   This method is properly synchronized to allow correct use by
   more than one thread. However, if many threads need to generate
   pseudorandom numbers at a great rate, it may reduce contention
   for each thread to have its own pseudorandom-number generator.

  returns: a pseudorandom double greater than or equal
   to 0.0 and less than 1.0. - `double`"
  ([]
    (StrictMath/random )))

(defn *cosh
  "Returns the hyperbolic cosine of a double value.
   The hyperbolic cosine of x is defined to be
   (ex  e-x)/2
   where e is Euler's number.

   Special cases:


   If the argument is NaN, then the result is NaN.

   If the argument is infinite, then the result is positive
   infinity.

   If the argument is zero, then the result is 1.0.

  x - The number whose hyperbolic cosine is to be returned. - `double`

  returns: The hyperbolic cosine of x. - `double`"
  ([^Double x]
    (StrictMath/cosh x)))

(defn *min
  "Returns the smaller of two int values. That is,
   the result the argument closer to the value of
   Integer.MIN_VALUE.  If the arguments have the same
   value, the result is that same value.

  a - an argument. - `int`
  b - another argument. - `int`

  returns: the smaller of a and b. - `int`"
  ([^Integer a ^Integer b]
    (StrictMath/min a b)))

(defn *atan-2
  "Returns the angle theta from the conversion of rectangular
   coordinates (x, y) to polar
   coordinates (r, theta).
   This method computes the phase theta by computing an arc tangent
   of y/x in the range of -pi to pi. Special
   cases:
   If either argument is NaN, then the result is NaN.
   If the first argument is positive zero and the second argument
   is positive, or the first argument is positive and finite and the
   second argument is positive infinity, then the result is positive
   zero.
   If the first argument is negative zero and the second argument
   is positive, or the first argument is negative and finite and the
   second argument is positive infinity, then the result is negative zero.
   If the first argument is positive zero and the second argument
   is negative, or the first argument is positive and finite and the
   second argument is negative infinity, then the result is the
   double value closest to pi.
   If the first argument is negative zero and the second argument
   is negative, or the first argument is negative and finite and the
   second argument is negative infinity, then the result is the
   double value closest to -pi.
   If the first argument is positive and the second argument is
   positive zero or negative zero, or the first argument is positive
   infinity and the second argument is finite, then the result is the
   double value closest to pi/2.
   If the first argument is negative and the second argument is
   positive zero or negative zero, or the first argument is negative
   infinity and the second argument is finite, then the result is the
   double value closest to -pi/2.
   If both arguments are positive infinity, then the result is the
   double value closest to pi/4.
   If the first argument is positive infinity and the second argument
   is negative infinity, then the result is the double
   value closest to 3*pi/4.
   If the first argument is negative infinity and the second argument
   is positive infinity, then the result is the double value
   closest to -pi/4.
   If both arguments are negative infinity, then the result is the
   double value closest to -3*pi/4.

  y - the ordinate coordinate - `double`
  x - the abscissa coordinate - `double`

  returns: the theta component of the point
            (r, theta)
            in polar coordinates that corresponds to the point
            (x, y) in Cartesian coordinates. - `double`"
  ([^Double y ^Double x]
    (StrictMath/atan2 y x)))

(defn *add-exact
  "Returns the sum of its arguments,
   throwing an exception if the result overflows an int.

  x - the first value - `int`
  y - the second value - `int`

  returns: the result - `int`

  throws: java.lang.ArithmeticException - if the result overflows an int"
  ([^Integer x ^Integer y]
    (StrictMath/addExact x y)))

(defn *cbrt
  "Returns the cube root of a double value.  For
   positive finite x, cbrt(-x) ==
   -cbrt(x); that is, the cube root of a negative value is
   the negative of the cube root of that value's magnitude.
   Special cases:



   If the argument is NaN, then the result is NaN.

   If the argument is infinite, then the result is an infinity
   with the same sign as the argument.

   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  a - a value. - `double`

  returns: the cube root of a. - `double`"
  ([^Double a]
    (StrictMath/cbrt a)))

(defn *get-exponent
  "Returns the unbiased exponent used in the representation of a
   float.  Special cases:


   If the argument is NaN or infinite, then the result is
   Float.MAX_EXPONENT  1.
   If the argument is zero or subnormal, then the result is
   Float.MIN_EXPONENT -1.

  f - a float value - `float`

  returns: the unbiased exponent of the argument - `int`"
  ([^Float f]
    (StrictMath/getExponent f)))

(defn *max
  "Returns the greater of two int values. That is, the
   result is the argument closer to the value of
   Integer.MAX_VALUE. If the arguments have the same value,
   the result is that same value.

  a - an argument. - `int`
  b - another argument. - `int`

  returns: the larger of a and b. - `int`"
  ([^Integer a ^Integer b]
    (StrictMath/max a b)))

(defn *floor-div
  "Returns the largest (closest to positive infinity)
   int value that is less than or equal to the algebraic quotient.
   There is one special case, if the dividend is the
   Integer.MIN_VALUE and the divisor is -1,
   then integer overflow occurs and
   the result is equal to the Integer.MIN_VALUE.

   See Math.floorDiv for examples and
   a comparison to the integer division / operator.

  x - the dividend - `int`
  y - the divisor - `int`

  returns: the largest (closest to positive infinity)
   int value that is less than or equal to the algebraic quotient. - `int`

  throws: java.lang.ArithmeticException - if the divisor y is zero"
  ([^Integer x ^Integer y]
    (StrictMath/floorDiv x y)))

(defn *pow
  "Returns the value of the first argument raised to the power of the
   second argument. Special cases:

   If the second argument is positive or negative zero, then the
   result is 1.0.
   If the second argument is 1.0, then the result is the same as the
   first argument.
   If the second argument is NaN, then the result is NaN.
   If the first argument is NaN and the second argument is nonzero,
   then the result is NaN.

   If

   the absolute value of the first argument is greater than 1
   and the second argument is positive infinity, or
   the absolute value of the first argument is less than 1 and
   the second argument is negative infinity,

   then the result is positive infinity.

   If

   the absolute value of the first argument is greater than 1 and
   the second argument is negative infinity, or
   the absolute value of the
   first argument is less than 1 and the second argument is positive
   infinity,

   then the result is positive zero.

   If the absolute value of the first argument equals 1 and the
   second argument is infinite, then the result is NaN.

   If

   the first argument is positive zero and the second argument
   is greater than zero, or
   the first argument is positive infinity and the second
   argument is less than zero,

   then the result is positive zero.

   If

   the first argument is positive zero and the second argument
   is less than zero, or
   the first argument is positive infinity and the second
   argument is greater than zero,

   then the result is positive infinity.

   If

   the first argument is negative zero and the second argument
   is greater than zero but not a finite odd integer, or
   the first argument is negative infinity and the second
   argument is less than zero but not a finite odd integer,

   then the result is positive zero.

   If

   the first argument is negative zero and the second argument
   is a positive finite odd integer, or
   the first argument is negative infinity and the second
   argument is a negative finite odd integer,

   then the result is negative zero.

   If

   the first argument is negative zero and the second argument
   is less than zero but not a finite odd integer, or
   the first argument is negative infinity and the second
   argument is greater than zero but not a finite odd integer,

   then the result is positive infinity.

   If

   the first argument is negative zero and the second argument
   is a negative finite odd integer, or
   the first argument is negative infinity and the second
   argument is a positive finite odd integer,

   then the result is negative infinity.

   If the first argument is finite and less than zero

    if the second argument is a finite even integer, the
   result is equal to the result of raising the absolute value of
   the first argument to the power of the second argument

   if the second argument is a finite odd integer, the result
   is equal to the negative of the result of raising the absolute
   value of the first argument to the power of the second
   argument

   if the second argument is finite and not an integer, then
   the result is NaN.


   If both arguments are integers, then the result is exactly equal
   to the mathematical result of raising the first argument to the power
   of the second argument if that result can in fact be represented
   exactly as a double value.

   (In the foregoing descriptions, a floating-point value is
   considered to be an integer if and only if it is finite and a
   fixed point of the method ceil or,
   equivalently, a fixed point of the method floor. A value is a fixed point of a one-argument
   method if and only if the result of applying the method to the
   value is equal to the value.)

  a - base. - `double`
  b - the exponent. - `double`

  returns: the value ab. - `double`"
  ([^Double a ^Double b]
    (StrictMath/pow a b)))

(defn *copy-sign
  "Returns the first floating-point argument with the sign of the
   second floating-point argument.  For this method, a NaN
   sign argument is always treated as if it were
   positive.

  magnitude - the parameter providing the magnitude of the result - `double`
  sign - the parameter providing the sign of the result - `double`

  returns: a value with the magnitude of magnitude
   and the sign of sign. - `double`"
  ([^Double magnitude ^Double sign]
    (StrictMath/copySign magnitude sign)))

(defn *atan
  "Returns the arc tangent of a value; the returned angle is in the
   range -pi/2 through pi/2.  Special cases:
   If the argument is NaN, then the result is NaN.
   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  a - the value whose arc tangent is to be returned. - `double`

  returns: the arc tangent of the argument. - `double`"
  ([^Double a]
    (StrictMath/atan a)))

(defn *next-up
  "Returns the floating-point value adjacent to d in
   the direction of positive infinity.  This method is
   semantically equivalent to nextAfter(d,
   Double.POSITIVE_INFINITY); however, a nextUp
   implementation may run faster than its equivalent
   nextAfter call.

   Special Cases:

    If the argument is NaN, the result is NaN.

    If the argument is positive infinity, the result is
   positive infinity.

    If the argument is zero, the result is
   Double.MIN_VALUE

  d - starting floating-point value - `double`

  returns: The adjacent floating-point value closer to positive
   infinity. - `double`"
  ([^Double d]
    (StrictMath/nextUp d)))

(defn *log
  "Returns the natural logarithm (base e) of a double
   value. Special cases:
   If the argument is NaN or less than zero, then the result
   is NaN.
   If the argument is positive infinity, then the result is
   positive infinity.
   If the argument is positive zero or negative zero, then the
   result is negative infinity.

  a - a value - `double`

  returns: the value ln a, the natural logarithm of
            a. - `double`"
  ([^Double a]
    (StrictMath/log a)))

(defn *to-degrees
  "Converts an angle measured in radians to an approximately
   equivalent angle measured in degrees.  The conversion from
   radians to degrees is generally inexact; users should
   not expect cos(toRadians(90.0)) to exactly
   equal 0.0.

  angrad - an angle, in radians - `double`

  returns: the measurement of the angle angrad
            in degrees. - `double`"
  ([^Double angrad]
    (StrictMath/toDegrees angrad)))

(defn *sin
  "Returns the trigonometric sine of an angle. Special cases:
   If the argument is NaN or an infinity, then the
   result is NaN.
   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  a - an angle, in radians. - `double`

  returns: the sine of the argument. - `double`"
  ([^Double a]
    (StrictMath/sin a)))

(defn *scalb
  "Returns d ×
   2scaleFactor rounded as if performed
   by a single correctly rounded floating-point multiply to a
   member of the double value set.  See the Java
   Language Specification for a discussion of floating-point
   value sets.  If the exponent of the result is between Double.MIN_EXPONENT and Double.MAX_EXPONENT, the
   answer is calculated exactly.  If the exponent of the result
   would be larger than Double.MAX_EXPONENT, an
   infinity is returned.  Note that if the result is subnormal,
   precision may be lost; that is, when scalb(x, n)
   is subnormal, scalb(scalb(x, n), -n) may not equal
   x.  When the result is non-NaN, the result has the same
   sign as d.

   Special cases:

    If the first argument is NaN, NaN is returned.
    If the first argument is infinite, then an infinity of the
   same sign is returned.
    If the first argument is zero, then a zero of the same
   sign is returned.

  d - number to be scaled by a power of two. - `double`
  scale-factor - power of 2 used to scale d - `int`

  returns: d × 2scaleFactor - `double`"
  ([^Double d ^Integer scale-factor]
    (StrictMath/scalb d scale-factor)))

(defn *hypot
  "Returns sqrt(x2 y2)
   without intermediate overflow or underflow.

   Special cases:


    If either argument is infinite, then the result
   is positive infinity.

    If either argument is NaN and neither argument is infinite,
   then the result is NaN.

  x - a value - `double`
  y - a value - `double`

  returns: sqrt(x2 y2)
   without intermediate overflow or underflow - `double`"
  ([^Double x ^Double y]
    (StrictMath/hypot x y)))

(defn *exp
  "Returns Euler's number e raised to the power of a
   double value. Special cases:
   If the argument is NaN, the result is NaN.
   If the argument is positive infinity, then the result is
   positive infinity.
   If the argument is negative infinity, then the result is
   positive zero.

  a - the exponent to raise e to. - `double`

  returns: the value ea,
            where e is the base of the natural logarithms. - `double`"
  ([^Double a]
    (StrictMath/exp a)))

(defn *log-10
  "Returns the base 10 logarithm of a double value.
   Special cases:

   If the argument is NaN or less than zero, then the result
   is NaN.
   If the argument is positive infinity, then the result is
   positive infinity.
   If the argument is positive zero or negative zero, then the
   result is negative infinity.
    If the argument is equal to 10n for
   integer n, then the result is n.

  a - a value - `double`

  returns: the base 10 logarithm of  a. - `double`"
  ([^Double a]
    (StrictMath/log10 a)))

(defn *sqrt
  "Returns the correctly rounded positive square root of a
   double value.
   Special cases:
   If the argument is NaN or less than zero, then the result
   is NaN.
   If the argument is positive infinity, then the result is positive
   infinity.
   If the argument is positive zero or negative zero, then the
   result is the same as the argument.
   Otherwise, the result is the double value closest to
   the true mathematical square root of the argument value.

  a - a value. - `double`

  returns: the positive square root of a. - `double`"
  ([^Double a]
    (StrictMath/sqrt a)))

(defn *floor-mod
  "Returns the floor modulus of the int arguments.

   The floor modulus is x - (floorDiv(x, y) * y),
   has the same sign as the divisor y, and
   is in the range of -abs(y) < r < abs(y).

   The relationship between floorDiv and floorMod is such that:

     floorDiv(x, y) * y  floorMod(x, y) == x


   See Math.floorMod for examples and
   a comparison to the % operator.

  x - the dividend - `int`
  y - the divisor - `int`

  returns: the floor modulus x - (floorDiv(x, y) * y) - `int`

  throws: java.lang.ArithmeticException - if the divisor y is zero"
  ([^Integer x ^Integer y]
    (StrictMath/floorMod x y)))

(defn *tan
  "Returns the trigonometric tangent of an angle. Special cases:
   If the argument is NaN or an infinity, then the result
   is NaN.
   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  a - an angle, in radians. - `double`

  returns: the tangent of the argument. - `double`"
  ([^Double a]
    (StrictMath/tan a)))

(defn *cos
  "Returns the trigonometric cosine of an angle. Special cases:
   If the argument is NaN or an infinity, then the
   result is NaN.

  a - an angle, in radians. - `double`

  returns: the cosine of the argument. - `double`"
  ([^Double a]
    (StrictMath/cos a)))

(defn *subtract-exact
  "Returns the difference of the arguments,
   throwing an exception if the result overflows an int.

  x - the first value - `int`
  y - the second value to subtract from the first - `int`

  returns: the result - `int`

  throws: java.lang.ArithmeticException - if the result overflows an int"
  ([^Integer x ^Integer y]
    (StrictMath/subtractExact x y)))

(defn *abs
  "Returns the absolute value of an int value.
   If the argument is not negative, the argument is returned.
   If the argument is negative, the negation of the argument is returned.

   Note that if the argument is equal to the value of
   Integer.MIN_VALUE, the most negative representable
   int value, the result is that same value, which is
   negative.

  a - the argument whose absolute value is to be determined. - `int`

  returns: the absolute value of the argument. - `int`"
  ([^Integer a]
    (StrictMath/abs a)))

(defn *expm-1
  "Returns ex -1.  Note that for values of
   x near 0, the exact sum of
   expm1(x)  1 is much closer to the true
   result of ex than exp(x).

   Special cases:

   If the argument is NaN, the result is NaN.

   If the argument is positive infinity, then the result is
   positive infinity.

   If the argument is negative infinity, then the result is
   -1.0.

   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  x - the exponent to raise e to in the computation of ex -1. - `double`

  returns: the value ex - 1. - `double`"
  ([^Double x]
    (StrictMath/expm1 x)))

(defn *next-after
  "Returns the floating-point number adjacent to the first
   argument in the direction of the second argument.  If both
   arguments compare as equal the second argument is returned.

   Special cases:

    If either argument is a NaN, then NaN is returned.

    If both arguments are signed zeros, direction
   is returned unchanged (as implied by the requirement of
   returning the second argument if the arguments compare as
   equal).

    If start is
   ±Double.MIN_VALUE and direction
   has a value such that the result should have a smaller
   magnitude, then a zero with the same sign as start
   is returned.

    If start is infinite and
   direction has a value such that the result should
   have a smaller magnitude, Double.MAX_VALUE with the
   same sign as start is returned.

    If start is equal to ±
   Double.MAX_VALUE and direction has a
   value such that the result should have a larger magnitude, an
   infinity with same sign as start is returned.

  start - starting floating-point value - `double`
  direction - value indicating which of start's neighbors or start should be returned - `double`

  returns: The floating-point number adjacent to start in the
   direction of direction. - `double`"
  ([^Double start ^Double direction]
    (StrictMath/nextAfter start direction)))

(defn *to-int-exact
  "Returns the value of the long argument;
   throwing an exception if the value overflows an int.

  value - the long value - `long`

  returns: the argument as an int - `int`

  throws: java.lang.ArithmeticException - if the argument overflows an int"
  ([^Long value]
    (StrictMath/toIntExact value)))

(defn *iee-eremainder
  "Computes the remainder operation on two arguments as prescribed
   by the IEEE 754 standard.
   The remainder value is mathematically equal to
   f1 - f2 × n,
   where n is the mathematical integer closest to the exact
   mathematical value of the quotient f1/f2, and if two
   mathematical integers are equally close to f1/f2,
   then n is the integer that is even. If the remainder is
   zero, its sign is the same as the sign of the first argument.
   Special cases:
   If either argument is NaN, or the first argument is infinite,
   or the second argument is positive zero or negative zero, then the
   result is NaN.
   If the first argument is finite and the second argument is
   infinite, then the result is the same as the first argument.

  f-1 - the dividend. - `double`
  f-2 - the divisor. - `double`

  returns: the remainder when f1 is divided by
            f2. - `double`"
  ([^Double f-1 ^Double f-2]
    (StrictMath/IEEEremainder f-1 f-2)))

(defn *sinh
  "Returns the hyperbolic sine of a double value.
   The hyperbolic sine of x is defined to be
   (ex - e-x)/2
   where e is Euler's number.

   Special cases:


   If the argument is NaN, then the result is NaN.

   If the argument is infinite, then the result is an infinity
   with the same sign as the argument.

   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  x - The number whose hyperbolic sine is to be returned. - `double`

  returns: The hyperbolic sine of x. - `double`"
  ([^Double x]
    (StrictMath/sinh x)))

(defn *round
  "Returns the closest int to the argument, with ties
   rounding to positive infinity.

   Special cases:
   If the argument is NaN, the result is 0.
   If the argument is negative infinity or any value less than or
   equal to the value of Integer.MIN_VALUE, the result is
   equal to the value of Integer.MIN_VALUE.
   If the argument is positive infinity or any value greater than or
   equal to the value of Integer.MAX_VALUE, the result is
   equal to the value of Integer.MAX_VALUE.

  a - a floating-point value to be rounded to an integer. - `float`

  returns: the value of the argument rounded to the nearest
            int value. - `int`"
  ([^Float a]
    (StrictMath/round a)))

(defn *asin
  "Returns the arc sine of a value; the returned angle is in the
   range -pi/2 through pi/2.  Special cases:
   If the argument is NaN or its absolute value is greater
   than 1, then the result is NaN.
   If the argument is zero, then the result is a zero with the
   same sign as the argument.

  a - the value whose arc sine is to be returned. - `double`

  returns: the arc sine of the argument. - `double`"
  ([^Double a]
    (StrictMath/asin a)))

(defn *tanh
  "Returns the hyperbolic tangent of a double value.
   The hyperbolic tangent of x is defined to be
   (ex - e-x)/(ex  e-x),
   in other words, sinh(x)/cosh(x).  Note
   that the absolute value of the exact tanh is always less than
   1.

   Special cases:


   If the argument is NaN, then the result is NaN.

   If the argument is zero, then the result is a zero with the
   same sign as the argument.

   If the argument is positive infinity, then the result is
   +1.0.

   If the argument is negative infinity, then the result is
   -1.0.

  x - The number whose hyperbolic tangent is to be returned. - `double`

  returns: The hyperbolic tangent of x. - `double`"
  ([^Double x]
    (StrictMath/tanh x)))

(defn *to-radians
  "Converts an angle measured in degrees to an approximately
   equivalent angle measured in radians.  The conversion from
   degrees to radians is generally inexact.

  angdeg - an angle, in degrees - `double`

  returns: the measurement of the angle angdeg
            in radians. - `double`"
  ([^Double angdeg]
    (StrictMath/toRadians angdeg)))

(defn *rint
  "Returns the double value that is closest in value
   to the argument and is equal to a mathematical integer. If two
   double values that are mathematical integers are
   equally close to the value of the argument, the result is the
   integer value that is even. Special cases:
   If the argument value is already equal to a mathematical
   integer, then the result is the same as the argument.
   If the argument is NaN or an infinity or positive zero or negative
   zero, then the result is the same as the argument.

  a - a value. - `double`

  returns: the closest floating-point value to a that is
            equal to a mathematical integer. - `double`"
  ([^Double a]
    (StrictMath/rint a)))

(defn *signum
  "Returns the signum function of the argument; zero if the argument
   is zero, 1.0 if the argument is greater than zero, -1.0 if the
   argument is less than zero.

   Special Cases:

    If the argument is NaN, then the result is NaN.
    If the argument is positive zero or negative zero, then the
        result is the same as the argument.

  d - the floating-point value whose signum is to be returned - `double`

  returns: the signum function of the argument - `double`"
  ([^Double d]
    (StrictMath/signum d)))

(defn *acos
  "Returns the arc cosine of a value; the returned angle is in the
   range 0.0 through pi.  Special case:
   If the argument is NaN or its absolute value is greater
   than 1, then the result is NaN.

  a - the value whose arc cosine is to be returned. - `double`

  returns: the arc cosine of the argument. - `double`"
  ([^Double a]
    (StrictMath/acos a)))

