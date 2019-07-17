(ns jdk.util.spi.LocaleNameProvider
  "An abstract class for service providers that
  provide localized names for the
  Locale class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.spi LocaleNameProvider]))

(defn get-display-language
  "Returns a localized name for the given
   IETF BCP47 language code and the given locale that is appropriate for
   display to the user.
   For example, if languageCode is `fr` and locale
   is en_US, getDisplayLanguage() will return `French`; if languageCode
   is `en` and locale is fr_FR, getDisplayLanguage() will return `anglais`.
   If the name returned cannot be localized according to locale,
   (say, the provider does not have a Japanese name for Croatian),
   this method returns null.

  language-code - the language code string in the form of two to eight lower-case letters between 'a' (U+0061) and 'z' (U+007A) - `java.lang.String`
  locale - the desired locale - `java.util.Locale`

  returns: the name of the given language code for the specified locale, or null if it's not
       available. - `java.lang.String`

  throws: java.lang.NullPointerException - if languageCode or locale is null"
  ([this language-code locale]
    (-> this (.getDisplayLanguage language-code locale))))

(defn get-display-script
  "Returns a localized name for the given
   IETF BCP47 script code and the given locale that is appropriate for
   display to the user.
   For example, if scriptCode is `Latn` and locale
   is en_US, getDisplayScript() will return `Latin`; if scriptCode
   is `Cyrl` and locale is fr_FR, getDisplayScript() will return `cyrillique`.
   If the name returned cannot be localized according to locale,
   (say, the provider does not have a Japanese name for Cyrillic),
   this method returns null. The default implementation returns null.

  script-code - the four letter script code string in the form of title-case letters (the first letter is upper-case character between 'A' (U+0041) and 'Z' (U+005A) followed by three lower-case character between 'a' (U+0061) and 'z' (U+007A)). - `java.lang.String`
  locale - the desired locale - `java.util.Locale`

  returns: the name of the given script code for the specified locale, or null if it's not
       available. - `java.lang.String`

  throws: java.lang.NullPointerException - if scriptCode or locale is null"
  ([this script-code locale]
    (-> this (.getDisplayScript script-code locale))))

(defn get-display-country
  "Returns a localized name for the given
   IETF BCP47 region code (either ISO 3166 country code or UN M.49 area
   codes) and the given locale that is appropriate for display to the user.
   For example, if countryCode is `FR` and locale
   is en_US, getDisplayCountry() will return `France`; if countryCode
   is `US` and locale is fr_FR, getDisplayCountry() will return `Etats-Unis`.
   If the name returned cannot be localized according to locale,
   (say, the provider does not have a Japanese name for Croatia),
   this method returns null.

  country-code - the country(region) code string in the form of two upper-case letters between 'A' (U+0041) and 'Z' (U+005A) or the UN M.49 area code in the form of three digit letters between '0' (U+0030) and '9' (U+0039). - `java.lang.String`
  locale - the desired locale - `java.util.Locale`

  returns: the name of the given country code for the specified locale, or null if it's not
       available. - `java.lang.String`

  throws: java.lang.NullPointerException - if countryCode or locale is null"
  ([this country-code locale]
    (-> this (.getDisplayCountry country-code locale))))

(defn get-display-variant
  "Returns a localized name for the given variant code and the given locale that
   is appropriate for display to the user.
   If the name returned cannot be localized according to locale,
   this method returns null.

  variant - the variant string - `java.lang.String`
  locale - the desired locale - `java.util.Locale`

  returns: the name of the given variant string for the specified locale, or null if it's not
       available. - `java.lang.String`

  throws: java.lang.NullPointerException - if variant or locale is null"
  ([this variant locale]
    (-> this (.getDisplayVariant variant locale))))

