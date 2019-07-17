(ns jdk.lang.Integer
  "The Integer class wraps a value of the primitive type
  int in an object. An object of type Integer
  contains a single field whose type is int.

  In addition, this class provides several methods for converting
  an int to a String and a String to an
  int, as well as other constants and methods useful when
  dealing with an int.

  Implementation note: The implementations of the `bit twiddling`
  methods (such as highestOneBit and
  numberOfTrailingZeros) are
  based on material from Henry S. Warren, Jr.'s Hacker's
  Delight, (Addison Wesley, 2002)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Integer]))

(defn ->integer
  "Constructor.

  Constructs a newly allocated Integer object that
   represents the specified int value.

  value - the value to be represented by the Integer object. - `int`"
  ([value]
    (new Integer value)))

(def *-min-value
  "Static Constant.

  A constant holding the minimum value an int can
   have, -231.

  type: java.lang.annotation.    int"
  Integer/MIN_VALUE)

(def *-max-value
  "Static Constant.

  A constant holding the maximum value an int can
   have, 231-1.

  type: java.lang.annotation.    int"
  Integer/MAX_VALUE)

(def *-type
  "Static Constant.

  The Class instance representing the primitive type
   int.

  type: java.lang.Class<java.lang.Integer>"
  Integer/TYPE)

(def *-size
  "Static Constant.

  The number of bits used to represent an int value in two's
   complement binary form.

  type: java.lang.annotation.    int"
  Integer/SIZE)

(def *-bytes
  "Static Constant.

  The number of bytes used to represent a int value in two's
   complement binary form.

  type: int"
  Integer/BYTES)

(defn *compare
  "Compares two int values numerically.
   The value returned is identical to what would be returned by:


      Integer.valueOf(x).compareTo(Integer.valueOf(y))

  x - the first int to compare - `int`
  y - the second int to compare - `int`

  returns: the value 0 if x == y;
           a value less than 0 if x < y; and
           a value greater than 0 if x > y - `int`"
  ([x y]
    (Integer/compare x y)))

(defn *remainder-unsigned
  "Returns the unsigned remainder from dividing the first argument
   by the second where each argument and the result is interpreted
   as an unsigned value.

  dividend - the value to be divided - `int`
  divisor - the value doing the dividing - `int`

  returns: the unsigned remainder of the first argument divided by
   the second argument - `int`"
  ([dividend divisor]
    (Integer/remainderUnsigned dividend divisor)))

(defn *min
  "Returns the smaller of two int values
   as if by calling Math.min.

  a - the first operand - `int`
  b - the second operand - `int`

  returns: the smaller of a and b - `int`"
  ([a b]
    (Integer/min a b)))

(defn *value-of
  "Returns an Integer object holding the value
   extracted from the specified String when parsed
   with the radix given by the second argument. The first argument
   is interpreted as representing a signed integer in the radix
   specified by the second argument, exactly as if the arguments
   were given to the parseInt(java.lang.String, int)
   method. The result is an Integer object that
   represents the integer value specified by the string.

   In other words, this method returns an Integer
   object equal to the value of:


    new Integer(Integer.parseInt(s, radix))

  s - the string to be parsed. - `java.lang.String`
  radix - the radix to be used in interpreting s - `int`

  returns: an Integer object holding the value
               represented by the string argument in the specified
               radix. - `java.lang.Integer`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable int."
  ([s radix]
    (Integer/valueOf s radix))
  ([s]
    (Integer/valueOf s)))

(defn *to-hex-string
  "Returns a string representation of the integer argument as an
   unsigned integer in base 16.

   The unsigned integer value is the argument plus 232
   if the argument is negative; otherwise, it is equal to the
   argument.  This value is converted to a string of ASCII digits
   in hexadecimal (base 16) with no extra leading
   0s.

   The value of the argument can be recovered from the returned
   string s by calling Integer.parseUnsignedInt(s, 16).

   If the unsigned magnitude is zero, it is represented by a
   single zero character '0' ('\u0030');
   otherwise, the first character of the representation of the
   unsigned magnitude will not be the zero character. The
   following characters are used as hexadecimal digits:


    0123456789abcdef


   These are the characters '\u0030' through
   '\u0039' and '\u0061' through
   '\u0066'. If uppercase letters are
   desired, the String.toUpperCase() method may
   be called on the result:


    Integer.toHexString(n).toUpperCase()

  i - an integer to be converted to a string. - `int`

  returns: the string representation of the unsigned integer value
            represented by the argument in hexadecimal (base 16). - `java.lang.String`"
  ([i]
    (Integer/toHexString i)))

(defn *divide-unsigned
  "Returns the unsigned quotient of dividing the first argument by
   the second where each argument and the result is interpreted as
   an unsigned value.

   Note that in two's complement arithmetic, the three other
   basic arithmetic operations of add, subtract, and multiply are
   bit-wise identical if the two operands are regarded as both
   being signed or both being unsigned.  Therefore separate addUnsigned, etc. methods are not provided.

  dividend - the value to be divided - `int`
  divisor - the value doing the dividing - `int`

  returns: the unsigned quotient of the first argument divided by
   the second argument - `int`"
  ([dividend divisor]
    (Integer/divideUnsigned dividend divisor)))

(defn *highest-one-bit
  "Returns an int value with at most a single one-bit, in the
   position of the highest-order (`leftmost`) one-bit in the specified
   int value.  Returns zero if the specified value has no
   one-bits in its two's complement binary representation, that is, if it
   is equal to zero.

  i - the value whose highest one bit is to be computed - `int`

  returns: an int value with a single one-bit, in the position
       of the highest-order one-bit in the specified value, or zero if
       the specified value is itself equal to zero. - `int`"
  ([i]
    (Integer/highestOneBit i)))

(defn *sum
  "Adds two integers together as per the  operator.

  a - the first operand - `int`
  b - the second operand - `int`

  returns: the sum of a and b - `int`"
  ([a b]
    (Integer/sum a b)))

(defn *reverse
  "Returns the value obtained by reversing the order of the bits in the
   two's complement binary representation of the specified int
   value.

  i - the value to be reversed - `int`

  returns: the value obtained by reversing order of the bits in the
       specified int value. - `int`"
  ([i]
    (Integer/reverse i)))

(defn *decode
  "Decodes a String into an Integer.
   Accepts decimal, hexadecimal, and octal numbers given
   by the following grammar:



   DecodableString:
   Signopt DecimalNumeral
   Signopt 0x HexDigits
   Signopt 0X HexDigits
   Signopt # HexDigits
   Signopt 0 OctalDigits

   Sign:
   -
   +



   DecimalNumeral, HexDigits, and OctalDigits
   are as defined in section 3.10.1 of
   The Java™ Language Specification,
   except that underscores are not accepted between digits.

   The sequence of characters following an optional
   sign and/or radix specifier (`0x`, `0X`,
   `#`, or leading zero) is parsed as by the Integer.parseInt method with the indicated radix (10, 16, or
   8).  This sequence of characters must represent a positive
   value or a NumberFormatException will be thrown.  The
   result is negated if first character of the specified String is the minus sign.  No whitespace characters are
   permitted in the String.

  nm - the String to decode. - `java.lang.String`

  returns: an Integer object holding the int
               value represented by nm - `java.lang.Integer`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable integer."
  ([nm]
    (Integer/decode nm)))

(defn *max
  "Returns the greater of two int values
   as if by calling Math.max.

  a - the first operand - `int`
  b - the second operand - `int`

  returns: the greater of a and b - `int`"
  ([a b]
    (Integer/max a b)))

(defn *to-string
  "Returns a string representation of the first argument in the
   radix specified by the second argument.

   If the radix is smaller than Character.MIN_RADIX
   or larger than Character.MAX_RADIX, then the radix
   10 is used instead.

   If the first argument is negative, the first element of the
   result is the ASCII minus character '-'
   ('\u002D'). If the first argument is not
   negative, no sign character appears in the result.

   The remaining characters of the result represent the magnitude
   of the first argument. If the magnitude is zero, it is
   represented by a single zero character '0'
   ('\u0030'); otherwise, the first character of
   the representation of the magnitude will not be the zero
   character.  The following ASCII characters are used as digits:


     0123456789abcdefghijklmnopqrstuvwxyz


   These are '\u0030' through
   '\u0039' and '\u0061' through
   '\u007A'. If radix is
   N, then the first N of these characters
   are used as radix-N digits in the order shown. Thus,
   the digits for hexadecimal (radix 16) are
   0123456789abcdef. If uppercase letters are
   desired, the String.toUpperCase() method may
   be called on the result:


    Integer.toString(n, 16).toUpperCase()

  i - an integer to be converted to a string. - `int`
  radix - the radix to use in the string representation. - `int`

  returns: a string representation of the argument in the specified radix. - `java.lang.String`"
  ([i radix]
    (Integer/toString i radix))
  ([i]
    (Integer/toString i)))

(defn *rotate-right
  "Returns the value obtained by rotating the two's complement binary
   representation of the specified int value right by the
   specified number of bits.  (Bits shifted out of the right hand, or
   low-order, side reenter on the left, or high-order.)

   Note that right rotation with a negative distance is equivalent to
   left rotation: rotateRight(val, -distance) == rotateLeft(val,
   distance).  Note also that rotation by any multiple of 32 is a
   no-op, so all but the last five bits of the rotation distance can be
   ignored, even if the distance is negative: rotateRight(val,
   distance) == rotateRight(val, distance & 0x1F).

  i - the value whose bits are to be rotated right - `int`
  distance - the number of bit positions to rotate right - `int`

  returns: the value obtained by rotating the two's complement binary
       representation of the specified int value right by the
       specified number of bits. - `int`"
  ([i distance]
    (Integer/rotateRight i distance)))

(defn *compare-unsigned
  "Compares two int values numerically treating the values
   as unsigned.

  x - the first int to compare - `int`
  y - the second int to compare - `int`

  returns: the value 0 if x == y; a value less
           than 0 if x < y as unsigned values; and
           a value greater than 0 if x > y as
           unsigned values - `int`"
  ([x y]
    (Integer/compareUnsigned x y)))

(defn *to-octal-string
  "Returns a string representation of the integer argument as an
   unsigned integer in base 8.

   The unsigned integer value is the argument plus 232
   if the argument is negative; otherwise, it is equal to the
   argument.  This value is converted to a string of ASCII digits
   in octal (base 8) with no extra leading 0s.

   The value of the argument can be recovered from the returned
   string s by calling Integer.parseUnsignedInt(s, 8).

   If the unsigned magnitude is zero, it is represented by a
   single zero character '0' ('\u0030');
   otherwise, the first character of the representation of the
   unsigned magnitude will not be the zero character. The
   following characters are used as octal digits:


   01234567


   These are the characters '\u0030' through
   '\u0037'.

  i - an integer to be converted to a string. - `int`

  returns: the string representation of the unsigned integer value
            represented by the argument in octal (base 8). - `java.lang.String`"
  ([i]
    (Integer/toOctalString i)))

(defn *reverse-bytes
  "Returns the value obtained by reversing the order of the bytes in the
   two's complement representation of the specified int value.

  i - the value whose bytes are to be reversed - `int`

  returns: the value obtained by reversing the bytes in the specified
       int value. - `int`"
  ([i]
    (Integer/reverseBytes i)))

(defn *bit-count
  "Returns the number of one-bits in the two's complement binary
   representation of the specified int value.  This function is
   sometimes referred to as the population count.

  i - the value whose bits are to be counted - `int`

  returns: the number of one-bits in the two's complement binary
       representation of the specified int value. - `int`"
  ([i]
    (Integer/bitCount i)))

(defn *rotate-left
  "Returns the value obtained by rotating the two's complement binary
   representation of the specified int value left by the
   specified number of bits.  (Bits shifted out of the left hand, or
   high-order, side reenter on the right, or low-order.)

   Note that left rotation with a negative distance is equivalent to
   right rotation: rotateLeft(val, -distance) == rotateRight(val,
   distance).  Note also that rotation by any multiple of 32 is a
   no-op, so all but the last five bits of the rotation distance can be
   ignored, even if the distance is negative: rotateLeft(val,
   distance) == rotateLeft(val, distance & 0x1F).

  i - the value whose bits are to be rotated left - `int`
  distance - the number of bit positions to rotate left - `int`

  returns: the value obtained by rotating the two's complement binary
       representation of the specified int value left by the
       specified number of bits. - `int`"
  ([i distance]
    (Integer/rotateLeft i distance)))

(defn *get-integer
  "Determines the integer value of the system property with the
   specified name.

   The first argument is treated as the name of a system
   property.  System properties are accessible through the System.getProperty(java.lang.String) method. The
   string value of this property is then interpreted as an integer
   value using the grammar supported by decode and
   an Integer object representing this value is returned.

   The second argument is the default value. An Integer object
   that represents the value of the second argument is returned if there
   is no property of the specified name, if the property does not have
   the correct numeric format, or if the specified name is empty or
   null.

   In other words, this method returns an Integer object
   equal to the value of:


    getInteger(nm, new Integer(val))


   but in practice it may be implemented in a manner such as:



   Integer result = getInteger(nm, null);
   return (result == null) ? new Integer(val) : result;

   to avoid the unnecessary allocation of an Integer
   object when the default value is not needed.

  nm - property name. - `java.lang.String`
  val - default value. - `int`

  returns: the Integer value of the property. - `java.lang.Integer`

  throws: java.lang.SecurityException - for the same reasons as System.getProperty"
  ([nm val]
    (Integer/getInteger nm val))
  ([nm]
    (Integer/getInteger nm)))

(defn *hash-code
  "Returns a hash code for a int value; compatible with
   Integer.hashCode().

  value - the value to hash - `int`

  returns: a hash code value for a int value. - `int`"
  ([value]
    (Integer/hashCode value)))

(defn *to-binary-string
  "Returns a string representation of the integer argument as an
   unsigned integer in base 2.

   The unsigned integer value is the argument plus 232
   if the argument is negative; otherwise it is equal to the
   argument.  This value is converted to a string of ASCII digits
   in binary (base 2) with no extra leading 0s.

   The value of the argument can be recovered from the returned
   string s by calling Integer.parseUnsignedInt(s, 2).

   If the unsigned magnitude is zero, it is represented by a
   single zero character '0' ('\u0030');
   otherwise, the first character of the representation of the
   unsigned magnitude will not be the zero character. The
   characters '0' ('\u0030') and '1' ('\u0031') are used as binary digits.

  i - an integer to be converted to a string. - `int`

  returns: the string representation of the unsigned integer value
            represented by the argument in binary (base 2). - `java.lang.String`"
  ([i]
    (Integer/toBinaryString i)))

(defn *number-of-leading-zeros
  "Returns the number of zero bits preceding the highest-order
   (`leftmost`) one-bit in the two's complement binary representation
   of the specified int value.  Returns 32 if the
   specified value has no one-bits in its two's complement representation,
   in other words if it is equal to zero.

   Note that this method is closely related to the logarithm base 2.
   For all positive int values x:

   floor(log2(x)) = 31 - numberOfLeadingZeros(x)
   ceil(log2(x)) = 32 - numberOfLeadingZeros(x - 1)

  i - the value whose number of leading zeros is to be computed - `int`

  returns: the number of zero bits preceding the highest-order
       (`leftmost`) one-bit in the two's complement binary representation
       of the specified int value, or 32 if the value
       is equal to zero. - `int`"
  ([i]
    (Integer/numberOfLeadingZeros i)))

(defn *to-unsigned-long
  "Converts the argument to a long by an unsigned
   conversion.  In an unsigned conversion to a long, the
   high-order 32 bits of the long are zero and the
   low-order 32 bits are equal to the bits of the integer
   argument.

   Consequently, zero and positive int values are mapped
   to a numerically equal long value and negative int values are mapped to a long value equal to the
   input plus 232.

  x - the value to convert to an unsigned long - `int`

  returns: the argument converted to long by an unsigned
           conversion - `long`"
  ([x]
    (Integer/toUnsignedLong x)))

(defn *lowest-one-bit
  "Returns an int value with at most a single one-bit, in the
   position of the lowest-order (`rightmost`) one-bit in the specified
   int value.  Returns zero if the specified value has no
   one-bits in its two's complement binary representation, that is, if it
   is equal to zero.

  i - the value whose lowest one bit is to be computed - `int`

  returns: an int value with a single one-bit, in the position
       of the lowest-order one-bit in the specified value, or zero if
       the specified value is itself equal to zero. - `int`"
  ([i]
    (Integer/lowestOneBit i)))

(defn *number-of-trailing-zeros
  "Returns the number of zero bits following the lowest-order (`rightmost`)
   one-bit in the two's complement binary representation of the specified
   int value.  Returns 32 if the specified value has no
   one-bits in its two's complement representation, in other words if it is
   equal to zero.

  i - the value whose number of trailing zeros is to be computed - `int`

  returns: the number of zero bits following the lowest-order (`rightmost`)
       one-bit in the two's complement binary representation of the
       specified int value, or 32 if the value is equal
       to zero. - `int`"
  ([i]
    (Integer/numberOfTrailingZeros i)))

(defn *parse-unsigned-int
  "Parses the string argument as an unsigned integer in the radix
   specified by the second argument.  An unsigned integer maps the
   values usually associated with negative numbers to positive
   numbers larger than MAX_VALUE.

   The characters in the string must all be digits of the
   specified radix (as determined by whether Character.digit(char, int) returns a nonnegative
   value), except that the first character may be an ASCII plus
   sign '+' ('\u002B'). The resulting
   integer value is returned.

   An exception of type NumberFormatException is
   thrown if any of the following situations occurs:

   The first argument is null or is a string of
   length zero.

   The radix is either smaller than
   Character.MIN_RADIX or
   larger than Character.MAX_RADIX.

   Any character of the string is not a digit of the specified
   radix, except that the first character may be a plus sign
   '+' ('\u002B') provided that the
   string is longer than length 1.

   The value represented by the string is larger than the
   largest unsigned int, 232-1.

  s - the String containing the unsigned integer representation to be parsed - `java.lang.String`
  radix - the radix to be used while parsing s. - `int`

  returns: the integer represented by the string argument in the
               specified radix. - `int`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable int."
  ([s radix]
    (Integer/parseUnsignedInt s radix))
  ([s]
    (Integer/parseUnsignedInt s)))

(defn *signum
  "Returns the signum function of the specified int value.  (The
   return value is -1 if the specified value is negative; 0 if the
   specified value is zero; and 1 if the specified value is positive.)

  i - the value whose signum is to be computed - `int`

  returns: the signum function of the specified int value. - `int`"
  ([i]
    (Integer/signum i)))

(defn *to-unsigned-string
  "Returns a string representation of the first argument as an
   unsigned integer value in the radix specified by the second
   argument.

   If the radix is smaller than Character.MIN_RADIX
   or larger than Character.MAX_RADIX, then the radix
   10 is used instead.

   Note that since the first argument is treated as an unsigned
   value, no leading sign character is printed.

   If the magnitude is zero, it is represented by a single zero
   character '0' ('\u0030'); otherwise,
   the first character of the representation of the magnitude will
   not be the zero character.

   The behavior of radixes and the characters used as digits
   are the same as toString.

  i - an integer to be converted to an unsigned string. - `int`
  radix - the radix to use in the string representation. - `int`

  returns: an unsigned string representation of the argument in the specified radix. - `java.lang.String`"
  ([i radix]
    (Integer/toUnsignedString i radix))
  ([i]
    (Integer/toUnsignedString i)))

(defn *parse-int
  "Parses the string argument as a signed integer in the radix
   specified by the second argument. The characters in the string
   must all be digits of the specified radix (as determined by
   whether Character.digit(char, int) returns a
   nonnegative value), except that the first character may be an
   ASCII minus sign '-' ('\u002D') to
   indicate a negative value or an ASCII plus sign '+'
   ('\u002B') to indicate a positive value. The
   resulting integer value is returned.

   An exception of type NumberFormatException is
   thrown if any of the following situations occurs:

   The first argument is null or is a string of
   length zero.

   The radix is either smaller than
   Character.MIN_RADIX or
   larger than Character.MAX_RADIX.

   Any character of the string is not a digit of the specified
   radix, except that the first character may be a minus sign
   '-' ('\u002D') or plus sign
   '+' ('\u002B') provided that the
   string is longer than length 1.

   The value represented by the string is not a value of type
   int.


   Examples:


   parseInt(`0`, 10) returns 0
   parseInt(`473`, 10) returns 473
   parseInt(`+42`, 10) returns 42
   parseInt(`-0`, 10) returns 0
   parseInt(`-FF`, 16) returns -255
   parseInt(`1100110`, 2) returns 102
   parseInt(`2147483647`, 10) returns 2147483647
   parseInt(`-2147483648`, 10) returns -2147483648
   parseInt(`2147483648`, 10) throws a NumberFormatException
   parseInt(`99`, 8) throws a NumberFormatException
   parseInt(`Kona`, 10) throws a NumberFormatException
   parseInt(`Kona`, 27) returns 411787

  s - the String containing the integer representation to be parsed - `java.lang.String`
  radix - the radix to be used while parsing s. - `int`

  returns: the integer represented by the string argument in the
               specified radix. - `int`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable int."
  ([s radix]
    (Integer/parseInt s radix))
  ([s]
    (Integer/parseInt s)))

(defn short-value
  "Returns the value of this Integer as a short
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type short. - `short`"
  ([this]
    (-> this (.shortValue))))

(defn double-value
  "Returns the value of this Integer as a double
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  ([this]
    (-> this (.doubleValue))))

(defn long-value
  "Returns the value of this Integer as a long
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  ([this]
    (-> this (.longValue))))

(defn byte-value
  "Returns the value of this Integer as a byte
   after a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type byte. - `byte`"
  ([this]
    (-> this (.byteValue))))

(defn to-string
  "Returns a String object representing this
   Integer's value. The value is converted to signed
   decimal representation and returned as a string, exactly as if
   the integer value were given as an argument to the toString(int) method.

  returns: a string representation of the value of this object in
            base 10. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn float-value
  "Returns the value of this Integer as a float
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  ([this]
    (-> this (.floatValue))))

(defn int-value
  "Returns the value of this Integer as an
   int.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  ([this]
    (-> this (.intValue))))

(defn hash-code
  "Returns a hash code for this Integer.

  returns: a hash code value for this object, equal to the
            primitive int value represented by this
            Integer object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares two Integer objects numerically.

  another-integer - the Integer to be compared. - `java.lang.Integer`

  returns: the value 0 if this Integer is
            equal to the argument Integer; a value less than
            0 if this Integer is numerically less
            than the argument Integer; and a value greater
            than 0 if this Integer is numerically
             greater than the argument Integer (signed
             comparison). - `int`"
  ([this another-integer]
    (-> this (.compareTo another-integer))))

(defn equals
  "Compares this object to the specified object.  The result is
   true if and only if the argument is not
   null and is an Integer object that
   contains the same int value as this object.

  obj - the object to compare with. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

