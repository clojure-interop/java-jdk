(ns jdk.text.spi.DecimalFormatSymbolsProvider
  "An abstract class for service providers that
  provide instances of the
  DecimalFormatSymbols class.

  The requested Locale may contain an  extension for
  specifying the desired numbering system. For example, \"ar-u-nu-arab\"
  (in the BCP 47 language tag form) specifies Arabic with the Arabic-Indic
  digits and symbols, while \"ar-u-nu-latn\" specifies Arabic with the
  Latin digits and symbols. Refer to the Unicode Locale Data Markup
  Language (LDML) specification for numbering systems."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text.spi DecimalFormatSymbolsProvider]))

(defn get-instance
  "Returns a new DecimalFormatSymbols instance for the
   specified locale.

  locale - the desired locale - `java.util.Locale`

  returns: a DecimalFormatSymbols instance. - `java.text.DecimalFormatSymbols`

  throws: java.lang.NullPointerException - if locale is null"
  (^java.text.DecimalFormatSymbols [^DecimalFormatSymbolsProvider this ^java.util.Locale locale]
    (-> this (.getInstance locale))))

