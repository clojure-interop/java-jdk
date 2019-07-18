(ns jdk.text.spi.DateFormatSymbolsProvider
  "An abstract class for service providers that
  provide instances of the
  DateFormatSymbols class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text.spi DateFormatSymbolsProvider]))

(defn get-instance
  "Returns a new DateFormatSymbols instance for the
   specified locale.

  locale - the desired locale - `java.util.Locale`

  returns: a DateFormatSymbols instance. - `java.text.DateFormatSymbols`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.DateFormatSymbols [^DateFormatSymbolsProvider this ^java.util.Locale locale]
    (-> this (.getInstance locale))))

