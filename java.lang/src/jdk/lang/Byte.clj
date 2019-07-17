(ns jdk.lang.Byte
  "The Byte class wraps a value of primitive type byte
  in an object.  An object of type Byte contains a single
  field whose type is byte.

  In addition, this class provides several methods for converting
  a byte to a String and a String to a byte, as well as other constants and methods useful when dealing
  with a byte."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Byte]))

(defn ->byte
  "Constructor.

  Constructs a newly allocated Byte object that
   represents the specified byte value.

  value - the value to be represented by the Byte. - `byte`"
  ([^Byte value]
    (new Byte value)))

(def *-min-value
  "Static Constant.

  A constant holding the minimum value a byte can
   have, -27.

  type: byte"
  Byte/MIN_VALUE)

(def *-max-value
  "Static Constant.

  A constant holding the maximum value a byte can
   have, 27-1.

  type: byte"
  Byte/MAX_VALUE)

(def *-type
  "Static Constant.

  The Class instance representing the primitive type
   byte.

  type: java.lang.Class<java.lang.Byte>"
  Byte/TYPE)

(def *-size
  "Static Constant.

  The number of bits used to represent a byte value in two's
   complement binary form.

  type: int"
  Byte/SIZE)

(def *-bytes
  "Static Constant.

  The number of bytes used to represent a byte value in two's
   complement binary form.

  type: int"
  Byte/BYTES)

(defn *to-string
  "Returns a new String object representing the
   specified byte. The radix is assumed to be 10.

  b - the byte to be converted - `byte`

  returns: the string representation of the specified byte - `java.lang.String`"
  (^java.lang.String [^Byte b]
    (Byte/toString b)))

(defn *value-of
  "Returns a Byte object holding the value
   extracted from the specified String when parsed
   with the radix given by the second argument. The first argument
   is interpreted as representing a signed byte in
   the radix specified by the second argument, exactly as if the
   argument were given to the parseByte(java.lang.String,
   int) method. The result is a Byte object that
   represents the byte value specified by the string.

    In other words, this method returns a Byte object
   equal to the value of:


   new Byte(Byte.parseByte(s, radix))

  s - the string to be parsed - `java.lang.String`
  radix - the radix to be used in interpreting s - `int`

  returns: a Byte object holding the value
                    represented by the string argument in the
                    specified radix. - `java.lang.Byte`

  throws: java.lang.NumberFormatException - If the String does not contain a parsable byte."
  (^java.lang.Byte [^java.lang.String s ^Integer radix]
    (Byte/valueOf s radix))
  (^java.lang.Byte [^Byte b]
    (Byte/valueOf b)))

(defn *parse-byte
  "Parses the string argument as a signed byte in the
   radix specified by the second argument. The characters in the
   string must all be digits, of the specified radix (as
   determined by whether Character.digit(char,
   int) returns a nonnegative value) except that the first
   character may be an ASCII minus sign '-'
   ('\u002D') to indicate a negative value or an
   ASCII plus sign '+' ('\u002B') to
   indicate a positive value.  The resulting byte value is
   returned.

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
   byte.

  s - the String containing the byte representation to be parsed - `java.lang.String`
  radix - the radix to be used while parsing s - `int`

  returns: the byte value represented by the string
                     argument in the specified radix - `byte`

  throws: java.lang.NumberFormatException - If the string does not contain a parsable byte."
  (^Byte [^java.lang.String s ^Integer radix]
    (Byte/parseByte s radix))
  (^Byte [^java.lang.String s]
    (Byte/parseByte s)))

(defn *decode
  "Decodes a String into a Byte.
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
   `#`, or leading zero) is parsed as by the Byte.parseByte method with the indicated radix (10, 16, or 8).
   This sequence of characters must represent a positive value or
   a NumberFormatException will be thrown.  The result is
   negated if first character of the specified String is
   the minus sign.  No whitespace characters are permitted in the
   String.

  nm - the String to decode. - `java.lang.String`

  returns: a Byte object holding the byte
            value represented by nm - `java.lang.Byte`

  throws: java.lang.NumberFormatException - if the String does not contain a parsable byte."
  (^java.lang.Byte [^java.lang.String nm]
    (Byte/decode nm)))

(defn *hash-code
  "Returns a hash code for a byte value; compatible with
   Byte.hashCode().

  value - the value to hash - `byte`

  returns: a hash code value for a byte value. - `int`"
  (^Integer [^Byte value]
    (Byte/hashCode value)))

(defn *compare
  "Compares two byte values numerically.
   The value returned is identical to what would be returned by:


      Byte.valueOf(x).compareTo(Byte.valueOf(y))

  x - the first byte to compare - `byte`
  y - the second byte to compare - `byte`

  returns: the value 0 if x == y;
           a value less than 0 if x < y; and
           a value greater than 0 if x > y - `int`"
  (^Integer [^Byte x ^Byte y]
    (Byte/compare x y)))

(defn *to-unsigned-int
  "Converts the argument to an int by an unsigned
   conversion.  In an unsigned conversion to an int, the
   high-order 24 bits of the int are zero and the
   low-order 8 bits are equal to the bits of the byte argument.

   Consequently, zero and positive byte values are mapped
   to a numerically equal int value and negative byte values are mapped to an int value equal to the
   input plus 28.

  x - the value to convert to an unsigned int - `byte`

  returns: the argument converted to int by an unsigned
           conversion - `int`"
  (^Integer [^Byte x]
    (Byte/toUnsignedInt x)))

(defn *to-unsigned-long
  "Converts the argument to a long by an unsigned
   conversion.  In an unsigned conversion to a long, the
   high-order 56 bits of the long are zero and the
   low-order 8 bits are equal to the bits of the byte argument.

   Consequently, zero and positive byte values are mapped
   to a numerically equal long value and negative byte values are mapped to a long value equal to the
   input plus 28.

  x - the value to convert to an unsigned long - `byte`

  returns: the argument converted to long by an unsigned
           conversion - `long`"
  (^Long [^Byte x]
    (Byte/toUnsignedLong x)))

(defn short-value
  "Returns the value of this Byte as a short after
   a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type short. - `short`"
  (^Short [^java.lang.Byte this]
    (-> this (.shortValue))))

(defn double-value
  "Returns the value of this Byte as a double
   after a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type double. - `double`"
  (^Double [^java.lang.Byte this]
    (-> this (.doubleValue))))

(defn long-value
  "Returns the value of this Byte as a long after
   a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type long. - `long`"
  (^Long [^java.lang.Byte this]
    (-> this (.longValue))))

(defn byte-value
  "Returns the value of this Byte as a
   byte.

  returns: the numeric value represented by this object after conversion
            to type byte. - `byte`"
  (^Byte [^java.lang.Byte this]
    (-> this (.byteValue))))

(defn to-string
  "Returns a String object representing this
   Byte's value.  The value is converted to signed
   decimal representation and returned as a string, exactly as if
   the byte value were given as an argument to the
   toString(byte) method.

  returns: a string representation of the value of this object in
            base 10. - `java.lang.String`"
  (^java.lang.String [^java.lang.Byte this]
    (-> this (.toString))))

(defn float-value
  "Returns the value of this Byte as a float after
   a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type float. - `float`"
  (^Float [^java.lang.Byte this]
    (-> this (.floatValue))))

(defn int-value
  "Returns the value of this Byte as an int after
   a widening primitive conversion.

  returns: the numeric value represented by this object after conversion
            to type int. - `int`"
  (^Integer [^java.lang.Byte this]
    (-> this (.intValue))))

(defn hash-code
  "Returns a hash code for this Byte; equal to the result
   of invoking intValue().

  returns: a hash code value for this Byte - `int`"
  (^Integer [^java.lang.Byte this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares two Byte objects numerically.

  another-byte - the Byte to be compared. - `java.lang.Byte`

  returns: the value 0 if this Byte is
            equal to the argument Byte; a value less than
            0 if this Byte is numerically less
            than the argument Byte; and a value greater than
             0 if this Byte is numerically
             greater than the argument Byte (signed
             comparison). - `int`"
  (^Integer [^java.lang.Byte this ^java.lang.Byte another-byte]
    (-> this (.compareTo another-byte))))

(defn equals
  "Compares this object to the specified object.  The result is
   true if and only if the argument is not
   null and is a Byte object that
   contains the same byte value as this object.

  obj - the object to compare with - `java.lang.Object`

  returns: true if the objects are the same;
                    false otherwise. - `boolean`"
  (^Boolean [^java.lang.Byte this ^java.lang.Object obj]
    (-> this (.equals obj))))

