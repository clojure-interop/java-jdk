(ns jdk.time.ZoneId
  "A time-zone ID, such as Europe/Paris.

  A ZoneId is used to identify the rules used to convert between
  an Instant and a LocalDateTime.
  There are two distinct types of ID:

  Fixed offsets - a fully resolved offset from UTC/Greenwich, that uses
   the same offset for all local date-times
  Geographical regions - an area where a specific set of rules for finding
   the offset from UTC/Greenwich apply

  Most fixed offsets are represented by ZoneOffset.
  Calling normalized() on any ZoneId will ensure that a
  fixed offset ID will be represented as a ZoneOffset.

  The actual rules, describing when and how the offset changes, are defined by ZoneRules.
  This class is simply an ID used to obtain the underlying rules.
  This approach is taken because rules are defined by governments and change
  frequently, whereas the ID is stable.

  The distinction has other effects. Serializing the ZoneId will only send
  the ID, whereas serializing the rules sends the entire data set.
  Similarly, a comparison of two IDs only examines the ID, whereas
  a comparison of two rules examines the entire data set.

  Time-zone IDs
  The ID is unique within the system.
  There are three types of ID.

  The simplest type of ID is that from ZoneOffset.
  This consists of 'Z' and IDs starting with '+' or '-'.

  The next type of ID are offset-style IDs with some form of prefix,
  such as 'GMT+2' or 'UTC+01:00'.
  The recognised prefixes are 'UTC', 'GMT' and 'UT'.
  The offset is the suffix and will be normalized during creation.
  These IDs can be normalized to a ZoneOffset using normalized().

  The third type of ID are region-based IDs. A region-based ID must be of
  two or more characters, and not start with 'UTC', 'GMT', 'UT' '+' or '-'.
  Region-based IDs are defined by configuration, see ZoneRulesProvider.
  The configuration focuses on providing the lookup from the ID to the
  underlying ZoneRules.

  Time-zone rules are defined by governments and change frequently.
  There are a number of organizations, known here as groups, that monitor
  time-zone changes and collate them.
  The default group is the IANA Time Zone Database (TZDB).
  Other organizations include IATA (the airline industry body) and Microsoft.

  Each group defines its own format for the region ID it provides.
  The TZDB group defines IDs such as 'Europe/London' or 'America/New_York'.
  TZDB IDs take precedence over other groups.

  It is strongly recommended that the group name is included in all IDs supplied by
  groups other than TZDB to avoid conflicts. For example, IATA airline time-zone
  region IDs are typically the same as the three letter airport code.
  However, the airport of Utrecht has the code 'UTC', which is obviously a conflict.
  The recommended format for region IDs from groups other than TZDB is 'group~region'.
  Thus if IATA data were defined, Utrecht airport would be 'IATA~UTC'.

  Serialization
  This class can be serialized and stores the string zone ID in the external form.
  The ZoneOffset subclass uses a dedicated format that only stores the
  offset from UTC/Greenwich.

  A ZoneId can be deserialized in a Java Runtime where the ID is unknown.
  For example, if a server-side Java Runtime has been updated with a new zone ID, but
  the client-side Java Runtime has not been updated. In this case, the ZoneId
  object will exist, and can be queried using getId, equals,
  hashCode, toString, getDisplayName and normalized.
  However, any call to getRules will fail with ZoneRulesException.
  This approach is designed to allow a ZonedDateTime to be loaded and
  queried, but not modified, on a Java Runtime with incomplete time-zone information.


  This is a value-based
  class; use of identity-sensitive operations (including reference equality
  (==), identity hash code, or synchronization) on instances of
  ZoneId may have unpredictable results and should be avoided.
  The equals method should be used for comparisons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.time ZoneId]))

(def *-short-ids
  "Static Constant.

  A map of zone overrides to enable the short time-zone names to be used.

   Use of short zone IDs has been deprecated in java.util.TimeZone.
   This map allows the IDs to continue to be used via the
   of(String, Map) factory method.

   This map contains a mapping of the IDs that is in line with TZDB 2005r and
   later, where 'EST', 'MST' and 'HST' map to IDs which do not include daylight
   savings.

   This maps as follows:

   EST - -05:00
   HST - -10:00
   MST - -07:00
   ACT - Australia/Darwin
   AET - Australia/Sydney
   AGT - America/Argentina/Buenos_Aires
   ART - Africa/Cairo
   AST - America/Anchorage
   BET - America/Sao_Paulo
   BST - Asia/Dhaka
   CAT - Africa/Harare
   CNT - America/St_Johns
   CST - America/Chicago
   CTT - Asia/Shanghai
   EAT - Africa/Addis_Ababa
   ECT - Europe/Paris
   IET - America/Indiana/Indianapolis
   IST - Asia/Kolkata
   JST - Asia/Tokyo
   MIT - Pacific/Apia
   NET - Asia/Yerevan
   NST - Pacific/Auckland
   PLT - Asia/Karachi
   PNT - America/Phoenix
   PRT - America/Puerto_Rico
   PST - America/Los_Angeles
   SST - Pacific/Guadalcanal
   VST - Asia/Ho_Chi_Minh

   The map is unmodifiable.

  type: java.util.Map<java.lang.String,java.lang.String>"
  ZoneId/SHORT_IDS)

(defn *system-default
  "Gets the system default time-zone.

   This queries TimeZone.getDefault() to find the default time-zone
   and converts it to a ZoneId. If the system default time-zone is changed,
   then the result of this method will also change.

  returns: the zone ID, not null - `java.time.ZoneId`

  throws: java.time.DateTimeException - if the converted zone ID has an invalid format"
  (^java.time.ZoneId []
    (ZoneId/systemDefault )))

(defn *get-available-zone-ids
  "Gets the set of available zone IDs.

   This set includes the string form of all available region-based IDs.
   Offset-based zone IDs are not included in the returned set.
   The ID can be passed to of(String) to create a ZoneId.

   The set of zone IDs can increase over time, although in a typical application
   the set of IDs is fixed. Each call to this method is thread-safe.

  returns: a modifiable copy of the set of zone IDs, not null - `java.util.Set<java.lang.String>`"
  (^java.util.Set []
    (ZoneId/getAvailableZoneIds )))

(defn *of
  "Obtains an instance of ZoneId using its ID using a map
   of aliases to supplement the standard zone IDs.

   Many users of time-zones use short abbreviations, such as PST for
   'Pacific Standard Time' and PDT for 'Pacific Daylight Time'.
   These abbreviations are not unique, and so cannot be used as IDs.
   This method allows a map of string to time-zone to be setup and reused
   within an application.

  zone-id - the time-zone ID, not null - `java.lang.String`
  alias-map - a map of alias zone IDs (typically abbreviations) to real zone IDs, not null - `java.util.Map`

  returns: the zone ID, not null - `java.time.ZoneId`

  throws: java.time.DateTimeException - if the zone ID has an invalid format"
  (^java.time.ZoneId [^java.lang.String zone-id ^java.util.Map alias-map]
    (ZoneId/of zone-id alias-map))
  (^java.time.ZoneId [^java.lang.String zone-id]
    (ZoneId/of zone-id)))

(defn *of-offset
  "Obtains an instance of ZoneId wrapping an offset.

   If the prefix is \"GMT\", \"UTC\", or \"UT\" a ZoneId
   with the prefix and the non-zero offset is returned.
   If the prefix is empty \"\" the ZoneOffset is returned.

  prefix - the time-zone ID, not null - `java.lang.String`
  offset - the offset, not null - `java.time.ZoneOffset`

  returns: the zone ID, not null - `java.time.ZoneId`

  throws: java.lang.IllegalArgumentException - if the prefix is not one of \"GMT\", \"UTC\", or \"UT\", or \"\""
  (^java.time.ZoneId [^java.lang.String prefix ^java.time.ZoneOffset offset]
    (ZoneId/ofOffset prefix offset)))

(defn *from
  "Obtains an instance of ZoneId from a temporal object.

   This obtains a zone based on the specified temporal.
   A TemporalAccessor represents an arbitrary set of date and time information,
   which this factory converts to an instance of ZoneId.

   A TemporalAccessor represents some form of date and time information.
   This factory converts the arbitrary temporal object to an instance of ZoneId.

   The conversion will try to obtain the zone in a way that favours region-based
   zones over offset-based zones using TemporalQueries.zone().

   This method matches the signature of the functional interface TemporalQuery
   allowing it to be used as a query via method reference, ZoneId::from.

  temporal - the temporal object to convert, not null - `java.time.temporal.TemporalAccessor`

  returns: the zone ID, not null - `java.time.ZoneId`

  throws: java.time.DateTimeException - if unable to convert to a ZoneId"
  (^java.time.ZoneId [^java.time.temporal.TemporalAccessor temporal]
    (ZoneId/from temporal)))

(defn get-id
  "Gets the unique time-zone ID.

   This ID uniquely defines this object.
   The format of an offset based ID is defined by ZoneOffset.getId().

  returns: the time-zone unique ID, not null - `java.lang.String`"
  (^java.lang.String [^ZoneId this]
    (-> this (.getId))))

(defn get-display-name
  "Gets the textual representation of the zone, such as 'British Time' or
   '+02:00'.

   This returns the textual name used to identify the time-zone ID,
   suitable for presentation to the user.
   The parameters control the style of the returned text and the locale.

   If no textual mapping is found then the full ID is returned.

  style - the length of the text required, not null - `java.time.format.TextStyle`
  locale - the locale to use, not null - `java.util.Locale`

  returns: the text value of the zone, not null - `java.lang.String`"
  (^java.lang.String [^ZoneId this ^java.time.format.TextStyle style ^java.util.Locale locale]
    (-> this (.getDisplayName style locale))))

(defn get-rules
  "Gets the time-zone rules for this ID allowing calculations to be performed.

   The rules provide the functionality associated with a time-zone,
   such as finding the offset for a given instant or local date-time.

   A time-zone can be invalid if it is deserialized in a Java Runtime which
   does not have the same rules loaded as the Java Runtime that stored it.
   In this case, calling this method will throw a ZoneRulesException.

   The rules are supplied by ZoneRulesProvider. An advanced provider may
   support dynamic updates to the rules without restarting the Java Runtime.
   If so, then the result of this method may change over time.
   Each individual call will be still remain thread-safe.

   ZoneOffset will always return a set of rules where the offset never changes.

  returns: the rules, not null - `java.time.zone.ZoneRules`

  throws: java.time.zone.ZoneRulesException - if no rules are available for this ID"
  (^java.time.zone.ZoneRules [^ZoneId this]
    (-> this (.getRules))))

(defn normalized
  "Normalizes the time-zone ID, returning a ZoneOffset where possible.

   The returns a normalized ZoneId that can be used in place of this ID.
   The result will have ZoneRules equivalent to those returned by this object,
   however the ID returned by getId() may be different.

   The normalization checks if the rules of this ZoneId have a fixed offset.
   If they do, then the ZoneOffset equal to that offset is returned.
   Otherwise this is returned.

  returns: the time-zone unique ID, not null - `java.time.ZoneId`"
  (^java.time.ZoneId [^ZoneId this]
    (-> this (.normalized))))

(defn equals
  "Checks if this time-zone ID is equal to another time-zone ID.

   The comparison is based on the ID.

  obj - the object to check, null returns false - `java.lang.Object`

  returns: true if this is equal to the other time-zone ID - `boolean`"
  (^Boolean [^ZoneId this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "A hash code for this time-zone ID.

  returns: a suitable hash code - `int`"
  (^Integer [^ZoneId this]
    (-> this (.hashCode))))

(defn to-string
  "Outputs this zone as a String, using the ID.

  returns: a string representation of this time-zone ID, not null - `java.lang.String`"
  (^java.lang.String [^ZoneId this]
    (-> this (.toString))))

