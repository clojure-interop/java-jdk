(ns jdk.util.spi.TimeZoneNameProvider
  "An abstract class for service providers that
  provide localized time zone names for the
  TimeZone class.
  The localized time zone names available from the implementations of
  this class are also the source for the
  DateFormatSymbols.getZoneStrings() method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util.spi TimeZoneNameProvider]))

(defn get-display-name
  "Returns a name for the given time zone ID that's suitable for
   presentation to the user in the specified locale. The given time
   zone ID is `GMT` or one of the names defined using `Zone` entries
   in the `tz database`, a public domain time zone database at
   ftp://elsie.nci.nih.gov/pub/.
   The data of this database is contained in a file whose name starts with
   `tzdata`, and the specification of the data format is part of the zic.8
   man page, which is contained in a file whose name starts with `tzcode`.

   If daylight is true, the method should return a name
   appropriate for daylight saving time even if the specified time zone
   has not observed daylight saving time in the past.

  id - a time zone ID string - `java.lang.String`
  daylight - if true, return the daylight saving name. - `boolean`
  style - either TimeZone.LONG or TimeZone.SHORT - `int`
  locale - the desired locale - `java.util.Locale`

  returns: the human-readable name of the given time zone in the
       given locale, or null if it's not available. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if style is invalid, or locale isn't one of the locales returned from getAvailableLocales()."
  (^java.lang.String [^java.util.spi.TimeZoneNameProvider this ^java.lang.String id ^Boolean daylight ^Integer style ^java.util.Locale locale]
    (-> this (.getDisplayName id daylight style locale))))

(defn get-generic-display-name
  "Returns a generic name for the given time zone ID that's suitable
   for presentation to the user in the specified locale. Generic
   time zone names are neutral from standard time and daylight saving
   time. For example, `PT` is the short generic name of time zone ID America/Los_Angeles, while its short standard time and daylight saving
   time names are `PST` and `PDT`, respectively. Refer to
   getDisplayName
   for valid time zone IDs.

   The default implementation of this method returns null.

  id - a time zone ID string - `java.lang.String`
  style - either TimeZone.LONG or TimeZone.SHORT - `int`
  locale - the desired locale - `java.util.Locale`

  returns: the human-readable generic name of the given time zone in the
       given locale, or null if it's not available. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if style is invalid, or locale isn't one of the locales returned from getAvailableLocales()."
  (^java.lang.String [^java.util.spi.TimeZoneNameProvider this ^java.lang.String id ^Integer style ^java.util.Locale locale]
    (-> this (.getGenericDisplayName id style locale))))

