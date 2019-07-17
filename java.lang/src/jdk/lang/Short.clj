(ns jdk.lang.Short
  "The Short class wraps a value of primitive type short in an object.  An object of type Short contains a
  single field whose type is short.

  In addition, this class provides several methods for converting
  a short to a String and a String to a
  short, as well as other constants and methods useful when
  dealing with a short."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Short]))

(defn ->short
  "Constructor.

  Constructs a newly allocated Short object that
   represents the specified short value.

  value - the value to be represented by the Short. - `short`"
  ([value]
    (new Short value)))

(def *-min-value
  "Static Constant.

  A constant holding the minimum value a short can
   have, -215.

  type: short"
  Short/MIN_VALUE)

(def *-max-value
  "Static Constant.

  A constant holding the maximum value a short can
   have, 215-1.

  type: short"
  Short/MAX_VALUE)

(def *-type
  "Static Constant.

  The Class instance representing the primitive type
   short.

  type: java.lang.Class<java.lang.Short>"
  Short/TYPE)

(def *-size
  "Static Constant.

  The number of bits used to represent a short value in two's
   complement binary form.

  type: int"
  Short/SIZE)

(def *-bytes
  "Static Constant.

  The number of bytes used to represent a short value in two's
   complement binary form.

  type: int"
  Short/BYTES)

(defn *compare
  "Compares two short values numerically.
   The value returned is identical to what would be returned by:


      Short.valueOf(x).compareTo(Short.valueOf(y))

  x - the first short to compare - `short`
  y - the second short to compare - `short`

  returns: the value 0 if x == y;
           a value less than 0 if x < y; and
           a value greater than 0 if x > y - `int`"
  ([x y]
    (Short/compare x y)))

(defn *value-of
  "Returns a Short object holding the value
   extracted from the specified String when parsed
   with the radix given by the second argument. The first argument
   is interpreted as representing a signed short in
   the radix specified by the second argument, exactly as if the
   argument were given to the parseShort(java.lang.String,
   int) method. The result is a Short object that
   represents the short value specified by the string.

   In other words, this method returns a Short object
   equal to the value of:


    new Short(Short.parseShort(s, radix))

  s - the string to be parsed - `java.lang.String`
  radix - the radix to be used in interpreting s - `int`

  returns: a Short object holding the value
                    represented by the string argument in the
                    specified radix. - `java.lang.Short`

  throws: java.lang.NumberFormatException - If the String does not contain a parsable short."
  ([s radix]
    (Short/valueOf s radix))
  ([s]
    (Short/valueOf s)))

(defn *parse-short
  "Parses the string argument as a signed short in the
   radix specified by the second argument. The characters in the
   string must all be digits, of the specified radix (as
   determined by whether Character.digit(char,
   int) returns a nonnegative value) except that the first
   character may be an ASCII minus sign '-'
   ('\u002D') to indicate a negative value or an
   ASCII plus sign '+' ('\u002B') to
   indicate a positive value.  The resulting short value
   is returned.

   An exception of type NumberFormatException is
   thrown if any of the following situations occurs:

    The first argument is null or is a string of
   length zero.

    The radix is either smaller than Character.MIN_RADIX or larger than Character.MAX_RADIX.

    Any character of the string is not a digit of the
   specified radix, except that the first character may be a minus
   sign '-' ('\u002D') or plus sign
   '+' ('\u002B') provided that the
   string is longer than length 1.

    The value represented by the string is not a value of type
   short.

  s - the String containing the short representation to be parsed - `java.lang.String`
  radix - the radix to be used while parsing s - `int`

  returns: the short represented by the string
                    argument in the specified radix. - `short`

  throws: java.lang.NumberFormatException - If the String does not contain a parsable short."
  ([s radix]
    (Short/parseShort s radix))
  ([s]
    (Short/parseShort s)))

(defn *decode
  "Decodes a String into a Short.
   Accepts decimal, hexadecimal, and octal numbers given by
   the following grammar:



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
   `#`, or leading zero) is parsed as by the Short.parseShort method with the indicated radix (10, 16, or
   8).  This sequence of characters must represent a positive
   value or a NumberFormatException will be thrown.  The
   result is negated if first character of the specified String is the minus sign.  No whitespace characters are
   permitted in the String.

  nm - the String to decode. - `java.lang.String`

  returns: a Short object holding the short
              value represented by nm - `java.lang.Short`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable short."
  ([nm]
    (Short/decode nm)))

(defn *to-string
  "Returns a new String object representing the
   specified short. The radix is assumed to be 10.

  s - the short to be converted - `short`

  returns: the string representation of the specified short - `java.lang.String`"
  ([s]
    (Short/toString s)))

(defn *reverse-bytes
  "Returns the value obtained by reversing the order of the bytes in the
   two's complement representation of the specified short value.

  i - the value whose bytes are to be reversed - `short`

  returns: the value obtained by reversing (or, equivalently, swapping)
       the bytes in the specified short value. - `short`"
  ([i]
    (Short/reverseBytes i)))

(defn *to-unsigned-int
  "Converts the argument to an int by an unsigned
   conversion.  In an unsigned conversion to an int, the
   high-order 16 bits of the int are zero and the
   low-order 16 bits are equal to the bits of the short argument.

   Consequently, zero and positive short values are mapped
   to a numerically equal int value and negative short values are mapped to an int value equal to the
   input plus 216.

  x - the value to convert to an unsigned int - `short`

  returns: the argument converted to int by an unsigned
           conversion - `int`"
  ([x]
    (Short/toUnsignedInt x)))

(defn *hash-code
  "Returns a hash code for a short value; compatible with
   Short.hashCode().

  value - the value to hash - `short`

  returns: a hash code value for a short value. - `int`"
  ([value]
    (Short/hashCode value)))

(defn *to-unsigned-long
  "Converts the argument to a long by an unsigned
   conversion.  In an unsigned conversion to a long, the
   high-order 48 bits of the long are zero and the
   low-order 16 bits are equal to the bits of the short argument.

   Consequently, zero and positive short values are mapped
   to a numerically equal long value and negative short values are mapped to a long value equal to the
   input plus 216.

  x - the value to convert to an unsigned long - `short`

  returns: the argument converted to long by an unsigned
           conversion - `long`"
  ([x]
    (Short/toUnsignedLong x)))

(defn short-value
  "Returns the value of this Short as a
   short.

  returns: the numeric value represented by this object after conversion
            to type short. - `short`"
  ([this]
    (-> this (.shortValue))))

(defn double-value
  "Returns the value of this Short as a double
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  ([this]
    (-> this (.doubleValue))))

(defn long-value
  "Returns the value of this Short as a long after
   a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  ([this]
    (-> this (.longValue))))

(defn byte-value
  "Returns the value of this Short as a byte after
   a narrowing primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type byte. - `byte`"
  ([this]
    (-> this (.byteValue))))

(defn to-string
  "Returns a String object representing this
   Short's value.  The value is converted to signed
   decimal representation and returned as a string, exactly as if
   the short value were given as an argument to the
   toString(short) method.

  returns: a string representation of the value of this object in
            base 10. - `java.lang.String`"
  ([this]
    (-> this (.toString))))

(defn float-value
  "Returns the value of this Short as a float
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  ([this]
    (-> this (.floatValue))))

(defn int-value
  "Returns the value of this Short as an int after
   a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  ([this]
    (-> this (.intValue))))

(defn hash-code
  "Returns a hash code for this Short; equal to the result
   of invoking intValue().

  returns: a hash code value for this Short - `int`"
  ([this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares two Short objects numerically.

  another-short - the Short to be compared. - `java.lang.Short`

  returns: the value 0 if this Short is
            equal to the argument Short; a value less than
            0 if this Short is numerically less
            than the argument Short; and a value greater than
             0 if this Short is numerically
             greater than the argument Short (signed
             comparison). - `int`"
  ([this another-short]
    (-> this (.compareTo another-short))))

(defn equals
  "Compares this object to the specified object.  The result is
   true if and only if the argument is not
   null and is a Short object that
   contains the same short value as this object.

  obj - the object to compare with - `java.lang.Object`

  returns: true if the objects are the same;
                    false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

