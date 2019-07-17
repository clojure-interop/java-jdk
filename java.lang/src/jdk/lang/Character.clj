(ns jdk.lang.Character
  "The Character class wraps a value of the primitive
  type char in an object. An object of class
  Character contains a single field whose type is
  char.

  In addition, this class provides a large number of static methods for
  determining a character's category (lowercase letter, digit, etc.)
  and for converting characters from uppercase to lowercase and vice
  versa.

  Unicode Conformance

  The fields and methods of class Character are defined in terms
  of character information from the Unicode Standard, specifically the
  UnicodeData file that is part of the Unicode Character Database.
  This file specifies properties including name and category for every
  assigned Unicode code point or character range. The file is available
  from the Unicode Consortium at
  http://www.unicode.org.

  The Java SE 8 Platform uses character information from version 6.2
  of the Unicode Standard, with two extensions. First, the Java SE 8 Platform
  allows an implementation of class Character to use the Japanese Era
  code point, U+32FF, from the first version of the Unicode Standard
  after 6.2 that assigns the code point. Second, in recognition of the fact
  that new currencies appear frequently, the Java SE 8 Platform allows an
  implementation of class Character to use the Currency Symbols
  block from version 10.0 of the Unicode Standard. Consequently, the
  behavior of fields and methods of class Character may vary across
  implementations of the Java SE 8 Platform when processing the aforementioned
  code points ( outside of version 6.2 ), except for the following methods
  that define Java identifiers:
  isJavaIdentifierStart(int), isJavaIdentifierStart(char),
  isJavaIdentifierPart(int), and isJavaIdentifierPart(char).
  Code points in Java identifiers must be drawn from version 6.2 of
  the Unicode Standard.

  Unicode Character Representations

  The char data type (and therefore the value that a
  Character object encapsulates) are based on the
  original Unicode specification, which defined characters as
  fixed-width 16-bit entities. The Unicode Standard has since been
  changed to allow for characters whose representation requires more
  than 16 bits.  The range of legal code points is now
  U+0000 to U+10FFFF, known as Unicode scalar value.
  (Refer to the
  definition of the U+n notation in the Unicode
  Standard.)

  The set of characters from U+0000 to U+FFFF is
  sometimes referred to as the Basic Multilingual Plane (BMP).
  Characters whose code points are greater
  than U+FFFF are called supplementary characters.  The Java
  platform uses the UTF-16 representation in char arrays and
  in the String and StringBuffer classes. In
  this representation, supplementary characters are represented as a pair
  of char values, the first from the high-surrogates
  range, (\uD800-\uDBFF), the second from the
  low-surrogates range (\uDC00-\uDFFF).

  A char value, therefore, represents Basic
  Multilingual Plane (BMP) code points, including the surrogate
  code points, or code units of the UTF-16 encoding. An
  int value represents all Unicode code points,
  including supplementary code points. The lower (least significant)
  21 bits of int are used to represent Unicode code
  points and the upper (most significant) 11 bits must be zero.
  Unless otherwise specified, the behavior with respect to
  supplementary characters and surrogate char values is
  as follows:


  The methods that only accept a char value cannot support
  supplementary characters. They treat char values from the
  surrogate ranges as undefined characters. For example,
  Character.isLetter('\uD840') returns false, even though
  this specific value if followed by any low-surrogate value in a string
  would represent a letter.

  The methods that accept an int value support all
  Unicode characters, including supplementary characters. For
  example, Character.isLetter(0x2F81A) returns
  true because the code point value represents a letter
  (a CJK ideograph).


  In the Java SE API documentation, Unicode code point is
  used for character values in the range between U+0000 and U+10FFFF,
  and Unicode code unit is used for 16-bit
  char values that are code units of the UTF-16
  encoding. For more information on Unicode terminology, refer to the
  Unicode Glossary."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Character]))

(defn ->character
  "Constructor.

  Constructs a newly allocated Character object that
   represents the specified char value.

  value - the value to be represented by the Character object. - `char`"
  ([^Character value]
    (new Character value)))

(def *-min-radix
  "Static Constant.

  The minimum radix available for conversion to and from strings.
   The constant value of this field is the smallest value permitted
   for the radix argument in radix-conversion methods such as the
   digit method, the forDigit method, and the
   toString method of class Integer.

  type: int"
  Character/MIN_RADIX)

(def *-max-radix
  "Static Constant.

  The maximum radix available for conversion to and from strings.
   The constant value of this field is the largest value permitted
   for the radix argument in radix-conversion methods such as the
   digit method, the forDigit method, and the
   toString method of class Integer.

  type: int"
  Character/MAX_RADIX)

(def *-min-value
  "Static Constant.

  The constant value of this field is the smallest value of type
   char, '\u0000'.

  type: char"
  Character/MIN_VALUE)

(def *-max-value
  "Static Constant.

  The constant value of this field is the largest value of type
   char, '\uFFFF'.

  type: char"
  Character/MAX_VALUE)

(def *-type
  "Static Constant.

  The Class instance representing the primitive type
   char.

  type: java.lang.Class<java.lang.Character>"
  Character/TYPE)

(def *-unassigned
  "Static Constant.

  General category `Cn` in the Unicode specification.

  type: byte"
  Character/UNASSIGNED)

(def *-uppercase-letter
  "Static Constant.

  General category `Lu` in the Unicode specification.

  type: byte"
  Character/UPPERCASE_LETTER)

(def *-lowercase-letter
  "Static Constant.

  General category `Ll` in the Unicode specification.

  type: byte"
  Character/LOWERCASE_LETTER)

(def *-titlecase-letter
  "Static Constant.

  General category `Lt` in the Unicode specification.

  type: byte"
  Character/TITLECASE_LETTER)

(def *-modifier-letter
  "Static Constant.

  General category `Lm` in the Unicode specification.

  type: byte"
  Character/MODIFIER_LETTER)

(def *-other-letter
  "Static Constant.

  General category `Lo` in the Unicode specification.

  type: byte"
  Character/OTHER_LETTER)

(def *-non-spacing-mark
  "Static Constant.

  General category `Mn` in the Unicode specification.

  type: byte"
  Character/NON_SPACING_MARK)

(def *-enclosing-mark
  "Static Constant.

  General category `Me` in the Unicode specification.

  type: byte"
  Character/ENCLOSING_MARK)

(def *-combining-spacing-mark
  "Static Constant.

  General category `Mc` in the Unicode specification.

  type: byte"
  Character/COMBINING_SPACING_MARK)

(def *-decimal-digit-number
  "Static Constant.

  General category `Nd` in the Unicode specification.

  type: byte"
  Character/DECIMAL_DIGIT_NUMBER)

(def *-letter-number
  "Static Constant.

  General category `Nl` in the Unicode specification.

  type: byte"
  Character/LETTER_NUMBER)

(def *-other-number
  "Static Constant.

  General category `No` in the Unicode specification.

  type: byte"
  Character/OTHER_NUMBER)

(def *-space-separator
  "Static Constant.

  General category `Zs` in the Unicode specification.

  type: byte"
  Character/SPACE_SEPARATOR)

(def *-line-separator
  "Static Constant.

  General category `Zl` in the Unicode specification.

  type: byte"
  Character/LINE_SEPARATOR)

(def *-paragraph-separator
  "Static Constant.

  General category `Zp` in the Unicode specification.

  type: byte"
  Character/PARAGRAPH_SEPARATOR)

(def *-control
  "Static Constant.

  General category `Cc` in the Unicode specification.

  type: byte"
  Character/CONTROL)

(def *-format
  "Static Constant.

  General category `Cf` in the Unicode specification.

  type: byte"
  Character/FORMAT)

(def *-private-use
  "Static Constant.

  General category `Co` in the Unicode specification.

  type: byte"
  Character/PRIVATE_USE)

(def *-surrogate
  "Static Constant.

  General category `Cs` in the Unicode specification.

  type: byte"
  Character/SURROGATE)

(def *-dash-punctuation
  "Static Constant.

  General category `Pd` in the Unicode specification.

  type: byte"
  Character/DASH_PUNCTUATION)

(def *-start-punctuation
  "Static Constant.

  General category `Ps` in the Unicode specification.

  type: byte"
  Character/START_PUNCTUATION)

(def *-end-punctuation
  "Static Constant.

  General category `Pe` in the Unicode specification.

  type: byte"
  Character/END_PUNCTUATION)

(def *-connector-punctuation
  "Static Constant.

  General category `Pc` in the Unicode specification.

  type: byte"
  Character/CONNECTOR_PUNCTUATION)

(def *-other-punctuation
  "Static Constant.

  General category `Po` in the Unicode specification.

  type: byte"
  Character/OTHER_PUNCTUATION)

(def *-math-symbol
  "Static Constant.

  General category `Sm` in the Unicode specification.

  type: byte"
  Character/MATH_SYMBOL)

(def *-currency-symbol
  "Static Constant.

  General category `Sc` in the Unicode specification.

  type: byte"
  Character/CURRENCY_SYMBOL)

(def *-modifier-symbol
  "Static Constant.

  General category `Sk` in the Unicode specification.

  type: byte"
  Character/MODIFIER_SYMBOL)

(def *-other-symbol
  "Static Constant.

  General category `So` in the Unicode specification.

  type: byte"
  Character/OTHER_SYMBOL)

(def *-initial-quote-punctuation
  "Static Constant.

  General category `Pi` in the Unicode specification.

  type: byte"
  Character/INITIAL_QUOTE_PUNCTUATION)

(def *-final-quote-punctuation
  "Static Constant.

  General category `Pf` in the Unicode specification.

  type: byte"
  Character/FINAL_QUOTE_PUNCTUATION)

(def *-directionality-undefined
  "Static Constant.

  Undefined bidirectional character type. Undefined char
   values have undefined directionality in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_UNDEFINED)

(def *-directionality-left-to-right
  "Static Constant.

  Strong bidirectional character type `L` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_LEFT_TO_RIGHT)

(def *-directionality-right-to-left
  "Static Constant.

  Strong bidirectional character type `R` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_RIGHT_TO_LEFT)

(def *-directionality-right-to-left-arabic
  "Static Constant.

  Strong bidirectional character type `AL` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC)

(def *-directionality-european-number
  "Static Constant.

  Weak bidirectional character type `EN` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_EUROPEAN_NUMBER)

(def *-directionality-european-number-separator
  "Static Constant.

  Weak bidirectional character type `ES` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR)

(def *-directionality-european-number-terminator
  "Static Constant.

  Weak bidirectional character type `ET` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR)

(def *-directionality-arabic-number
  "Static Constant.

  Weak bidirectional character type `AN` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_ARABIC_NUMBER)

(def *-directionality-common-number-separator
  "Static Constant.

  Weak bidirectional character type `CS` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_COMMON_NUMBER_SEPARATOR)

(def *-directionality-nonspacing-mark
  "Static Constant.

  Weak bidirectional character type `NSM` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_NONSPACING_MARK)

(def *-directionality-boundary-neutral
  "Static Constant.

  Weak bidirectional character type `BN` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_BOUNDARY_NEUTRAL)

(def *-directionality-paragraph-separator
  "Static Constant.

  Neutral bidirectional character type `B` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_PARAGRAPH_SEPARATOR)

(def *-directionality-segment-separator
  "Static Constant.

  Neutral bidirectional character type `S` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_SEGMENT_SEPARATOR)

(def *-directionality-whitespace
  "Static Constant.

  Neutral bidirectional character type `WS` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_WHITESPACE)

(def *-directionality-other-neutrals
  "Static Constant.

  Neutral bidirectional character type `ON` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_OTHER_NEUTRALS)

(def *-directionality-left-to-right-embedding
  "Static Constant.

  Strong bidirectional character type `LRE` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING)

(def *-directionality-left-to-right-override
  "Static Constant.

  Strong bidirectional character type `LRO` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE)

(def *-directionality-right-to-left-embedding
  "Static Constant.

  Strong bidirectional character type `RLE` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING)

(def *-directionality-right-to-left-override
  "Static Constant.

  Strong bidirectional character type `RLO` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE)

(def *-directionality-pop-directional-format
  "Static Constant.

  Weak bidirectional character type `PDF` in the Unicode specification.

  type: byte"
  Character/DIRECTIONALITY_POP_DIRECTIONAL_FORMAT)

(def *-min-high-surrogate
  "Static Constant.

  The minimum value of a

   Unicode high-surrogate code unit
   in the UTF-16 encoding, constant '\uD800'.
   A high-surrogate is also known as a leading-surrogate.

  type: char"
  Character/MIN_HIGH_SURROGATE)

(def *-max-high-surrogate
  "Static Constant.

  The maximum value of a

   Unicode high-surrogate code unit
   in the UTF-16 encoding, constant '\uDBFF'.
   A high-surrogate is also known as a leading-surrogate.

  type: char"
  Character/MAX_HIGH_SURROGATE)

(def *-min-low-surrogate
  "Static Constant.

  The minimum value of a

   Unicode low-surrogate code unit
   in the UTF-16 encoding, constant '\uDC00'.
   A low-surrogate is also known as a trailing-surrogate.

  type: char"
  Character/MIN_LOW_SURROGATE)

(def *-max-low-surrogate
  "Static Constant.

  The maximum value of a

   Unicode low-surrogate code unit
   in the UTF-16 encoding, constant '\uDFFF'.
   A low-surrogate is also known as a trailing-surrogate.

  type: char"
  Character/MAX_LOW_SURROGATE)

(def *-min-surrogate
  "Static Constant.

  The minimum value of a Unicode surrogate code unit in the
   UTF-16 encoding, constant '\uD800'.

  type: char"
  Character/MIN_SURROGATE)

(def *-max-surrogate
  "Static Constant.

  The maximum value of a Unicode surrogate code unit in the
   UTF-16 encoding, constant '\uDFFF'.

  type: char"
  Character/MAX_SURROGATE)

(def *-min-supplementary-code-point
  "Static Constant.

  The minimum value of a

   Unicode supplementary code point, constant U+10000.

  type: int"
  Character/MIN_SUPPLEMENTARY_CODE_POINT)

(def *-min-code-point
  "Static Constant.

  The minimum value of a

   Unicode code point, constant U+0000.

  type: int"
  Character/MIN_CODE_POINT)

(def *-max-code-point
  "Static Constant.

  The maximum value of a

   Unicode code point, constant U+10FFFF.

  type: int"
  Character/MAX_CODE_POINT)

(def *-size
  "Static Constant.

  The number of bits used to represent a char value in unsigned
   binary form, constant 16.

  type: int"
  Character/SIZE)

(def *-bytes
  "Static Constant.

  The number of bytes used to represent a char value in unsigned
   binary form.

  type: int"
  Character/BYTES)

(defn *compare
  "Compares two char values numerically.
   The value returned is identical to what would be returned by:


      Character.valueOf(x).compareTo(Character.valueOf(y))

  x - the first char to compare - `char`
  y - the second char to compare - `char`

  returns: the value 0 if x == y;
           a value less than 0 if x < y; and
           a value greater than 0 if x > y - `int`"
  ([^Character x ^Character y]
    (Character/compare x y)))

(defn *java-identifier-part?
  "Determines if the specified character may be part of a Java
   identifier as other than the first character.

   A character may be part of a Java identifier if any of the following
   conditions are true:

     it is a letter
     it is a currency symbol (such as '$')
     it is a connecting punctuation character (such as '_')
     it is a digit
     it is a numeric letter (such as a Roman numeral character)
     it is a combining mark
     it is a non-spacing mark
    isIdentifierIgnorable returns
   true for the character


   These conditions are tested against the character information from version
   6.2 of the Unicode Standard.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isJavaIdentifierPart(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character may be part of a
            Java identifier; false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isJavaIdentifierPart ch)))

(defn *to-lower-case
  "Converts the character argument to lowercase using case
   mapping information from the UnicodeData file.

   Note that
   Character.isLowerCase(Character.toLowerCase(ch))
   does not always return true for some ranges of
   characters, particularly those that are symbols or ideographs.

   In general, String.toLowerCase() should be used to map
   characters to lowercase. String case mapping methods
   have several benefits over Character case mapping methods.
   String case mapping methods can perform locale-sensitive
   mappings, context-sensitive mappings, and 1:M character mappings, whereas
   the Character case mapping methods cannot.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the toLowerCase(int) method.

  ch - the character to be converted. - `char`

  returns: the lowercase equivalent of the character, if any;
            otherwise, the character itself. - `char`"
  ([^Character ch]
    (Character/toLowerCase ch)))

(defn *for-digit
  "Determines the character representation for a specific digit in
   the specified radix. If the value of radix is not a
   valid radix, or the value of digit is not a valid
   digit in the specified radix, the null character
   ('\u0000') is returned.

   The radix argument is valid if it is greater than or
   equal to MIN_RADIX and less than or equal to
   MAX_RADIX. The digit argument is valid if
   0 <= digit < radix.

   If the digit is less than 10, then
   '0'  digit is returned. Otherwise, the value
   'a'  digit - 10 is returned.

  digit - the number to convert to a character. - `int`
  radix - the radix. - `int`

  returns: the char representation of the specified digit
            in the specified radix. - `char`"
  ([^Integer digit ^Integer radix]
    (Character/forDigit digit radix)))

(defn *value-of
  "Returns a Character instance representing the specified
   char value.
   If a new Character instance is not required, this method
   should generally be used in preference to the constructor
   Character(char), as this method is likely to yield
   significantly better space and time performance by caching
   frequently requested values.

   This method will always cache values in the range '\u0000' to '\u007F', inclusive, and may
   cache other values outside of this range.

  c - a char value. - `char`

  returns: a Character instance representing c. - `java.lang.Character`"
  ([^Character c]
    (Character/valueOf c)))

(defn *low-surrogate
  "Returns the trailing surrogate (a

   low surrogate code unit) of the

   surrogate pair
   representing the specified supplementary character (Unicode
   code point) in the UTF-16 encoding.  If the specified character
   is not a
   supplementary character,
   an unspecified char is returned.

   If
   isSupplementaryCodePoint(x)
   is true, then
   isLowSurrogate(lowSurrogate(x)) and
   toCodePoint(highSurrogate(x), lowSurrogate(x)) == x
   are also always true.

  code-point - a supplementary character (Unicode code point) - `int`

  returns: the trailing surrogate code unit used to represent the
            character in the UTF-16 encoding - `char`"
  ([^Integer code-point]
    (Character/lowSurrogate code-point)))

(defn *space-char?
  "Determines if the specified character is a Unicode space character.
   A character is considered to be a space character if and only if
   it is specified to be a space character by the Unicode Standard. This
   method returns true if the character's general category type is any of
   the following:

    SPACE_SEPARATOR
    LINE_SEPARATOR
    PARAGRAPH_SEPARATOR


   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isSpaceChar(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is a space character;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isSpaceChar ch)))

(defn *is-space
  "Deprecated. Replaced by isWhitespace(char).

  ch - the character to be tested. - `char`

  returns: true if the character is ISO-LATIN-1 white
               space; false otherwise. - `java.lang.   boolean`"
  ([^Character ch]
    (Character/isSpace ch)))

(defn *get-type
  "Returns a value indicating a character's general category.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the getType(int) method.

  ch - the character to be tested. - `char`

  returns: a value of type int representing the
            character's general category. - `int`"
  ([^Character ch]
    (Character/getType ch)))

(defn *lower-case?
  "Determines if the specified character is a lowercase character.

   A character is lowercase if its general category type, provided
   by Character.getType(ch), is
   LOWERCASE_LETTER, or it has contributory property
   Other_Lowercase as defined by the Unicode Standard.

   The following are examples of lowercase characters:


   a b c d e f g h i j k l m n o p q r s t u v w x y z
   '\u00DF' '\u00E0' '\u00E1' '\u00E2' '\u00E3' '\u00E4' '\u00E5' '\u00E6'
   '\u00E7' '\u00E8' '\u00E9' '\u00EA' '\u00EB' '\u00EC' '\u00ED' '\u00EE'
   '\u00EF' '\u00F0' '\u00F1' '\u00F2' '\u00F3' '\u00F4' '\u00F5' '\u00F6'
   '\u00F8' '\u00F9' '\u00FA' '\u00FB' '\u00FC' '\u00FD' '\u00FE' '\u00FF'
    Many other Unicode characters are lowercase too.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isLowerCase(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is lowercase;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isLowerCase ch)))

(defn *unicode-identifier-start?
  "Determines if the specified character is permissible as the
   first character in a Unicode identifier.

   A character may start a Unicode identifier if and only if
   one of the following conditions is true:

    isLetter(ch) returns true
    getType(ch) returns
        LETTER_NUMBER.


   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isUnicodeIdentifierStart(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character may start a Unicode
            identifier; false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isUnicodeIdentifierStart ch)))

(defn *is-java-letter-or-digit
  "Deprecated. Replaced by isJavaIdentifierPart(char).

  ch - the character to be tested. - `char`

  returns: true if the character may be part of a
            Java identifier; false otherwise. - `java.lang.   boolean`"
  ([^Character ch]
    (Character/isJavaLetterOrDigit ch)))

(defn *to-string
  "Returns a String object representing the
   specified char.  The result is a string of length
   1 consisting solely of the specified char.

  c - the char to be converted - `char`

  returns: the string representation of the specified char - `java.lang.String`"
  ([^Character c]
    (Character/toString c)))

(defn *bmp-code-point?
  "Determines whether the specified character (Unicode code point)
   is in the Basic Multilingual Plane (BMP).
   Such code points can be represented using a single char.

  code-point - the character (Unicode code point) to be tested - `int`

  returns: true if the specified code point is between
           MIN_VALUE and MAX_VALUE inclusive;
           false otherwise. - `boolean`"
  ([^Integer code-point]
    (Character/isBmpCodePoint code-point)))

(defn *alphabetic?
  "Determines if the specified character (Unicode code point) is an alphabet.

   A character is considered to be alphabetic if its general category type,
   provided by getType(codePoint), is any of
   the following:

    UPPERCASE_LETTER
    LOWERCASE_LETTER
    TITLECASE_LETTER
    MODIFIER_LETTER
    OTHER_LETTER
    LETTER_NUMBER

   or it has contributory property Other_Alphabetic as defined by the
   Unicode Standard.

  code-point - the character (Unicode code point) to be tested. - `int`

  returns: true if the character is a Unicode alphabet
            character, false otherwise. - `boolean`"
  ([^Integer code-point]
    (Character/isAlphabetic code-point)))

(defn *to-code-point
  "Converts the specified surrogate pair to its supplementary code
   point value. This method does not validate the specified
   surrogate pair. The caller must validate it using isSurrogatePair if necessary.

  high - the high-surrogate code unit - `char`
  low - the low-surrogate code unit - `char`

  returns: the supplementary code point composed from the
           specified surrogate pair. - `int`"
  ([^Character high ^Character low]
    (Character/toCodePoint high low)))

(defn *valid-code-point?
  "Determines whether the specified code point is a valid

   Unicode code point value.

  code-point - the Unicode code point to be tested - `int`

  returns: true if the specified code point value is between
           MIN_CODE_POINT and
           MAX_CODE_POINT inclusive;
           false otherwise. - `boolean`"
  ([^Integer code-point]
    (Character/isValidCodePoint code-point)))

(defn *high-surrogate
  "Returns the leading surrogate (a

   high surrogate code unit) of the

   surrogate pair
   representing the specified supplementary character (Unicode
   code point) in the UTF-16 encoding.  If the specified character
   is not a
   supplementary character,
   an unspecified char is returned.

   If
   isSupplementaryCodePoint(x)
   is true, then
   isHighSurrogate(highSurrogate(x)) and
   toCodePoint(highSurrogate(x), lowSurrogate(x)) == x
   are also always true.

  code-point - a supplementary character (Unicode code point) - `int`

  returns: the leading surrogate code unit used to represent the
            character in the UTF-16 encoding - `char`"
  ([^Integer code-point]
    (Character/highSurrogate code-point)))

(defn *iso-control?
  "Determines if the specified character is an ISO control
   character.  A character is considered to be an ISO control
   character if its code is in the range '\u0000'
   through '\u001F' or in the range
   '\u007F' through '\u009F'.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isISOControl(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is an ISO control character;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isISOControl ch)))

(defn *get-name
  "Returns the Unicode name of the specified character
   codePoint, or null if the code point is
   unassigned.

   Note: if the specified character is not assigned a name by
   the UnicodeData file (part of the Unicode Character
   Database maintained by the Unicode Consortium), the returned
   name is the same as the result of expression.

   Character.UnicodeBlock.of(codePoint).toString().replace('_', ' ')
        ` `
        Integer.toHexString(codePoint).toUpperCase(Locale.ENGLISH);

  code-point - the character (Unicode code point) - `int`

  returns: the Unicode name of the specified character, or null if
           the code point is unassigned. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if the specified codePoint is not a valid Unicode code point."
  ([^Integer code-point]
    (Character/getName code-point)))

(defn *to-chars
  "Converts the specified character (Unicode code point) to its
   UTF-16 representation. If the specified code point is a BMP
   (Basic Multilingual Plane or Plane 0) value, the same value is
   stored in dst[dstIndex], and 1 is returned. If the
   specified code point is a supplementary character, its
   surrogate values are stored in dst[dstIndex]
   (high-surrogate) and dst[dstIndex+1]
   (low-surrogate), and 2 is returned.

  code-point - the character (Unicode code point) to be converted. - `int`
  dst - an array of char in which the codePoint's UTF-16 value is stored. - `char[]`
  dst-index - the start index into the dst array where the converted value is stored. - `int`

  returns: 1 if the code point is a BMP code point, 2 if the
   code point is a supplementary code point. - `int`

  throws: java.lang.IllegalArgumentException - if the specified codePoint is not a valid Unicode code point."
  ([^Integer code-point dst ^Integer dst-index]
    (Character/toChars code-point dst dst-index))
  ([^Integer code-point]
    (Character/toChars code-point)))

(defn *get-numeric-value
  "Returns the int value that the specified Unicode
   character represents. For example, the character
   '\u216C' (the roman numeral fifty) will return
   an int with a value of 50.

   The letters A-Z in their uppercase ('\u0041' through
   '\u005A'), lowercase
   ('\u0061' through '\u007A'), and
   full width variant ('\uFF21' through
   '\uFF3A' and '\uFF41' through
   '\uFF5A') forms have numeric values from 10
   through 35. This is independent of the Unicode specification,
   which does not assign numeric values to these char
   values.

   If the character does not have a numeric value, then -1 is returned.
   If the character has a numeric value that cannot be represented as a
   nonnegative integer (for example, a fractional value), then -2
   is returned.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the getNumericValue(int) method.

  ch - the character to be converted. - `char`

  returns: the numeric value of the character, as a nonnegative int
             value; -2 if the character has a numeric value that is not a
            nonnegative integer; -1 if the character has no numeric value. - `int`"
  ([^Character ch]
    (Character/getNumericValue ch)))

(defn *letter?
  "Determines if the specified character is a letter.

   A character is considered to be a letter if its general
   category type, provided by Character.getType(ch),
   is any of the following:

    UPPERCASE_LETTER
    LOWERCASE_LETTER
    TITLECASE_LETTER
    MODIFIER_LETTER
    OTHER_LETTER


   Not all letters have case. Many characters are
   letters but are neither uppercase nor lowercase nor titlecase.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isLetter(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is a letter;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isLetter ch)))

(defn *letter-or-digit?
  "Determines if the specified character is a letter or digit.

   A character is considered to be a letter or digit if either
   Character.isLetter(char ch) or
   Character.isDigit(char ch) returns
   true for the character.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isLetterOrDigit(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is a letter or digit;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isLetterOrDigit ch)))

(defn *upper-case?
  "Determines if the specified character is an uppercase character.

   A character is uppercase if its general category type, provided by
   Character.getType(ch), is UPPERCASE_LETTER.
   or it has contributory property Other_Uppercase as defined by the Unicode Standard.

   The following are examples of uppercase characters:


   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
   '\u00C0' '\u00C1' '\u00C2' '\u00C3' '\u00C4' '\u00C5' '\u00C6' '\u00C7'
   '\u00C8' '\u00C9' '\u00CA' '\u00CB' '\u00CC' '\u00CD' '\u00CE' '\u00CF'
   '\u00D0' '\u00D1' '\u00D2' '\u00D3' '\u00D4' '\u00D5' '\u00D6' '\u00D8'
   '\u00D9' '\u00DA' '\u00DB' '\u00DC' '\u00DD' '\u00DE'
    Many other Unicode characters are uppercase too.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isUpperCase(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is uppercase;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isUpperCase ch)))

(defn *to-upper-case
  "Converts the character argument to uppercase using case mapping
   information from the UnicodeData file.

   Note that
   Character.isUpperCase(Character.toUpperCase(ch))
   does not always return true for some ranges of
   characters, particularly those that are symbols or ideographs.

   In general, String.toUpperCase() should be used to map
   characters to uppercase. String case mapping methods
   have several benefits over Character case mapping methods.
   String case mapping methods can perform locale-sensitive
   mappings, context-sensitive mappings, and 1:M character mappings, whereas
   the Character case mapping methods cannot.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the toUpperCase(int) method.

  ch - the character to be converted. - `char`

  returns: the uppercase equivalent of the character, if any;
            otherwise, the character itself. - `char`"
  ([^Character ch]
    (Character/toUpperCase ch)))

(defn *mirrored?
  "Determines whether the character is mirrored according to the
   Unicode specification.  Mirrored characters should have their
   glyphs horizontally mirrored when displayed in text that is
   right-to-left.  For example, '\u0028' LEFT
   PARENTHESIS is semantically defined to be an opening
   parenthesis.  This will appear as a `(` in text that is
   left-to-right but as a `)` in text that is right-to-left.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isMirrored(int) method.

  ch - char for which the mirrored property is requested - `char`

  returns: true if the char is mirrored, false
           if the char is not mirrored or is not defined. - `boolean`"
  ([^Character ch]
    (Character/isMirrored ch)))

(defn *offset-by-code-points
  "Returns the index within the given char subarray
   that is offset from the given index by
   codePointOffset code points. The
   start and count arguments specify a
   subarray of the char array. Unpaired surrogates
   within the text range given by index and
   codePointOffset count as one code point each.

  a - the char array - `char[]`
  start - the index of the first char of the subarray - `int`
  count - the length of the subarray in chars - `int`
  index - the index to be offset - `int`
  code-point-offset - the offset in code points - `int`

  returns: the index within the subarray - `int`

  throws: java.lang.NullPointerException - if a is null."
  ([a ^Integer start ^Integer count ^Integer index ^Integer code-point-offset]
    (Character/offsetByCodePoints a start count index code-point-offset))
  ([^java.lang.CharSequence seq ^Integer index ^Integer code-point-offset]
    (Character/offsetByCodePoints seq index code-point-offset)))

(defn *surrogate-pair?
  "Determines whether the specified pair of char
   values is a valid

   Unicode surrogate pair.

   This method is equivalent to the expression:


   isHighSurrogate(high) && isLowSurrogate(low)

  high - the high-surrogate code value to be tested - `char`
  low - the low-surrogate code value to be tested - `char`

  returns: true if the specified high and
   low-surrogate code values represent a valid surrogate pair;
   false otherwise. - `boolean`"
  ([^Character high ^Character low]
    (Character/isSurrogatePair high low)))

(defn *ideographic?
  "Determines if the specified character (Unicode code point) is a CJKV
   (Chinese, Japanese, Korean and Vietnamese) ideograph, as defined by
   the Unicode Standard.

  code-point - the character (Unicode code point) to be tested. - `int`

  returns: true if the character is a Unicode ideograph
            character, false otherwise. - `boolean`"
  ([^Integer code-point]
    (Character/isIdeographic code-point)))

(defn *reverse-bytes
  "Returns the value obtained by reversing the order of the bytes in the
   specified char value.

  ch - The char of which to reverse the byte order. - `char`

  returns: the value obtained by reversing (or, equivalently, swapping)
       the bytes in the specified char value. - `char`"
  ([^Character ch]
    (Character/reverseBytes ch)))

(defn *supplementary-code-point?
  "Determines whether the specified character (Unicode code point)
   is in the supplementary character range.

  code-point - the character (Unicode code point) to be tested - `int`

  returns: true if the specified code point is between
           MIN_SUPPLEMENTARY_CODE_POINT and
           MAX_CODE_POINT inclusive;
           false otherwise. - `boolean`"
  ([^Integer code-point]
    (Character/isSupplementaryCodePoint code-point)))

(defn *unicode-identifier-part?
  "Determines if the specified character may be part of a Unicode
   identifier as other than the first character.

   A character may be part of a Unicode identifier if and only if
   one of the following statements is true:

     it is a letter
     it is a connecting punctuation character (such as '_')
     it is a digit
     it is a numeric letter (such as a Roman numeral character)
     it is a combining mark
     it is a non-spacing mark
    isIdentifierIgnorable returns
   true for this character.


   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isUnicodeIdentifierPart(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character may be part of a
            Unicode identifier; false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isUnicodeIdentifierPart ch)))

(defn *high-surrogate?
  "Determines if the given char value is a

   Unicode high-surrogate code unit
   (also known as leading-surrogate code unit).

   Such values do not represent characters by themselves,
   but are used in the representation of
   supplementary characters
   in the UTF-16 encoding.

  ch - the char value to be tested. - `char`

  returns: true if the char value is between
           MIN_HIGH_SURROGATE and
           MAX_HIGH_SURROGATE inclusive;
           false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isHighSurrogate ch)))

(defn *identifier-ignorable?
  "Determines if the specified character should be regarded as
   an ignorable character in a Java identifier or a Unicode identifier.

   The following Unicode characters are ignorable in a Java identifier
   or a Unicode identifier:

   ISO control characters that are not whitespace

   '\u0000' through '\u0008'
   '\u000E' through '\u001B'
   '\u007F' through '\u009F'


   all characters that have the FORMAT general
   category value


   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isIdentifierIgnorable(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is an ignorable control
            character that may be part of a Java or Unicode identifier;
             false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isIdentifierIgnorable ch)))

(defn *surrogate?
  "Determines if the given char value is a Unicode
   surrogate code unit.

   Such values do not represent characters by themselves,
   but are used in the representation of
   supplementary characters
   in the UTF-16 encoding.

   A char value is a surrogate code unit if and only if it is either
   a low-surrogate code unit or
   a high-surrogate code unit.

  ch - the char value to be tested. - `char`

  returns: true if the char value is between
           MIN_SURROGATE and
           MAX_SURROGATE inclusive;
           false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isSurrogate ch)))

(defn *get-directionality
  "Returns the Unicode directionality property for the given
   character.  Character directionality is used to calculate the
   visual ordering of text. The directionality value of undefined
   char values is DIRECTIONALITY_UNDEFINED.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the getDirectionality(int) method.

  ch - char for which the directionality property is requested. - `char`

  returns: the directionality property of the char value. - `byte`"
  ([^Character ch]
    (Character/getDirectionality ch)))

(defn *title-case?
  "Determines if the specified character is a titlecase character.

   A character is a titlecase character if its general
   category type, provided by Character.getType(ch),
   is TITLECASE_LETTER.

   Some characters look like pairs of Latin letters. For example, there
   is an uppercase letter that looks like `LJ` and has a corresponding
   lowercase letter that looks like `lj`. A third form, which looks like `Lj`,
   is the appropriate form to use when rendering a word in lowercase
   with initial capitals, as for a book title.

   These are some of the Unicode characters for which this method returns
   true:

   LATIN CAPITAL LETTER D WITH SMALL LETTER Z WITH CARON
   LATIN CAPITAL LETTER L WITH SMALL LETTER J
   LATIN CAPITAL LETTER N WITH SMALL LETTER J
   LATIN CAPITAL LETTER D WITH SMALL LETTER Z

    Many other Unicode characters are titlecase too.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isTitleCase(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is titlecase;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isTitleCase ch)))

(defn *hash-code
  "Returns a hash code for a char value; compatible with
   Character.hashCode().

  value - The char for which to return a hash code. - `char`

  returns: a hash code value for a char value. - `int`"
  ([^Character value]
    (Character/hashCode value)))

(defn *defined?
  "Determines if a character is defined in Unicode.

   A character is defined if at least one of the following is true:

   It has an entry in the UnicodeData file.
   It has a value in a range defined by the UnicodeData file.


   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isDefined(int) method.

  ch - the character to be tested - `char`

  returns: true if the character has a defined meaning
            in Unicode; false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isDefined ch)))

(defn *is-java-letter
  "Deprecated. Replaced by isJavaIdentifierStart(char).

  ch - the character to be tested. - `char`

  returns: true if the character may start a Java
            identifier; false otherwise. - `java.lang.   boolean`"
  ([^Character ch]
    (Character/isJavaLetter ch)))

(defn *digit?
  "Determines if the specified character is a digit.

   A character is a digit if its general category type, provided
   by Character.getType(ch), is
   DECIMAL_DIGIT_NUMBER.

   Some Unicode character ranges that contain digits:

   '\u0030' through '\u0039',
       ISO-LATIN-1 digits ('0' through '9')
   '\u0660' through '\u0669',
       Arabic-Indic digits
   '\u06F0' through '\u06F9',
       Extended Arabic-Indic digits
   '\u0966' through '\u096F',
       Devanagari digits
   '\uFF10' through '\uFF19',
       Fullwidth digits


   Many other character ranges contain digits as well.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isDigit(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is a digit;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isDigit ch)))

(defn *code-point-count
  "Returns the number of Unicode code points in the text range of
   the specified char sequence. The text range begins at the
   specified beginIndex and extends to the
   char at index endIndex - 1. Thus the
   length (in chars) of the text range is
   endIndex-beginIndex. Unpaired surrogates within
   the text range count as one code point each.

  seq - the char sequence - `java.lang.CharSequence`
  begin-index - the index to the first char of the text range. - `int`
  end-index - the index after the last char of the text range. - `int`

  returns: the number of Unicode code points in the specified text
   range - `int`

  throws: java.lang.NullPointerException - if seq is null."
  ([^java.lang.CharSequence seq ^Integer begin-index ^Integer end-index]
    (Character/codePointCount seq begin-index end-index)))

(defn *to-title-case
  "Converts the character argument to titlecase using case mapping
   information from the UnicodeData file. If a character has no
   explicit titlecase mapping and is not itself a titlecase char
   according to UnicodeData, then the uppercase mapping is
   returned as an equivalent titlecase mapping. If the
   char argument is already a titlecase
   char, the same char value will be
   returned.

   Note that
   Character.isTitleCase(Character.toTitleCase(ch))
   does not always return true for some ranges of
   characters.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the toTitleCase(int) method.

  ch - the character to be converted. - `char`

  returns: the titlecase equivalent of the character, if any;
            otherwise, the character itself. - `char`"
  ([^Character ch]
    (Character/toTitleCase ch)))

(defn *code-point-before
  "Returns the code point preceding the given index of the
   char array, where only array elements with
   index greater than or equal to start
   can be used. If the char value at (index - 1)
   in the char array is in the
   low-surrogate range, (index - 2) is not less than
   start, and the char value at
   (index - 2) in the char array is in
   the high-surrogate range, then the supplementary code point
   corresponding to this surrogate pair is returned. Otherwise,
   the char value at (index - 1) is
   returned.

  a - the char array - `char[]`
  index - the index following the code point that should be returned - `int`
  start - the index of the first array element in the char array - `int`

  returns: the Unicode code point value before the given index. - `int`

  throws: java.lang.NullPointerException - if a is null."
  ([a ^Integer index ^Integer start]
    (Character/codePointBefore a index start))
  ([^java.lang.CharSequence seq ^Integer index]
    (Character/codePointBefore seq index)))

(defn *whitespace?
  "Determines if the specified character is white space according to Java.
   A character is a Java whitespace character if and only if it satisfies
   one of the following criteria:

    It is a Unicode space character (SPACE_SEPARATOR,
        LINE_SEPARATOR, or PARAGRAPH_SEPARATOR)
        but is not also a non-breaking space ('\u00A0',
        '\u2007', '\u202F').
    It is '\t', U+0009 HORIZONTAL TABULATION.
    It is '\n', U+000A LINE FEED.
    It is '\u000B', U+000B VERTICAL TABULATION.
    It is '\f', U+000C FORM FEED.
    It is '\r', U+000D CARRIAGE RETURN.
    It is '\u001C', U+001C FILE SEPARATOR.
    It is '\u001D', U+001D GROUP SEPARATOR.
    It is '\u001E', U+001E RECORD SEPARATOR.
    It is '\u001F', U+001F UNIT SEPARATOR.


   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isWhitespace(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character is a Java whitespace
            character; false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isWhitespace ch)))

(defn *java-identifier-start?
  "Determines if the specified character is
   permissible as the first character in a Java identifier.

   A character may start a Java identifier if and only if
   one of the following conditions is true:

    isLetter(ch) returns true
    getType(ch) returns LETTER_NUMBER
    ch is a currency symbol (such as '$')
    ch is a connecting punctuation character (such as '_').


   These conditions are tested against the character information from version
   6.2 of the Unicode Standard.

   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the isJavaIdentifierStart(int) method.

  ch - the character to be tested. - `char`

  returns: true if the character may start a Java identifier;
            false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isJavaIdentifierStart ch)))

(defn *low-surrogate?
  "Determines if the given char value is a

   Unicode low-surrogate code unit
   (also known as trailing-surrogate code unit).

   Such values do not represent characters by themselves,
   but are used in the representation of
   supplementary characters
   in the UTF-16 encoding.

  ch - the char value to be tested. - `char`

  returns: true if the char value is between
           MIN_LOW_SURROGATE and
           MAX_LOW_SURROGATE inclusive;
           false otherwise. - `boolean`"
  ([^Character ch]
    (Character/isLowSurrogate ch)))

(defn *char-count
  "Determines the number of char values needed to
   represent the specified character (Unicode code point). If the
   specified character is equal to or greater than 0x10000, then
   the method returns 2. Otherwise, the method returns 1.

   This method doesn't validate the specified character to be a
   valid Unicode code point. The caller must validate the
   character value using isValidCodePoint
   if necessary.

  code-point - the character (Unicode code point) to be tested. - `int`

  returns: 2 if the character is a valid supplementary character; 1 otherwise. - `int`"
  ([^Integer code-point]
    (Character/charCount code-point)))

(defn *digit
  "Returns the numeric value of the character ch in the
   specified radix.

   If the radix is not in the range MIN_RADIX ≤
   radix ≤ MAX_RADIX or if the
   value of ch is not a valid digit in the specified
   radix, -1 is returned. A character is a valid digit
   if at least one of the following is true:

   The method isDigit is true of the character
       and the Unicode decimal digit value of the character (or its
       single-character decomposition) is less than the specified radix.
       In this case the decimal digit value is returned.
   The character is one of the uppercase Latin letters
       'A' through 'Z' and its code is less than
       radix  'A' - 10.
       In this case, ch - 'A'  10
       is returned.
   The character is one of the lowercase Latin letters
       'a' through 'z' and its code is less than
       radix  'a' - 10.
       In this case, ch - 'a'  10
       is returned.
   The character is one of the fullwidth uppercase Latin letters A
       ('\uFF21') through Z ('\uFF3A')
       and its code is less than
       radix  '\uFF21' - 10.
       In this case, ch - '\uFF21'  10
       is returned.
   The character is one of the fullwidth lowercase Latin letters a
       ('\uFF41') through z ('\uFF5A')
       and its code is less than
       radix  '\uFF41' - 10.
       In this case, ch - '\uFF41'  10
       is returned.


   Note: This method cannot handle  supplementary characters. To support
   all Unicode characters, including supplementary characters, use
   the digit(int, int) method.

  ch - the character to be converted. - `char`
  radix - the radix. - `int`

  returns: the numeric value represented by the character in the
            specified radix. - `int`"
  ([^Character ch ^Integer radix]
    (Character/digit ch radix)))

(defn *code-point-at
  "Returns the code point at the given index of the
   char array, where only array elements with
   index less than limit can be used. If
   the char value at the given index in the
   char array is in the high-surrogate range, the
   following index is less than the limit, and the
   char value at the following index is in the
   low-surrogate range, then the supplementary code point
   corresponding to this surrogate pair is returned. Otherwise,
   the char value at the given index is returned.

  a - the char array - `char[]`
  index - the index to the char values (Unicode code units) in the char array to be converted - `int`
  limit - the index after the last array element that can be used in the char array - `int`

  returns: the Unicode code point at the given index - `int`

  throws: java.lang.NullPointerException - if a is null."
  ([a ^Integer index ^Integer limit]
    (Character/codePointAt a index limit))
  ([^java.lang.CharSequence seq ^Integer index]
    (Character/codePointAt seq index)))

(defn char-value
  "Returns the value of this Character object.

  returns: the primitive char value represented by
            this object. - `char`"
  ([^java.lang.Character this]
    (-> this (.charValue))))

(defn hash-code
  "Returns a hash code for this Character; equal to the result
   of invoking charValue().

  returns: a hash code value for this Character - `int`"
  ([^java.lang.Character this]
    (-> this (.hashCode))))

(defn equals
  "Compares this object against the specified object.
   The result is true if and only if the argument is not
   null and is a Character object that
   represents the same char value as this object.

  obj - the object to compare with. - `java.lang.Object`

  returns: true if the objects are the same;
            false otherwise. - `boolean`"
  ([^java.lang.Character this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-string
  "Returns a String object representing this
   Character's value.  The result is a string of
   length 1 whose sole component is the primitive
   char value represented by this
   Character object.

  returns: a string representation of this object. - `java.lang.String`"
  ([^java.lang.Character this]
    (-> this (.toString))))

(defn compare-to
  "Compares two Character objects numerically.

  another-character - the Character to be compared. - `java.lang.Character`

  returns: the value 0 if the argument Character
            is equal to this Character; a value less than
            0 if this Character is numerically less
            than the Character argument; and a value greater than
            0 if this Character is numerically greater
            than the Character argument (unsigned comparison).
            Note that this is strictly a numerical comparison; it is not
            locale-dependent. - `int`"
  ([^java.lang.Character this ^java.lang.Character another-character]
    (-> this (.compareTo another-character))))

