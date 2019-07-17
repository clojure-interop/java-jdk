(ns jdk.text.spi.DateFormatProvider
  "An abstract class for service providers that
  provide concrete implementations of the
  DateFormat class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text.spi DateFormatProvider]))

(defn get-time-instance
  "Returns a new DateFormat instance which formats time
   with the given formatting style for the specified locale.

  style - the given formatting style. Either one of DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, or DateFormat.FULL. - `int`
  locale - the desired locale. - `java.util.Locale`

  returns: a time formatter. - `java.text.DateFormat`

  throws: java.lang.IllegalArgumentException - if style is invalid, or if locale isn't one of the locales returned from getAvailableLocales()."
  ([^java.text.spi.DateFormatProvider this ^Integer style ^java.util.Locale locale]
    (-> this (.getTimeInstance style locale))))

(defn get-date-instance
  "Returns a new DateFormat instance which formats date
   with the given formatting style for the specified locale.

  style - the given formatting style. Either one of DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, or DateFormat.FULL. - `int`
  locale - the desired locale. - `java.util.Locale`

  returns: a date formatter. - `java.text.DateFormat`

  throws: java.lang.IllegalArgumentException - if style is invalid, or if locale isn't one of the locales returned from getAvailableLocales()."
  ([^java.text.spi.DateFormatProvider this ^Integer style ^java.util.Locale locale]
    (-> this (.getDateInstance style locale))))

(defn get-date-time-instance
  "Returns a new DateFormat instance which formats date and time
   with the given formatting style for the specified locale.

  date-style - the given date formatting style. Either one of DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, or DateFormat.FULL. - `int`
  time-style - the given time formatting style. Either one of DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, or DateFormat.FULL. - `int`
  locale - the desired locale. - `java.util.Locale`

  returns: a date/time formatter. - `java.text.DateFormat`

  throws: java.lang.IllegalArgumentException - if dateStyle or timeStyle is invalid, or if locale isn't one of the locales returned from getAvailableLocales()."
  ([^java.text.spi.DateFormatProvider this ^Integer date-style ^Integer time-style ^java.util.Locale locale]
    (-> this (.getDateTimeInstance date-style time-style locale))))

