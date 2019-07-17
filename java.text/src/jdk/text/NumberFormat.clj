(ns jdk.text.NumberFormat
  "NumberFormat is the abstract base class for all number
  formats. This class provides the interface for formatting and parsing
  numbers. NumberFormat also provides methods for determining
  which locales have number formats, and what their names are.


  NumberFormat helps you to format and parse numbers for any locale.
  Your code can be completely independent of the locale conventions for
  decimal points, thousands-separators, or even the particular decimal
  digits used, or whether the number format is even decimal.


  To format a number for the current Locale, use one of the factory
  class methods:



  myString = NumberFormat.getInstance().format(myNumber);

  If you are formatting multiple numbers, it is
  more efficient to get the format and use it multiple times so that
  the system doesn't have to fetch the information about the local
  language and country conventions multiple times.



  NumberFormat nf = NumberFormat.getInstance();
  for (int i = 0; i < myNumber.length; +i) {
      output.println(nf.format(myNumber[i])  `; `);
  }

  To format a number for a different Locale, specify it in the
  call to getInstance.



  NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);

  You can also use a NumberFormat to parse numbers:



  myNumber = nf.parse(myString);

  Use getInstance or getNumberInstance to get the
  normal number format. Use getIntegerInstance to get an
  integer number format. Use getCurrencyInstance to get the
  currency number format. And use getPercentInstance to get a
  format for displaying percentages. With this format, a fraction like
  0.53 is displayed as 53%.


  You can also control the display of numbers with such methods as
  setMinimumFractionDigits.
  If you want even more control over the format or parsing,
  or want to give your users more control,
  you can try casting the NumberFormat you get from the factory methods
  to a DecimalFormat. This will work for the vast majority
  of locales; just remember to put it in a try block in case you
  encounter an unusual one.


  NumberFormat and DecimalFormat are designed such that some controls
  work for formatting and others work for parsing.  The following is
  the detailed description for each these control methods,

  setParseIntegerOnly : only affects parsing, e.g.
  if true,  `3456.78` → 3456 (and leaves the parse position just after index 6)
  if false, `3456.78` → 3456.78 (and leaves the parse position just after index 8)
  This is independent of formatting.  If you want to not show a decimal point
  where there might be no digits after the decimal point, use
  setDecimalSeparatorAlwaysShown.

  setDecimalSeparatorAlwaysShown : only affects formatting, and only where
  there might be no digits after the decimal point, such as with a pattern
  like `#,##0.##`, e.g.,
  if true,  3456.00 → `3,456.`
  if false, 3456.00 → `3456`
  This is independent of parsing.  If you want parsing to stop at the decimal
  point, use setParseIntegerOnly.


  You can also use forms of the parse and format
  methods with ParsePosition and FieldPosition to
  allow you to:

   progressively parse through pieces of a string
   align the decimal point and other areas

  For example, you can align numbers in two ways:

   If you are using a monospaced font with spacing for alignment,
       you can pass the FieldPosition in your format call, with
       field = INTEGER_FIELD. On output,
       getEndIndex will be set to the offset between the
       last character of the integer and the decimal. Add
       (desiredSpaceCount - getEndIndex) spaces at the front of the string.

   If you are using proportional fonts,
       instead of padding with spaces, measure the width
       of the string in pixels from the start to getEndIndex.
       Then move the pen by
       (desiredPixelWidth - widthToAlignmentPoint) before drawing the text.
       It also works where there is no decimal, but possibly additional
       characters at the end, e.g., with parentheses in negative
       numbers: `(12)` for -12.


  Synchronization


  Number formats are generally not synchronized.
  It is recommended to create separate format instances for each thread.
  If multiple threads access a format concurrently, it must be synchronized
  externally."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text NumberFormat]))

(def *-integer-field
  "Static Constant.

  Field constant used to construct a FieldPosition object. Signifies that
   the position of the integer part of a formatted number should be returned.

  type: int"
  NumberFormat/INTEGER_FIELD)

(def *-fraction-field
  "Static Constant.

  Field constant used to construct a FieldPosition object. Signifies that
   the position of the fraction part of a formatted number should be returned.

  type: int"
  NumberFormat/FRACTION_FIELD)

(defn *get-instance
  "Returns a general-purpose number format for the specified locale.
   This is the same as calling
   getNumberInstance(inLocale).

  in-locale - the desired locale - `java.util.Locale`

  returns: the NumberFormat instance for general-purpose number
   formatting - `java.text.NumberFormat`"
  ([in-locale]
    (NumberFormat/getInstance in-locale))
  ([]
    (NumberFormat/getInstance )))

(defn *get-number-instance
  "Returns a general-purpose number format for the specified locale.

  in-locale - the desired locale - `java.util.Locale`

  returns: the NumberFormat instance for general-purpose number
   formatting - `java.text.NumberFormat`"
  ([in-locale]
    (NumberFormat/getNumberInstance in-locale))
  ([]
    (NumberFormat/getNumberInstance )))

(defn *get-integer-instance
  "Returns an integer number format for the specified locale. The
   returned number format is configured to round floating point numbers
   to the nearest integer using half-even rounding (see RoundingMode.HALF_EVEN) for formatting,
   and to parse only the integer part of an input string (see isParseIntegerOnly).

  in-locale - the desired locale - `java.util.Locale`

  returns: a number format for integer values - `java.text.NumberFormat`"
  ([in-locale]
    (NumberFormat/getIntegerInstance in-locale))
  ([]
    (NumberFormat/getIntegerInstance )))

(defn *get-currency-instance
  "Returns a currency format for the specified locale.

  in-locale - the desired locale - `java.util.Locale`

  returns: the NumberFormat instance for currency formatting - `java.text.NumberFormat`"
  ([in-locale]
    (NumberFormat/getCurrencyInstance in-locale))
  ([]
    (NumberFormat/getCurrencyInstance )))

(defn *get-percent-instance
  "Returns a percentage format for the specified locale.

  in-locale - the desired locale - `java.util.Locale`

  returns: the NumberFormat instance for percentage formatting - `java.text.NumberFormat`"
  ([in-locale]
    (NumberFormat/getPercentInstance in-locale))
  ([]
    (NumberFormat/getPercentInstance )))

(defn *get-available-locales
  "Returns an array of all locales for which the
   get*Instance methods of this class can return
   localized instances.
   The returned array represents the union of locales supported by the Java
   runtime and by installed
   NumberFormatProvider implementations.
   It must contain at least a Locale instance equal to
   Locale.US.

  returns: An array of locales for which localized
           NumberFormat instances are available. - `java.util.Locale[]`"
  ([]
    (NumberFormat/getAvailableLocales )))

(defn set-rounding-mode
  "Sets the RoundingMode used in this NumberFormat.
   The default implementation of this method in NumberFormat always
   throws UnsupportedOperationException.
   Subclasses which handle different rounding modes should override
   this method.

  rounding-mode - The RoundingMode to be used - `java.math.RoundingMode`

  throws: java.lang.UnsupportedOperationException - The default implementation always throws this exception"
  ([this rounding-mode]
    (-> this (.setRoundingMode rounding-mode))))

(defn set-minimum-integer-digits
  "Sets the minimum number of digits allowed in the integer portion of a
   number. minimumIntegerDigits must be ≤ maximumIntegerDigits.  If the
   new value for minimumIntegerDigits exceeds the current value
   of maximumIntegerDigits, then maximumIntegerDigits will also be set to
   the new value

  new-value - the minimum number of integer digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMinimumIntegerDigits new-value))))

(defn get-minimum-integer-digits
  "Returns the minimum number of digits allowed in the integer portion of a
   number.

  returns: the minimum number of digits - `int`"
  ([this]
    (-> this (.getMinimumIntegerDigits))))

(defn parse-object
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

   See the parse(String, ParsePosition) method for more information
   on number parsing.

  source - A String, part of which should be parsed. - `java.lang.String`
  pos - A ParsePosition object with index and error index information as described above. - `java.text.ParsePosition`

  returns: A Number parsed from the string. In case of
           error, returns null. - `java.lang.Object`

  throws: java.lang.NullPointerException - if pos is null."
  ([this source pos]
    (-> this (.parseObject source pos))))

(defn set-currency
  "Sets the currency used by this number format when formatting
   currency values. This does not update the minimum or maximum
   number of fraction digits used by the number format.

   The default implementation throws
   UnsupportedOperationException.

  currency - the new currency to be used by this number format - `java.util.Currency`

  throws: java.lang.UnsupportedOperationException - if the number format class doesn't implement currency formatting"
  ([this currency]
    (-> this (.setCurrency currency))))

(defn set-maximum-integer-digits
  "Sets the maximum number of digits allowed in the integer portion of a
   number. maximumIntegerDigits must be ≥ minimumIntegerDigits.  If the
   new value for maximumIntegerDigits is less than the current value
   of minimumIntegerDigits, then minimumIntegerDigits will also be set to
   the new value.

  new-value - the maximum number of integer digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMaximumIntegerDigits new-value))))

(defn set-parse-integer-only
  "Sets whether or not numbers should be parsed as integers only.

  value - true if numbers should be parsed as integers only; false otherwise - `boolean`"
  ([this value]
    (-> this (.setParseIntegerOnly value))))

(defn get-minimum-fraction-digits
  "Returns the minimum number of digits allowed in the fraction portion of a
   number.

  returns: the minimum number of digits - `int`"
  ([this]
    (-> this (.getMinimumFractionDigits))))

(defn get-maximum-fraction-digits
  "Returns the maximum number of digits allowed in the fraction portion of a
   number.

  returns: the maximum number of digits. - `int`"
  ([this]
    (-> this (.getMaximumFractionDigits))))

(defn get-maximum-integer-digits
  "Returns the maximum number of digits allowed in the integer portion of a
   number.

  returns: the maximum number of digits - `int`"
  ([this]
    (-> this (.getMaximumIntegerDigits))))

(defn set-maximum-fraction-digits
  "Sets the maximum number of digits allowed in the fraction portion of a
   number. maximumFractionDigits must be ≥ minimumFractionDigits.  If the
   new value for maximumFractionDigits is less than the current value
   of minimumFractionDigits, then minimumFractionDigits will also be set to
   the new value.

  new-value - the maximum number of fraction digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMaximumFractionDigits new-value))))

(defn clone
  "Overrides Cloneable.

  returns: a clone of this instance. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn parse
  "Returns a Long if possible (e.g., within the range [Long.MIN_VALUE,
   Long.MAX_VALUE] and with no decimals), otherwise a Double.
   If IntegerOnly is set, will stop at a decimal
   point (or equivalent; e.g., for rational numbers `1 2/3`, will stop
   after the 1).
   Does not throw an exception; if no object can be parsed, index is
   unchanged!

  source - the String to parse - `java.lang.String`
  parse-position - the parse position - `java.text.ParsePosition`

  returns: the parsed value - `java.lang.Number`"
  ([this source parse-position]
    (-> this (.parse source parse-position)))
  ([this source]
    (-> this (.parse source))))

(defn set-minimum-fraction-digits
  "Sets the minimum number of digits allowed in the fraction portion of a
   number. minimumFractionDigits must be ≤ maximumFractionDigits.  If the
   new value for minimumFractionDigits exceeds the current value
   of maximumFractionDigits, then maximumIntegerDigits will also be set to
   the new value

  new-value - the minimum number of fraction digits to be shown; if less than zero, then zero is used. The concrete subclass may enforce an upper limit to this value appropriate to the numeric type being formatted. - `int`"
  ([this new-value]
    (-> this (.setMinimumFractionDigits new-value))))

(defn hash-code
  "Overrides hashCode.

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn parse-integer-only?
  "Returns true if this format will parse numbers as integers only.
   For example in the English locale, with ParseIntegerOnly true, the
   string `1234.` would be parsed as the integer value 1234 and parsing
   would stop at the `.` character.  Of course, the exact format accepted
   by the parse operation is locale dependant and determined by sub-classes
   of NumberFormat.

  returns: true if numbers should be parsed as integers only;
           false otherwise - `boolean`"
  ([this]
    (-> this (.isParseIntegerOnly))))

(defn get-rounding-mode
  "Gets the RoundingMode used in this NumberFormat.
   The default implementation of this method in NumberFormat
   always throws UnsupportedOperationException.
   Subclasses which handle different rounding modes should override
   this method.

  returns: The RoundingMode used for this NumberFormat. - `java.math.RoundingMode`

  throws: java.lang.UnsupportedOperationException - The default implementation always throws this exception"
  ([this]
    (-> this (.getRoundingMode))))

(defn set-grouping-used
  "Set whether or not grouping will be used in this format.

  new-value - true if grouping is used; false otherwise - `boolean`"
  ([this new-value]
    (-> this (.setGroupingUsed new-value))))

(defn grouping-used?
  "Returns true if grouping is used in this format. For example, in the
   English locale, with grouping on, the number 1234567 might be formatted
   as `1,234,567`. The grouping separator as well as the size of each group
   is locale dependant and is determined by sub-classes of NumberFormat.

  returns: true if grouping is used;
           false otherwise - `boolean`"
  ([this]
    (-> this (.isGroupingUsed))))

(defn get-currency
  "Gets the currency used by this number format when formatting
   currency values. The initial value is derived in a locale dependent
   way. The returned value may be null if no valid
   currency could be determined and no currency has been set using
   setCurrency.

   The default implementation throws
   UnsupportedOperationException.

  returns: the currency used by this number format, or null - `java.util.Currency`

  throws: java.lang.UnsupportedOperationException - if the number format class doesn't implement currency formatting"
  ([this]
    (-> this (.getCurrency))))

(defn equals
  "Overrides equals.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

(defn format
  "Formats a number and appends the resulting text to the given string
   buffer.
   The number can be of any subclass of Number.

   This implementation extracts the number's value using
   Number.longValue() for all integral type values that
   can be converted to long without loss of information,
   including BigInteger values with a
   bit length of less than 64,
   and Number.doubleValue() for all other types. It
   then calls
   format(long,java.lang.StringBuffer,java.text.FieldPosition)
   or format(double,java.lang.StringBuffer,java.text.FieldPosition).
   This may result in loss of magnitude information and precision for
   BigInteger and BigDecimal values.

  number - the number to format - `java.lang.Object`
  to-append-to - the StringBuffer to which the formatted text is to be appended - `java.lang.StringBuffer`
  pos - On input: an alignment field, if desired. On output: the offsets of the alignment field. - `java.text.FieldPosition`

  returns: the value passed in as toAppendTo - `java.lang.StringBuffer`

  throws: java.lang.IllegalArgumentException - if number is null or not an instance of Number."
  ([this number to-append-to pos]
    (-> this (.format number to-append-to pos)))
  ([this number]
    (-> this (.format number))))

