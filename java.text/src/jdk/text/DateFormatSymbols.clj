(ns jdk.text.DateFormatSymbols
  "DateFormatSymbols is a public class for encapsulating
  localizable date-time formatting data, such as the names of the
  months, the names of the days of the week, and the time zone data.
  SimpleDateFormat uses
  DateFormatSymbols to encapsulate this information.


  Typically you shouldn't use DateFormatSymbols directly.
  Rather, you are encouraged to create a date-time formatter with the
  DateFormat class's factory methods: getTimeInstance,
  getDateInstance, or getDateTimeInstance.
  These methods automatically create a DateFormatSymbols for
  the formatter so that you don't have to. After the
  formatter is created, you may modify its format pattern using the
  setPattern method. For more information about
  creating formatters using DateFormat's factory methods,
  see DateFormat.


  If you decide to create a date-time formatter with a specific
  format pattern for a specific locale, you can do so with:



  new SimpleDateFormat(aPattern, DateFormatSymbols.getInstance(aLocale)).



  DateFormatSymbols objects are cloneable. When you obtain
  a DateFormatSymbols object, feel free to modify the
  date-time formatting data. For instance, you can replace the localized
  date-time format pattern characters with the ones that you feel easy
  to remember. Or you can change the representative cities
  to your favorite ones.


  New DateFormatSymbols subclasses may be added to support
  SimpleDateFormat for date-time formatting for additional locales."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text DateFormatSymbols]))

(defn ->date-format-symbols
  "Constructor.

  Construct a DateFormatSymbols object by loading format data from
   resources for the given locale. This constructor can only
   construct instances for the locales supported by the Java
   runtime environment, not for those supported by installed
   DateFormatSymbolsProvider
   implementations. For full locale coverage, use the
   getInstance method.

  locale - the desired locale - `java.util.Locale`

  throws: java.util.MissingResourceException - if the resources for the specified locale cannot be found or cannot be loaded."
  ([^java.util.Locale locale]
    (new DateFormatSymbols locale))
  ([]
    (new DateFormatSymbols )))

(defn *get-available-locales
  "Returns an array of all locales for which the
   getInstance methods of this class can return
   localized instances.
   The returned array represents the union of locales supported by the
   Java runtime and by installed
   DateFormatSymbolsProvider
   implementations.  It must contain at least a Locale
   instance equal to Locale.US.

  returns: An array of locales for which localized
           DateFormatSymbols instances are available. - `java.util.Locale[]`"
  ([]
    (DateFormatSymbols/getAvailableLocales )))

(defn *get-instance
  "Gets the DateFormatSymbols instance for the specified
   locale.  This method provides access to DateFormatSymbols
   instances for locales supported by the Java runtime itself as well
   as for those supported by installed
   DateFormatSymbolsProvider
   implementations.

  locale - the given locale. - `java.util.Locale`

  returns: a DateFormatSymbols instance. - `java.text.DateFormatSymbols`

  throws: java.lang.NullPointerException - if locale is null"
  ([^java.util.Locale locale]
    (DateFormatSymbols/getInstance locale))
  ([]
    (DateFormatSymbols/getInstance )))

(defn set-short-weekdays
  "Sets short weekday strings. For example: `Sun`, `Mon`, etc.

  new-short-weekdays - the new short weekday strings. The array should be indexed by Calendar.SUNDAY, Calendar.MONDAY, etc. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this ^java.lang.String[] new-short-weekdays]
    (-> this (.setShortWeekdays new-short-weekdays))))

(defn get-months
  "Gets month strings. For example: `January`, `February`, etc.

   If the language requires different forms for formatting and
   stand-alone usages, this method returns month names in the
   formatting form. For example, the preferred month name for
   January in the Czech language is ledna in the
   formatting form, while it is leden in the stand-alone
   form. This method returns `ledna` in this case. Refer
   to the
   Calendar Elements in the Unicode Locale Data Markup Language
   (LDML) specification for more details.

  returns: the month strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getMonths))))

(defn set-short-months
  "Sets short month strings. For example: `Jan`, `Feb`, etc.

  new-short-months - the new short month strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this ^java.lang.String[] new-short-months]
    (-> this (.setShortMonths new-short-months))))

(defn set-months
  "Sets month strings. For example: `January`, `February`, etc.

  new-months - the new month strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this ^java.lang.String[] new-months]
    (-> this (.setMonths new-months))))

(defn set-am-pm-strings
  "Sets ampm strings. For example: `AM` and `PM`.

  new-ampms - the new ampm strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this ^java.lang.String[] new-ampms]
    (-> this (.setAmPmStrings new-ampms))))

(defn get-weekdays
  "Gets weekday strings. For example: `Sunday`, `Monday`, etc.

  returns: the weekday strings. Use Calendar.SUNDAY,
   Calendar.MONDAY, etc. to index the result array. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getWeekdays))))

(defn set-eras
  "Sets era strings. For example: `AD` and `BC`.

  new-eras - the new era strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this ^java.lang.String[] new-eras]
    (-> this (.setEras new-eras))))

(defn get-am-pm-strings
  "Gets ampm strings. For example: `AM` and `PM`.

  returns: the ampm strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getAmPmStrings))))

(defn set-weekdays
  "Sets weekday strings. For example: `Sunday`, `Monday`, etc.

  new-weekdays - the new weekday strings. The array should be indexed by Calendar.SUNDAY, Calendar.MONDAY, etc. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this ^java.lang.String[] new-weekdays]
    (-> this (.setWeekdays new-weekdays))))

(defn get-short-months
  "Gets short month strings. For example: `Jan`, `Feb`, etc.

   If the language requires different forms for formatting and
   stand-alone usages, This method returns short month names in
   the formatting form. For example, the preferred abbreviation
   for January in the Catalan language is de gen. in the
   formatting form, while it is gen. in the stand-alone
   form. This method returns `de gen.` in this case. Refer
   to the
   Calendar Elements in the Unicode Locale Data Markup Language
   (LDML) specification for more details.

  returns: the short month strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getShortMonths))))

(defn set-zone-strings
  "Sets time zone strings.  The argument must be a
   two-dimensional array of strings of size n by m,
   where m is at least 5.  Each of the n rows is an
   entry containing the localized names for a single TimeZone.
   Each such row contains (with i ranging from
   0..n-1):

   zoneStrings[i][0] - time zone ID
   zoneStrings[i][1] - long name of zone in standard
   time
   zoneStrings[i][2] - short name of zone in
   standard time
   zoneStrings[i][3] - long name of zone in daylight
   saving time
   zoneStrings[i][4] - short name of zone in daylight
   saving time

   The zone ID is not localized; it's one of the valid IDs of
   the TimeZone class that are not
   custom IDs.
   All other entries are localized names.

  new-zone-strings - the new time zone strings. - `java.lang.String[][]`

  throws: java.lang.IllegalArgumentException - if the length of any row in newZoneStrings is less than 5"
  ([^java.text.DateFormatSymbols this ^java.lang.String[][] new-zone-strings]
    (-> this (.setZoneStrings new-zone-strings))))

(defn get-local-pattern-chars
  "Gets localized date-time pattern characters. For example: 'u', 't', etc.

  returns: the localized date-time pattern characters. - `java.lang.String`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getLocalPatternChars))))

(defn get-short-weekdays
  "Gets short weekday strings. For example: `Sun`, `Mon`, etc.

  returns: the short weekday strings. Use Calendar.SUNDAY,
   Calendar.MONDAY, etc. to index the result array. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getShortWeekdays))))

(defn get-eras
  "Gets era strings. For example: `AD` and `BC`.

  returns: the era strings. - `java.lang.String[]`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getEras))))

(defn clone
  "Overrides Cloneable

  returns: a clone of this instance. - `java.lang.Object`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.clone))))

(defn hash-code
  "Override hashCode.
   Generates a hash code for the DateFormatSymbols object.

  returns: a hash code value for this object. - `int`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.hashCode))))

(defn set-local-pattern-chars
  "Sets localized date-time pattern characters. For example: 'u', 't', etc.

  new-local-pattern-chars - the new localized date-time pattern characters. - `java.lang.String`"
  ([^java.text.DateFormatSymbols this ^java.lang.String new-local-pattern-chars]
    (-> this (.setLocalPatternChars new-local-pattern-chars))))

(defn get-zone-strings
  "Gets time zone strings.  Use of this method is discouraged; use
   TimeZone.getDisplayName()
   instead.

   The value returned is a
   two-dimensional array of strings of size n by m,
   where m is at least 5.  Each of the n rows is an
   entry containing the localized names for a single TimeZone.
   Each such row contains (with i ranging from
   0..n-1):

   zoneStrings[i][0] - time zone ID
   zoneStrings[i][1] - long name of zone in standard
   time
   zoneStrings[i][2] - short name of zone in
   standard time
   zoneStrings[i][3] - long name of zone in daylight
   saving time
   zoneStrings[i][4] - short name of zone in daylight
   saving time

   The zone ID is not localized; it's one of the valid IDs of
   the TimeZone class that are not
   custom IDs.
   All other entries are localized names.  If a zone does not implement
   daylight saving time, the daylight saving time names should not be used.

   If setZoneStrings has been called
   on this DateFormatSymbols instance, then the strings
   provided by that call are returned. Otherwise, the returned array
   contains names provided by the Java runtime and by installed
   TimeZoneNameProvider
   implementations.

  returns: the time zone strings. - `java.lang.String[][]`"
  ([^java.text.DateFormatSymbols this]
    (-> this (.getZoneStrings))))

(defn equals
  "Override equals

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.text.DateFormatSymbols this ^java.lang.Object obj]
    (-> this (.equals obj))))

