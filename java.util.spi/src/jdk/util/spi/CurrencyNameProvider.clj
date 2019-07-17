(ns jdk.util.spi.CurrencyNameProvider
  "An abstract class for service providers that
  provide localized currency symbols and display names for the
  Currency class.
  Note that currency symbols are considered names when determining
  behaviors described in the
  LocaleServiceProvider
  specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.spi CurrencyNameProvider]))

(defn get-symbol
  "Gets the symbol of the given currency code for the specified locale.
   For example, for `USD` (US Dollar), the symbol is `$` if the specified
   locale is the US, while for other locales it may be `US$`. If no
   symbol can be determined, null should be returned.

  currency-code - the ISO 4217 currency code, which consists of three upper-case letters between 'A' (U+0041) and 'Z' (U+005A) - `java.lang.String`
  locale - the desired locale - `java.util.Locale`

  returns: the symbol of the given currency code for the specified locale, or null if
       the symbol is not available for the locale - `java.lang.String`

  throws: java.lang.NullPointerException - if currencyCode or locale is null"
  (^java.lang.String [^java.util.spi.CurrencyNameProvider this ^java.lang.String currency-code ^java.util.Locale locale]
    (-> this (.getSymbol currency-code locale))))

(defn get-display-name
  "Returns a name for the currency that is appropriate for display to the
   user.  The default implementation returns null.

  currency-code - the ISO 4217 currency code, which consists of three upper-case letters between 'A' (U+0041) and 'Z' (U+005A) - `java.lang.String`
  locale - the desired locale - `java.util.Locale`

  returns: the name for the currency that is appropriate for display to the
       user, or null if the name is not available for the locale - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if currencyCode is not in the form of three upper-case letters, or locale isn't one of the locales returned from getAvailableLocales()."
  (^java.lang.String [^java.util.spi.CurrencyNameProvider this ^java.lang.String currency-code ^java.util.Locale locale]
    (-> this (.getDisplayName currency-code locale))))

