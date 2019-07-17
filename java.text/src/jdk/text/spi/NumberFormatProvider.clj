(ns jdk.text.spi.NumberFormatProvider
  "An abstract class for service providers that
  provide concrete implementations of the
  NumberFormat class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text.spi NumberFormatProvider]))

(defn get-currency-instance
  "Returns a new NumberFormat instance which formats
   monetary values for the specified locale.

  locale - the desired locale. - `java.util.Locale`

  returns: a currency formatter - `java.text.NumberFormat`

  throws: java.lang.NullPointerException - if locale is null"
  ([this locale]
    (-> this (.getCurrencyInstance locale))))

(defn get-integer-instance
  "Returns a new NumberFormat instance which formats
   integer values for the specified locale.
   The returned number format is configured to
   round floating point numbers to the nearest integer using
   half-even rounding (see HALF_EVEN)
   for formatting, and to parse only the integer part of
   an input string (see isParseIntegerOnly).

  locale - the desired locale - `java.util.Locale`

  returns: a number format for integer values - `java.text.NumberFormat`

  throws: java.lang.NullPointerException - if locale is null"
  ([this locale]
    (-> this (.getIntegerInstance locale))))

(defn get-number-instance
  "Returns a new general-purpose NumberFormat instance for
   the specified locale.

  locale - the desired locale - `java.util.Locale`

  returns: a general-purpose number formatter - `java.text.NumberFormat`

  throws: java.lang.NullPointerException - if locale is null"
  ([this locale]
    (-> this (.getNumberInstance locale))))

(defn get-percent-instance
  "Returns a new NumberFormat instance which formats
   percentage values for the specified locale.

  locale - the desired locale - `java.util.Locale`

  returns: a percent formatter - `java.text.NumberFormat`

  throws: java.lang.NullPointerException - if locale is null"
  ([this locale]
    (-> this (.getPercentInstance locale))))

