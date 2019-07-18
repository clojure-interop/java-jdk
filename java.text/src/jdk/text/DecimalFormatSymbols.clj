(ns jdk.text.DecimalFormatSymbols
  "This class represents the set of symbols (such as the decimal separator,
  the grouping separator, and so on) needed by DecimalFormat
  to format numbers. DecimalFormat creates for itself an instance of
  DecimalFormatSymbols from its locale data.  If you need to change any
  of these symbols, you can get the DecimalFormatSymbols object from
  your DecimalFormat and modify it."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text DecimalFormatSymbols]))

(defn ->decimal-format-symbols
  "Constructor.

  Create a DecimalFormatSymbols object for the given locale.
   This constructor can only construct instances for the locales
   supported by the Java runtime environment, not for those
   supported by installed
   DecimalFormatSymbolsProvider
   implementations. For full locale coverage, use the
   getInstance method.
   If the specified locale contains the Locale.UNICODE_LOCALE_EXTENSION
   for the numbering system, the instance is initialized with the specified numbering
   system if the JRE implementation supports it. For example,


   NumberFormat.getNumberInstance(Locale.forLanguageTag(`th-TH-u-nu-thai`))
   This may return a NumberFormat instance with the Thai numbering system,
   instead of the Latin numbering system.

  locale - the desired locale - `java.util.Locale`

  throws: java.lang.NullPointerException - if locale is null"
  (^DecimalFormatSymbols [^java.util.Locale locale]
    (new DecimalFormatSymbols locale))
  (^DecimalFormatSymbols []
    (new DecimalFormatSymbols )))

(defn *get-available-locales
  "Returns an array of all locales for which the
   getInstance methods of this class can return
   localized instances.
   The returned array represents the union of locales supported by the Java
   runtime and by installed
   DecimalFormatSymbolsProvider
   implementations.  It must contain at least a Locale
   instance equal to Locale.US.

  returns: an array of locales for which localized
           DecimalFormatSymbols instances are available. - `java.util.Locale[]`"
  ([]
    (DecimalFormatSymbols/getAvailableLocales )))

(defn *get-instance
  "Gets the DecimalFormatSymbols instance for the specified
   locale.  This method provides access to DecimalFormatSymbols
   instances for locales supported by the Java runtime itself as well
   as for those supported by installed
   DecimalFormatSymbolsProvider implementations.
   If the specified locale contains the Locale.UNICODE_LOCALE_EXTENSION
   for the numbering system, the instance is initialized with the specified numbering
   system if the JRE implementation supports it. For example,


   NumberFormat.getNumberInstance(Locale.forLanguageTag(`th-TH-u-nu-thai`))
   This may return a NumberFormat instance with the Thai numbering system,
   instead of the Latin numbering system.

  locale - the desired locale. - `java.util.Locale`

  returns: a DecimalFormatSymbols instance. - `java.text.DecimalFormatSymbols`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.DecimalFormatSymbols [^java.util.Locale locale]
    (DecimalFormatSymbols/getInstance locale))
  (^java.text.DecimalFormatSymbols []
    (DecimalFormatSymbols/getInstance )))

(defn get-currency-symbol
  "Returns the currency symbol for the currency of these
   DecimalFormatSymbols in their locale.

  returns: the currency symbol - `java.lang.String`"
  (^java.lang.String [^DecimalFormatSymbols this]
    (-> this (.getCurrencySymbol))))

(defn set-zero-digit
  "Sets the character used for zero. Different for Arabic, etc.

  zero-digit - the character used for zero - `char`"
  ([^DecimalFormatSymbols this ^Character zero-digit]
    (-> this (.setZeroDigit zero-digit))))

(defn set-digit
  "Sets the character used for a digit in a pattern.

  digit - the character used for a digit in a pattern - `char`"
  ([^DecimalFormatSymbols this ^Character digit]
    (-> this (.setDigit digit))))

(defn get-exponent-separator
  "Returns the string used to separate the mantissa from the exponent.
   Examples: `x10^` for 1.23x10^4, `E` for 1.23E4.

  returns: the exponent separator string - `java.lang.String`"
  (^java.lang.String [^DecimalFormatSymbols this]
    (-> this (.getExponentSeparator))))

(defn get-na-n
  "Gets the string used to represent `not a number`. Almost always left
   unchanged.

  returns: the string representing `not a number` - `java.lang.String`"
  (^java.lang.String [^DecimalFormatSymbols this]
    (-> this (.getNaN))))

(defn get-per-mill
  "Gets the character used for per mille sign. Different for Arabic, etc.

  returns: the character used for per mille sign - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getPerMill))))

(defn get-decimal-separator
  "Gets the character used for decimal sign. Different for French, etc.

  returns: the character used for decimal sign - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getDecimalSeparator))))

(defn set-currency
  "Sets the currency of these DecimalFormatSymbols.
   This also sets the currency symbol attribute to the currency's symbol
   in the DecimalFormatSymbols' locale, and the international currency
   symbol attribute to the currency's ISO 4217 currency code.

  currency - the new currency to be used - `java.util.Currency`

  throws: java.lang.NullPointerException - if currency is null"
  ([^DecimalFormatSymbols this ^java.util.Currency currency]
    (-> this (.setCurrency currency))))

(defn set-percent
  "Sets the character used for percent sign. Different for Arabic, etc.

  percent - the character used for percent sign - `char`"
  ([^DecimalFormatSymbols this ^Character percent]
    (-> this (.setPercent percent))))

(defn set-na-n
  "Sets the string used to represent `not a number`. Almost always left
   unchanged.

  na-n - the string representing `not a number` - `java.lang.String`"
  ([^DecimalFormatSymbols this ^java.lang.String na-n]
    (-> this (.setNaN na-n))))

(defn get-zero-digit
  "Gets the character used for zero. Different for Arabic, etc.

  returns: the character used for zero - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getZeroDigit))))

(defn get-international-currency-symbol
  "Returns the ISO 4217 currency code of the currency of these
   DecimalFormatSymbols.

  returns: the currency code - `java.lang.String`"
  (^java.lang.String [^DecimalFormatSymbols this]
    (-> this (.getInternationalCurrencySymbol))))

(defn get-digit
  "Gets the character used for a digit in a pattern.

  returns: the character used for a digit in a pattern - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getDigit))))

(defn set-pattern-separator
  "Sets the character used to separate positive and negative subpatterns
   in a pattern.

  pattern-separator - the pattern separator - `char`"
  ([^DecimalFormatSymbols this ^Character pattern-separator]
    (-> this (.setPatternSeparator pattern-separator))))

(defn get-monetary-decimal-separator
  "Returns the monetary decimal separator.

  returns: the monetary decimal separator - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getMonetaryDecimalSeparator))))

(defn set-minus-sign
  "Sets the character used to represent minus sign. If no explicit
   negative format is specified, one is formed by prefixing
   minusSign to the positive format.

  minus-sign - the character representing minus sign - `char`"
  ([^DecimalFormatSymbols this ^Character minus-sign]
    (-> this (.setMinusSign minus-sign))))

(defn set-grouping-separator
  "Sets the character used for thousands separator. Different for French, etc.

  grouping-separator - the grouping separator - `char`"
  ([^DecimalFormatSymbols this ^Character grouping-separator]
    (-> this (.setGroupingSeparator grouping-separator))))

(defn get-percent
  "Gets the character used for percent sign. Different for Arabic, etc.

  returns: the character used for percent sign - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getPercent))))

(defn set-currency-symbol
  "Sets the currency symbol for the currency of these
   DecimalFormatSymbols in their locale.

  currency - the currency symbol - `java.lang.String`"
  ([^DecimalFormatSymbols this ^java.lang.String currency]
    (-> this (.setCurrencySymbol currency))))

(defn set-decimal-separator
  "Sets the character used for decimal sign. Different for French, etc.

  decimal-separator - the character used for decimal sign - `char`"
  ([^DecimalFormatSymbols this ^Character decimal-separator]
    (-> this (.setDecimalSeparator decimal-separator))))

(defn get-infinity
  "Gets the string used to represent infinity. Almost always left
   unchanged.

  returns: the string representing infinity - `java.lang.String`"
  (^java.lang.String [^DecimalFormatSymbols this]
    (-> this (.getInfinity))))

(defn get-grouping-separator
  "Gets the character used for thousands separator. Different for French, etc.

  returns: the grouping separator - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getGroupingSeparator))))

(defn clone
  "Standard override.

  returns: a clone of this instance. - `java.lang.Object`"
  (^java.lang.Object [^DecimalFormatSymbols this]
    (-> this (.clone))))

(defn set-exponent-separator
  "Sets the string used to separate the mantissa from the exponent.
   Examples: `x10^` for 1.23x10^4, `E` for 1.23E4.

  exp - the exponent separator string - `java.lang.String`

  throws: java.lang.NullPointerException - if exp is null"
  ([^DecimalFormatSymbols this ^java.lang.String exp]
    (-> this (.setExponentSeparator exp))))

(defn hash-code
  "Override hashCode.

  returns: a hash code value for this object. - `int`"
  (^Integer [^DecimalFormatSymbols this]
    (-> this (.hashCode))))

(defn set-per-mill
  "Sets the character used for per mille sign. Different for Arabic, etc.

  per-mill - the character used for per mille sign - `char`"
  ([^DecimalFormatSymbols this ^Character per-mill]
    (-> this (.setPerMill per-mill))))

(defn get-minus-sign
  "Gets the character used to represent minus sign. If no explicit
   negative format is specified, one is formed by prefixing
   minusSign to the positive format.

  returns: the character representing minus sign - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getMinusSign))))

(defn set-monetary-decimal-separator
  "Sets the monetary decimal separator.

  sep - the monetary decimal separator - `char`"
  ([^DecimalFormatSymbols this ^Character sep]
    (-> this (.setMonetaryDecimalSeparator sep))))

(defn set-international-currency-symbol
  "Sets the ISO 4217 currency code of the currency of these
   DecimalFormatSymbols.
   If the currency code is valid (as defined by
   Currency.getInstance),
   this also sets the currency attribute to the corresponding Currency
   instance and the currency symbol attribute to the currency's symbol
   in the DecimalFormatSymbols' locale. If the currency code is not valid,
   then the currency attribute is set to null and the currency symbol
   attribute is not modified.

  currency-code - the currency code - `java.lang.String`"
  ([^DecimalFormatSymbols this ^java.lang.String currency-code]
    (-> this (.setInternationalCurrencySymbol currency-code))))

(defn get-currency
  "Gets the currency of these DecimalFormatSymbols. May be null if the
   currency symbol attribute was previously set to a value that's not
   a valid ISO 4217 currency code.

  returns: the currency used, or null - `java.util.Currency`"
  (^java.util.Currency [^DecimalFormatSymbols this]
    (-> this (.getCurrency))))

(defn set-infinity
  "Sets the string used to represent infinity. Almost always left
   unchanged.

  infinity - the string representing infinity - `java.lang.String`"
  ([^DecimalFormatSymbols this ^java.lang.String infinity]
    (-> this (.setInfinity infinity))))

(defn equals
  "Override equals.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^DecimalFormatSymbols this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-pattern-separator
  "Gets the character used to separate positive and negative subpatterns
   in a pattern.

  returns: the pattern separator - `char`"
  (^Character [^DecimalFormatSymbols this]
    (-> this (.getPatternSeparator))))

