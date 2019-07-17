(ns jdk.util.spi.CalendarDataProvider
  "An abstract class for service providers that provide locale-dependent Calendar parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.spi CalendarDataProvider]))

(defn get-first-day-of-week
  "Returns the first day of a week in the given locale. This
   information is required by Calendar to support operations on the
   week-related calendar fields.

  locale - the desired locale - `java.util.Locale`

  returns: the first day of a week; one of Calendar.SUNDAY ..
           Calendar.SATURDAY,
           or 0 if the value isn't available for the locale - `int`

  throws: java.lang.NullPointerException - if locale is null."
  (^Integer [^java.util.spi.CalendarDataProvider this ^java.util.Locale locale]
    (-> this (.getFirstDayOfWeek locale))))

(defn get-minimal-days-in-first-week
  "Returns the minimal number of days required in the first week of a
   year. This information is required by Calendar to determine the
   first week of a year. Refer to the description of  how Calendar determines
   the first week.

  locale - the desired locale - `java.util.Locale`

  returns: the minimal number of days of the first week,
           or 0 if the value isn't available for the locale - `int`

  throws: java.lang.NullPointerException - if locale is null."
  (^Integer [^java.util.spi.CalendarDataProvider this ^java.util.Locale locale]
    (-> this (.getMinimalDaysInFirstWeek locale))))

