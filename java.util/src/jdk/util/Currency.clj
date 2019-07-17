(ns jdk.util.Currency
  "Represents a currency. Currencies are identified by their ISO 4217 currency
  codes. Visit the
  ISO web site for more information.

  The class is designed so that there's never more than one
  Currency instance for any given currency. Therefore, there's
  no public constructor. You obtain a Currency instance using
  the getInstance methods.

  Users can supersede the Java runtime currency data by means of the system
  property java.util.currency.data. If this system property is
  defined then its value is the location of a properties file, the contents of
  which are key/value pairs of the ISO 3166 country codes and the ISO 4217
  currency data respectively.  The value part consists of three ISO 4217 values
  of a currency, i.e., an alphabetic code, a numeric code, and a minor unit.
  Those three ISO 4217 values are separated by commas.
  The lines which start with '#'s are considered comment lines. An optional UTC
  timestamp may be specified per currency entry if users need to specify a
  cutover date indicating when the new data comes into effect. The timestamp is
  appended to the end of the currency properties and uses a comma as a separator.
  If a UTC datestamp is present and valid, the JRE will only use the new currency
  properties if the current UTC date is later than the date specified at class
  loading time. The format of the timestamp must be of ISO 8601 format :
  'yyyy-MM-dd'T'HH:mm:ss'. For example,


  #Sample currency properties
  JP=JPZ,999,0


  will supersede the currency data for Japan.



  #Sample currency properties with cutover date
  JP=JPZ,999,0,2014-01-01T00:00:00


  will supersede the currency data for Japan if Currency class is loaded after
  1st January 2014 00:00:00 GMT.

  Where syntactically malformed entries are encountered, the entry is ignored
  and the remainder of entries in file are processed. For instances where duplicate
  country code entries exist, the behavior of the Currency information for that
  Currency is undefined and the remainder of entries in file are processed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util Currency]))

(defn *get-instance
  "Returns the Currency instance for the given currency code.

  currency-code - the ISO 4217 code of the currency - `java.lang.String`

  returns: the Currency instance for the given currency code - `java.util.Currency`

  throws: java.lang.NullPointerException - if currencyCode is null"
  ([currency-code]
    (Currency/getInstance currency-code)))

(defn *get-available-currencies
  "Gets the set of available currencies.  The returned set of currencies
   contains all of the available currencies, which may include currencies
   that represent obsolete ISO 4217 codes.  The set can be modified
   without affecting the available currencies in the runtime.

  returns: the set of available currencies.  If there is no currency
      available in the runtime, the returned set is empty. - `java.util.Set<java.util.Currency>`"
  ([]
    (Currency/getAvailableCurrencies )))

(defn get-currency-code
  "Gets the ISO 4217 currency code of this currency.

  returns: the ISO 4217 currency code of this currency. - `java.lang.String`"
  ([this]
    (-> this (.getCurrencyCode))))

(defn get-symbol
  "Gets the symbol of this currency for the specified locale.
   For example, for the US Dollar, the symbol is `$` if the specified
   locale is the US, while for other locales it may be `US$`. If no
   symbol can be determined, the ISO 4217 currency code is returned.

  locale - the locale for which a display name for this currency is needed - `java.util.Locale`

  returns: the symbol of this currency for the specified locale - `java.lang.String`

  throws: java.lang.NullPointerException - if locale is null"
  ([this locale]
    (-> this (.getSymbol locale)))
  ([this]
    (-> this (.getSymbol))))

(defn get-default-fraction-digits
  "Gets the default number of fraction digits used with this currency.
   For example, the default number of fraction digits for the Euro is 2,
   while for the Japanese Yen it's 0.
   In the case of pseudo-currencies, such as IMF Special Drawing Rights,
   -1 is returned.

  returns: the default number of fraction digits used with this currency - `int`"
  ([this]
    (-> this (.getDefaultFractionDigits))))

(defn get-numeric-code
  "Returns the ISO 4217 numeric code of this currency.

  returns: the ISO 4217 numeric code of this currency - `int`"
  ([this]
    (-> this (.getNumericCode))))

(defn get-display-name
  "Gets the name that is suitable for displaying this currency for
   the specified locale.  If there is no suitable display name found
   for the specified locale, the ISO 4217 currency code is returned.

  locale - the locale for which a display name for this currency is needed - `java.util.Locale`

  returns: the display name of this currency for the specified locale - `java.lang.String`

  throws: java.lang.NullPointerException - if locale is null"
  ([this locale]
    (-> this (.getDisplayName locale)))
  ([this]
    (-> this (.getDisplayName))))

(defn to-string
  "Returns the ISO 4217 currency code of this currency.

  returns: the ISO 4217 currency code of this currency - `java.lang.String`"
  ([this]
    (-> this (.toString))))

