(ns jdk.lang.Long
  "The Long class wraps a value of the primitive type long in an object. An object of type Long contains a
  single field whose type is long.

   In addition, this class provides several methods for converting
  a long to a String and a String to a long, as well as other constants and methods useful when dealing
  with a long.

  Implementation note: The implementations of the `bit twiddling`
  methods (such as highestOneBit and
  numberOfTrailingZeros) are
  based on material from Henry S. Warren, Jr.'s Hacker's
  Delight, (Addison Wesley, 2002)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Long]))

(defn ->long
  "Constructor.

  Constructs a newly allocated Long object that
   represents the specified long argument.

  value - the value to be represented by the Long object. - `long`"
  (^Long [^Long value]
    (new Long value)))

(def *-min-value
  "Static Constant.

  A constant holding the minimum value a long can
   have, -263.

  type: long"
  Long/MIN_VALUE)

(def *-max-value
  "Static Constant.

  A constant holding the maximum value a long can
   have, 263-1.

  type: long"
  Long/MAX_VALUE)

(def *-type
  "Static Constant.

  The Class instance representing the primitive type
   long.

  type: java.lang.Class<java.lang.Long>"
  Long/TYPE)

(def *-size
  "Static Constant.

  The number of bits used to represent a long value in two's
   complement binary form.

  type: int"
  Long/SIZE)

(def *-bytes
  "Static Constant.

  The number of bytes used to represent a long value in two's
   complement binary form.

  type: int"
  Long/BYTES)

(defn *compare
  "Compares two long values numerically.
   The value returned is identical to what would be returned by:


      Long.valueOf(x).compareTo(Long.valueOf(y))

  x - the first long to compare - `long`
  y - the second long to compare - `long`

  returns: the value 0 if x == y;
           a value less than 0 if x < y; and
           a value greater than 0 if x > y - `int`"
  (^Integer [^Long x ^Long y]
    (Long/compare x y)))

(defn *remainder-unsigned
  "Returns the unsigned remainder from dividing the first argument
   by the second where each argument and the result is interpreted
   as an unsigned value.

  dividend - the value to be divided - `long`
  divisor - the value doing the dividing - `long`

  returns: the unsigned remainder of the first argument divided by
   the second argument - `long`"
  (^Long [^Long dividend ^Long divisor]
    (Long/remainderUnsigned dividend divisor)))

(defn *min
  "Returns the smaller of two long values
   as if by calling Math.min.

  a - the first operand - `long`
  b - the second operand - `long`

  returns: the smaller of a and b - `long`"
  (^Long [^Long a ^Long b]
    (Long/min a b)))

(defn *value-of
  "Returns a Long object holding the value
   extracted from the specified String when parsed
   with the radix given by the second argument.  The first
   argument is interpreted as representing a signed
   long in the radix specified by the second
   argument, exactly as if the arguments were given to the parseLong(java.lang.String, int) method. The result is a
   Long object that represents the long
   value specified by the string.

   In other words, this method returns a Long object equal
   to the value of:


    new Long(Long.parseLong(s, radix))

  s - the string to be parsed - `java.lang.String`
  radix - the radix to be used in interpreting s - `int`

  returns: a Long object holding the value
               represented by the string argument in the specified
               radix. - `java.lang.Long`

  throws: java.lang.NumberFormatException - If the String does not contain a parsable long."
  (^java.lang.Long [^java.lang.String s ^Integer radix]
    (Long/valueOf s radix))
  (^java.lang.Long [^java.lang.String s]
    (Long/valueOf s)))

(defn *to-hex-string
  "Returns a string representation of the long
   argument as an unsigned integer in base 16.

   The unsigned long value is the argument plus
   264 if the argument is negative; otherwise, it is
   equal to the argument.  This value is converted to a string of
   ASCII digits in hexadecimal (base 16) with no extra
   leading 0s.

   The value of the argument can be recovered from the returned
   string s by calling Long.parseUnsignedLong(s,
   16).

   If the unsigned magnitude is zero, it is represented by a
   single zero character '0' ('\u0030');
   otherwise, the first character of the representation of the
   unsigned magnitude will not be the zero character. The
   following characters are used as hexadecimal digits:


    0123456789abcdef


   These are the characters '\u0030' through
   '\u0039' and  '\u0061' through
   '\u0066'.  If uppercase letters are desired,
   the String.toUpperCase() method may be called
   on the result:


    Long.toHexString(n).toUpperCase()

  i - a long to be converted to a string. - `long`

  returns: the string representation of the unsigned long
            value represented by the argument in hexadecimal
            (base 16). - `java.lang.String`"
  (^java.lang.String [^Long i]
    (Long/toHexString i)))

(defn *divide-unsigned
  "Returns the unsigned quotient of dividing the first argument by
   the second where each argument and the result is interpreted as
   an unsigned value.

   Note that in two's complement arithmetic, the three other
   basic arithmetic operations of add, subtract, and multiply are
   bit-wise identical if the two operands are regarded as both
   being signed or both being unsigned.  Therefore separate addUnsigned, etc. methods are not provided.

  dividend - the value to be divided - `long`
  divisor - the value doing the dividing - `long`

  returns: the unsigned quotient of the first argument divided by
   the second argument - `long`"
  (^Long [^Long dividend ^Long divisor]
    (Long/divideUnsigned dividend divisor)))

(defn *highest-one-bit
  "Returns a long value with at most a single one-bit, in the
   position of the highest-order (`leftmost`) one-bit in the specified
   long value.  Returns zero if the specified value has no
   one-bits in its two's complement binary representation, that is, if it
   is equal to zero.

  i - the value whose highest one bit is to be computed - `long`

  returns: a long value with a single one-bit, in the position
       of the highest-order one-bit in the specified value, or zero if
       the specified value is itself equal to zero. - `long`"
  (^Long [^Long i]
    (Long/highestOneBit i)))

(defn *sum
  "Adds two long values together as per the  operator.

  a - the first operand - `long`
  b - the second operand - `long`

  returns: the sum of a and b - `long`"
  (^Long [^Long a ^Long b]
    (Long/sum a b)))

(defn *reverse
  "Returns the value obtained by reversing the order of the bits in the
   two's complement binary representation of the specified long
   value.

  i - the value to be reversed - `long`

  returns: the value obtained by reversing order of the bits in the
       specified long value. - `long`"
  (^Long [^Long i]
    (Long/reverse i)))

(defn *decode
  "Decodes a String into a Long.
   Accepts decimal, hexadecimal, and octal numbers given by the
   following grammar:



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
   `#`, or leading zero) is parsed as by the Long.parseLong method with the indicated radix (10, 16, or 8).
   This sequence of characters must represent a positive value or
   a NumberFormatException will be thrown.  The result is
   negated if first character of the specified String is
   the minus sign.  No whitespace characters are permitted in the
   String.

  nm - the String to decode. - `java.lang.String`

  returns: a Long object holding the long
              value represented by nm - `java.lang.Long`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable long."
  (^java.lang.Long [^java.lang.String nm]
    (Long/decode nm)))

(defn *max
  "Returns the greater of two long values
   as if by calling Math.max.

  a - the first operand - `long`
  b - the second operand - `long`

  returns: the greater of a and b - `long`"
  (^Long [^Long a ^Long b]
    (Long/max a b)))

(defn *to-string
  "Returns a string representation of the first argument in the
   radix specified by the second argument.

   If the radix is smaller than Character.MIN_RADIX
   or larger than Character.MAX_RADIX, then the radix
   10 is used instead.

   If the first argument is negative, the first element of the
   result is the ASCII minus sign '-'
   ('\u002d'). If the first argument is not
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
   '\u007a'. If radix is
   N, then the first N of these characters
   are used as radix-N digits in the order shown. Thus,
   the digits for hexadecimal (radix 16) are
   0123456789abcdef. If uppercase letters are
   desired, the String.toUpperCase() method may
   be called on the result:


    Long.toString(n, 16).toUpperCase()

  i - a long to be converted to a string. - `long`
  radix - the radix to use in the string representation. - `int`

  returns: a string representation of the argument in the specified radix. - `java.lang.String`"
  (^java.lang.String [^Long i ^Integer radix]
    (Long/toString i radix))
  (^java.lang.String [^Long i]
    (Long/toString i)))

(defn *rotate-right
  "Returns the value obtained by rotating the two's complement binary
   representation of the specified long value right by the
   specified number of bits.  (Bits shifted out of the right hand, or
   low-order, side reenter on the left, or high-order.)

   Note that right rotation with a negative distance is equivalent to
   left rotation: rotateRight(val, -distance) == rotateLeft(val,
   distance).  Note also that rotation by any multiple of 64 is a
   no-op, so all but the last six bits of the rotation distance can be
   ignored, even if the distance is negative: rotateRight(val,
   distance) == rotateRight(val, distance & 0x3F).

  i - the value whose bits are to be rotated right - `long`
  distance - the number of bit positions to rotate right - `int`

  returns: the value obtained by rotating the two's complement binary
       representation of the specified long value right by the
       specified number of bits. - `long`"
  (^Long [^Long i ^Integer distance]
    (Long/rotateRight i distance)))

(defn *compare-unsigned
  "Compares two long values numerically treating the values
   as unsigned.

  x - the first long to compare - `long`
  y - the second long to compare - `long`

  returns: the value 0 if x == y; a value less
           than 0 if x < y as unsigned values; and
           a value greater than 0 if x > y as
           unsigned values - `int`"
  (^Integer [^Long x ^Long y]
    (Long/compareUnsigned x y)))

(defn *get-long
  "Determines the long value of the system property
   with the specified name.

   The first argument is treated as the name of a system
   property.  System properties are accessible through the System.getProperty(java.lang.String) method. The
   string value of this property is then interpreted as a long value using the grammar supported by decode
   and a Long object representing this value is returned.

   The second argument is the default value. A Long object
   that represents the value of the second argument is returned if there
   is no property of the specified name, if the property does not have
   the correct numeric format, or if the specified name is empty or null.

   In other words, this method returns a Long object equal
   to the value of:


    getLong(nm, new Long(val))


   but in practice it may be implemented in a manner such as:



   Long result = getLong(nm, null);
   return (result == null) ? new Long(val) : result;

   to avoid the unnecessary allocation of a Long object when
   the default value is not needed.

  nm - property name. - `java.lang.String`
  val - default value. - `long`

  returns: the Long value of the property. - `java.lang.Long`

  throws: java.lang.SecurityException - for the same reasons as System.getProperty"
  (^java.lang.Long [^java.lang.String nm ^Long val]
    (Long/getLong nm val))
  (^java.lang.Long [^java.lang.String nm]
    (Long/getLong nm)))

(defn *to-octal-string
  "Returns a string representation of the long
   argument as an unsigned integer in base 8.

   The unsigned long value is the argument plus
   264 if the argument is negative; otherwise, it is
   equal to the argument.  This value is converted to a string of
   ASCII digits in octal (base 8) with no extra leading
   0s.

   The value of the argument can be recovered from the returned
   string s by calling Long.parseUnsignedLong(s,
   8).

   If the unsigned magnitude is zero, it is represented by a
   single zero character '0' ('\u0030');
   otherwise, the first character of the representation of the
   unsigned magnitude will not be the zero character. The
   following characters are used as octal digits:


    01234567


   These are the characters '\u0030' through
   '\u0037'.

  i - a long to be converted to a string. - `long`

  returns: the string representation of the unsigned long
            value represented by the argument in octal (base 8). - `java.lang.String`"
  (^java.lang.String [^Long i]
    (Long/toOctalString i)))

(defn *reverse-bytes
  "Returns the value obtained by reversing the order of the bytes in the
   two's complement representation of the specified long value.

  i - the value whose bytes are to be reversed - `long`

  returns: the value obtained by reversing the bytes in the specified
       long value. - `long`"
  (^Long [^Long i]
    (Long/reverseBytes i)))

(defn *bit-count
  "Returns the number of one-bits in the two's complement binary
   representation of the specified long value.  This function is
   sometimes referred to as the population count.

  i - the value whose bits are to be counted - `long`

  returns: the number of one-bits in the two's complement binary
       representation of the specified long value. - `int`"
  (^Integer [^Long i]
    (Long/bitCount i)))

(defn *rotate-left
  "Returns the value obtained by rotating the two's complement binary
   representation of the specified long value left by the
   specified number of bits.  (Bits shifted out of the left hand, or
   high-order, side reenter on the right, or low-order.)

   Note that left rotation with a negative distance is equivalent to
   right rotation: rotateLeft(val, -distance) == rotateRight(val,
   distance).  Note also that rotation by any multiple of 64 is a
   no-op, so all but the last six bits of the rotation distance can be
   ignored, even if the distance is negative: rotateLeft(val,
   distance) == rotateLeft(val, distance & 0x3F).

  i - the value whose bits are to be rotated left - `long`
  distance - the number of bit positions to rotate left - `int`

  returns: the value obtained by rotating the two's complement binary
       representation of the specified long value left by the
       specified number of bits. - `long`"
  (^Long [^Long i ^Integer distance]
    (Long/rotateLeft i distance)))

(defn *parse-unsigned-long
  "Parses the string argument as an unsigned long in the
   radix specified by the second argument.  An unsigned integer
   maps the values usually associated with negative numbers to
   positive numbers larger than MAX_VALUE.

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
   largest unsigned long, 264-1.

  s - the String containing the unsigned integer representation to be parsed - `java.lang.String`
  radix - the radix to be used while parsing s. - `int`

  returns: the unsigned long represented by the string
               argument in the specified radix. - `long`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable long."
  (^Long [^java.lang.String s ^Integer radix]
    (Long/parseUnsignedLong s radix))
  (^Long [^java.lang.String s]
    (Long/parseUnsignedLong s)))

(defn *parse-long
  "Parses the string argument as a signed long in the
   radix specified by the second argument. The characters in the
   string must all be digits of the specified radix (as determined
   by whether Character.digit(char, int) returns
   a nonnegative value), except that the first character may be an
   ASCII minus sign '-' ('\u002D') to
   indicate a negative value or an ASCII plus sign '+'
   ('\u002B') to indicate a positive value. The
   resulting long value is returned.

   Note that neither the character L
   ('\u004C') nor l
   ('\u006C') is permitted to appear at the end
   of the string as a type indicator, as would be permitted in
   Java programming language source code - except that either
   L or l may appear as a digit for a
   radix greater than or equal to 22.

   An exception of type NumberFormatException is
   thrown if any of the following situations occurs:


   The first argument is null or is a string of
   length zero.

   The radix is either smaller than Character.MIN_RADIX or larger than Character.MAX_RADIX.

   Any character of the string is not a digit of the specified
   radix, except that the first character may be a minus sign
   '-' ('\u002d') or plus sign '+' ('\u002B') provided that the string is
   longer than length 1.

   The value represented by the string is not a value of type
        long.


   Examples:


   parseLong(`0`, 10) returns 0L
   parseLong(`473`, 10) returns 473L
   parseLong(`+42`, 10) returns 42L
   parseLong(`-0`, 10) returns 0L
   parseLong(`-FF`, 16) returns -255L
   parseLong(`1100110`, 2) returns 102L
   parseLong(`99`, 8) throws a NumberFormatException
   parseLong(`Hazelnut`, 10) throws a NumberFormatException
   parseLong(`Hazelnut`, 36) returns 1356099454469L

  s - the String containing the long representation to be parsed. - `java.lang.String`
  radix - the radix to be used while parsing s. - `int`

  returns: the long represented by the string argument in
               the specified radix. - `long`

  throws: java.lang.NumberFormatException - if the string does not contain a parsable long."
  (^Long [^java.lang.String s ^Integer radix]
    (Long/parseLong s radix))
  (^Long [^java.lang.String s]
    (Long/parseLong s)))

(defn *hash-code
  "Returns a hash code for a long value; compatible with
   Long.hashCode().

  value - the value to hash - `long`

  returns: a hash code value for a long value. - `int`"
  (^Integer [^Long value]
    (Long/hashCode value)))

(defn *to-binary-string
  "Returns a string representation of the long
   argument as an unsigned integer in base 2.

   The unsigned long value is the argument plus
   264 if the argument is negative; otherwise, it is
   equal to the argument.  This value is converted to a string of
   ASCII digits in binary (base 2) with no extra leading
   0s.

   The value of the argument can be recovered from the returned
   string s by calling Long.parseUnsignedLong(s,
   2).

   If the unsigned magnitude is zero, it is represented by a
   single zero character '0' ('\u0030');
   otherwise, the first character of the representation of the
   unsigned magnitude will not be the zero character. The
   characters '0' ('\u0030') and '1' ('\u0031') are used as binary digits.

  i - a long to be converted to a string. - `long`

  returns: the string representation of the unsigned long
            value represented by the argument in binary (base 2). - `java.lang.String`"
  (^java.lang.String [^Long i]
    (Long/toBinaryString i)))

(defn *number-of-leading-zeros
  "Returns the number of zero bits preceding the highest-order
   (`leftmost`) one-bit in the two's complement binary representation
   of the specified long value.  Returns 64 if the
   specified value has no one-bits in its two's complement representation,
   in other words if it is equal to zero.

   Note that this method is closely related to the logarithm base 2.
   For all positive long values x:

   floor(log2(x)) = 63 - numberOfLeadingZeros(x)
   ceil(log2(x)) = 64 - numberOfLeadingZeros(x - 1)

  i - the value whose number of leading zeros is to be computed - `long`

  returns: the number of zero bits preceding the highest-order
       (`leftmost`) one-bit in the two's complement binary representation
       of the specified long value, or 64 if the value
       is equal to zero. - `int`"
  (^Integer [^Long i]
    (Long/numberOfLeadingZeros i)))

(defn *lowest-one-bit
  "Returns a long value with at most a single one-bit, in the
   position of the lowest-order (`rightmost`) one-bit in the specified
   long value.  Returns zero if the specified value has no
   one-bits in its two's complement binary representation, that is, if it
   is equal to zero.

  i - the value whose lowest one bit is to be computed - `long`

  returns: a long value with a single one-bit, in the position
       of the lowest-order one-bit in the specified value, or zero if
       the specified value is itself equal to zero. - `long`"
  (^Long [^Long i]
    (Long/lowestOneBit i)))

(defn *number-of-trailing-zeros
  "Returns the number of zero bits following the lowest-order (`rightmost`)
   one-bit in the two's complement binary representation of the specified
   long value.  Returns 64 if the specified value has no
   one-bits in its two's complement representation, in other words if it is
   equal to zero.

  i - the value whose number of trailing zeros is to be computed - `long`

  returns: the number of zero bits following the lowest-order (`rightmost`)
       one-bit in the two's complement binary representation of the
       specified long value, or 64 if the value is equal
       to zero. - `int`"
  (^Integer [^Long i]
    (Long/numberOfTrailingZeros i)))

(defn *signum
  "Returns the signum function of the specified long value.  (The
   return value is -1 if the specified value is negative; 0 if the
   specified value is zero; and 1 if the specified value is positive.)

  i - the value whose signum is to be computed - `long`

  returns: the signum function of the specified long value. - `int`"
  (^Integer [^Long i]
    (Long/signum i)))

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

  i - an integer to be converted to an unsigned string. - `long`
  radix - the radix to use in the string representation. - `int`

  returns: an unsigned string representation of the argument in the specified radix. - `java.lang.String`"
  (^java.lang.String [^Long i ^Integer radix]
    (Long/toUnsignedString i radix))
  (^java.lang.String [^Long i]
    (Long/toUnsignedString i)))

(defn short-value
  "Returns the value of this Long as a short after
   a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type short. - `short`"
  (^Short [^Long this]
    (-> this (.shortValue))))

(defn double-value
  "Returns the value of this Long as a double
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  (^Double [^Long this]
    (-> this (.doubleValue))))

(defn long-value
  "Returns the value of this Long as a
   long value.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  (^Long [^Long this]
    (-> this (.longValue))))

(defn byte-value
  "Returns the value of this Long as a byte after
   a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type byte. - `byte`"
  (^Byte [^Long this]
    (-> this (.byteValue))))

(defn to-string
  "Returns a String object representing this
   Long's value.  The value is converted to signed
   decimal representation and returned as a string, exactly as if
   the long value were given as an argument to the
   toString(long) method.

  returns: a string representation of the value of this object in
            base 10. - `java.lang.String`"
  (^java.lang.String [^Long this]
    (-> this (.toString))))

(defn float-value
  "Returns the value of this Long as a float after
   a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  (^Float [^Long this]
    (-> this (.floatValue))))

(defn int-value
  "Returns the value of this Long as an int after
   a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  (^Integer [^Long this]
    (-> this (.intValue))))

(defn hash-code
  "Returns a hash code for this Long. The result is
   the exclusive OR of the two halves of the primitive
   long value held by this Long
   object. That is, the hashcode is the value of the expression:


    (int)(this.longValue()^(this.longValue()>>>32))

  returns: a hash code value for this object. - `int`"
  (^Integer [^Long this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares two Long objects numerically.

  another-long - the Long to be compared. - `java.lang.Long`

  returns: the value 0 if this Long is
            equal to the argument Long; a value less than
            0 if this Long is numerically less
            than the argument Long; and a value greater
            than 0 if this Long is numerically
             greater than the argument Long (signed
             comparison). - `int`"
  (^Integer [^Long this ^java.lang.Long another-long]
    (-> this (.compareTo another-long))))

(defn equals
  "Compares this object to the specified object.  The result is
   true if and only if the argument is not
   null and is a Long object that
   contains the same long value as this object.

  obj - the object to compare with. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  (^Boolean [^Long this ^java.lang.Object obj]
    (-> this (.equals obj))))

