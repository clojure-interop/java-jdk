(ns jdk.text.DecimalFormat
  "DecimalFormat is a concrete subclass of
  NumberFormat that formats decimal numbers. It has a variety of
  features designed to make it possible to parse and format numbers in any
  locale, including support for Western, Arabic, and Indic digits.  It also
  supports different kinds of numbers, including integers (123), fixed-point
  numbers (123.4), scientific notation (1.23E4), percentages (12%), and
  currency amounts ($123).  All of these can be localized.

  To obtain a NumberFormat for a specific locale, including the
  default locale, call one of NumberFormat's factory methods, such
  as getInstance().  In general, do not call the
  DecimalFormat constructors directly, since the
  NumberFormat factory methods may return subclasses other than
  DecimalFormat. If you need to customize the format object, do
  something like this:



  NumberFormat f = NumberFormat.getInstance(loc);
  if (f instanceof DecimalFormat) {
      ((DecimalFormat) f).setDecimalSeparatorAlwaysShown(true);
  }

  A DecimalFormat comprises a pattern and a set of
  symbols.  The pattern may be set directly using
  applyPattern(), or indirectly using the API methods.  The
  symbols are stored in a DecimalFormatSymbols object.  When using
  the NumberFormat factory methods, the pattern and symbols are
  read from localized ResourceBundles.

  Patterns

  DecimalFormat patterns have the following syntax:


  Pattern:
          PositivePattern
          PositivePattern ; NegativePattern
  PositivePattern:
          Prefixopt Number Suffixopt
  NegativePattern:
          Prefixopt Number Suffixopt
  Prefix:
          any Unicode characters except \uFFFE, \uFFFF, and special characters
  Suffix:
          any Unicode characters except \uFFFE, \uFFFF, and special characters
  Number:
          Integer Exponentopt
          Integer . Fraction Exponentopt
  Integer:
          MinimumInteger
          #
          # Integer
          # , Integer
  MinimumInteger:
          0
          0 MinimumInteger
          0 , MinimumInteger
  Fraction:
          MinimumFractionopt OptionalFractionopt
  MinimumFraction:
          0 MinimumFractionopt
  OptionalFraction:
          # OptionalFractionopt
  Exponent:
          E MinimumExponent
  MinimumExponent:
          0 MinimumExponentopt

  A DecimalFormat pattern contains a positive and negative
  subpattern, for example, `#,##0.00;(#,##0.00)`.  Each
  subpattern has a prefix, numeric part, and suffix. The negative subpattern
  is optional; if absent, then the positive subpattern prefixed with the
  localized minus sign ('-' in most locales) is used as the
  negative subpattern. That is, `0.00` alone is equivalent to
  `0.00;-0.00`.  If there is an explicit negative subpattern, it
  serves only to specify the negative prefix and suffix; the number of digits,
  minimal digits, and other characteristics are all the same as the positive
  pattern. That means that `#,##0.0#;(#)` produces precisely
  the same behavior as `#,##0.0#;(#,##0.0#)`.

  The prefixes, suffixes, and various symbols used for infinity, digits,
  thousands separators, decimal separators, etc. may be set to arbitrary
  values, and they will appear properly during formatting.  However, care must
  be taken that the symbols and strings do not conflict, or parsing will be
  unreliable.  For example, either the positive and negative prefixes or the
  suffixes must be distinct for DecimalFormat.parse() to be able
  to distinguish positive from negative values.  (If they are identical, then
  DecimalFormat will behave as if no negative subpattern was
  specified.)  Another example is that the decimal separator and thousands
  separator should be distinct characters, or parsing will be impossible.

  The grouping separator is commonly used for thousands, but in some
  countries it separates ten-thousands. The grouping size is a constant number
  of digits between the grouping characters, such as 3 for 100,000,000 or 4 for
  1,0000,0000.  If you supply a pattern with multiple grouping characters, the
  interval between the last one and the end of the integer is the one that is
  used. So `#,##,###,####` == `######,####` ==
  `##,####,####`.

  Special Pattern Characters

  Many characters in a pattern are taken literally; they are matched during
  parsing and output unchanged during formatting.  Special characters, on the
  other hand, stand for other characters, strings, or classes of characters.
  They must be quoted, unless noted otherwise, if they are to appear in the
  prefix or suffix as literals.

  The characters listed here are used in non-localized patterns.  Localized
  patterns use the corresponding characters taken from this formatter's
  DecimalFormatSymbols object instead, and these characters lose
  their special status.  Two exceptions are the currency sign and quote, which
  are not localized.




           Symbol
           Location
           Localized?
           Meaning

           0
           Number
           Yes
           Digit

           #
           Number
           Yes
           Digit, zero shows as absent

           .
           Number
           Yes
           Decimal separator or monetary decimal separator

           -
           Number
           Yes
           Minus sign

           ,
           Number
           Yes
           Grouping separator

           E
           Number
           Yes
           Separates mantissa and exponent in scientific notation.
               Need not be quoted in prefix or suffix.

           ;
           Subpattern boundary
           Yes
           Separates positive and negative subpatterns

           %
           Prefix or suffix
           Yes
           Multiply by 100 and show as percentage

           \u2030
           Prefix or suffix
           Yes
           Multiply by 1000 and show as per mille value

           ¤ (\u00A4)
           Prefix or suffix
           No
           Currency sign, replaced by currency symbol.  If
               doubled, replaced by international currency symbol.
               If present in a pattern, the monetary decimal separator
               is used instead of the decimal separator.

           '
           Prefix or suffix
           No
           Used to quote special characters in a prefix or suffix,
               for example, `'#'#` formats 123 to
               `#123`.  To create a single quote
               itself, use two in a row: `# o''clock`.



  Scientific Notation

  Numbers in scientific notation are expressed as the product of a mantissa
  and a power of ten, for example, 1234 can be expressed as 1.234 x 10^3.  The
  mantissa is often in the range 1.0 ≤ x < 10.0, but it need not
  be.
  DecimalFormat can be instructed to format and parse scientific
  notation only via a pattern; there is currently no factory method
  that creates a scientific notation format.  In a pattern, the exponent
  character immediately followed by one or more digit characters indicates
  scientific notation.  Example: `0.###E0` formats the number
  1234 as `1.234E3`.


  The number of digit characters after the exponent character gives the
  minimum exponent digit count.  There is no maximum.  Negative exponents are
  formatted using the localized minus sign, not the prefix and suffix
  from the pattern.  This allows patterns such as `0.###E0 m/s`.

  The minimum and maximum number of integer digits are interpreted
  together:


  If the maximum number of integer digits is greater than their minimum number
  and greater than 1, it forces the exponent to be a multiple of the maximum
  number of integer digits, and the minimum number of integer digits to be
  interpreted as 1.  The most common use of this is to generate
  engineering notation, in which the exponent is a multiple of three,
  e.g., `##0.#####E0`. Using this pattern, the number 12345
  formats to `12.345E3`, and 123456 formats to
  `123.456E3`.

  Otherwise, the minimum number of integer digits is achieved by adjusting the
  exponent.  Example: 0.00123 formatted with `00.###E0` yields
  `12.3E-4`.


  The number of significant digits in the mantissa is the sum of the
  minimum integer and maximum fraction digits, and is
  unaffected by the maximum integer digits.  For example, 12345 formatted with
  `##0.##E0` is `12.3E3`. To show all digits, set
  the significant digits count to zero.  The number of significant digits
  does not affect parsing.

  Exponential patterns may not contain grouping separators.


  Rounding

  DecimalFormat provides rounding modes defined in
  RoundingMode for formatting.  By default, it uses
  RoundingMode.HALF_EVEN.

  Digits

  For formatting, DecimalFormat uses the ten consecutive
  characters starting with the localized zero digit defined in the
  DecimalFormatSymbols object as digits. For parsing, these
  digits as well as all Unicode decimal digits, as defined by
  Character.digit, are recognized.

  Special Values

  NaN is formatted as a string, which typically has a single character
  \uFFFD.  This string is determined by the
  DecimalFormatSymbols object.  This is the only value for which
  the prefixes and suffixes are not used.

  Infinity is formatted as a string, which typically has a single character
  \u221E, with the positive or negative prefixes and suffixes
  applied.  The infinity string is determined by the
  DecimalFormatSymbols object.

  Negative zero (`-0`) parses to

  BigDecimal(0) if isParseBigDecimal() is
  true,
  Long(0) if isParseBigDecimal() is false
      and isParseIntegerOnly() is true,
  Double(-0.0) if both isParseBigDecimal()
  and isParseIntegerOnly() are false.


  Synchronization


  Decimal formats are generally not synchronized.
  It is recommended to create separate format instances for each thread.
  If multiple threads access a format concurrently, it must be synchronized
  externally.

  Example



  <strong>// Print out a number using the localized number, integer, currency,
  // and percent format for each locale</strong>
  Locale[] locales = NumberFormat.getAvailableLocales();
  double myNumber = -1234.56;
  NumberFormat form;
  for (int j = 0; j < 4; +j) {
      System.out.println(`FORMAT`);
      for (int i = 0; i < locales.length; +i) {
          if (locales[i].getCountry().length() == 0) {
             continue; // Skip language-only locales
          }
          System.out.print(locales[i].getDisplayName());
          switch (j) {
          case 0:
              form = NumberFormat.getInstance(locales[i]); break;
          case 1:
              form = NumberFormat.getIntegerInstance(locales[i]); break;
          case 2:
              form = NumberFormat.getCurrencyInstance(locales[i]); break;
          default:
              form = NumberFormat.getPercentInstance(locales[i]); break;
          }
          if (form instanceof DecimalFormat) {
              System.out.print(`: `  ((DecimalFormat) form).toPattern());
          }
          System.out.print(` -> `  form.format(myNumber));
          try {
              System.out.println(` -> `  form.parse(form.format(myNumber)));
          } catch (ParseException e) {}
      }
  }"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text DecimalFormat]))

(defn ->decimal-format
  "Constructor.

  Creates a DecimalFormat using the given pattern and symbols.
   Use this constructor when you need to completely customize the
   behavior of the format.

   To obtain standard formats for a given
   locale, use the factory methods on NumberFormat such as
   getInstance or getCurrencyInstance. If you need only minor adjustments
   to a standard format, you can modify the format returned by
   a NumberFormat factory method.

  pattern - a non-localized pattern string - `java.lang.String`
  symbols - the set of symbols to be used - `java.text.DecimalFormatSymbols`

  throws: java.lang.NullPointerException - if any of the given arguments is null"
  ([pattern symbols]
    (new DecimalFormat pattern symbols))
  ([pattern]
    (new DecimalFormat pattern))
  ([]
    (new DecimalFormat )))

(defn set-grouping-size
  "Set the grouping size. Grouping size is the number of digits between
   grouping separators in the integer portion of a number.  For example,
   in the number `123,456.78`, the grouping size is 3.

   The value passed in is converted to a byte, which may lose information.

  new-value - the new grouping size - `int`"
  ([this new-value]
    (-> this (.setGroupingSize new-value))))

(defn set-rounding-mode
  "Sets the RoundingMode used in this DecimalFormat.

  rounding-mode - The RoundingMode to be used - `java.math.RoundingMode`

  throws: java.lang.NullPointerException - if roundingMode is null."
  ([this rounding-mode]
    (-> this (.setRoundingMode rounding-mode))))

(defn set-minimum-integer-digits
  "Sets the minimum number of digits allowed in the integer portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of newValue and
   309 is used. Negative input values are replaced with 0.

  new-value - the minimum number of integer digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMinimumIntegerDigits new-value))))

(defn set-decimal-format-symbols
  "Sets the decimal format symbols, which is generally not changed
   by the programmer or user.

  new-symbols - desired DecimalFormatSymbols - `java.text.DecimalFormatSymbols`"
  ([this new-symbols]
    (-> this (.setDecimalFormatSymbols new-symbols))))

(defn get-minimum-integer-digits
  "Gets the minimum number of digits allowed in the integer portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of the return value and
   309 is used.

  returns: the minimum number of digits - `int`"
  ([this]
    (-> this (.getMinimumIntegerDigits))))

(defn get-negative-suffix
  "Get the negative suffix.
   Examples: -123%, ($123) (with positive suffixes)

  returns: the negative suffix - `java.lang.String`"
  ([this]
    (-> this (.getNegativeSuffix))))

(defn set-negative-suffix
  "Set the negative suffix.
   Examples: 123%

  new-value - the new negative suffix - `java.lang.String`"
  ([this new-value]
    (-> this (.setNegativeSuffix new-value))))

(defn set-currency
  "Sets the currency used by this number format when formatting
   currency values. This does not update the minimum or maximum
   number of fraction digits used by the number format.
   The currency is set by calling
   DecimalFormatSymbols.setCurrency
   on this number format's symbols.

  currency - the new currency to be used by this decimal format - `java.util.Currency`

  throws: java.lang.NullPointerException - if currency is null"
  ([this currency]
    (-> this (.setCurrency currency))))

(defn set-decimal-separator-always-shown
  "Allows you to set the behavior of the decimal separator with integers.
   (The decimal separator will always appear with decimals.)
   Example: Decimal ON: 12345 → 12345.; OFF: 12345 → 12345

  new-value - true if the decimal separator is always shown; false otherwise - `boolean`"
  ([this new-value]
    (-> this (.setDecimalSeparatorAlwaysShown new-value))))

(defn parse-big-decimal?
  "Returns whether the parse(java.lang.String, java.text.ParsePosition)
   method returns BigDecimal. The default value is false.

  returns: true if the parse method returns BigDecimal;
           false otherwise - `boolean`"
  ([this]
    (-> this (.isParseBigDecimal))))

(defn set-negative-prefix
  "Set the negative prefix.
   Examples: -123, ($123) (with negative suffix), sFr-123

  new-value - the new negative prefix - `java.lang.String`"
  ([this new-value]
    (-> this (.setNegativePrefix new-value))))

(defn get-grouping-size
  "Return the grouping size. Grouping size is the number of digits between
   grouping separators in the integer portion of a number.  For example,
   in the number `123,456.78`, the grouping size is 3.

  returns: the grouping size - `int`"
  ([this]
    (-> this (.getGroupingSize))))

(defn to-pattern
  "Synthesizes a pattern string that represents the current state
   of this Format object.

  returns: a pattern string - `java.lang.String`"
  ([this]
    (-> this (.toPattern))))

(defn set-parse-big-decimal
  "Sets whether the parse(java.lang.String, java.text.ParsePosition)
   method returns BigDecimal.

  new-value - true if the parse method returns BigDecimal; false otherwise - `boolean`"
  ([this new-value]
    (-> this (.setParseBigDecimal new-value))))

(defn set-multiplier
  "Sets the multiplier for use in percent, per mille, and similar
   formats.
   For a percent format, set the multiplier to 100 and the suffixes to
   have '%' (for Arabic, use the Arabic percent sign).
   For a per mille format, set the multiplier to 1000 and the suffixes to
   have '\u2030'.

   Example: with multiplier 100, 1.23 is formatted as `123`, and
   `123` is parsed into 1.23.

  new-value - the new multiplier - `int`"
  ([this new-value]
    (-> this (.setMultiplier new-value))))

(defn get-positive-prefix
  "Get the positive prefix.
   Examples: 123, $123, sFr123

  returns: the positive prefix - `java.lang.String`"
  ([this]
    (-> this (.getPositivePrefix))))

(defn get-multiplier
  "Gets the multiplier for use in percent, per mille, and similar
   formats.

  returns: the multiplier - `int`"
  ([this]
    (-> this (.getMultiplier))))

(defn format-to-character-iterator
  "Formats an Object producing an AttributedCharacterIterator.
   You can use the returned AttributedCharacterIterator
   to build the resulting String, as well as to determine information
   about the resulting String.

   Each attribute key of the AttributedCharacterIterator will be of type
   NumberFormat.Field, with the attribute value being the
   same as the attribute key.

  obj - The object to format - `java.lang.Object`

  returns: AttributedCharacterIterator describing the formatted value. - `java.text.AttributedCharacterIterator`

  throws: java.lang.NullPointerException - if obj is null."
  ([this obj]
    (-> this (.formatToCharacterIterator obj))))

(defn set-maximum-integer-digits
  "Sets the maximum number of digits allowed in the integer portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of newValue and
   309 is used. Negative input values are replaced with 0.

  new-value - the maximum number of integer digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMaximumIntegerDigits new-value))))

(defn decimal-separator-always-shown?
  "Allows you to get the behavior of the decimal separator with integers.
   (The decimal separator will always appear with decimals.)
   Example: Decimal ON: 12345 → 12345.; OFF: 12345 → 12345

  returns: true if the decimal separator is always shown;
           false otherwise - `boolean`"
  ([this]
    (-> this (.isDecimalSeparatorAlwaysShown))))

(defn get-negative-prefix
  "Get the negative prefix.
   Examples: -123, ($123) (with negative suffix), sFr-123

  returns: the negative prefix - `java.lang.String`"
  ([this]
    (-> this (.getNegativePrefix))))

(defn get-minimum-fraction-digits
  "Gets the minimum number of digits allowed in the fraction portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of the return value and
   340 is used.

  returns: the minimum number of digits - `int`"
  ([this]
    (-> this (.getMinimumFractionDigits))))

(defn apply-localized-pattern
  "Apply the given pattern to this Format object.  The pattern
   is assumed to be in a localized notation. A pattern is a
   short-hand specification for the various formatting properties.
   These properties can also be changed individually through the
   various setter methods.

   There is no limit to integer digits set
   by this routine, since that is the typical end-user desire;
   use setMaximumInteger if you want to set a real value.
   For negative numbers, use a second pattern, separated by a semicolon
   Example `#,#00.0#` → 1,234.56
   This means a minimum of 2 integer digits, 1 fraction digit, and
   a maximum of 2 fraction digits.
   Example: `#,#00.0#;(#,#00.0#)` for negatives in
   parentheses.
   In negative patterns, the minimum and maximum counts are ignored;
   these are presumed to be set in the positive pattern.

  pattern - a new pattern - `java.lang.String`

  throws: java.lang.NullPointerException - if pattern is null"
  ([this pattern]
    (-> this (.applyLocalizedPattern pattern))))

(defn get-maximum-fraction-digits
  "Gets the maximum number of digits allowed in the fraction portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of the return value and
   340 is used.

  returns: the maximum number of digits. - `int`"
  ([this]
    (-> this (.getMaximumFractionDigits))))

(defn get-maximum-integer-digits
  "Gets the maximum number of digits allowed in the integer portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of the return value and
   309 is used.

  returns: the maximum number of digits - `int`"
  ([this]
    (-> this (.getMaximumIntegerDigits))))

(defn set-positive-prefix
  "Set the positive prefix.
   Examples: 123, $123, sFr123

  new-value - the new positive prefix - `java.lang.String`"
  ([this new-value]
    (-> this (.setPositivePrefix new-value))))

(defn set-maximum-fraction-digits
  "Sets the maximum number of digits allowed in the fraction portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of newValue and
   340 is used. Negative input values are replaced with 0.

  new-value - the maximum number of fraction digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMaximumFractionDigits new-value))))

(defn clone
  "Standard override; no change in semantics.

  returns: a clone of this instance. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn parse
  "Parses text from a string to produce a Number.

   The method attempts to parse text starting at the index given by
   pos.
   If parsing succeeds, then the index of pos is updated
   to the index after the last character used (parsing does not necessarily
   use all characters up to the end of the string), and the parsed
   number is returned. The updated pos can be used to
   indicate the starting point for the next call to this method.
   If an error occurs, then the index of pos is not
   changed, the error index of pos is set to the index of
   the character where the error occurred, and null is returned.

   The subclass returned depends on the value of isParseBigDecimal()
   as well as on the string being parsed.

     If isParseBigDecimal() is false (the default),
         most integer values are returned as Long
         objects, no matter how they are written: `17` and
         `17.000` both parse to Long(17).
         Values that cannot fit into a Long are returned as
         Doubles. This includes values with a fractional part,
         infinite values, NaN, and the value -0.0.
         DecimalFormat does not decide whether to
         return a Double or a Long based on the
         presence of a decimal separator in the source string. Doing so
         would prevent integers that overflow the mantissa of a double,
         such as `-9,223,372,036,854,775,808.00`, from being
         parsed accurately.

         Callers may use the Number methods
         doubleValue, longValue, etc., to obtain
         the type they want.
     If isParseBigDecimal() is true, values are returned
         as BigDecimal objects. The values are the ones
         constructed by BigDecimal.BigDecimal(String)
         for corresponding strings in locale-independent format. The
         special cases negative and positive infinity and NaN are returned
         as Double instances holding the values of the
         corresponding Double constants.


   DecimalFormat parses all Unicode characters that represent
   decimal digits, as defined by Character.digit(). In
   addition, DecimalFormat also recognizes as digits the ten
   consecutive characters starting with the localized zero digit defined in
   the DecimalFormatSymbols object.

  text - the string to be parsed - `java.lang.String`
  pos - A ParsePosition object with index and error index information as described above. - `java.text.ParsePosition`

  returns: the parsed value, or null if the parse fails - `java.lang.Number`

  throws: java.lang.NullPointerException - if text or pos is null."
  ([this text pos]
    (-> this (.parse text pos))))

(defn set-minimum-fraction-digits
  "Sets the minimum number of digits allowed in the fraction portion of a
   number.
   For formatting numbers other than BigInteger and
   BigDecimal objects, the lower of newValue and
   340 is used. Negative input values are replaced with 0.

  new-value - the minimum number of fraction digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMinimumFractionDigits new-value))))

(defn hash-code
  "Overrides hashCode

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn get-decimal-format-symbols
  "Returns a copy of the decimal format symbols, which is generally not
   changed by the programmer or user.

  returns: a copy of the desired DecimalFormatSymbols - `java.text.DecimalFormatSymbols`"
  ([this]
    (-> this (.getDecimalFormatSymbols))))

(defn get-positive-suffix
  "Get the positive suffix.
   Example: 123%

  returns: the positive suffix - `java.lang.String`"
  ([this]
    (-> this (.getPositiveSuffix))))

(defn get-rounding-mode
  "Gets the RoundingMode used in this DecimalFormat.

  returns: The RoundingMode used for this DecimalFormat. - `java.math.RoundingMode`"
  ([this]
    (-> this (.getRoundingMode))))

(defn apply-pattern
  "Apply the given pattern to this Format object.  A pattern is a
   short-hand specification for the various formatting properties.
   These properties can also be changed individually through the
   various setter methods.

   There is no limit to integer digits set
   by this routine, since that is the typical end-user desire;
   use setMaximumInteger if you want to set a real value.
   For negative numbers, use a second pattern, separated by a semicolon
   Example `#,#00.0#` → 1,234.56
   This means a minimum of 2 integer digits, 1 fraction digit, and
   a maximum of 2 fraction digits.
   Example: `#,#00.0#;(#,#00.0#)` for negatives in
   parentheses.
   In negative patterns, the minimum and maximum counts are ignored;
   these are presumed to be set in the positive pattern.

  pattern - a new pattern - `java.lang.String`

  throws: java.lang.NullPointerException - if pattern is null"
  ([this pattern]
    (-> this (.applyPattern pattern))))

(defn set-grouping-used
  "Set whether or not grouping will be used in this format.

  new-value - true if grouping is used; false otherwise - `boolean`"
  ([this new-value]
    (-> this (.setGroupingUsed new-value))))

(defn get-currency
  "Gets the currency used by this decimal format when formatting
   currency values.
   The currency is obtained by calling
   DecimalFormatSymbols.getCurrency
   on this number format's symbols.

  returns: the currency used by this decimal format, or null - `java.util.Currency`"
  ([this]
    (-> this (.getCurrency))))

(defn equals
  "Overrides equals

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn set-positive-suffix
  "Set the positive suffix.
   Example: 123%

  new-value - the new positive suffix - `java.lang.String`"
  ([this new-value]
    (-> this (.setPositiveSuffix new-value))))

(defn format
  "Formats a number and appends the resulting text to the given string
   buffer.
   The number can be of any subclass of Number.

   This implementation uses the maximum precision permitted.

  number - the number to format - `java.lang.Object`
  to-append-to - the StringBuffer to which the formatted text is to be appended - `java.lang.StringBuffer`
  pos - On input: an alignment field, if desired. On output: the offsets of the alignment field. - `java.text.FieldPosition`

  returns: the value passed in as toAppendTo - `java.lang.StringBuffer`

  throws: java.lang.IllegalArgumentException - if number is null or not an instance of Number."
  ([this number to-append-to pos]
    (-> this (.format number to-append-to pos))))

(defn to-localized-pattern
  "Synthesizes a localized pattern string that represents the current
   state of this Format object.

  returns: a localized pattern string - `java.lang.String`"
  ([this]
    (-> this (.toLocalizedPattern))))

